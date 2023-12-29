## 들어가면서

- 스프링에서 트랜잭션은 `@Transactional` 을 선언하면 적용
- 해당 기능은 AOP를 통해 구현.
  - AOP가 적용되었는 지 확인하기 위해서는 `.getClass()` 를 통해클래스 이름을 확인해도 됨. (`$$SpringCGLIB...`)
  - 혹은 `AopUtils` 라는 클래스에서 제공하는 메서드를 통해 확인해볼 수 도 있음.
  - 그리고 `public` 메서드에만 적용이 가능. (`private`, `protected`, `package-visible` 엔 적용이 안됨.)
    - `protected`, `package-visible` 의 경우 외부에서 호출은 가능하나, 스프링 자체에서 적용되지 않도록 막고 있음.
- 스프링에서 트랜잭션에 대한 관리는 `TransactionSynchronizationManager` 에서 관리.
  - `ThreadLocal`이라, 각 스레드 별로 관리된다고 보여짐.

## @Transactional 옵션에서의 우선순위?

- 스프링에서 우선 순위?
  - 항상 더 **구체적으로 자세한 것이 더 높은 우선 순위**를 가짐.
  - 클래스 vs 메서드 -> 메서드
  - 인터페이스 vs 클래스(인터페이스를 구현한) -> 클래스 (더 자세한 것이므로)

```java
@Transactional(readOnly = true)
    static class LevelService {

        @Transactional(readOnly = false)
        public void write() {
            log.info("call write");
        }
    }

```

- 이와 같이 선언되어있을 때, 프록시가 적용된 LevelSerivce#write를 호출 하면, readOnly 옵션이 false로 적용되어서 실행됨.
- 왜? 더 구체적인 것(메서드) 에 적용된 옵션이 먼저 적용되기 때문에

## @Transactional with Interface

- 인터페이스에 트랜잭션을 적용하는 방법은 스프링에서 권장하지 않는 방법.
- 왜?
  - AOP를 적용하는 방식에 따라, 인터페이스에 사용했을 경우 AOP가 의도한 대로 동작하지 않을 수 있음.
  - 즉 인터페이스 기반 프록시를 사용하는 경우에만, 적용할 수 있는 방법
- 인터페이스 기반 프록시 vs 클래스 기반 프록시
  - JDK Dynamic proxy vs CGLIB
  - 아마도 Spring 기본 AOP 적용 기술이 CGLIB 즉 클래스 기반이므로, 문제가 발생할 수 있어서 이렇게 권장하는 듯
