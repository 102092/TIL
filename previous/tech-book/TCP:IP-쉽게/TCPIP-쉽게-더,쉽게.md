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

### 4.4 라우팅

- 라우팅? 경로 탐색 과정을 일컫는 말
  - 최단거리를 찾고, 중간 전송 중에 오류가 발생하면 다른 길을 찾는 일련의 과정을 말한다.
- 라우팅 프로토콜
  - BGP, OSPE, RIP
  - 라우터 끼리, 서로 누구와 연결되어 있는 지에 대한 정보를 교환할 때 사용하는 프로토콜

- 자율 시스템
  - 인터넷 서비스 제공자는 규모가 큰 네트워크에서, 몇 개의 네트워크를 하나로 묶어 관리 == 자율시스템
  - 일종의 단위
  - 이렇게 단위를 만들어 놓으면, 라우팅이 좀 더 간단하게 이루어지는 데 도움을 줌.



### 4.5 라우터, 라우팅 프로토콜

- 라우터? 네트워크 간 패킷을 전달하는 것이 주요 역할
- 라우팅 테이블
  - 라우터가 활용하는 정보.
  - 목적지 호스트가 속한 <u>네트워크 정보</u> , 경유해야하는 <u>라우터 정보</u> 가 들어있음.
  - 일종의 표지판.

- 정적 라우팅, 동적 라우팅

  - 라우팅 테이블을 만드는 2가지 방법
  - 정적? 네트워크 관리자가 수작업을 통해 직접 설정
  - 동적? 라우팅 프로토콜을 사용하여, 자동으로 경로 정보 수집하여 라우팅 테이블을 설정하는 방식

  - 네트워크 간 접속 형태가 복잡하면 사실상 수작업은 불가능하다. == <u>동적 라우팅</u>으로 해야함

- 라우팅 테이블을 원하는 정보가 없으면?
  - 해당 라우터보다 더 많은 정보를 가지고 있는 기본 라우터, 혹은 **default 라우터** 에게 물어보도록 설계되어있음.

  - 디폴트 라우터는 라우터 마다, **정적으로** 설정되어있음

- 동적 라우터 알고리즘
  - 거리 벡터형
    - RIP 프로토콜 사용. Routing Information Protocol
    - 목적지까지 거리를 살펴보고 짦은 거리 선택
    - 라우터수는 hop으로 셈.
    - 비교적 구성이 간단한 LAN 방식 네트워크에 적합한 알고리즘
  - 링크 상태형
    - OSPF 프로토콜 사용. Open Shortest Path First
    - 네트워크 통신정보를 Map으로 관리하면서, 상태가 가장 좋은 경로를 선택하는 방식
    - 복잡하고 변화가 잦은 네트워크 구성에 적합함.
  - AS(자율시스템, OSPF )
    - 네트워크를 몇개의 구역을 분할한 후, 이 분할 마다 통신정보 Map을 만들어서 관리
    - 왜? 맵정보 부하를 막기 위해
  - AS(자율시스템, BGP )
    - Border Gateway Protocol
    - 경로 벡터형
    - 경로의 거리 뿐만 아니라, 경유하는 AS정보 또한 포함한 경로정보를 만드는 방식



### 4.6 ICMP

- 네트워크 오류를 통보하는 프로토콜

- Internet Control Message Protocol

