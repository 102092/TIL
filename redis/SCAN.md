# What is the SCAN

## Syntax
- 커맨드 실행엔 O(1), 가져온 키들을 순환 시키는 데는 O(N)
- 최근에 레디스에서 선택된 키들을 순환 시키는 커맨드.
    - 기본 10개씩 조회함.
- cursor based iterator
    - `scan 0` curosr 값이 0인 곳 부터 순회하도록 하는 명령어, 리턴값으로 다음 cursor 값이 반환됨.
    - 만약에 반환된 값이 0 이면, **순회가 종료**되었다는 의미임.
- 동작 방식으로 보았을 때, `KEYS` 와 동일한 동작을 하는게 아닐까?
    - 그렇진 않고, 아마도 Bucket을 하나씩 가져오는 방식으로 동작하는듯
- `match` 옵션을 통해 라는 특정 패턴을 매치하는 키를 골라낼 수 있을듯.
    - match 옵션은 elements들이 scan 통해 반환된 후에 적용이 됨.
    - 즉 해당 패턴에 맞는 element가 없다면, 반환된 키들이 없을 수도 있음 (empty list or set)

## SCAN and DEL
- redis-cli 이용
```
redis-cli --scan --pattern users:* | xargs redis-cli del
```

## References
- https://redis.io/commands/scan/
