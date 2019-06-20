# Javascript_fundamental	

- [모던자바스크립트입문](<http://www.yes24.com/Product/goods/59410698>)



### 1. 개요

![](http://pyrasis.com/assets/images/GoForTheReallyImpatientUnit01/2.png)

1. 자바스크립트는 인터프리터 언어(컴파일언어--자바..보다는 느리다..)
   
- <u>컴파일러는 전체를 변환해서, 인터프리터 언어는 한줄씩 변환함.</u>
  
   - JIT컴파일러를 보통 내장하여, 많이 빨라졌다.
   - 자바스크립트와 파이썬 유사함.
   
   
   
2. 동적 프로토타입 기반 객체 지향 언어

   - 자바는 클래스 정의 하고, 객체를 만듬.

   - 자바스크립트는 프로토타입을 정의하고, 객체를 생성함.

     - 자바의 인터페이스랑 비슷한건가?
     
     

3. 동적타입 언어.

  - 변수 앞에 타입을 선언하지 않고, 저장되는 값에 따라서 변수의 타입이 그때그때 저장되고.

  

4. 함수가 객체임.

5. **클로저**

  - 이걸 이용하면, 로컬변수를 함수 밖에서도 쓸 수 있게 만들어줌.

### 2. 프로그램 작성,실행법

- 문장종료는 세미콜론 `;`
- 저장은 UTF-8로 할 것.
- 크롬에서 `CTRL + SHIFT + I` -> 개발자도구

- `javascript` 는 `html` 에서 `head` 태그내에 `script`  태그를 사용해서 할수 있고

  혹은 `body` 태그 내에도 사용가능하다.

  차이점?

  `head` 태그에서는 선언과 관련된 내용이 옴(전역변수, 함수)

  `body` 태그에서는 즉시실행 문장 코드가 오는데

  그렇지만 `html` 과 `javascript` 파일은 분리하는 것을 권장함.

- `Tomcat` 실행은? `bin` 폴더에서, `Webapp/ROOT` 폴더안에 넣어놔야 `localhost`에서 읽을 수 있음.



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script>
        var msg = document.getElementById("div1").innerHTML;
        window.alert(msg);
    </script>
    <title>Document</title>
</head>
<body>
    <div id="div1">
        body태그 내에 div태그 입니다.
    </div>
</body>
</html>
```

- 오류? 왜? `body` 객체 아래, `div` 에 해당하는 부분이 메모리에 올라가지 않았음. 그러면 

  `head` 태그내에서 찾을 때 못찾겠지?

  즉 메모리에 해당 html이 DOM으로 생성된 후에 찾을 수 있는 것.

  그렇지만 오류 발생안되었음. 왜? 브라우저의 발전때문이지 않을까.

- 유니코드로 작성해야함 UTF 8로.

- 대문자와 소문자 구별함.

### 3. 변수

- *처리해야할 값을 메모리에 저장하고 값을 참조하기 위해 사용하는 이름..*

#### 3.1 선언

- `var 변수명;` 

  이건 아직까지 메모리에 생성이 되지 않을 것. 그러면? `undefiend`라고 나옴

- `var 변수명 = 초기값;`

- 변수 선언을 생략하지 않은 값을 읽으려고 시도하면?

  `Uncaught ReferenceError: x is not defined at js4.html:15` 참조 오류 나옴.

- `var` 를 주지 않고 변수를 할당하면? 실행시에 전역객체로 생성되는 것이고 이러한 global object는 window객체의 속성이 추가됨.
- 호이스팅(hoisting) 나중에 실행된 선언자은 끌어올려서 먼저 실행되는 현상을 일컫는말.



#### 3.2 명명규칙

- 자바의 네이밍 규칙과 대부분 같음.
- _, $ , 영문자로 시작.
- 두번째 문자부터는 숫자도허용하고.. 길이제한 없음.
- 키워드 x 내장함수명 x 내장객체명x 왜? 충돌가능성때문에

#### 3.3 데이터 타입

- javascript는 정수와 실수를 구분하지 않음. 같은 타입 `number` 
- "",''둘다 타입은 `string` -- `char` 라는 타입은 자바스크립트에서 없음.
- [],{} 둘다 타입은 `object` ... 배열은 객체취급을 한다는 것!
- 타입출력은 소문자로 출력되는 점을 기억하자
- html javascript에서 세미콜론이 필수는 아니다. 왜? 가독성을 위해서 쓰고 있고, 문법적으로 필수적인것은 아님.

```javascript
    var a = 1;
    document.write("a변수의 타입은? : "+typeof(a)+"<br>");
    var b = 0.5;
    document.write("b변수의 타입은? : "+typeof(b)+"<br>");        

    a ="javascript";
    document.write("a변수의 타입은? : "+typeof(a)+"<br>");
    b= 'ECMAScript6';
    document.write("b변수의 타입은? : "+typeof(b)+"<br>");  
    
    a = function(){};
    document.write("a변수의 타입은? : "+typeof(a)+"<br>");
    
    a=[];
    document.write("a변수의 타입은? : "+typeof(a)+"<br>");
    b={};
    document.write("b변수의 타입은? : "+typeof(b)+"<br>");        

    a= new Object();
    document.write("a변수의 타입은? : "+typeof(a)+"<br>");
    b= true;
    document.write("b변수의 타입은? : "+typeof(b)+"<br>");  


/*a변수의 타입은? : number
b변수의 타입은? : number
a변수의 타입은? : string
b변수의 타입은? : string
a변수의 타입은? : function
a변수의 타입은? : object
b변수의 타입은? : object
a변수의 타입은? : object
b변수의 타입은? : boolean*/
```

1. **prmitive 타입**

   = 원시타입이라 부르고

   number, string, boolean, undefined|null

   undefined? 변수는 선언되었는데 값은 할당되지 않을 때 출력되는 값.

2. **object 타입**

   = 객체 타입이라 부르고

   function, object, interface.... Array(배열)

   

3. **숫자 리터럴**

![](https://slidesplayer.org/slide/15012325/91/images/15/%EB%A6%AC%ED%84%B0%EB%9F%B4%EA%B3%BC+%EC%A0%95%EC%88%98+%EB%A6%AC%ED%84%B0%EB%9F%B4+%EB%A6%AC%ED%84%B0%EB%9F%B4%28literal%29+%EC%A0%95%EC%88%98+%EB%A6%AC%ED%84%B0%EB%9F%B4+%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%A8%EC%97%90%EC%84%9C+%EC%A7%81%EC%A0%91+%ED%91%9C%ED%98%84%ED%95%9C+%EA%B0%92.jpg)

```javascript
    a=0x2a;
    document.write("0x2a의 10진수값은? "+a+"<br>");
    a=0o73;
    document.write("0o73의 10진수값은? "+a+"<br>");
    a=0b101;
    document.write("0b101의 10진수값은? "+a+"<br>");
    a=1.161425e-11;
    document.write("1.161425e-11의 10진수값은? "+a+"<br>");

/*
0x2a의 10진수값은? 42
0o73의 10진수값은? 59
0b101의 10진수값은? 5
1.161425e-11의 10진수값은? 1.161425e-11
*/
```

4. **이스케이프 시퀀스 목록**

![](https://image.slidesharecdn.com/9javascriptobjects-140716153203-phpapp02/95/javascript-objects-21-638.jpg?cb=1405525604)

5. **논리값**

   `x ==2` true or false

6. **특수한 값**

- `undefined` 

```javascript
var c=[];
document.write(c[0]+"<br>");
a = function(){};
document.write(a()+"<br>");
   a = function(d){
        alert(d);
    };
document.write(a()+"<br>");
```



빈배열에서, 요소를 읽으려고 시도하면? undefined

아무것도 반환하지 않는 함수가 반환하는 값은? undefined

함수를 호출했을 때 d라는 변수에 아무것도 정의되어있지 않을때?  undefined

선언되지 않은 변수를 참조하면 반환디는 값? ReferenceError



- `null`

아무것도 없음을 전달하기 위한 값.무언가를 검색했지만 찾지 못했을 때, 아무것도 없음을 전달하기 위한 값으로 사용함.



- ECMAScript 6 부터 추가된..
  - 심벌? 

    원시값, 자기 자신을 제외한 그 어떤 값과는 다른 유일 무이한 값!

  - 템플릿 리터럴.

    보간 표현식.. 

### 4. 객체

#### 4.1 객체 기초

- 객체는 이름하고 데이터를 한쌍으로 여러개 묶은 것은 복합데이터(연관배열,딕셔너리) 의미함.
  - 딕셔너리? 파이썬에서도 찾아볼 수 있구여
- 객체 리터럴? json 하나의 객체만 생성해서 사용하는 경우,
- 생성자 함수정의는 new키워드를 사용하고, 필요할때마다 생성자함수로부터 객체를 생성해서 사용함.

```javascript
var employee ={}; // 빈 객체 생성, var employee = new Object();
employee.ename = 'Scott';
employee.job = 'Developer';
employee.salary = 5000;
employee.hiredate = '2013/01/01';
employee.address = '삼성동';

document.write("employee.ename= "+employee.ename+"<br>");
document.write("employee['job']= "+employee['job']+"<br>");
document.write("<br>");

for(var key in employee){//key 변수에, 해당하는 객체의 프로퍼티는 무엇인가?
    document.write(key+" : "+ employee[key]+"<br>");
    }
document.write("employee instanceof Object => "+(employee instanceof Object)+"<br>");//내장 객체, Object상속을 확인하는 방법
    
```

```javascript
var student = {이름 : '홍길동', 영어: 88, 국어:90, 수학:77, 과학:75};

document.write(student.이름+"의 총점 : "+(student.영어+student.국어+student.수학+student.과학)+"<br>");

with(student){
    document.write(이름+"의 평균 : "+(영어+국어+수학+과학)/4+"<br>");
}
        
```



#### 4.2 함수

- 값이 없는 함수를 return 하면 undefined를 줌

- 함수 선언

```javascript
//func1(); 왜 안되지? 아직 변수가 메모리에 안올라가서
func2(); // 왜 됨? 호이스팅 때문에

var func1  = function(){ //변수에 저장된 함수 호출, 함수는 이름 없이 선언하고변수에 저장된것.
var jum = Number(window.prompt("1~100수 입력",0));
(jum%2==0)? alert("짝수") : alert("홀수");
        }
        
function func2(){ //선언전 함수..함수자체로 선언한것
    var jum = Number(window.prompt("1~100수 입력",0));
    (jum%2==0)? alert("짝수") : alert("홀수");
}
```



- 함수 인수
  - 함수의 정의된 매개변수 개수보다 많은 매개변수를 호출하면? *실행시에 무시됨*
  - 그러면 더 적은 매개변수를 호출하면? *오류 undefiend*

```javascript
   function hap(a,b){
        document.write("함수의 인수 개수 : "+arguments.length+"<br>");
        var sum = 0;
        for(var item in arguments){
            document.write(arguments[item]+"<br>");
            sum += arguments[item];
        }
        document.write("함수의 a,b : "+a+" "+b+ "<br>");
        return sum;
    }
    
    document.write("hap(3,5) => "+hap(3,5)+"<br>"); //선언된 매개변수에 맞게
    document.write("<br>");
    document.write("hap(1,3,5,7,9) => "+hap(1,3,5,7,9)+"<br>"); //더 많게
    document.write("<br>");
    document.write("hap(9) => "+hap(9)+"<br>");// 더 적게
    document.write("<br>");

    var nums = [2,4,6,8,10]; //배열을 선언하고
    document.write("hap(nums) => "+hap(nums)+"<br>"); //배열이 인수에 들어가면 ?


/*
함수의 인수 개수 : 2
3
5
함수의 a,b : 3 5
hap(3,5) => 8

함수의 인수 개수 : 5
1
3
5
7
9
함수의 a,b : 1 3
hap(1,3,5,7,9) => 25

함수의 인수 개수 : 1
9
함수의 a,b : 9 undefined
hap(9) => 9

함수의 인수 개수 : 1 //배열은 인수갯수 하나
2,4,6,8,10
함수의 a,b : 2,4,6,8,10 undefined
hap(nums) => 02,4,6,8,10 //undefined는 0으로 생각되나본데/.
*/
```

- 자바스크립트 배열에서는 모든 타입을 저장할 수 있음.
  - 자바와는 다름. 자바는 배열 타입을 선언하고, 그 타입에 맞는 요소만 저장할 수 있었으니까..
  - 자바스크립트 배열 안에, 배열을 또 저장할 수 있을까? 응 할수 있어



#### 4.3 Scope

```javascript
// function square(x){
//     return x*x;            
// }
function pythagoras(width, height){
    function square(x){
    return x*x;            
        }
    return Math.sqrt(square(width)+square(height));
}

document.write("밑변 3 높이 4인 삼각형의 빗변의 길이는 : "+ pythagoras(3,4)+"<br>");  
    
function square(width, height, hypotenuse){
   if(width*width+height*height ==hypotenuse*hypotenuse){
    	return true;
    }else{
    	return false;
    }
}
```

- 함수가 **오바라이드** 되더라도, 함수내부에 정의해놓은 함수를 먼저 참조하는 것을 알 수 있음.

#### 4.4 참조,값에 의한 호출

- 값호출? call by value. 
- 객체를 호출하면? call by reference. 객체의 주소값이 호출됨
  - 자바와 같은 방식으로.

#### 4.5 let, const

- `let`? 지역변수 선언자느낌. 해당 선언자의 블록범위가 한정되어있는 느낌.
- `const` 상수선언자 
  - 자바 `final` 선언자느낌.

#### 4.6 함수리터럴

- `function(x){.,...}`  함수 리터럴이라 함. 그리고 이름이 없으니까 익명함수 또는 무명함수라고 이야기하고.

#### 4.7 생성자

- 객체 생성할 것이 많다? 동일한 속성이다? 그럼 생성자를 만들자!

  ```javascript
  function Student (파라미터1, 파라미터2....){// 함수명 첫번째는 반드시 대문자로 시작해야함
      this.파라미터1 = 파라미터1;
      this.파라미터2 = 파라미터2;
  }
  ```

  `this` 값은 객체 내부의 데이터(프로퍼티 값) 상태를 바꾸거나 혹은 접근할때 사용함을 알 수 있지.

```javascript
    function Student(name, ko, math, en, sci ){
			this.name = name;
			this.ko= ko;
			this.math = math;
			this.en = en;
			this.sci = sci;
			this.total = function(){
					return  (this.ko+this.math+this.en+this.sci);
			},
			this.average = function(){
                    return this.total()/4+"<br>";
			}
	}



    var students = [ //students변수에 객체를 생성해서 담는데, 생성자를 이용하여
                 new Student('장기영', 87,  98,  88,  95),
                 new Student('이기한', 85,  90,  68,  73),
				 new Student('나태한', 80,  67,  82,  91),
				 new Student('김리민', 99,  94,  89,  90),
                 ];
    
    for(var idx in students){
        document.write(students[idx].name+"의 총점은 =>"+students[idx].total()+", 평균은 => "+students[idx].average()) // 함수를호출할때는 항상 ()를 잊지말거라
    
```

- 생성자 함수는 자동으로 **프로토타입** 객체가 자동으로 생성되고, 프로토타입 속성객체는 생성자함수 가지고 있는 객체들의 기능을 추가해놓음. 

  전역 메서드 느낌. 왜? 어차피 같은 속성, 기능을 가지고 있을 꺼니까 메모리 낭비를 줄이기 위해서.

- [프로토타입에 대한 이해를 위해 ]([https://medium.com/@bluesh55/javascript-prototype-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-f8e67c286b67](https://medium.com/@bluesh55/javascript-prototype-이해하기-f8e67c286b67))

  - 자바의 클래스개념과 비슷. 이 클래스를 통해 생성되는 객체는 해당 클래스에 있는 값을 언제든지 갖다쓸수 있게 함.
  - 왜? 
  - 아마도 각 객체마다 같은 코드 작성반복을 하지 않게 하기 위해서.. 즉 메모리 낭비를 줄여주기 위해서?
  - `__proto__` 프로토타입 체인.상위 프로토타입과 연결되게 해주는 속성.

- 

#### 4.8 내장 객체

- `console.dir(객체명)` 

- javascript 내장객체..검색해서 보면 됨.

  1. Date 생성자

  2. Function 생서자

  3. 기타 내장객체

  4. 전역객체

     ![](https://poiemaweb.com/img/objects.png)

#### 4.9 배열

- 배열을 *리터럴*로 생성을 어떻게 할까?

  `var evens = [2,4,6,8];` evens라는 변수에 배열이 리터럴(그냥선언한대로) 들어갔음

- 배열의 요소에는 모든 타입이 올수있음을 잊지말자

```javascript
var array1 = new Array(); // 빈배열[]
var array2 = new Array(10);// [10] 배열 길이 1나오고
var array3 = new Array(10,20,30,40,50); //[10,20,30,40,50] 배열 길이 5나오고

document.write("array1 =>"+array1.length+"<br>");
document.write("array2 =>"+array2.length+"<br>");
document.write("array3 =>"+array3.length+"<br>");

/*
array1 =>0
array2 =>10
array3 =>5
*/

array3[5] = 60; //5번째 칸에 60추가하고
array3.push(70); //뒤에 70을 넣음

for(var idx in array3){
    document.write("array["+idx+"] => "+ array3[idx]+"<br>");
	}

/*
array[0] => 10
array[1] => 20
array[2] => 30
array[3] => 40
array[4] => 50
array[5] => 60
array[6] => 70
*/

```



### 5. 표현식,연산자

#### 5.1 산술,논리,관계연산자

- 틸트 연산자

  [참고](<https://webclub.tistory.com/21)

- 정수끼리 나눴을 때 자바에서는 정수, 자바스크립트에서는 부동소수점이 될 수 있음!

  `7 /2  //3.5`

- `0/0 ?` NaN

- `"one" * 1` NaN, 문자열에 * 연산이 안되는구나

- `1+null?` 1

  db에서는 `1+null` 은 `null`

- `1+ undefined` NaN

- `==` 연산자

  *값만 비교함*

- `===` 연산자

  *값과, 타입도 같이 비교함*

```javascript
document.write("null == undefined =>"+(null == undefined)+"<br>"); document.write("1 == '1' =>"+(1 == '1')+"<br>");
document.write("255 == '0xff' =>"+(255 == '0xff')+"<br>");
document.write("true == 1 =>"+(true == 1)+"<br>");
document.write("true == '1' =>"+(true == '1')+"<br>");
document.write("new String('a') == 'a' =>"+(new String('a') == 'a')+"<br>");

document.write("<br>")

document.write("null === undefined =>"+(null === undefined)+"<br>");
document.write("1 === '1' =>"+(1 === '1')+"<br>");
document.write("255 === '0xff' =>"+(255 === '0xff')+"<br>");
document.write("true === 1 =>"+(true === 1)+"<br>");
document.write("true ==='1' =>"+(true === '1')+"<br>");
document.write("new String('a') === 'a' =>"+(new String('a') === 'a')+"<br>");

/*
null == undefined =>true
1 == '1' =>true
255 == '0xff' =>true
true == 1 =>true
true == '1' =>true
new String('a') == 'a' =>true

null === undefined =>false
1 === '1' =>false
255 === '0xff' =>false
true === 1 =>false
true ==='1' =>false
new String('a') === 'a' =>false */
```



#### 5.2 문자열 관련 연산자



```javascript
document.write("랜덤주사위 값음? "+ Math.round((Math.random()*5)+1)+"<br>");
document.write("1+ {} :" +(1 + {})+"<br>")
document.write("true+ (new Date()) :" +(true + (new Date()))+"<br>")

var msgObj = new String("Everything is practice");
document.write("msgObj.length: " +msgObj.length+"<br>");
document.write("msgObj.charAt(3): " +msgObj.charAt(3)+"<br>");
document.write("msgObj[3]: " +msgObj[3]+"<br>");
document.write("msgObj.subString(3,7): " +msgObj.substring(3,7)+"<br>");
document.write("msgObj.slice(-3): " +msgObj.slice(-3)+"<br>");
document.write("msgObj.slice(-9,-6): " +msgObj.slice(-9,-6)+"<br>");
document.write("msgObj.indexOf('t'): " +msgObj.indexOf('t')+"<br>");
document.write("msgObj.indexOf('i',10): " +msgObj.indexOf('i',10)+"<br>");
document.write("msgObj.split(' '): " +msgObj.split(' ')+"<br>");
document.write("msgObj.replace('p','P'): " +msgObj.replace('p','P')+"<br>");
document.write("msgObj.includes('thing'): " +msgObj.includes('thing')+"<br>");
document.write("msgObj.charCodeAt(0): " +msgObj.charCodeAt(0)+"<br>");
document.write("msgObj.codePointAt(0): " +msgObj.codePointAt(0)+"<br>");
    
/*
msgObj.length: 22
msgObj.charAt(3): r
msgObj[3]: r
msgObj.subString(3,7): ryth
msgObj.slice(-3): ice
msgObj.slice(-9,-6): pr
msgObj.indexOf('t'): 5
msgObj.indexOf('i',10): 11
msgObj.split(' '): Everything,is,practice
msgObj.replace('p','P'): Everything is Practice
msgObj.includes('thing'): true
msgObj.charCodeAt(0): 69
msgObj.codePointAt(0): 69

*/
```

#### 5.3 기타 연산자

- `eval()`

  함수임. 단 하나만을 인수로 받아서 자바스크립트 코드로 해석해서 기준에 맞다면 실행함.

  다만 쓰는 것을 조힘. 왜? 악의적으로 입력한 문자열을 실행해버리면 보안상 문제가 발생할 수 있으니까.



#### 5.4 명시적 타입 변환

- **숫자를 문자열로**

  - 숫자 + 문자열 ? 문자타입으로 바뀜

    10+ "cook" // "10cook" 

    `window.parseInt("123a") // 123 a는 빼고`

    `window.parseFloat("0.123b") // 0.123`

    `Number("a123")` //NaN 문자를 앞에 쓰면 인식을 잘 못함.

  - `Number` 객체의 메서드..

    - `toString, toFixed..etc`

    

- **문자를 숫자열로**
  - `parseInt, parseFloat` 사용
  - `Number(null)` // 0 
  - `Number(undefined)`// NaN
- **논리값으로** 
  
  - `!!` or `Boolean` 을 사용

### 6. 웹브라우저

- 사용자의 문자를 입력받으려면?

  `window.prompt("메세지",기본값)`를 이용

  문자타입으로 반환하고

- Boolean값을 입력받으려면?

  `window.confirm`을 이용함.

### 7. 제어구문

- 대부분 자바형식과 비슷하지만,

  ```javascript
  for(var i = 0; i < n; i++){...}
  ```

  - 변수를 `var` 써주는 것이 다름.

- 템플릿 리터럴

```javascript
    for(var su = 1; su <10; su++){
        for(var dan = 2; dan <10; dan++){
            document.write(`${dan}X${su}= ${dan*su}\t`);
            }
        
        document.write("<br>");
    }
        
```

### 13. 웹브라우저의 객체

- `DOM` 

- 488페이지 ... 웹페이지를 읽어들이는 순서.
- `window 객체` 
  - `window.onload`
  - `window.open, window.close` 



#### 13.3 Document 객체

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script>
        window.onload = function(){
            var h1 = document.createElement("h1");
            var text1 = document.createTextNode("새 요소 추가");
            h1.appendChild(text1);
            document.body.appendChild(h1);

            var img1 = document.createElement("img");
            img1.src = "dog.jpg";
            img1.height= 300;
            img1.width = 300;
            document.body.appendChild(img1);

            var img2 = document.createElement("img");
            img2.setAttribute('src','cat.jpg');
            img2.setAttribute('width',300);
            img2.setAttribute('height',300);
            console.log(img2.getAttribute('src'));
            document.body.appendChild(img2);

        }
        
    </script>
    <title>js15.html</title>
</head>
<body>
    <h3>document객체를 이용한 문서 구조 변경하는방법!</h3>


    
</body>
</html>
```

