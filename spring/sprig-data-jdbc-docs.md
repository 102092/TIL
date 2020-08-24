# 들어가면서

- todo 프로젝트에서, DB schema 설정 시, 사용하고 있는 의존성 특히 `spring-data-jdbc` 에 대해 제대로 알아야 겠다는 생각이 들었음.
- 지금까지 사용해본바로는, `jdbc template(DB..) -- data-jdbc -- jpa (객체지향)` 
- 해당 의존성은 중간자 역할을 하고 있는 듯.
- 약간이나마, 자바에서 사용하고 있는 자료구조들을 DB에 편리하게 적용시키기 위함이 느껴지기도 함 ex) mappedCollection
- 참고문서가 없는 만큼, 공식문서에서 살짝만 참고해서 정리해봄.



# Why Spring Data JDBC?
- No lazy loading or Caching
- no dirty tracking, no session



# Domain Driven Design and Relational Databases.
- `repository`, `aggregate`, `aggregate root`라는 개념에서 비롯되었음.
- aggregate는 엔티티들의 그룹을 의미하는데, 그 예로는 **주문**과, **상품들** 임
- 각각의 aggreate는 하나의 aggregate root를 가지고 있음.
- aggreate는 root를 통해서만 조작이 가능하다.



# @MappedCollection
- 1:1 관계에 있거나 `Set, List, Map` (1:다 관계) 있을 때 사용할 수 있음.
- `annotaion`의 `value` 중 `idColumn` 은 부모객체의 id column값을 의미하고
- 그리고 `List, Map` 을 사용할 때, 추가적인 `column`을 반드시 가지고 있어야함.  
  - 왜? 해당 자료구조안에, 위치를 판별하기 위해서.
  - `KeyColumn` 에 어떤 컬럼을 위치판별을 위해 사용할 것인지 명시해야한다.

# 참고

- https://docs.spring.io/spring-data/jdbc/docs/current/reference/html/#reference