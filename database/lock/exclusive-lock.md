# 정의
> A kind of **lock** that prevents any other **transaction** from locking the same row

- 배타적인 잠금
	- 쓰기 잠금(write lock)
- 데이터를 변경하고자 할 때, 해당 [[transaction]] 이 마무리되기 전까지 다른 트랜잭션에서 **읽거나, 쓰지** 못하도록 하기 위해 사용하는 락

## 목적

> The exclusive lock must be used when the potential for conflict exists

- 잠재적으로 충돌이 일어날 것이라고 생각되는 부분에 사용함.

## 특징
> Depending on the transaction **isolation level**, this kind of lock might block other transactions from writing to the same row, or might also block other transactions from reading the same row

- [[isolation-level]] 에 따라서, 다른 [[transaction]] 들에서 해당 row(락이 걸린) `writing` 를 막을 수도 있고 혹은 `reading` 를 막을 수도 있음

## 예시
```sql
-- 고객 정보 테이블에서 `id`가 1인 행을 업데이트합니다.
UPDATE customers
SET name = 'John Doe'
WHERE id = 1;
```
- 해당 [[transaction]] 은  `id = 1`  [[row]] 에 대해 `exclusive lock` 을 획득함

---
## 참고
- https://www.geeksforgeeks.org/difference-between-shared-lock-and-exclusive-lock/
- https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_exclusive_lock