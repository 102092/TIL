# 레디스를 이용해서 동시 요청 방지하기
---
## 개요
- 짧은 시간 내에 발생하는 동일 요청을 효과적으로 처리하기 위해,
- Redis의 원자적 연산을 활용하는 방법을 설명

## 환경 설정 
- Java, Spring Framework
- spring-data-redis 
- lettuce 드라이버 
- Redis 서버 연결 설정이 완료되어 있어야 함

## 요구사항
- 1초 미만으로 다수의 동일 요청이 발생하는 환경.
- 처음 들어온 요청만 처리하고 나머지는 중복 요청으로 처리해야 함.

## 해결 방안

### Redis INCRBY 명령어 활용
- Redis의 INCRBY는 원자적(atomic) 증가 연산을 수행하는 명령어로, 동시성 제어에 적합
- [INCRBY](https://redis.io/docs/latest/commands/incrby/)
	- 키가 존재하지 않을 경우 자동으로 0에서 시작하여 증가 
	- 분산 환경에서도 race condition 없이 원자적 연산 보장
	- 일정 시간 후 자동 만료(expire) 설정 가능

### 작동원리
1. 요청 식별자(key)로 Redis에 카운터 증가 요청
2. 카운터 값이 1이면 최초 요청, 그 이상이면 중복 요청으로 판단 
3. 최초 요청의 경우 만료 시간을 설정하여 일정 시간 후 카운터가 자동 삭제되도록 함 
4. 설정된 만료 시간 내에 동일 키로 요청이 오면 중복으로 처리
### 예시

```java
@Component
@RequiredArgsConstructor
public class RedisRepository {

	private final RedisTemplate<String, String> redisTemplate;

	public boolean isDuplciated(final String key) {
		var ops = redisTemplate.boundValueOps(key);	
		var result = ops.increment(1L);
		// result can be null
		if (result == null || result == 1L) {
			// this ops wil expire in 1 seconds
			ops.expire(1, TimeUnit.SECONS)
			return false;
		}
		
		return true;
	}
}

```
- 맨 처음 요청이 왔을 경우 나올 수 있는 결과는 `null` or `1L` 
	- 이럴 경우, 해당 데이터에 대한 만료를 설정하고, `false` 리턴
	- 즉 중복된 요청이 아님. 
- 그 외 `true` 리턴
	- 같은 `key` 1초 내 요청에 대해서는, `2L, 3L, 4L..` 와 같은 `result` 가 반환됨
- `ops.expire(1, TimeUnit.SECONS)` 설정을 통해서, 무분별하게 쌓일 수 있는 점을 방지

## 참고
---
- [Redis 공식 문서 - INCRBY](https://redis.io/commands/incrby/)
- [Redis 공식 문서 - EXPIRE](https://redis.io/commands/expire/)
- [Spring Data Redis 문서](https://docs.spring.io/spring-data/redis/docs/current/reference/html/)
- [Redisson을 이용한 분산 락 구현](https://github.com/redisson/redisson/wiki/8.-distributed-locks-and-synchronizers)
- [Baeldung - Redis를 이용한 분산 락](https://www.baeldung.com/redis-redisson)
- [Martin Fowler - Idempotency Patterns](https://www.martinfowler.com/articles/patterns-of-distributed-systems/idempotent-receiver.html)