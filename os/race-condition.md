- race?
	- 경쟁.
- race condition?
	- 경쟁 상태

> a race condition is a condition of a program where its behavior depends on relative timing or interleaving of multiple threads or processes

- 어떤 프로그램의 동작이, 여러 스레드나 프로세스의 상호 배치적이 거나 상대적인 타이밍 때문에 달라지는 걸 의미.
- 즉 결과가 예측한대로 나오지 않음 (버그임)
- [[thread-safe]] 하다는 말은 [[race-condition]] 의 상태에서 자유롭다는 의미로 봐도 되는듯.

## Elimination

- 2가지 방법으로 race condition을 방지할 수 있음.
	1. [[avoiding-shared-state]]
	2. Using Synchronizations and Atomic Operations
  
## Conclusion

- 전반적으로 2개의 타입 모두 공유 자원에 대해 배제가 필요한 부분이라 생각됨.
- 읽기를 할 때는 이러한 배제를 하지 않아도 되지만, 쓰기를 할 때는 다른 스레드에서 침범하지 못하도록 배제 시키는게 필요할 지도.

## 참고

- <https://www.baeldung.com/cs/race-conditions>
- <https://iredays.tistory.com/125>
