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



### 3.3 TCP 데이터 전달

- 프로토콜, 정확한 데이터 통신에 사용.
- 데이터를 segment단위로 분할, 전송 속도 조절, 만약 데이터가 제대로 전달되지 않으면 **재전송을** 함
- TCP Header

![](https://i1.daumcdn.net/thumb/R750x0/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F9902903359F8830122)

- 컨트롤 비트

  - control flags라 일컫기도 함.
  - 통신 상대에게 정보를 전달해서 , TCP 통신을 제어하는 용도.
  - 9개 플래그가 있고 각각 1비트씩.

  ![](http://www.ktword.co.kr/img_data/2437_1.jpg)

  ![](https://t1.daumcdn.net/cfile/tistory/27785749541AE7A521)

- 3방향 핸드쉐이크

  - 연결

  ![](https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Tcp_normal.svg/240px-Tcp_normal.svg.png)

  - 통신을 시작하고 싶으면 SYN - ON, 끝내고 싶으면 FIN - ON
  - 커넥션을 맺을 때, 즉 통신을 시작할 때는 사전에 **일련번호**, **최대 세그먼트 크기 ** 를 서로 합의, 조율하는 과정을 거침. 원활한 통신을 위해서.
  - 데이터 전송과정에서는 일련번호는 1씩 증가.
  - 서로 얼마나 데이터를 전송, 수신 했는 지 확인할 수 있는 용도임.
  - 클라이언트 800바이트 요청을 보내고, 서버에서 2000바이트 응답을 보낸다고 가정하면
    - 결과적으로 클라이언트 801 | 2001
    - 서버는 2001 | 801 
    - 위와 같은 바이트 수를 보일 것인다.
    - 커넥션을 1번 맺었으며, 요청, 응답 데이터는 정상적으로 수신되었음을 의미함.

- 버퍼buffer
  - 수신측에서 사용하는 수신한 데이터를 일시적으로 저장할 수 있는 공간을 의미.
  - 수신 측은 TCP 헤더, **윈도우 사이즈**에서 이 **버퍼의** 크기를 지정한다.

- 흐름제어 flow control
  - 수신측 컴퓨터 성능이 안좋을 경우, 버퍼에서 꺼내 처리하는 속도가 느려 수신한 데이터가 버퍼에 쌓이게 됨.
  - 이를 방지하기 위해 현재 어느정도 버퍼로 받을 수 있는지 수시로 서버측에 이야기하는데
  - 이러한 과정을 흐름제어라고 함.

- 버퍼가 가득 차면?
  - 윈도우 사이즈가 0으로 설정되고 일단 데이터 전송이 멈춤
  - 송신측은 윈도우 프로브(window probe) 패킷을 수신측에 전송
    - 이는 언제쯤 수신이 가능한지 알아보는 탐색 패킷
  - 수신측은 이 패킷에 대해 응답함, 현재 윈도우 사이즈를.



- 네트워크가 혼잡한지는 어떻게 알까?
  - ECE 플래그, CWR플래그를 통해 서로 통신 속도를 조절할 수 있게 함.



### 3.4 UDP 데이터 고속 전달

- 다른 처리 없이 전송만.
- 속도가 최우선!

- 그래서 어느정도 데이터 손실이 생길 수 있음. 그래도 사용자가 느끼기에 크게 문제 없는 서비스에 사용 

  - VoIP, 동영상 스트리밍등.
  - 개쿨

  ![](http://www.oradori.com/files/attach/images/240/301/5a965b6c1a0a5e61cf8431b3aef44d27.png)

- UDP Header

![](https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile9.uf.tistory.com%2Fimage%2F2522CB355780AE742CD3EC)

- upd에서는 패킷을 **데이터그램** 이라 한당

- 브로드 캐스트, 멀티 캐스트.

  - 하나의 패킷을 여러 수신지에 전달

  ![](http://www.steves-internet-guide.com/wp-content/uploads/Unicast-Broadcast-Multicast.jpg)

- 전송속도가 우선인 UDP이지만, 신뢰성도 중요하기에 이를 어플리케이션 계층으로 감싸서 **흐름제어, 혼잡제어** 등을 통해 부족한 신뢰성을 보완하고 있음.



### 3.5 netstat

- netstat -n : 활성 상태의 TCP 접속 정보 표시





## 04. 라우팅, 인터넷 계층

- IP 어드레스 , 우편번호 전화번호 같은 개념
- 라우터 , 네트워크 장비. 네트워크 간의 연결정보를 관리.



### 4.1 인터넷 계층

- IP 어드레스 정보를 보고, 데이터를 알맞게 전달한다.
- 네트워크 인터페이스 계층과 협력하여 데이터를 전달.



- 라우팅, 라우터
  - Router 네트워크 장비, 네트워크와 네트워크를 연결하는 역할.
  - Routing 라우터가 목적의 경로를 찾아나가는 과정
- 관련 기술
  - IP 어드레스 고갈 방지 대안?
  - private address, public address
  - IPv4 --> IPv6
  - DNS



### 4.2 IPv4, IPv6

![](https://i.ytimg.com/vi/D1avGPpSJHs/maxresdefault.jpg)

- ipv4 32비트 어드레스 0~255

- 인터넷 계층에서 사용되는 장비에만 IP어드레스가 할당됨.

  - 네트워크 허브(네트워크 계층에서 사용되는) 등에는 IP가 할당되지 않는다.

  

- IPv4 Header

  ![](https://jaehyek.github.io/img/2017-01-08-CCNA-book-TCP-IP-easy-and-easy/009.JPG)

  - IP 패킷은 유통기간 있음 : TTL
  - MTU maximum transmission unit 한번에 전송할 수 있는 데이터 크기
    - 라우터가 이러한 MTU보다 작은 값으로 패킷을 분할하여 전송하도록 되어있음.
    - 왜? 라우터의 작업부하를 낮추기 위해.
  - 데이터 분할, 복원

  ![](https://jaehyek.github.io/img/2017-01-08-CCNA-book-TCP-IP-easy-and-easy/010.JPG)



- IPv6

  - IPv4 자원 고갈에 대비하여 등장.

  ![](https://jaehyek.github.io/img/2017-01-08-CCNA-book-TCP-IP-easy-and-easy/011.JPG)

  - 병행
    - 현재는 IPv4 랑 호환이 되지 않으니까, 전환하는 기술이 필요하다.

  ![](http://image.zdnet.co.kr/images/2002/04/o_169-2.jpg)

### 4.3 IP 어드레스 활용

- 네트워크 부, 호스트 부

  ![](https://juner417.github.io/assets/post_images/2018-03-23-network-101-ip-subnet/subnet.png)

  - 네트워크? 네트워크 부가 같은 컴퓨터 그룹이라는 의미.
  - 네트워크 부가 다르면 다른 라우터를 거치지 않고서야 연결되지 않는다.



- 어드레스 클래스

  ![](https://t1.daumcdn.net/cfile/tistory/995A2E405BF015D608)

  - 네트워크 부 클래스의 크기는 고정.

  - A class는 한 개의 네트워크 당 1677만대 호스트의 어드레스를 연결할 수 있지만, 실제로 그렇게 하지는 못함.
  - 그래서 꽤 많은 자원이 낭비된다고 볼 수 있음.

- 서브넷 마스크

  - 정해져 있는 네트워크 부의 클래스를 서브넷 마스크(subnet mask)를 통해 비트 단위로 유연하게 늘려서 쓰도록 도와줌.

    ![](data:image/jpeg;base64,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)

  - 네트워크를 더 세분화하여, 서브네트워크를 만들 수 있게 함.
  - 부서나 지역단위 작은 네트워크 생성할 때 도와줌.
  - 그렇지만 *네트워크 부를 늘릴 수만 있지 줄일수는 없어* 클래스 C에서 사용시 별로 도움이 되지 않음.
    - 왜?
    - 이미 호스트 길이가 짦아진 상태이므로, 
  - A,B class 할당시에만 도움이 되겠네

- IP어드레스 할당 방법

  - 전체 32비트 중에, 네트워크 부를 제외한 호스트 부분만 자유롭게 할당하여 사용할 수 있음.



- Private IP address
  - 가정이나 사내에서 자유롭게 사용하는 어드레스
  - 인터넷에 연결해도 외부에서 접근할 수 없기에, NAT 변환 기술이 필요.
  - 이를 통해 Public 하게 바꿔줘야 외부에서 접근이 가능하다.

- Public IP address

  - 인터넷 안에서 중복되면 안됨.
  - 그래서 단체(ICANN등)에서 관리.
  - 필요하면 이 단체로 부터 할당받아서 사용

  ![](http://www.ktword.co.kr/img_data/4864_1.JPG)

