> http://mobile.kyobobook.co.kr/showcase/book/KOR/9788966261208

# 들어가기전에

- 600여페이지.. 3개월 잡고 읽어야할듯?
- 모르는 단어 있으면 기록할것.



# HTTP: 웹의 기초

## 목표

1. HTTP 개관
2. URL 리소스 형식에 대해
3. HTTP 메세지에 대해
4. TCP 커넥션에 대해





## 1장



### 1.1 HTTP

- http? hypertext transfer protocool..

- 규약. 신뢰성이 있는 데이터 전송 프로토콜
  - 즉 HTTP통신 전송 중에는 파일이 파괴되거나, 중복되거나 왜곡되는 걱정이 없어도 된다.

### 1.2 웹클라이언트, 서버

![](https://s3-ap-northeast-2.amazonaws.com/opentutorials-user-file/course/2614/4971.png)

- 클라이언트? 웹브라우저 : 익스플로어 크롬등



### 1.3 리소스

- 웹 서버는 웹 리소스를 관리한다.
- 정적파일? 텍스트, html, 워드, avi..등...
- 동적 리소스? 사용자가 누구인지 어떤 요청인지에 따라서 다른 콘텐츠를 전달해주는 것을 의미함.



#### 1.3.1 미디어타입

- MIME : Multipurpose Internet Mail Extensions
  
- 원래는 각기 다른 전자메일 시스템 사이에서 오가는 메세지가 겪는 문제점을 해결하기 위해 설계 된것.
  
- 웹 서버는 모든 HTTP 객체 데이터에 `MIME` 타입 라벨을 붙인다.

  - 그래서 웹브라우저가 서버로부터 객체를 받을 때,  다룰수 있는 객체인지 확인 할 수 있음.

  ```
  Content-type: image(MIME타입) / jpeg(확장자)
  ```

  - / 사선으로 구분되어 왼쪽은 주타입, 오른쪽은 부타입

  

#### 1.3.2 URI

- 웹 서버 리소스는 각자 이름을 가지고 있음. 그래서 클라이언트를 이를 지목할 수 있음.
- 서버리소스 이름은 **통합 자원 식별자**라고 부름(**uniform resource identifier**) 즉 **URI**

- URI에는 두가지로 종류가 있음

  - URL(location), URN(name)

  

#### 1.3.3 URL

- **통합 자원 지시자** (uniform resource locator)
- 특정 서버의 한 리소스에 대한 구체적인 위치를 지시하는 역할을 함.

![](https://www.codns.com/image/url11.png)

#### 1.3.4 URN

- **uniform resource name**
- 리소스 위치에 영향을 받지 않는 유일무일한 이름 역할
  - 즉 이러한 리소스가 이리저리 옮겨지더라도 문제없이 동작해야함.



### 1.4 트랜잭션

![](https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F2460F63B54BE2E1C0D)

- 요청과 응답으로 이루어져 있는 일련의 과정



#### 1.4.1 메서드

- 모든 HTTP 요청 메세지는 한 개의 메서드를 가짐.
- 메서드? 서버에게 어떤 동작을 취해야할지 알려주는 것(가져오기, 실행하기, 파일삭제하기 등등.)
- GET, PUT, DELETE, POST, HEAD...



#### 1.4.2 상태코드

- 모든 HTTP 응답 메서지는 **상태코드** 와 함께 반환됨.
- 200? 성공.
- 302? 요청 다시보내라 
- 404 리소스 찾을 수 없음.



#### 1.4.3 웹페이즌 여러 객체로 이루어짐