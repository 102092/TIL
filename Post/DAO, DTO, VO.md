# DAO, DTO, VO, Entity

### 전체 구조

![](https://gmlwjd9405.github.io/images/spring-framework/spring-package-flow.png)





## DAO

### @Repository 

- Data Access Object

- 일종의 객체

- DB를 사용해 데이터를 조회, 조적하는 기능을 담당. 

- 왜? DB에만 접근하는 Model을 따로 만들어두는 걸까?

  1. DB에 접근하기 위해서는 Connection객체를 생성해야하니까 다른 코드가 있을 경우 효율적이지 못함.
- CRUD (Create Read Update Delete) 할수 있도록..


## DTO

- Data Transfer Obejct

- 계층간 *데이터 교환*을 위해 사용

  `public` 접근제어자를 사용하는 경우가 많음

  계층? 컨트롤 - 서비스 - Repository간에

- *getter/setter* 메서드를 가짐

- VO(Value Object) 와 비슷한 말 단 VO는 **read only**

  VO는 *특정한 비즈니스* 값을 담는 객체, 변하지 않고 불변하는 객체일 때 사용
  
  *setter* 없음.



## Entity

- entity, 유사한 속성을 가지고 있는 집합을 일컫는 말. 비슷한 entity를 묶음 분류화

### Domain

- 실제 DB테이블과 매칭됨.

- 가장 Core핵심 클래스

  

### 참고

- https://genesis8.tistory.com/214

- https://gmlwjd9405.github.io/2018/12/25/difference-dao-dto-entity.html

- https://multifrontgarden.tistory.com/182