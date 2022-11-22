# Race conditoin

## About

- race?
  - 경쟁.
- race condition?
  - 경쟁 상태

> a race condition is a condition of a program where its behavior depends on relative timing or interleaving of multiple threads or processes

- 어떤 프로그램의 동작이, 여러 스레드나 프로세스의 상호 배치적이 거나 상대적인 타이밍 때문에 달라지는 걸 의미.
- 즉 결과가 예측한대로 나오지 않음 (버그임)
- `Thread-safe` 하다는 말은 race condition의 상태에서 자유롭다는 의미로 봐도 되는듯.

## Check-Then-Act

- race condition type
- 프로그램 flow임.
  - 현재 상태를 검사한 후에, 다음 행동을 하는 것.
- e.g back funds transfer

![image](https://www.baeldung.com/wp-content/ql-cache/quicklatex.com-e240cc2d4e75c7d6c5cbf6685d955996_l3.svg)

## Read-Modify-Write

- race condition type
- multi thread application에서 자주 직면할 수 있음.
- e.g global counter

![image](https://www.baeldung.com/wp-content/ql-cache/quicklatex.com-c568072cda8838a1760db3e82ad39682_l3.svg)

## Elimination

- 2가지 방법으로 race condition을 방지할 수 있음.
- Avoiding shared state
  - 즉 변경가능하지 않은 객체들을 사용.
  - 혹은 thread-local한 객체들.
- 즉 공유에 있어 immutable한 객체를 사용하거나 혹은 공유 중인 객체를 다른 객체에서 접근하지 못하도록하는 방법인듯.

- Using Synchronizations and Atomic Operations
  - `lock`, 스레드 수준에서 사용하는 것.
  - `mutex`, 프로세스 수준에 걸쳐도 사용되는 락과 동일한 추상화 형태인듯.
- 동기화를 사용하는 건 좋지만, 오버헤드 발생 (성능 저하가 있음)
- 또한 교착 상태(Deadlock, Starvation) 이 발샐할 수도 있음.

## Conclusion

- 전반적으로 2개의 타입 모두 공유 자원에 대해 배제가 필요한 부분이라 생각됨.
- 읽기를 할 때는 이러한 배제를 하지 않아도 되지만, 쓰기를 할 때는 다른 스레드에서 침범하지 못하도록 배제 시키는게 필요할 지도.

## 참고

- <https://www.baeldung.com/cs/race-conditions>
- <https://iredays.tistory.com/125>
