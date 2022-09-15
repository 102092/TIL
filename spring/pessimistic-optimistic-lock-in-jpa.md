# Pessimistic Locking vs. Optimistic Locking

- 낙관적인 락, 비관적인 락.
- 들어가기 전에,
  - 아마도 락에 대한 처리를 어떻게 할지에 대한 개념일듯.
  - 락에 대해 낙관적으로 생각하느냐, 락에 대해 비관적으로 생각하느냐로 이해됨.

## About

- 두가지 모두 Lock을 어떻게 다룰 것인가에 대한 모델
  - 데이터베이스 기본 기능은 아닌듯. 즉 데이터베이스에서 기본적으로 낙관적인 락 혹은 비관적인 락을 사용하겠다고 선택하는 옵션은 없는듯.
  - 단지 개념적으로는 락(Lock)을 바라보는 관점
- 낙관적인 락
  - 비선점 잠금.
  - 변경 사항이 데이터베이스에 **커밋될 때만** 레코드가 잠길 것임.
    - 락에 대해 조금 느슨하게 바라보는 듯, 트랜잭션 간이 충돌이 발생하지 않을 것. 
    - 즉 락 설정에 문제가 없을 거다!
  - 변경사항이 있어도, 아직 커밋이 안되었으면 잠겨있지 않을듯.
- 비관적인 락
  - 션점 잠금
  - 레코드가 변경이 되고 있다면, 잠겨있을 거임. 즉 Lock이 걸려 있을 것.
  - 트랜잭션 간 **충돌이 일어날 것이라 생각**하고 (비관적), 락을 좀 미리 빡세게 걸어놓는 느낌.
  - `낙관적인 락` 보다는 좀 더 엄격한 느낌.
  - 만약에 어떤 레코드가 수정 중이라면 (아직 커밋이 안된 상태) 락이 걸려있을 거라 기대하는 모델인듯.

## Optimistic locking

