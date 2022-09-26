# InnoDB vs MyISAM

## InnoDB

- `general-purpose storage engine that balances high reliability and high performance` (성능과 신뢰도를 모두 잡은 엔진이다!)
- MySQL 5.7 부터는 기본엔진이고, 직접적으로 어떤 엔진을 쓸지 명시하지 않는 한, `CREATE TABLE` 이라는 명령어 사용하면 기본적으로 InnoDB table로 생성됨.

### Key Advantages of InnoDB

- DML(Data manipulation language) 기능은 [ACID](https://en.wikipedia.org/wiki/ACID)를 보장.
  - transaction, commit, rollback, crash-recovery 기능을 제공.
- Row level locking, consistent reads increase multi-user concurrency (여러 유저가 동시에 읽어도, 일관성 있는 읽기를 보장함.)
- PK(primary key) 를 기반으로 디스크에 저장되는 데이터를 최적화함.
  - 각각의 InnoDB로 구성된 테이블에는 pk를 가지고 있는데 이는 clustered index라 불림.
  - 이러한 인덱스를 통해, I/O를 최적화함.
- 데이터의 무결성을 유지하기 위해 Foreign key(FK) 제약 조건을 제공.
  - FK를 통해 테이블간 데이터 불일치를 방지함.

## MyISAM

- `only a table-level` lock (table level의 락만을 지원함.)
  - 많은 변화가 있는 데이터베이스 에는 부적절.
  - 왜? 변화가 필요할 때 마다 table lock이 걸릴테니.
  - `The table locking method is helpful for read-only databases as it doesn’t require a lot of memory.`
- 트랜잭션, 외래키, 테이블간 관계 지원하지 않음.
- FULL TEXT Search 를 지원.
- SELECT가 많은 서비스에 권장됨.

## 공통점

- storage engine 임.
  - storage engine ?
  - `the component of the database that is responsible for managing how data is stored, both in memory and on disk`
  - 즉 데이터가 메모리와 디스크에 어떻게 저장되는 지 책임을 맡고 있는 요소.
  - InnoDB라는 형식의 데이터 저장 방식이 있는 거로, MyISAM이라는 데이터 저장 방식이 있는 것.

## 참고

- <https://ojava.tistory.com/25>
- <https://velog.io/@gillog/DBInnoDB-VS-MyISAM>
- <https://hevodata.com/learn/myisam-vs-innodb/#:~:text=MyISAM%20is%20a%20non%2Dtransactional,if%20they%20are%20not%20completed>
- <https://dev.mysql.com/doc/refman/5.7/en/innodb-introduction.html>
- <https://www.mongodb.com/docs/manual/core/storage-engines/>
