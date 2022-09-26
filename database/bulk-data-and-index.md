# 테이블 생성

```sql
User(id, name, rank, money, start_date, last_login)

# rank: 1-10
# money: 1-99999999
# nickname: 한글 2-10글자 
# start_date: 2019년 1월 1일 부터 현재값 랜덤
# last_login: null 허용, 2020년 4월 1일부터 현재

```

- `rank` 값은 굉장히 많은 컬럼들이 중복될 것이다.
  - 1-10 으로 넣으면, 분포가 10으로 몰릴 것.
  - 그럼 이 부분을 어떻게 코드로 처리해줄 수 있을까?
- 데이터 마다, 분포가 다르다.
- 목표 4백만건의 데이터를 `CSV` 파일로 생성해보자

## js 파일

```javascript
function main() {
  let data = "name,rank,money,start_date,last_login\n";
  for (let i = 0; i < 200000; i++) {
    data += randName() + ",";
    data += randomRank() + ",";
    data += randomMoney() + ",";
    data += randomDate(new Date("2019-01-01"), new Date(), false) + ",";
    data += randomDate(new Date("2020-04-01"), new Date(), true);
    data += "\n";
  }
  console.log(data);
}

function randName() {
  let text = "";
  let first =
    "김이박최정강조윤장임한오서신권황안송류전홍고문양손배조백허유남심노정하곽성차주우구신임나전민유진지엄채원천방공강현함변염양변여추노도소신석선설마주연방위표명기반왕모장남탁국여진구";
  let last =
    "가강건경고관광구규근기길나남노누다단달담대덕도동두라래로루리마만명무문미민바박백범별병보사산상새서석선설섭성세소솔수숙순숭슬승시신아안애엄여연영예오옥완요용우원월위유윤율으은의이익인일자잔장재전정제조종주준중지진찬창채천철초춘충치탐태택판하한해혁현형혜호홍화환회효훈휘희운모배부림봉혼황량린을비솜공면탁온디항후려균묵송욱휴언들견추걸삼열웅분변양출타흥겸곤번식란더손술반빈실직악람권복심헌엽학개평늘랑향울련";

  for (var i = 0; i < 1; i++)
    text += first.charAt(Math.floor(Math.random() * first.length));
  for (var i = 0; i < 2; i++)
    text += last.charAt(Math.floor(Math.random() * last.length));

  return text;
}

function randomRank() {
  return Math.floor(Math.random() * 10) + 1;
}

function randomMoney() {
  return Math.floor(Math.random() * 99999998 + 1);
}

function getFormatDate(date) {
  var year = date.getFullYear(); //yyyy
  var month = 1 + date.getMonth(); //M
  month = month >= 10 ? month : "0" + month; //month 두자리로 저장
  var day = date.getDate(); //d
  day = day >= 10 ? day : "0" + day; //day 두자리로 저장
  return year + "-" + month + "-" + day;
}

function randomDate(startDate, endDate, nullOk) {
  if (nullOk && Math.random() > 0.5) {
    return "null";
  }
  return getFormatDate(
    new Date(+startDate + Math.random() * (endDate - startDate))
  );
}

main();
```

- `node hello.js > hello.csv`
- node를 사용한다. 너무 많은 데이터를 생성하면... 터질수도 있음.

# 대용량 데이터 넣기

- 백엔드 개발자가 굉장히 많이 하는 작업
- 외부에서 제공되는 `CSV` 데이터를 서버에 넣는 작업을 주기 적으로 한다.
- `batch` 등을 이용하기도 함.
- mysql 의 `load data local infile` 명령을 이용함.
- 키워드 : **Bulk Insert!**
- 혹은 Jetbrain의 DataGrip 을 이용하면 좀 더 편하게 할 수 있기도 함.

## 검색하기

- 각각의 필드에 대해 지정검색, 범위검색, count()등을 실행해 보고 성능을 비교
- 특정 필드에 대해 정렬을 수행하고 성능을 비교

| column()   | 지정검색 (no index) | 지정검색(with index) | 범위검색(no index) | 범위 검색(with index) |
| :--------- | :-----------------: | :------------------: | :----------------: | :-------------------: |
| id         |        29ms         |                      |        25ms        |                       |
| name       |       1s 27ms       |         44ms         |        39ms        |         87ms          |
| rank       |        45ms         |         47ms         |        50ms        |         72ms          |
| money      |        860ms        |         39ms         |        49ms        |         71ms          |
| start_date |        100ms        |         47ms         |        55ms        |         73ms          |
| last_login |        53ms         |         52ms         |        48ms        |         79ms          |

| count()    | 지정검색 (no index) | 지정검색(with index) | 범위검색(no index) | 범위 검색(with index) |
| :--------- | :-----------------: | :------------------: | :----------------: | :-------------------: |
| id         |        25ms         |                      |        21ms        |                       |
| name       |        723ms        |         40ms         |       664ms        |         53ms          |
| rank       |        615ms        |         89ms         |       627ms        |         455ms         |
| money      |        597ms        |         36ms         |       630ms        |         565ms         |
| start_date |        681ms        |         38ms         |       688ms        |         200ms         |
| last_login |        671ms        |         38ms         |       694ms        |         116ms         |

