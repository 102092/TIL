# Symbolic, Hard link



![](https://miro.medium.com/max/1028/1*Q77tFyicUYPNVBh-9aYfeg.jpeg)



- 리눅스 파일을 참조할 때 사용하는 2가지 방법이 심볼릭 링크와 하드 링크임.



## inode

- 데이터베이스
  
  - 파일이나 디렉토리의 메타데이터 값을 설명하고 있음.
  
  - 하드드라이브에서 물리적인 위치 또한 포함하고 있음.

- 이를를 통해, OS는 파일에서 정보를 추출할 수 있음.
  
  - 예를 들면 권한이나, 위치

- 만약에 파일이 A -> B 디렉토리로 변경된다면, 파일의 `inode` 또한 자동적으로 수정될 것임.
  
  - 즉 `inode` 값은 변경이 가능하다.

- 정리하자면 파일들의 고유 식별 정보정도로 볼 수 있겠음.
  
  - 아마도 2가지 참조 방식의 가장 큰 차이점은, **직접 이 식별정보를 참조하느냐 아니냐** 일듯

- `ls -i` 명령으로 inode 번호를 확인할 수 있음.
  
  

## hard link

- `inode` 를 참조한다.
- 파일에서만 가져올 수 있음.
- 하드링크를 사용한다면, 만약에 기존의 파일 내용이나 위치가 변경되더라도 하드링크는 여전히 기존의 파일을 가르키고 있는 것임.
  - 즉 `inode` 가 여전히 해당 파일을 가르키고 있음.



## symbolic link

- `inode` 를 참조하지 않음.

- 디렉토리에 많이 사용됨.

- 윈도우에서 디렉토리 바로가기 링크가 이에 해당하는듯.



## mv, cp

- 리눅스 시스템에서, `mv` 커맨드는 몇몇의 경우를 제외하면 inode는 변경되지 않음.

- cp의 경우 inode 변경됨.



# 참고

- [REAKWON :: [리눅스] Inode와 심볼릭 링크(Symbolic Link), 하드 링크(Hard Link) 개념과 실습](https://reakwon.tistory.com/142#:~:text=%EC%8B%AC%EB%B3%BC%EB%A6%AD%20%EB%A7%81%ED%81%AC%EA%B0%80%20%EC%9B%90%EB%B3%B8%20%ED%8C%8C%EC%9D%BC,%EB%B0%94%EB%9D%BC%EB%B3%B4%EB%8A%90%EB%83%90%EC%9D%98%20%EC%B0%A8%EC%9D%B4%EC%9E%85%EB%8B%88%EB%8B%A4.)

- https://medium.com/@307/hard-links-and-symbolic-links-a-comparison-7f2b56864cdd

- https://medium.com/obscure-system/mv-vs-cp-56f39ffe37d9
