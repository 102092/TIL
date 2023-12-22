## Overview
- `only a table-level` lock (table level의 락만을 지원함.)
  - 많은 변화가 있는 데이터베이스 에는 부적절.
  - 왜? 변화가 필요할 때 마다 table lock이 걸릴테니.
  - `The table locking method is helpful for read-only databases as it doesn’t require a lot of memory.`
- 트랜잭션, 외래키, 테이블간 관계 지원하지 않음.
- FULL TEXT Search 를 지원.
- SELECT가 많은 서비스에 권장됨.

## Reference
- <https://ojava.tistory.com/25>
- <https://velog.io/@gillog/DBInnoDB-VS-MyISAM>
- <https://hevodata.com/learn/myisam-vs-innodb/#:~:text=MyISAM%20is%20a%20non%2Dtransactional,if%20they%20are%20not%20completed>
- https://www.mongodb.com/docs/manual/core/storage-engines/