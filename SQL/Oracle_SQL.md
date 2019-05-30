# Oracle_SQL

### Database 시작

- **통합**? 데이터 중복을 최소화여 중복으로 인한 데이터 불일치를 최소화함.
- **저장**? 파일 형태로 컴퓨터 저장창치에 저장.
- **공용**? 동시적으로 공유할 수 있고,
- **운영**? 업무를 위한 검색을 할 목적으로 데이터를 이용하고,
- **실시간**으로 데이터를 볼 수 있는 접근성.
- **업데이트** 지속적으로 데이터가 변화하고,
- File -> Database -> DBMS(databaseManagementSystem)

  - 데이터베이스는 물리적인 것이고, DBMS는 소프트웨어(MySQL등)


|             |         =         |                           |
| :---------: | :---------------: | :------------------------ |
|    Table    |      Entity       | Record집합                |
|     Row     |      Record       | Tuple(속성값 모음)        |
|   Column    |     Attribute     | 속성                      |
| Primary key | not null + unique | 값이 없진 않고, 유일한 키 |
| Foreign key |        //         | 외래키,                   |

- row 가로

- SQL ? Structured Query Language
- DML, DDL , DCL ? 
- DBMS가 제공하는 보안적 기능
  1. 인증
  2. 권한

- RDBMS 주요 목적
  - Transaction? 분리되어서 실행될 수 없는 작업 단위. (unique of work) 
    원자성을 가짐. 즉 쪼개서 실행될 수 없다는 말이구. 
  
  

------



> ***앞으로 배울 것은 필수적인 SQL명령어, Transcation  에 대해!*** 



### 1. 설치

- [오라클](<https://www.oracle.com/technetwork/database/enterprise-edition/downloads/112010-win64soft-094461.html>)
- 1,2 압축풀고, 2에 들어있는 stage 폴더가  잘 들어가있는 지 확인. 없으면 설치시 오류남.
- 비밀번호 (8자 이상, 대소문자, 특수문자 포함여부)  가 충족이 되지 않으면 경고가 뜨긴 하지만 그냥 진행해도 무관함.
- 데스크탑 클라이언트 선택.



### 2. 실행

- 보통은 공부할 목적이면 좀 더 가벼운 xe버젼 사용.

- cmd창에서 ```sqlplus / sysdba``` //db 실행

  - 원래 ```sqlplus / 계정명/비밀번호 / sysdba``` 를 해야하는데 만약 보안프로그램이 설정되어 있으면 계정명/비밀번호를 해야하고, 그렇지 않으면 스킵해도 괜찮음.

- 실행된 후 일반 cmd창으로 빠져 나오려면? 명령어 : ```host```

  - host 창에서 다시 sql창으로? ```exit```

- ```select user from dual;``` : 현재 접속되어있는 유저 확인

  ```
  alter user scott // 유저 선언 scott은 oracle내부에 있는 데이터임.
  identified by oracle // 오라클에서 인증되었고 
  account unlock; //그러니까 유저의 언락해라
  ```

- Soft passing, Hard parsing 

  <https://jeong-pro.tistory.com/157> // SQL 내부 처리방식 참고할 것.

  - Soft parsing : SQL 실행계획이 캐시에 있으면 바로 실행되고,
  - had parsing : 캐시에 없으면 **최적화** 과정을 거친 후 , 실행되도록 하는 방식

- Symantic checking

- 엔티티관계모델

  <https://victorydntmd.tistory.com/126> // 참고

- SQL Developer 를 이용해서 접속하면 cmd보다 좀 더 가독성있는 접근이 가능함

  접속이름 : 맘대루

  사용자 이름 : 현재 DB에 있는 사용자 ex) scott

  비밀번호 : 처음 오라클에 설정한 비밀번호

  SID : orcl로 설정

### 3. 기본

