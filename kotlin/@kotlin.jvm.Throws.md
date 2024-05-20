# checked exception 이란?
- 컴파일러 단계에서 예외 처리를 명시적으로 요구하는 예외 유형
- e.g. IOException

## Java의 Checked Exception 처리
- Checked Exception 처리를 강제
- 반드시 try-catch 블록으로 예외 처리를 해야만 컴파일이 통과됨

```java
try { 
	// Checked Exception이 발생 가능성이 있는 코드 
} catch (CheckedException e) { 
	// 예외 처리 코드 
}
```

## Kotlin에서 Checked Exception 처리
- 처리가 강제되지 않음
- 예외가 전파되지 않음.

```kotlin

@kotlin.jvm.Throws(IOException::class)
fun throwIOException() {  
    throw IOException()  
}
```

- `@kotlin.jvm.Throws` 을 통해, 전파를 하게 할 수 있음.

## Reference
- https://kotlinlang.org/docs/exceptions.html