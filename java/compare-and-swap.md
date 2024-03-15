- 일명 CAP
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

# 참고
- https://www.digitalocean.com/community/tutorials/atomicinteger-java
- https://www.javacodemonk.com/what-is-atomicinteger-class-and-how-it-works-internally-1cda6a56
- https://www.baeldung.com/java-volatile
- https://www.geeksforgeeks.org/volatile-keyword-in-java/#:~:text=For%20Java%2C%20%E2%80%9Cvolatile%E2%80%9D%20tells,scope%20of%20the%20program%20itself.