- 변수 사용하지 못함 (MySQL은 가능

- 반복처리는 table의 행단위로 반복처리되고 있음. 명시적인 `for`이나 `while`은 없음.

- `exception`처리 안해도됨.

- 문법

- 함수 분류

  - predefine -> DB벤더에 `nvl, sysdate, user`등
  - custom -> (PL/SQL)

  

  - 단일행 함수 `Input`이 함수처리에 들어가서 `outputdata`가 **1개** 나오는 것.

    - DB의  단일행 함수는 반드시 **1개**의 결과를 리턴해줘야함.
    - `Character, Number, Date, Null처리, Conversion , 기타`

    

  - 복수행 함수 `allrow,gropingrow`가 `inpu`t으로 들어가서 `함수처리`를 지나 `outputdata`가 **1개** 나오는 것.

  

  - 분석함수(window 함수라고 함)
    - 엑셀 피벗테이블 그룹화 느낌. 이렇게 그룹화 되는 것을 window처럼 보임.
    - 분석함수는 비율, 순위등을 구해주는 것.



### 4. 기초 문법

- *sqlplus 툴은* sql을 실행하고 결과를 보여주는 환경을 제공해주고

- *sqlplus 툴* 명령어가 있는데, 세미콜론(;) 없이 사용이 가능하고 명령어는 축약이 가능하다.

- sql문은 명령어가 축약이 불가하고, 반드시 세미콜론으로 끝나야함.

- **sql문장의 키워드와 테이블명, 컬럼명등은 대소문자 구별안함.**
  
  - <u>**단 컬럼값은 대소문자 구별함.</u>**
  
- 주석은 단일`--주석문`, 멀티 `/* */` 

  



#### 4.1 변수

- ```VARCHAR2(10)``` 가변길이로 char타입 데이터를 저장할 수 있음.

  - ```CHAR(10)``` 은 반드시 10개의 문자가 들어가야하고, 길이가 10이지만

    default 1 ,2000byte까지 저장됨.

  - ```VARCHAR2(10)``` 은 10개의 문자 내에 문자가 저장될 수 있음.

    default 1, 4000byte까지 저장됨.

  - ```NUMBER``` 은 binary형식으로 정수, 실수

  - ```date``` 는 7byte를 사용해서 수치값으로 저장하는데 `__`시 `__` 분 `__`초 ...이런식으로 



#### 4.2 시간

- `select sysdate from dual` 시간 알아보는 것 근데 19/05/30이런식으로 나옴. 왜? 

  시스템 형식이 위의 방식으로 저장(default)되어있기 때문에 그래서 이것을 바꾸려면?

  `alter session set nls_date_format = 'YYYY/MM/DD HH24:MI:SS';` -> 2019/05/30 11:25:16으로

  그렇지만 세션을 종료한 다음에 다시 시작하면 default값으로 변경되어 나옴.



#### 4.3 테이블

- column 열을 뜻함

- `oracle data dictionary view` meta정보가 저장된 것을 보는 방법.

- user_tables : 특정 user 소유의 테이블 목록을 확인하고
- all_tables : 특정 user 소유와 권한을 받은 테이블 목록을 확인하는 방법
- dba_tables : db의 모든 테이블 목록을 확인(단 dba권한으로만 확인가능)
- ```select * from emp;``` emp에서 모든 값 출력
  ```select ename, sal, job, deptno from emp;``` 해당하는 컬럼만 출력, 이 컬럼의 순서는 테이블에 정의된 컬럼 순서를 맞추치 않아도 됨.

- ```select distinct deptno,  job from emp; --?``` 

  `distinct` 는 모든 컬럼 앞에만 쓴다는 것. 중복을 제거해주는 방법 hashing방법으로



#### 4.4 연산자

- `number`타입
  - 산술연산 : `+,-,*,/`
- `char/varchar2` 타입
  - 문자열 연결은?  `||`
- `date 타입`
  - ```date- date, date+-n```

![oracle 계산](C:\Users\student\Desktop\새 폴더\TIL\SQL\Oracle_SQL.assets\oracle_null.png)

- null은 값이 없다는 의미. 0도 아니고 ``도 아님.
- null을 산술연산 한다면 ? 값은 null
- null은 비교연산 논리연산 진행시 모두 null값을 결과함
- null을 포함하는 컬럼들은 null아닌 값으로 변환 후에, 산술연산을 수행해야 됨.
- 모든 DBMS는 <u>NULL 아닌 값으로 변환해주는 내장함수</u>가 존재한다!
  - `nvl(column, null일때 리턴값)`
- `is null`, `is not null` 연산자 
  - null은 논리연산, 비교연산이 안되니까 위의 연산자를 사용하고.
- 논리 연산자 `and`, `or` ,`not`
  - **논리 연산자 우선 순위는 NOT, AND, OR순위임.**
- 범위 값 연산자`between 하한값 and 상한값`

- **문자, 날짜 데이터는 반드시 ' ' 를 사용해서 표현하고 처리**해야한다.
- 날짜 데이터는 세션에 설정된 포맷형식하고 일치해야 한다.



#### 4.5 출력

- `selelct~from` 절은 필수적

- 단순 계산 결과, 함수 결과, 문자 데이터 출력들은 `dual` 테이블을 사용.

- Q) 'A' 를 출력하려면?

  ```
  select '''A''' from dual; //가독성 너무 떨어짐. 그래서..
  select q'['A']' from dual; // 현재 이 방식 지원하고 있음
  ```
  
