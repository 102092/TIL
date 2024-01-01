# 만들면서 배우는 클린 아키텍쳐

## 01
- 기본적인 구조는 웹 -> 도메인 -> 영속성
- 이게 계층형 아키텍쳐
- 이 구조의 문제는?
	- 데이터 베이스 중심 설계가 됨.
- 데이터 베이스 중심 설계가 되는 가장 큰 원인은 ORM 
- ORM을 사용함으로써 비즈니스 규칙을 영속성에 섞게 됨. (이게 편하니)
	- 문제는 영속성 계층과 도메인 계층에서 생기는 **강한 결합**
	- 이 결합의 증거가 eager, lazy loading, transaction, cache flush등을 서비스 계층에서 진행하게 된다는 것.
- 영속성 계층이 비대해지거나, 웹에서 직접 영속성 계층에 접근하게 되면.. 테스트하기 어려워짐.
	- 왜 테스트 하기가 어려워짐?
	- 테스트 코드 작성하는 것보다 종속성을 이해하고, mock을 주입하는 거에 시간이 더 오래 걸린다.
	- 맞는 말인듯.
- UserService에 모든 유저관련된 로직이 있는 것보단, RegisterUserService와 같이 나누는게 낫다.

## 02
- 의존성 역전
- 단일 책임 원칙
	- 컴포넌트를 변경하는 **이유** 는 오직 하나 뿐이어야함.
	- 단일 변경 이유 원칙이 더 맞겠다.
- JPA...와 같은 ORM을 사용하면 도메인 계층은 영속성 계층에 대해 의존하고 있음.
	- 그러면 영속성 계층이 변경되면?
	- 도메인 계층도 변경되어야함.
	- 이 의존성을 어떻게 없앨 수 있을까? -> 의존성 역전
	- 도메인이 영속성에 의존하게 하는 것이 아닌, 영속성이 도메인에 의존하도록 해야함.

![](data:image/png;base64,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)

1. 도메인에 리포지토리 인터페이스를 만듬. (도메인에 대한  행동)
2. 이 인터페이스를 기반으로 영속성 계층에서 구현체를 만듬
3. 그리고 영속성 계층에서 ORM에서 관리하는 엔티티도 가지고 있고.

- 위와 같이 하면, 도메인이 영속성 계층에 의존하는 것이 아닌, 영속성 계층이 도메인 (리포지토리 인터페이스) 에 의존하고 있다고 할 수 있음. -> (신기하고 적용해보면 좋을 것 같다고 느껴진다)
- 이렇게 하면, 영속성 구현체가 바뀌어도 (jpa -> mybatis) 도메인 계층의 변경은 없고 영속성 계층에서 변경만 일어날 것.

- 헥사고날 아키텍쳐
	- 왜 헥사고날?
	- 어플키에션은 다른 시스템 혹은 어댑터와 연결되는 면이 4개 이상 될 수 있다는 의미.

## 03
- AccountService -> SendMoneyService
	- AccountService의 책임을 줄이기 위해서
- 기능에 의한 패키징 방식은 계층에 의한 패키징 방식보다 가시성을 훨씬 떨어트린다.
- `adapter.in.web` -> 어댑터 역할인데 web으로 들어오는걸 처리하는 녀석들.
	- 위와 같이 표현력 있는 구조는 코드와 아키텍쳐 간의 갭을 줄일 수 있게 해줌.
- 클린아키텍쳐의 본질은 애플리케이션 계층이 인/아웃 어댑터에 대해 의존성을 갖지 않도록 하는 것.

## 04

- `ActivityWindow`, 계좌의 활동 (입금이나 출금) 을 나타내는 도메인인듯.
- 입력 유효성 검사는 어플리케이션 계층에서 해야함.
- `SelfValidating` 괜찮은듯.
	- 입력 모델에서 유효성 검사하는 방법
- 불변 커맨드 객체의 필드에 대해서 `null` 을 유효한 상태로 받아들이는 것 그 자체로 코드 냄새 (리팩토링...이나 수정의 필요성이 있는)
- 입력 유효성 검증은 유스케이스 로직의 일부가 아님.
	- 그렇지만 비즈니스 규칙 검증은 분명히 유스케이스 로직의 일부
	- 비즈니스 검증 규칙은 어디에? -> 보통 도메인 내부에

## 05

- 어댑터와 유스케이스 사이에 왜 간접계층 (인터페이스...) 를 넣어야함?
	- 어플리케이션과 외부가 통신할 수 있는 명세가 필요하기 때문
	- 이게 포트이고 보통 인터페이스 정의함.
