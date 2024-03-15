- 데이터베이스
- 파일이나 디렉토리의 메타데이터 값을 설명하고 있음.
- 하드드라이브에서 물리적인 위치 또한 포함하고 있음.
	- 이를 통해, OS는 파일에서 정보를 추출할 수 있음.
	- 예를 들면 권한이나, 위치
- 만약에 파일이 A -> B 디렉토리로 변경된다면, 파일의 `inode` 또한 자동적으로 수정될 것임.
- 즉 `inode` 값은 변경이 가능하다.
- 정리하자면 파일들의 **고유 식별 정보**정도로 볼 수 있겠음.
- 아마도 2가지 참조 방식의 가장 큰 차이점은, **직접 이 식별정보를 참조하느냐 아니냐** 일듯
- `ls -i` 명령으로 inode 번호를 확인할 수 있음.