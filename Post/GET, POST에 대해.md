# GET, POST

![](https://upload.wikimedia.org/wikipedia/commons/3/3c/PostRedirectGet_DoubleSubmitSolution.png)



## GET

- 서버로부터, 정보를 **조회,요청**하기 위한 메서드.

- 요청을 할 때, 필요한 데이터를 HTTP Request body에 담지 않고, 요청 파라미터에 **쿼리스트링**을 담아 통해 전송됨.

  즉 주소창에 해당 내용이 표현된다는 의미.

  인터넷 주소창 URL 끝에 **?** 다음에 나타남.

  

  예를들면,

  [www.example-url.com/resources?name1=value1&name2=value2](http://www.example-url.com/resources?name1=value1&name2=value2)

  ? 이후에 쿼리스트링은 **이름** , **값** 으로 구성되어 있는데,

  name1 은 value1값과 매치되어, name2 는 value2 값과 매치되어 전송됨.  어디에? *서버!*



- 다만, 해당 요청값이 주소에 그대로 보이므로,

  1. 보완적인 문제가 있고,

  2. 그 값을 표현하는 길이에 제한이 있다는 단점이 있음.

  3. binary 데이터 전송이 불가능(사진,동영상)

     즉 대용량 데이터는 전송 불가.

- 그렇지만 상대적으로 `Post` 방식보다는 속도가 빠름.



- **핵심!**

  *Idempotent*

  get방식으로 요청하는 것은 , 서버에 동일한 연산을 여러번 요청해도, 동일한 응답이 돌아와야함.
  
  즉 데이터를 조회하는 경우에만 사용하자.



## POST

- 요청시 , 해당 내용이 HTTP Request body에 담겨서 전송됨.

  전송되는 것이 브라우저 url 상에 나타나지 않으므로, 기본적인 보안이 있다는 것을 알 수 있고,

  이를 통해 회원가입등의 요청을 보낼 때, `POST` 방식으로 해야함을 유추할 수 있음.

  다만 POST 방식이 **안전** 하다고는 볼 수 없다.

  왜?

  <u>특정 툴로 요청 내용을 확인 할 수 있기 때문에!</u>



- POST 요청을 보낼 때는 , 요청 헤더에 Content-Type을 표시해줘야 함.

  표시하지 않으면 서버는, 데이터 타입을 **유추** 하기 때문.



- binary 데이터 전송 가능

  즉 문자열 뿐만 아니라, **객체** 들도 전송 가능하다.

  그래서,

  1. 상대적으로 `get` 방식보다는 느리고

  

- **핵심!**

  *Non-idempotent*
  
  서버에 동일한 요청을 하더라도, 응답이 다를 수 있을 때 사용.
  
  즉 서버에 존재하는 데이터를 **변경** 시킬 때 사용해함.
  
  단 데이터 생성에 많이 사용함. (수정 : PUT or PATCH, 삭제 : DELETE)

> 참고

- https://hongsii.github.io/2017/08/02/what-is-the-difference-get-and-post/
- https://blackaaron.tistory.com/10
- https://simsimjae.tistory.com/218