- https://www.youtube.com/watch?v=EaHlancPA14

## intro

- 기본적으로 CrudRepository를 상속받으면, 많이 사용하는 method(save..등에 대해서는) 사용할 수 있음.
- `logging.level.sql`  을 통해 사용되는 sql 을 로그 찍어 볼 수 있음.

- `one to many `

  

## Mapping Relationships

### One to One

- 영화는 대여 될 수 있음.
- 대여는 기간과, 가격을 가지고 있을 것.
- 하나의 영화는 한번의 렌털만 할 수 있으므로, 1:1 관계를 가진다고 할 수 있음.
- 1:1 맵핑되어있는 객체에서 한 쪽을 지우면, 데이터 베이스에서 자동으로 delete를 실행함.



### One to Many

- annotation 설정 없이도, 1:다 관계를 설정할 수 있음.
- 단순히 One 객체에, Map등의 여러객체를 저장할 수 있는 공간을 만드는 것만으로
- 그렇지만 Many에 해당하는 테이블은 pk키가 있어야함.
  - Map<String, String>이면, key에 해당하는 형태는 text이어야함.
- 이정도는 매칭해주는구나.



### Many to Many

- Spring data jdbc에서 직접적으로 지원해주느지는 않는 듯.
- 작가와, 도서의 관계는 다:다 관계라고 볼 수 있음.
- 어노테이션 있음.
- 문제가 있음.
  - 어떤 entity가 이 관계에서 중요한 위치인지 알 수 있는 방법이 없음.
  - entity의 id를 이용
- 