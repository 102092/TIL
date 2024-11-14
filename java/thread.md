스레드 상태
- Blocked
	- 차단 상태
	- 스레드가 다른 스레드에 의해 동기화락을 얻기 위해 기다리는 상태
- Waiting
	- 대기 상태
	- 스레드가 다른 스레드의 특정 작업이 완료되기를 무기한 기다리는 상태
	- `wait()`, `join()` 메서드 호출 시.
- Timed Waiting
	- 스레드가 특정 시간 동안 다른 스레드의 작업이 완료되기를 기다리는 상태
	- `sleep(long millis)`, `wait(long timeout)`

## 참고
- https://www.inflearn.com/course/lecture?courseSlug=%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B3%A0%EA%B8%89-1&unitId=232329
- https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html