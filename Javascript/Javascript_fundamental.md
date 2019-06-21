# Javascript_fundamental	

- [모던자바스크립트입문](<http://www.yes24.com/Product/goods/59410698>)
  - 책 좋음. 고급 예제도 있음.



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

  1. **함수 선언문으로 정의**

     `function square(x) { return x*x;}`//square(5)

  2. **함수 리터럴(익명 함수)로 정의**

     `var square = function(x) {return x*x;}`//square(5)

  3. **Fuction 생성자로 정의**

     `var square = new Function ("x","return x*x");`// square(5)

  4. **함수 표현식(람다식)으로 정의**

     `var square = x => x*x` 호출??? `square(5)` 

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

- `function(x){.,...}`  함수 리터럴이라 함. 그리고 이름이 없으니까 *익명함수* 또는 *무명함수*라고 이야기하고.

#### 4.7 생성자

- 객체 생성할 것이 많다? 동일한 속성이다? 그럼 생성자를 만들자!

  ```javascript
  function Student (name, age....){// 함수명 첫번째는 반드시 대문자로 시작해야함
      this._name = name;
      this._age = age; //접근 못함 왜? private속성을 가지고 있어서
      return{//객체를 리턴한다.
          getName : function() {return _name;},
        getAge : function() {return _age;}.
          setAge : function(n) {_age = n;}
      }; //get,set메서드를 설정해줌으로, 해당 객체의 이름,나이 그리고 나이를 설정할 수 있게해줌.
  }
  
  var p = New Student("kim", 30);; //p변수에 새로운 객체 생성
  console.log(p._name); //오류 접근못함
  console.log(p._age);//오류 접근못함
  console.log(p.getName())//,,
  ```
  
  `this` 값은 객체 내부의 데이터(프로퍼티 값) 상태를 바꾸거나 혹은 접근할때 사용함을 알 수 있지.
  
  - 함수가 호출되어 실행되는 시험에서 `this`값이 결정됨.

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

#### 4.10 클로저



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

#### 6.2 console

- `console.log`

- `console.dir`

- `console.time`

  

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

### 8. 함수

#### 8.1 함수 기초

- [참고](<https://beomy.tistory.com/9>)

#### 8.2 재귀 함수

```javascript
function factorial(n){
    if(n<=1)
        return 1; //base case
    else
        return n*factorial(n-1); //recursion case
}
```

- 반드시 멈춰야함.

  

#### 8.3 클로저

- 은닉과 관련된 내용.



#### 8.4 객체로서의 함수

- 함수적 프로그래밍 특성
  - **콜백함수?** 인수로 전달되는 함수를 일컫는 말.
  - 변수에 함수를 저장할 수 있고
  - 배열의 요소로 함수를 저장할 수 있고
  - 함수 내부에 함수 정의 가능하고
  - **고차함수?** 내부에 함수를 정의하거나, 함수를 반환하는 함수를 고차함수라 함

- 자바스크립트 객체분류

  - 내장 객체 - `object, String, Boolean, Number, Array(중요) , Date, Regexp...`

  - 브라우저 객체 - `Window`

    - `window method` ? close(), open(url, name, option...), moveBy, moveTo, alert(), confirm(),prompt(), setTimeout(function(){}, time(milisecond), clearTimeout(id)), setInterval(function(){}, time), clearInterval(id)

      - Window 객체의 속성. document 는 HTML요소관련 처리하는 객체

        getElementById(), getElementsByName(), getElementsByTagName(), getElementsByClassName(), querySelector("css의 select형식"), querySelectorAll()

        createElement(), createComment(), **createDocumentFragement()**

        createAttribute(), createTextNode()

        setAttribute(), getAttribute(), removeAttribute()

        parentNode(), childNode, **body**(dot을 통해 내려갈수 있음),appendChile()

  - ECMAScript 객체



#### 8.11 이터레이션

- 데이터들의 집합을 반복적으로 처리할 때, `이터레이션` 한다고 함.
- `이터레이터` ? 반복 처리 가능한 객체를 일컫는말.
- 모든 자바스크립트에서는 `Symbol.iterator()`가 있음.
- `iter` 는 `next` 로 호출할때 마다 ,이터레이터 리절트(iterator result) 라는 객체로 리턴됨.



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <script>
    function makeIterator(array){
        var index = 0;
        return {
            next: function(){//next 프로퍼티를 가지게 해줌.
                if(index < array.length){
                    return {value: array[index++], done: false};
                }else{
                    return {value: undefined, done: true};
                }
            }
        };
    }
    
    var iter= makeIterator(["A","B","C"])
    
    
    </script>
</body>
</html>
```

- `for(var i of a)` for~of문을 통해서 , iterator하게 할 수 있음.

#### 8.12 제너레이터

- 이터레이터 처럼 반복처리를 지원하고
  - 그 와중에 중간에 일시정지, 재 시작을 할 수 있음.
  - 이터레이터 보다 더 유연하게 표현할 수 있음.
- 제너레이터는 자동으로 `next`프로퍼티를 가짐.
- `yield` = `return` 과 비슷
- `yield*` 배열이나 여러개 인자를 반환하려고 할때 

### 11. 버그, 예외처리

#### 11.1 버그에 대처하기

- Strict

  ```javascript
  "use strict...
  ```

- 스타일 가이드

  버그를 피하면서 가독성을 높히기 위해서 권장하는 규칙을 의미함.

  [Airbnb style guide](https://github.com/airbnb/javascript)

- 단위 테스트, 통합테스트, 시스템 테스트, 운용 테스트



#### 11.2 예외처리

- `throw 표현식` 표현식에는 어떠한 값이라도 가능함.

- **타입의 판정**

  인수가 원시값(number...object..function)인지 함수 타입이 판별할때는? `typeof`

  `instanceof`

  [참고](https://unikys.tistory.com/260)



#### 11.3 try/catch/finally 문

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <script>
    
    
    function permutation(a){
        if( !(a instanceof Array)){
            throw new Error(a+" is not an array");
        }
        return a;
    }
    //permutation("ABC");
    
    var a = ['a','b','c'];
    try {
        var p = permutation(a);
        //var p = permutation("ABC"); 오류.. ARRAY가 아니다
        p.forEach(element => {
            console.log(element);
        });
    } catch (error) {
        alert(error);
    }
    
    
    
    </script>
</body>
</html>
```

- `javascript`에서는 `catch` 문을 많이 쓰지 않는다. 

  ```javascript
  try{
      
  }catch{
      if( e instanceof TypeError){
          
      }else if(...){
          
      }else{
          
      }
  }
  ```

  - `catch`문 아래, if문을 넣어서 해결함.



- 예외의 전파

  예외는 호출 스택을 거슬러 올라가며 전파됩니다.

- **콜백함수?** 다른 함수의 인수로전달되는 함수가 콜백함수

### 13. 웹브라우저의 객체

- `DOM` 

- 488페이지 웹페이지를 읽어들이는 순서.
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



#### 13.2 Location 객체

- 브라우저 창에 표시되는 문서의 url을 관리

- `assign(url)`

- `replace(url)`

  문서를 읽어 들일 때, 이력을 남기지 않으려면 replace 메서드를 사용함.

#### 13.3 History 객체

- 웹 페이지 방문 했었던 열람 이력을 관리.![](https://images.slideplayer.com/26/8778432/slides/slide_25.jpg)

#### 13.4 Navigator 객체

- 브라우저, 기기가 무엇인지.
  - 즉 반응형 웹콘텐츠같이 처리해줄 수 있는 객체임.

#### 13.5 Screen 객체

- 모니터 정보 확인
- `console.dir(screen)` 으로 확인 가능

### 14. DOM

- Document Object Model의 줄임말
- 노드? DOM트리를 구성하는 객체 하나를 일컫는 말.

![](https://parrot-tutorial.com/images/html_dom_tree.png)

- 공백 노드도 있음.

- **노드의 주요 객체**

![](http://www.ktword.co.kr/img_data/2506_2.JPG)

#### 14.1 노드 객체 가져오기

- id, tagname,class속성..
- `getElements` 일때는 집합객체로 가져오니까 하나씩 출력하려면? `for` 문을 돌려야겠네

```javascript
document.getElementByid("id값");
document.getElementsByTagName();
document.getElementsByClassName();
```

- CSS 선택자를 통해, 

```JAVASCRIPT
document.querySelector("선택자"); //p.subtitle > span 
document.querySelectorAll();
```



#### 14.4 HTML 요소 내용 읽고 쓰기

1. `InnerHTML`

   코드를 문자열로 다뤄야함. 즉 복잡한 구조를 가진 코드를 편집할떄는 어려움.

   ```html
   <p id ="cards"> &hearts;하트는 <em>승려</em> 라는 뜻입니다.</p>
   
   var para = document.getElementId("cards");
   para.innerHTML = "&diams;다이아는 <strong>상인</strong>이라는 뜻입니다."
   console.log(para.innerHTML);
   //&amp;diams;다이아는 &lt;string&gt;상인&lt;/strong&gt;이라는 뜻입니다.
   ```

   

2. `textContent`

   텍스트를 대입하면 &,<,>등의 HTML특수문자가 변환되어 표시될 수 있는 문자열로 바뀜

   ```html
   console.log(para.textContent);
   //diams;다이아는 <strong>상인</strong>이라는 뜻입니다.
   ```

   두개 차이?
   `InnerHTML` 로 가져오면 태그 포함 가져오고,

- `textContent`로 가져오면  해당하는 텍스트만 가져옴



#### 14.6 HTML요소 위치

문서의 위치를 표현할때 두개의 좌표계가 있음

1. 뷰 포트 좌표계(윈도우 좌표계) **웹브라우저에서 문서의 내용이 표시되는 영역**

   ![](https://developer.tizen.org/sites/default/files/users/user-1451/raph_0030.png)

   문서의 요소 객체는 박스모델이 적용되며, 뷰포트 원점은 왼쪽 상단 (0,0)

   ​	왼쪽 x좌표는 `left속성` 

   ​	왼쪽 y좌표는 `top속성`

   ​	오른쪽 아래 x좌표는 `right 속성`

   ​	오른쪽 아래 y좌표는 `bottom 속성`

   ​	너비는 `width` 

   ​	높이는 `height`

   뷰포트의 너비 속성은? `clientWidth, innerWidth` (스크롤 막대 포함)

   뷰포트의 높이 속성은?` clientHeght, innerHeight` (스크롤 막대 포함)?

2. 문서 좌표계

- [참고](<https://mommoo.tistory.com/85>)

#### 14.7 HTML form

- form
  - 유사 배열 객체임
  - Method_POST,GET, Action...
- 프로퍼티 접근은??
  - ` document.forms[0]`인덱스..
  - `document.forms.form1 ` id속성
  - `document forms.questions` name속성

### 15. 이벤트

#### 15.1 이벤트 처리기 등록

1. `이벤트소스객체.on이벤트 = function(){}` //  이벤트 핸들러 함수.. 그러나 특정요소 이벤트에 대해서는 단 하나만 등록할 수 있는 단점이 있음.

2. `이벤트소스객체.addEventListener(type, listener, userCapture)` 

   type? "click", "mouseup.."

   listener? 이벤트 발생했을 때 처리를 담당하는 콜백함수!

   userCapture? 이벤트 단계 true(캡처링:부모->자식), **false(버블링:자식->부모) = 기본값!**

   장점 : 같은 요소의 같은 이벤트에 이벤트 리스너를 여러개 사용할 수 있음. 

   ​			버블링 캡처링에도 사용가능.

   삭제는..? `이벤트소스객체.removeEventListener(type, listener, userCapture)`

#### 15.2 이벤트 객체

- 공통 프로퍼티, 마우스 이벤트 객체
- [참고](https://webclub.tistory.com/490)

#### 15.3 이벤트 전파

- 브라우저는 버블링만 지원이 되고, 캡처링이 되지 않음.

1. **이벤트 캡처링**

   **부모 -> 자식**으로 이벤트가 전파되는것. 예를 들면 한번클릭하면 자식것 까지 모두실행됨

2. **이벤트 버블링**

   **자식 -> 부모**로 전파되는 것.

- **전파를 취소하러면?**

1. `stopPropagation` W3 표준.. IE에서는 다른 것을 사용해야함.

   `stopImmediatePropagation` 일시적으로 전파를 멈추는 메서드..



```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>이벤트</title>
<style>
div, h1, p { border:2px solid black;
             padding : 10px;
             margin : 10px; }
</style>
<script>
 window.addEventListener("load", function(){
	document.getElementById("outerDiv").onclick= function(){
		this.style.backgroundColor='gray';
	}
	document.getElementById("innerDiv").onclick= function(){
		this.style.backgroundColor='cyan';
	}
	document.getElementById("header1").onclick= function(evt){
        var event = evt;
        if(event.stopPropagation){
            event.stopPropagation();
        }

		this.style.backgroundColor='magenta';
	}
	document.getElementById("p1").onclick= function(evt){		 
        var event = evt;

        if(event.stopPropagation){
            event.stopPropagation();
        }
        this.style.backgroundColor='orange';
        
	}
}, false);
</script>
</head>
<body>
 <h3> 자바스크립트 버블링과 캡처링 </h3>
자바스크립트 버블링 : html문서내에서 자식 태그객체에서 발생된 이벤트가 부모 태그 객체로 이벤트 전파되는 것 <br>
자바스크립트 캡처링 : html문서내에서 부모 태그객체에서 발생된 이벤트가 자식 태그 객체로 이벤트 전파되는 것 <br>
<div id="outerDiv">
  <div id="innerDiv">
    <h1 id="header1">
       <p id="p1">이벤트 전파</p>
    </h1>
  </div>
</div>
</body>
</html>
```

```javascript
	document.getElementById("p1").onclick= function(evt){	
		var event = evt || window.event; //var event = evt가 null이 아니면 할당되고 null이면 false니까, window.event가 실행됨.
		if(event.stopPropagation){
			event.stopPropagation();
		}else{
			event.cancelBubble=true;
		}		
		this.style.backgroundColor='orange';
	}
}, false);
```

- 이벤트 실행을 취소하려면?
  1. `return false`  //아예 이동을 안하는 거고.
  2. `preventDafult();` 를 이용함

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>이벤트</title>
<script>
window.addEventListener("load", function(){
    var anchor = document.getElementById("link1");
    anchor.onclick = function(e){
        //return false;
        if( !confirm("페이지를 이동하시겠습니까?")) e.preventDefault();
        
    }

    var search = document.getElementById("searchForm");
    search.onsubmit = function(e){
        //return false;
        if( !confirm("검색 결과로 이동하겠습니까?")) e.preventDefault();
    }
 
}, false);
</script>
</head>
<body>
 <h3> 브라우저에 정의된 기본 이벤트 취소 </h3>
 브라우저에서 자동으로 처리해주는 기본 이벤트 핸들러를 취소하려면 이벤트 핸들러 함수를  override해서 false를 리턴합니다.<br>
<a id="link1" href="http://www.google.com">구글</a><br>
<form id="searchForm" action="data.jsp" method="GET">
찾기 <input type="search">
<input type="submit" value="검색">
</form>
</body>
</html>
```

### 19.APT

#### 19.1 드래그 앤 드롭 

```HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
    var dropbox;
    window.addEventListener("load",function(){
        dropbox = document.getElementById("dropbox");

        dropbox.addEventListener("drop",drop,false);
        dropbox.addEventListener("dragenter",dragEnter,false);
        dropbox.addEventListener("dragover",dragOver,false);
    },false);

    function dragEnter(event){
        event.stopPropagation(); //이벤트가 상위로 전달되지 않도록 정지
        event.preventDefault(); // 현재 이벤트 기본동작을 정지
    }
    function dragOver(event){
        event.stopPropagation();
        event.preventDefault();
    }
    function drop(event){
        event.stopPropagation();
        event.preventDefault();

        var files =event.dataTransfer.files;
        var count = files.length;

        if(count > 0){
            var file = files[0];
            document.getElementById("droplabel").innerHTML = "Processing ...." + file.name;
            var reader = new FileReader();
            reader.onloadend = function(event){
                var img = document.getElementById("preview");
                img.src = this.result;
            };
            reader.readAsDataURL(file);
        }
    }

</script>	
</head>
<body>
<h1>Drag and Drop Demo</h1>
	<div id="dropbox"
		style="width: 360px; height: 80px; border: 1px solid #aaa;">
		<span id="droplabel"> 이곳에 파일을 드랍해 주세요... </span>
	</div>
	<img id="preview" alt="[ preview will display here ]" />
</body>
</html>
```

```html

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<title>Insert title here</title>
<style>
div#Red {border:2Px solid #F00;}
div#Blue {border:2Px solid #00F;}
div {width:400px;height:266px;}
a {margin:50px;display:block;}
</style>
<script>
function drag(source, event){
	//event.preventDefault();
	event.stopPropagation();
	event.dataTransfer.setData("text", source.id);
}

function drop(source, event){
	//event.preventDefault();
	event.stopPropagation();
	var imgId = event.dataTransfer.getData("text");
	console.log(event.dataTransfer.getData("text"));
	source.appendChild(document.getElementById(imgId));
}
</script>
</head>
<body>
<div id="Red" ondrop="drop(this, event);" 
     ondragenter="return false;" 
     ondragover="return false;"></div>
<div id="Blue" ondrop="drop(this, event);" 
	ondragenter="return false;" 
	ondragover="return false;"></div>
<img draggable="true" id="textlink" 
     ondragstart="drag(this, event);" 
     src="images/red_dragon1.jpeg"></img>
</body>
</html>
```





#### 19.2 Blob

- Blob? 원시데이터(raw data)를 나타내는 객체!  , `slice()`가 리턴하는 것이 **blob**

- **FileReader**

  동기,비동기 방식있음.

  **동기 방식은, 변수로 리턴을 받아야한다.**

  **비동기 방식은**. `result`  **를 통해 바로 알아볼 수 있음**

  `var reader = new FileReader();` 파일 객체 생성

  - 오류

    ![](https://image.slidesharecdn.com/fileapi-140718000313-phpapp01/95/fileapi-10-638.jpg?cb=1405641815)



```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
//1. new FileReader()
//2. onload, onloadend이벤트에 대한 핸들러 : result속성에 저장낸 내용을 textarea에..
//3. readAsText()사용  내용 읽기
function readFile(){
    //file가져오기

    var file = document.getElementById("file").files[0];
    document.getElementById("fileName").innerHTML = file.name;
    document.getElementById("fileSize").innerHTML = file.size;

	//reader객체 생성
    var reader = new FileReader();
    reader.onloadend = function(){
        document.getElementById("content").innerHTML = reader.result;
    }
    //인코딩관련문제도 있을 수 있으니까..
    var encodinglist = document.getElementById("encoding");
    var encoding = 
    encodinglist.options[encodinglist.selectedIndex].value;
    reader.readAsText(file,encoding);//선택된 인코딩 방식으로 파일을 읽는다.
	
}
</script>
</head>
<body>
 <h1> FileReader Interface : readAsText()</h1>
       <input id="file" type="file">
       <select id="encoding">
           <option>UTF-8</option>
		   <option>euc-kr</option>
        </select>
        <button onclick="readFile()">읽기</button><br />
        <div>
            <span id="fileName">File Name</span>
            <span id="fileSize">File Size</span>
        </div>
        <textarea id="content" readonly style="width:600px; height:400px;"></textarea>
</body>
</html>
```



- **Canvas**