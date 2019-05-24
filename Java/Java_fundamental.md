# Java_fundamental

#### 정리목록

1. [Java의 정석](<http://www.yes24.com/Product/goods/24259565>) - 기본

2. [생활코딩_자바](<https://opentutorials.org/course/1223>) - 참고

   - **반드시 내가 이해한바를 적는다.** 

   - **그냥 교재나 코드가 써있는 바를 적지 않는다.**

   

### Ch7 객체지향프로그래밍 2

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





##### 8. 예외처리

###### 	8.1 프로그램 오류

- 컴파일 에러 : 컴파일시 발생한 에러

- 런타임 에러: 컴파일은 되었는데, 실행 시 발생한 오류

- 논리적 에러: 실행은 되는데, 생각한거랑 다르게 동작할 때

- 에러 : 메모리부족(OutOfMemoryError), 스택오버플로우(StackOverFlowError) 발생 시 복구할 수 없는 심각한 오류.

- 예외 : 다소 미약한 오류. 코드를 통해 막을 수 있음.



###### 	8.2 예외 클래스의 계층 구조

- 예외의 최고 조상은 Exception

![](https://t1.daumcdn.net/cfile/tistory/217C6B4552AF12B432)



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

- ```1,2,3,5,6```이 실행됨.
- 만약 ```ArithmeticException``` 대신 ```Exception``` 클래스 타입의 참조변수를 선언하면 어떤 종류의 예외가 발생하더라도 이 catch블럭에서 잡게 됨. 왜? ```Exception```은 예외들 조상이기때문에
- ```e.printStackTrace();```참조변수 e를 통해, 생성된```ArithmeticException```인스턴스에 접근
  - ```java.lang.ArithemticExcepton: /by zero....```등의 정보를 획득할 수 있음.

- ```e.getMessage``` -> 예외 메세지를 보여줌. ```/by zero```

- 멀티블럭 ```catch (Exception A | Exception B)``` 사용가능.
  - 만약 두개의 예외 멀티블럭이 서로 조상,자손관계라면 에러.. 왜? 조상 한번만 써주되니까.



###### 8.5 예외발생시키기

- 객체 생성하듯이, ```new``` 연산자 사용해서 객체 만듬. ```Exception e = new Exception```
- 키워드 ```throw``` 이용해서 예외 발생



###### 8.6 메서드에 예외 선언하기

- 예외를 발생시키는 ```throw```와 예외를 메서드에 선언할 때 쓰이는 ```throws```를 잘 구별할 것.

```java
void method() throws Exception 1, Exception 2..{
    //메서드 내용
}
```

- throws는 ```java.lang.Exceiption`` 클래스 자손이기 때문에, 반드시 처리해야하는 예외임.



###### 8.7 finally 블럭

- try-catch문과 함께 예외의 발생여부와 상관없이 실행됭야할 코드를 포함.

```java
try{
    //예외가 발생할 가능성이 있는 문장
}catch(Exception e){
    //예외처리를 위한 문장
}fianlly {
    //예외 여부 상관없이 ㅂ반드시 실행되야할 문장
    // try-catch문 반드시 마지막에 위치
}
```



###### 8.8 사용자정의 예외 만들기

