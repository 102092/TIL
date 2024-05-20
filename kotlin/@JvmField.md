
# @JvmField 란?

- Kotlin 프로퍼티를 자바 필드처럼 사용할 수 있도록 해주는 어노테이션

## @JvmField 사용법

```kotlin
class Person {
  @JvmField
  var name: String = "Kotlin"

  // ...
}
```

```java
Person person = new Person();
person.name = "Java";
String javaName = person.name;
```

- `kotlin` 에서 해당 어노테이션을 특정 필드 위에 선언하면,
- `java` 에서 `get` `set` 아닌 property 로 접근할 수 있음
	- e.g. `person.name = "Java";`

## Reference
- https://kotlinlang.org/docs/java-to-kotlin-interop.html#instance-fields