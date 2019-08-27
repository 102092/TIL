> 궁금했던 부분을 찾아가며 정리하고 있습니다.
> 혹시 잘못된 부분이 있으면, 언제든지 댓글로 편하게 알려주세요 :)



## 참고

[이기적 SQL 개발자](http://www.yes24.com/Product/Goods/67442640)



---



## 1. 데이터모델링

#### 정의

- 현실세계를 데이터베이스를 표현하기 위해 **추상화**
- 복잡하지 않도록, 왜? 고객이 이해학 쉽게
- 처음에는 고객의 업무 프로세스를 추상화하고, 그 후에 소프트웨어가 분석-설계 하면서 상세해지도록



#### 특징

- 추상화 : 공통적인 특징을 찾고, 간략하게 표현
- 단순화 : 누구나 이해할 수있도록
- 명확성 : 해석이 모호하지 않고, 명확하게 해석되도록



### 단계

1. #### 개념적 모델링

   - 기업 전체에 대한 데이터 모델링(비즈니스 프로세스에 대한)
   - 복잡하지 않고, 중요부분만 모델링
   - Entity, Attribute를 도출, 개념적 ERD(Entity Relationship Diagram)을 작성

2. #### 논리적 모델링

   - 개념적 모델링을 **논리적** 으로 변환하는 작업
   - 식별자 도출, 필요한 모든 릴레이션 정의
   - 정규화를 통한 데이터 모델 독립성 확보(*재사용성 높힘*)

3. #### 물리적 모델링

   - DB실제 구축, 성능 보안 가용성을 고려하여



### 관점

데이터? 실질적으로 사용되는

프로세스? 비즈니스 프로세스에서 수행되는 작업

데이터와 프로세스? CRUD분석



### ERD

1976/피터첸

Entity간의 관계를 정의하는 모델링 방법

작성시 고려해할것?

- 중요한 것은 가급적 왼쪽 상단
- 이해가 쉽고, 복잡하지 않도록



### 데이터 모델링 고려사항

1. #### 독립성

   - 이를 위해 중복된 데이터를 제거해야함.
   - 중복된 데이터를 제거하는 방법은 ? 정규화

2. #### 요구사항 표현

   - 고객의 요구사항을 복잡하지 않게 표현
   - 간결하고 명확하게

3. #### 품질 확보



### 3층 스키마

- 사용자 설계자, 개발자가 데이터베이스를 보는 관점에 따라 데이터베이스를 기술하고, 관계를 정의한 ANSI 표준

- 데이터베이스의 독립성을 확보하기 위한 방법

  독립성을 확보하면 뭐가 좋을까?

  -> 데이터 **복잡도 증가, 중복 제거, 대응력 향상, 유지보수 비용 절감등. ****

  *좋은건 다된다고 보면 될까.*

- 각 계층을 View라 표현



1. #### 독립성 

   논리적 : 저장구조가 변경되어도, 프로그램 및 개념 스크마에는 영향이 없도록

   물리적 : DB의 논리적 구조가 변경되어도 응용프로그램에 변화가 없도록

![](http://www.databaser.net/moniwiki/pds/3_eb_8b_a8_ea_b3_84_ec_8a_a4_ed_82_a4_eb_a7_88_ea_b5_ac_ec_a1_b0/3%EB%8B%A8%EA%B3%84%EC%8A%A4%ED%82%A4%EB%A7%88%EA%B5%AC%EC%A1%B0.JPG)

2. #### 구조

외부 스키마 : 사용자관점에서 접근,  **응용프로그램이 접근하는 측면**에서 데이터베이스를 정의

개념 스키마 : 설계자, 사용자 전체의 관점에서 접근, **통합 데이터 베이스의 구조**를 정의

내부 스키마 : 개발자 관점, **데이터베이스의 물리적 저장구조** (데이터베이스,레코드 구조, 필드 정의, 인덱스등)



### 엔터티(Entity)

- 업무에서 관리해야 하는 **데이터 집합**을 의미, 엔터티는 저장되고 , 관리되어야하는 데이터!
- 명사적인 의미로 *개념, 사건 , 장소*를 의미함



Ex) 은행 비즈니스 프로세스에서 엔터티는 뭐가 있을까.

1.  고객 (회원id, 패스워드, 이름, 주소, 전화번호)
2.  계좌 (계좌번호, 계좌명, 개설지점, 담당자)



#### **엔터티 특징**

1. 식별자 
   - 유일한 식별자가 있음 (id, 계좌번호)
2. 인스턴스 집합
   - 2개이상의 인스턴스가 있어야함.(고객이 한명만 있는 건 아니니까 2명이상 있겠지?)
3. 속성
   - 반드시 속성을 가지고 있음(id, 패스워드, 이름, 주소등..)
4. 관계
   - 다른 엔터티와 **최소 1개 이상** 관계에 있음
5. 업무
   - 업무에서 관리되어야하는 집합이어야 함(업무상황에서 고객, 계좌 집합이 관리되므로)



#### 엔터티 종류

유형 무형, 발생하는 시점 에 따라 나뉘게 됨.



1. 유형 vs 무형

- 유형 : 지속적으로 사용되는 엔터티 (고객, 강사, 사원등등..)
- 개념 : 실제 세계에 물리적 형태 없음.  (생명보험 상품등.)
- 사건 : 비즈니스 프로세스를 **실행시키면** 생성되는 (주문, 체결, 취소주문..)



2. 발생 시점

- 기본 : 키 엔터티, 독립적으로 생성되는 엔터티(고객, 상품 부서)
- 중심 : 기본- 중심 - 행위 형태, 기본으로 부터 발생되고, 행위 엔터티를 생성하는 것 (계좌, 주문, 취소, 체결)
- 행위 : 2개 이상의 엔터티로 부터 발생 ( 주문 이력, 체결 이력)



### 속성

엔터티가 가지는 항목, 더 이상 분리되지 않음, 인스턴스의 구성요소 (계좌 엔터티의 계좌명, 예수금등은 속성이라 생각된다.)



1. #### 특징

   - <u>하나의 값</u>만 가짐
   - <u>주식별자에게 종속</u>됨 ( 기본키가 변경되면 속성값도 변경됨)

   

2. #### 종류

   - 분해 여부에 따라

     단일 : 하나의 의미로 구성 (회원ID, 이름)

     복합 : 여러개의 의미가 있는것, 분해될 수 있음 (주소)

     다중값 : 속성을 여러개의 값을 가질 수 있는 것(상품 리스트)

   

   - 특성에 따라

     기본 : 본래의 속성

     설계 : 데이터 모델링 과정에서 발생되는, 유일한 값을 부여함 ( 상품코드 , 지점 코드)

     파생 : 다른 속성에 의해서 만들어짐 (합계, 평균)



- 도메인?

  속성이 가질 수 있는 값의 범위.

  즉 성별이라는 **속성의 도메인은 남자 여자임**



### 관계

- 엔티티간의 관련성, 존재 관계와 행위 관계로 분류됨.



1. #### 종류

   - 존재관계 : 엔티티 간의 상태. 고객이 은행에 가입하면, 관리점이 할당되고 , 할당된 관리점은 고객을 관리하는 것
   - 행위 관계 : 엔티티간의 행위 관계, 계좌를 사용해서 주문을 발주하는 관계

2. #### 관계 차수

- 두 개의 엔티티 간에 참여하는 수, 
- 1대N등,..



- 기억하자 1)

