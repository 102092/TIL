## architecture

![kor](https://user-images.githubusercontent.com/48278519/148185755-af1d5287-4380-4fdb-b764-a9d05a1abd37.png)

![eng](https://media.geeksforgeeks.org/wp-content/uploads/20210211183907/MySQLArchi.png)

- 주요된 부분은 1. 클라이언트, 2. 서버 3. 스토리지 레이어
- 클라이언트 사이드에는 1. Connection handling, 2. Authentication, 3. Security 가 주요 기능
- 서비스 레이어 (서버) 는 **Brain of MYSQL Architecture** 라 불림
	- 주요 처리가 모두 이 레이어에서 일어나고 그만큼 중요하다는 의미인듯.

### server
- 서비스 레이어

### thread Handling
- 클라이언트와 서버를 연결하는 스레드를 관리.
- 클라이언트에서 요청원 쿼리들을 어떤 스레드에서 실행할지도 결정하는듯.

### parser
- SQL 문법에 대한 오류 탐지.
- 넘어온 쿼리 문장을 토큰 단위 나눠서 트리 형태로 파싱하는 작업을 담당

### optimizer
- 파싱이 끝나면, 다양한 최적화 기술이 적용됨.
- 여기서 최적화 기술은 쿼리를 다시 쓰거나 혹은 테이블 스캔 순서를 변경하거나 적절한 인덱스를 선택하는 걸 의미

### query cache
- 쿼리 실행에 대한 결과를 저장하는 곳
- 파싱 이전에 쿼리 캐시를 확인함.
- 만약에 클라이언트에서 요청 온 쿼리가 캐시에 있다면 (identical), 서버는 parsing, optimization 심지어 실행결과도 스킵함.
	- 캐시에 있는 결과를 리턴함.

### buffer and cache
- 클라이언트가 쿼리를 요청하면 제일먼저 쿼리 캐시 확인 한후에 동일한 쿼리가 캐시에 있다면..
- parser, optimizer 거치지 않고, 쿼리에서 결과 리턴

## table metadata cache
- 데이터베이스, 인덱스등의 정보를 추적하기 위한 데이터를 저장하는 곳.

## storage engine
- 스토리지 레이어
- 어떤 스토리지 엔진을 선택하냐에 따라서 다르게 동작할 수 있음.
- 스토리지 엔진?
	- 서비스 
 
 필요한 데이터를 물리적인 장치에서 가져오거나 저장하는 역할
	- 대부분 `InnoDB` 이용 

---
## 참고
- https://www.geeksforgeeks.org/architecture-of-mysql/
- https://github.com/alstjgg/cs-study/blob/main/%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4/SQL%ED%8A%9C%EB%8B%9D%201%20-%20%EA%B8%B0%EB%B3%B8%EC%9A%A9%EC%96%B4.md