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

  2. or 직접 다운



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

```javascript
$("div.simple").css("color","red");
```

- 태그.class속성값



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



#### 1.3 기본 메서드

##### 1.31 each()

- Jquery에서는 `each()`이용하여 배열을 다룰 수 있음. (for느낌)
  - `addClass(), removeClass()`

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
    .high_light0 { background:Red; }
    .high_light1 { background:Orange; }
    .high_light2 { background:Yellow; }
    .high_light3 { background:Green; } 
    .high_light4 { background:Blue; }   
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $('h1').each(function(index,item){
                $(this).addClass("high_light"+(index)); //각각 클래스를 더해주는데..인덱스는 0부터 시작함               
            });
});
    </script>
    <title>Document</title>
</head>
<body>
    <h1>item0</h1><!--빨강-->
    <h1>item1</h1><!--주황-->
    <h1>item2</h1><!--노랑-->
    <h1>item3</h1><!--초록-->
    <h1>item4</h1><!--파랑-->
    <h1>item5</h1><!--클래스 추가되지 않음-->
</body>
</html>
```

- 페이지 소스보기 보다는, 개발자도구를 통해 보면 적용된 화면이 나옴.



##### 1.32 extend()

- 기존의 객체에 새로운 객체를 추가할 때



##### 1.33 noConflict()

- 충돌이 발생했을 때, 사용할 수 있는 방법.

- `$.noConflict()` // 더이상 $ 식별자를 사용할 수 없게 됨.



### 2. 객체 탐색

#### 2.1 filter()

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
    .high_light0 { background:Red; }
    .high_light1 { background:Orange; }
    .high_light2 { background:Yellow; }
    .high_light3 { background:Green; } 
    .high_light4 { background:Blue; }   
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $('h3').filter(function(index){
                return index%3==0;
            }).css({background:'black',color :'white'});
        
            $('input').filter(function(index){
                return this.type =='search';
            }).css('background-color','magenta');

        });

    </script>
    <title>Document</title>
</head>
<body>
    <h3>item0</h3>
    <h3>item1</h3>
    <h3>item2</h3>
    <h3>item3</h3>
    <h3>item4</h3>
    <h3>item5</h3>

    mail : <input type="email"><br>
    search : <input type="search"><br>
    password : <input type="password">
</body>
</html>
```



#### 2.2 end()

- Javascript method는 **체이닝** 방식으로 진행된다. 즉 단계별로 진행된다는 의미
- 그러면 서로 다른 css를 적용시키려면 매번 다시 쓰는 수밖에 없을까?
- No `end()`를 이용하자

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
    .high_light0 { background:Red; }
    .high_light1 { background:Orange; }
    .high_light2 { background:Yellow; }
    .high_light3 { background:Green; } 
    .high_light4 { background:Blue; }   
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $('h3').css('background','orange').filter(':even').css('color','green').end().filter(':odd').css('color','blue');

        });
          //filter(':even').css('color','green').end() 붙으면 이건 끝! 다만 css('background','orange') 는 그대로 있겠지
        
    
    
    </script>
    <title>Document</title>
</head>
<body>
    <h3>item0</h3>
    <h3>item1</h3>
    <h3>item2</h3>
    <h3>item3</h3>
    <h3>item4</h3>
    <h3>item5</h3>

</body>
</html>
```



#### 2.3 first(),end() = eq()

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
    .high_light0 { background:Red; }
    .high_light1 { background:Orange; }
    .high_light2 { background:Yellow; }
    .high_light3 { background:Green; } 
    .high_light4 { background:Blue; }   
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $('h3').first().css('color','cyan');
            $('h3').last().css('color','magenta');

            // $('h3').eq(0).css('color','green'); first()와 같음
            // $('h3').eq(-1).css('color','blue'); last() 와 같음


        });

    </script>
    <title>Document</title>
</head>
<body>
    <h3>item0</h3>
    <h3>item1</h3>
    <h3>item2</h3>
    <h3>item3</h3>
    <h3>item4</h3>
    <h3>item5</h3>

</body>
</html>
```



#### 2.4 add()

- 특정 태그를 추가할 때 사용

#### 2.5 is(expr) 

- 있는지 없는지(true, false로 리턴함)

