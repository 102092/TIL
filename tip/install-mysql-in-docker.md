#docker
### 생성
```bash
docker run --name <ContainerName> -p 3306:3306 -e MYSQL_ROOT_PASSWORD="password" -d mysql:5.7.29 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```

### 접속
```bash
docker exec -it <ContainerName> env TERM=xterm-256color script -q -c "/bin/bash" /dev/null
```

### 추가 설치, 설정
- apt
```bash
apt-get install apt
apt update
apt install vim -y
```

- vim
```bash
# vim ~/.bashrc
if [ -x /usr/bin/dircolors ]; then
test -r ~/.dircolors && eval "$(dircolors -b ~/.dircolors)" || eval "$(dircolors -b)"
alias ls='ls --color=auto'
alias grep='grep --color=auto'
alias fgrep='fgrep --color=auto'
alias egrep='egrep --color=auto'
fi
```

- mysql
```bash
vi /etc/mysql/mysql.conf.d/mysqld.cnf
```
- 해당 설정 파일을 아래와 같이 바꿔준다.
```bash
[client]
default-character-set = utf8mb4

[mysqld]
init-connect = 'SET collation_connection = utf8mb4_unicode_ci'
init-connect = 'SET NAMES utf8mb4'
character-set-server = utf8mb4
collation-server = utf8mb4_unicode_ci
default_time_zone='+09:00'

[mysql]
default-character-set = utf8mb4

[mysqldump]
default-character-set = utf8mb4
```
- 재시작
```bash
service mysql restart
```

### 시작
- `docker restart <ContainerName>`
- `docker exec`
- 설정이 제대로 되었는 지 확인
```sql
SHOW VARIABLES LIKE 'char%';

+--------------------------+----------------------------+
| Variable_name            | Value                      |
+--------------------------+----------------------------+
| character_set_client     | utf8mb4                    |
| character_set_connection | utf8mb4                    |
| character_set_database   | utf8mb4                    |
| character_set_filesystem | binary                     |
| character_set_results    | utf8mb4                    |
| character_set_server     | utf8mb4                    |
| character_set_system     | utf8                       |
| character_sets_dir       | /usr/share/mysql/charsets/ |
+--------------------------+----------------------------+

SHOW VARIABLES LIKE '%collation%';

+----------------------+--------------------+
| Variable_name        | Value              |
+----------------------+--------------------+
| collation_connection | utf8mb4_general_ci |
| collation_database   | utf8mb4_unicode_ci |
| collation_server     | utf8mb4_unicode_ci |
+----------------------+--------------------+
```

### DB 설정
```sql
CREATE DATABASE db_name;

CREATE USER 'user'@'%' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON db_name.* TO 'user'@'%';

FLUSH PRIVILEGES;
```
- % 모두 해당 유저로 접속할 수 있도록 허락해줌
- 여기 부분에 특정 IP 혹은 localhost로 선언해줄 수도 있음