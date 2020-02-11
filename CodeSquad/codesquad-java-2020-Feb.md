## codesquad-Java-2020-Jan

> 목표

- 매일 했던 것을 정리
- 부족했던 부분 + 더해야할 부분도 정리하자



> 목차

- [1-week](#1-week)
- [2-week](#2-week)



## 1-week

### 02-03 Mon

> done

- [x] step1작성
- [x] Java 12.4 ch 동영상 시청 + 코드 작성

- [x] step2
- [x] Java 12ch 동영상 시청

- [x] 알고리즘 1문제

- [x] 독서 (만화로 읽는 CPU)



### 02-04 Tue

> done

- [x] step2 pull request

- [x] Java 12.6까지 강의 시청

- [x] 알고리즘 1문제(프로그래머스) Top

- [x] 독서 만화로 1ch





### 02-05 Wed

> done

- [x] 알고리즘 1문제

- [x] 깃 연습 (https://learngitbranching.js.org/) 
  - git pull == git fetch + git merge
  - git rebase -i HEAD~2
    - interation option으로 현재 헤드에서 두번째 위까지 커밋을 rebase 하겠다.
    - 원격 저장소 + 고오급 문제 남았다.



> to do



### 02-06 Tue

> done

- [x] 상담
- [x] 오전 15- mission,  gist 정리
- [x] 독서 
- [x] 선택 정렬 손으로 써보기



### 02-07 FRI

> done
- [x] step 3 , Step 2 Review 바탕으로 개선.
- [x] 소팅 알고리즘 하나 정리(BubbleSort + BubblSort(swapped flag)

---




### 02-08 ~ 09 SAT ~ SUN

> done
- [x] 오전 미션 step3 정리하기, 다른 분들꺼 보면서 




## 2-week

### 02-10 MON

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



### 02-11 Tue

> done

- [x] InsertionSort Baisc
- [x] Programmers : SQL GROUP BY (1)
- [x] 프로그래머스 : 탐욕법 greedy
- [x] step 4




> todo

- [ ] 깃 연습 (https://learngitbranching.js.org/)  , 원격 저장소 + 고급 문제
- [ ] 이분 탐색에 대해

