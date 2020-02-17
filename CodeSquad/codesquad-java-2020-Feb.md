## codesquad-Java-2020-Feb

> 목표

- 매일 했던 것을 정리
- 부족했던 부분 + 더해야할 부분도 정리하자



> 목차

- [1-week](#1-week)
- [2-week](#2-week)
- [3-week](#3-week)



## 1-week

### 02-03 월

> done

- [x] step1작성
- [x] Java 12.4 ch 동영상 시청 + 코드 작성

- [x] step2
- [x] Java 12ch 동영상 시청

- [x] 알고리즘 1문제

- [x] 독서 (만화로 읽는 CPU)



### 02-04 화

> done

- [x] step2 pull request

- [x] Java 12.6까지 강의 시청

- [x] 알고리즘 1문제(프로그래머스) Top

- [x] 독서 만화로 1ch





### 02-05 수

> done

- [x] 알고리즘 1문제

- [x] 깃 연습 (https://learngitbranching.js.org/) 
  - git pull == git fetch + git merge
  - git rebase -i HEAD~2
    - interation option으로 현재 헤드에서 두번째 위까지 커밋을 rebase 하겠다.
    - 원격 저장소 + 고오급 문제 남았다.



### 02-06 목

> done

- [x] 상담
- [x] 오전 15- mission,  gist 정리
- [x] 독서 
- [x] 선택 정렬 손으로 써보기



### 02-07 금

> done
- [x] step 3 , Step 2 Review 바탕으로 개선.
- [x] 소팅 알고리즘 하나 정리(BubbleSort + BubblSort(swapped flag)

---




### 02-08 ~ 09 토~일

> done
- [x] 오전 미션 step3 정리하기, 다른 분들꺼 보면서 




## 2-week

### 02-10 월

> done

- [x] Tdd 영상 시청
- [x] singleton- pattern



> class

- [https://lucas.codesquad.kr/course/masters-java-backend/Java-tip/awt-%EA%B8%B0%EC%B4%88](https://lucas.codesquad.kr/course/masters-java-backend/Java-tip/awt-기초)

- AWT
  - gui 프로그램에 가장 중요한 점은, 사용자의 입력을 받는 부분.
  - while문으로, 화면으로 뿌려주는 코드를 반복해주고 있음.
  - GUI 프로그램은 기본적으로 싱글 스레드.
    - 특히 사용자의 입력을 받는 부분은 싱글 스레드로 해야함.
    - 왜? 데드락이 걸릴 가능성이 높기 때문에, 프로그램의 안전성을 위해서.

- AWT 문제점
  - 모든 디자인을 코드로 작성해야함.

- 기본적으로 운영체제가 이벤트를 제어하고 있음.

- 콜백함수는 함수는 함수 인데, 내 가 실행하지 않는 함수를 일컫는 다.
  - 콜백함수는 형식이 정해져 있음.
  - `ActionListener` 인터페이스

- 익명 클래스는 객체
  - 람다는 함수이면서 객체라는 뜻.
  - 자바의 람다는 함수를 객체로 만들고 싶었음.
  - 인터페이스를 만들고, 함수를 하나만 만들어서 이를 통해서 객체를 만듬.
  - `Functional keyword` 를 사용하여

- handler가 있다면, handler 코드를 실행하고, 아니면 버리고.
- 자바 스크립트는 비동기가 일방적.
- 오래걸리는 I/O 작업은, 이벤트 핸들러로 처리하면 안됨.
  - 그러면 어떻게 처리함? 음.. 그러면 별도의 쓰레드로 만들어서 처리해야함.
  - 그림을 그리는 것은 반드시 Main 쓰레드에서 처리해줘야함.

- 가능하면 몬스터 레이스 GUI 버젼을 해보자



### 02-11 화

> done

- [x] InsertionSort
- [x] Programmers : SQL GROUP BY (1)
- [x] 프로그래머스 : 탐욕법 greedy
- [x] step 4





### 02-11 수

> done

- [x] Java 복습 Generic , Lamda
- [x] 프로그래머스 SQL : group by 2
- [x] 프로그래머스 heap : 더 맵게



### 02-12 목

> done

- [x] Leetcode 1문제
- [x] 프로그래머스 SQL
- [x] Java 복습 stream



> class

- 배열이 왜 0부터 시작할까?
  - C언어에서 배열을 참조하는 문법을, Java에서 좀 더 쉽게 이해할 수있도록 변경한것.
  - 1부터 시작했으면, 무언가 저장할 때 맨 처음이 비었음.
  - substring 에서 한글자만 가져오려면? subString(0,1); == 배열과 똑같음ㅋㅋ
- [x] JVM의 공간 정리해보자

- 코딩은 대화
  - 1차적으로 컴퓨터와
  - 그리고 동료하고.
  - 그러니까 동료들이 읽기 좋은 글이 좋은 코딩 스타일
  - 그렇지만 목적에 따라 코드를 짜라.
- 일단 짜고, 문제가 발생하면 대응하라.



- 함수형 프로그래밍
  - 최근에 중요해졌음.
  - 왜? web scale의 시대.
  - CPU 발전의 한계
  - 동시성 이슈를 처리하기 위한 방법.
    - 객체 지향 프로그래밍에서 자주 발생하는 문제
    - 왜? 행동을 통해 상태를 조정하기 때문에
    - 즉 병렬 프로그래밍에서 원하지 않는 사이드 이펙트를 막기 위한 방법.
  - 코드의 생산성이 상대적으로 좋음.
    - 왜 서버의 가격이 너무 저렴해졌음.
    - 성능의 우선순위가 낮아졌음.
  - 객체지향적으로 코드를 짜려다보면, 코드가 복잡해지는 경우가 많음.
    - 자바가 너무 견고한 객체지향 프로그래밍을 요구한다.
  - 변경 불가능한 값을 활용함.
    - 왜? 동시성 이슈를 방지하기 위해.
    - 그대신 메모리적으로는 안 좋음
  - 함수가 1등시민
    - 함수를 매개변수로 사용할 수 있음.
    - 함수 안에 함수를 선언할 수 있음.
- 람다
  - 이름이 없는 함수.
  - 람다가 없던 시절에는 함수를 매개변수로 받을 수 없었음.
  - 그래서 인터페이스(메서드를 하나만 가진)를 만들고 이 인터페이스를 구현한 객체를 람다가 실행시키는 방식이었음. @FunctionalInterface

- 클로저
  - 개념적 정의 : 어떤 1급 함수가 , *외부 함수에 접근할 수 있는 것*을 가지고 있는 저장단위를 클로저라함.

- 고차 함수
  - or 고계 함수
  - 함수를 인자로 받아들어거나, 리턴 하는 함수.

- filter
  - if문 하나 더 쓰는 것.
- map
  - 각각 원소들에 뭔가 조건을 더 더하는 것.

- reduce
  - 차원이 줄어드는 경우
  - 데이터가 줄어듬. 배열에서 원시값 이런식으로.

> next mission

- [ ] HTTP 공부
- [ ] Java 로 웹서버 만들어보기
  
- [ ] REST API 지원
  
- flatMap

  - https://www.geeksforgeeks.org/stream-flatmap-java-examples/
  - Map은 원소를 가공하여 스트림에 반환함.
  - flatMap은 원소를 가공하여 스트림 혹은 Optional로 반환?
  - 중간 연산
    - 그래서 항상 지연된다. 
    - 종단 연산이 되기 전까지.

  



### 02-13 금

> done

- [x] leetcode 1문제
- [x] 프로그래머스 sql
- [x] step4 중복 우승자
- [x] Monsters class refactor
- [x] step4 pull request
- [x] 목요일 수업 복습
- [x] 턱걸이 6 * 3 set



> retrospective

- 회고 정리해야함.
- 짦은 단기 목표 세우기.



---

#### JVM

- 왜?
- Java 운영체제에 독립적으로 작동하도록 하기 위해서.
- 운영체제에 종속적이면, 운영체제마다 다른 Java를 만들어야 하나?

![](https://lh4.googleusercontent.com/6WFR269BkOXIAaZxySgJt4ZOFKDPgN_G5lOa0eKtpW3add440v_wTdqe-pbs64BimfEY4R3f6hKB_fCbTh55SD-OcgDFexD0dA8ulqblZe1aB0yY_7o7PQ-MKA)

- `.java` 파일이, Complier 를 통해서  `.class` 파일로 컴파일됨.
  - Java Complier는 .java 파일을 byte code로 변환한다.
- Runtime Data Areas 중에, 
  - heap, Method 영역은 모든 Thread에 공유됨.
  - 즉 heap 영역은 멀티스레드 환경에서 안전하지는 않겠네.
- Main 에서 실행시키면, Class Loader가 해당 컴파일된 .class 파일을 메모리(Runtime Data Area) 에 올림



##### PC registers

- Thread가 생성될 때마다 , 공간이 새로 생기는데 해당 Thread가 어떤 명령을 수행할지 기록함.



##### Method Area

- 클래스의 인스턴스 변수, 메소드, 클래스 변수(static)이 저장되는 곳.
  - 프로그램 실행 시에 위의 것들이 자동적으로 저장되진 않음.
  - new 키워드로 인스턴스가 생성되면 저장됨.

##### heap

- 클래스의 인스턴스가 생성되는 공간.
  - 동적 할당 공간.
- 즉 객체가 이 공간에 생성된다.
- 이 영역이 GC(Garbage Collector)가 활동하는 영역
  - 즉 객체의 참조가 없어지면, GC가 활동하여 메모리에서 비워준다.
  - 이 과정이 생각보다 자원을 많이 잡아먹는 일.



##### JVM Stacks

- Thread 제어를 위한 메모리 영역
  - Thread가 생성될 때 마다, 하나씩 생성.
  - Method가 호출되면, 해당 정보가 Stack에 쌓이고, 
  - 해당 메서드 호출이 종료되면, Stack point에서 제거.
- 해당 메서드의 매개변수, 지역변수, 임시변수, 어드레스등을 저장.
- 정적 메모리 할당.
  - 정적으로 할당되니, 메모리 누수같은 것은 신경 안써도 됨.
  - 회수도 운영체제가 알아서.
  - 그렇지만 메모리 크기가 정해져 있으니, 조절할 수 없다는 점이 단점.
- 이부분이 비어져 있으면, 프로그램이 종료된것.



##### Stack with Heap

- 정적으로 할당된 스택에서 메모리의 참조 값을 힙에서 쓸 수 있도록 만들어줌.
- 만약 스택에서 null이 있다면, Heap에서 참조할 수 없음. 그러면 NullPointerException



#### String literal pool

- String 은 `new` 연산자를 이용하여 생성하거나, literal을 이용하여 생성하는 방법이 있음.

- `new` 로 생성된 것은 heap 영역에 생성되고,

- literal 로 생성된 것은  `string constant pool` 에 생성됨.

  ```java
  public class StringMemory {
  
      public static void main(String... args) {
          String literal = "loper";
          String object = new String("loper");
  
          System.out.println(literal == object);
          System.out.println(literal.equals(object));
      }
  }
  ```

  - `==` 객체의 주소값을 비교 --> false
  - `equals` 문자열을 비교 --> true

- string을 literal 로 생성하게 되면, 기본적으로 `intern()` 메서드에 의해서 `string constant pool` 에 해당 literal이 있는 지 우선 확인

  - 없으면, literal을 넣고, 그 주소값을 반환.

  ```java
  public class StringMemoryIntern {
  
      public static void main(String... args) {
          String literal = "loper";
          String object = new String("loper");
          String intern = object.intern();
  
          System.out.println(literal == object); // false
          System.out.println(literal.equals(object)); // true
          System.out.println(literal == intern); // true
          System.out.println(literal.equals(intern)); // true
      }
  
  }
  ```

- String constant pool은 어느 영역에 있는가?

  - Heap 영역(Java7)
  - 즉 이 String constant pool도 GC의 대상이다.

- Java 8 이하에서는 String은 char의 배열들로 표현되었음. (encoded UTF-16)

  - 즉 모든 캐릭터들을 2bytes를 차지했음 

- Java 9부터는 Compact Strings 라는 표현 방식으로 바뀌었는데, 저장되는 콘텐츠에 따라서 이건 적절한 인코딩 방식을 알아서 선택함. 

  - char[] or byte[] 중에서
  - 왜? 
  - 이 방식은 필요할 때만 UTF-16 인코딩 방식을 채택하고, 그러면 heap 메모리를 차지하는 공간이 엄청나게 낮아짐. 즉 GC의 overhead를 줄여줌.

> 참고

- https://www.holaxprogramming.com/2013/07/16/java-jvm-runtime-data-area/

- [https://postitforhooney.tistory.com/entry/JavaStackHeap-JAVA%EC%9D%98-Stack%EA%B3%BC-Heap%EC%9D%98-%EC%9D%B4%ED%95%B4%EB%A5%BC-%ED%86%B5%ED%95%B4-Java%EC%9D%98-%EB%A9%94%EB%AA%A8%EB%A6%AC-%EA%B4%80%EB%A6%AC](https://postitforhooney.tistory.com/entry/JavaStackHeap-JAVA의-Stack과-Heap의-이해를-통해-Java의-메모리-관리)

- https://www.baeldung.com/java-string-pool

- [https://medium.com/@joongwon/string-%EC%9D%98-%EB%A9%94%EB%AA%A8%EB%A6%AC%EC%97%90-%EB%8C%80%ED%95%9C-%EA%B3%A0%EC%B0%B0-57af94cbb6bc](https://medium.com/@joongwon/string-의-메모리에-대한-고찰-57af94cbb6bc)





### 02-14,15 토-일

> done

- [x] 이것이자바다 ch 17
- [x] JVM, String 정리
- [x] 이펙티브 자바 구입
- [x] HTTP 생활코딩 강의듣기





## 3-week



### 02-17 월

> done

- [x] sql 1
- [x] leetcode 1
- [x] Sprinboot 회원프로필정보보기 까지



> class

- 스프링 부트 따라하기.

  - 교재 보고 할 필요 없음.

- heroku 배포

- ORM 있는 지만 확인하는 수준.

  - 대부분은 spring-jdbc 사용 or Mybatis

- 서블릿

  - 서버에서 돌아가는 자바 어플리케이션을 통칭하는 말.

- www

  - 3대 요소는 알아야함
  - 뭐가있찌?
  - HTTP / HTML / URL

- 정적인 페이지를 처리해주는 서버를 돌리는 

  - apache, ngix

- 동적인 페이지를 처리해주는 == WAS, AppServer

  - 대표적인 WAS는 TOMCAT

  - JSP
  - Servlet

- EJB, 동적페이지 처리 기준. IBM 밀어줌. 망함. 왜? 너무 어려워. 러닝커브가 너무 높아.

- Django, Spring은 개발자가 서버 구현을 위해 필요한 모든 것이 들어있어서, 로직만 구현하면 됨.

- JVM runtime , Node.js runtime(웹서버 기능을 내장하고 있는.)

  - Node.js 는 web server 없어도 돌아감. 싱글 스레드여서

- WEB SERVER - WAS - DB (3-tier)

- Spring
  - Full Framework.
  - 안정적
  - DI, AOP

- 실행주체는 gradle
- handlebar 사용
- 서버에 배포할 때, `gradlew`가 있어야 됨.
- 기본적으로 `jar` java archive 배포.

- handlerbar를 쓰는 이유? 
  - 템플릿에 로직을 넘기지 않기 위해서



### 02-18 화

> done



> todo

- [ ] Java ch 18
- 도서
  - [ ] 헬로우 알고리즘 탐욕알고리즘
  - [ ] 1% 네트워크 쭉 읽기
  - [ ] 데이터베이스 기본
