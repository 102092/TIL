# Java_fundamental

#### 정리목록

1. [Java의 정석](<http://www.yes24.com/Product/goods/24259565>) - 기본

2. [생활코딩_자바](<https://opentutorials.org/course/1223>) - 참고

3. [TCP자바](<http://tcpschool.com/java/intro>)

   - **반드시 내가 이해한바를 적는다.** 
   - **그냥 교재나 코드가 써있는 바를 적지 않는다.**



### 1. 시작

![](C:\Users\student\Downloads\687474703a2f2f77696b69646f63732e6e65742f696d616765732f706167652f3235372f6a646b2e6a7067.jpg)

- JVM 자바 가상 머신?

  - 자바바이트 코드를 실행시킬 수 있는 기계.
  - 서로 다른 운영체제에 맞춰서 실행시키기 위해 사용하는 것.

  ![](C:\Users\student\Downloads\img_java_jvm.png)

  -  Garbage collector가 있는 곳. 더 이상 사용하지 않는 메모리를 자동으로 회수해주는 역할

- JRE 자바 실행환경

  - JVM을 포함하고 있고
  - 자바를 동작시킬때 필요한 라이브러리,기타파일들을 가지고 있음.

  

![](C:\Users\student\Downloads\javacomplie.png)

- `javac`를 통해 `java`를 컴파일(컴퓨터언어로바꿔주고), 이 형태가 `.class`
- `java`는 `.class`파일을 실행시킬 수 있음.

- 변수명

  - <u>숫자, 특수기호가 맨 앞에 올 수 없고</u>,
  - 자바에서 사용되는 키워드는 사용할 수 없고.

  ```
  abstract  continue  for         new        switch
  assert    default   goto        package    synchronized
  boolean   do        if          private    this
  break     double    implements  protected  throw
  byte      else      import      public     throws
  case      enum      instanceof  return     transient
  catch     extends   int         short      try
  char      final     interface   static     void
  class     finally   long        strictfp   volatile
  const     float     native      super      while
  ```

  

- 주석

  ```java
  //한줄
  /*여러
  줄
  /*
  ```



- 자료형
  - 변수를 처음 선언할 때 어떤 자료형인지 알려주는 것
    - 숫자, int long, double float byte short
    - boolean  true,false
    - 문자, char
    - 문자열 관련해서는 String, StringBuffer (서로 다른것)
    - 배열, ArrayList
    - 해쉬, HashMap
- 접근제어자
  - 적절한 제어를 통해, 객체에 접근성을 설정할수있음
  - `private` : 해당클래스내만 접근할 수 있음
  - `default` : 해당 패키지내만
  - `protected ` : 해당 패키지 + 해당클래스 + 해당클래스를 상속받은 외부 패키지에서의 클래스까지
  - `public` 
- `fianl` : 상수, 선언하면 변경되지 않음. 객체에서 어떤 것을 상수로 선언해줘야하나도 고민해봐야할 문제. 
- 자바는 멀티쓰레드 환경을 구성하기가 좋음.

### 2. 변수 variable

###### 2.1 변수란?

- 변수는 메모리상 공간.
- 변수는 단 하나의 값만 저장할 수 있음.
- ```int``` 변수타입 : 정수, ```age``` : 변수 이름. ```//age라는 이름의 변수를 선언한 것```
- 기본형(primitive type)
- 참조형(reference type)



###### 2.2 변수 초기화.

primitive data type : boolean, byte, short, chat, int, long, float, double

- 하나의 값만 가질 목적으로 만들어짐.



### 7. 객체지향프로그래밍 2

##### 7. 인터페이스

###### 	7.1 인터페이스란?

인터페이스는 일종의 추상(abstract)클래스. 

그렇지만 추상클래스와는 달리, 일반 메서드, 멤버변수를 구성원으로 가질 수 없음.

인터페이스는 다른 클래스를 작성하는데 도움될 목적으로 만들어지고 일종의 기초 설계도. 객체를 만들때 설계되는 최소한의 틀의 느낌.



###### 	7.2 인터페이스 작성

기본적으로 클래스 작성과 같음. 다만 ``class``가 아닌 ``interface``를 사용함.

또한, ``interface`` 접근자는 ``public`` or ``default``를 사용가능.

```java
	interface 이름{
        public static final 타입 상수이름 = 값; //public static final 생략가능
        public abstract 메서드 이름 (매개변수);//public abstract 생략가능
        
    }
```



###### 	7.3 인터페이스 상속

인터페이스는 인터페이스로만 상속 가능. 여러개의 인터페이스 상속가능 = 다중 상속 가능 (클래스는 하나만 상속가능)



###### 7.4 인터페이스 구현

```java
class 클래스 이름 implements 인터페이스이름{
    // 인터페이스에 정의된 추상메서드 구현.
}
```





### 8. 예외처리

###### 	8.1 프로그램 오류

- 컴파일 에러 : 컴파일시 발생한 에러

- 런타임 에러: 컴파일은 되었는데, 실행 시 발생한 오류

- 논리적 에러: 실행은 되는데, 생각한거랑 다르게 동작할 때

- 에러 : 메모리부족(OutOfMemoryError), 스택오버플로우(StackOverFlowError) 발생 시 복구할 수 없는 심각한 오류.

- 예외 : 다소 미약한 오류. 코드를 통해 막을 수 있음.



###### 	8.2 예외 클래스의 계층 구조

- 예외의 최고 조상은 Exception

![](https://t1.daumcdn.net/cfile/tistory/217C6B4552AF12B432)

- checked exception 실행범위가 JRE를 벗어나는 경우
- unchecked exception 실행범위가 JRE를 벗어나지 않고, 사용자 부주의 또는 논리 오류에 대해.

1. ```exception``` 클래스와 그 자손들.
   - 외부의 영향으로 발생하는 오류.
   - 존재하지도 않는 파일을 이름을 입력했을때(```FileNot..```)
   - 클래스 이름을 잘못 적었을때(```ClassNot..```)
   - 컴파일러가 예외처리를 확인함.
2. ```runtimeException```과 그 자손들.
   - 프로그래머 실수
   - 배열 범위 넘어섬
   - 값이 null인 참조변수의 멤버 호출.
   - 클래스간 잘못된 형변환
   - 정수를 0으로 나누려고 했을 때(```ArithmetExeption..```)
     - ```NullpointerException``` null 0또는 공백을 참조할때,
   - 컴파일러가 예외처리를 확인하지 않음.



###### 	8.3 예외처리 try,catch

```java
try{
    //예외 발생 가능성 문장; 이곳에서 예외가 발생하면 catch로 넘어간다. 실행되면 아래문장으로 내려감.
}catch(예외클래스타입 객체){
    //예외 처리 문장;
}catch(예외클래스타입 객체){
    //예외 처리 문장;
}catch(예외클래스타입 객체){
    //예외 처리 문장;
}fianlly{
	//예외 발생과 무관한 반드시 수행해야 할 문장;
	ex) 사용했었던 resource들의 정리(close()) 문장등..
}		
```

- ```ArrayIndexOutOfBoundsException``` :  배열관련 예외처리
- ```NumberFormatException``` : 숫자 형식 관련 예외 처리



###### 8.4 try-catch문 흐름

```java
public static void main(String args[]){
    System.out.println(1);
    System.out.println(2);
    try{
        System.out.println(3);
        System.out.println(0/0); //ArithmeticException
        System.out.println(4);
    }catch(ArithmeticException e){//ArithmeticException 발생시 잡음
        e.printStackTrace();
        System.out.println(5);
    }
    System.out.println(6);
}
```

- ```1,2,3,5,6```이 프린트됨.
- 만약 ```ArithmeticException``` 대신 ```Exception``` 클래스 타입의 참조변수를 선언하면 어떤 종류의 예외가 발생하더라도 이 catch블럭에서 잡게 됨. 왜? ```Exception```은 예외들 조상이기때문에
- ```e.printStackTrace();```참조변수 e를 통해, 생성된```ArithmeticException```인스턴스에 접근
  - ```java.lang.ArithemticExcepton: /by zero....```등의 정보를 획득할 수 있음.

- ```e.getMessage``` -> 예외 메세지를 보여줌. ```/by zero```

- 멀티블럭 ```catch (Exception A | Exception B)``` 사용가능.
  - 만약 두개의 예외 멀티블럭이 서로 조상,자손관계라면 에러.. 왜? 조상 한번만 써주되니까.



###### 8.5 예외발생시키기

- 객체 생성하듯이, ```new``` 연산자 사용해서 객체 만듬. ```Exception e = new Exception```
- 키워드 ```throw``` 이용해서 예외 발생



###### 8.6 메서드에 예외 선언하기(declare 방식)

- 예외를 발생시키는 ```throw```와 예외를 메서드에 선언할 때 쓰이는 ```throws```를 잘 구별할 것.
- ```throws``` 예외클래스 이름을 메서드 선언부에 선언
- 예외처리 대신에 메서드를 호출한 곳으로 예외처리를 떠넘 기는 방식.

```java
void method() throws Exception 1, Exception 2..{
    //메서드 내용
}
```

- throws는 ``java.lang.Exceiption`` 클래스 자손이기 때문에, 반드시 처리해야하는 예외임.



###### 8.7 finally 블럭

- try-catch문과 함께 예외의 발생여부와 상관없이 실행됭야할 코드를 포함.

```java
try{
    //예외가 발생할 가능성이 있는 문장
}catch(Exception e){
    //예외처리를 위한 문장
}fianlly {
    //예외 여부 상관없이 반드시 실행되야할 문장
    // try-catch문 반드시 마지막에 위치
    // ex) 사용했었던 자원같은 정리 .close로.. => checked exception
    // 그래서 이 내부에도 try-catch-finally 블락을 쓸 수 있음.
}
```



### 9. java.lang 패키지, 유용한 클래스



##### - Object 

###### 9.1 equals()

- 얕은복사 vs 깊은 복사. 
  - Call by value vs Call by reference
  - ```equals``` : 대상 내용 자체를 비교 ```boolean```값으로 비교함.
  - ```==``` : 비교하고자 하는 대상의 주소값을 비교
  - ```Object.equals```는 주소값 비교 ```String.equals```는 실제값비교

###### 9.2 hasCode()

- Object클래스 기본적인 hasCode()클래스는 서로다른 객체가 결코 같은 해시코드를 가질 수 없음.
- 만약 클래스의 인스턴스 값을 비교하려면? 오바라이드해줘야함.
- ```System.identityHasCode(Object x)```는 객체의 주소값으로 해시코드를 생성하기 때문에 객체마다 항상 해시코드값이 서로 다름.



###### 9.3 toString()

- 기본적으로 인스턴스 변수에 저장된 값을 문자열로 표현.

```java
public String toString(){
    return getClass().getName() +"@" + Integer.toHexString(hashCode());
}//16진수 해시코드값 도출.
```



###### 9.4 clone()

- 기본적으로 단순히 인스턴스변수값만 복사(얕은 복사에 해당함.)
  - **얕은 복사**. 원본과 복제본이 같은 객체를 공유, 그래서 원본변경하면 복사본도 영향(온전한 복제라 볼 수 없지.) ex) 기본형 배열을 복사하면 얕은 복사를 한거라 할 수 있지.
  - **깊은 복사**.  원본이 참조하고 있는 객체까지 복사. 원본과 복사본은 서로다른 객체를 참조하게 됨. 그래서 원본의 변경이 복사본에 영향을 미치지 않음.

```java
class point implements Clonable{ //clonable 인터페이스를 구현한 클래스에서만 clone을 호출할 수 있음.
    int x, y; 
    Point (int x, int y){
        this.x =x;
        this.y = y;
       }
    pulic String toString(){
        return "x=" + x +", y =" + y;
    }
    public Object clone(){ //clone 오버라이딩, 접근제어자를 proteced에서 public으로 변경해줘야함.그래야 상속관계가 없는 다른 클래스에서 호출 할 수 있으니까.
        Object obj = null;
        try{
            obj = super.clone(); //clone() 은 반드시 예외처리해줘야함.
        }catch(CloneNotSupportedException e){}
        return obj;
    }
}
```

- 배열 clone 방법

```java
int [] arr = {1,2,3,4,5};
int [] arrClone = arr. clone;
//위 아래 결과값은 서로 같음, 배열을 복사하는 방법
int [] arr= {1,2,3,4,5};
int [] arrClone = new int[arr.length];
System.arraycopy(arr, 0, arrClone, 0, arr.length);
```



###### 9.5 getClass()

- 자신이 속한 클래스를 반환하는 메서드.
- 못찾으면 ```ClassNotFoundException``` 발생



##### - String

###### 9.6 Immutable

- immutable 변경불가능한. 

- 한번 생성된 String 인스턴스가 가지고 있는 문자열은 읽어올 수 만 있고 변경할 수는 없음.

- 그럼 새로운 문자열을 생성할때?

  - 덧셈연산자를 사용하면, 매 연산시마다 새로운 문자열을 가진 String인스턴스가 생성되는 것.

- ```그래서 new Stringbuffer```를 이용하면 좋음.

  - ```StringBuffer```인스턴스에 저장된 문자열은 변경가능하니까 ```appned``` 메소드를 사용함.
  
  


###### 9.7 String 클래스 의 생성자와 메서드

- ```String s = new String("Hello")``` String 인스턴스 생성, hello를 갖는
- ```String(char[] value)``` ->```char[] = {'h','e','l','l','o'}```
- ```String(StringBuffer buf)```
- ```char charAt(int index)``` : 지정된 위치(0부터시작하는 문자를 알려줌.
- ```int indexOf(int ch)``` : 주어진 문자 ch가 문자열에 존재하는지 찾음. 
- ```String[] split(String regex)``` : 문자열을 지정된 regex로 나눠 string 배열에 저장함.
- ```String substring(int begin, int end)``` : 시작 부터 끝 위치까지 포함된 문자열을 얻음.
- ```String trim()``` 문자열 왼쪽,오른쪽끝에 있는 공백 제거, 단 문자열 중간에 있는 공백은 제거하지 않음.



###### 9.8 join(), StringJoiner

```java
String animals = "dog,cat,bear";
String[] arr = animals.split(",");
String str = String.join("-",arr);
System.out.println(str); //dog-cat-bear
```



###### 9.9 Wrapping boxing, Unboxing

- primitive data type을 reference type에 할당이 가능하게 된것.
- Boolean, Byte, Short, Character, Integer, Long, Float, Double으로 박싱



###### 9.10 기본형 값 <->String

```java
int i = 100;
String str1 = i +""; //100을 "100"으로
String str2 = String.valueOf(i);
```

```java
int i = Integer.pareInt("100"); //"100"을 100으로
int i2 = Integer.valueOf("100");
```

- ```valueOf```리턴값은 Integer그렇지만 오토박싱에 의하여 int값으로 자동변화

- [기본형 문자열 변환방법](<https://m.blog.naver.com/PostView.nhn?blogId=iloveshe2&logNo=90189516739&proxyReferer=https%3A%2F%2Fwww.google.com%2F>)



##### - StringBuffer 클래스, StringBulider클래스



###### 9.11 StringBuilder

- 멀티쓰레드. 한번에 한 사람만 그 자원을 쓸 수 있도록 만들어 주는 것.

###### 9.12 StringBuffer 클래스 생성자와 메서드

- 가변문자열을 만들려할때 ```StringBuffer```을 사용함

- Stiring클래스와 다름. 

  - ```append()```

  ```java
  StringBuffer str = new StringBuffer("java");
  System.out.println(str.append("123"));
  System.out.println(str); // java
  ```

  - 즉 원본문자열을 바뀌지 않음.
  - ```delete()```,```insert()```등

###### 9.13 StringBuffer의 비교

- 위의 방법으로 생성된 객체는 ```equals``` 를 사용해도 ```==```를 비교한 결과(주소값을비교하는)를 얻음.
- 그래서 ```toString```을 호출한다음 ```equlas```메소드를 사용해야함.



##### - Math 클래스

- 생성자 private이므로, new Math()하는 것이 불가하다

- 모든 속성과 메서드는 static으로 정의됨.

  - ``` Math.E``` : 약 2.718
  - ```Math.PI``` : 약 3.141592.

- 올림,버림,반올림이 굉장히 귀찮게 되어있음.

  ```java
  //90.7552 소수점 셋째자리에서 반올림해서 소수 두째자리까지?
  
  1. 원래값에 100을 곱하고
  2. 그 결과에 Math.round()를 쓰고
  3. 2번 겨로가에 100.0으로 나눔.
  ```


###### 9.13 예외를 발생시키는 메서드

- 메서드 이름에 ```Exact```면 연산에서 발생 할 수 있는 오버 플로우를 감지하기 위함.

  ```int addExact (int x, int y)``` : x+y를 통해서 발생할 수 있는 overflow감지!

###### 9.14 StrictMath

- Math OS의 메소드를 사용 왜? 연산이 빠르게 진행됨. 하지만 컴퓨터마다 결과가 다를 수 있음.
- 그래서 StrictMath를 이용하면 차이를 방지할 수 있음.



###### 9.15 Math 클래스와 매서드

| 메서드명                      | 설명                |
| ----------------------------- | ------------------- |
| ```Math.ceil()```/double에만  | 올림                |
| ```Math.floor()```/double에만 | 버림                |
| ```Math.abs()```              | 절대값 반환         |
| ```Math.max,min()```          | 최대,최소값         |
| ```Math.random()```           | 0.0~1.0임의 값 반환 |

- 우리가 대부분 알고있는 영어로 구성됨.
- ```Math.random()*100``` 하면 0~99난수 생성하는 방법
- ```pow(),sqrt()``` 등.



##### - 래퍼wrapper 클래스

- 모든 것을 객체로 다룰려면, 이 클래스를 이용하면 됨.

- 오토박싱이 여기서 나오고.

  ```java
  Integer num = new Integer(5); //박싱
  int n = num.inValue(); //언박싱, 5
  
  Character ch = 'x'; // Character ch = new Character('x') 오토박싱
  char c = ch; // char c = ch.charValue() 오토언박싱  ,x
  ```

  

| Primitive | Wrapper class | primitive값만? |
| --------- | ------------- | -------------- |
| boolean   | Boolean       | booleanValue() |
| byte      | Byte          |                |
| short     | Short         |                |
| char      | Character     |                |
| int       | Integer       |                |
| long      | Long          |                |
| float     | Float         |                |
| double    | Double        |                |



| 문자열        | Wrapper클래스로       |
| ------------- | --------------------- |
| 문자열 "true" | Boolean.paseBoolean() |
| 문자열 "100"  | Byte.parseByte()...   |
|               |                       |

![](C:\Users\student\Downloads\img_java_boxing_unboxing.png)



##### - java.util.Objects클래스

- 널 체크(null check)할때 유용,
- 매개 변수의 유효성 검사를 할 때 유용함.
- ```Objects.equals``` 매개변수값이 null인지 확인할 필요 없음 (cf ```object.equals```와는 다름)

```java
String[][] str2D = new String[][]{{"aaa","bbb"},{"aaa","bbb"}};
String[][] str2D2 = new String[][]{{"aaa","bbb"},{"aaa","bbb"}}; //이중 배열 생성과 할당

//2중배열을 비교할떄는? equals가 아닌 deepEquals

System.out.printnln(Objects.deepEquals(str2D,str2D2));
```



##### - java.util.Random



##### - Regular Expression

1. 정규식을 매개변수로 Pattern 클래스, static 메서드인 Pattern compile(String regex)을 호출해서 

   ```Pattern p = Pattern.compile("c[a-z]*");```c로 시작하는 소문자 영단어 모두 

2. ```Macther m = p.macher(data[i]);```

3. ```if(m.matches())``` boolean값으로 리턴됨.

4. [참고](<https://regexr.com/>)  작성된 regex를 살펴볼 수 있음. 단 ```javascript```만 됨..



##### - java.util.Scanner클래스

```java
Scanner s = new Scanner(System.in);
String input = s.nextLine();
int input = s.nextInt();
```



##### - java.util.StringTokenizer 클래스

- ```split(), Scanner(line).useDelimiter(",");``` 와 같은효과. 이 전에 쓰던 방법



##### - java.math.BigInteger 클래스

- 필요할때 찾아보자.



### 10. 날짜 시간, 형식화

#### - 날짜와 시간

- Calendar는 추상클래스. 직접객체 생성불가 그래서..?
- Date, Calendar간 변환

```java
//Calendar -> Date
Calendar cal = Calendar.getInstance(); //그래서 getInstance()부분사용
Date d= new Date(cal.getTimeMillis()); 

//Date -> Calendar
Date d = new Date();
Calendar cal = Calendar.getInstance();
cal.setTime(d)
```



```java
package lab.java.core;

import java.util.Calendar;

public class CalendarEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String[] DAY_OF_WEEK = {"","일","월","화","수","목","금","토"};
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		//date1.set(2015,Calendar.AUGUST,15);
		date1.set(2015,7,15); // 2015년 8월 15일, 왜 7? 0부터 시작해서
		System.out.println("date1은 "+toString(date1)+DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]+"요일이고");
		System.out.println("오늘(date2)은 "+toString(date2)+DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]+"요일입니다");
		
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
		System.out.println("date1부터 지금까지 "+ difference+" 초가 지났습니다.");
		System.out.println("일로 계산하면 "+ difference/(24*60*60)+" 일입니다.");		
	}	
	public static String toString(Calendar date) {
		// TODO Auto-generated method stub
		return date.get(Calendar.YEAR) +"년 " + (date.get(Calendar.MONTH)+1) + "월 " + date.get(Calendar.DATE) + "일 ";}
}

```

- ```date.add```와 ```date.roll```의 차이점 , add는 date자체에 영향을주지만 roll은 안 줌.
- ```boolean isLeapYear(int year)```
- ```int datDiff(int y1, int m1)```
- ```int getDayOfWeek(int year, int month, int day)```
- ```String covertDayToDate(int day)```
- ```int convertDateToDay(int year, int month, int day)```

- 날짜 데이터를 특정 형식으로 문자열 하려면? ```yyyy-MM(월)-dd hh:mm(분):ss```
  - ```SimepleDateForm	at sdf = new SimpleDateFormat("yyyy-MM(월)-dd hh:mm(분):ss");```
- 숫자 데이터를 특정 형식으로 문자열 하려면? java.text.DecimalFormat
  - ```DecimalFormat df = new DecimalFormat("\u00A4##,###.")``` 



#### - 형식화 클래스

- DecimalFormat 왜? **숫자데이터**를 정수,부동소수점,금액등으로 다양한 형식으로 변환하기 위해서

  ```java
  double number = 1234567.89;
  DecimalFormat df = new DecimalFormat("#.#E0"); //#10진수, .소수점 E지수 0 10진수(0값 없을 때 0)
  ```

- SimpleDateFormat 날짜 데이터를 우리가 원하는 방식으로 나타내기 위해서.

  ```java
  SimpleDateFormat sdf1; //선언
  sdf1 = new SimpleDateFormat("yyyy-MM-dd"); //2015-11-23형식...
  ```

  

### 11. 컬렉션 프레임웍

- 컬렉션 : 객체들에 대한 집합

- 프레임웍 : 기반시설, 미리 만들어놓은 것. 나중에 사용하면 개발이 굉장히 쉬워진다..ㅠㅠ

- 하나 이상 같은 데이터들의 집합은 배열로 만들어놨지만,

  - **생성시에 배열의 크기를 정해놔야 하고**, 그 값보다 더 많은 값을 지정하려면 에러가 발생.

  

- List : 순서가 있고, 데이터의 중복을 허용함.  ex)ArrayList,,,Vector,Stack, index로 핸들링

- Set :  순서를 유지 하지 않음. 데이터 중복 허용하지 않음. index로 핸들링 못함. 왜? 순서가 없으니까.

  - 그래서 ```lterator```라는 친구를 이용해서 데이터를 찾음

- Vector랑 Arraylist는 같은 친구지만, 백터는 멀티쓰레드, 무거움(여러 사용자가 접근). arraylist 싱글 쓰레드, 가벼움(한 사용자가 접근)



###### 11.1 Collection 인터페이스

###### 11.2 List 인터페이스

```java
Arraylist a1 = new Arraylist();
a1.add("one");

// String[] arrayObj = new String[2];
// arrayObj[0] = "one"; 과 같은말.
```



###### 11.3 Set 인터페이스

- 중복허용하지 않고, 저장순서가 유지 되지 않는 컬렉션 구현할때
- ```HashSet``` , ```TreeSet``` 

- hashset은 저장된 그대로, 중복은 제거되면서, TreeSet은 약간의 순서변화가 있고 중복은 제거됨.



```java
package lab.java.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cars[] = {"k3","k5","sm6","k7","sm7","sm6","k9"};
		Set<String> hset = new HashSet();
		Set<String> tset = new TreeSet();
		for (String car : cars) {
			hset.add(car);
			tset.add(car);
		}
		
		//Iterator로 꺼내오기		
		Iterator<String> iter = hset.iterator();
		System.out.print("HashSet : ");
		while(iter.hasNext()) {
			System.out.print(iter.next()+",");
		}
		System.out.println();
		
		iter = tset.iterator();
		System.out.print("TreeSet : ");
		while(iter.hasNext()) {
			System.out.print(iter.next()+",");
		}
		System.out.println();		
	}

}
//HashSet : k3,k5,k7,sm7,sm6,k9,
//TreeSet : k3,k5,k7,k9,sm6,sm7,

```



#### - ArrayList

- Object배열을 이용해서 데이터를 순차적으로 저장.

### 12. 지네릭스

###### 12.1 지네릭스

###### 12.2 열거형

###### 12.3 애너테이션



### 15. 입출력(I/0)

###### 15.1 자바에서 입출력



