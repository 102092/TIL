# 정의
> a type of database lock that allows multiple transactions to read the same data concurrently

- 공유 잠금
    - 공유되는 락을 의미하는 듯?
- 읽기 잠금 (read lock) 
- 서로 다른 [[transaction]] 에서 동시에 읽는 것은 허용하함

## 특징
> When a transaction acquires a shared lock on a piece of data, it prevents other transactions from acquiring an exclusive lock on that data. However, other transactions can still acquire shared locks on the same data

- 한 자원에 여러 개의 (shard lock)가 존재 가능하다.
- 어떤 자원에 한 개이상의 shared lock이 존재한다면, 해당 자원에 대한 [[exclusive-lock]] 을 획득할 수 없음을 의미

> Shared locks can also be used to implement read consistency, which is a database property that ensures that all transactions always see the latest data

- read - [[consistency]] 를 보장하기 위해 사용됨.

> Shared locks are often used to implement optimistic locking, which is a concurrency control strategy that allows transactions to proceed without any locking until they attempt to commit their changes

- [[optimistic-lock]] 을 구현하는 데 사용됨.
	- 즉 [[concurrency]] 로 생기는 문제를 막기 위해서 사용됨.

## 예시
```sql
-- 고객 정보 테이블에서 `id`가 1인 행을 읽습니다.
SELECT * FROM customers
WHERE id = 1;
```


---
## 참고
- https://stackoverflow.com/questions/11837428/whats-the-difference-between-an-exclusive-lock-and-a-shared-lock
- https://www.geeksforgeeks.org/difference-between-shared-lock-and-exclusive-lock/
- https://jeong-pro.tistory.com/94
- http://www.myreadingroom.co.in/notes-and-studymaterial/65-dbms/538-types-of-locks.html#:~:text=An%20exclusive%20lock%20exists%20when,basis%20of%20a%20common%20lock.