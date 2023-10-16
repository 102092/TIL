# What is the KEYS
## Syntax
- Time complexity O(N)
    - 즉 존재하는 모든 키를 다 찾아본다는 뜻.
- Prod 환경일 때는 **사용하면 안됨**.
    - 해당 커맨드가 실행될 동안, 다른 명령어들은 기다리고 있을 테니 (싱글 스레드니까.)
    - [[SCAN]] 이나 [[SETS]] 명령어를 고려하라.

## Do not use KEYS keyword
- 왜?
- 모든 키를 다 찾아보기 때문에

## References
- https://redis.io/commands/keys
- https://tech.kakao.com/2016/03/11/redis-scan/
- https://rdbtools.com/blog/redis-delete-keys-matching-pattern-using-scan/