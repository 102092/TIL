#linux #tip 
## SCP 명령어를 이용해서, remote 서버에서 여러개의 파일을 로컬 서버로 다운받는 방법

```sh
scp 'SERVERNAME:/DIR/\*' .
```

- quote, esacpe 문자가 `*` 앞에 있어야함.
- 그래야 해당 `*` 가 특정 패턴을 의미하는 지 알수 있는 듯.
- 테스트 해본 결과, quote 가 없어도 `\` 만으로도 내가 원하는 파일들만 골라서 다운로드가 가능했음.

## R 옵션 사용
```sh
scp -r ~/test_folder/ twpower@[IP주소]:/home/twpower
```

- 폴더 자체를 내 로컬 서버로 다운로드.
## 참고
- https://twpower.github.io/138-send-file-using-scp-command
- https://unix.stackexchange.com/questions/27419/how-to-use-wildcards-when-copying-with-scp