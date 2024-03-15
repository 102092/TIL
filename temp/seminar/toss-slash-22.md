# Java Native Memeory Leak 원인을 찾아서
- system.log에서 발생하는 OOM Killer 을 슬랙으로 연동
- OOM Killer?
    - 전체 시스템 안정성을 위해, 희생할 작업 (프로세스) 를 선택하는 것.
    - 일반적으로 Java로 서비스하고 있으면, OS에서 Java Process를 죽이는 경우가 많음
- Java Max Heap Size 가 1.5GB인데.. Java 프로세스가 사용한 메모리가 4GB
    - 2.5GB는 어디서 사용된것?

## 실제 사용량 측멍
    - `jcmd` 를 통해 자바 가상머신의 실제 메모리 사용량(heap, thread, code, gc..) 을 알 수 있음. (2GB)
    - TOP 명령어의 RSS 수치가, 해당 프로세스가 OS로 부터 할당 받아 사용하고 있는 메모리 리 (3.1GB)
    - 1.1GB 오차
    - 문제가 일어났을 때 TOP은 4GB를 나타내고 있었을 듯.
    - 그러면 약 2GB의 오차가 생기고 이게 어디서 발생한 건지 알아야함.

## Native Memeory Leak
    - TOP으로 확인할 수 있는 프로세스 메모리 사용량과, `jcmd` 를 통해 측정되는 자바 가상머신 실제 메모리 사용량의 차이
    - 이 컨퍼런스에서는 약 2GB 라 함 (4GB - 2GB)

## 예상 원인
    - JNI & JNA
    - DirectBuffer (native memory 가 할당됨. 그러면 GC에서 정리하지 못함)
    - APM 툴 (JavaAgent 기반)
    - 위 리스트에서 찾지 못함

## 시도했던 방법
    - 프로세스 조사, 프로세스 메모리 dump (pmap, smaps, gdb) strings 를 이용
    - Memory Allocator (malloc -> jemalloc)
        - 어떤 모듈에서 얼마나 메모리를 사용하는지 알 수 있음.
        - C2 Complier

- C2 Complier
    - Java 파일 컴파일 시 class 파일 생김
    - class파일을 OS가 이해하기 위해서는 기계어로 컴파일해야 하는데 이 역할을 JIT Complier 가 하게됨.
    - JIT Complier의 레벨은 0~4 단계로 진행하는데, 이 중 마지막 단계 해당 하는 것이 C2 Complier
    - C1 Complier는 빠르게 컴파일되기 위해 사용 (Client Complier)
    - C2 는 Server Complier로, 구동시간은 느리지만, JIT Complier의 최적화를 많이하여서 빠르게 연산할 때 사용됨.
        - 그래서 서버에서 많이 사용함

- TiredStopAtLevel이라는 옵션을 통해 Java에서는 Complier 레벨을 설정할 수 있음.

## 해결
    1. C1 Complier로 변경. 해결 그렇지만 CPU 사용량이 2배 증가
    2. JDK 11, 17 변경, 해결 안됨.
    3. OpenJDK의 Graal Complier 사용

## 참고
- https://www.youtube.com/watch?v=w4fWgLgop5U


--- 

# 토스증권 실시간 시세 적용기

- WebSocket
    - 비정상적이면, REST API 사용 (Polling API)
    - 실시간 시세, 역동적!

- 망분리 요건을 고려한 인프라 구조
    - 망분리 요건
        - 클라이언트가 증권사 서버에 직접 접속해선 안되고, 웹서버(DMZ) 를 경유해야함.
        - 토스에서는 WebSocket 서버가 DMZ

- Spring WebSocket with Stomp

## Load Balancing 방식에 따른 Connection 지연
- 해결
    - Round Robin + Least conntion

## WebSocket Connection Leak
- 문제
    - 접속사 수 차이 (HTTP vs WEBSOCKET, 같아야하는데..)
    - abnoraml 종료 시, 제대로 connection 이 제대로 종료되지 않음.
- 해결
    - WebSocketHandler를 새로 구현하여서, 명시적인 케이스 (1001..) 에 WebSocket Conenction이 닫히도록 구현

## 보안 장비 이슈
- 실시간 서비스 트래픽이 늘면서, 방화벽에서 레이턴시 발생
- 이 레이턴시로 인해, 해당 보안 인프라를 사용하고 있는 다른 서비스에서도 에러가 전파됨.

## Scale out 어려움
- AWS Cloud로 이전 고려중

## 참고
- https://www.youtube.com/watch?v=WKYE-QtzO6g&list=PL1DJtS1Hv1PiGXmgruP1_gM2TSvQiOsFL&index=11


# 왜 은행은 무한스크롤이 안되나요
- 왜?
    - 코어뱅킹 서버 (계정계) 에 적은 부하를 주기 위해서 특정 일자로 제한 하는 것.
- 토스 뱅크에서는 이러한 요청에 대해 코어 뱅킹에 바로 요청을 보내지 않음.




## 참고
- https://www.youtube.com/watch?v=v9rcKpUZw4o&list=PL1DJtS1Hv1PiGXmgruP1_gM2TSvQiOsFL&index=12