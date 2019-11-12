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

### 2.3 웹서비스, 웹 어플리케이션

- HTTP 메세지를 통해 정보를 교환.

- Get, Post 방식

- 데이터의 암호화가 필요한 경우 **HTTPS 프로토콜** 사용한다.

- AJAX

  - Asynchronous Javascript and XML
  - 웹브라우저가 웹 서버로 요청을 보내는 것이 아닌 <u>자바스크립트로 작성된 프로그램</u>이 웹 서버와 통신

  - 통신의 결과는 전체 페이지를 갱신하는 방식이 아니라, **특정** 부분만 갱신하도록.
  - 즉 사용자가 좀 더 편하게 서비스를 이용할 수 있도록 도와주는 방식임.



### 2.4 쿠키

- HTTP는 stateless 프로토콜.
  - 즉 요청과 응답이 한번씩 주고 받아지면 통신이 끊어진다.
  - 이러면, 사용자 접속의 연결성을 어떻게 보장해야 할지 궁금증이 남음.
  - 쿠키를 통해 위와같은 문제를 해결

- 웹브라우저는 응답 받은 메세지에서 'Set-Cookie' 문자열이 있는 지 확인하면서 쿠키 존재의 여부를 확인함.
- 쿠키에 포함되는 정보는 Key- Value값으로 저장됨.

- 쿠키를 통해 주고 받는 정보는 클라이언트 PC가 아닌, 서버 쪽에만 저장하는 것이 원칙(보안성 떄문에)
- 클라이언트 쪽에는 세션 ID등의 식별 정보만을 저장해야함.



### 2.5 이메일

- 이메일 송수신시에는 SMTP, POP, IMAP 프로토콜이 사용됨.
- Simple Mail Transfer Protocol : 메일 발신
- Post Office Protocol : 메일 수신

- SMTP
  - 클라이언트 PC가 **메일 을 보낼때**,
  - 발신자의 메일서버에서 수신자의 메일서버로 메일을 중계할 때 사용(<u>메일 서버간의 메일 중계시에도</u>)
  - statefull 프로토콜. 
    - 즉 전송 종료 명령이 보내져야만 통신이 종료됨을 의미한다.

- POP
  - 메일 서버에 저장된 메일을 확인할 때 사용하는 프로토콜
    - SMTP는 최종적으로 메일을 수신자의 메일 서버에 저장되기 까지를 책임진다.
  - 최근 버젼은 POP3

- SMTP auth
  - SMTP + 사용자 인증 기능이 추가된 프로토콜
- IMAP
  - POP 프로토콜은 클라이언트가 메일을 수신하면, 메일 서버에 보관된 메일을 **삭제** 하게 되어있음.
  - IMAP 프로토콜은 클라이언트가 메일을 수신하더라도, 메일 서버에 보관된 메일을 보관하도록 되어있음.
    - 그래서 스마트폰등 휴대기기에서는 이 프로토콜이 사용됨. 왜?
    - 휴대기기는 메일을 보관할 용량이 충분하지 않기 때문에.

### 2.6 PC 간 파일 공유

- P2P
  - peer to peer 
  - 1:1 공유될 컴퓨터끼리 네트워크가 연결되기만 하면 파일 공유가 가능.
- NAS
  - Network Attached Storage

- 파일 공유 프로토콜은 OS마다 다르다.
  - 윈도우 SMB
  - OS X AFP
    - 그렇지만 다른 프로토콜도 지원하는 기능이 있음.ㅎㅎ

### 2.7 FTP

- 네트워크에 연결된 서버로 파일을 전송하기 위한 프로토콜을 의미.

- File Transfer Protocol
- 주로 인터넷에 연결된 서버에서 파일을 전송할 때 사용.
  - CWD, MKD, LIST, RETR, STOR, DELE 등의 명령어도 있음.

- FTP는 웹서버로 웹페이지를 전송 할때 자주 사용된다.
- 두 가지 접속 형태를 사용함
  - 데이터 커넥션, 컨트롤 커넥션
  - 왜 이렇게 분리되어있음?
    - 그러면 파일 전송 중에도 명령을 줄 수 있어, <u>전송중인 파일을 중단 시킬 수 있으니까</u>.

