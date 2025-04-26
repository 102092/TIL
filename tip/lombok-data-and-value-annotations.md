#java #lombok #tip

## Lombok의 @Data와 @Value 어노테이션
---
### 1. Lombok이란?

- Lombok은 Java 코드에서 반복적으로 작성해야 하는 보일러플레이트 코드(getter, setter, toString 등)를 줄여주는 라이브러리
- 컴파일 시점에 어노테이션을 기반으로 필요한 코드를 자동 생성

### 2. @Data 어노테이션

#### 2.1 개요
- `@Data`는 다음 어노테이션들이 합쳐진 복합 어노테이션
	- `@Getter`: 모든 필드에 대한 getter 메서드 생성
	- `@Setter`: 모든 non-final 필드에 대한 setter 메서드 생성
	- `@ToString`: toString() 메서드 생성
	- `@EqualsAndHashCode`: equals()와 hashCode() 메서드 생성
	- `@RequiredArgsConstructor`: 필수 필드(final, @NonNull)만 파라미터로 받는 생성자 생성

#### 2.2 예시
```java
import lombok.Data;

@Data
public class User {
    private final Long id;          // final이므로 setter가 생성되지 않음
    private String username;
    private String email;
    private boolean active;
}
```

#### 2.3 주의사항
- **순환 참조**
	- `toString()`이나 `equals()`/`hashCode()`에서 다른 객체를 참조하면 무한 재귀가 발생할 수 있음.
	- 이 경우 `@ToString.Exclude`나 `@EqualsAndHashCode.Exclude` 사용
- **상속 관계**
	- `equals()`와 `hashCode()`가 상속 관계에서 문제 발생 가능

### 3. @Value 어노테이션

#### 3.1 개요
- `@Value`는 불변(immutable) 객체를 생성하기 위한 어노테이션
	- 클래스를 자동으로 `final`로 만듦
	- 모든 필드를 자동으로 `private final`로 만듦
	- `@Getter` 적용
	- `@ToString` 적용
	- `@EqualsAndHashCode` 적용
	- `@AllArgsConstructor` 적용 (모든 필드를 초기화하는 생성자 생성)
	- Setter 메서드는 생성하지 않음

#### 3.2 예시
```java
import lombok.Value;

@Value
public class ImmutableUser {
    Long id;              // 자동으로 private final이 됨
    String username;
    String email;
    boolean active;
}
```

#### 3.3 주의사항
- **컬렉션의 불변성**
	- 내부 컬렉션이나 가변 객체가 있는 경우 해당 객체의 불변성은 보장되지 않음. 
	- 추가적인 방어적 복사 필요
- **상속 불가**
	- 클래스가 final이므로 상속이 불가능함

### 4. @Data와 @Value의 핵심 차이점

| 특성        | @Data                    | @Value              |
| --------- | ------------------------ | ------------------- |
| 객체 타입     | 가변(mutable)              | 불변(immutable)       |
| 클래스 final | 아니오                      | 예                   |
| 필드 final  | 명시적으로만                   | 모든 필드 자동            |
| Setter    | non-final 필드에 생성         | 생성 안 함              |
| 생성자       | @RequiredArgsConstructor | @AllArgsConstructor |
| 상속        | 가능                       | 불가능                 |

### 5. @Data 사용을 지양해야 하는 이유와 대안

#### 지양해야 하는 이유
- 무분별한 Setter 생성으로 객체 무결성 위험
- 객체지향 설계 원칙 침해 가능성
- 모든 필드에 일괄 정책 적용으로 개별 필드 제어 어려움

#### 대안
1. **선별적 어노테이션 조합**
```java
@Getter
@ToString
@EqualsAndHashCode
public class Product {
    private final Long id;
    private String name;
    
    // 필요한 setter만 명시적 구현
    public void updateName(String name) {
        this.name = name;
    }
}
```

2. **Builder 패턴 활용**
```java
@Getter
@Builder
public class Order {
    private final Long id;
    private OrderStatus status;
    
    // 상태 변경을 위한 명시적 메서드
    public void markAsProcessed() {
        this.status = OrderStatus.PROCESSED;
    }
}
```

3. **DTO는 @Value 사용**
```java
@Value
public class ProductDTO {
    Long id;
    String name;
    double price;
}
```

### 6. 참고
---
- https://projectlombok.org/features/Data
- https://projectlombok.org/features/Value
- https://www.baeldung.com/lombok-data-annotation
- https://www.javaquery.com/2020/10/lombok-data-vs-value-annotation.html
