## what is service mesh ?

> ... The term “service mesh” describes both the type of software you use to implement this pattern, and the security or network domain that is created when you use that software.

- 어떤 패턴을 구현하는데 사용한 소프트웨어 유형이나 보안 네트워크 도메인을 모두를 지칭하는 말
- 어떤 패턴?

> Modern applications are typically architected as distributed collections of microservices, with each collection of microservices performing some discrete business function. 

- 분산 컬렉션
- 각 컬렉션은 개별적인 비즈니스 기능을 수행하고 있고,

> A service mesh is a dedicated infrastructure layer that you can add to your applications

- 정리하자면 서비스 매시는 인프라계층을 일컫는 말

## what is the benefit ?

>. Routing this communication, both within and across application clusters, becomes increasingly complex as the number of services grow. Istio helps reduce this complexity while easing the strain on development teams.

- 애플리케이션 간 통신 라우팅에 대한 복잡도를 줄이는 데 기여한다.

## reference
- https://istio.io/latest/about/service-mesh/