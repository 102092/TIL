#linux 

![image](https://miro.medium.com/max/1028/1*Q77tFyicUYPNVBh-9aYfeg.jpeg)



- 리눅스 파일을 참조할 때 사용하는 2가지 방법이 심볼릭 링크와 하드 링크임.

## symbolic link

- `inode` 를 참조하지 않음.
- 디렉토리에 많이 사용됨.
- 윈도우에서 디렉토리 바로가기 링크가 이에 해당하는듯.
- 리눅스 시스템에서, [[mv]] 는 몇몇의 경우를 제외하면 [[inode]] 는 변경되지 않음.
- [[cp]] 의 경우 [[inode]] 변경됨.

## 참고

- [REAKWON :: [리눅스] Inode와 심볼릭 링크(Symbolic Link), 하드 링크(Hard Link) 개념과 실습](https://reakwon.tistory.com/142#:~:text=%EC%8B%AC%EB%B3%BC%EB%A6%AD%20%EB%A7%81%ED%81%AC%EA%B0%80%20%EC%9B%90%EB%B3%B8%20%ED%8C%8C%EC%9D%BC,%EB%B0%94%EB%9D%BC%EB%B3%B4%EB%8A%90%EB%83%90%EC%9D%98%20%EC%B0%A8%EC%9D%B4%EC%9E%85%EB%8B%88%EB%8B%A4.)
- https://medium.com/@307/hard-links-and-symbolic-links-a-comparison-7f2b56864cdd
- https://medium.com/obscure-system/mv-vs-cp-56f39ffe37d9
