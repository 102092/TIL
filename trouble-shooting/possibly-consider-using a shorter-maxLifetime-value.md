#trouble-shooting 
# [HikariCP] Possibly consider using a shorter maxLifetime value

# 에러 로그

```textile
HikariPool-1 - Failed to validate connection com.mysql.jdbc.JDBC4Connection (No operations allowed after connection closed.). Possibly consider using a shorter maxLifetime value.
```

## 사용 버전

- MySQL 5.7, HikariCP 3.4.5

## 에러 메세지 해석

- `Failed to validate connection com.mysql.jdbc.JDBC4Connection`
- JDBC4Connection 객체를 validate 검증하는데 실패하였음.
- `No operations allowed after connection closed.`
- 커넥션이 종료된 후에는 어떠한 기능 수행이 허용되지 않음.
	- DB와의 커넥션을 이야기하는 듯.
- 즉 Connection Pool에서 어떤 Connection 객체를 validate 진행하는데 (Poolbase.isConnectionAlive),
	- `Possibly consider using a shorter maxLifetime value.`
	- `maxLifeTime` 값을 감소시키는 걸 고려하라

## 원인

- Database의 `wait_timeout`  값과, HikariCP에서 참고하는 `maxLifetime` 중 후자의 값이 더 크기 때문

## 분석

> Poolbase.isConnectionAlive

```java
   boolean isConnectionAlive(final Connection connection)
   {
      try {
         try {
            setNetworkTimeout(connection, validationTimeout);

            final int validationSeconds = (int) Math.max(1000L, validationTimeout) / 1000;

            if (isUseJdbc4Validation) {
               return connection.isValid(validationSeconds);
            }

            try (Statement statement = connection.createStatement()) {
               if (isNetworkTimeoutSupported != TRUE) {
                  setQueryTimeout(statement, validationSeconds);
               }

               statement.execute(config.getConnectionTestQuery());
            }
         }
         finally {
            setNetworkTimeout(connection, networkTimeout);

            if (isIsolateInternalQueries && !isAutoCommit) {
               connection.rollback();
            }
         }

         return true;
      }
      catch (Exception e) {
         lastConnectionFailure.set(e);
         logger.warn("{} - Failed to validate connection {} ({}). Possibly consider using a shorter maxLifetime value.",
                     poolName, connection, e.getMessage());
         return false;
      }
```

- Connection이 살아있는 지 확인해보는 메서드
- 여기서 에러를 발생함.
	- 어느 부분에서?
	- `setNetworkTimeout(connection, validationTimeout);` 혹은 `Statement statement = connection.createStatement()` 일수도..
- 아마 히카리 풀에 있는 커넥션을 통해 무언가를 하려고 (예를 들면 커넥션의 타임아웃설정..)을 하려 했으나, 이에 연결된 Database의 커넥션은 **이미** 닫혀서, `SQLException` 이 발생했을듯.
- 이 때문에 `warn` 로그가 최종적으로 찍히게 된듯.

## 해결

- Database 의 `wait_timeout`  보다 HikariCP의 `maxLifetime` 를 5초 더 짦게 주었음.
- 왜 5초?
	- 권장사항...
	- [HikariCP는 test-while-idle과 같은 커넥션 갱신 기능이 없을까? | 후덥의 기술블로그](https://pkgonan.github.io/2018/04/HikariCP-test-while-idle)

## HikariCP option

> 시간 단위는 `ms`

- **autoCommit**
  
  - auto-commit설정
  - <u>default: true</u>

- **connectionTimeout**
  
  - pool에서 커넥션을 얻어오기전까지 기다리는 최대 시간
  - 허용가능한 wait time을 초과하면 SQLException을 던짐.
  - 설정가능한 가장 작은 시간은 250ms
  - <u>default: 30000 (30s)</u>

- **idleTimeout**
  
  - pool에 일을 안하는 커넥션을 유지하는 시간
  - 이 옵션은 minimumIdle이 maximumPoolSize보다 작게 설정되어 있을 때만 설정.
  - pool에서 유지하는 최소 커넥션 수는 minimumIdle (A connection will never be retired as idle before this timeout.).
  - 최솟값은 10000ms
  - <u>default: 600000 (10minutes)</u>

- **maxLifetime**
  
  - 커넥션 풀에서 살아있을 수 있는 커넥션의 최대 수명시간.
  - 사용중인 커넥션은 maxLifetime에 상관없이 제거되지않음.
  - 사용중이지 않을 때, maxLifetime이 지나면 제거됨.
  - 풀 전체가아닌 커넥션 별로 적용 그 이유는 풀에서 대량으로 커넥션들이 제거되는 것을 방지하기 위함임.
  - 강력하게 설정해야하는 설정 값
  - 데이터베이스나 인프라의 적용된 connection time limit보다 작아야함.
  - 0으로 설정하면 infinite lifetime이 적용됨.
    - idleTimeout설정 값에 따라 적용
    - idleTimeout값이 설정되어 있을 경우 0으로 설정해도 무한 lifetime 적용 안됨).
  - <u>default: 1800000 (30minutes)</u>

