![](https://d2908q01vomqb2.cloudfront.net/fc074d501302eb2b93e2554793fcaf50b3bf7291/2017/10/03/exponential-backoff-and-jitter-blog-figure-8.png)
- [[exponential-backoff]] 의 한계점을 보완하기 위해 제시된 알고리즘
- 지연변이라는 의미
    - 즉 재시도의 간격을 일정한 비율이 아닌, 랜덤하게 재조정하는 걸 의미.
    - 그러면 네트워크 부하를 최대한 고르게 분산할 수 있을듯 싶음.
## 참고
- https://aws.amazon.com/ko/blogs/architecture/exponential-backoff-and-jitter/
- https://jungseob86.tistory.com/12