- Q) `select 10||10 from dual;`

  `||` concanate 문자열간의 연결하는 것. 즉 10,10이 문자열로 취급되고 그러면 1010이 나오겠네?>

- Q) `select '10'+' 10' from dual;`

  `+` 산술연산자, 그럼 '10', ' 10' 문자열을 정수로 자동적으로 현변환 시켜서 답이 20이 나옴.

- Q) ```select sysdate+1, sysdate-1 from dual;``` +1,-1이 무엇을 의미하니?

  날짜와 산술연산하는 정수는 day임 즉 일단위로 바뀜

- Q)` select sysdate-hiredate from emp;`

  기간이 리턴되는데, 일 단위로.

- Q)`select sysdate_hiredate from emp;`

  에러 _은 부적합한 식별자.

- ```alter session set nls_date_format = 'YYYY-MM-DD HH24:MI:SS';```

  날짜형식 설정.

  ```select sysdate, sysdate+1/24, sysdate+5/1440 from dual;```

![](C:\Users\student\Desktop\새 폴더\TIL\SQL\Oracle_SQL.assets\sysdate.png)

#### 4.6 조건 검색 예제

- `select` ,`검색 컬럼 리스트`, `표현식`, `from 테이블` `where 조건`

  조건? 컬럼 비교 연산자 값 (>, < , >= , <> ,!=, = ,<=)

1. 부서 번호가 30번인 사원 검색하는 SQL문

   ```select ename, deptno from emp where deptno = 30;```

2. 직무가 ANALYST인 사원

   `select ename,job from emp where job = 'ANALYST';`

3. 급여가 3000이상인 사원은

   `select ename, salary from emp where salary >= 3000;`



​	Q. 87년 1월 1일 이후에 입사한 사원 이름 검색은? (단 session set이 'RR/MM/DD'로 설정)

​		1. `select ename, hiredate from emp where hiredate > '87/01/01';`

​			87/01/01로 조건을 해서 검색하면 오류뜸. 양식에 맞지 않는다고. 

​			그럼 ' ' 안에 넣어서 세션과 똑같이 해주면 자동으로 conversion해줌

​	 Q. 커미션을 받는 사원은?

​		1. `select ename, comm from emp where comm != 0;`

​		2. `select ename, comm from emp where comm != null;` 

​		오류 왜? null값은 논리연산자와 쓸 수 없음.

​		그래서 `is not null` 을 씀 null이 아닌 것. `is null` 널 인것.

​	 Q. 연봉 3000이상 5000이하인 사람은?

​		1. `select ename, sal from emp where sal >= 3000 and sal <=5000;`

​			이대신에 `between 하한값 and 상한값`을 사용해도됨.

​	 Q. 직무가 clerk 또는 analyst인 사원을 검색?

​		1.`select ename, job from emp where job = 'clerk' or job =' analyst';`

​			-`error` 왜? clerk , analyst로 검색했기 때문. 대소문자 컬럼값은 대소문자 구별하니까?