- **connectionTestQuery**
  
  - JDBC4 드라이버를 지원한다면 이 옵션은 설정하지 않는 것을 추천
  - 이 옵션은 JDBC4를 지원안하는 드라이버를 위한 옵션임(Connection.isValid() API.)
  - 커넥션 pool에서 커넥션을 획득하기전에 살아있는 커넥션인지 확인하기 위해 valid 쿼리를 던지는데 사용되는 쿼리 (보통 SELECT 1 로 설정)
  - JDBC4드라이버를 지원하지않는 환경에서 이 값을 설정하지 않는다면 error레벨 로그를 뱉어냄.
  - <u>default: none</u>

- **minimumIdle**
  
  - 아무런 일을 하지않아도 적어도 이 옵션에 설정 값 size로 커넥션들을 유지해주는 설정.
  - 최적의 성능과 응답성을 요구한다면 이 값은 설정하지 않는게 좋음.
  - <u>default: same as maximumPoolSize</u>

- **maximumPoolSize**
  
  - pool에 유지시킬 수 있는 최대 커넥션 수.
  - pool의 커넥션 수가 옵션 값에 도달하게 되면 idle인 상태는 존재하지 않음.
  - <u>default: 10</u>

- **poolName**
  
  - 사용자가 pool의 이름을 지정함.
  - 로깅이나 JMX management console에 표시되는 이름.
  - <u>default: auto-generated</u>

- **initializationFailTimeout**
  
  - pool에서 커넥션을 초기화할 때 성공적으로 수행할 수 없을 경우 빠르게 실패하도록 해줌

- **readOnly**
  
  - pool에서 커넥션을 획득할 때 read-only 모드로 가져옴.
  - 단, 몇몇의 database는 read-only모드를 지원하지 않음.
  - 커넥션이 read-only로 설정되어있으면 몇몇의 쿼리들이 최적화 됨.
  - <u>default: false</u>

- **driverClassName**
  
  - jdbcUrl을 참조하여 자동으로 driver를 설정하려고 시도.
  - 하지만 몇몇의 오래된 driver들은 driverClassName을 명시화 해야함.
  - 어떤 에러 메시지가 명백하게 표시 되지않는다면 생략해도됨.

- **validationTimeout**
  
  - valid 쿼리를 통해 커넥션이 유효한지 검사할 때 사용되는 timeout.
  - 250ms가 설정될 수 있는 최솟값
  - <u>default: 5000ms</u>

- **leakDetectionThreshold**
  
  - 커넥션이 누수 로그메시지가 나오기 전에 커넥션을 검사하여 pool에서 커넥션을 내보낼 수 있는 시간.
  - 0으로 설정하면 leak detection을 이용하지않음.
  - 최솟값 2000ms
  - <u>default: 0</u>

## 참고

- [[HikariCP] Possibly consider using a shorter maxLifetime value :: Hello World](https://hello-world.kr/33)
- [HikariCP Failed to Validate Connection Warning 이야기 | Carrey`s 기술블로그](https://jaehun2841.github.io/2020/01/08/2020-01-08-hikari-pool-validate-connection/#hikari-pool-failed-to-validate-connection)
- [java - Possibly consider using a shorter maxLifetime value - hikari connection pool spring boot - Stack Overflow](https://stackoverflow.com/questions/60310858/possibly-consider-using-a-shorter-maxlifetime-value-hikari-connection-pool-spr)
- [MySQL :: MySQL 5.7 Reference Manual :: 5.1.7 Server System Variables](https://dev.mysql.com/doc/refman/5.7/en/server-system-variables.html#sysvar_wait_timeout)
- [GitHub - brettwooldridge/HikariCP: 光 HikariCP・A solid, high-performance, JDBC connection pool at last.](https://github.com/brettwooldridge/HikariCP#configuration-knobs-baby)
- [HikariCP 세팅시 옵션 설명](https://effectivesquid.tistory.com/entry/HikariCP-%EC%84%B8%ED%8C%85%EC%8B%9C-%EC%98%B5%EC%85%98-%EC%84%A4%EB%AA%85)
