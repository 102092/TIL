- 하나 이상의 클래스를 상속받거나 인터페이스를 구현하는 자바 클래스의 동적 서브클래스를 생성하는 Java 라이브러리
- **타겟 클래스**를 통해 프록시 객체 생성
	- [[bytecode]] 를 조작함...
- 현재 Spring에서 기본적으로 [[proxy]] 를 생성하는 방법으로 채택됨.
	- 초기에는 여러 문제가 있었으나, 개선되었음.

---
## 정리
![image](https://gmoon92.github.io/md/img/aop/jdk-dynamic-proxy-and-cglib/aop-proxy-mechanism2.png)
- Bean 이 인터페이스를 구현하고 있으면.. -> [[JDK-dynamic-proxy]]
- Bean이 인터페이스를 구현하고 있지 않으면.. [[CGLib]]

## 참고
- <https://gmoon92.github.io/spring/aop/2019/01/15/aspect-oriented-programming-concept.html>
- <https://gmoon92.github.io/spring/aop/2019/04/20/jdk-dynamic-proxy-and-cglib.html>
- <https://velog.io/@hanblueblue/Spring-Proxy-1-Java-Dynamic-Proxy-vs.-CGLIB>
- <https://blog.naver.com/gngh0101/222073112894>