![image](https://d2908q01vomqb2.cloudfront.net/fc074d501302eb2b93e2554793fcaf50b3bf7291/2017/10/03/exponential-backoff-and-jitter-blog-figure-4.png)

- 일정 시간 간격을 두고, 재시도.
- 그리고 일정 시간 간격은 **점진적** 으로 증가한다.
- 예를 들면, 첫번째 재시도 100ms -> 두번째 200ms -> 세번째 400ms (2배씩..)
- 이런 방식을 통해, 재시도의 네트워크 부하를 줄이는 것을 유도.
- 하지만 생각해보면 만약에 한꺼번에 많은 요청이 들어오고, 그리고 이 모든 요청이 실패한다면 **똑같은** 간격 으로 재시도를 할 것임.
    - 그렇다면, 의도한 재시도 시에 네트워크를 부하를 줄이는 것은 달성하지 못할 수도 있음.

# 참고
- https://aws.amazon.com/ko/blogs/architecture/exponential-backoff-and-jitter/
- https://jungseob86.tistory.com/12