- 메세지 타입

  ![](https://mblogthumb-phinf.pstatic.net/20140410_72/shj1126zzang_1397116503894ctoCj_PNG/7.png?type=w2)

- ICMP 헤더

  ![](https://mblogthumb-phinf.pstatic.net/20140410_118/shj1126zzang_1397116912767RU5g8_PNG/8.png?type=w2)



- 주요 ICMP 메세지
  - 패킷의 생존기간(TTL)이 경과되면 네트워크 상 소멸. 라우터가 11번타입  ICMP 메세지를 보냄 
  - 어디에다가? 송신 측에



### 4.7 어드레스 변환

- 기본적으로 가정, 사무실 네트워크는 Private IP 어드레스를 사용

- 이건 내부에서 사용하는 가상의 주소.

- 그래서 인터넷에 연결된 Public IP 어드레스를 사용하는 서버와는 통신이 불가하다.

- 즉 Private --> Public 바꿔줘야함

- 이 때 NAT (Network Address Translation ) 기술이 사용된다.

  ![](https://s8185.pcdn.co/wp-content/uploads/2013/11/41.jpg)



- NAT에서 발생할 수 있는 제약사항
  - 송신지의 여러 호스트가 같은 **포트 번호** 를 사용하고 있다면, 라우터는 수신지에서 온 응답을 어디에 보내야할 지 판단하지 못함
  - 그리고 외부에서 일방적으로 보낸 데이터는 NAT가 어디에 보내야할지 판단못함. 즉 전달되지 않음.



- 네트워크 어드레스 포트 변환

  - 같은 포트 번호를 사용시 발생할 수 있는 문제를 방지하기 위해, 다른 포트번호를 넣는 방식

  ![](https://patentimages.storage.googleapis.com/8e/1b/aa/480b41ccd34620/pct00023.png)

- 외부에서 들어온 요청을 받는 경우
  - 메세지 자동 확인
  - 포트 포워딩
    - 라우터의 특정 포트번호로 통신이 들어오면, 내부에 특정 서버로 전달될 수 있도록 설정하는 방법



### 4.8 도메인명

- IP address는 숫자. 그래서 사람이 기억하기 어려움. --> 기억하기 쉬운 걸로 바꾸자(도메인)
- DNS Domain Name System == 도메인명

![](data:image/png;base64,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)

- DNS 서버에 질의

  ![](https://www.synology.com/_images/tutorials/set_up_domain_dns_server/02.jpg)

- 도메인 계층 구조

  ![](https://t1.daumcdn.net/cfile/tistory/226BFA3857A8828E0E)

- DNS 서버 계층 구조

  ![](https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F999874455B8C9DBB22)

  - 도메인명 데이터를 직접한과리하는 서버는 ? DNS 콘텐츠 서버
  - 루트 도메인 서버는 하위 계층 DNS서버에 대한 정보를 알고 있음.



- DNS 서버 질의 처리과정

  ![](http://www.kisa.or.kr/synapfile/201008191118016319.hwp.files/BIN0002.bmp.png)

  - 캐쉬 서버에 우선 질의
  - 루트 -> kr DNS -> 해당 홈페이지를 관리하는 DNS



- DNS 도메인 등록
  - 리소스 레코드 resource record DNS서버에 등록되는 정보
  - 리소스 레코드가 등록된 파일 == 존 파일(zone file)



### 4.9 DHCP

- 네트워크에 속한 호스트들에게 IP를 **자동** 부여함.
- Dynamic Host Configuration Protocol

- 신규 호스트는 네트워크의 모든 호스트들에게 <u>브로드캐스트</u> 방식 으로 **DHCP 발견 메세지**를 보내고 이 메세지를 받은 DHCP 서버가 사용 가능한 IP를 할당하는 방식
  - 이 패킷에 관계없는 호스트는 받은 패킷을 버림.



### 4.10 명령어

- ipconfig
- ping
  - ICMP 8번 메세지를 보내는 명령어
  - 살아있는 지 확인

- tracert 
  - 목적지까지 통과한 경로를 표시해라
  - 경유한 라우터의 IP어드레스가 나옴
- nslookup + 도메인 명 or IP 어드레스
  - 도메인 명으로 IP 어드레스 알아낼 때 사용하는 명령어



## 05. 하드웨어, 네트워크 인터페이스 계층

- 네트워크 인터페이스 계층은 TCP/IP 계층 모델 중 가장 아래 있는 계층
- 즉 네트워크 어댑터와 가이 하드웨어와 맞닿은 부분까지 포함하는 경우
- 이러한 하드웨어를 제어하면서 인접한 다른 통신기기까지 데이터를 전달하는 것이 이 계층의 목적
- 다르게 보면 데이터를 전달하기만 하면 이 계층의 목적은 끝남.



###  5.1 네트워크 인터페이스 계층의 역할

- 다양한 하드웨어를 네트워크에 연결
  - 하드웨어를 제어해서 데이터를 온전히 전달하는 것이 가장 큰 목표

- 프로토콜
  - PPP, 이더넷, ARP
- 유선 LAN, 무선 LAN같은 하드웨어와 연결되어 있음.



### 5.2 MAC 어드레스

- 네트워크 장비에 부여된 **식별번호**

- NIC networt interface card에는 MAC media access control 이라는 식별번호가 부여되어있음.

  - 제조단계 부터 부여되고, 전 세계 네트워크 장비들이 서로 식별될 수 있도록 할당됨.

  ![](https://networkencyclopedia.com/wp-content/uploads/2019/08/mac-address.jpg)

  ![](https://www.wikihow.com/images/thumb/4/43/Find-the-MAC-Address-of-Your-Computer-Step-5-Version-4.jpg/aid13225-v4-728px-Find-the-MAC-Address-of-Your-Computer-Step-5-Version-4.jpg)

- 이 주소는 유선 <u>이더넷</u>, 혹은 <u>무선</u> LAN 외에도 <u>블루투스</u> 와 같은 데이터 통신에 활용됨.

- 네트워크 계층이 보내는 데이터를 프레임frame이라 함.

  - 이 프레임 안에는 송신지, 수신지의 MAC 어드레스 정보가 들어감.

  ![](https://www.networkkings.org/wp-content/uploads/2019/01/ethernet-header.png)

- IP address vs MAC address
  - IP 어드레스는 최종 목적지가 한번 설정되면 **전송과정 중에 변경되지 않는다**
  - 반면 MAC 어드레스는 전송 과정 중, **다음 장비의 어드레스로 교체된다**
    - 즉 MAC 어드레스는 최종 목적지를 가르키는 것이 아닌, 다음 목적지를 가르킴을 알 수 있지.

### 5.3 이더넷

- 가장 많이 사용되는 유선 LAN 규격
- Ethernet
- 비트의 0,1을 전압의 높낮이로 표현하여 전달하고 있음.



- 이더넷 프레임

![](http://www.ktword.co.kr/img_data/2965_1.jpg)

- 프리앰블 : 신호의 시작을 알게 해주는 **패턴** 
  - 상당히 길어서, 앞부분 데이터가 없어도 마지막이 10101011로 끝남. 그러면 이게 프레임 이구나 라고 네트워크 어댑터에서 인식하도록 만들어줌.



- 케이블 종류

![](data:image/png;base64,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)



### 5.4 네트워크 허브

- 이더넷에서 사용하는 중계 기기(L2, L3 스위치)
- 유선 LAN에서 연결됨. 
- 일반적인 가정에서는 인터넷 업체(ex KT) 에서 임대한 인터넷 라우터를 사용하는 것이 일반적 이러한 단말기에는 <u>네트워크 허브</u> 기능이 내장

- 기능 ? 수신한 데이터를 다른 컴퓨터로 전송하는 역할

- 네트워크 토폴로지(구성 형태)

![](http://www.ktword.co.kr/img_data/356_1.JPG)



- L2

  - 접속된 상대를 식별
  - 일명 스위칭 허브
  - 가장 많이 사용되는 네트워크 중계 기기
  - TCP/IP 에 네트워크 인터페이스 계층에 해당
  - 포트에 연결된 각 호스트의 MAC어드레스를 기억해둬싿가 통신할 당사자 간에만 데이터를 전달

  - 통신 회선이 통신 당사자 간에만 독립적으로 만들어져서 패킷 충돌이 벌어지지 않는다.



- 브로드 캐스트 도메인
  - 수신지 주소가 브로드 캐스트 어드레스 일 때 데이터가 전달되는 **범위** 를 말함.



- L3
  - 대규모 사무실에 적합
  - TCP/IP에 인터넷 계층 역할까지 수행 가능
  - VLAN 기능 virtual LAN
    - LAN을 몇 개의 가상적인 네트워크로 분할해서 통신 효율을 높임

![](https://study-ccna.com/wp-content/images/topology_with_vlan.jpg)



### 5.5 무선랜

- 전파를 통신 매개체.
- 무선 LAN의 정식 규격명은 **IEEE 802.11**

- 통신을 시작하는데 CSMA/CA 방식을 사용

- 클라이언트가 이미 통신하고 있으면 기다려서, 다른 전파를 받지 않고 있으면 통신을 시작하는 방식.



- 무선랜 프레임 구조

![](http://www.ktword.co.kr/img_data/3352_3.JPG)

- mac어드레스 필드가 4개나 들어감.
- 무선랜 통신은 무선 AP 가 중계, 이 AP 기기의 MAC 어드레스도 프레임에 포함됨.



### 5.6 ARP

- IP어드레스를 통해 해당 장비의 MAC 어드레스를 알아내는 프로토콜

![](https://cdn.ttgtmedia.com/rms/onlineimages/whatis-arp.png)

- 이더넷, 무선랜이 데이터를 보내려면 수신측의 MAC어드레스를 알고 있어야함.
- 이러한 주소를 알기위해 ARP라는 프로토콜을 실행
- 송신 측이 **요청 패킷** 을 수신 측 IP 네트워크 전체에 브로드 캐스트.
- 이러한 요청을 받은 호스트중 수신지의 IP어드레스가 자신과 같은 호스트는 자신의 MAC어드레스를 **응답 패킷** 에 담아 전송함
- 이러면 송신측은 수신지 장비의 IP어드레스를 알게됨



- ARP 헤더

![](data:image/png;base64,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)

- 오퍼레이션 코드 1 == 요청 , 2 == 응답



- 프락시 ARP
  - 호스트 대신에 <u>라우터</u>가 ARP에 대해 응답하는 기능을 의미함
  - 왜? 서브넷 마스크가 다른 호스트 까지는 요청 패킷이 전달되지 않기 때문
  - 이럴 경우 그 사이에 있는 라우터가 자신의 MAC어드레스를 대신 응답.
  - 그러면 라우터를 중계 과정을 밟을 수 있도록 함.



### 5.7 FTTx, xDSL

- 광섬유 케이블, 금속 케이블



- FTTx
  - 광섬유 케이블을 사용.
  - 일반 가정까지 광회선이 들어와 인터넷 서비스를 제공하는 방식은 FTTH



- xDSL
  - 금속 케이블을 사용
  - ADSL, VDSL
  - ADSL : 전화회선
  - VDSL : 옥외배선



### 5.8 PPP, PPPoE

- 멀리 떨어진 컴퓨터끼리 접속하기 위한 프로토콜. PPP
- 이더넷에서 사용 가능한 형태는 PPPoE



- PPP
  - Point to Point Protocol
  - 원격지에 있는 컴퓨터와 일대일 연결하기 위한 프로토콜
  - 접속, 사용자 인증, 통신 중단 같은 단계로 통신함.



- PPPoE

  - 이더넷에서는 PPP에서 사용하는 접속~인증 등의 절차가 없음

  - 그러기에 이더넷 프레임 안에 PPP 헤더를 넣음. == PPPoE

  - PPP over Ethernet

    ![](https://www.cisco.com/c/dam/en/us/support/docs/ip/transmission-control-protocol-tcp/200932-Ethernet-MTU-and-TCP-MSS-Adjustment-Conc-00.png)





### 5.9 명령어

- `arp -a` 
  - MAC어드레스 목록 확인
- `arp -s + ip addrress` 
  - IP 어드레스 연결정보확인



## 6. 보안

- HTTPS, SSL/TLS, VPN



### 6.1 네트워크, 보안

- 암호화 방식
  - 공유키 암호화
  - 공개키 암호화
- 전자 인증서 : 신분 사칭을 막기 위한
- 전자 서명 : 데이터 위변조를 막기 위한



### 6.2 공유키, 공개키

- 암호화 --- 복호화
- 공유키 암호화
  - 하나의 키를 사용해서 암호화 , 복호화 작업을 하는 방식
  - 이와 같은 처리 속도가 빠름
  - 그렇지만 하나의 키로 모든 것을 해결하는만큼, 이 키가 탈취 당하면 문제가 커짐



- 공개키 암호화

  - 서로 다른 키로 암호화, 복호화 작업을 수행
  - 개인키 : 자신이 보관하는 키
  - 공개키 : 외부에 공개하는 키

  ![](data:image/png;base64,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)



### 6.3 전자 증명서, 전자 서명

- 신분사칭, 데이터 위변조를 막을 때 사용



- 전자 증명서
  - 공개키 방식을 사용하면 데이터 유출을 막을 수는 있음.
  - 그러나 공개 키를 보낸 사람이 이상한 사람이라면, 모르는 사람에게 데이터를 넘겨줄 위험이 있음.
  - 이와 같은 위험을 막고자 **전자증명서** 사용
  - 즉 본인임을 증명하는 서류
  - 전자 증명서는 <u>인증기관</u> 에서 발행
    - 인증기관? (한국정보인증, 코스콤, 금융결제원 등)
  - 소유자는 공개키 와 소유자 정보를 인증기관에 보내, 전자 증명서 발행을 요청
    - 인증기관에서 확인하고, 인증기관 전자 서명이 포함된 인증서를 발행



- PKI
  - 공개키, 전자 인증서등의 보안 인프라를 지칭하는 말
  - Public Key Infrastructure



- 전자 서명

  - 데이터 내용이 위변조 되지 않았다는 것과, 보낸 이를 보증하는 역할을 함.
  - 전자 인증서에 포함되어 있음.

  - 원본데이터의 해쉬 값을 **개인 키로 암호화** 하는 방식.
    - 개인 키로 암호화된 데이터는 공개키로 복호화 할 수 있기에..



- S/MIME
  - 이메일의 안전한 전달을 보장.
  - 이 방식은 통신 쌍방이 전자 인증서를 가지고 있는 경우에만 사용할 수 있음
  - 송신
    - 메일 본문은 공유키로 암호화, 공유키를 **상대방** 의 공개키로 암호화 해서 전송
  - 수신
    - 전송된 공유키는 자신 개인키로 복호화하여 메일 본문을 복호화 할 수 있음.
  - 왜 공유키? 
    - 공유키로 암호화하면 연산 처리 측면에서 부담이 적다.



### 6.4 SSL/TLS

- 서버 인증서를 사용해서 서버, 클라이언트 간 통신을 암호화 함



![](http://mblogthumb1.phinf.naver.net/MjAxNzExMDFfNDIg/MDAxNTA5NTE4ODIzNDI5.30l4d3KGAKczXtfSGbbhJMS06JRefFMr-ucXkWHMMkEg.INnt1wW9-8esFvcqYvIMxo4kEJIIH5v4PJARXVoqvNsg.PNG.tjdeoaksthl/%EA%B7%B8%EB%A6%BC1.png?type=w800)

- 공개키로 공유키를 주고 받은 후, 이 **공유키로 데이터를 암호화** 해서 통신 하는 방식

- 이와 같은 절자 전에, <u>서버의 신원을 확인</u>하는 전자 인증서를 받는 과정이 있음



- HTTPS
  - SSL/TLS를 사용한 보안 프로토콜. 대표적인 것.
  - 그 외 FTP, 혹은 메일 프로토콜과도 SSL/TLS를 조합하기도 함.
  - 즉 HTTP 프로토콜이 SSL/TLS에 의해 암호화 되어 전달되는 것.

- 참고 :  https://wayhome25.github.io/cs/2018/03/11/ssl-https/ 



### 6.5  SSH

- 원격지의 컴퓨터를 안전하게 제어하기 위한 프로토콜
- 공개키, 공유키를 조합한 방식으로 통신
- 그렇지만 전자인증서를 사용하진 않음. 
  - 패스워드 인증이나, 공개 키 인증을 사용



- 패스워드 인증

  ![](https://thebook.io/img/006718/linux-149.jpg)

- 접속 요청시, 서버에서 공개키를 보냄
- 클라이언트는 난수를 사용한 공유키를 생성하고, 이러한 공유키를 전송 받은 공개키로 암호화 하여 전송
- 서버는 개인키로 복호화
- 이러면 서로 같은 공유키를 가지고 있고.
- 이제 클라이언트는 패스워드를 공유키로 암호화 해서 보내고, 서버는 공유키로 복호화 하여 체크
- 인증완료



- 공개키 인증방식

![](https://thebook.io/img/006718/linux-152.jpg)

- 클라이언트 측에서 공개키를 만든 후, 이 키를 미리 접속한 서버에 **등록**

- 이러면 연결할 때 마다 패스워드 입력하지 않아도 됨.





### 6.6 방화벽

- 외부로부터 선별된 접속을 위함.



- 어떻게?
  1. 패킷 필터 : IP헤더, TCP/UPD헤더로 부터 어드레스, 포트번호를 보고 제어하는 방식
  2. 서킷 레벨 게이트 웨이 : 데이터를 주고 받을 때 반드시 거쳐가야한 관문(게이트웨이)을 통해 제어하는 방식
  3. 애플리케이션 게이트 웨이 : 애플리케이션 계층에서 다루는 URL, 텍스트 정보를 보고 제어하는 방식

- 가정용 라우터는 방화벽 역할도 함.



### 6.7 무선 LAN의 보안

- WEP, WPA,WPA2,,![](https://image.ahnlab.com/comm/info/article_100519_19.jpg)



- 스트림 암호화, 블록 암호화
  - 무선 랜 암호화는 안전 + 고속화가 필요. 
  - 그래서 공유키 방식 사용
    - 공개키는 암호화시 연산처리가 부담되므로
  - 스트림 
    - 공유키를 통해 선두에서 차례로 암호화.
  - 블록
    - 원본 데이터를 블록하여, 공유키를 통해 암호화



- 패스 프레이즈
  - WEP =패스 프레이즈 
  - 사용자가 지정한 문자열 + **초기화 벡터** (매번 조금씩 변하는 값) 을 조합하여 암호화를 위한 공유키를 생성했음.
  - 간단하고 처리 속도가 빠름. 그러면서 복호화는 어렵게
  - 그렇지만 초기화 벡터의 길이가 짦으면, 같은 공유키가 만들어질 위험성 있음.



- 초기화 벡터 길게 만들기.
  - 그래서 WPA 방식에서는 초기화 벡터값을 길게 만듬.
  - 왜? 보안 강도를 높히기 위해



### 6.8 VPN

- Virtual Private Network
- 거점 간의 통신 전체를 보호할 수 있는 방법
- 인터넷 VPN과, 클로즈드 VPN있음.
  - 인터넷 상 데이터를 암호화해서 통신하게 만들거나
  - 인터넷과는 아예 분리되어 별개의 회선을 사용하게 지원하거나



- IPSec, PPTP, L2TP/IPSec
  - VPN에서 사용하는 프로토콜
  - 참고 :  https://ko.vpnmentor.com/blog/vpn-protocol-comparison-pptp-vs-l2tp-vs-openvpn-vs-sstp-vs-ikev2/ 

- VPN에서는 어떻게 사용자를 인증할까?
  - L2TP 패킷 안에 PPP 헤더를 통해 사용자를 인증한다.
  - 즉 L2TP/IPSec을 사용
  - IPSec은 암호화하고, L2TP는 사용자 인증에 사용하고



- 캡슐링
  - PPP -> L2TP -> IPSec 순으로 IP패킷을 포장하는 방식
  - 수신 받은 후에는 역순으로 풀어내서 IP 패킷을 취득한다.
- 터널링
  - 원본 데이터가 IPSec이라는 터널 아래 / L2TP / PPP 아래 있으므로 마치 터널을 지나가는 것과 같다고 해서 붙여진 말.