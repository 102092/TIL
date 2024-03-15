- 멀티스레드 환경에서, 2~3개의 스레드에서 mutable shared data를 동시에 업데이트 할 때 [race condition](https://www.baeldung.com/cs/race-conditions) 발생.
	- 이 때 자바가 제공하고 있는, [[race-condition]] 을 피하기 위한 메카니즘임.
	- shard data에 접근하는 스레들을 sychronizing 함으로..

```java
public class BaeldungSynchronizedMethods {

    private int sum = 0;

    public void calculate() {
        setSum(getSum() + 1);
    }

    // standard setters and getters
}

@Test
public void givenMultiThread_whenNonSyncMethod() {
    ExecutorService service = Executors.newFixedThreadPool(3);
    BaeldungSynchronizedMethods summation = new BaeldungSynchronizedMethods();

    IntStream.range(0, 1000)
      .forEach(count -> service.submit(summation::calculate));
    service.awaitTermination(1000, TimeUnit.MILLISECONDS);

    assertEquals(1000, summation.getSum());
}

```

- `int sum`은 공유자원, 접근하는 방식은 `cacluate()` 를 통해서 (여러 스레드가..)
- 즉 3개의 스레드에서 동시에 접근해서 `calculate()` 실행
- 결과가 1000이 나올 것이 기대되지만, 테스트 실패함.

## keyword

- [[synchronized]] 키워드는 3가지 부분에 사용할 수 있음.
	- instance method
	- static method
	- code blocks
- code block에 사용할 때는, [monitor](https://www.baeldung.com/cs/monitor) 을 사용해서 락을 제공.

### instance method

```java
public synchronized void synchronisedCalculate() {
    setSum(getSum() + 1);
}
```

- 일반적인 메서드에 키워드 추가하는 것.
- 생성된 instance 해당 메서드에 접근하는 건 한번에 하나의 스레드에서만 가능하게함.
- 여러 instance가 생성되어 있으면, 각각 인스턴스마다 각각 스레드가 해당 메서드에 접근 가능하게 됨.

### static method

```java
 public static synchronized void syncStaticCalculate() {
     staticSum = staticSum + 1;
 }
```

- `static` 키워드와 함께 사용.
- Class 레벨에 종속되어있음.
	- 즉 오직 하나의 Class object가 [[JVM]] 에 존재할 수 있는 만큼, 이 클래스로 생성된 인스턴스가 여러개 있더라도, 해당 메서드에 접근하는 건 하나의 스레드만 가능함.
- 정리해보자면 instance method 레벨에 키워드가 붙어있으면, 해당 *인스턴스* 에서만 하나의 스레드가 접근가능하도록 보장하는데,
- `static` 와 같이 사용한다면, 해당 클래스에 해당 메서드에 하나의 스레드가 접근하도록 보장하는 것.

## 참고
- <https://www.baeldung.com/java-volatile>
- <https://www.baeldung.com/java-synchronized>
- <https://www.geeksforgeeks.org/volatile-keyword-in-java/#:~:text=For%20Java%2C%20%E2%80%9Cvolatile%E2%80%9D%20tells,scope%20of%20the%20program%20itself>
- <https://www.geeksforgeeks.org/class-level-lock-in-java/>