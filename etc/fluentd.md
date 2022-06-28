# Introduction
- 로그 수집기 (collector)
- 데이터 유실을 막기 위해 메모리, 파일 기반의 Buffer 시스템을 가지고 있음.
- Failover을 위한 HA(high availability) 구성도 가능.
    - HA? 클러스터링, 이중화등의 방식. 즉 하나의 `fluentd` 시스템이 원치 않은 이유로 종료되었을 경우, 다른 `fluentd` 시스템이 있어서 로그 데이터의 유실을 막아주는 것.

# Basic
> Inputs or listeners Fluentd will have and set up common matching rules to route the Event data to a specific Output.
- input data는 특정한 룰에 매칭되어서 output으로 전환된다.
    - 전체적인 동작은 input -> (Filter) -> Buffer -> Output
- 예를 들면 `HTTP Request` 는 아래와 같은 데이터로 전환.

```
<source>
  @type http
  port 8888
  bind 0.0.0.0
</source>
```

- 특정한 룰 (Matching rule)

```
<match test.cycle>
  @type stdout
</match>
```

> The Match sets a rule where each Incoming event that arrives with a Tag equals to test.cycle, will match and use the Output plugin type called stdout

- `test.cycyle` 이라는 Tag와 함께 들어오는 이벤트는 `stdout` 이라고 불리는 output plugin type을 사용할 것이라는 룰임.
- tag, event란?

# Event Srtucture
- 3개의 요소로 구성됨.
    - tag : 메세지 라우팅에 사용되며, 이벤트가 어디에서 들어오는 지 확인하는 용도.
    - time : 이벤트가 발생한 시간 (nanosecond)
    - record : JSON Obect 형식의 실제 로그 (전송해야할)

```
tag: apache.access         # set by configuration
time: 1362020400.000000000 # 28/Feb/2013:12:00:00 +0900
record: {"user":"-","method":"GET","code":200,"size":777,"host":"192.168.0.1","path":"/"}
```


# Processing Events
- input data따라, 각각 다른 이미 정의된 룰을 적용 시킬 수 있음.
- 즉 내부적으로 이벤트가 전송되기 전에, 어떤 체인으로 연결된 룰을 적용시킨다고 보면 될듯.

## Filter
> A Filter behaves like a rule to pass or reject an event

-  통과시키거나, 거부하는 룰인듯.

```
<source>
  @type http
  port 8888
  bind 0.0.0.0
</source>

<filter test.cycle>
  @type grep
  <exclude>
    key action
    pattern ^logout$
  </exclude>
</filter>

<match test.cycle>
  @type stdout
</match>
```

- match 전에 정의되었음
- grep잡아서, key 가 action인 데이터의 값이 `logout` 패턴이라면, 이 이벤트는 거부됨.
- 즉

```
$ curl -i -X POST -d 'json={"action":"login","user":2}' http://localhost:8888/test.cycle
HTTP/1.1 200 OK
Content-type: text/plain
Connection: Keep-Alive
Content-length: 0

$ curl -i -X POST -d 'json={"action":"logout","user":2}' http://localhost:8888/test.cycle
HTTP/1.1 200 OK
Content-type: text/plain
Connection: Keep-Alive
Content-length: 0
```

- 첫번째 이벤트는 filter를 통과하고, 두번째 이벤트는 필터를 통과하지 못함.


## Label
>  aims to solve the configuration file complexity and allows to define new Routing sections that do not follow the top-to-bottom order, instead they act like linked references

- configuratoin 파일의 복잡성을 해결하기 위해 나왔음.
- 새로운 Routing section을 허용해주는 것.
- 해당 label을 정의하면, filter 보다 먼저 찾아가게 되는듯.(이전 필터는 유지하고, 새로운 필터를 적용하고 싶을 때 사용되는 듯 버져닝 느낌)


## Buffers
> In this example, we use stdout, the non-buffered output
> you use outputs in buffered mode e.g. forward, mongodb, s3 and etc.

- 위에서 사용된 예시는 non-bufftered output인 stdout.
- 그렇지만 forward, mongodb, s3와 같은 값을 `@type` 과 사용하면, buffered mode를 사용할 수 있음.

> first stores the received events into buffers and then writes out buffers to a destination after meeting flush conditions

- 첫번째 store는 이벤트를 받고, 그리고 flush 조건에 만족하면, 목적지 버퍼에 쓸 수 있는 듯. (첫번째 이벤트 스토어 버퍼에 저장된 정보를 보낸다는 의미인듯)

# Input plugins

## tail

- 로그 파일을 `tail` 명령어를 통해서 읽어오는 것을 말함.
- 로그 파일이 변경되면 (rotated), 새로운 파일을 읽기 시작함.
- `pos_file` 을 사용할 경우, fluentd가 재 실행되었을 때, 읽은 파일의 마지막 위치 부터 다시 시작하게 도와줌.
    - position file

## forward

- 보통 다른 fluentd 노드로 부터 데이터를 전달받기 위해 사용함.
- 전달받는 데이터는 JSON 이나 Messagepack 형식으로 구성되어있음.

# Output plugins

## forward
> The out_forward Buffered Output plugin forwards events to other fluentd nodes.
> For replication, please use out_copy plugin. 

- 이벤트가 다른 fluentd node로 forward 되는 것을 의미
- 복제 방식은 `out_copy` 플러그인을 사용해라
- `standby` option
    - default : false
    - 해당 노드는 standby 타입이라 명시해줌.
    - 만약에 active node가 멈추면, standby node가 해당 역할을 대신함.
    - 즉 기본적으로 `forward` 방식에서 standby node로 설정된 노드는 **이용되지 않음**.

## s3

- [Send Apache Logs to S3](https://docs.fluentd.org/how-to-guides/apache-to-s3) 
    - real world use case
    - 실제 production 환경에 적용하려 할 때, 참고해보면 좋을듯.

# 참고
- https://jonnung.dev/system/2018/04/06/fluentd-log-collector-part1/
- https://docs.fluentd.org/