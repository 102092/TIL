# shared lock
- 공유 잠금
    - 공유되는 락을 의미하는 듯?
    - 읽기 잠금 (read lock), 즉 서로 다른 세션에서 읽는 것은 허용하되, 변경은 불가능하도록 거는 락인듯.
- 한 자원에 여러 개의 (shard lock)가 존재 가능하다.
- 어떤 자원에 한 개이상의 shared lock이 존재한다면, 해당 자원에 대한 exclusive lock을 획득할 수 없다.


# exclusive lock
- 배타적인 잠금, 쓰기 잠금(write lock)
- 데이터를 변경하고자 할 때, 해당 트랜잭션이 마무리되기 전까지 다른 트랜잭션에서 **읽거나, 쓰지** 못하도록 하기 위해 사용하는 락.
    - 이 락이 걸려있으면, 다른 트랜잭션에서 읽을 수도 없고, 쓸 수도 없음. 
- 어떤 table, row에 해당 락이 걸려 있으면, 다른 트랜잭션에서 exclusive lock을 걸 수 없음.
    - 또한 shared lock도 걸 수 없음.
    - 왜? 해당 락이 걸려 있으면, 다른 트랜잭션에서 *읽거나, 쓰는* 작업을 모두 할 수 없기 때문에


# why do shared, exclusive lock exist?
- 멀티 트랜잭션 환경 데이터베이스에서, 데이터의 일관성과 무결성을 보장하기 위해서
- 즉 트랜잭션 간의 순차적 진행을 보장 시키기 위해서

> The exclusive lock must be used when the potential for conflict exists

- 배타적 잠금의 경우, 잠재적으로 충돌이 일어날 것이라고 생각되는 부분에 사용함.

> A shared lock exists when concurrent transactions are granted read access on the basis of a common lock
> A shared lock produces no conflict as long as all the concurrent transactions are read-only

- 공유 잠금의 경우, 동시적 트랜잭션이 읽기 권한을 보장하기 위해서 사용하고.
- 그리고 동시적 트랜잭션들이 모두 read-only 라면, 어떠한 충돌도 발생시키지 않음.

# 정리하자면..

> a lock can have three states: unlocked, shared (read), and exclusive (write)

- 락이란 개념은 3가지의 상태를 가지는 데, unlocked, shared, exclusive임.
- unlocked은 말 그대로 아무런 락을 가지고 있지 않은 상태를 의미하고,
- shared는 공유 잠금이 걸려있음.
    - 즉 읽기 트랜잭션이 해당 데이터에 대해 접근할 때, 이 락을 사용하고.
    - 이 락이 걸려있는 데이터는 또다른 shared lock을 걸 순 있지만, exclusive lock를 걸 순 없음.
- exclusive의 경우 배타적 잠금.
    - 그러니까 이 락 빼고, 다른 락들을 허용하지 않겠다는 락임 (이 락이 걸려있다면 또다른 exclusive lock을 걸거나 shared lock을 걸 순 없음.)
    - 그래서 보통 데이터를 update... 할 때 사용함.

- 이렇게 락의 상태를 나눠서 관리하는 이유는, concurrent transaction 이 존재하고, 이러한 트랜잭션 간의 데이터의 정합성을 보장하기 위해서가 아닐까 생각함.


# 참고
- https://stackoverflow.com/questions/11837428/whats-the-difference-between-an-exclusive-lock-and-a-shared-lock
- https://www.geeksforgeeks.org/difference-between-shared-lock-and-exclusive-lock/
- https://jeong-pro.tistory.com/94
- http://www.myreadingroom.co.in/notes-and-studymaterial/65-dbms/538-types-of-locks.html#:~:text=An%20exclusive%20lock%20exists%20when,basis%20of%20a%20common%20lock.

