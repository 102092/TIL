## Overview
- `general-purpose storage engine that balances high reliability and high performance` 
	- 성능과 신뢰도를 모두 잡은 엔진이다!
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

## Reference
- https://dev.mysql.com/doc/refman/5.7/en/innodb-introduction.html