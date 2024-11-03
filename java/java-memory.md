## 메서드 영역
- method area
- 프로그램을 실행하는데 필요한 공통 데이터 관리
- 클래스 정보
	- bytecode, field, method, consturctor
- static 영역
	- static 변수들
- 런타임 상수 풀
	- 공통 literal 상수 보관

## 스택 영역
- stack area
- 자바 실행 시, 하나의 실행 스택이 생성
- 각 스택 프레임은 지역변수, 중간 연산 결과, 메서드 호출 정보등을 포함
- 스택 프레임?
	- 메서드 호출 할때 마다 하나의 스택 프레임이 쌓이는 것
	- 메서드가 종료되면 해당 스택 프레임이 제거된다.
- 스택 영역은 각 스레드별로 하나의 실행 스택이 생성됨.
	- 즉 **스레드 수만큼 스택이 생성됨**

## 힙 영역
- heap area
- 객체(인스턴스) 와 배열시 생성되는 영역
- GC 가 이루어지는 주요영역


## 참고
- https://www.inflearn.com/course/lecture?courseSlug=%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B3%A0%EA%B8%89-1&unitId=232319&tab=curriculum&subtitleLanguage=ko