​		2.`select ename, job from emp where job in ('CLERK','ANALYST');`

​		***in 리스트 연산자 : in (값1, 값2, 값....)**

​	

  * character pattern matching 연산자 : `like '%, _'`
    		* % 문자 종류는 모든 문자, 갯수는 0~m개!
        		* _ 는 문자 종류는 모든 문자, 개수는 1개!

1. 사원 이름 중에서 두번째 문자가 'D' 인 사원만 검색할때는?

   `select ename from emp where ename like '_D%';`



​	Q. 사원 이름 중에서 첫번째 문자가 'S' 시작하는 사원

​	`select ename from emp where ename like 'S%';`

​	Q. 사원 이름 중에서 문자가 'N' 으로 끝나는 사원

​	`select ename from emp where ename like '%N';`

​	Q. 81년도에 입사한 사원을 검색?

```
select ename from emp where hiredate like '81%';
select ename from emp where hiredate between '81/01/01' and '81/12/31';
select ename from emp where hiredate  > '80/12/31' and hiredate < '82/01/31';
```



​	Q. 업무가 PRESIDENT이고 급여가 1500이상이거나 / 업무가 SALESMAN인 사원의 사원번호 이름 업무 급여를 출력

​	`select deptno, ename, job, sal from emp where (job = 'PRESIDENT' and sal >=1500) or job = 'SALESMAN'`

​	Q. 업무가 PRESIDENT 급여가 1500이상이고 업무가 SALESMAN 이거나 PRESIDENT인 사원의 사원번호 이름 업무 급여를 출력

```
select deptno, ename, job, sal from emp where  sal >=1500 and job in ('PRESIDENT','SALESMAN');`

select deptno, ename, job, sal from emp where  sal >=1500 and job = 'PRESIDENT' or job = 'SALESMAN';`
```



#### 4.7 정렬

- `select~from [where 필터조건] [group by 컬럼] [having 조건] [order by 정렬기준컬럼 정렬방식]`

  - [] 는 선택조건. 넣어도 되고 안해도 되고.
  - 정렬방식 `asc`  오름차순, `default, desc` 내림차순, *적질않았을 경우 오름차순으로 됨.*

  Q. 월급의 오름차순으로 사원정보 출력

  `select ename, job, sal from emp order by sal;`

  내림차순?  `select ename, job, sal from emp order by sal desc; `

   Q. 사원들의 사번, 이름 부서번호,월급, 커미션,연봉(SAL+COMM*12)의 결과 출력은 연봉 내리차순으로?

  `select deptno, ename, mgr, sal, comm, 연봉(sal+comm*12) from emp order by 연봉;`

  - **컬럼명을 추가해줄때는 해당 SQL명령어 뒤에 적어주는 구나**

  ```
  select empno, ename, deptno, sal, comm, (sal+nvl(comm,0)*12) from emp order by (sal+nvl(comm,0)*12) desc;
  
  select empno, ename, deptno, sal, comm, (sal+nvl(comm,0)*12) "연봉" from emp order by "연봉" desc; 
  
  select empno, ename, deptno, sal, comm, (sal+nvl(comm,0)*12) "연봉" from emp order by 6 desc; 
  ```

  

  Q. 사원들의 사번, 이름 부서번호,월급, 커미션,연봉(SAL+COMM*12)의 결과 출력은 부서번호 오름 차순 정렬하고 연봉의 내림차순

  ```
  select empno, ename, deptno, sal, comm, (sal+nvl(comm,0)*12) "연봉" from emp order by deptno asc, "연봉" desc; 
  
  select empno, ename, deptno, sal, comm, (sal+nvl(comm,0)*12) "연봉" from emp order by 3 asc, 6 desc;  //숫자는 컬럼번호
  ```

  

#### 4.8 연습문제

