- [[lock]] , 스레드 수준에서 사용하는 것.
  - [[mutex]] , 프로세스 수준에 걸쳐도 사용되는 락과 동일한 추상화 형태인듯.
- [[synchronization]] 를 사용하는 건 좋지만, [[overhead]] 발생 (성능 저하가 있음)
- 또한 교착 상태([[deadlock]], [[starvation]]) 이 발생할 수도 있음.

## 참고
- <https://www.baeldung.com/cs/race-conditions>
- <https://iredays.tistory.com/125