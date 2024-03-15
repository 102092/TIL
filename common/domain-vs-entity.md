

# Domain vs Entity

## Domain

- 직역해보면 **영역, 범위** 라는 의미

- 개발적으로 사용될 때는 내가 개발하고자 하는 바를 구성하는 핵심 개념, 영역을 의미하는듯.

- 예를 들면 야구 게임이라는 걸 개발하고 자 할 때 여기서 도메인에 해당하는 건 *야구* 일듯.

- 정리해보자면 추상적으로 사용되고, 비즈니스를 구성하는 핵심적인 로직을 말할 때 사용한다고 보면될듯.



## Entity

- **독립체**

- 식별자를 가지는 개체

- 데이터베이스와 맞물리기도 하는듯.

- **Hibernate Entity** is a Java object that is instantiated, tracked, persisted, discarded and garbage collected
  
  - 하이버네이트에서 정의된 엔티티는 자바 객체로 추적, 저장, 삭제등이 가능한 객체를 일컫는듯

- **DDD Entity** is an abstract thing, if defines an idea (a pattern) and gives guidelines of what this idea is and what it represents
  
  - 반면 DDD라는 철학에서 정의된 엔티티는 추상적인 것.
  
  - 아이디어나 그걸 어떻게 나타낼지에 대한 가이드라인을 주는 추상적인 것을 의미하는듯.



## 그래서..?

- Domain and Entity are different functions. Domain model **has-an** entity

- 도메인이 좀 더 범위가 넓은 추상적인 의미.

- 엔티티는 도메인을 기반으로 정의된 것.

- 

# 참고

- [Domain, Entity, Value(Object)](https://doing7.tistory.com/79)

- [Domain Driven Design - Domain model vs Hibernate Entity - Stack Overflow](https://stackoverflow.com/questions/55756194/domain-driven-design-domain-model-vs-hibernate-entity)
