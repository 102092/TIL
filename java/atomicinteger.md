
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

# ETC
- java.util.concurrent.atomic 패키지에 AtomicInteger를 포함한 다른 클래스들도 있음.
- AtomicBoolean, AtomicIntegerArray, AtomicLong...


# 참고
- https://www.digitalocean.com/community/tutorials/atomicinteger-java
- https://www.javacodemonk.com/what-is-atomicinteger-class-and-how-it-works-internally-1cda6a56
- https://www.baeldung.com/java-volatile
- https://www.geeksforgeeks.org/volatile-keyword-in-java/#:~:text=For%20Java%2C%20%E2%80%9Cvolatile%E2%80%9D%20tells,scope%20of%20the%20program%20itself.