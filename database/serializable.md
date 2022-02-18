# Database Serializable

## 정의
- 데이터 베이스는 동시에 실행하는 데도 불구하고 그 결과가 `Serial Schedule`의 부분 집합이라면 즉 한번에 한번씩 실행했던 것과 같다면,` Serializable` 하다라고 말한다.
- 어디에서 언급되는가?
  - 트랜잭션의 isolation level (격리 수준)
  
## 트랜잭션
- 트랜잭션이란, 데이터베이스의 상태를 변환시키는 하나의 논리적 기능을 수행하기 위한 작업의 단위 또는 한꺼번에 모두 수행되어야 할 일련의 연산들을 의미
  - 즉 어떠한 쿼리등의 결과가 적용되거나(Commit) Rollback 됨을 의미함.
  - All or Nothing?
  
## 트랜잭션의 성질
> A C I D

- Atomicity 원자성
  - All or Nothing
  - 트랜잭션은 어중간한 것이 없음, 해당 트랜잭션은 적용되거나 혹은 아무것도 영향이 없거나 둘중 하나다!
- Consistency 일관성
  - 데이터베이스의 일관성을 의미한다.
  - 트랜잭션이 실행되기 전, 실행된 후의 데이터베이스가 가지고 있는 각종 제약조건들은 여전히 유지되고 있어야함.
- Isolation 고립성
  - 일반적으로 DB는 사용자 여럿이 동시에 접근하는 것이 가능하다
  - 이러한 쿼리들이 동시에 실행되지만, 각각 트랜잭션을 볼 때는 고립되어서 실행되는 것 처럼 보여야한다.
- Durability 영속성, 지속성
  - 트랜잭션이 `commit` 되고 나면, 반드시 DB에 영구적으로 반영되어야 함.

## InnoDB
- 레코드 기반 저장 구조를 의미
- MySQL도 내부적으로 `InnoDB` 를 사용

## CAP 이론
> 분산 시스템을 지탱하는 이론
- 분산 시스템? 서버가 여러대 있고 , 이를 통해 서비스를 제공해줌.
- Consistency : 일관성 
  - 사용자가 요청을 하면, 요청을 처리해줄 서버는 어떤 것일지는 모르지만, 그럼에도 불구하고 항상 똑같은 결과를 보장해줘야함.
- Availability : 가용성
  - 서버는 항상 동작하고 있는 상태여야 함.
  - 이는 사용자에게 서버가 장애상태에 있다는 것을 알려주는 것도 포함함.
- Partion Tolerence : 
  - 하나의 서버가 망가져도, 해당 데이터는 여전히 다른곳에 존재해야함.

- CAP를 모두 만족하는 서버는 존재하지 않는다!
  - NoSQL 은 A,P를 만족시키지만, C를 포기했음.
  - 그래도 `Eventual Consistency`를 보장해준다. 즉 일관성을 보장해주긴 하는데 언제 그러한 내용이 반영될지는 모른다.
  - 예를 들면, A 가 `DropBox` 에 어떤 파일을 업로드한다고 하고 B가 이를 다운 받을 예정이라고 하자
  - A 컴퓨터에서 업로드가 끝나도, 해당 공유폴더에서 B 컴퓨터로 바로 다운 받을 수 없다.
  - 하지만 어느정도 시간이 지나면 다운받을 수 있음을 `Eventual Consistency`를 만족한다고 이야기할 수 있음.


### 참고
- https://ryan-han.com/post/java/serialization/
- https://www.letmecompile.com/database-transaction-isolation-level/
- https://coding-factory.tistory.com/226

