
- MySQL 5.7
- 프로젝트를 진행하다가 `varchar(50)` 에는 과연 한글을 몇 글자나 담을 수 있을지 궁금해졌다.

## 정리

- 기본적으로 문자열도 00byte로 저장될듯.
- `Char`
	- 고정형 문자열이기에 Char(20)을 했을 경우 **20byte**만큼 공간이 할당된다.
	- 할당된 크기를 넘어가면, 데이터가 잘린다.
	- 할당을 100으로 하고 6만큼만 쓰면, 94는 낭비하는 셈이 됨.

- `Varchar`
	- 가변형 문자열.
	- UTF-8 인코딩 방식은, 아스키 문자를 1byte 한글은 3byte를 차지하고,
	- euc-kr 방식은 아스키 문자는 1byte 한글은 2byte를 차지하는듯.
	- MySQL version 4.1 이전에는 `()` 안에 설정된 수치는 바이트를 의미했지만, 이후에는 즉 현재 프로젝트에서 쓰고있는 버전(5.7...)에서는 **문자수를 의미**한다.
	  - 다시말하면 `varchar(50)` 이면 아스키 문자든, 한글이든지 50자가 입력가능하다라는 뜻.
	- `charater_length(char_length)`는 문자수를 계산하는 연산
	- octet_length는 바이트 수를 계산하는 연산

# 참고
- https://namocom.tistory.com/792
- https://hack-cracker.tistory.com/165
- https://github.com/Hwannnn/wiki/wiki/[mysql]-문자열의-바이트,-저장공간
- http://www.rcy.co.kr/xeb/study/2900
