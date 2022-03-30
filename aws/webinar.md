# 2022-03-30

## AWS Basic Networking Design
- 인터넷 게이트웨이가 있어야, 인터넷 연결이 가능하게 함.
- 엔드포인트
    - 게이트웨이 : S3, DynamoDB..와 같은 데이터베이스를 이야기하는듯.
- VPC flow logs
    - 어떤 트래픽이 어떤 서브넷을 거쳤고 어디에 들어간걸 볼 수 있음.
- Traffic Mirroring
    - 트래픽 실시간 네트워크 모니터링 (대규모)
- ENI : Elastic Network Interface
- 피어링에서 default vpc 사용하는 건 지양.
- 인터넷을 통신할 있으면 퍼블릿 서브넷, 통신할 수 없으면 프라이빗 서브넷
    - 프라이빗 서브넷 - 커스텀 라우팅 테이블 - 인터넷 게이트웨이 이렇게 연결하면 프라이빗 서브넷이 퍼블릭 서비넷이 된다고 볼 수 있음.


> S3의 인터페이스 타입과 게이트웨이 타입의 차이점은 뭔가요?
- 인터페이스 타입은 동일한 서브넷에 엔드포인트 네트워크 인터페이스를 만들고 적절한 액세스 권한을 가진 인터페이스에 자동으로 연결. 
- 게이트웨이 타입은 Gateway를 생성하신 후에 Route table에 등록을 해서 Route table에 associate된 내역을 보고 연결되게 되는 구조.
- 즉 인터페이스는 자동으로 해주는 것 같고, 게이트웨이는 관리자가 수동으로 해야되는 측면이 있는듯.


> 라우팅 테이블하고 인터넷 게이트웨이하고 차이?
- 주 라이팅 테이블 :  VPC를 생성하면 , 자동으로 생기는 테이블. 내부 트래픽을 처리
- 커스텀 라우팅 테이블 : public subnet에서 인터넷 통신을 위해 존재하는 장비. (0.0.0.0/0..)


## AWS EC2 를 이용한 Immutable Infrastructure 구성 알아보기
- Mutable Infra?
    - 동일한 인스턴스 (Server/VM)
    - 로컬에 삭제되지 않아야할 데이터가 있다면, 이 방식이 나음.
    - 동일한 인스턴스 내부에서 어떤 프로그램이 문제가 생긴다면, 변경하기 어려울 수 있음.
- Immutable Infra?
    - 새로운 인스턴스 (Server/VM)
    - No partial deployment state
    - 왜 중요?
        - Golden state 때문 (유저에게 의도한 대로 작동하게하는 것. 즉 가장 베스트, 오류 없게 동작하는 형태)
        - 인프라 복잡도를 낮춰줄 수 있음.
- AMI
    - 인스턴스의 템플릿의 스냅샷
- EC2 userdata를 통해 package 설치 자동화를 할 수 있음.
- ELB
    - ALB application load balancer(Layer 7, HTTP, HTTPS)
        - HTTP의 특정 헤더값을 보고 트래픽을 분해
    - NLB newtwork load balancer (layer 4, TCP, UDP, TLS)
- EC2 auto scaling
    - polling mangement, 비정상적인 인스턴스를 정상적인 인스턴스로 교체해주는 것.
    - CPU 부하에 따른, 인스턴스 추가..

- Route 53
    - Route 53은 LB에 대한 트래픽을 관리해주는 건가? 그런듯.
    - public internal DNS 관리.
    - alias record. 
        -  Alias record type으로 record를 설정
        -  source가 되는 ALB의 IP 변경사항을 1분이내에, 자동으로 감지
        -  dns resolve 값을 업데이트

### Hands on
- yaml 야믈..
- CloudFormation
- 오늘 한 거를 기반으로, 인프라 고도화를 할 수 있을 것 같다.
- Route 53을 이용하면 카나리 배포와 같이 사용할 수 있을 듯 싶다.
- 상용 서비스 도 좋지만, 왠만한건 AWS에서 제공해주는 듯 싶다 (부하 테스트, CloudWatch..)
- 태그를 잘 입력해야한다.
    - 그래야 나중에 리소스 추적이 쉬워진다.

    