#### 2.6 find(expr)

- `expr`  에 해당하는 모든 DOM element를 검색함.
  - `expr` 은 CSS Selector문법과, 기본적인 XPath 검색 표현식을 따른다.



```html

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
 div{  margin:10px;
       border:3px Solid Black;
       border-radius:10px;
       float:left;
       width:120px; height:120px;
       text-align:center;
        }
    </style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
        // 변수를 선언합니다.
        var xml = '';
        xml += '<friends>';
        xml += '    <friend>';
        xml += '        <name>연하진</name>';
        xml += '        <language>Ruby</language>';
        xml += '    </friend>';
        xml += '    <friend>';
        xml += '        <name>윤명월</name>';
        xml += '        <language>Basic</language>';
        xml += '    </friend>';
        xml += '    <friend>';
        xml += '        <name>윤하린</name>';
        xml += '        <language>C#</language>';
        xml += '    </friend>';
        xml += '</friends>';

        $(document).ready(function () {
            var xmlDoc = $.parseXML(xml);
           $(xmlDoc).find('friend').each(function(index){
            var output ='';
            output += '<div>';
            output += '     <h1>'+$(this).find('name').text()+'</h1>';
            output += '     <p>'+$(this).find('language').text()+'</p>';
            output += '</div>';
            document.body.innerHTML += output;
           });
           
        });
    </script>
</head>
<body>

</body>
</html>
```



### 3. 객체 조작

#### 3.1 attr(), removeAttr()

```html

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
 div{  margin:10px;
       border:3px Solid Black;
       border-radius:10px;
       float:left;
       width:120px; height:120px;
       text-align:center;
        }
    </style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script> 

        $(document).ready(function () {
            $('img').attr('width',function(index){
                return (index+1)*100; //0,1,2
            })
            //$('img').attr(
            //    {width : function(index){
            //    return (index+1)*100; //0,1,2
            //    }, heght: 100
            //});         
        });
    </script>
</head>
<body>
   <img src="Koala.jpg"> 
   <img src="Lighthouse.jpg">
   <img src="Tulips.jpg">
</body>
</html>
```

- 속성을 조절한다. 이미지 속성값



#### 3.2 css()

- $(selector).css(name, value);
   $(selector).css(name, function(index, style){ });
   $(selector).css(object);

```html

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script> 

        $(document).ready(function () {
            var color = ['blue','cyan','magenta'];
            $('h1').css({
                'color': function(index){
                    return color[index];
                },
                'backgroundColor' : 'black'
			//h1태그전체를 가져와서 css를 아래와 같이 바꿔준다. 객체 스타일 추가
            });
        });
    </script>
</head>
<body>
   <h1>Header0</h1>
   <h1>Header1</h1>
   <h1>Header2</h1>
</body>
</html>
```



#### 3.3 html(),text()

- $(selector).html(value);
  $(selector).text(value); 

- $(selector).html(function(index, html){ });
  $(selector).text(function(index, text){ });

  

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script> 

        $(document).ready(function () {
            var headers = $('h1').html();
            alert(headers); //Header0 하나만 가져오고

            var texts = $('h1').text();
            alert(texts); //Hearder0Hearder1Hearder2 //h1에 해당하는것을 다가져오는듯
        });
    </script>
</head>
<body>
   <h1>Header0</h1>
   <h1>Header1</h1>
   <h1>Header2</h1>
</body>
</html>
```



#### 3.4 remove()

- 한 개의 객체를 지움. 

```html

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script> 
 $(document).ready(function () {
       var headers = $('h1').html();
	   alert(headers);
     
	   $('div').text(function(index){
          return ("<h3>Header-"+index+"</h3>");
        });

        $('h3').last().remove(); //h3태그에 마지막을 지우고
        $('article').empty(); // article태그를 비우고

        $('<p></p>').html("This is <mark>web app</mark>").appendTo('body');//body 태그에  p태그로해당내용을 넣는다.
	
    });
    </script>
</head>
<body>
    
   <h1> Header-0 </h1>
   <h1> Header-1 </h1>
   <h1> Header-2 </h1>
   <div></div>
   <div></div>
   <div></div>

   <h3>제목1</h3>
  <h3>제목2</h3>