![](https://www.exavault.com/blog/app/uploads/2019/01/Screen-Shot-2019-01-04-at-4.13.57-PM.png)

- 액티브, 패시브 모드

  ![](https://www.mybluelinux.com/img/post/posts/0052/active-ftp-firewall.png)

  - firewrall이 있으면, 요청한 데이터를 못받을 수 있음.

  ![](https://t1.daumcdn.net/cfile/tistory/2521D73451F48F932C)

  - client쪽에서 데이터 채널을 미리 만들어놓으면, 통신이 원활하게 될 수 있다.
  - 왜? 보안 수준 때문



### 2.8 원격 컴퓨터 제어

- CLI (command line interface), GUI( graphical user interface)
- Telnet, SSH(Secure SHell) 원격지의 컴퓨터를 제어하기 위한 프로토콜.

- 최근에는 SSH를 많이 사용.

- 윈도우는 RDP(remote desktop, protocol) 많이 사용
- OS에 독립적인 VNC(virtual network computing), RFB(remote, framebuffer) 도 있다.



### 2.9 Voice over IP, 스트리밍

- 영상, 음성을 보낼 때는 데이터를 **압축**, **분할** 하여 보낸다.

- UDP 방식 사용
  - 왜? 
  - 데이터 용량이 크기 때문에 신뢰성 보다는 빠른 전송방식이 필요하기 때문에.
- Youtube 같은 서비스는 HTTP 메세지 안에, 동영상 프로토콜을 첨부하여 사용하고 있음.
  - 왜? 
  - 그러면 차단되는 경우가 거의 없을 테니까.

### 2.10 MIME

![](https://docs.trafficserver.apache.org/en/latest/_images/http_header_struct.jpg)

![](https://images.slideplayer.com/16/5204029/slides/slide_10.jpg)

![](https://image.slidesharecdn.com/06-response-headers-120915143225-phpapp02/95/jsp-and-servlet-tutorial-generating-the-server-response-http-response-headers-7-728.jpg?cb=1347719609)

## 03. 트랜스 포트 계층

- **컴퓨터 안까지 들어온 데이터를 각 프로그램에 전달**하는 역할을 맡은 계층
- 대표적인 프로토콜 TCP, UDP



### 3.1 트랜스포트 계층 역할

- 애플리케이션에 데이터를 전달.

- 인터넷 - 트랜스포트 - 애플리케이션

- 전달자 역할.

- 어떻게 적절한 애플리케이션에게 전달할까?

  - 포트번호로 구별한다.

  ![](https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile7.uf.tistory.com%2Fimage%2F23CF9533597751E824E6A2)

- TCP
  - 프로토콜
  - 정확한 데이터의 전달을 더 중요시 여긴다.
- UDP
  - 프로토콜
  - 데이터 전송 속도를 중요시 여긴다.
  - 영상, 인터넷전화(VoIP) 등에 사용됨.



### 3.2 포트 번호

- 컴퓨터 내부의 수신지를 표현하는 주소.

- 웹서버에서 송신될 때 같이 첨부되어서 날아들어옴.

- 범위는 *0 ~65535*

- 주요 포트 번호

  ![](https://slidesplayer.org/slide/13639969/83/images/20/01+%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC%EC%97%90+%EB%8C%80%ED%95%9C+%EC%9D%B4%ED%95%B4+%EC%A0%84%EC%86%A1+%EA%B3%84%EC%B8%B5%284%EA%B3%84%EC%B8%B5%29+%5B%ED%91%9C+3-5%5D+%EC%A3%BC%EC%9A%94+%ED%8F%AC%ED%8A%B8%EC%99%80+%EC%84%9C%EB%B9%84%EC%8A%A4+%ED%8F%AC%ED%8A%B8+%EB%B2%88%ED%98%B8+%EC%84%9C%EB%B9%84%EC%8A%A4+%EC%84%A4%EB%AA%85+20+FTP.jpg)

- 클라이언트가 사용하는 포트 번호는 그때그때 다르다.
  - 사용 당시 비어있는 포트번호를 할당하고, 통신이 끝나면 반납하는 형식.

- 클라이언트, 서버와 접속 과정

  ![](https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile10.uf.tistory.com%2Fimage%2F245BA033597759411984A2)

- 서버에서 다양한 클라이언트 접속을 어떻게 판별할까?
  - 포트번호 + IP어드레스의 조합을 통해 구분함.



