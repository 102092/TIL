# 문제점

- 한번에 한개만 동작하던 프로세스(Tomcat), 여러 개의 프로세스가 동작할 수 있도록 변경.

- 그런데 관리되던 로그파일도 하나
  
  배포 스크립트 예시
  
  ```bash
  ...
  
  cp /hello-spring/spring.log /logs/spring-$(date +$s).log
  nohup java -jar /hello-spring/target/hello-spring.jar 2> spring.log 1> dev/null &
  ```

---

- 만약에 A 프로세스가 동작 중이다가, B가 배포된다고 할 때, `nohup` 이 후 발생한 A 로그를 못볼 수 있음.



# 해결

- `mv` 커맨드를 이용

- `mv /hello-spring/spring.log /logs/spring-(date +s).log` 이런식으로 사용하면, A 프로세스에 `nohup` 을 통해 발생하던 로그가 지속적으로 쌓이는 듯.

- 즉 파일 이름은 바뀌지만, `nohup`  을 통해 로그가 쌓이던 링크는 변화가 없는듯함.



# 배경

- `mv` 는 파일의 이름을 변경하거나, 디렉토리를 이동시킬 때 사용 (혹은 둘다)



# 사용

```bash
mv [OPTIONS] SOURCE DESTINATION
```

- 기본적으로 사용되는 방법



```bash
mv file1 file2 dir1
```

- 여러개의 파일을 옮길 수도 있음.

- 기타 옵션들은 [여기](https://tldr.ostera.io/mv)  참고해보면 좋을듯.



# 참고

- [linux - Run a java program in backend - Stack Overflow](https://stackoverflow.com/questions/9323690/run-a-java-program-in-backend)

- [How to Move Files and Directories in Linux (mv Command) | Linuxize](https://linuxize.com/post/how-to-move-files-in-linux-with-mv-command/)
