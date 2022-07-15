# Transaction Isolation
> the isolation level is the setting that fine-tunes the balance between performance and reliability, consistency, and reproducibility of results when multiple transactions are making changes and performing queries at the same time

- 트랜잭션 격리를 하는 이유는, 멀티 트랜잭션 환경에서 성능과 데이터 신뢰도 사이에서 균형을 찾기 위해서 등장한 것.
- 즉 어떤 부분에서는 성능보다는 데이터의 신뢰도가 중요할 수 있고, 어떤 부분에서는 신뢰도보다는 성능이 더 중요할 수 있음. 
- 격리 수준에 따라서, 문제점이 발생할 수 있는데 `Dirty Read`, `Non-Repeatable Read`, `Phantom Read` 이렇게 3가지임.
- MySQL에서는 트랜잭션 시작할 때, 세션의 트랜잭션 격리 수준을 설정해 줄 수 있음.
    - https://stackoverflow.com/questions/7937472/setting-transaction-isolation-level-of-mysql

## READ UNCOMMITTED

> SELECT statements are performed in a nonlocking fashion, but a possible earlier version of a row might be used
- nonlocking으로 진행되기 때문에, 성능상으로는 가장 이점이 있는듯.
- 그렇지만 이전 버젼의 row를 가져올 가능성도 있음.
- `Dirty Read`, `Non-Repeatable Read`, `Phantom Read` 발생 가능.

## READ COMMITTED

## REPEATABLE READ
- InnoDB의 기본 속성
- SELECT 실행 시, 그 시점으로 snapshot을 만들고,  그 이후에 다른 트랜잭션에서 오는 SELECT 오퍼레이션에 대해서는 생성된 snapshot을 기준으로 consistent read를 실행하게 됨.
    - T_A가 하나의 레코드에 대해 조회를 실행하고, T_B가 그 레코드에 대해 업데이트 - 커밋한 이후에, 아직 끝나지 않은 T_A가 동일한 레코드를 조회 할 경우에 T_B가 업데이트한 데이터 이 전 (snapshot에서 비롯된) 데이터를 조회할 수 있음.

- `Non-Repeatable Read`, `Phantom Read` 가 발생할 수 있음.
- 왜?

> This exception causes the following anomaly: If you update some rows in a table, a SELECT sees the latest version of the updated rows, but it might also see older versions of any rows. If other sessions simultaneously update the same table, the anomaly means that you might see the table in a state that never existed in the database.

- SELECT는 가장 최신 버젼의 row 의 snapshot을 가져오게 하는데, 이건 최신이 아닐 수도 있음. 이 전 버젼의 스냅샷일 수도 있다는 이야기인듯.
- 즉 동시적으로 여러 세션에서 하나의 테이블을 업데이트 친다고 하면, 실질적으로 가장 최신의 스냅샷이 아닐 수도 있다는 의미.
- 그래서 non-repeatable read 나, phantom read가 발생하는듯 

## SERIALIZABLE

# 격리 수준에 따른 문제 유형
![](https://3553248446-files.gitbook.io/~/files/v0/b/gitbook-legacy-files/o/assets%2F-M5HOStxvx-Jr0fqZhyW%2F-MGdOhx8aWkOCeHcri8Q%2F-MGdW-V-iOgKgGmSOVd7%2F%E1%84%80%E1%85%B3%E1%84%85%E1%85%B5%E1%86%B71.png?alt=media&token=0722018a-0d24-4586-9288-d9c306d2c263)


## Dirty Read
![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbgjwus%2FbtqKbV7Q7go%2FDwXX4Bgjl39Gu1FO78SkJk%2Fimg.png)
- 아직 커밋되지 않은 데이터(dirty..)를 읽는 것.
- Transaction_1에서 YKH 데이터를 아직 커밋하지 않았지만, Trasaction_2에서 select하면, 조회되는 현상을 의미.

## Non-Repeatable Read
![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FOAHDX%2FbtqJ8fZ5yJr%2FAKYMiEi3XQ7m71RasvPXF1%2Fimg.png)
- 하나의 트랜잭션 내에서 **하나의 row**를 반복되어 읽었을 때, 결과가 다르게 나오게 나오는 것을 의미.
- Transaction_2에서 id = 1의 값을 읽어보면 SABARADA가 나오지만, T_1에서 id = 1 에 대한 값을 YKH로 업데이트하고 커밋한 후에, 끝나지 않은 T_2에서 id = 1에 대해 다시 조회해 보면 YKH가 나온다.
- 즉 T_2 커밋 이전 T_1에서 조회한 값고, T_2 커밋 이후 T_1에서 조회된 값이 다르다.


## Phantom Read
![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FxunmZ%2FbtqJ0pJFsmi%2F2KhKRBkksKwyIOWbhaeVBk%2Fimg.png)
- 하나의 트랜잭션 내에서, 같은 쿼리를 반복적으로 실행했을 때, 첫번째에는 없었던 데이터가, 두번째에는 보이는 현상.
- `non-repeatable read` 는 한 개의 로우가 업데이트등의 액션으로 인하여 값이 변경되는 반면, 해당 현상은 보통 조회 쿼리에서 첫번째에는 보이지 않았던 row들이(1개 이상) 두번째에는 보이는 현상을 의미하는듯.
- T_1이 커밋되기 이 전에 T_2 내에서 진행한 첫번째 select 문은 1개의 row만 있지만, T_1 이 커밋된 이후, 끝나지 않은 T_2에서 같은 쿼리를 재실행 했을 경우엔 2개의 로우가 보인다.
    - 즉 id = 2 는 phantom value 인듯 하다.


# 참고
- https://en.wikipedia.org/wiki/Isolation_%28database_systems%29#Read_uncommitted
- https://mysqldba.tistory.com/334
- https://dev.mysql.com/doc/refman/5.7/en/innodb-transaction-isolation-levels.html
- https://sabarada.tistory.com/117
- https://jyeonth.tistory.com/32
- https://jupiny.com/2018/11/30/mysql-transaction-isolation-levels/#readcommitted
- https://taes-k.github.io/2020/05/17/mysql-transaction-lock/
- https://www.percona.com/blog/2021/02/11/various-types-of-innodb-transaction-isolation-levels-explained-using-terminal/