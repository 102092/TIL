# Index condition pushdown ?

## 들어가면서
- 쿼리 튜닝 도중 `extra` 란에 `Using index condition` 라 나옴을 확인.
- `Using index` 와는 어떻게 다른 것인지 정리.

## Using index condition 이란?

> 통칭 ICP

![](https://mariadb.com/kb/en/index-condition-pushdown/+image/index-access-2phases)
- disk-based storage engines 에서 기본적으로 인덱스를 통한 검색은 2단계로 이루어짐.
    1. 인덱스(B-tree)에서 매칭되는 records 를 추출하고,
    2. 추출된 records들이 가르키는 포인터를 따라서 table에서 실제 데이터를 읽게됨.
- 인덱스는 실제 데이터를 가지고 있는게 아니고, 실제 데이터가 저장된 포인터만을 가지고 있으므로.

![](https://mariadb.com/kb/en/index-condition-pushdown/+image/index-access-with-icp)
- `Index Condition Pushdown optimization` 이 적용되었다는 건, 1 -> 2번 과정 사이에 한가지 스텝이 추가되었다는 의미.
- 인덱스를 통해 도출된 records 를 기반으로, **적용할 수 있는 조건**을 적용 시켜서 물리적인 데이터에 접근하는 row 수를 최적화 하는 것.
    - 즉 index records 들이 filterd out 된다고 표현됨.
- 아마도 실제 table record에 접근하는 건, 상당한 비용을 소모하는 작업이기 때문에 이런 최적화 방식을 사용한다고 이해됨.

> MySQL 실행 구조를 기반으로 이해해보면..

![](https://t1.daumcdn.net/cfile/tistory/999E8C475E40139317)

- 추가적인 조건을 (적용할 수 있는 조건) 스토리지 엔진으로 전달해서,
- 스토리지 엔진에서는 인덱스를 기반한 레코드 추출 + 추가적인 조건을 기반한 필터링 을 하고,
- 이 결과(최대한 걸러낸 데이터) 를 가지고 실제 디스크, 메모리에 접근하도록 하는 것.
- 다시 말해, `index condition push down` 은 인덱스를 필터링할 조건 (condition) 이 스토리지 레벨까지 전달된다 (push down) 의미라고 의해됨.
    - *MySQL server pushes this part of the WHERE condition down to the storage engine..*
- MySQL 5.6 이상 부터는 이 조건이 기본적으로 `on` 되어있는듯.

--- 
```sql
select * from tbl where key_col1 between 10 and 11 and key_col2 like '%foo%';
```
- 예를 들어서, `key_col1` 에 인덱스가 걸려 있고, `index_condition_pushdown=on` 이라면 explain 결과는 아래와 같을 것.

```sql
+----+-------------+-------+-------+---------------+----------+---------+------+------+-----------------------+
| id | select_type | table | type  | possible_keys | key      | key_len | ref  | rows | Extra                 |
+----+-------------+-------+-------+---------------+----------+---------+------+------+-----------------------+
|  1 | SIMPLE      | tbl   | range | key_col1      | key_col1 | 5       | NULL |    2 | Using index condition |
+----+-------------+-------+-------+---------------+----------+---------+------+------+-----------------------+
```
- 이해해보자면, `where key_col1 between 10 and 11` 는 인덱스를 통해 추출되었고 (read matching index records)
- `and key_col2 like '%foo%'` 는 추출된 인덱스 레코드들을 기반으로 filterd out 되어서 (pushed index condition checks)
- 실행 계획의 extra 에 `Using index condition` 나오고 있는 것이라 이해됨.

## Using index 이란?

- 커버링 인덱스로 처리되었음을 의미. (covering index)
- 즉 인덱스를 통해서만, 원하는 데이터가 추출되었음.
- 속도적인 측면에서 굉장히 장점있음.





# 참고
- https://stackoverflow.com/questions/28759576/mysql-using-index-condition-vs-using-where-using-index
- https://jojoldu.tistory.com/474
- https://dev.mysql.com/doc/refman/5.7/en/index-condition-pushdown-optimization.html
- https://mariadb.com/kb/en/index-condition-pushdown/