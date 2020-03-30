### 들어가면서

- `user + 특정 데이터 베이스` 명으로 사용할 데이터 베이스를 선언하고
- SELECT 간이 필드명 은 `,` 로 구분된다.
  - `select name, population from city..`
- `SELECT distinct district from city where contrycode = 'KOR'`
  - `distinct` 조건을 통해, 중복되지 않는 district 값을 가져올 수 있다.
- SQL문 마지막에는 `세미콜론`이 오는 것을 잊지 말자.
- 정수는 기존 그대로 사용하지만 문자열, 날짜 시각의 경우에는 <u>작은 따옴표('')</u>로 감싼다.
- 기본적으로 키워드(select, from)등의 문자는 <u>대,소문자를 구별하지 않는다.</u>



#### SELECT

- 기본적으로 DBMS에 저장된 테이블을 조작하기 위해서 사용되는 언어.

- select * from,,

  - `*` 는 별로 좋지 않음. 어떤 컬럼들이 선택되는지 정확하게 명시해줄 필요가 있다.
  - 왜냐면 이렇게 해야, 작성하지 않은 다른 개발자가 보더라도 쉽게 이해할 수 있기 때문에

- **SELECT 열명 FROM 테이블명 WHERE 조건;**

  - 굉장히 기본적인 SQL 구문임.

- SQL문 연산자 우선 순위

  ![](https://www.dbguide.net/publishing/img/knowledge/SQL_173.jpg)



#### SELECT 응용

- `SELECT 컬럼 FROM 테이블명 WHERE 조건컬럼 = 조건 ORDER BY 조건컬럼 desc or asc;`
  - 기본적으로 특정 조건에 따라 오름차순, 내림차순으로 정렬하는 방법
  - where 다음에 order 구분이 위치함을 잊지말자.

- 정렬을 실행할 때는 정렬 키가 복수개 존재하지 않도록 해야함.
- 테이블을 요약함수는 크게 2가지.
  - 복수 행에 대해 집계를 수행하거나
  - 단일 행의 값에 대해 조작이나 계산을 수행하는 함수.
  - COUNT, SUM, AVG, MAX, MIN이 이에 해당함.
- 집약된 결과에 조건을 지정해 주고 싶을 때는?
  - `SELECT ~ FROM ~ GROUP BY ~ HAVING 그룹에 대한 조건`
- 작성 순서
  1. SELECT
  2. FROM
  3. WHERE
  4. GROUP BY
  5. HAVING 
  6. ORDER BY



### 데이터 갱신 삽입

- 기본의 데이터를 변경, 갱신할 때는 UPDATE 문

  - `UPDATE 테이블 명 SET 열명 = 값`

    `UPDATE 테이블 명 SET 열명 = 값 WHERE 조건`

- 데이터를 입력할 때는 INSERT 문

  - `INSERT INTO 테이블명(열1, 열2...) VALUES (값1, 값2)`
  - `INSERT INTO 테이블명(열1, 열2) VALUES (값1, 값2), (값3, 값4), (값5,값6)`
    - 여러번 insert하지 않아도, 콤마를 통해 하나의 문장처럼 작성할 수 있음/

- 데이터를 제거할 때는 DELETE 문

  - `DELETE FROM 테이블명;`
    - 이경우 전체 행이 삭제됨..
  - `DELETE FROM 테이블명 WHERE 조건;`



### 뷰

- 특정 조건에 따른 테이블 데이터 스냅샷을 의미하는듯.
- 테이블과 동일하지만, 테이블과 같은 데이터를 가지고 있진 않고, SELECT 문을 실행시킬 수 는 있음.

- CREATE VIEW
  - `CREATE VIEW 뷰 명 (열1, 열2...) AS SELECT 문;`
- 서브 쿼리
  - SELECT 문의 결과를 마치 데이터 처럼 다루거나, 수치 처럼 취급하여 조건문에 이용할 수 있음.
  - 이러한 쿼리를 서브쿼리라 함.
- 스칼라 값
  - SELECT COUNT (*) FROM 테이블 명;
  - 이 쿼리문의 결과는 단일 값이 나오는데 이를 스칼라 값이라 부른다.



### 결합

- 내부 결합 inner join, 외부 결합 outer join이 있음.

- 내부 결합

  - ON으로 지정된 결합 조건에 일치하는 행만을 2개의 테이블로 부터 가져 오는 것을 의미함.
  - 테이블명.열명으로 테이블별 열을 구분할 수 있는데, 2개 테이블에 이름이 같은 열이 있다면 필수고, 한 쪽 열에만 존재한다면 생략해도 좋음.
  - **SELECT 선택하고 싶은 열 리스트 FROM 첫번째 테이블 명 INNER JOIN 두번 쨰 테이블 명 ON 결합 조건**

- 외부 결합

  - 한쪽 테이블을 기준으로 전체 행을 표시하고, 다른 테이블의 값이 있으면 표시하고 싶을 때 사용.
  - **SELECT 선택하고 싶은 열 리스트 FROM 첫번째 테이블 명 LEFT OUTER JOIN 두번 쨰 테이블 명 ON 결합 조건**
    - 2개의 테이블 중 왼쪽 테이블의 전체 행이 표시되고, 다른 테이블의 행 데이터는 결합 조건이 일치할 때, 그 값이 되고 일치하는 것이 없으면 NULL이 된다.

- NULL

  - 불명, 적용 불가를 나타내는 단어.
  - 별로 권장하지 않음.
  - 왜?
    - true, false, null이 세가지 선택지가 가능하다.
    - NULL의 전파 문제
    - 코딩적 null하고 다른 의미.

  