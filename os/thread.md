- [[process]] 는 하나 이상의 [[os/thread]] 를 반드시 포함한다.
- [[process]] 내에서 실행되는 작업의 단위
- 즉 하나의 프로세스에 여러 스레드가 존재할 수 있음.
	- 여러 프로세스는 프로세스가 제공하는 동일한 메모리 공간을 공유함.

## 스레드 메모리 구성
- 공유 메모리
	- 같은 프로세스의 코드 섹션, 데이터섹션, 힙은 프로세스 안의 모든 스레드가 공유
- 개별 스택
	- 각 스레드는 자신의 스팩을 가지고 있음.

## 프로그램이 실행된다는 것의 의미
- 프로그램이 실행되면..
	- 운영체제는 프로그램을 메모리에 불러오면서 프로세스를 만듬.
- 프로세스는 어떻게 실행됨?
	- 프로세스 안에 코드가 한 줄씩 실행되는 것
	- 스레드(실, 실을 꿰다)가 실행함
		- 코드를 위에서 아래로 내려가면서 하나씩 꿰는 것

## Reference
- https://www.inflearn.com/course/lecture?courseSlug=%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B3%A0%EA%B8%89-1
