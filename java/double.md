- floating-point literals의 **default type**
- 8 bytes (64bits)
- 소수점 값을 표현
- suffix로 `d`, `D` 혹은 <u>보통 소수점 자리는 double로 컴파일 되는듯</u>
  
  ```java
  double d1 = 1.23;
  double d2 = 1.23d;
  double d3 = 1.23D;
  ```

- [[float]] 가 보다 [[double]] 좀 더 정확함.
	- <u>더 많은 메모리</u>를  사용하니, 더 **정확한 값**을 나타낼 수 있을듯.
	- 소수점 아래 15 ~ 16자리 까지 정확하게 표현 가능하다고 함.
	- 즉 [[float]] -> [[double]]로 변환할 때는 **데이터 손실**이 없다고 보면 됨.
	- [[double]] -> [[float]]로 변환 될 때는 데이터 손실이 발생할 수도 있을듯.

- default value는 `0.0d`

> [[float]] 와 비슷한 점

- 둘 다 정확한 값을 나타내진 않는다.
- 즉 소수점 한자리수가 중요한 통화등에 사용하면 안된다.
	- *[[floating-point]] 문제*
	- `BigDecimal`사용
- `=` , `!=` 같은 정확한 값을 비교하는 논리 연산자 사용의 해당 타입들에서 사용을 피하는게 좋을듯.
	- `>` , `<` 비교 연산자는 괜찮을듯..?

# 참고

- https://javahungry.blogspot.com/2019/11/difference-between-float-and-double-in-java.html
- [Java 자료형 비교 : Double vs Float (Difference between Double and Float)](https://goodgid.github.io/Java-Double-vs-Float/)
- [What&#39;s the difference between a single precision and double precision floating point operation? - Stack Overflow](https://stackoverflow.com/questions/801117/whats-the-difference-between-a-single-precision-and-double-precision-floating-p)
