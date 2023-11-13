# null 잘 쓰는 법 1
- null을 통해 유연한 메서드를 만들지 말고, 명시적인 메서드를 만들도록.
- null을 반환하지 말라
    - 반환 값이 꼭 있어야하는데 null이면 예외를 던지게 하고,
    - 빈 반환값은 빈 컬렉션이나 혹은 Null 객체 (빈 객체지만 Null 대용으로 사용되는)
    - 반환 값이 없을 수도 있으면 Optional을 반환.

# null 잘 쓰는 법 2
- Design By Contract
    - require + __ + ensure
    - 메서드가 실행되기 전에 만족되어야 하는 부분 + 로직 실행 + 로직 실행 후에, 만족되어야하는 부분
    - 이런 방식으로 개발하면, 품질을 보장할 수 있음.
- 즉 이걸 null에 대입해보면,
    - 보호절에는 단정문, Objects에서 제공해주는 메서드..등을 사용할 수 있음.
    - Assert, Preconditions.. 클래스들도 사용해볼 수 있겠네.
- 즉 사전 조건을 확실히 지켜라

# null 잘 쓰는 법 3
- null의 범위를 좁혀라
- 즉 클래스나 메서드 내부에서만 사용하도록. 
    - 그리고 그 클래스나 메서드를 작게 만들면 됨.

# JSR 308
- `@NonNull` , `@Nullable` 등 컴파일 타임에서 체크할 수 있도록..
- Automatic type refinement
```java
    Console console = System.console();
    char[] password = nonNull(console) ? console.readPassword() : new char[0];
```

# 정리
- JSR 305, JSR 308 쓰자
- Checker Framework


# 참고
- https://www.youtube.com/watch?v=vX3yY_36Sk4&t=954
- https://www.oracle.com/technical-resources/articles/java/ma14-architect-annotations.html