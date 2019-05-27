# Java_fundamental

#### 정리목록

1. [Java의 정석](<http://www.yes24.com/Product/goods/24259565>) - 기본

2. [생활코딩_자바](<https://opentutorials.org/course/1223>) - 참고

   - **반드시 내가 이해한바를 적는다.** 

   - **그냥 교재나 코드가 써있는 바를 적지 않는다.**

   

### 2. 변수 variable

###### 2.1 변수란?

- 변수는 메모리상 공간.
- 변수는 단 하나의 값만 저장할 수 있음.
- ```int``` 변수타입 : 정수, ```age``` : 변수 이름. ```//age라는 이름의 변수를 선언한 것```



###### 2.2 변수 초기화.



primitive data type : boolean, byte, short, chat, int, long, float, double

- 하나의 값만 가질 목적으로 만들어짐.



### 7. 객체지향프로그래밍 2

##### 7. 인터페이스

###### 	7.1 인터페이스란?

인터페이스는 일종의 추상(abstract)클래스. 

그렇지만 추상클래스와는 달리, 일반 메서드, 멤버변수를 구성원으로 가질 수 없음.

인터페이스는 다른 클래스를 작성하는데 도움될 목적으로 만들어지고

인터페이스는 일종의 기초 설계도. 객체를 만들때 설계되는 최소한의 틀의 느낌.



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

- 오버라이딩을 통해



###### 9.4 clone()

- 기본적으로 단순히 인스턴스변수값만 복사(얕은 복사에 해당함.)
  - 얕은 복사. 원본과 복제본이 같은 객체를 공유, 그래서 원본변경하면 복사본도 영향(온전한 복제라 볼 수 없지.) ex) 기본형 배열을 복사하면 얕은 복사를 한거라 할 수 있지.
  - 깊은 복사.  원본이 참조하고 있는 객체까지 복사. 원본과 복사본은 서로다른 객체를 참조하게 됨. 그래서 원본의 변경이 복사본에 영향을 미치지 않음.

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

  - ```StringBuffer```인스턴스에 저장된 문자열은 변경가능하니까,appned```메소드를 사용함.

  

###### 9.7 문자열비교

- 

###### 9.8 String을 기본 값으로 변환

###### 9.9 Wrapping boxing, Unboxing

- primitive data type을 reference type에 할당이 가능하게 된것.
- Boolean, Byte, Short, Character, Integer, Long, Float, Double으로 박싱

###### 9.10 Join()

###### 유니코드

- A 65,  a

###### 문자인코딩

- UTF8 가변길이 유니코드.



##### - StringBuffer 클래스, StringBulider클래스

###### 9.11 StringBuilder

- 멀티쓰레드. 한번에 한 사람만 그 자원을 쓸 수 있도록 만들어 주는 것.



##### - Math 클래스

- 모두 static으로 정의됨.

###### 9.12 예외를 발생시키는 메서드

- 메서드 이름에 ```Exact```면 연산에서 발생 할 수 있는 오버 플로우를 감지하기 위함.

###### 9.13 StrictMath

- Math OS의 메소드를 사용 왜? 연산이 빠르게 진행됨. 하지만 컴퓨터마다 결과가 다를 수 있음.
- 그래서 StrictMath를 이용하면 차이를 방지할 수 있음.

##### - 래퍼wrapper 클래스

- 파이썬은 모두 객체
- 모든 것을 객체로 다룰려면, 이 클래스를 이용하면 됨.



##### - java.util.Objects클래스

- 널 체크(null check)할때 유용,
- 매개 변수의 유효성 검사를 할 때 유용함.
- ```Objects.equals``` 매개변수값이 null인지 확인할 필요 없음 (cf ```object.equals```와는 다름)



##### - java.util.Random

##### - Regular Expression

1. 정규식을 매개변수로 Pattern 클래스, static 메서드인 Pattern compile(String regex)을 호출해서 

   ```Pattern p = Pattern.compile("c[a-z]*");```c로 시작하는 소문자 영단어 모두 

2. ```Macther m = p.macher(data[i]);```

3. ```if(m.matches())``` boolean값으로 리턴됨.

##### - java.util.Scanner클래스

```java
Scanner s = new Scanner(System.in);
String input = s.nextLine();
```



##### - java.util.StringTokenizer 클래스

- ```split(), Scanner(line).useDelimiter(",");``` 와 같은효과. 이 전에 쓰던 방법

##### - java.math.BigInteger 클래스

- 필요할때 찾아보자.