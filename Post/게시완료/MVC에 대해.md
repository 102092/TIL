# MVC에 대해

- 디자인 패턴 = 공법
  
  1. 소프트웨어의 개발방법
  2. 서로 소통,처리 하기 편하도록 정한 규칙,방법론
  
- 기본적인 골격 `Controller, Model, View` 으로 구성되어있음

- Model View Controller의 약자

- 사용자 인터페이스 측면과, 데이터 처리를 위한 부분이 나눠져있는 부분이 깔끔함. 

  유지보수측면에서



![](https://s3.ap-northeast-2.amazonaws.com/opentutorials-user-file/module/327/1262.png)

- 사용자가 **컨트롤러**를 조작하면, **모델**은 데이터를 조작하여 정보를 가져오고 **뷰**를 통해 사용자에게 전달해줌.

- 위 그림은 좀 더 논리적인 구조에 가까움.

------



![](https://mblogthumb-phinf.pstatic.net/MjAxNzAzMjVfMjUw/MDAxNDkwNDM4NzI4MTIy.4ZtITJJKJW_Nj1gKST0BhKMAzqmMaYIj9PobYJMFD4Ig.xTHT-0qyRKXsA4nZ2xKPNeCxeU2-tLIc-4oyrWq5WBgg.PNG.jhc9639/mvc_role_diagram.png?type=w800)



## 1. Controller

- 사용자가 원하는 바를 파악하고,  `Model` 에게 어떠한 작업이 필요하다고 이야기해주는 역할을 함
- 사용자와 데이터의 다리역할
- `Model` , `View` 에 대해서 알고 있어야함.

## 2. Model

- DB에 접근, 데이터를 요청에 맞게 처리하는 부분
- `View` , `Controller` 에 대해서 어떠한 정보도 알도록 하면 안됨.
- 재사용 가능해야하며, 다른 인터페이스에서도 변해서는 안됨

## 3. View

- 화면에 보여주기 위한 역할을 하는 부분
- 데이터 및 객체의 입력, 출력의 역할.
- 모델이 가지고 있는 정보를 가지고 있으면 안됨.
- `Model` `Controller` 에 대해서 정보를 알면 안됨.

### 참고

- [생활코딩](https://opentutorials.org/course/697/3828)

- [https://m.blog.naver.com/jhc9639/220967034588]([https://m.blog.naver.com/jhc9639/220967034588)
- https://coding-factory.tistory.com/69