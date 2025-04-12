# Redisson DNS Resolution 문제 분석 및 해결

## 1. 문제상황
### 1.1 발생 증상
- 간헐적으로 에러 발생
- 에러 해석
	- redis-host에 대해 DNS로 찾지 못함.
	- Timeout 발생 DNS서버가 5초 내로 응답하지 못함

### 1.2 환경 정보
- `java 17`
- `org.redisson:redisson-spring-boot-starter:3.18.0`
	- `io.netty:4.1.79 (Final)`
- `org.springframework.boot:2.7.3`

### 1.3 에러 로그
```java
...
Unable to resolve redis-m.xxxxxx.xxx.xx.xxxx.xx
io.netty.resolver.dns.DnsResolveContext$SearchDomainUnknownHostException: Failed to resolve 'redis-m.xxxxxx.xxx.xx.xxxx.xx' and search domain query for configured domains failed as well: [xxx-xxxxxxx, xxxxxxxxx]  
    at io.netty.resolver.dns.DnsResolveContext.finishResolve(DnsResolveContext.java:1047)  
    at io.netty.resolver.dns.DnsResolveContext.tryToFinishResolve(DnsResolveContext.java:1000)  
    at io.netty.resolver.dns.DnsResolveContext.query(DnsResolveContext.java:418)  
    at io.netty.resolver.dns.DnsResolveContext.access$600(DnsResolveContext.java:66)  
    at io.netty.resolver.dns.DnsResolveContext$2.operationComplete(DnsResolveContext.java:467)  
    at io.netty.util.concurrent.DefaultPromise.notifyListener0(DefaultPromise.java:578)  
    at io.netty.util.concurrent.DefaultPromise.notifyListeners0(DefaultPromise.java:571)  
    at io.netty.util.concurrent.DefaultPromise.notifyListenersNow(DefaultPromise.java:550)  
    at io.netty.util.concurrent.DefaultPromise.notifyListeners(DefaultPromise.java:491)  
    at io.netty.util.concurrent.DefaultPromise.setValue0(DefaultPromise.java:616)  
    at io.netty.util.concurrent.DefaultPromise.setFailure0(DefaultPromise.java:609)  
    at io.netty.util.concurrent.DefaultPromise.tryFailure(DefaultPromise.java:117)  
    at io.netty.resolver.dns.DnsQueryContext.tryFailure(DnsQueryContext.java:256)  
    at io.netty.resolver.dns.DnsQueryContext$4.run(DnsQueryContext.java:208)  
    at io.netty.util.concurrent.PromiseTask.runTask(PromiseTask.java:98)  
    at io.netty.util.concurrent.ScheduledFutureTask.run(ScheduledFutureTask.java:153)  
    at io.netty.util.concurrent.AbstractEventExecutor.runTask(AbstractEventExecutor.java:174)  
    at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:167)  
    at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:470)  
    at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:503)  
    at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:997)  
    at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)  
    at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)  
    at java.base/java.lang.Thread.run(Unknown Source)  
Caused by: io.netty.resolver.dns.DnsNameResolverTimeoutException: [/xx.xxx.x.xx:53] query via UDP timed out after 5000 milliseconds (no stack trace available)
...
```

## 2. DNS 관련 주요 개념
### 2.1 DNS 응답 유형

- Authoritative: 해당 도메인의 공식 DNS 정보를 보유. 응답이 최종적이고 신뢰할 수 있음
- Non-Authoritative: 캐시된 정보만 보유. 다른 서버에 추가 확인이 필요할 수 있음
- NXDOMAIN (Non-Existent Domain): 도메인이 존재하지 않음을 나타내는 DNS 응답


## 3. 원인 분석

### 3.1 DnsAddressResolverGroup 조회 방식 이슈
- redisson(netty) -> DNS
- 기존 DnsAddressResolverGroupFactory 을 통해 생성된 DnsAddressResolverGroup는 여러 DNS에 동시에 쿼리
   - 쿼리 중 하나만 실패해도 조회실패
- 반면 SequentialDnsAddressResolverFactory 을 통해 생성된 DnsAddressResolver의 경우
	- DNS 요청에 대한 [동시성](https://github.com/redisson/redisson/commit/2d83ebdf64bde8793b8c3b24be81ad23e72119d5#diff-4e3a2d9eefdda899572ed33b8bdc08b590414b60ad203b3ad8b1d439d7f6ed42R69)을 제어했음.
	- DNS 요청에 대한 부하를 줄여서 문제가 없는걸까? (좀 더 확인해봐야할 부분)
	

## 4. 해결방안
### 4.1 Redisson 버전 업그레이드
- [redisson commit](https://github.com/redisson/redisson/commit/2d83ebdf64bde8793b8c3b24be81ad23e72119d5)
	- DnsAddressResolverGroupFactory 대신 SequentialDnsAddressResolverFactory 사용하도록 변경
	- 즉 DNS 조회에 대한 동시성을 제어함.
- 3.38.1 버전으로 redisson version upgrade함.


 #### 4.2 의존성 설정

```gradle
// AS-IS
implementation("org.redisson:redisson-spring-boot-starter:3.18.0")

// TO-BE
implementation("org.redisson:redisson-spring-boot-starter:3.38.1") {
	exclude(group = "org.redisson", module = "redisson-spring-data-33")
}
implementation("org.redisson:redisson-spring-data-27:3.38.1")

```
- SpringBoot 2.7 대는 위와와 같이 변경을 권장함.
	- 버전을 올리고, 
	- `spring-data-33` 제외
	- `spring-data-27` 추가
	- https://redisson.org/docs/integration-with-spring/#spring-boot-starter

## 참고
- https://github.com/redisson/redisson/issues/1625
- https://github.com/redisson/redisson/issues/1944
- https://github.com/netty/netty/issues/8261#issuecomment-427350547
- https://github.com/redisson/redisson/commit/2d83ebdf64bde8793b8c3b24be81ad23e72119d5
- https://zorba91.tistory.com/353
- https://blog.naver.com/dong6245/140050637164
- [netty issue](https://github.com/netty/netty/issues/8261)
- [netty pull request](https://github.com/netty/netty/pull/8731)
