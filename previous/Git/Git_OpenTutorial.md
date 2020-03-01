# **생활코딩 Git**

\- [링크](https://opentutorials.org/module/2676)

> 필요한 기억해야할 깃 명령어를 정리.

#### 1. 저장소 만들기, 파일등록

- ```mkdir``` : 폴더 만들기
- ```cd``` : 폴더간 이동
- ```git init``` : 현재 디렉토리에 git의 저장소를 만들기
- ```ctrl + L ```= 커맨드창 화면 초기화
- ```rm -r.git``` : init 취소
- ```vim {f1.txt}``` : f1.txt 파일을 생성
- vim 안에 들어간 상태에서 ```i``` 버튼 눌면 편집 가능 ```esc``` 편집 종료
- ```esc``` 누른 상태에서 ```:wq``` 누르면 저장하고 나가기
- ```git add f1.txt``` : f1.txt 파일을 git이 추적하도록 명령
- ```git status``` : 프로젝트 폴더의 상태 확인



#### 2. 버전 만들기(commit,add)

- 처음 깃 사용, 사용자 설정.

  - ```git config --global user.name "자신의 닉네임"```

  - ```git config --global user.email "자신의 이메일"```

- git은 commit 전에 add를 꼭해야 합니다. 그 이유는 선택적으로 파일을 버전에 포함시키기 위해서 입니다. 여기서는 이에 대한 설명을 합니다.
  - git add -> stage area -> git commit (local)| -> git push



#### 3. 변경사항 확인하기(log,diff)

- git add 전 마지막 리뷰를 위해 git diff 사용. 왜? 자신의 실수를 찾아볼수 있는 기회.

- ```git log -p``` : 로그에서 출력되는 버전 간의 차이점(구체적으로) 출력
  - +++ 최근버젼, --- 이전버젼, 그 옆에 변경 내용이 간단하게 적혀있음

- ```git diff 버전 id'..버전 id2``` : 버전 간 소스 상의 차이점을 비교.

- ```git diff``` : git add 하기 전과 add한 후의 파일 내용을 비교.

- git bash 복사 & 붙여넣기 → 복사 : ctrl + insert, 붙여넣기 : shift + insert



#### 4. 과거의 버전으로 돌아가기

- commit을 취소할 수 있는 명령어

  - ```git reset --hard 버전 id```

  - 로컬커밋 내용을 아예 삭제, 기록도 남지 않음 (hard 위험함.. soft도 있음, 공유한 이후에는 절대로 reset 하면 안됨)

- ```git revert``` 버전 id

  - 해당 버젼 id 커밋을 취소한 내용을 새로운 버전으로 만드는 명령어
  - reset처럼 해당 버젼으로 되돌아가긴 하지만, 지워진 버전 기록은 남음.

  - 즉 웹으로 푸시한 이후에 revert를 사용하면 그 전 커밋 기록은 남음과 동시에 새로운 버젼으로 선언
  - revert를 통해 돌아간 버젼을 최신으로 인식.

- ```git commit --help``` : 깃 명령어에 대한 도움말.