| 정렬       | ASC (no index) | DESC (no index) | ASC (with index) | DESC 검색(with index) |
| :--------- | :------------: | :-------------: | :--------------: | :-------------------: |
| id         |      47ms      |      49ms       |                  |                       |
| name       |    1s 802ms    |    1s 833ms     |       42ms       |         55ms          |
| rank       |    1s 105ms    |    1s 105ms     |       43ms       |         51ms          |
| money      |    1s 100ms    |    1s 114ms     |       47ms       |         55ms          |
| start_date |    1s 129ms    |    1s 125ms     |       53ms       |         56ms          |
| last_login |    1s 140ms    |    1s 163ms     |       49ms       |         54ms          |

> 현재 위 데이터는, 정확하지 않다, 아마도 데이터 갯수를 적게 해서 그런듯.

# 인덱스 생성 및 성능 비교

## 인덱스란?

- 테이블에서 원하는 데이터를 빠르게 찾기 위한 색인 혹은 테이블의 사본
- B-tree 자료구조로 되어있음.

## 인덱스 생성 방법

```sql
CREATE INDEX 인덱스이름 ON 테이블이름 (필드이름1, 필드이름2, ...)
```

- 언제 인덱스를 만듬? SELECT를 많이 쓸 때, 있으면 좋음.
- Covering Index : 인덱스가 모든 것을 처리했다.
- 인덱스를 만드면, Secondary Index가 만들어짐.
- Secondary Index
  - K(특정 필드값) -- V(PK)
  - 특정 필드값을 `SELECT 필드....` 하면 모든 데이터에 접근하지 않아도, 인덱스에만 접근하게됨
- Seconday Index 를 생성하면, 실제 7페이지 3(Secondary Index) + 3(Primary Index) + 1(data page) 를 읽어야 해당 값에 접근할 수 있음.

## 인덱스 생성 후 정렬 성능은 어떻게 변하는가?

- 전반적으로 개선됨.
- 왜? 미리 PK를 정렬해놓기 때문에 좋아진다.
- Oracle, Postsql, MsSQL은 확실한 관계형 데이터 베이스
  - MySQL은 간단한 쿼리에서 가장 빠르다. 왜? 실행할 수 있는 경우의 수가 1개에 가깝다.
  - 그렇지만 Oracle 같은 경우, 쿼리를 실행하려고 명령을 줬을 경우에, 어떤 API가 가장 빠를지 생각하고 실행하기 때문에 느림.
  - 하지만 복잡한 쿼리일 경우 Oracle이 훨씬 빠르다. 즉 비교 대상이 아님.

## 모든 필드들의 검색 성능은 동일한가?

- 아니다.
- 특히 char file의 성능이 다른 필드에 비해 다르다

## 인덱스를 사용하면 무조건 성능이 개선되는가?

- 아니다.
- column의 범위 검색을 했을 경우에는 성능이 저하되는 것을 확인할 수 있었음.

## 오름차순 / 내림차순 정렬의 성능은 동일한가?

- 인덱스 없이 정렬할 경우에는 거의 비슷하다고 보여짐
- 그렇지만 인덱스를 생성한다면, 오름차순이 내림차순 보다 조금 빠르다고 생각됨
- 왜 그럴까?
  - 그냥 생각해보면 기본적인 정렬은 오름차순이기 때문에, 좀 더 최적화 되어 있지 않을까?
  
  - MySQL의 B-tree가 document상에는 양방향 연결이라 되어있지만, 실제로는 단방향 연결이기에, backward index가 더 시간이 걸린다.
  
> 참고 : <https://tech.kakao.com/2018/06/19/mysql-ascending-index-vs-descending-index/>

## Selectivity란 무엇일까?

- 분포도, 특정 컬럼의 데이터가 **평균적으로 분포 되어 있는 정도**를 의미함.
- 인덱스로 적정한 분포도는 **10~15%**
- 계산식 : `1/해당 컬럼의 distinct 데이터 개수 * 100`
- 분포도는 괜찮지만 즉 적정하지만, 데이터의 분포가 불균형하다면, 인덱스로 만들지 않는 것이 나을 수도 있음.
- 분포도가 좋다는 의미는, 서로 다른 데이터의 값이 중복없이 존재한다는 말.
  - 회원 테이블에 1만건의 데이터가 있다고 가정
  - 회원 id는 고유하기 때문에 분포도는 1/10,000 * 100 즉 1%이고
  - 시도구분 컬럼 같은 경우에는 중복이 많이 될 수 있고, 10개의 시도 구분이 있다면 1,000/10,000 * 100 10%임을 알 수 있음.
- 성별 같은 경우에는 분포도가 안좋음.
  - 왜? 남 혹은 여이기 때문에
  - 5,000 /10,000 * 100 =50%
  - 성별을 포함에서 인덱스를 만드는 경우, 이름 - 나이 - 성별 같이, 분포도가 안좋은 것들 그러니까 겹칠 가능성이 높은 것들을 뒤쪽에 넣는 것이 좋다.
  - 왜? 차례대로 check 하므로.
  
## 복합 인덱스 생성 및 성능 비교

- 복합 인덱스는 순서가 중요하다.
- (Rank , Date) vs (Date, Rank) 다르다!
- 다음시간에!

## 추가적인 질문

- InnoDB 에서 B-tree가 아닌 다른 인덱스를 사용할 수 있을까?
  - 있음!
  - 예 : Hash O(1) / Hash는 범위 검색이 힘들다.
  - spacial , 지도, 반도체등.. 좌표가 중요한 데이터
    - 이런 것을 위한 R-tree가 있음. 즉 공간 데이터용 인덱스가 따로 있음.
  - Json용 fulltext용 있음.

- idnex는 아무거나 만든다고 성능이 향상되지 않는다. 즉 쿼리 최적화를 알아야, index를 잘 쓸 수 있음.
