# What is the INCRBY ?

## Syntax
 - Time complexity: O(1)

```txt
...If the key does not exist, it is set to 0 before performing the operation
```
- 해당 키가 존재하지 않으면, `0` 으로 설정됨

## Examples
```shell
redis> SET mykey "10"
"OK"
redis> INCRBY mykey 5
(integer) 15
redis>
```

## Reference
- https://www.baeldung.com/java-redis-lettuce
- http://redis.io/commands/incrby
- https://redis.io/commands/incrby/