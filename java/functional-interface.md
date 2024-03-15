
- Java 스펙에 정의된 함수형 인터페이스라는 것을 알리기 위한 **정보성 애노테이션**
- 함수형 인터페이스 ?
    - 한개의 *추상 메소드*를 가짐
    - `default` 선언된 메소드는 구현이 있으므로 추상 메소드가 아님
    - `java.lang.Object` 의 공통 메서드(`equals()`..등) 를 대체하는 추상 메소드는, 함수형 인터페이스를 위한 추상메소드로 여겨지지 않음.

```java
@FunctionalInterface
public interface MyFunctionalInterface {
    void hello(); // 추상 메소드
}
```
- 하나의 추상 메서드를 가지는 적절한 함수형 인터페이스


```java
@FunctionalInterface // compile error -> No target method found
public interface MyFunctionalInterface {
    default void hello() {}
}

@FunctionalInterface // compile error -> No target method found
public interface MyFunctionalInterface<T> {
    boolean equals(Object obj);
}

```
- default method나 Object의 메서드를 오버라이드 하는 경우 컴파일 에러 발생

---

- `@FunctionalInterface`로 선언된 타입은..
    - `interface` 타입이어야함. annotation, enum, class 면 사용할 수 없음.
- 그렇지만 `@FunctionalInterface` 어노테이션 선언과 무관하게, 함수형 인터페이스의 정의 즉 해당 인터페이스가 하나의 추상메서드만 갖는 다면 컴파일러는 해당 인터페이스를 함수형 인터페이스로 취급함. 

## 대표적인 함수형 인터페이스


## 참고
- https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/FunctionalInterface.html
- https://johngrib.github.io/wiki/java-functional-interface/
- https://www.baeldung.com/java-8-functional-interfaces