- [참고](https://medium.com/webeveloper/transactional-%EC%9D%80-%EC%96%B4%EB%8A%90-layer-%EC%97%90-%EB%91%90%EB%8A%94%EA%B2%8C-%EB%A7%9E%EC%9D%84%EA%B9%8C-807f50610f0b)

## @Transactional 사용하면서, 발생할 수 있는 문제점

### 내부 호출

```java

@Service
class CallService {

    public void external() {
        log.info("call external");
        internal();
}
    @Transactional
    public void internal() {
        log.info("call internal");
        printTxInfo();
    }

    private void printTxInfo() {
              boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
              log.info("tx active={}", txActive);
    }
}

```

- Controller에서 CallService#external (프록시 적용된 객체를 거쳐서) 를 호출 한다고 가정.
- 그러면 external 에서, internal() 이 호출 될 것.
- 이럴 때 `@Transactional` 이 적용 될까? (txActive = true?)
- 안된다.
- 왜?
  - Proxy 객체를 거쳐서 호출되는 것이 아니기 때문에, `@Transactional` 이 붙어있어도 아무런 기능을 하지 못함.
  - 즉 AOP가 적용되지 않음.
- 정리하자면 Spring에서 AOP가 동작하는 방식 때문에 발생할 수 있는 문제임.
- 해결은 `internal()` 로 호출되는 부분을 **다른 클래스로 분리**하여 AOP가 적용된 상태로 호출되도록 수정하면 됨.

### @PostContruct 와 @Transactional을 같이 사용할 경우, 트랜잭션이 적용되지 않는 문제

- 스프링 빈 라이프 사이클
     1. 스프링 컨테이너 생성
     2. 스프링 빈 생성
     3. 의존관계주입
     4. 초기화 콜백사용 @PostConstruct
     5. 빈 사용
     6. 소멸전 콜백 @PreDestro
- 라이프 사이클로 미루어보아, 4번에서 `@PostContruct` 실행함.
- 4번에서 `@Transactional` 에 대한 프록시 빈이 스프링 컨테이너에 모두 적용되었다고 보장할 수 없을듯
  - `@Transactional` 을 먼저 순서가 상단에 있어도.. 안될듯.
- BeanPostProcessor는 3~5번 사이에 동작하므로.
- 해결?

```java
  @EventListener(value = ApplicationReadyEvent.class)
  @Transactional
  public void init2() {
      log.info("Hello init ApplicationReadyEvent");
  }
```

- `@EventListener(value = ApplicationReadyEvent.class)` 이용하여 애플리케이션이 모두 올라왔을 때, 호출되도록.

## @Transaciotnal 옵션

- 참고
  - <https://www.baeldung.com/spring-transactions-read-only>

## 트랜잭션 예외, 롤백

- unchecked exception (Runtime exception, Error) 발생 시, 롤백함.
- checked exeception (Exception) 발생 시, 트랜잭션 커밋.

- 로그 옵션을 통해, 해당 트랜잭션 진행에 대한 로그를 모두 확인할 수 있음.

```properties
logging.level.org.springframework.transaction.interceptor=TRACE
logging.level.org.springframework.jdbc.datasource.DataSourceTransactionManager=DEBUG

#JPA log
logging.level.org.springframework.orm.jpa.JpaTransactionManager=DEBUG
logging.level.org.hibernate.resource.transaction=DEBUG

#JPA SQL
logging.level.org.hibernate.SQL=DEBUG
```

- 왜 언체크 예외는 롤백, 체크 예외는 커밋?
  - 체크 예외는 비즈니스 예외가 있음.
    - 비즈니스 예외? 시스템적 예외는 아니지만, 예외가 발생 (잔고 부족 같은)
    - 그래서 롤백까진 하지 않아도 될때.
    - 예를 들어, 만약 롤백해버리면 고객이 주문한 주문 정보까지 없어지는 일이 발생. (불필요한..)
  - 언체크 예외는 복구 불가능하므로, 던저셔 사용자가 알게해야함. *시스템 예외 예를 들면 네트워크 이슈..*

## 중첩된 트랜잭션에서의 커밋과 롤백

> 트랜잭션 전파는 기본 값임 (required)

- 트랜잭션 진행 중에, 그 트랜잭션이 아직 끝나지 않았는(커밋, 롤백) 데 그 내부에서 또다른 트랜잭션이 생성된다면, 외, 내부 트랜잭션 모두 하나의 트랜잭션으로 여겨짐 (스프링 기본 방식)
  - 트랜잭션 진행 시에, 또 다른 트랜잭션을 생성한다면..
  - 하나의 물리적인 트랜잭션이 존재하며, 그 안에는 논리적 트랜잭션이 2개 있다고 볼 수 있음.
  - 즉 물리 트랜잭션 = 논리 트랜잭션 + 논리 트랜잭션
- 이 하나의 트랜잭션으로 묶이는 건 물리적으로 즉 데이터베이스 동작을 이야기 하는 것.
- 롤백 전략?
  - 논리 트랜잭션 중 **하나라도 롤백**된다면, 물리적 트랜잭션은 롤백됨.
  - 즉 논리 트랜잭션들 모두가 문제 없이 커밋 되어야, 물리적 트랜잭션이 커밋된다는 이야기 이고, 물리적 트랜잭션이 커밋된다는 건 그떄서야 데이터베이스에 커밋이 된다는 이야기

- 트랜잭션 실행 시에, 현재 상태를 확인 (TransactionSynchronizationManager를 통해) 현재 진행되고 있는 트랜잭션이 있는 지 확인 한다음에, 있으면 해당 트랜잭션을 이용하도록 함.
  - 해당 트랜잭션에 참여한다? == 아무것도 안한다는 뜻.
  - 물리커넥션을 획득하거나.. 이런 일련의 작업을 하지 안한다는 뜻.

- 하나의 물리적 트랜잭션이 있고, 2개의 논리적 트랜잭션이 있다고 가정하자.
  - 외부 트랜잭션(먼저 시작한 트랜잭션) 은 정상적으로 커밋되었는데, 내부 트랜잭션(나중에 시작한)이 롤백된다면?
  - 결과적으로 물리적 트랜잭션은 롤백될 것이고.
  - 내부 트랜잭션에서 롤백되었을 때, **트랜잭션의 속성값(rollback-only)** 변경하여, 외부 트랜잭션이 커밋 전에 해당 속성값을 체크하는데 (커밋해도 될지), 이 값이 `true`이기 때문에, 롤백된다.
  - 트랜잭션 매니저는 신규 트랜잭션인지 아닌지 여부에 따라, 진짜 물리적으로 롤백 할지, 아니면 전역 트랜잭션에 마크만 할지 결정함.

- 정리하자면, 내부 트랜잭션이 롤백되면, 물리적 트랜잭션을 롤백하진 않음. 그 대신에 `rollback-only = true` 에 마크함.
  - 그래서 외부 트랜잭션이 커밋하기 전에, 해당 값을 보고, 롤백해야 말지 판단. 마크 되어있다면 물리적 트랜잭션을 롤백하게 됨.
  - 그리고 `UnexpectedRollbackException` 예외를 던짐.

## 트랜잭션 전파

### REQUIRED

- 기본
  - 가장 많이 사용함.
- 기존 트랜잭션 있으면, 참여함.
- 기존 트랜잭션 없으면 생성함.

### REQUIRED_NEW

- 항상 새로운 트랜잭션을 생성하는 옵션
- 기존 트랜잭션 있으면, 새로 생성.
- 기존 트랜잭션 없으면, 새로 생성.
  - 즉 외부, 내부를 완전히 분리해서 사용하는 방법. 즉 물리적으로 완전히 분리하는 방법임.
- 해당 옵션의 트랜잭션이 호출되는 시점에, 커넥션 풀에 커넥션이 부족하면.. 데드락이 걸릴 가능성 있음.
  - timeout이 있기 때문에, 어느 시점에서는 롤백되겠지만..
- [응? 이게 왜 롤백되는거지?](https://techblog.woowahan.com/2606/) 추가적으로 읽어봐야할 것.

### SUPPORT

### NOT_SUPPORT

### MANDATORY

### NEVER

### NESTED

- 기존 트랜잭션이 없으면, 새로운 트랜잭션 생성.
- 기존 트랜잭션이 있으면, *중첩 트랜잭션*을 생성
- 중첩 트랜잭션 ?
  - 이 트랜잭션은 외부 트랜잭션의 영향을 받지만, 이 트랜잭션이 외부 트랜잭션에 영향을 주진 않음.
  - e.g 외부 트랜잭션 롤백 -> 중첩 트랜잭션 롤백, 중첩 트랜잭션 롤백 -> 외부 트랜잭션 커밋 가능

## 트랜잭션 전파, 옵션의 적용

- `isolation`, `timeout`, `readOnly` 등의 옵션을 트랜잭션이 새로 시작할 때만 적용됨.
- e.g `REQUIRED` 에서 기존 트랜잭션이 없고, 새로운 트랜잭션을 시작할 때 적용, 참여할 때는 해당 트랜잭션에 옵션이 있어도 적용이 안된다. (외부 트랜잭션 옵션이 적용됨.)

## 참고

- <https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-db-2/>
