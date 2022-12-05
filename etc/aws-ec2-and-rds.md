## EC2
### 기본
- apt,git
```bash
sudo apt-get update
sudo apt-get install git
```

### java
- 설치
```bash
sudo apt-get install openjdk-8-jdk
```
- 확인
```bash
java - version
```

### nginx
- 설치
```bash
sudo apt-get install nginx
```
- 관련 명령어
```bash
// 시작
$ sudo service nginx start
$ sudo systemctl start nginx
$ sudo /etc/init.d/nginx start

// 재시작
$ sudo service nginx restart
$ sudo systemctl restart nginx
$ sudo /etc/init.d/nginx restart

// 중지
$ sudo service nginx stop
$ sudo systemctl stop nginx
$ sudo /etc/init.d/nginx stop

// 상태
$ sudo service nginx status
$ sudo systemctl status nginx

// 설정 reload
$ sudo service nginx reload
$ sudo systemctl reload nginx
$ sudo nginx -s reload

// configuration file syntax check
$ sudo nginx -t
```
- 확인 : `ps -ef | grep nginx`

- 설정 파일 수정
- `sudo vi /etc/nginx/sites-available/default`
```bash
location /api/ {
	rewrite ^/api(/.*)$ $1 break; # url에서 api 뒤에 있는 URL을 전부 그대로 사용.
	# ip/api/blahblah로 들어온 요청은 ip/blahblah로 Spring에 전달됩니다.
	proxy_pass http://localhost:8080;
	}
```
- 재시작 : `sudo service nginx restart`




### node
- 설치
```bash
curl -sL https://deb.nodesource.com/setup_12.x | sudo -E bash -
sudo apt-get install -y nodejs
```



## RDS
### 파라미터 그룹
> MySQL 5.7
- utf8mb4
	- 검색어 : set
	- character_set_client
    - character_set_connection
    - character_set_database
    - character_set_filesystem	
    - character_set_results
    - character_set_server
  
- utf8mb4_unicode_ci
	- 검색어 : collation
    - collation_connection
    - collation_server
- Asia/Seoul
	- 검색어 : zone
    - time_zone

