![image](https://www.baeldung.com/wp-content/uploads/2017/08/cpu.png)

- 기본적인 멀티 프로세스의 구조.
- Core(CPU) 별로, 캐시들을 가지고 있고, L3 를 거쳐 RAM으로 가는 구조.
- 만약에 L1 cache에서 A 메모리의 값에 업데이트가 일어나면 어떻게 될까?
  - 그 업데이트가 RAM에 전파될때 까지는 다른 코어에서는 알 수 없음. (업데이트가 안되었으니)
  - `data inconsistency`
- 이 키워드를 사용하면, 해당 변수의 변화가 main memory까지 바로 전파됨을 의미. ([[compare-and-swap]] 라는 방법을 이용해서)

### Memory Visibility

```java
public class TaskRunner {

    private static int number;
    private static boolean ready;

    private static class Reader extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }

            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new Reader().start();
        number = 42;
        ready = true;
    }
}
```

- 스레드는 2개 main, runner thread
- main thread에서 업데이트 한 변수 (number, ready) 가 runner thread 에게도 바로 읽을 수 있을까?
  - 그럴 수도, 시간이 걸릴 수도, 혹은 업데이트가 안될 수도 있음.
  - 왜?
  - `processors tend to queue those writes in a special write buffer`
  - 바로 적용되는 것이 아닌, write buffer에 queue 를 던져서, 일정 시간이 지난 후에 main memory에 반영되기 때문
- 즉 정리하자면,
  - main thread가 number, ready 변수를 업데이트 했을 때, reader thread가 업데이트 된 변수를 읽는 다는 보장이 없음.
  - 심지어 programe order (number -> ready) 순으로 업데이트해서 보기 보다는 아예 다른 순서 (ready -> number) 순으로도 볼 수 있음. (개발자의 의도와는 아예 다르게..)
  - ready = true로 바뀌었지만 number는 업데이트 되지 않은 채 0을 프린트 하고 종료될 수도 있다는 뜻인듯.

### To ensure programm order

- To ensure that updates to variables propagate predictably to other thread
- 프로그램을 작성한 순서대로 변수들이 업데이트 되는 것을 보장하기 위해선?
- `volatile` 변수를 사용.

```java
public class TaskRunner {

    private volatile static int number;
    private volatile static boolean ready;

    // same as before
}
```

- 이렇게 하면.. number 업데이트 후에 ready가 업데이트 된다.
- 42 print 후 종료를 예측할 수 있을듯.

## For multithreaded applications

- 일관적인 행동을 위해선 2가지 룰을 지켜야함.
    1. Mutual Exclusion : 치명적인 부분에는 한번에 하나의 스레드만 실행하도록.
    2. Visibility : 공유된 자원에 하나의 스레드로 부터 만들어진 변화들은, 다른 스레드들이 볼 수 있어야함. 왜? data consistency 를 유지하기 위해
- [[sy]] 메서드는 1,2 번의 룰을 모두 만족 시킬 수 있음.
  - 다만 상당한 자원을 소모.
- 그렇지만 [[volatile]] 는 mutual exclusion 없이 2번 visibility 측면을 만족시킴.


## 참고
- <https://www.baeldung.com/java-volatile>
- <https://www.baeldung.com/java-synchronized>
- <https://www.geeksforgeeks.org/volatile-keyword-in-java/#:~:text=For%20Java%2C%20%E2%80%9Cvolatile%E2%80%9D%20tells,scope%20of%20the%20program%20itself>
- <https://www.geeksforgeeks.org/class-level-lock-in-java/>