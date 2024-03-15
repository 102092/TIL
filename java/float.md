- floating-point literals
- 4 bytes (32bits) 를 차지
- 소수점 값을 표현
- suffix로 `f` 혹은 `F` 를 사용하여 해당 리터럴의 타입을 나타낼 수 있음.

```java
float num = 1.23456 // compiler error
float num = 1.23456f or float num 1.23456F`
float num = (float) 1.23456
```
``
  - 보통 소수점 아래 6~7 자리까지 **정확하게** 표현할 수 있음.
	  - `float num = 1.2345678f;`
- wrapper class 는 Float
- default value는 `0.0f`

> [[double]] 과 비슷한 점

- 둘 다 정확한 값을 나타내진 않는다.
- 즉 소수점 한자리수가 중요한 통화등에 사용하면 안된다.
	- *[[floating-point]] 문제*
	- `BigDecimal`사용
- `=` , `!=` 같은 정확한 값을 비교하는 논리 연산자 사용의 해당 타입들에서 사용을 피하는게 좋을듯.
	- `>` , `<` 비교 연산자는 괜찮을듯..?
## 참고
- https://javahungry.blogspot.com/2019/11/difference-between-float-and-double-in-java.html
- [Java 자료형 비교 : Double vs Float (Difference between Double and Float)](https://goodgid.github.io/Java-Double-vs-Float/)
- [What&#39;s the difference between a single precision and double precision floating point operation? - Stack Overflow](https://stackoverflow.com/questions/801117/whats-the-difference-between-a-single-precision-and-double-precision-floating-p)