```
[연습문제]
문제1)  EMP Table의 모든 자료를 출력하여라.

문제2)  EMP Table에서 사원 번호, 이름, 급여, 담당업무를 출력하여라.

문제3) 모든 사원의 급여를 $300 증가시키기 위해 덧셈 연산자를 사용하고 결과에 SAL+300을 조회한다
  
문제4) EMP 테이블에서 사원번호, 이름, 급여보너스를 출력하여라.

문제5) EMP 테이블에서 ENAME를 NAME로 SAL을 SALARY로 출력하여라.

문제6) EMP 테이블에서 ENAME를 Name로 SAL*12를 Annual Salary 로 출력하여라.

문제7) EMP 테이블에서 ENAME를 '성 명'으로, SAL를 ‘급 여'로  출력하여라.

문제8) EMP 테이블에서 이름과 업무를 연결하여 출력하여라.

문제9) EMP 테이블에서 이름과 업무를 "King is a PRESIDENT" 형식으로 출력하여라.

문제10) EMP 테이블에서 이름과 연봉을 "KING: 1 Year salary = 60000" 


문제11) EMP 테이블에서 JOB을 모두 출력하여라.

문제12) EMP 테이블에서 담당하고 있는 업무의 종류를 출력하여라.

문제13) EMP 테이블이 부서번호를 중복 값을 제거해서 조회하라

문제14) 부서별로 담당하는 업무를 한번씩 출력하여라.

문제15) EMP 테이블에서 사원번호, 이름, rowid를 조회하라.

문제17) EMP 테이블에서 급여가 3000 이상인 사원의 사원번호, 이름, 담당업무, 급여를 출력하라.

문제18) EMP 테이블에서 담당업무가 Manager인 사원의 정보를 사원정보, 성명, 담당업무, 급여, 부서번호를 출력하라.

문제19) EMP 테이블에서 1982년 1월 1일 이후에 입사한 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라.

문제20) EMP 테이블에서 급여가 1300에서 1700사이의 사원의 성명, 담당업무, 급여, 부서 번호를 출력하여라.

문제21) EMP 테이블에서 사원업호가 7902, 7788, 7566인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자를 출력하여라.

문제22) EMP 테이블에서 입사일자가 82년도에 입사한 사원의 사번, 성명, 당당업무, 급여, 입사일자, 부서번호를 출력하여라.

문제23) EMP 테이블 이름의 첫 글자가 'M'인 사원의 이름, 급여 조회하라

문제24) EMP 테이블 이름의  두 번째 글자가 ‘L'인 사원의 이름,업무를  조회하라

문제25) EMP 테이블에서 보너스가 NULL인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하여라.

문제26) EMP 테이블에서 급여가 1100 이상이고 JOB이 Manager인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하여라.
```

```
1.select * from emp;
2.select empno, ename, sal, job from emp;
3.select sal+300 from emp;
4.select empno, ename, comm from emp;
5.select ename"NAME", sal"SALARY" from emp;
6.select ename"Name", sal*12"Annal Salary" from emp;
7.select ename"성 명", sal"급 여" from emp;
8.select ename || job from emp;
9.select ename ||  ' is a ' || job from emp;
10.select ename ||  ': 1 Year salary =  ' || sal from emp;
11.select job from emp;
12.--무슨말이여
13.select distinct job from emp;
14.select distinct deptno, job from emp;
15.select empno, ename, ROWID from emp;
16.select empno, ename, job, sal from emp where sal >=3000;
17.select empno, ename, job, deptno from emp where job ='MANAGER';
18.select empno, ename, job, sal, hiredate, deptno from emp where hiredate > '82/01/01';
19.select ename, job, sal, deptno from emp where sal between 1300 and 1700;
20.select empno, ename, job, sal, hiredate from emp where empno in ('7902','7788','7566');
21.select empno, ename, job, sal, hiredate, deptno from emp where hiredate like '82%';
22.select ename, sal from emp where ename like 'M%';
23.select ename, job from emp where ename like '_L%';
24.select empno, ename, job, sal, deptno from emp where comm is null;
25.select deptno, ename, job, sal from emp where  sal >=1500 and job in ('MANAGER');
```



### 5. 필수 함수

