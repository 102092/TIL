# How to prevent duplicated requests

## Set up
- java, spring
	- spring-data-redis
	- lettuce
- redis 관련 설정이 되어있다고 가정

> 요구 사항
- 1초 미만으로, 다수의 request가 온다고 가정
- 이중 하나의 요청만 받아들이고, 나머지는 에러를 던져야함

## Java code

```java
@Component
@RequiredArgsConstructor
public class RedisRepository {

	private final RedisTemplate<String, String> redisTemplate;

	public boolean isDuplciated(final String key) {
		var ops = redisTemplate.boundValueOps(key);	
		var result = ops.increment(1L);
		// result can be null
		if (result == null || result == 1L) {
			// this ops wil expire in 1 seconds
			ops.expire(1, TimeUnit.SECONS)
			return false;
		}
		
		return true;
	}
}

```
- 맨 처음 요청이 왔을 경우 나올 수 있는 결과는 `null` or `1L` 
	- 이럴 경우, 해당 데이터에 대한 만료를 설정하고, `false` 리턴
	- 즉 중복된 요청이 아님. 
- 그 외 `true` 리턴
	- 같은 `key` 1초 내 요청에 대해서는, `2L, 3L, 4L..` 와 같은 `result` 가 반환됨
- `ops.expire(1, TimeUnit.SECONS)` 설정을 통해서, 무분별하게 쌓일 수 있는 점을 방지

## Redis

### INCRBY
- Time complexity: O(1)

```txt
...If the key does not exist, it is set to 0 before performing the operation
```
- 해당 키가 존재하지 않으면, `0` 으로 설정됨

### Examples
```sh
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