![](https://t1.daumcdn.net/cfile/tistory/26A797335969511F26)



- 기억하자2)

![](http://tech.devgear.co.kr/files/attach/images/271/331/cfe4db4b255357a9df734994b4d2ea38.png)



2.1 관계 차수 종류

- 1대 1관계 

  완전(반드시), 선택적(있을수 없을 수도 있음)

- 1대 N관계

- M대 N관계

  관계형 데이터베이스에서 M대 N관계의 조인join은 카테시안 곱이 발생. 

  그래서 M대 N을 1대 N.. 로 해소해야함

- 필수적, 선택적 관계

  필수적(|) : 반드시 하나는 존재해야함

  선택적(O) : 없을수도 있음 



### 식별, 비식별 관계



#### 식별관계

- 독립적으로 존재할 수 있는 강한 개체(Strong Entity)

- 다른 엔티티와 관계를 가질 때, 기본키를 공유함

- 강한 개체는 식별관계로 표현됨.

  식별관계는 고객 엔티티의 기본키인 회원 ID를 계좌 엔티티의 기본기의 하나로 공유하는 것

![](data:image/png;base64,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)

- 기본키인 회원번호를 프로필의 기본키로 공유하고 있음

  회원은 프로필을 하나를 만들 수도 없을 수 도 있지만, 프로필은 회원이 꼭 있어야함.

- 프로필이 약한 개체



### 비식별 관계

- 강한 개체의 기본키가 다른 엔티티의 기본키가 되는 것 이아닌, 일반 칼럼으로의 관계

- 예를 들면, 관리점 엔티티에서 기본키인 지점코드는 고객 엔티티와 비식별 관계이다.

  왜? 지점코드가 고객엔티티에서 기본키로 취급되는 것이 아닌 일반 칼람으로 참조 되기 때문

- 비식별관계는 점선으로 표현

![](http://tech.devgear.co.kr/files/attach/images/271/331/e3f8cc96d8a157eff0ef361f821de1c1.png)

### 엔티티 식별자

- 엔티티를 대표할 수 있는, 유일성을 만족하는 속성.
- 회원 ID, 주민등록번호, 계좌번호등이 이에 해당한다.



#### 주식별자(기본키)

- 유일성, 최소성을 만족함.
- 엔티티를 대표해야함
- 자주 변경되지 않아야함



- 종류
  - 기본키 : 후보키 중, 엔티티를 대표할 수 있는
  - 후보키 : 유일성, 최소성을 만족
  - 슈퍼키 : 유일성은 만족하지만, 최소성(Not null)은 만족하지 않음
  - 대체키 : 후보키 중 기본키를 선정하고 남은것

![](http://www.jidum.com/upload/ckeditor/2016/08/20160801143028964.png)



#### 식별자 종류

- 대표성, 생성여부, 속성의 수, 대체여부에 따라 분류됨.



1. 대표성

   주식별자 : 유일성, 최소성을 만족하면서 엔티티를 대표, 참조 연결 가능

   보조 식별자 : 유일성, 최소성을 만족하지만, **대표성을 만족하지 못함**

2. 생성여부

   내부 식별자 : 엔티티 내부에 스스로 생성되는 식별자 (부서코드, 주문번호등)

   외부 식별자 : 다른 엔티티와의 관계로 만들어지는 식별자(계좌 엔티티, 회원ID)

3. 속성의 수

   단일 식별자 : 하나의 속성으로 구성 ( 회원ID)

   복합 식별자 : 두개 이상의 속성으로 구성됨

4. 대체 여부

   본질 식별자 : 비즈니스 프로세스에서 만들어지는

   인조 식별자 : 인위적으로 만들어지는 



## 2. 데이터 모델링

### 정규화

- Normalization
- 데이터의 일관성, 최소한의 데이터 중복,데이터 유연성 확보를 위한
- 중복을 제거하거, 독립성을 확보하기 위한 **방법**
  - <u>일관성, 유연성, 중복제거</u>

- 정규화절차

  1. 제1정규화

     기본키설정, 속성의 원자성?을 확보한다.

  2. 제2정규화

     기본키가 2개이상이면, **부분 함수 종속성**을 제거한다

  3. 제3정규화

     기본키,주식별자를 제외한 칼럼간 종속성을 제거

  4. BCNF

     후보키가 있는 경우, 후보키가 기본키를 종속시키면, 분해함

  5. 제4정규화

     여러 칼럼들이 하나의 칼럼을 종속시킨다면, 분해함

  6. 제5정규화

     조인에 의해 종속성일 발생되는 경우 분해함



#### 제1정규화

- 함수적 종속성은 X가 변하면, Y가 변하는지 확인하는 것. 변한다면? 종속성이 있다고 판단함.
- 어떤것을 기본키로 할 것인가? 가 제1정규화의 핵심 포인트



#### 제2정규화

- 부분 함수 종속성?

  기본키가 2개 이상의 칼럼에서 발생하는데,

  X값의 속성 중 하나가, 부분적으로 변화했는데도, Y값이 변하는 결과를 초래하는 것을 의미함.

- 이러한 것이 발생한다면, **분해** 해야한다.



#### 제3정규화

- 이행 함수 종속성?

  기본키를 제외한 칼럼간 종속성 발생.

- 제1,2정규화 이후 발생해야하는 정규화 과정

- X-> Y의 종속성이 아닌, Y의 속성간의 종속적인 결과를 초래하는 것.



#### BCNF

- Boyce-Codd-Normalization-Form

  복수의 후보키가 있고, 후보키가 복합 속성이어야 하며, 서로 중첩되어야 한다.

- 후보키? <u>최소성과 유일성을 만족시키는값</u>

![](http://www.jidum.com/upload/ckeditor/2016/07/20160725112715905.PNG)

- 교수는 후보키. 기본적으로 기본키인 학번, 과목이 교수를 함수적으로 종속하고있는데,
- 교수가 과목을 함수적으로 종속하는 결과를 가지고 있음
- 이럴 경우 분해가 일어나고
- 교수 테이블을 **새로** 만들어서, 기본키는 교수, 그리고 칼럼은 과목번호가 되는 것을 만들어야함 
- 이과정을 BCNF라 함



#### 정규화 문제점

- 정규화는 조회시, 조인(Join)을 유발하기 때문에, CPU와 메모리를 많이 사용함.
- 이러한 성능저하를 해결하기 위해, **반정규화**를 사용



### 반정규화

- DB성능향상을 위해, 데이터 중복을 허용하고, 조인을 줄이는 방법
- 조회 속도는 향상, 데이터 모델의 유연성은 낮아짐



#### 언제?

- 정규화를 통해 수행속도가 느려질때
- 다량의 범위를 자주 사용할 때
- 특정 범위 데이터만 처리하는 경우
- 요약/집계 정보를 자주 요구하는 경우



#### 반정규화 기법

1. 미리 계산된 칼럼 추가

2. 테이블을 수직분할

   하나의 테이블을 기준으로 새로운 테이블을 만드는 방법, <u>칼럼을 분해</u>

3. 테이블을 수평분할

   <u>특정 값</u>에 따라서 테이블을 분할

4. 테이블을 병합

   1대N, 1대1관계 테이블을 병합

   슈퍼타입, 서브타입 관계(부모자식관계) 발생시 테이블을 통합



#### 분산 데이터베이스

- 여러명의 사용자가 하나의 데이터베이스 관리시스템에 접속하여 사용하는 구조? 

  중앙 집중형 데이터 베이스

- 물리적으로 떨어진 데이터 베이스에, 네트워크 연결, 이미지는 단일 데이터 베이스 같지만

  분산된 작업 처리를 수행하는 데이터 베이스를 의미함

  고객은 인식 못함 나눠져 있는지

- 즉 데이터베이스의 **투명성**을 제공해야함

- 투명성 종류?

  분할, 위치, 지역사상,중복, 장애 및 병행

  분할

  위치 : 데이터가 어느 위치에 있더라도 동일한 명령을 사용하여 데이터 접근

  중복 : 데이터가 중복되더라도, 데이터의 일관성을 유지

  장애 : 통신망에 이상이 발생하더라도, 데이터 무결성 보장

  병행 : 동시에, 트랜잭션 수행해도 결과에는 이상없도록



#### 설계방식

- 상향식, 하향식
- 상향식 : 지역 스키마 작성 후 전역 스키마 작성
- 하향식 : 전역 스키마 작성 후 , 지역 스키마 작성
- 데이터베이스 미들웨어(ODBC,JDBC)



- 장점

  신뢰성,가용성 높음, 빠른응답 가능, 용량확장 쉬움

- 단점

  관리통제가 어려움, 무결성관리 어려움, 설계가 복잡