> The serialVersionUID attribute is an identifier that is used to serialize/deserialize an object of a Serializable class.

- 즉 [[java/serializable|serializable]], [[deserialize]]  할 때 식별자로 사용되는 속성
	- 필수는 아님. 선언되어있지 않을 경우, 클래스의 기본 [[hash]] 값을 사용함.
- 해당 값은 다른 클래스끼리 같은 값을 가져도 상관 없음 (클래스 별 독립적인 값으로 취급된다.)
- 직렬화, 역직렬화 과정에서 해당 값이 일치하지 않으면, 즉 어떤 프로그램에서 A라는 클래스의 SUID 값은 1인데, 외부에서 받아서 역직렬화를 해봤더니 A라는 클래스의 SUID 값이 2이면..
	- `InvalidClassException` 에러를 던진다.

## 어디서 사용할까?

- [[JVM]] 상에 존재하는 객체 데이터를 그대로 영속성화(Persistence) 하고 싶을때
- Servlet Session
- [[WAS]] 는 기본적으로 Java 직렬화를 지원해줌.
- Cache
- Java RMI(Remote Method Invocation)
	- 원격 시스템의 메서드를 호출할 때 전달하는 메세지(객체)를 직렬화, 메세지(객체)를 전달받은 원격 시스템에서는 메세지(객체)를 역직렬화