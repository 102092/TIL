- 통합 테스트
- 여러 컴포넌트들이 서로 잘 협력하는지 확인하는 테스트
- 주요 특징으로는
	- 여러 컴포넌트가 함계 작동하는 것을 테스트하고,
	- 실제 데이터베이스를 연결하고, 실제 API를 호출하는등, 실제와 비슷한 환경에서 테스트가 진행된다는 점.
- 목적으로는
	- 실제 사용자 시나리오를 검증하고,
	- 배포 전 문제를 찾아내는데 목적이 있음.
- 그 방법으로는 
	- Top-down approach
		- 상위 모듈 -> 하위모튤로 테스트
	- Bottom-up approach
		- 하위 모듈 -> 상위 모듈
	- Sandwich approach
	- Big bang approach

## 참고
- https://circleci.com/blog/unit-testing-vs-integration-testing/
- https://en.wikipedia.org/wiki/Integration_testing