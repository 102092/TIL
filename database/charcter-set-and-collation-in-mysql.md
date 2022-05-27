# 들어가면서

```
Illegal mix of collations (utf8_general_ci,IMPLICIT) and(utf8mb4_unicode_ci,COERCIBLE) for operation '='
```

- 위와 같은 에러를 받았음.
- 해석했을 때, `=` 부분에 `utf8_general_ci,IMPLICIT` 와 `utf8mb4_unicode_ci,COERCIBLE` 를 혼용해서 사용하려 했기 때문에 발생한 것으로 보임.
- 그러면 collation이란 무엇일까?

# Collation
- `set of rules for comparing characters in a character set.`
- 캐릭터 셋 내부에서 정렬되는 규칙.
- 실행되는 쿼리 문에서 OrderBy, Like 같은 비교 연산자를 사용할 때 이 부분이 영향을 끼치지 않을까 생각함.



# Character set 
- `set of symbols and encodings`

- 예를 들면..
    1.  four letters: A, B, a, b.
    2.  A = 0, B = 1, a = 2, b = 3.
        - A는 Symbol, 0 은 A가 encoding되었을 때 나타내는 숫자
    3. combination of all four letters and their encodings is a character set
        - 즉 symbol과 encodings의 집합을 character set이라 부른다.

- 왜 필요할까?
    - 생각해보면, 텍스트 데이터를 0,1 숫자로 매칭한 후에, 저장, 전송하니까.. 후에 이 encodings만을 기반으로 원래 데이터를 가져오기 위해서는 약속된 규칙 (캐릭터셋) 이 필요할 듯.

- 발생할 수 있는 문제는?
    - 문자열이 적절하게 인코딩되지 못하는 경우.
    - 이럴 경우, deconding 될 때, 정상적인 문자열로 치환되지 않을 수도 있을듯.

- Examples
![](https://www.lesstif.com/dbms/files/9437311/91947068/1/1592641862000/image2020-6-20_17-31-0.png)


# In MySQL
> MySQL 5.7

```sql
SHOW VARIABLES WHERE Variable_name LIKE 'character\_set\_%' OR Variable_name LIKE 'collation%';
```
- 현재 적용 중인 character set과, collation 설정을 확인할 수 있음.

<img width="307" alt="image" src="https://user-images.githubusercontent.com/71244638/170174575-015feaac-24f4-497b-8fb8-59052e035a34.png">


## Difference betweee utf8 and utf8mb4 charsets 

- utf8 
    - `utf8mb3` 와 같은 의미
    - 하나의 캐릭터를 저장하는 데 1~3 byte를 요구됨.

- utf8mb4
    - supplementary characters. (아마도 이모지 같은..문자)
    - Requires a maximum of four bytes per multibyte character. (최대 4바이트까지 사용한다는 의미인듯)


# 정리

```
Illegal mix of collations (utf8_general_ci,IMPLICIT) and(utf8mb4_unicode_ci,COERCIBLE) for operation '='
```

- 정리해보면 이 에러는, `=` 비교되는 sql operation에서 서로 다른 collations을 사용하려 했기 때문에 발생한 문제.
- 아마도 해당 테이블의 설정은 `utf8_general_ci` 이고, 강제적으로 그러니까 어플리케이션에서 쿼리는 `utf8mb4_unicode_ci` collation을 사용하도록 되지 않았나 함.
- 그리고 `utf8mb4` 로 되어있는 것으로 보아 이모지가 포함되지 않았나 싶음.
- 그래서 해결 방법으로는..
    1. 해당 테이블의 셋팅을 변경 (리스크가 동반될듯.)
    2. 발생하는 쿼리문에서 이모지등을 제거하는 방법이 있을듯.

# 참고
- https://dev.mysql.com/doc/refman/5.7/en/charset-general.html
- https://mathiasbynens.be/notes/mysql-utf8mb4
- https://www.lesstif.com/dbms/mysql-character-sets-collations-9437311.html
- https://en.wikipedia.org/wiki/Character_encoding
- https://stackoverflow.com/questions/30074492/what-is-the-difference-between-utf8mb4-and-utf8-charsets-in-mysql