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

- SQL Developer 를 이용해서 접속해도 됨.



### 3. 기본 문법

- *sqlplus 툴은* sql을 실행하고 결과를 보여주는 환경을 제공해주고
- *sqlplus 툴* 명령어가 있는데, 세미콜론(;) 없이 사용이 가능하고 명령어는 축약이 가능하다.
- sql문은 명령어가 축약이 불가하고, 반드시 세미콜론으로 끝나야함.

- **sql문장의 키워드와 테이블명, 컬럼명등은 대소문자 구별안함.**
  - <u>**단 컬럼값은 대소문자 구별함.</u>**



#### 3.1 변수

- ```VARCHAR2(10)``` 가변길이로 char타입 데이터를 저장할 수 있음.

  - ```CHAR(10)``` 은 반드시 10개의 문자가 들어가야하고, 길이가 10이지만

    default 1 ,2000byte까지 저장됨.

  - ```VARCHAR2(10)``` 은 10개의 문자 내에 문자가 저장될 수 있음.

    default 1, 4000byte까지 저장됨.

  - ```NUMBER``` 은 binary형식으로 정수, 실수

  - ```date``` 는 7byte를 사용해서 수치값으로 저장하는데 `__`시 `__` 분 `__`초 ...이런식으로 



#### 3.2 시간

- `select sysdate from dual` 시간 알아보는 것 근데 19/05/30이런식으로 나옴. 왜? 

  시스템 형식이 위의 방식으로 저장(default)되어있기 때문에 그래서 이것을 바꾸려면?

  `alter session set nls_date_format = 'YYYY/MM/DD HH24:MI:SS';` -> 2019/05/30 11:25:16으로

  그렇지만 세션을 종료한 다음에 다시 시작하면 default값으로 변경되어 나옴.



#### 3.3 테이블

- `oracle data dictionary view` meta정보가 저장된 것을 보는 방법.

- user_tables : 특정 user 소유의 테이블 목록을 확인하고
- all_tables : 특정 user 소유와 권한을 받은 테이블 목록을 확인하는 방법
- dba_tables : db의 모든 테이블 목록을 확인(단 dba권한으로만 확인가능)
- ```select * from emp;``` emp에서 모든 값 출력
  ```select ename, sal, job, deptno from emp;``` 해당하는 컬럼만 출력, 이 컬럼의 순서는 테이블에 정의된 컬럼 순서를 맞추치 않아도 됨.

- ```select distinct deptno,  job from emp; --?``` 

  `distinct` 는 모든 컬럼 앞에만 쓴다는 것. 중복을 제거해주는 방법 hashing방법으로

  