# TCP/IP 쉽게, 더 쉽게

- 참고

  [TCP/IP...](http://www.yes24.com/Product/Goods/32203210)

- Goal
  1. 웹페이지가 표시되는 원리르 배운다
  2. 네트워크에서 데이터가 어떻게 전달되는지 배운다.
  3. IP 어드레스 규칙을 배운다.
- 목록

----



## 01. 컴퓨터 네트워크

### 1.1 종류

- LAN(local area network)
- WAN(Wide area network)



### 1.2 역할

- 이메일, 채팅, VoIP(인터넷전화)
- 파일공유, 전송등
- 분산처리



### 1.3 서버,클라이언트

- 서버 : 서비스를 제공하는 쪽

- 클라이언트 : 그 서비스를 받는 쪽

- 서버와 클라이언트는 어떻게 구분?

  *= > 어떤 역할을 하는 프로그램이 설치되는 지에 따라 결정됨*

- 피어 투 피어 (P2P)

  네트워크에 연결된 두 대의 컴퓨터가 클라이언트, 서버 역할을 동시에 할 수 있어서 서로 서비스를 주고 받는 **통신 방식**

  예를 들면, 개인 컴퓨터간 파일 겅유, 인터넷전화(VoIP)

### 1.4 패킷

- 데이터를 주고 받는 작은 단위
- 패킷은 자신이 어디로 전송되어야하는지 어드레스(address)를 가지고 있음.
- 교환방식은 2가지
  1. 회선 교환방식 : 양쪽에서 하나의 통신경로를 가지고 교환. 일대일 통신
  2. 패킷 교환방식 : 여러 상대와 통신할 때 효과적



### 1.5 계층모델

![](https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F2518D64858B2A8D70E)

- 어플리케이션 서비스를 제공
- 트랜스포트, 인터넷, 네트워크 : 통신기능을 담당.

- 위의 계층 모델은 TCP/IP 계층 모델.
- 각 계층에 해당하는 역할들이 있음.



![](https://miro.medium.com/max/1472/1*tnEkvHfXNnhv7xAthT2sJQ.png)

### 1.6 4개 계층의 동작방식

1. 어플리케이션 계층

- 사용자에게 실제 서비스를 제공하는 계층. 
- 웹서버, 클라이언트끼리 요청, 응답결과로 전달되는 과정을 지원.



2. 트랜스포트 계층

- 애플리케이션 계층에서 전달받은 데이터를 목적지 애플리케이션 계층의 프로그램까지 전달하는 역할.
- 제대로 전송되지 않았으면 재전송도 함.



3. 인터넷 계층

- 데이터에 어드레스정로르 덧붙여, 목적지까지 무사히 전달하는 것.
- 여기서 라우터라는 장비가 사용됨.
- 라우터? 데이터를 다음 네트워크에게 전달하기 위해서 사용되는 장비.



4. 네트워크 인터페이스 계층

- 유선 랜 어댑터, 무선 랜 어댑터가 처리할 수 있는 형태로 데이터를 변환하고 이러한 데이터를 목적지까지 전달하는 것.

- 물리적으로 인접한 장비까지 어떻게 데이터를 전달할 것인가가 초점임.



### 1.7 통신규약, 프로토콜

- 프로토콜, 절차 규약을 의미

![](https://1.bp.blogspot.com/-HfTlkVv6_jQ/V2FXJzyhoRI/AAAAAAAAAV0/K-G7WiBrZFsm15ehhfktgjhFGRaOB2GPACLcB/s1600/1.PNG)

- UDP? 확실한 데이터전달은 어렵지만, 고속 전송이 가능한 프로토콜
- TCP 확실한 데이터 전달 우선.

![](https://t1.daumcdn.net/cfile/tistory/223C7F4C5715100726)



## 02. 네트워크 서비스, 애플리케이션 계층

- 애플리케이션? 네트워크의 비주얼을 담당.
- 비주얼이라는 이야기는 이를 받춰주는 다른 계층이 있음을 의미하고.



### 2.1 애플리케이션 계층의 역할

- 사용자가 직접 사용하며 체감하는 계층이다.
- HTTP, POP, SMTP, IMAP, SMB, AFP, FTP, Telnet, SSH등.
  - 사용자가 직접 사용하는 프로토콜
- DNS, DHCP, SSL/TLS, NTP, LDAP
  - 사용자가 간접적으로 사용하는 프로토콜

###  2.2 HTTP

- 가장 대표적인 프로토콜

- HTTP 메세지는 request, response 두가지 형태로 구분됨.
- HTTP는 상태가 없음.

- 요청 request를 보내기 위해서는 URL(uniform resource locator)를 사용.

  ![](https://codelikethis.com/lessons/www/complex_url.png)

- 상태코드

  - 응답 데이터의 첫번째 행에 있음.

  ![](http://static.codeflow.study/1523354127336_ext3HTTPResponseMessageExample.png)

  - 상태코드 예

  ![](https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F1249F947513EDD1C29)

