## The Basics

> TCP-based and assume long-lived connections (a new connection is not opened per protocol operation) for efficiency

- TCP 기반, Long Live 형태의 통신
- 프로토콜당 새로운 커넥션이 열리는 건 아님.
	- e.g. `AMQP 0-9-1`, `AMQP 1.0`


> One client library connection uses a single TCP connection

- 하나의 클라이언트는 하나의 TCP 커넥션만 가지고있음.

> Since connections are meant to be long-lived, clients usually [consume messages](https://www.rabbitmq.com/consumers.html) by registering a subscription and having messages delivered (pushed) to them instead of polling.

- long-live 커넥션을 가지고 있기 때문에, 클라이언트(어플리케이션은) 대부분 메세지를 소비함.
- 클라이언트는 `polling` 대신 구독을 하고 있고..
	- 클라이언트가 rabbitmq node에 메세지가 있는지 혹은 가져올 수 있는지 주기적으로 확인하는 것이 아니라 
	- node가 클라이언트에게 메세지를 deliverd(pushed) 해준다는 뜻인가?


> Operating systems have a [limit around how many TCP connections (sockets) a single process can have open](https://www.rabbitmq.com/networking.html#open-file-handle-limit) simultaneously.


- OS는 하나의 프로세스에서 동시에 열 수 있는 TCP 커넥션 갯수가 정해져있음.
- QA 환경에서는 이 부분이 문제 없었는데, Prod 환경에서는 문제가 발생할 수 있는 부분.


## Connection Lifecycle

> Application configures the client library it uses to use a certain connection endpoint (e.g. hostname and port)

1. 클라이언트(어플리케이션)가 사용할 라이브러리를 설정. (호스트네임, 포트등의 정보를 기반으로)

> The library resolves the hostname to one or more IP addresses

2. 해당 라이브러리는 호스트를 하나 이상의 IP로 확인 (Health check?)


>  The library opens a TCP connection to the target IP address and port

3. 해당 라이브러리그 TCP 커넥션을 오픈.

> After the server has accepted the TCP connection, protocol-specific negotiation procedure is performed

4. 클라이언트에서 오픈한 커넥션이 서버가 받아진다음에, 특정 프로토콜 절차가 실행됨.
	- `AMQP 0-9-1`, `AMQP 1.0`


> The server then [authenticates](https://www.rabbitmq.com/access-control.html) the client

5. 그리고 서버는 클라이언트를 신뢰할 수 있는지 인증함.

> The client now can perform operations, each of which involves an [authorisation check](https://www.rabbitmq.com/access-control.html) by the server.

6. 인증이 끝나면, 클라이언트는 작업(e.g. publish, consume..) 을 할 수 있고 각 작업에 서버가 권한을 확인하고 있음.

> The client retains the connections for as long as it needs to communicate with RabbitMQ

7. 클라이언트는 rabbitmq와 통신이 필요할때까지 커넥션을 계속 유지함 


> extra..
-
- 커넥션 라이프사이클의 경우, 프로토콜별로 약간의 변화는 있지만, 큰 변화는 없음.


## 기타

> 문제상황
> - RabbitMQ Queue 생성 -> Spring boot application 실행(클라이언트) 
> - 클라이언트에서 메세지를 publish 하려 할 때 시도하는 커넥션이 맺어지지 않았음. 왜?

- 그런데 rabbitmq cli를 통해 임의로 해당 queue 메세지를 생성 후, 클라이언트와 커넥션이 맺어짐.
- 어플리케이션이 로딩 시점에 커넥션이 rabbitmq node와 자동으로 맺어지지 않나?
- 재발생하면 로그를 자세히 봐야할듯.
	- 어떤 프로토콜을 사용하는 지
	- 클라이언트에서 커넥션을 맺으려고 할 때, 어떤 로그가 나오는지 (성공, 시도, 실패..)


## 참고
- https://www.rabbitmq.com/connections.html#lifecycle
- https://en.wikipedia.org/wiki/Polling_(computer_science)