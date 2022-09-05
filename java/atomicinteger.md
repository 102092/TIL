# AtomicInteger 란?
- `An int value that may be updated atomically`
- 원자적인 int 업데이트를 보장해주는 클래스인듯.
- 아마도 멀티스레드 환경에서 발생할 수 있는 데이터 불일치성을 피할 수 있을듯함. 
    - 여러 스레드가 하나의 int value를 증가시키는 것과 같은..

# How to work?
- `uses combination of volatile & CAS (compare and swap) to achieve thread-safety for Integer Counter`

## volatile 
- 휘발성이라는 단어뜻.
    - 아마 메모리가 휘발성이어서, 메인 메모리에 접근하겠다는 뜻으로 한게 아닐까.
    - 메인 메모리까지 접근해야하니, CPU 캐시에 접근하는 비용보다는 **시스템 자원을 많이 소모**할듯.
- 변수의 값을 Read할 때마다 CPU cache에 저장된 값이 아닌 Main Memory에서 읽는 것.
- 변수의 값을 Write할 때마다 Main Memory에 까지 작성하는 것
![](https://nesoy.github.io/assets/posts/20180609/1.png)

- 즉 CPU에서 제공하는 cache에서 값을 가져오는 것이 아닌, Main Memeory까지 가서 값을 가져옴.
    - 멀티스레드 환경에서 가장 최신의 값을 보장. (읽을 때)
    - write 하는 경우엔, 특정 스레드의 변경 사항이 무시될 수 있음. (아래 상황)

![](https://nesoy.github.io/assets/posts/20180609/3.png)

- 아마도 main memory에 2라는 값이 저장되는 것을 의도했겠지만.. CPU2 cache 에 저장된 +1 의 값이 무시됨.

## CAS
- `atomic instruction used in multi-threading to achieve synchronization`
- 특정 값이 (false), 예상한 값 (false) 과 같다면 새로운 값으로 치환하는 방법.
- 만약에 특정 값이 (true), 예상한 값(false) 과 다르면 해당 치환작업은 실패함이 보장됨.

## code
- java8
- java.util.concurrent.atomic.AtomicInteger#incrementAndGet

```java
    // sun.misc.Unsafe#getAndAddInt
    public final int getAndAddInt(Object var1, long var2, int var4) {
        int var5;
        do {
            var5 = this.getIntVolatile(var1, var2);
        } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));

        return var5;
    }
```

- `var5` 는 volatile value
    - 반환하는 건 초기값 (e.g = 1)
- `val1` 는 AtomicInteger 클래스
- `var2` 는 valueOffSet
    - The offset is just used to determine which memory location to address when updating the value field of AtomicInteger instances.
    - AtomicInteger 인스턴스가 가지고 있는 value값의 주소인듯.
- `compareAndSwapInt` CAS 기법으로, do-while문을 돌면서 현재 메인 메모리가 가지고 있는 값이 var5와 같으면 var5 + var4(1) 해서 set하고 아니면 계속 돌듯.
    - 돌다가 어느정도 지나면 튕기겠지..?


# ETC
- java.util.concurrent.atomic 패키지에 AtomicInteger를 포함한 다른 클래스들도 있음.
- AtomicBoolean, AtomicIntegerArray, AtomicLong...


# 참고
- https://www.digitalocean.com/community/tutorials/atomicinteger-java
- https://www.javacodemonk.com/what-is-atomicinteger-class-and-how-it-works-internally-1cda6a56
- https://www.baeldung.com/java-volatile
- https://www.geeksforgeeks.org/volatile-keyword-in-java/#:~:text=For%20Java%2C%20%E2%80%9Cvolatile%E2%80%9D%20tells,scope%20of%20the%20program%20itself.