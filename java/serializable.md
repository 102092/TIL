#java

- JVM 메모리에 존재하는 객체나, 데이터를 JVM 외부에서도 사용할 수 있도록 `Byte` 형태로 변환하는 과정을 말한다.
- 직렬화된 데이터는 `primitive` 한 `Byte` 타입의 묶음임.
  
  ## 어떻게 사용할까?
- Java 직렬화는 비교적 복잡한 객체도 큰 작업 없이 `java.io.Serializable` 인터페이스만 구현해주면 기본 Java 라이브러리만 사용해도 직렬화/역직렬화 가능
- 만약 [[transient]] 를 선언하면, 객체가 직렬화 되지 않는다.
- `NonSerializableException` 오류가 발생할 경우, 직렬화 대상에서 제외하고 싶은 객체에게 `Transient` 를 선언해주면 해당 오류를 해결할 수 있음.

## 왜 사용할까?
- 서로 다른 메모리 공간을 가지고 있는 프로세스 간에 데이터 전달을 위해서
- 메모리 공간의 주소 값이 아닌, 객체 데이터를 직렬화 하여 전달하면, 상대방은 역직렬화 하여 해당 객체를 생성하고 자신의 메모리에 올릴 수 있게 됨.
- 다시 말해서, 전송 혹은 저장 가능한 데이터를 만들기 위해서 직렬화를 사용함.

## serialVersionUID ?


## JPA entity 정의할 때, Serializable 을 구현할 필요가 있을까?
>  if our object is to leave the domain of the JVM, it'll require serialization.

- JVM에서만 사용되는 게 아니라, 외부 프로그램으로 전송되거나 혹은 View에 도메인 그대로 보여지게 될 경우, 해당 인터페이스 구현이 필요한듯.

> when describing mapping in Hibernate, notes that the referenced field must be serializable when we use referencedColumnName from the @JoinColumn

- `@JoinColum` 어노테이션의 referencedColumnName 을 사용해서 연관관계를 맺는 경우, 그리고 그 키가 복합 엔티티일 경우, 해당 엔티티는 반드시 serializable 인터페이스를 구현해야함.

## 결론
- 여러가지 경우의 수를 따져봤을 때, 기본적으로 JPA Entity에 serializable 인터페이스를 구현하는게 좋을듯 싶음.
- 그렇지만 안전하다고 확실 할 수 없을 경우에 필터링을 해야함 [참고](https://madplay.github.io/post/why-java-serialization-is-bad)
- 가능한 Json을 통해 프로그램 간 데이터를 교환하는게 나을지도..?
  
# 참고
- https://www.baeldung.com/java-serialization
- https://www.baeldung.com/java-serial-version-uid
- https://madplay.github.io/post/java-serialization
- https://www.baeldung.com/jpa-entities-serializable