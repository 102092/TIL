#thread #virtual-thread
## 배경
- 제한된 메모리 환경에서 사용할 수 있는 [[thread]] 의 수가 제한되어있음.
- 또한 필요한 스레드 수가 증가하면서, [[context-switching]] 비용도 증가함.
- 위의 2가지 문제점을 해결하기 위해 나온 개념이 [[virtual-thread]].

## 특징
- [[context-switching]] 비용이 저렴하다
 
![image](https://github.com/102092/TIL/assets/22140570/d4a159dd-f7f2-48a3-909a-c93076a8e474)


- 왜?
	- `platform thread` 위에서 여러 `virtual thread` 가 번걸아가면서 실행되는 형태
	- 기존 방식보다 점유하는 메모리 사이즈가 적고, 커널 영역의 호출이 적음

## 구조
![image1](https://techblog.woowahan.com/wp-content/uploads/2023/12/6.png)

![image](https://github.com/102092/TIL/assets/22140570/0616f192-0a4e-4365-ba20-e4712f582162)

- 스케쥴러가 `platform thread` 를 관리한다.
- `platform thread` 는 `virtual thread` 의 작업 분배를 관리한다 

![image2](https://techblog.woowahan.com/wp-content/uploads/2023/12/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA-2023-12-06-%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB-1.12.45.png)

- `virtual thread`는 `carrierThread` 를 가지고 있다.
	- `carrierThread` 는 `platform thread` 이다.
	- `carrierThread` 는 `workQueue`를 가지고 있다.
- `virtual thread` 는  `scheduler` 를 가지고 있다.
	- `scheduler` 는 `ForkJoinPool` 이다
	- `scheduler` 는 `carrierThread` 의 poll 이다
	-  `scheduler` 는 `virtual thread` 의 스케쥴링을 담당한다
- `virtual thread`  는 `runConfiguration` 을 가지고 있다.
	- `runConfiguration` 은 실제 작업 내용(`runnable`) 을 가지고 있다

## 정리
- `virtual thread` 는 기존 `platform thread` 를 대체하는 것이 목적이 아님.
	- `platform thread` 의 기다림에 대한 개선이 목적.
- `virtual thread` 를 도입한다고 해서, 무조건적으로 처리량이 높아지진 않음.
- 리액티브 프로그래밍과 동일하게 '처리량' 은 증가하지만 더 가독성이 좋고, 개발자 친화적인 방법이다.

## Reference
- https://techblog.woowahan.com/15398/
- https://tech.kakao.com/2023/12/22/techmeet-virtualthread/