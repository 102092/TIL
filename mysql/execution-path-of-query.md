
![](https://user-images.githubusercontent.com/48278519/148187887-b382bd9a-7cad-4847-b56e-22bdc6db3706.JPG)


![](https://miro.medium.com/max/720/1*bRSpYp9FPEveovLosWVP0A.webp)


## 쿼리 실행 구조에 대한 설명

### 1. Parser
- 쿼리 문장 문법(Syntax) 확인
- 쿼리 문장을 적절한 토큰으로 나눠서 트리 형태로 만듬.
- 이때 생성되는 트리는 `>`, `<`, `=` 등의 기호나 SQL 키워드로 분리됨.
	- 이러한 트리 생성할 때, 타당한지, 적절한 위치에 있는 확인함.

### 2.  Preprocessor
- `Parser` 가 생성한 tree에 대해 파서는 할 수 있는 추가적인 semantics를 확인함.
	- 예를 들면 테이블이나 컬럼이 존재하는 지 확인
	- `names` 나 `aliases` 가 애매모호하게 선언되어있지 않은지 확인
	- 그리고 privileges(아마도 권한 여부, 쿼리 실행이 가능한지 여부인듯.) 가 있는지 확인

### 3. Optimizer
- 여기까지 왔으면 쿼리는 실행 가능하다고 봄.
- 이제 쿼리 실행 계획(query execution plan) 을 판단함. 
- 옵티마이저가 하는 건 이 쿼리를 실행하기 위한 best option은 무엇인지 확인하는 것.
	- mysql 은 cost-based optimizer를 사용하는데 이 이야기는 여러개의 실행계획 중에서 가장 비용이 적게 드는 실행 계획을 선택하다는 것.
![e.g last_query_cost](https://miro.medium.com/max/614/1*y8QHf33NsBNT4udyXem1fw.webp)
- `10.499000` 란 숫자는 10 random data page를 읽어야한다는 의미.

## 참고
- https://shashwat-creator.medium.com/mysqls-logical-architecture-1-eaaa1f63ec2f
- https://github.com/alstjgg/cs-study/blob/main/%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4/SQL%ED%8A%9C%EB%8B%9D%201%20-%20%EA%B8%B0%EB%B3%B8%EC%9A%A9%EC%96%B4.md