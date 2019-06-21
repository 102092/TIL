### 1. 기본

- *모든 브라우저*에서 동작하는 클라이언트 자바스크립트 **라이브러리**

- 무료임!

- JQuery 제작 목표?

  - DOM 관련된 처리 쉽게 구현..ex) getElementBy..
  - flash, acitvex 없어도 쉽게..
  - `Ajax` 어플리케이션을 쉽게 개발.
  - 아무튼 편하게 자바스크립트를 이용할 수 있게.

- 사용법

  1. CDN 호스트(Content Delevery Network) 에서 라이브러리를 전송받도록

     ```
     --Google CDN
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
     ```

  2. 직접 다운



#### 1.1 실행

- `JQuery(css selector) = $(), default`

  but $가 충돌일어날 수도 있으니까, 다른 것으로 바꿀 수 도 있음.

- `$(document).ready(매개변수)`

  문서준비 완료, 매개변수로 전달된 함수를 실행하라

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        jQuery(document).ready(function(){alert("ready event handler1")});
        
        $(document).ready(function(){alert("ready event handler2")});
		//2번째 방식을 많이씀.    
    </script>
    <title>Document</title>
</head>
<body>
    
</body>
</html>
```



#### 1.2 JQuery 기본 선택자

- `h3` 선택하여, css를 변경하는 태그. 
  - `javascript`에 비해서 훨씬 간결하다.

```javascript
var h3 = document.getElementsByTagName("h3")[0];
h3.style.color("blue");


///

$(document).ready(function(){
    $("h3").css("color","blue");
});
```



- **복수 태그 선택자**

```javascript
$("div, p ").css("color","red"); //div, p태그 선택
```



- **id 선택자**

```javascript
$("#simple").css("color","red"); //id="simple" 아이디 선택자
```



- **클래스 속성 선택자**

```javascript
$(".simple").css("color","red");
```



- **자식 , 후손 선택자**

```
$("body > p").css("color","red");
```

- body 태그 아래 바로 p 태그에만 적용시킬 때
- pre + next
- pre + silbing



- **속성 선택자**

1. 요소[속성=값..]형식

   **~=** 특정 값을 단어로써 포함

   **^=** 특정 값으로 시작

   **$=** 특정 값으로 끝나고

   ***=** 특정 값을 포함

```html
$("input[type='text']").val("Hello,jquery~");

text : <input type="text"><br>
password : <input type="password"><br>
email : <input type="email"><br>
search : <input type="search"><br>
```



2. 요소 : type 형식

```html
    $("input:password").css("backgroundColor","cyan");
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){

            setTimeout(function(){
                var value = $("select > option:selected").val();
                alert(value);
            },5000);
});

    </script>
    <title>Document</title>
</head>
<body>
    <select>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
    </select>
    
</body>
</html>
```

- `val()` 양식(form)의 값을 가져오거나 설정하는 **메소드**



- **필터 선택자**
  - `요소 : odd, even, first, last` 

