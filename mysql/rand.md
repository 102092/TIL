## default 

```sql
select * from boomarks
order by rand()
limit 10;
```
- using [rand()](https://aodba.com/mysql-rand-function/)


> mysql 8.0 이상

## option 1

```sql
set @max = (select max(id) from brand_news);  
set @randid = ROUND((RAND() * (@max -1)) + 1);  
  
with recursive ids as (  
    select 1 as n, ROUND((RAND() * (@max -1)) + 1) as rand  
    union all  
    select n + 1, ROUND((RAND() * (@max -1)) + 1) from ids where n < 1000
)  
  
select * from bookmarks where id in (select rand from ids) limit 10
```

## option 2

```sql
select id from brand_news  
order by rand()  
limit 10;
```
- better than `*`

## option 3

```sql
select *  
from bookmarks  
         inner join (select id from bookmarks where user_id = 1 order by rand() limit 10) as tmp  
                    on tmp.id = bookmarks.id
```
- better than `*`
- inner join에 사용되는 subquery에 인덱스가 걸려있다면 조금 더 최적화 할 수 있음.

## option4
```sql
select *  
from bookmarks  
         inner join (
         select id 
         from bookmarks
	  .  where hash like '9%' or hash like 'b%'
	  .  order by
         rand() limit 10) as tmp  
                    on tmp.id = bookmarks.id
```

- purely random but not completely random
- alter column automated created hash 
- sudo random

## reference
- https://www.youtube.com/watch?v=wTcpZWPHl6w