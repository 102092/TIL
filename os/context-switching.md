- context 는 현재 작업 중인 문백맥
- 현재 작업 중인 문맥이 변화하기 때문에 switching
- 즉 실행 중인 값을 메모리에 잠깐 저장하고, 이후에 다시 실행하는 시점에 저장한 값을 CPU로 불러오는 과정을 의미
- 이 과정에서 비용이 발생함
- 다시 말해, multi-thread는 대부분 효율적이지만, [[context-switching]] 이 필요하므로, **항상** 효율적인 것은 아니다.
## Reference
- https://www.inflearn.com/course/lecture?courseSlug=%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B3%A0%EA%B8%89-1