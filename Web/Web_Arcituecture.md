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

- `div`



#### 3.4 ETC

- `caption` 표와 관련하여 사용하는..

- `cite`인용할 때 사용

- `data`태그를 이용한 value값 설정.

- `dialog` 특정 위치에 커서를 옮겼을 때 , 이미지 텍스트등이 나오는 이벤트를 사용하고자 할때 `javascript` 와 같이 씀.

- `embed` flash등 외부 영역이 들어간 영역은 `embed`로 묶어주면됨

- `iframe` 다른 페이지를 사용할때

  - 단 해당 사이트에서 거부할 수 있음.

- `main` main~article로 구성되어있음.

- `map` 영역을 지정하여, 클릭시 다른 이벤트가 일어나도록

  ```html
  <!DOCTYPE html>
  <html>
  <body>
  
  <img src="navi.jpg" alt ="navi" usemap="#navimap"/>
  
  <map name="navimap">
    <area shape="rect" coords="0,0,40,35" alt="mail" 
    href="https://mail.naver.com">
    <area shape="rect" coords="40,0,70,35" alt="cafe" 
    href="https://cafe.naver.com">
    <area shape="rect" coords="70,0,115,35" alt="blog" 
    href="https://section.blog.naver.com">
  </map>
  
  </body>
  </html>
  ```

  

- `mark` 문서에 노란색 형광색을 칠할 수 있도록...

- `meta`
  - `viewport` 왜? 각 유저마다 다른 디바이스를 가지고 있기 때문에, 그것에 맞게끔 설정해주는 것(반응형 콘텐츠)
    - [참고](<https://offbyone.tistory.com/110>)
  
- `svg` markup을 이용해서 그림을 지원하는데, 속성값만 잘해주면 브라우저에서 알아서 해줌. 나중에 **d3** 사용할 때 필요한 부분.



### 4. 연습문제

#### 4.1 강아지 소개

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style.css">
    <title>dog</title>
</head>
<body>
    <header>
        <h1>입양하기 </h1>
        <nav>
            <ul>
                <li>애완견 종류</li>
                <li>입양하기</li>
                <li>건강돌보기</li>
                <li>더불어살기</li>
            </ul>
        </nav>
    </header>

    <section>
            <img src="puppy.png" id="puppy" >

            <p>강아지 집 강아지가 편히 쉴 수 있는 포근한 집이 필요합니다. 강아지의 집은 강아지가 다 큰 후에도 계속 쓸 수 있는 집으로 구입하세요.집을 구입하실 때는 박음질이 잘 되어 있는지, 세탁이 간편한 제품인지 꼭 확인하시고 고르시는 것이 좋습니다. 강아지 먹이 강아지의 먹이는 꼭 어린 강아지용으로 나와있는 사료를 선택하세요. 강아지들은 사람에 비해 성장속도가 8배정도 빠르답니다. 따라서 강아지에게는 성장속도에 맞는 사료를 급여하셔야 합니다. 사람이 먹는 음식을 먹게 되면 양념과 향신료에 입맛이 익숙해지고, 비만이 될 가능성이 매우 높아집니다. 강아지용 사료는 생후 12개월까지 급여하셔야 합니다. 밥그릇, 물병 밥그릇은 쉽게 넘어지지 않도록 바닥이 넓은 것이 좋습니다.물병은 대롱이 달린 것으로 선택하세요. 밥그릇에 물을 주게 되면 입 주변에 털이 모두 젖기 때문에 비위생적이므로 대롱을 통해서 물을 먹을 수 있는 물병을 마련하시는 것이 좋습니다. 이름표, 목줄 강아지를 잃어버릴 염려가 있으니 산책할 무렵이 되면 이름표를 꼭 목에 걸어주도록 하세요. 그리고 방울이 달린 목걸이를 하고자 하실 때는 신중하셔야 합니다. 움직일 때마다 방울이 딸랑 거리면 신경이 예민한 강아지들에게는 좋지 않은 영향을 끼칠 수 있기 때문입니다.
            </p>


    </section>

    <footer style="color: aliceblue">
        copyright 작성


    </footer>

    
</body>
</html>
```

#### 4.2 가입정보 폼 만들기

- HTML

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="register.css">
    <title>Document</title>
</head>
<body>
    <div id="container">    
        <h1>가입정보</h1>
        <form action="login.jsp"id="reg_form" method="GET">
            <ul>
                <li>
                    <label for="uname">이름</label>
                    <input type="text" id="uname" placeholder="홍길동" autofocus>                
                </li>
                <li>
                    <label for="uemail">email</label>
                    <input type="email" id="uemail" placeholder="abcde@gmail.com">  
                </li>
                <li>
                    <label for="upwd">password</label>
                    <input type="password" id="upwd" required>  
                </li>         
 
                <li>
                    <label for="sex">성별</label>
                    <select id="sex">
                            <option value="man">남자</option>
                            <option value="woman">여자</option>
                    </select>
         
                </li>      

            </ul>

            <div class="centered"> 
                    <input type="submit" value="가입하기">
        
            </div>
        
        </form>
    </div>        
</body>
</html>
```

- CSS

```CSS
@charset "utf-8";

body{
    background: #666;
}
/* #? id지정자 */
#container{ 
    width: 450px;
    margin: 15px auto;
    padding: 10px;
    border: 1px solid #666;
    border-radius: 10px;
    background: white
}

form ul{
    list-style-type: none;
}
form ul li{
    line-height: 25px;
    margin-bottom: 10px;
}
label{
    width: 80px;
    float: left;
    text-align: right;
    padding-right: 5px;
    font-weight: bold;
}

/* .? class지정자 */
.centered{
    text-align: center;
}
```

