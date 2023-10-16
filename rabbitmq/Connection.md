# What is the connection?
## Content

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


## References
- https://www.rabbitmq.com/connections.html#basics
