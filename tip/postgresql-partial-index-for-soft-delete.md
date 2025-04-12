# PostgreSQL Partial Index로 soft delete 구현

## 내용
---
### 1. Partial Index란?

- Partial Index는 테이블의 특정 조건을 만족하는 행에만 적용되는 인덱스
- WHERE 절을 사용하여 인덱스에 포함될 행을 지정합니다.

### 2. Partial Index 사용하기

```sql
-- 활성 사용자 간에만 이메일 중복 방지
CREATE UNIQUE INDEX idx_unique_active_email ON users(email)
WHERE deleted_at IS NULL;
```

- 삭제된 사용자의 이메일은 재사용 가능
- 활성 사용자 간에는 이메일 중복 방지

### 3. 예시
#### 주문 관리 시스템

```sql
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    canceled_at TIMESTAMP NULL
);

-- 취소되지 않은 주문에 대한 인덱스
CREATE INDEX idx_active_orders ON orders(customer_id, created_at)
WHERE canceled_at IS NULL;
```

### 4. 주의사항

- 쿼리에 반드시 `deleted_at IS NULL` 조건 포함되어야 생성된 인덱스 활용됨
- ORM 사용 시 글로벌 스코프(`@Where...`)를 설정하여 자동으로 적용되는 방법도 적용 고려해보면 좋을듯.
	- 즉 누락될 수 있는 부분을 방지하는 목적

### 5. 요약

- Partial Index는 Soft Delete 패턴의 성능 문제를 효과적으로 해결
- 인덱스 크기 감소와 검색 성능 향상 동시에 가능
	- 필요한 데이터만 인덱스에 포함하므로..
- 유니크 제약조건과 함께 사용하면 삭제된 데이터의 값 재사용 가능

## 참고 
---
- [PostgreSQL 공식 문서: Partial Indexes](https://www.postgresql.org/docs/current/indexes-partial.html)
- [PostgreSQL Index Types](https://www.postgresql.org/docs/current/indexes-types.html)
- [Soft Delete Pattern in PostgreSQL](https://www.cybertec-postgresql.com/en/implementing-soft-delete-in-postgresql/)
