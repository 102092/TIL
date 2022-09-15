# Persistence context

- `EntityManager` 인스턴스와 연관 있음.
- entity instances들의 집합이라 부를 수 있을듯.
  - 그리고 이 entity들은 unique하게 구분될 수 있음.
- 영속성 컨텍스트 내부에서는, entity들의 lifeCycle의 관리됨.
- 정리하자면..

> The persistence context is the first-level cache where all the entities are fetched from the database or saved to the database.

- 데이터베이스에서 혹은 데이터베이스로 저장하고자하는 모든 엔티티들이 존재하는 **1차 캐시**라 할 수 있음.
- application - persistence context - database
  - application과 database 사이에 존재.
- 그리고 내부에 존재하는 entity들의 변화를 관리함.
- 만약에 트랜잭션 중에, 엔티티들의 변화가 일어난다면, 해당 entity는 dirty 상태로 marked 됨.
- 그리고 트랜잭션이 끝난다면 (commit 시에..), 해당 변경들이 Database로 flush됨

## Persistence Context Type

- persistence context가 어떤 scope내에 존재 할지에 대한 설정.
- default는 `Transaction-scoped` 인 듯.

## Transaction-Scoped Persistence Context

- 영속성 콘텍스트는, 트랜잭션 내부에 존재하는 것.
- 트랜잭션 진행 시에, 영속성 컨텍스트가 있는 지 확인해서, 있으면 있는 걸 쓰고 없으면 새로 만듬.
- 트랜잭션 내부에서 영속성 콘텍스트에 속하는 엔티티의 변화가 일어날 경우, 이걸 감지하고 추후 트랜잭션 커밋시에 데이터베이스로 변경사항을 flush함

## Extended-Scoped Persistence Context

- 여러개의 트랜잭션에서 하나의 영속성 콘텍스트를 사용할 수 있는 것.
- entity persist는 트랜잭션 없이 할 수 있지만, (entity를 persistence context에 추가하는 것..)
- flush는 트랜잭션 없이 할 수 없음.
  - 즉 여러개 트랜잭션에서 하나의 영속성 컨텍스트가 공유되는 만큼, persist 같은 액션에 트랜잭션 존재 여부가 체크 되진 않지만, database 로 flush 하는 액션에는 트랜잭션이 필수 인듯.

### 참고

- <https://willseungh0.tistory.com/75>
- <https://velog.io/@conatuseus/2019-09-06-0009-%EC%9E%91%EC%84%B1%EB%90%A8-cfk06vdfm9>
- <https://www.baeldung.com/jpa-hibernate-persistence-context>
- <https://docs.jboss.org/hibernate/core/4.3/devguide/en-US/html/ch03.html>
