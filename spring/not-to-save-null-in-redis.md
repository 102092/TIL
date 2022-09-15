# Spring Redis Cache 사용에서 null을 캐싱하지 않는 법

## RedisCacheManager

- 설정할 때 `disableCachingNullValues()` 추가
- 전역적으로 `null` 을 캐싱하지 않도록 함
- 단 사용시, 캐시에 `null` 담기려 하면 **에러** 발생함.

## unless = "#result == null"

- `@Cacheable(value="defaultCache", key="#pk", unless="#result == null")` 와 같이, 해당 어노테이션에 `unless = "#result == null"` 을 명시.
- 그러면 `null` 은 캐싱하지 않게 됨
- 에러 반환도 없고.
- 이해하자면, *result 가 null이 아니라면(unless)* 캐싱한다는 의미인듯.
  - `unless` 라는 이름이 붙으면, 함수가 실행된 이유에 판단된다.
  - 다시 말해, cache에 값이 있으면 그 값이 리턴되고, 캐시에 값이 없고, 메서드가 실행되었는데 그 값이 `null` 이라면?
  - 해당 패턴에 의해서 캐싱이 되지 않는다고 이해됨.

### 참고

- <https://stackoverflow.com/questions/12113725/how-do-i-tell-spring-cache-not-to-cache-null-value-in-cacheable-annotation>
- <https://findmypiece.tistory.com/105>
- <https://blog.leocat.kr/notes/2022/05/05/redis-avoid-store-null-value>