- Database SQL Language Reference](<https://docs.oracle.com/cd/E11882_01/server.112/e41084/toc.htm>)
  - `Function` 으로 들어가면 함수에 대한 reference를 볼 수 있음.
  - `chr`



![](C:\Users\student\Downloads\chr.gif)

  - `n`정수값이 들어가면 이걸 이용해서.... char

##### 5.1 lower등, length, cocat

- [참고](<https://mine-it-record.tistory.com/57>)

```
select initcap(ename), lower(ename), upper(ename) from emp; 
-- ename을 받아서, 소문자, 대문자
select length('korea') length('대한민국') from dual;
--길이
select lengthb('korea') lengthb('대한민국') from dual;
--?
select concat(concat(ename, ' is '), job) from emp;
--concat 합치는 거지. ename과 is를 먼저 합치고 그리고 job과 또 합치고
```



##### 5.2 substr, instr

```
select substr('today is 2015년 4월 26일', 1, 5),
       substr('today is 2015년 4월 26일', 10, 5), - 10부터 15까지 추출
       substr('today is 2015년 4월 26일', 15), - 15부터 나머지 모두
       substr('today is 2015년 4월 26일', -3, 2) - 맨뒤? -1, -3부터 -1까지
from dual;
--substr 부분추출. 1부터 5까지. 여기 index시작은 1부터됨.

select instr('korea is wonderful', 'o'),
       instr('korea is wonderful', 'o', 1, 2),
       instr('korea is wonderful', 'o', 9),
       instr('korea is wonderful', 'x')
from dual;
-- instr 찾는 거지, '문자' 가 어디있는지.
```



##### 5.3 lpad, rpad

```
select ename, sal, lpad(sal, 10, '*')
from emp;
-- 문자열 변환, 문자열 전체 길이내에 왼쪽 공백에 특정문달을 padding
-- sal컬럼에 값들을 10자리 값으로 만들고, 그 왼쪽에 빈값들을 해당 문자로 채워넣음

select ename, sal, rpad(sal, 10, '*')
from emp;
-- r? rigtht 오른쪽으로 채워나가는 것.
```



##### 5.4 trim, ltrim, replace

- 공백제거하는 함수 `trim`
  - 문자중간에 공백을 제거할 수 는 없음.
- 변환 `replace`

```
select length('  hello  '),  length(trim('  hello  '))
from dual;
--공백을 제거하지 않으면 그 공백의 길이까지 측정.

select trim('H' from 'Hello wonderful'), trim('l' from 'Hello wonderful')
from dual;
-- 'H' 제거하고 나머지 반환, 마지막나오는 L WPRJGKRH QKSGHKS

select ltrim('Hello wonderful', 'He' ), rtrim( 'Hello wonderful' , 'ful')
from dual;
-- 후자 'He' 제거하고 나머지 반환

select replace('Jack AND Jue', 'J', 'BL')
from dual;
--'J'를 'BL'로 바꿔라,, BLack ADN BLue 반환됨.
```



##### 5.5 numberic 

- `round(n1,n2)` n1에서 0아래 n2자리수까지 보존하면서 반올림.
- `trunc 절사, mod 나머지, ceil 올림, power 지승`

```
select round(12.345, 2), round(12.345, 0), round(12.345, -1)
from dual;
-- 0? 1의자리까지, -1? 10의자리까지

select trunc(12.345, 2), trunc(12.345), trunc(12.345, -1)
from dual;
-- 버림느낌.

select mod(99, 4)
from dual;

select ceil(12.345), floor(12.345) from dual;
-- 올림함수, 내림함수

select power(3, 2), power(5, 2)
from dual;
-- 3^2
```

Q. 사원번호중 홀수인 사원들만 출력

​	`select empno, ename from emp where mod(empno, 2) =1;`

##### 5.6 date function

- RR날짜 형식

  ![](http://mblogthumb4.phinf.naver.net/20151003_59/sg5107_1443841427406MTpEg_PNG/17.png?type=w2)

  - YY포맷을 주고, 1995년도 입사한 고객을 찾으면? 1917로 검색하게 되고.

- `timestamp` 컬럽타임은 ? `(YYYY/MM/DD HH24:MI:SS.SSSSSSSSS)`

  ```
  select sessiontimezone from dual;
  alter session set time_zone='+3:00';
  select sessiontimezone from dual;
  ```

- `sysdate` 시스템의 현재 리턴

- current_date ? 세션의 timezone을 기반으로 현재시간을 date타입으로 리턴함

- current_timestamp? 세션의 timezone을 기반으로 현재시간을 timestamp타입으로 리턴함

  ```
  select sysdate, current_date, current_timestamp from dual;
  ```

- `add_months(date, n)` - 개월 수를 더한 날짜가 리턴

- `months_between(date, date) `- 기간이 리턴

	```
	select add_months(sysdate, 6) from dual;

	select hiredate, add_months(hiredate, 6) from emp;

	select months_between(sysdate, hiredate) from emp;
	```

- `next_day(date, '요일명')` 

  ```
  select next_day(sysdate, '목') from emp; --다음 목요일이 오는 날짜는 언제인가?
  ```

- 요일을 기준 올림,반올림,절사등..

  ```
  select trunc(to_date('14/02/14'), 'MONTH'),  --MONTH 면 일기준으로 행해지고
         trunc(to_date('14/02/14'), 'YEAR')	--YEAR이면 월기준으로 함수가 행해짐
  from dual;
  
  select round(to_date('14/02/14'), 'MONTH'), 
         round(to_date('14/02/14'), 'YEAR')
  from dual;
  ```

  - 하기전에 꼭 `alter session set nls_date_format = 'RR/MM/DD';` 를 설정해줘야하고,
  - 2월 14일, 14일을 기준으로 월 변화를 보면 2월 1일로 변화됨 , 15일도 `round` 함수에 의하면 내림이 되고

- `last_day(date)` 

  - 언제가 마지막 날인지 찾는 함수.

  ```
  select last_day(to_date('14/02/14')), last_day(to_date('2000/02/14'))
         , last_day(to_date('2100/02/14'))
  from dual;
  ```

  ![](C:\Users\student\Downloads\last_day.png)

  Q. 각 사원들의 입사날짜로 부터 6개월후로 날짜로부터 다음 금요일이 연봉 조정일이면 , 사원들의 연봉 조절 면담날짜는?

  ​	`select ename, hiredate, next_day(add_months(hiredate,6), '금')"연봉조절날짜" from emp;`

  

### 6. 형 변환

####  6.1 Number <=> Character

- `character` to `number` ? `to_number`
  - `to_number('기존 문자열', '변환할 format형식')` 
    - 형식은 문자열과 똑같이 지정을 해줘야힘 $23,000.00? $99,999.00이런식으로
- `number` to `character ` ? `to_char`
- `to_char(기존 number, '변환할 문자열 format형식')` 
- `tonumber`은 두개다 ' '로 감싸져있지만, `tochar`은 변환형식만

	```
	select to_char(123456.789, '$9,999,999.9999') from dual;
	-- 전자 숫자와 후자 포멧형식이 일치하지 않지만 변환을 해준다.

	select to_number('$1,234,567.999', '99,999,999.999') from dual;
	--에러. 왜? 숫자의 갯수의 문제가 아닌, '$'가 없기 때문임.
	```



####  6.2 Character <=> Date

- `to_date('기존 문자열', '변환할 날짜format 형식')`

- `to_char('기존 날짜','변환한 문자format 형식')`

  ![](C:\Users\student\Desktop\새 폴더\TIL\SQL\Oracle_SQL.assets\date_tochar.png)

  ![](C:\Users\student\Desktop\새 폴더\TIL\SQL\Oracle_SQL.assets\date_tochar_eng.png)

	- 영어형식으로 날짜가 출력됨.

  
  
  ```
  alter session set nls_language=english;
  
  select '2019-05-30 5:43 PM' 
         , to_date('2019-05-30 5:43 PM' 'HH12:MI AM YYYY-MM-DD')
  from dual;  --error?
  
  
  select '2019-05-30 5:43 PM' 
         , to_date('2019-05-30 5:43 PM', 'YYYY-MM-DD HH12:MI PM')
  from dual; 

  ```
  
  - **다시 살펴볼 내용.**



