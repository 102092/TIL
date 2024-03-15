![image](https://miro.medium.com/max/1028/1*Q77tFyicUYPNVBh-9aYfeg.jpeg)

- 리눅스 파일을 참조할 때 사용하는 2가지 방법이 [[symbolic-link]] 와 [[hard-link]] 임.

## hard link란?

- [[inode]] 를 참조한다.
- 파일에서만 가져올 수 있음.
- [[hard-link]]를 사용한다면, 
	- 만약에 기존의 파일 내용이나 위치가 변경되더라도 하드링크는 여전히 기존의 파일을 가르키고 있는 것임.
- 즉 [[inode]] 가 여전히 해당 파일을 가르키고 있음.