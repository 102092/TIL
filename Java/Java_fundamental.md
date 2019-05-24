# Java_fundamental

#### 정리목록

1. [Java의 정석](<http://www.yes24.com/Product/goods/24259565>) - 기본

2. [생활코딩_자바](<https://opentutorials.org/course/1223>) - 참고

   

### Ch7 객체지향프로그래밍 2

##### 7. 인터페이스

###### 	7.1 인터페이스란?

인터페이스는 일종의 추상(abstract)클래스. 

그렇지만 추상클래스와는 달리, 일반 메서드, 멤버변수를 구성원으로 가질 수 없음.

인터페이스는 다른 클래스를 작성하는데 도움될 목적으로 만들어지고



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



##### 8. 예외처리

###### 	8.1 프로그램 오류

- 컴파일 에러 : 컴파일시 발생한 에러

- 런타임 에러: 컴파일은 되었는데, 실행 시 발생한 오류

- 논리적 에러: 실행은 되는데, 생각한거랑 다르게 동작할 때

- 에러 : 메모리부족(OutOfMemoryError), 스택오버플로우(StackOverFlowError) 발생 시 복구할 수 없는 심각한 오류.

- 예외 : 다소 미약한 오류. 코드를 통해 막을 수 있음.



###### 	8.2 예외 클래스의 계층 구조

- 예외의 최고 조상은 Exception

![예외 클래스](C:\Users\student\Downloads\217C6B4552AF12B432.jpg)

1. ```exception``` 클래스와 그 자손들.
   - 외부의 영향으로 발생하는 오류.
   - 존재하지도 않는 파일을 이름을 입력했을때(```FileNot..```)
   - 클래스 이름을 잘못 적었을때(```ClassNot..```)
2. ```runtimeException```과 그 자손들.
   - 프로그래머 실수
   - 배열 범위 넘어섬
   - 값이 null인 참조변수의 멤버 호출.
   - 클래스간 잘못된 형변환
   - 정수를 0으로 나누려고 했을 때(```ArithmetExeption..```)

###### 	8.3 예외처리 try,catch

```java
try{
    //예외 발생 가능성 문장;
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



