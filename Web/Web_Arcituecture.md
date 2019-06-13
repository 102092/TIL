# Web

### 1. WebApp_Arch

#### 1.1 HTTP_Message 예시

- 기본적인 웹 요청, 응답 구조.

![](Web_Arcituecture.assets/HTTP_Message.gif)

- 일반적으로는 헤더 정보를 볼 수 없음. 브라우저의 플러그인을 사용하던가

  혹은, `Java` 등의 프로그램을 통해 긁어와야함.

#### 1.2  HTTP ERROR

![](https://codeteddycom.files.wordpress.com/2017/06/statuscode.png?w=1109)

- **405** :  `POST` 방식으로 해야하는데 `GET` 방식으로 요청한 경우 발생.
- **404** : favicon없어서 나오는 오류



#### 1.3 GET, POST

- GET? 단순페이지요청, URL에 다 나오니까, 보안이 필요하는 방식에 쓰면 안됨.
- POST? 회원가입,로그인방식에 사용

- 도메인 `/` -? ROOTCONTEXT, `/` .... 



### 2. Front, Back - end

1. 이전 웹 방식의 한계 ? 전체 페이지 갱신방식이어서 응답이 올때 까지 기다리고, 전체 페이지가 다 바뀜. -> `Ajax` 사용, 비동기 요청, 부분 페이지 갱신방법으로 바뀜.




### 3. HTML

```html
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
    
  </body>
</html>
```

-  기본적으로 editor에서 `html`치면됨
- href : hypertext reference



#### 3.1 기본 태그

- `tag` + `내용` = ? `elemnet`

- `h1` 태그들은 block태그, 즉 `br` 을 쓰지 않아도 줄바꿈을 해줌
- `inline` 태그는 `br` 이 안들어간 태그를 의미함.

![](http://www.lukefabish.com/wp-content/uploads/2016/07/block-inline-html-tags.png)

- [MDN 참고](<https://developer.mozilla.org/ko/docs/Web/HTML/Inline_elements>)

- `ruby`

  ```html
  <ruby>
  	<span>大韓民國</span>
  	<rt>대한민국</rt>
  </ruby>
  ```

  - 大韓民國 상단부에, ''대한민국' 조그맣게 작성됨.

- `ol, ul`

  - ordered list, unordered list
  - 구성은 `li` tag로

- 테이블 태그

  - `table, tr,td`
  
  ```html
  <table border="1">    
        <tr>
          <td>a</td>
          <td>a</td>
          <td>a</td>
        </tr>
  
        <tr>
          <td>a</td>
          <td>a</td>
          <td>a</td>
          <td>a</td>
          <td>a</td>
          <td>a</td>
          <td>a</td>
       </tr>
        
       <tr>
        <td>a</td>
        <td>a</td>
        <td>a</td>
        <td>a</td>
     </tr>
  </table>
  <!--어떤것이 만들어질까?-->
  ```
  
  - `colspan` td태그들이 *가로로* 합쳐지게 하는것이고..
  - `rowspan` td태그들이 *세로로* 합쳐지게 하는것이고..



- `a _blank` , 새로운 페이지로 열림

```html
<a href="https://wwww.facebook.com" target="_blank">페이스북</a>
```



#### 3.2 폼 태그

- 각종 정보 입력시에 사용하고,

```html
    <form method="POST" action="login.jsp"><br>
        아이디 : <input type="text" name="userid" id="userid"><br>
        패스워드 : <input type="password" name="userpwd" id="userpwd"><br>


        url : <input type="url" name="url" id=""><br>
        email :  <input type="email" name="email" id=""><br>
        연락처 : <input type="tel" name="tel" id=""><br>


        <input type="submit" value="로그인">
        <input type="reset" value="취소"><br>
    </form>
```

- `url, email` 의 경우 브라우저에서 타당성 체크를 할 수 있게 그 기능이 있음.

```html
연락처 : <input type="tel" name="tel" id="" pattern="\d{3}-\d{4}-\d{4}" placeholder="000-0000-0000"><br>
```

- 정규표현식을 통해, 지정되는 숫자를 한정하고, `placeholder`를 통해 그 초안을 알려줄 수 있음.

```html
 아이디 : <input type="text" name="userid" id="userid" required><br>
 패스워드 : <input type="password" name="userpwd" id="userpwd" required><br>
```

- `required` 속성을 통해, 꼭 작성해야할 것들을 선정할 수 있음.

```html
number : <input type="number" name="" id="" max="100" min="0" step="5"><br>
```

- `max,min,sept` 을 통해서 작성될 숫자를 우리가 제어할 수 있게함.



#### 3.3 공간 분할 태그