- 웹 어댑터의 입력 모델을, 유스케이스의 입력보델로 변환할 수 있다는 것을 검증해야함.
- 클래스마다 코드는 적을수록 좋다.

## 06

- 영속성 어댑터의 역할을 데이터베이스로 데이터를 요청하거나, 받는 역할 그리고 데이터 포맷을 변경하는 역할.
	- AccountPersistenceAdapter
- 도메인 - 영속성 모델 맵핑 방식을 이용하는게 낫다 왜?
	- 그러면 풍부한 도메인 모델을 생성할 수 있음.
	- 도메인에 기본 생성자를 안 만들 수도 있고..

## 07

- 의존성과 상호작용하고 있으면 통합테스트에 가까움.
- 영속성 어댑터 테스트는 실제 데이터베이스 (인메모리가 아닌) 대상으로 진행해야함.
	- `testcontainers` 같은 라이브러리 사용, 필요한 데이터베이스를 도커 컨테이너에 띄울 수 있음.
- `@SpringBootTest` 어노테이션을 이용하는 테스트에서는 `MovMvc` 를 이용하지 않고, `TestRestTemplate` 으로 실제 프로덕션 환경에 더 가깝게 테스트할 수 있도록 함.
- 도메인 엔티티, 유스케이스는 -> 단위 테스트로 커버
- 어댑터는 통합 테스트
- 사용자가 취할 수 있는 중요 어플리케이션 경로는 시스템 테스트 (`@SpringBootTest`와 같은 형식. 모든 필요한 리소스를 띄우고 실제 프러덕션 환경에 가깝게 테스트 하는 것.)

## 08

- No mapping
	- port.in interface(SendMoneyUseCase)와, port.out interface(UpdateAccoutStatePort) 가 도메인인 Account에 직접 의존하게 되면...
	- Account class는 책임 지는 계층이 증가함. 그러면 port.in에서 비롯된 변화가, port.out까지 전파될 수 있음. 단일 책임 원칙에 어긋남
- two way mapping
	- 웹 계층에서는 웹 모델을 인커밍 포트와 필요한 도메인 모델을 맵핑. 인커핑 포트에서 반환된 도메인 객체를 웹 모델로 맵핑
	- 즉 웹 계층이 웹 모델에 의존. 인커밍 포트는 도메인 모델에 의존. 그러면서 웹 계층은 인커밍 포트에 의존해서. 양방향인듯. (웹 -> 웹 모델, 웹 -> 인커밍 포트)
- full mapping
	- SendMoneyCommand 처럼, 각 작업에 특화 모델을 각자 사용하는 것 (각 계층마다.. 행동에 맞는 DTO를 만들어주는 걸 의미하는 듯.)
- one way mapping
	- 모든 계층의 모델이 같은 인터페이스를 구현하는 것.
- 아직 이 부분에 대한 차이점은 잘 이해가 되지 않음.

## 09

- 유스 케이스가 영속성 어댑터를 호출해야하고, 인스턴스화 한다면 코드 의존성이 잘못된 것.
	- 그 중간에 있는 입력 포트, 출력 포트를 호출해야함.
- 객체 인스턴스를 생성할 책임은, 설정 컴포넌트에게 있음.
	- 스프링 IOC 컨테이너에서 DI를 해주는 부분이지 않을까 (설정 컴포넌트)

## 10

- 아키텍쳐 경계를 강제하기 위한 도구는.. 접근 제한자
- package-private (default)
	- 모듈 내에 있는 클래스끼리는 서로 접근 가능하지만, 패키지 밖에서는 접근할 수 없음.
	- 그러면 모듈 진입점으로 활용될 클래스만을 골라서 public으로 만들면 됨 (e.g. SendMoneyCommand 같은 클래스)
- 이걸 사용하면 어떤 장점?
	- 의존성이 잘못된 방향을 가리켜서, 의존성 규칙 (안쪽을 바라봐야함..)을 위반할 위험이 줄어들게 됨.
- `ArchUnit` , 의존성 방향이 기대한 대로 잘 설정되어 있는지 체크하는 API 제공

## 11

- 지름길은 깨진 창문.
	- 한번 가기 시작하면 다시 고치기 힘들다.
	- 다른 부분에도 영향을 미친다.

## 12

- 외부 영향을 받지 않고, 도메인 코드를 자유롭게 발전시킬 수 있다는 것이, 육각형 아키텍쳐 스타일의 가장 중요한 가치