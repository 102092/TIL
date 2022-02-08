## 문제

- EC2 인스턴스에서 배포를 진행하는 bash script 파일 권한이 644임.
  
  - 그래서 바로 실행이 불가.

- 해당 폴더 내부 다른 스크립트 파일은 755..
  
  - 뭐지?



## 해결

- 해당 스크립트가 존재하는 인스턴스 내부에서 `chmod` 명령어를 통해 권한 변경을 시도
  
  - `git` 에서 관리되는 파일이라서 그런지 `pull` 되면 이전 권한(644) 로 복구됨.
  
  - 아마 해당 파일의 권한이 644로 Origin에서 관리되고 있어서 그런듯.

- 로컬에서 해당 파일 권한 확인
  
  - `ls -al`
  
  - 실행 권한 없음.
  
  - 아 로컬에서 해당 권한을 주지 않고 Origin에 올라간 듯함.

- `chmod +x script.sh`

- `git ls-tree HEAD`
  
  - 이 명령어를 통해 명시적으로 (좀 더 보기 쉽게) git으로 관리되는 **파일의 권한을 확인**



## 배운점

-  git 파일권한 변경 추적기능이 있음.       
- 그리고 그 권한을 확인하거나, on-off 할 수 있음.
- 단순히 `chmod` 를 통해 파일 권한을 변경할 수 있지만, 만약에 이 방법이 깃으로 관리되는 파일에 먹히지 않을 경우, `git update-index --chmod` 명령어 사용도 고려해보면 좋을듯

## 참고

- [Dev: GIT 스크립트 실행권한 설정하기 - Develope, Design and Make](https://nounique.github.io/development/git-execution-permission/)
