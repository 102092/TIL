

# 배경

- DB 설계하던 와중에, 몇가지 포스팅을 참고하게 됭되었고 모르는 `Keyword` 를 접하게 되었음.

# 정리

- 찾아보니, **외래키** 옵션과 관련있는듯함.

- 2가지 제약이 있음.

  - 변경제약, 삭제 제약

- ```
  RFERENCES [부모테이블명](부모PK컬럼명) ON DELETE / ON UPDATE RESTRICT | CASCADE | SET NULL | NO ACTION | SET DEFAULT
  ```

  - 보통 이런식으로 어디를 참조하고 있는지 선언하고, **ON** 뒤에 제약 조건을 명시함.

### 변경 제약

- ON UPDATE

### 삭제 제약

- On DELETE

### 옵션

- RESTRICT : 참조하는 부모 테이블의 column이 삭제, 변경 되어도 지우지 않고 유지한다.
- CASCADE : 참조하는 부모테이블의 column이 삭제, 변경되면 자식 테이블의 column도 삭제, 변경
- SET NULL : 참조하는 부모테이블의 column이 삭제, 변경되면 자식 테이블의 column들이 `Null` 로 셋팅!
- NO ACTION : MySQL에서는 `RESTRICT` 와 동일.

---



#### 왜 왜래키를 설정할까?

- 정확하고 완전한 데이터들이 저장되게 하기 위해서.
- 즉 **참조 무결성**을 보장하기 위해서?
- 이를 위해 제약조건(Constraint)를 사용하고, 이러한 제약 조건에 어긋나는 자료는 DB에 입력되지 않도록 만들 수 있음.
- 이러한 제약 조건에는..
  - NOT NULL,
  - UNIQUE
  - PK, 기본키
  - FK, 외래키
  - CHECK 가 있음
- 위에서 적은 옵션들은 FK에 관련되 옵션.

# 참고

- https://h5bak.tistory.com/125
- https://yzzeee.tistory.com/18
- https://brownbears.tistory.com/182

