# @Component vs @Bean

## @Component

- auto-detect and auto-configure beans using classpath scanning
  
  - 자동 탐색과 자동적으로 Bean으로 등록되도록 하는 어노테이션
  
  - 해당 어노테이션은 탐색 + Bean으로 등록이 가능하도록 해주는 어노테이션이라 보면 될 듯
  
  - `@Service` , `@Repositor` 빈도 같음.

- 클래스와 1:1 매핑 관계
  
  - 즉 **클래스**에만 사용할 수 있음.
  
  - Class, interface (including annotation type), or enum declaration
  
  - 그러면 좀 더 자유도가 높게 어떤 클래스를 생성한 후에 `Bean` 으로 등록해 관리할 수 있게 해줄듯



## @Bean

- `@Component` 스프링이 알아서 빈을 생성해주기보다는, 개발자가 생성을 설계

- **메서드, 어노테이션 타입**에 선언할 수 있음.

- 보통 외부 라이브러리를 통해, 어떤 클래스 생성하여 사용하는데 개발자가 의도한 대로 수정하고 이를 사용할 때 해당 어노테이션을 많이 사용하는 듯.

- 클래스에 `@Configuration` 있어야, 해당 클래스 내부에 있는 `@Bean` 으로 정의된 부분을 생성해서 스프링 컨테이너에 넘겨줄 수 있는듯.

- `@Scope` 어노테이션을 추가적으로 정의해서, 해당 빈이 어떤 범위(scope) 로 적용될지 정의할 수 있는듯.
  
  - singleton
  
  - prototype
  
  - request
    
    - HTTP 요청 하나가 들어오고 나갈 때 까지 유지되는 스코프, 각각의 HTTP 요청마다 별도의 빈 인스턴스가 생성되고, 관리  
    
    - 즉 하나의 요청이 왔을 때, 그 빈을 기반으로 생성된 프록시 객체가 사용되고 유지됨을 의미하는듯.
  
  - session
  
  - application
  
  - websocket





## 정리하자면..

- 둘 다 spring container에게 객체 관리를 맡기기 위해서 사용하는 어노테이션

- 다만 사용할 수 있는 타입이 다르고,

- 언제 사용하는 지도, 상황에 따라 다르게 사용할 수 있음.



# 참고

- [@Component와 @Bean의 차이](https://goodgid.github.io/Spring-Component-vs-Bean/)

- [java - Spring: @Component versus @Bean - Stack Overflow](https://stackoverflow.com/questions/10604298/spring-component-versus-bean)

- [Quick Guide to Spring Bean Scopes | Baeldung](https://www.baeldung.com/spring-bean-scopes)

- [[Spring]Request Scope를 사용해서 깔끔하게 로그남기기](https://chung-develop.tistory.com/64)
