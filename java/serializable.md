# Java Serializable

## 정의
- Serializable ?
  - JVM 메모리에 존재하는 객체나, 데이터를 JVM 외부에서도 사용할 수 있도록 `Byte` 형태로 변환하는 과정을 말한다.
  - 직렬화된 데이터는 `primitive` 한 `Byte` 타입의 묶음임.
- Deserialize ?
  - Serializable 된 정보를 즉 Byte 형태 묶음을, 객체로 변환하는 작업을 의미.
  - 즉 어떤 프로그램에서 사용할 수 있도록 Byte 데이터를 변환하는 과정을 의미함.

## 어떻게 사용할까?
- Java 직렬화는 비교적 복잡한 객체도 큰 작업 없이 `java.io.Serializable` 인터페이스만 구현해주면 기본 Java 라이브러리만 사용해도 직렬화/역직렬화 가능
- 만약 `Transient`를 선언하면, 객체가 직렬화 되지 않는다.
-`NonSerializableException` 오류가 발생할 경우, 직렬화 대상에서 제외하고 싶은 객체에게 `Transient` 를 선언해주면 해당 오류를 해결할 수 있음.

## 왜 사용할까?
- 서로 다른 메모리 공간을 가지고 있는 프로세스 간에 데이터 전달을 위해서
- 메모리 공간의 주소 값이 아닌, 객체 데이터를 직렬화 하여 전달하면, 상대방은 역직렬화 하여 해당 객체를 생성하고 자신의 메모리에 올릴 수 있게 됨.
- 다시 말해서, 전송 혹은 저장 가능한 데이터를 만들기 위해서 직렬화를 사용함.

## serialVersionUID ?
> The serialVersionUID attribute is an identifier that is used to serialize/deserialize an object of a Serializable class.
- 즉 직렬화, 역직렬화할 때 식별자로 사용되는 속성
  - 필수는 아님. 선언되어있지 않을 경우, 클래스의 기본 해시값을 사용함.
- 해당 값은 다른 클래스끼리 같은 값을 가져도 상관 없음 (클래스 별 독립적인 값으로 취급된다.)
- 직렬화, 역직렬화 과정에서 해당 값이 일치하지 않으면, 즉 어떤 프로그램에서 A라는 클래스의 SUID 값은 1인데, 외부에서 받아서 역직렬화를 해봤더니 A라는 클래스의 SUID 값이 2이면..
  - `InvalidClassException` 에러를 던진다.

## 어디서 사용할까?
- JVM상에 존재하는 객체 데이터를 그대로 영속성화(Persistence) 하고 싶을때
- Servlet Session
- `WAS` 는 기본적으로 Java 직렬화를 지원해줌.
- Cache
- Java RMI(Remote Method Invocation)
  - 원격 시스템의 메서드를 호출할 때 전달하는 메세지(객체)를 직렬화, 메세지(객체)를 전달받은 원격 시스템에서는 메세지(객체)를 역직렬화

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