## 내용
- `IN` 절을 사용할 때 성능 최적화와 관련된 설정
- `hibernate.query.in_clause_parameter_padding=true` 로 설정하면 Hibernate는 `IN` 절의 파라미터 갯수를 2의 거읍제곱으로 padding 한다.
	- 1-2개 → 2개로 패딩
	- 3-4개 → 4개로 패딩
	- 5-8개 → 8개로 패딩
	- 9-16개 → 16개로 패딩

### 왜 사용할까?
- 데이터베이스는 `IN` 을 이용한 쿼리 시, 파라미터 갯수가 다르면 매번 새로운 실행계획을 만들고, 캐시해야함
	- 왜?
	- 파라미터 갯수가 다르면 다른 쿼리로 인식하기 때문
- 이를 방지 하기 위해서 `hibernate.query.in_clause_parameter_padding=true` 옵션을 사용하면, 비슷한 `IN` 절 쿼리 끼리 같은 실행 계획을 공유할 수 있음.
	- 그러므로 매번 실행계획을 생성하지 않아도 되므로, 데이터베이스의 부하가 감소

### 주의할 점
- 반드시 성능 향상이 일어나는 것은 아님.
- 메모리 사용량이 증가할 수도 있음.
	- padding 으로 부족한 갯수만큼 채우므로, 이 부분 메모리 사용 추가됨
	- binding 변수를 위한 추가 메모리도 필요하고.
	- 이를 제어하기 위해서 `hibernate.query.in_clause_parameter_padding_max_size` 옵션도 존재함.
		- 특정 크기 이상에서는 패딩을 하지 않도록 설정하는 방법

## 사용 예시
```java
// OrderService.java
@Service
public class OrderService {
    @Transactional
    public List<Order> getOrdersByUserIds(List<Long> userIds) {
        return orderRepository.findByUserIdIn(userIds);
    }
}
```

> `hibernate.query.in_clause_parameter_padding=false` 라면..

```java
// 1번째 요청: 3명의 사용자 주문 조회
getOrdersByUserIds(Arrays.asList(1L, 2L, 3L))
// 생성되는 SQL: SELECT * FROM orders WHERE user_id IN (?, ?, ?)

// 2번째 요청: 4명의 사용자 주문 조회
getOrdersByUserIds(Arrays.asList(4L, 5L, 6L, 7L))
// 생성되는 SQL: SELECT * FROM orders WHERE user_id IN (?, ?, ?, ?)

// 3번째 요청: 2명의 사용자 주문 조회
getOrdersByUserIds(Arrays.asList(8L, 9L))
// 생성되는 SQL: SELECT * FROM orders WHERE user_id IN (?, ?)
```

- 3개 파라미터용 실행 계획 생성 및 저장 
- 4개 파라미터용 실행 계획 생성 및 저장 
- 2개 파라미터용 실행 계획 생성 및 저장
- 즉 같은 테이블을 조회하지만 3개의 실행 계획이 생성됨.
	- 그러므로 메모리 사용증가
		- SQL 파싱 -> 실행계획 생성 -> 실행계획 저장...

> `hibernate.query.in_clause_parameter_padding=true` 사용하면..

```java
// 1번째 요청: 3명 조회 → 4개로 패딩
// SQL: SELECT * FROM orders WHERE user_id IN (?, ?, ?, ?)

// 2번째 요청: 4명 조회 → 4개로 패딩 (동일한 실행 계획 재사용!)
// SQL: SELECT * FROM orders WHERE user_id IN (?, ?, ?, ?)

// 3번째 요청: 2명 조회 → 2개로 패딩
// SQL: SELECT * FROM orders WHERE user_id IN (?, ?)
```

- 실행 계획은 2개만 저장 (2,4)
- 동일한 실행계획 재사용
- 더 적은 실행계획으로 DB의 부하 감소
## 결론
- `IN` 쿼리에 따라 생기는 실행계획 생성 등으로 인한 데이터베이스 부하를 막기위해 사용하는 옵션
- 반드시 성능향상을 보이는 것은 아니고, 이로 인한 trade-off (메모리 사용량 증가)

## 참고
- https://www.baeldung.com/java-hibernate-in-clause-padding
- https://medium.com/@im_zero/hibernate-query-plan-cache-oom-%EC%97%90%EB%9F%AC-%ED%95%B4%EA%B2%B0-298f3feae93a
- https://hyos-dev-log.tistory.com/29