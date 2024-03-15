#docker

## 배경
- 로컬에서 사용 중인 docker(mysql) 의 구조를 main-repl 형태로 변경할 필요가 생김.
- 처음 생각은 `mysql dump`, `mysql main-repl on docker` 등의 키워드를 통해서  


## mysql dump, restore data
- 일반적인 dump 커맨드를 찾아보기보다는, 공식문서(docker)에서 찾아보는 게, 덜 고생했을듯 싶음.
- 아래 커맨드를 통해, 메인 DB의 data를 dump 하고, repl 구성 후, 동기화 하는 방식으로 했음.

### Creating database dumps

```
docker exec some-mysql sh -c 'exec mysqldump --all-databases -uroot -p"$MYSQL_ROOT_PASSWORD"' > /some/path/on/your/host/all-databases.sql
```
- `--master-data` 같은 옵션을 붙어줘도 괜찮을듯, [참고](https://dev.mysql.com/doc/mysql-replication-excerpt/5.7/en/replication-howto-mysqldump.html)
- `all-database.sql` 모든 데이터베이스를 dump 뜸.


### Restoring data from dump files

```
docker exec -i some-mysql sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD"' < /some/path/on/your/host/all-databases.sql
```



##  Setting Up Binary Log File Position Based Replication
- replica 데이터베이스를 도커에 띄운 상태라 가정.
- replica db에는 아무런 데이터 베이스가 없으며, configuration은 메인과 동일한 상태


### Setting the Replication Source Configuration

```
server-id=1
log-bin=mysql-bin
```

- server-id, main-repl을 구분하기 위해
- log-bin, `Binary logging` 을 동작하기 위해
    - 이 기능을 통해서, 메인디비의 변경사항이 기록되고, 이 로그 기록을 통해 복제디비에 변경사항이 복제된다고 이해됨.


### Creating a User for Replication

```
CREATE USER 'repl'@'%.example.com' IDENTIFIED BY 'password';
GRANT REPLICATION SLAVE ON *.* TO 'repl'@'%.example.com';
```

- 메인 디비에서, replication에 사용할 유저를 생성


### Obtaining the Replication Source's Binary Log Coordinates

```
mysql > SHOW MASTER STATUS;
+------------------+----------+--------------+------------------+
| File             | Position | Binlog_Do_DB | Binlog_Ignore_DB |
+------------------+----------+--------------+------------------+
| mysql-bin.000003 | 73       | test         | manual,mysql     |
+------------------+----------+--------------+------------------+
```
- repl 에서 master 설정할 때 필요한 정보들


### Choosing a Method for Data Snapshots

- 위 첫번째 문단 참고해서, dump 실행


### Setting Up Replicas

```
server-id=2
```

- configuration 파일에, replica를 구분할 수 있는 유니크한 서버 아이디 설정


### Setting the Source Configuration on the Replica

```
CHANGE MASTER TO
MASTER_HOST='mysql-master',
MASTER_USER='replication',
MASTER_PASSWORD='Slaverepl123',
MASTER_LOG_FILE='87e8982d00d1-bin.000004',
MASTER_LOG_POS=349;
```

- repl db에서
- `LOG_FILE` 은 Main 에서 `SHOW MASTER STATUS` 를 통해 보이는 `File` 값
    - `log-bin` 에 설정된 값이 prefix로 붙어있는 듯.
- `LOG_POS` 는 위 명령의 결과 값 중에 `Position`


### Setting Up Replication between a New Source and Replicas

- 위 첫번째 문단 참고해서, repl 에 데이터 restore 실행
- 메인, 복제 디비의 데이터가 똑같은 상태에서, replication이 시작되어야 데이터의 정합성이 맞다고 볼 수 있겠음.

### Start the replication threads

```
START SLAVE;
```

- repl에서, SLAVE 활동 시작
- 이제 메인 디비에서 테이블 생성, 혹은 데이터 생성등이 repl에 자동적으로 적용되는 지 확인하면 끝.


## Reference
- https://hub.docker.com/_/mysql
- https://dev.mysql.com/doc/mysql-replication-excerpt/5.7/en/replication-howto-slavebaseconfig.html
- https://sesamedisk.com/docker-mysql-master-slave-replication-with-docker/