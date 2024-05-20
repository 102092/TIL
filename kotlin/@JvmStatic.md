# @JvmStatic란?
- Kotlin 프로퍼티를 자바 필드처럼 사용하게 해주는 어노테이션

## @JvmStatic 사용법

```kotlin
class C { 
	companion object { 
		@JvmStatic 
		fun callStatic() {} 
		fun callNonStatic() {} 
	} 
}
```

```java
C.callStatic(); // works fine 
C.callNonStatic(); // error: not a static method 
C.Companion.callStatic(); // instance method remains 
C.Companion.callNonStatic(); // the only way it works
```

- `@JvmStatic` 가 있는 경우, `Companion` 키워드 없이 호출할 수 있음

## Reference
- https://kotlinlang.org/docs/java-to-kotlin-interop.html#static-methods