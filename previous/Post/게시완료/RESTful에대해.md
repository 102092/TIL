>   궁금했던 부분을 찾아가며 정리하고 있습니다.
> 혹시 잘못된 부분이 있으면, 언제든지 댓글로 편하게 알려주세요 :)



----



### RESTful에 대해

- 처음 들었을 때 받은 느낌.

  HTTP같은 프로토콜(약속) 이지 않을까?

  서버와 클라이언트 통신에 있어서 지켜야할 규약이라는 생각이 들긴 했음.

  그리고 줄임말일 꺼라 생각함.



### REST vs RESTful



#### REST 

- Representational State Transfer의 줄임말
- 분산 시스템을 위한 소프트웨어 아키텍쳐의 형식 | 자원을 정의하고, 자원에 대한 주소를 지정하는 방법에 대한 전반적인 방법에 대해 말하고 있는 것
- HTTP위에서, 별도의 전송계층 없이, 전송하기 위한 아주 간단한 **인터페이스**
- 이해되기론, 클라이언트-서버와 통신을 편하게 하기 위해 만든, 아키텍쳐, 인터페이스 즉 **틀, 약속**

##### 

##### 구체적으로..

- 웹 사이트에서 사용되는 자원(이미지, 덱스트등) 에 **고유한 ID**인 HTTP URI를 부여하여 처리하도록.

![](https://gmlwjd9405.github.io/images/network/rest.png)

- CRUD : create, read, update, delete.

  HEAD .. header정보를 조회할때

![](https://gmlwjd9405.github.io/images/network/restapi-example.png)



###### 구성요소

- 자원, 행위 , 표현방식으로 이루어져 있음.

1. 자원 : HTTP URI 
2. 행위 : HTTP Method
3. 표현방식 : MIME TYPE .. (Content-type으로 들어가는 부분)



##### REST는 왜 사용하는 걸까?

###### 장점

1. 서버, 클라이언트의 역할을 명확하기 나누기 위해

2. 아마도 귀찮음을 줄이기 위해.

   즉 하나의 기준을 세움으로 인해, 웹 상에서 자원의 흐름에 대해 좀 더 쉽게 파악할 수 있게 도와주려는 목적이 아닐까 싶음.

3. 그리고 갈수록 거대해지는 어플리케이션의 기능을 분리하고, 상호간의 통신을 원활하게 하기 위함

4. <u>멀티플랫폼</u>을 위함

   웹 페이지만을 위함이 아닌, <u>모바일 어플리케이션 등에서 요청해오는 자원</u>에 적절하게 대처하기 위함.



###### 단점

1. 확실한 표준이 없고
2. HTTP Method 한정되어있고(CRUD)
3. 구형브라우저를 위함은 아니라 한다..



##### REST를 사용하기 위한 제약조건?

1. Client / Server로 구성되어야 하고,

   자원이 있는 쪽이 **Server**, 서버는 클라이언트가 요청하는 API를 제공하고, 비즈니스 로직을 담당

   자원을 요청하는 쪽이 **Client**, 사용자 인증, Context(세션,로그인 정보)를 **직접** 관리,담당!

2. Stateless(무상태)

   Client의 Context(세션,로그인정보)를 Server에 저장하지 않음을 의미

   Server는 Client의 각각의 요청들이 완전히 별개의 것으로 인식할 수 있도록 해야함.

   	- 즉 이전 요청이, 다음요청에 영향을 주면 안됨.
   	- 그렇지만 이전 요청에 따라 DB가 변화했다면, 다음 요청에 따라 해당 DB에 접근하는 것은 괜춘

3. Cacheable(캐시 처리 가능)

   클라이언트 응답을 캐싱하는 것(참고 : https://goddaehee.tistory.com/171)

   자주 사용하는 요청들을 캐시 처리해 놓고, 데이터베이스 쪽의 부하를 줄임!

   즉 <u>인터넷 기록 - 캐시된 이미지, 파일</u>을 이야기하는 것이 아닐까.

4. Layered System(계층화)

   Client는 REST API Server만을 호출하도록

   Sever 다중 계층으로 구성하여,  보안, 암호화등등 - API Server 이런식으로

   하지만 이러한 다중 계층을 Client는 알 필요가 없도록 해야하고

5. Code-On-Demand(optional)

   Server에서 Code를 Client에게 보내도 실행될 수 있도록,

   다만 꼭 필요한 것은 아니고

6. **Uniform Interface(인터페이스 일관성)**

   자원(HTTP URI)는 유일하게 식별가능해야 하고, 

   HTTP Method,

   해당 메세지는 자신을 스스로 잘 설명할 수 있어야하고,

   하이퍼링크를 통해서 애플리케이션 상태가 전이(HATEOAS) 될수 있어야한다.

   즉, 자신에서 다른 정보로 넘어갈 수 있는 길을 만들어 놔야한다는 의미같음.



#### REST API

- API(Application Programming Interface)

  데이터,기능의 집합

- REST API는 REST를 기반으로 한 API를 의미하고, Open API는 대부분 이에 해당함



#### RESTful

- **REST** 를 만족하는 것을 의미.
- **RESTful API**는 REST를 만족하는 API란 의미겠지.
- 엄밀히 말하면 REST와 RESTful은 다른 의미.



##### RESTful 하지 않은 경우는?

- CRUD 기능을 모두 POST로 처리하고 있을 때,

- route에 resource, id 외의 정보가 들어가는 경우(/students/updateName)

  이 부분은 제약 규칙을 살펴봐야할 듯.



> 참고

- https://jeong-pro.tistory.com/180
- https://gmlwjd9405.github.io/2018/09/21/rest-and-restful.html

- https://ko.wikipedia.org/wiki/REST