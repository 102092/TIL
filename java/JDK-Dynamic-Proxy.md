- 인터페이스를 기반으로 **런타임에** 프록시 객체를 동적으로 생성하는 Java 기술
- `java.lang.reflect` 이용하여 생성한 Proxy 객체
	- 즉 리플랙션이 Proxy객체를 동적으로 생성해주는 것.
- JDK 프록시를 사용한다면, `@Autowired` 를 통해 주입하는 객체는 구현체가 아닌, 인터페이스여야 됨.
	- 왜? 프록시 객체는 인터페이스를 통해 생성되었으므로, 이 인터페이스를 구현한 객체를 가져오려하면 찾을 수 없을듯.
- `@EnableAsync` 인터페이스에서, `AdviceMode mode()` 를 보면 default가 `AdviceMode.PROXY` 임
	-  설명을 보면, `JDK proxy-based advice` 아마도 기본적으로 JDK Dynamic proxy를 사용한다는 뜻일듯.

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