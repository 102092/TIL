## 참고

- [빅데이터 전문가의 하둡관리](http://www.yes24.com/Product/goods/66586271)
- https://www.opentutorials.org/course/2908/17055



## 소개

- 하둡은 엄청난 데이터세트를 다루기 위함이 목적

- 아마존 AWS도 하둡 기반 서비스

- 저렴한 컴퓨터로, 대용량 데이터를 저장..

- Motto : 로직이 데이터로 접근하지말고, 데이터가 있는 곳에 로직을 옮기자

- 하둡의 핵심은 **HDFS, Yarn**

- 왜 하둡?
  1. 대용량 파일을 저장할 수 있는 분산 파일 시스템
  2. 장비를 증가하면 성능이 선형으로 증가
  3. 무료!

- 하둡으로 어떤 데이터를 다루는가?
  
  - 서버 로그, 비정형 데이터, 클릭 스트림, 지리데이터등..
  
- 분산파일 시스템?

  하둡 네트워크에 연결된 기기에 저장하는 분산형 파일 시스템



## 아키텍쳐

![](https://s3-ap-northeast-2.amazonaws.com/opentutorials-user-file/module/2926/6496.png)

- HDFS는 마스터 노드 1개, Slave 역할하는 데이터 노드 여러개



## 하둡 리눅스 설치

- 파일풀기

```
[hadoop@master ~]$ su -
Password: 
Last login: Wed Jul 31 13:04:07 EDT 2019 on pts/0
[root@master ~]# cd /usr/local
[root@master local]# pwd
/usr/local
[root@master local]# tar -xvf /home/hadoop/Downloads/jdk-8u221-linux-x64.tar.gz 
[root@master local]# chown -R hadoop:hadoop /usr/local/jdk1.8.0_221/
[root@master local]# ls -al


[root@master local]# tar -xvf /home/hadoop/Downloads/eclipse-jee-photon-R-linux-gtk-x86_64.tar.gz 
[root@master local]# ls -al
[root@master local]# chown -R hadoop:hadoop /usr/local/eclipse/
[root@master local]# ls –al

[root@master local]# tar -xvf /home/hadoop/Downloads/hadoop-2.7.7.tar.gz 
[root@master local]# chown -R hadoop:hadoop /usr/local/hadoop-2.7.7/
[root@master local]# ls –al

```

- 호스트 네임 변경

```
[root@master ~]# hostnamectl set-hostname  slave1
/bin/hostname -F /etc/hostname //이 명령어를 통해 서버를 재실행하지 않아도, 호스트 네임 변경을 알 수 있음.
```



- .bashrc 환경설정

![1565761593286](Hadoop.assets/1565761593286.png)

![1565761598045](Hadoop.assets/1565761598045.png)

- source.bash_profile을 해야, hadoop version이 작동한다.



- linux에서 ip 확인 = ifconfig

- Master node 와 slave node에서 , ![1565761651971](Hadoop.assets/1565761651971.png)

![1565761672699](Hadoop.assets/1565761672699.png)

- slave ssh설정

![1565761693456](Hadoop.assets/1565761693456.png)

- ssh를 통해 통신한다. 
- 중간에 yes or no 물어보는 확인창이 나오는데 처음 통신하면 확인 차 물어보는 것으로 yes해서 넘어가도록 하자



master : 192.168.153.130
slave1 : 192.168.153.131

192.168.153.130 master
192.168.153.130 secondary
192.168.153.131 slave1
192.168.153.130 slave2