## 설명
- 퍼사드 패턴
- 다른 클래스의 복잡한 집합에 대한 단순하된 인터페이스를 제공하는 패턴
	- 즉 해당 인터페이스에는 간단한 동작들만 있고,
	- 복잡한 액션은 다른 클래스들에서 한다
- 퍼사드 클래스 (보통 인터페이스) 만들어서, 상세 기능 역할을 하는 클래스들을 캡슐화 함
- 퍼사드 클래스가 커지만, **다른 퍼사드 클래스로 추출하는 것**도 고려해야함

## 예시
![image](https://refactoring.guru/images/patterns/diagrams/facade/structure-indexed.png?id=2da06d6b850701ea15cf72f9d2642fb8)
- 클라이언트는 `Facade` 패턴이 적용된 인터페이스를 가지고만 통신을 하고,
- 복잡한 하위 시스템들을 3번에서 자신이 일을 한다.

## 기타
- Adapter pattern과 비슷한 느낌
	- facade는 인터페이스 - 많은 하위 객체
	- adapter는 일반적으로 하나의 객체만 랩핑함

## 정리
- 퍼사드 패턴을 왜 사용하는가?
	- 복잡한 서브 시스템들을 인터페이스로 감싸서 간단하게 만드는 목적
	- 비즈니스의 흐름을 좀 더 한 눈에 보기 쉽게 하기 위해서

## 참고
- https://refactoring.guru/ko/design-patterns/facade
- https://www.tutorialspoint.com/design_pattern/facade_pattern.htm
- https://www.geeksforgeeks.org/facade-design-pattern-introduction/
- https://imasoftwareengineer.tistory.com/29
