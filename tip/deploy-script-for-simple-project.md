> jar
```
PID=$(jps | grep baseball09-0.0.1-SNAPSHOT.jar | awk '{print $1}')
GIT_REPO="https://github.com/codesquad-member-2020/baseball-09.git"
kill -9 $PID
sleep 1
rm -rf baseball-09
git clone -b $1 --single-branch $GIT_REPO
sleep 1
cd baseball-09
cd BE
./gradlew build -x test
sleep 1
cd build/libs
nohup java -jar -Dspring.profiles.active=prod baseball09-0.0.1-SNAPSHOT.jar &
```
---

```sh
#!/usr/bin/env bash

REPOSITORY=/opt/testapp
cd $REPOSITORY

APP_NAME=action # model name
JAR_NAME=$(ls $REPOSITORY/build/libs/ | grep '.jar' | tail -n 1)
JAR_PATH=$REPOSITORY/build/libs/$JAR_NAME

CURRENT_PID=$(pgrep -f $APP_NAME)

if [ -z $CURRENT_PID ]
then
  echo "> 종료할것 없음."
else
  echo "> kill -9 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> $JAR_PATH 배포"
nohup java -jar $JAR_PATH > /dev/null 2> /dev/null < /dev/null &


```

---
### airbnb 11
```bash
APP_NAME=airbnb
GIT_REPO="https://github.com/codesquad-member-2020/airbnb-11.git"

CURRENT_PID=$(pgrep -f $APP_NAME)

if [ -z $CURRENT_PID ]
then
        echo "> 종료할것 없다!"
else
        echo "> kill -9 $CURRENT_PID"
        kill -15 $CURRENT_PID
        sleep 5
fi

echo "> GIT CLONE"
rm -rf airbnb-11
git clone -b dev --single-branch $GIT_REPO
sleep 1

cd airbnb-11
cd BE
echo "> Build Start"
./gradlew build -x test
sleep 1

cd build/libs
nohup java -jar -Dspring.profiles.active=prod airbnb11-0.0.1-CAT.jar > /dev/null 2> /dev/null < /dev/null &
echo "> Build End"
```

### 스크립트 작성 후
- `chmod +x script.sh` 를 해줘야 실행권한을 주는 셈 