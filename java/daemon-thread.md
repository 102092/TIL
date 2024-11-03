- 백그라운드에서 보조적인 작업을 수행
- 모든 [user-thread] 가 종료되면 [[daemon-thread]] 도 종료됨
- JVM은 데몬 스레드의 실행완료를 기대리지 않고 종료됨

```java
DaemonThread daemonThread = new Thread()
daemonThread.setDaemon(true) // 데몬 스레드 설정
```
- 기본적으로 `thread` 는 daemon thread  = false 임

## 참고
- https://www.inflearn.com/course/lecture?courseSlug=%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B3%A0%EA%B8%89-1&unitId=232319&tab=curriculum&subtitleLanguage=ko