<article>
<p>단락1</p>
<p>단락2</p>
</article>
</body>
</html>
```



#### 3.5 append,prepend...

```html

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
div { border: 1px solid black;
      width : 300px;
      height : 300px;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script> 
 $(document).ready(function () {
     $('<p></p>').html('<mark>appendto</mark>').appendTo('div');
     $('<p></p>').html('<mark>prependto</mark>').prependTo('div');
     $('<p></p>').html('<mark>insertAfter</mark>').insertAfter('div');
     $('<p></p>').html('<mark>insertBefore</mark>').insertBefore('div');
    
    
     $('div').append(function(){
        return $('<p></p>').html('<mark>append</mark>');
     });
     $('div').prepend(function(){
        return $('<p></p>').html('<mark>prepend</mark>');
     });
     $('div').before(function(){
        return $('<p></p>').html('<mark>before</mark>');
     });
     $('div').after(function(){
        return $('<p></p>').html('<mark>after</mark>');
     });
    });
    </script>
</head>
<body>
 <h3>문서 객체를 추가<h3>
 A.appendTo(B) : B의 마지막 자식 요소로 A요소를 추가 <br>
 A.prependTo(B) : B의 첫번째 자식 요소로 A요소를 추가 <br>
 A.insertAfter(B) : B의 형제노드로서 A요소를 B의 다음에 추가<br>
 A.insertBefore(B) : B의 형제노드로서 A요소를 B의 앞에 추가<br>
 A.append(B) : A의 마지막 자식 요소로 B요소를 추가 <br>
 A.prepend(B) : A의 첫번째 자식 요소로 B요소를 추가 <br>
 A.after(B) : A의 형제노드로서 B요소를 A의 다음에 추가<br>
 A.before(B) : A의 형제노드로서 B요소를 A의 앞에 추가<br> 
 <div>내용</div>
   
    
</body>
</html>
```

- 결과 

![](JQuery.assets/append.png)

#### 3.6 clone()



### 3. 이벤트

#### 3.1 이벤트 시작

```html
<!DOCTYPE html>
<html>
<head>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            //h1클릭시에 별이 추가 됨.
            $('h1').click(function(){
                $(this).html(function(index, html){
                    return html + '★';
                });
            })
            //마지막 h1에 클릭을 시작함 동시에, 별이 1초마다 추가됨.
        	setInterval(function(){
                $('h1').last().trigger('click');
            },1000);
        });
    </script>
</head>
<body>
    <h1>Start: </h1>
    <h1>Start: </h1>
</body>
</html>
```



#### 3.2 이벤트 중단

- 이벤트제거, 전달을 막는 메서드
- `stopPropagation` 전달을 막는 메서드

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>javascript:event</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $('a').click(function(event){
        event.preventDefault(); //이벤트 제거
    });
    $('#f1').submit(function(event){
        event.preventDefault();
    });
	
});
</script>
</head>
<body>
<a href="http://www.multicampus.co.kr">www.multicampus.co.kr</a><br>
<form  id = "f1" method="get" action="data.jsp">
email : <input type=email name="email" id="email"><br>
<input type="submit">
</form>
</body>
</html>
```



#### 3.3 이벤트 한정

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>javascript:event</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
    //한정이벤트
$(document).ready(function(){
    $('#wrap').on('click','h1', function(){//h1태그에 이벤트가 한정됨
        var len = $('h1').length;
        var targetText = $(this).text();
        $('#wrap').append("<h1>"+len+"-"+targetText+"</h1>");
    })
});
 
</script>
</head>
<body>
 
    <div id="wrap">
        <h1>Header</h1>    
    </div>
</body>
</html>
```

- `on()` 이벤트에 연결

  `bind(), live(), delegate()`

- `off()`  이벤트 연결 제거

  `unbind(), die(), undelgate()`

#### 3.4 키보트 이벤트

##### 3.41 keyup

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>javascript:event</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(event){
    $('textarea').keyup(function(){
        //남은 글자의 수를 구하고
        var inputLength = $(this).val().length;
        var remain = 150 - inputLength;        

        //h1객체의 그 남은 내용을 입력하는데
        $('h1').html(remain);

        if(remain >= 0){
            $('h1').css('color','Yellow');
        }else{
            $('h1').css('color','black');
        }
    });
	 
});
 
</script>
</head>
<body>
<div>
        <p>지금 내 생각을</p>
        <h1>150</h1>
        <textarea cols="70" rows="5"></textarea>
    </div>
</body>
</html>
```

