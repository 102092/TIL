# 도메인 주도 개발 시작하기

# ch 8
- 선점 잠금(pessimistic lock)
- 비선점 잠금(optimistic lock)

## 선점 잠금
- 보통 비관적인 락이라 불림.
- 다른 스레드가 수정하지 못하도록 우선 해당 row에 락을 거는 방식
- 해당 트랜잭션이 커밋 되면, row에 걸린 락은 해제됨.
- 보통 DBMS가 제공하는 **행단위 장금** 을 사용해서 구현함.
    - `for update`
- JPA 로는 `LockModeType` 을 이용해서 구현함.
- Spring data jpa는 `@Lock` 제공.

### 교착 상태
- 선점 잠금에 따른 교착 상태는 사용자가 많을수록 발생할 가능성이 높음.
- 이러한 교착상태를 방지하고자 최대 대기 시간 정해야함
- Spring Data jpa 에서는 `@QueryHint` 를 통해 이를 구현하고 있음.

## 비선점 잠금
- 변경한 데이터가 실제 DB에 반영하는 시점에, 변경이 가능한지 확인하는 방식
- Version 을 이용해서, 업데이트하려는 row가 적절한지 판단함.
- JPA에서는 `@Version` 을 통해, 버져닝을 할 수 있는 컬럼을 추가할 수 있음.