![image](https://vladmihalcea.com/wp-content/uploads/2021/03/LostUpdateOptimisticLocking-1536x821.png)

- physical, logcial 적으로 구현이 가능한듯.
- 그렇지만 여러모로 Logical을 사용하는 게 좀 더 효율적으로 볼 수 있을듯
  - 즉 Database 자체 Lock 보다는, 락 처럼 구현한 (Logical) 걸 사용하는게 낫다는 의미인듯.
- 그래서 위 그림으로 보면, `version` 이라는 컬럼을 통해, Logcial Lock을 구현 (JPA에서..)
  - commit 순간 version 을 증가시킴으로써, 다른 Update 문에 `version = 1` 조건이 되어있는 구문은 무시됨을 알 수 있음.
  - 이럴 경우 `PreapredStatement` 는 0을 리턴하고 `data access framework` (예를 들면 JPA..?) 에서는 `OptimisticLockException` 을 던짐.
  - 그럴 경우 Alice 가 진행하던 Transaction 은 **롤백**됨.
  - 적용하려고 했던 update문에 대한 정보가 없어지니까.. 이 부분에 대한 처리가 application 에서 필요할 지도..

> In JPA

- 보통 엔티티의 `@Version` 필드를 이용해서 사용함.
- 그래서 업데이트 전에, 해당 필드를 체크하는 방식을 이용

- 4가지 Lock Mode를 제공하고 있음.
  1. OPTIMISTIC
  - optimistic read lock
  - 비선점 락
  - 해당 모드를 사용하면, dirty read or non-repeatable read 가 발생하지 않도록 막아줌.
  - 즉 커밋되지 않은 데이터를 읽는 것을 방지하거나, 한 트랜잭션 내에서 같은 쿼리가 반복 실행 될 때 동일한 값이 나오도록 일관성을 보장해준다는 말.
  2. OPTIMISTIC_FORCE_INCREMENT
  - OPTIMISTIC 를 기반으로, 추가적인 버젼 증가된 entity가 반환됨.
  - 커밋이나 플러시 되기 전까지는 에러가 발생할지 특정할 수 없음.
  3. READ
  - OPTIMISTIC의 alias
  4. WRITE
  - OPTIMISTIC_FORCE_INCREMENT 의 alias

- JPA 스펙에서는 READ, WRITE 타입을 사용하기 보다는 1,2번 처럼 명시적인 타입을 사용하는걸 권장하는 듯.

- 발생할 수 있는 에러
  - `OptimisticLockException`
  - 해당 에러가 던져졌을 때, 현재 트랜잭션은 rollback only로 mark됨.
  - 보통 이 에러는, 다시 엔티티를 조회하거나 (새로운 트랜잭션으로), 그 후에 업데이트 하도록 권장됨.

- 정리하자면..
  - 기본적으로 JPA에서는 OPTIMISTIC, OPTIMISTIC_FORCE_INCREMENT 타입이 제공되고 있음.
  - 사용방법은 `Query` 인터페이스에서 지정하거나, 엔티티매니저를 통해 이용하는 방법도 있는듯.
  - 그리고 보통 에러 발생하면, 추가적으로 어플리케이션에서 핸들링이 필요한 것으로 보이고.
  - 데이터베이스에서 제공하는 락 (s lock, x lock) 을 사용하는 것이 아니므로, deadlock같은 상황이 발생하지 않을 것 같음.

## Pessimistic lock

![image](https://vladmihalcea.com/wp-content/uploads/2021/03/LostUpdatePessimisticLocking-1536x814.png)

- 비관적인 락
  - 즉 락이 걸릴 것을 예상하고, 미리 락을 선점함.
- 하나의 레코드에 동시에 업데이트가 되는 것을 막기 위해 사용됨.
- 어떤 유저가 어떤 레코드에 업데이트를 실행하면, 해당 레코드에는 락이 걸리고, 이 락이 풀어지기 전(이 전 유저의 커밋이 완료될 때 까지) 에는 다른 유저가 해당 레코드에 업데이트를 실행할 수 없음.
  - Shared, Exclusive lock..
  - 실질적으로 데이터베이스에서 해당 행에 락을 건다고 이해됨.

- 락이 걸려있을 테니, 충돌을 방지할 수 있음.
  - 트랜잭션 간 충돌을 예방할 수 있음.
  - 그렇지만 성능적으로는 별로 안 좋지 않을까? (락을 걸고, 확인하고 혹은 푸는 것 자체가 꽤 리소스가 소모되지 않을까 생각됨.)
  - 왜? 락을 걸고, 풀고, 혹은 다른 트랜잭션에서 해당 레코드에 락이 걸려있는 지 확인하는 작업이 필요할 테니..
- 위 첨부된 그림을 보면, Bob의 UPDATE 구문의 트랜잭션 락은, Alice 의 커밋이 완료되기 전까지는 획득할 수 없음.
  - 그런데 만약에 Alice가 commit이 어떤 이유에서 그런지 끝나지 않는다면..?
  - 일정 시간이 지나면 Dead Lock 같은게 발생하지 않을까?

> In JPA

- 3가지 LOCK MODE 타입을 제공하고 있음.
  1. PESSIMISTIC_READ
  - `shared lock` (s lock) 사용. 그래서 해당 row의 update or delete를 방지함.
  - `dirty read` 를 방지하기 위해서 사용함.
  2. PESSIMISTIC_WRITE
  - `exclusive lock` (x lock) 사용. read, update, deleted 모두 막음
  - 즉 read, update, delete action을 하기 위해서는 무조건 해당 락을 획득해야됨.
  - 단 어떤 데이터베이스는 해당 락을 사용하고 있어도, read 할 수 있도록 지원해주는 듯 (**MVCC**)
  3. PESSIMISTIC_FORCE_INCREMENT
  - `PESSIMISTIC_WRITE` 를 기반으로 entity의 version 필드를 이용해 버져닝 기능도 지원
  - `@Version` 사용
  - update 시에, 락 (x lock) 획득이 필요한 동시에, version 필드의 매칭도 필요함 (좀 더 안전한듯.)

- 발생할 수 있는 에러
  1. `PessimisticLockException`
  2. `LockTimeoutException`
  3. `PersistanceException`
  - *위 에러들은 현재 트랜잭션 상태를 rollback only 상태로 만들어놓음.*

- Lock Timeout 셋팅
  - `LockTimeoutException` 발생을 위해 설정이 필요한듯.
  - `javax.persistence.lock.timeout` 의 값을 이용하는 데, 단위는 **milliseconds**
  - 데이터베이스가 해당 셋팅을 지원하지 않는 경우도 있으니, 확인이 필요함.

- 정리하자면..
  - 여러 트랜잭션에서, 같은 리소스에서 같은 타임에 접근하지 않도록 데이터베이스 차원에서 락을 이용해서 해결하는 방법을 지원해줌.
  - 사용방법은 위에서 언급한 것과 비슷 (`Query`, 엔티티매니저...등등)
  - 데이터베이스의 락을 사용하니, deadlock이 발생할 수도 있겠고, 이러한 상황에 대처하기 위해서 `timeout` 설정이 필수적으로 보임.

## 추가적인 키워드

- Shared Lock, Exclusive Lock
- Isolation Level
- MVCC
- Dead Lock

## 참고

- <https://www.ibm.com/docs/en/rational-clearquest/7.1.0?topic=clearquest-optimistic-pessimistic-record-locking>
- <https://vladmihalcea.com/optimistic-vs-pessimistic-locking/>
- <https://www.baeldung.com/jpa-optimistic-locking>
- <https://www.baeldung.com/jpa-pessimistic-locking>
- <https://okky.kr/article/1023929>
- <https://velog.io/@wmpark90/JPA-%EB%82%99%EA%B4%80%EC%A0%81-%EB%9D%BD%EA%B3%BC-%EB%B9%84%EA%B4%80%EC%A0%81-%EB%9D%BD>
- <https://junhyunny.github.io/spring-boot/jpa/junit/jpa-optimistic-lock/>
- <https://junhyunny.github.io/spring-boot/jpa/junit/jpa-pessimitic-lock/>
- <http://wiki.gurubee.net/pages/viewpage.action?pageId=21200923>