- keyup? 이벤트가 발생하면 글자 개수를 받아오는..



##### 3.42 scroll

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>javascript:event</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<script>

$(document).ready(function(){
    for(var i =0; i< 20; i++){
        $('<h1>처음 입력</h1>').appendTo('body');
    }
    
    //scroll 이벤트 발생시에
    $(window).scroll(function(){
        var scrollHeight = $(window).scrollTop()+$(window).height();
        var documentHeight = $(document).height();

        if(scrollHeight == documentHeight){
            for(var i = 0; i<10; i++){
                $('<h1>추가 입력</h1>').appendTo('body'); //끝에 도달 하자마자 10개 확보
            }
        }
    })
})

</script>
</head>
<body>

</body>
</html>
```

- 스크롤을 문서 끝가지 내리자 마자,'추가 입력' 부분이 10개 추가되면서 그만큼 스크롤이 위로 올라감.



### 4. 애니메이터

#### 4.1 animate()

```html
<!DOCTYPE html>
<html>
<head>
<style>
div{ width:50px;
     height:50px;
     background:orange;
     position:relative;
     }
</style>
<meta charset="utf-8">
<title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function () {
    $('div').hover(function(){
        $(this).animate({left:500},'slow');
    }, function(){
        $(this).animate({left:0},'slow');
    });
    
});
// $(document).ready(function () {
//     $('div').click(function(){ 클릭하면
//         var width = $(this).css('width');
//         var height = $(this).css('height');

//         $(this).animate({
//             width : parseInt(width)+50,
//             height : parseInt(height)+50

//         },'slow');
//     }); 
    
// });
</script>
</head>
<body>
<div></div>
<div></div>
<div></div>
<div></div>
<div></div>
<div></div>
</body>
</html>
```

#### 4.2 clearQueue();

- jquery메서드는 계속해서 누적된다. 큐에 누적되어 실행된다.

```html

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <style>
        div {
            width:100px; height:100px;
            background-color:Orange;
            position:relative;
        }
    </style>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {          
            $('button') .click(function(){
                var html = $(this).html();
                var evalText = "$('div')."+html;
                eval(evalText);
            })
            $('div').animate({
                left: '500'
            }, 5000).animate({
                left : '0'
            },5000);
            
        });
    </script>
</head>
<body>
    <button>stop()</button> 
    <!-- 멈추고 다시 돌아옴 첫번째 left는 멈추고, 두번쨰 left는 실행함 -->
    <button>stop(true)</button>
    <!-- 이대로 멈춤 -->
    <button>stop(false, true)</button>
    <!-- 끝까지 가서, que에 남아있는 내용이 있으니 그걸을 처리하려고 함 -->
    <button>stop(true, true)</button>
    <!-- 끝까지 가서, que도 비운다.  -->
    <div></div>
</body>
</html>
```

- `stop()`메서드

  stop(clearQueue, goToEnd);

  clearQueue는 `true` or `false` 

  goToEnd 또한  `true` or `false`  기본이 false라서, false는 처음부터시작

  `true` 이면 맨 마지막으로



#### 4.3 delay()

- 큐에 있는 메서드를 잠시 중지하는 것.
- 밀리초 단위,
- 입력하면 차근차근 오른쪽으로 이동하는 효과

```html

<!DOCTYPE html>
<html>
<head>
<style>
div{ width:50px;
     height:50px;
     background:orange;
     position:relative;
     }
</style>
<meta charset="utf-8">
<title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function () {
	$('div').each(function (index) {
         // (index * 500)초 후 animate() 메서드를 실행합니다.
         $(this).delay(index * 500).animate({
                     left: 500
              }, 'slow');
          });
});
</script>
</head>
<body>
<div></div>
<div></div>
<div></div>
<div></div>
<div></div>
<div></div>
</body>
</html>
```



=======
![](Javascript/JQuery.assets/제목 없음.png)
>>>>>>> 9ac3af1cd34349fa08f8adb1013d2bd860c28513
