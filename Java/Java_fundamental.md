# Java_fundamental

#### 정리목록

1. [Java의 정석](<http://www.yes24.com/Product/goods/24259565>) - 기본
2. [생활코딩_자바](<https://opentutorials.org/course/1223>) - 참고
- **반드시 내가 이해한바를 적는다.** 
- **그냥 교재나 코드가 써있는 바를 적지 않는다.**



### 1. 시작

- JVM 자바 가상 머신?

  - 자바바이트 코드를 실행시킬 수 있는 기계.
  - 서로 다른 운영체제에 맞춰서 실행시키기 위해 사용하는 것.

  -  Garbage collector가 있는 곳. 더 이상 사용하지 않는 메모리를 자동으로 회수해주는 역할

- JRE 자바 실행환경

  - JVM을 포함하고 있고
  - 자바를 동작시킬때 필요한 라이브러리,기타파일들을 가지고 있음.

  

- `javac`를 통해 `java`를 컴파일(컴퓨터언어로바꿔주고), 이 형태가 `.class`
- `java`는 `.class`파일을 실행시킬 수 있음.

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

  - `char` vs `String`

    둘다 문자를 담는 데이터 타입이지만, `char`은 오직한글자만 

    `string`은 여러 글자를 한번에

    char은 문자를 담을 때 해당문자를 ' '로

    string은 문자를 담을 때 " "로 묶음

- 참조형(reference type)



###### 2.2 변수 초기화.

###### 2.3 변수 명명규칙

- 대소문자구분, 길이제한없음

- 예약어(true같은) 사용못함

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

  숫자로 시작되어서는 안됨.

- 특수문자는 '_' , '$'만 허용

  



###### 2.4 변수 타입

- primitive data type : boolean, byte , short  char, int, long, float, double (기본형) 실제 값을 저장하고

  

  ![](https://t1.daumcdn.net/cfile/tistory/993908415A96665E19)

  - 작은 크기의 변수타입을 선언해줘야 하는 이유? 저장공간을 절약해주기 위해

- reference data type : 위 8개 그외. 주소값을 저장함.

- 리터럴? 그 자체로의 값을 의미하는 것.

  ```java
  final int MAX_VALUE(상수) = 100(리터럴);
  ```

###### 2.5 printf()

```java
%b boolean형식으로 출력
%d digit 정수
%o 8진수
%x %X 16진수형태로 출력
%f 부동소수점
%e,E 지수
%c 문자로 출력
%s 문자열로 출력
```



###### 2.6 형변환(casting)

- 변수 , 상수타입의 다른 타입으로 변환하는 것.

- `(타입) 피연산자` 로 선언하면서 바꿔줌.

- 기본형 형변환

  ```java
  double d = 85.4;
  int score = (int) d
  //score = 85
  // d= 85.4 .. 형변환해도 원래 변수값에는 변화없음.
  ```



- 정수형(int) -> 실수형(float) 변환하는 것은 별 무리 없음. 왜? 실수형이 훨씬 큰 저장범위를 가지기 때문

- 그런데 실수형(float) -> 정수형(int)이면 버림이 발생 1.6666 -> 1로 **오버플로우** 가 발생하여.

  
###### 2.7 자동형변환

- 형변환을 해야되는 상황에서 컴파일러가 자동적으로 해주는 것.

- 어떤 규칙으로? *기존의 값을 최대한 보존할 수 있는 타입으로 자동으로 형변환 해줌.*

  ![](https://t1.daumcdn.net/cfile/tistory/99142D335A095BCA27)

- 묵시적 형변환은 자동으로 해주는 것이고, 명시적 형변환은 내가 선언해줘야 하는 것.



### 3. 연산자

- 산술(+-,,) > 비교(=..) > 논리(>,<...)> 대입 연산자 순으로 수행
- 단항 > 이항 > 삼항 연산자.



###### 3.1 산술 변환

- 데이터타입이 다르면 산술 연산을 수행하지 못하므로, 형변환 연산자를 사용하여 일치시켜야함.(보다 큰타입으로)
- 피연산자 타입이 `int`보다 작은 타입이면 `int`로 변환됨.



###### 3.2 단항 연산자.

- `i++` i = i +1; 과 같음.후위형, 증감자 포함된 식이 실행된 후 증감이 실행되고
- `++i` i = i +1; 과 같은데, 전위형이고 증감자 포함식이 실행되기 **전**에 증감이 실행됨. 즉 증감이 언제 되냐?의 찿이지.
- `i--, --i` ..



###### 3.3 비트 연산자.

- & | ^ ~ << >>

- ^(XOR)

  ![](https://kocoafab.cc/data/140811110855.jpg)

###### 3.4 그 외 연산자.

- 조건 연산자 `? :`

  `조건식 ? 식1(참) : 식2(거짓)`

  유용하니까 기억해두자.



###  4. 조건문, 반복문.

###### 4.1 조건문

- `if, elseif , else...`

```JAVA
if (조건식1) {
    // 조건식1이 참(0이 아닌값)일 때 수행될 문장.
} else if(조건식2) {
    // 조건식2이 참(0이 아닌값)일 때 수행될 문장.
} else{
    // 조건식이 거짓(0) 일때 수행될 문장.
}
```

- `switch`

```java
switch (조건식){
    case 값1:
        //조건식 결과가 값1과 같을 때 수행될 문장.
        break;
    case 값2:...
        
        default: 
        //위의 값들과 일치되지 않을 때 수행될 문장.
}
```

- `while`문하고 많이 쓰임.
- `while(true)` 하면 무한반복문 실행되고.
- `break` 빼먹으면 안됨. 원하는 값 안나올 수 있음.



###### 4.2 반복문.

- `for` 문
  - 다중for문을 사용하면 프로그램이 느려져서 많이 사용하지 않음.

```java
for(int i = 1; i < 5; i++){
    //....
}
// int i = 1? 변수 초기화
// i < 5 조건식
// i++ 증감식.
```

- `for` 문 중첩도 가능.

- `while` 문

```java
while (조건식){
    // 조건식이 참일 경우, 반복될 문장.
}
int i = 1;

while (i < 5){
    i++;
}//위 for문의 반복문과 같은 식. 조금 다름.
```

- `while ` 문 조건식은 생략 불가하고.



- `do-while` 문

```java
do{
    // 일단 한번은 실행하고, 밑에 조건식이 참일 경우 다시 수행함.
}while (조건식);
```



- `break` 문

  - 반복문 작성시에 변수 선은은 가능한 반복문 밖에, 왜? 변수 초기화가 계속 될 수 있으니까.
  - `break` 문 사용시, 자신이 포함된 가장 가까운 반복문을 벗어남.

- `continue` 문

  - `continue` 문 사용시, 바로 자신이 포함된 반복문의 끝으로 이동하여, 다음 반복문으로 넘어감.

### 5. 배열

- 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것.

###### 5.1 배열 선언

  `타입 [] 변수이름;`

  `int [] score; `//int 타입 배열 참조변수 score를 선언한것.

- 배열의 인덱스는 0부터 시작한다.

- 배열의 길이는? `배열이름.length` 로 알아볼수 있음. 

  - `ArrayIndexOutOfBoundException` 오류 유효한 인덱스,배열범위를 넘어서 무언가를 하려 할때



###### 5.2 배열 초기화

- 배열안에 원하는 값을 저장하라면 각 요소의 값을 지정하여 초기화해줘야함.

  ```java
  int [] score = new int[5]; //  길이가 5인 int형 배열 생성
  score[0] = 50;
  score[1] = 60;...//이런식으로.
      
  //또는
      
  int[] score = new int[] {50,60,70,80,90}; // 배열 생성과 초기화를 동시에 해줄수도 있음.
  ```

  

######   5.3 배열의 출력

- 배열에 저장된 값을 확인할때는 `for`문을 사용하면됨

- 혹은 `Array.toString()`  을 사용

  ```java
  int[] iArr = {100,90,80,70,60};
  
  for (int i= 0; i < iArr.length; i++){
      System.out.println(iArr[i]);
  }
  ```

  - `iArr` 배열 자체를 출력하게 되면, '타입@주소' 형식으로 출력됨.



###### 5.4 배열 복사

1. `for` 문을 사용해서 배열을 복사.

   `temp`배열을 사용해서 배열을 복사하는 방식,.

2. ` System.arraycopy()` 를 사용

   ```java
   System.arraycopy(num, 0 , newNum,0,num.length);
   //num[0] 배열에서 newNum[0] 으로 num.length개의 데이터를 복사하는 것.
   ```



###### 5.5 배열 활용

1. 총합, 평균.
   - 반복문을 사용해서 전체를 더하고, 배열의 길이를 이용해서 총합을 나누면 평균이 나오고.
2. 최대값, 최소값

   - 임시변수 `temp`, 반복문`for` 이용
3. 섞기
4. 임의의 값으로 배열 채우기
5. 정렬
6. 빈도수



###### 5.6 String 배열

- `String[] name = new String[3];` 3개의 문자열을 담을 수 있는 배열 생성.

- char배열이 아닌 string클래스를 이용해서 문자열을 사용하는 이유는? 확장성 때문.

- 주요메서드

  ```
  char charAt(int index) //해당 인덱스에 있는 문자를 반환
  int length() // 문자열의 길이 반환
  String substring(int from, int to) //from~ to(포함하지 않음) 범위에 있는 문자열 반환
  boolean equals(String str) // 문자열 내용이 같은지
  char[] toCharArray() // 문자열을 문자배열char[]로 변환해서 반환
  ```
  
- char 배열, String클래스 변환
	```java
	char[] chArr = {'A','B','C'};
  String str = new String(chArr); // char배열 -> String
  char[] temp = str.toCharArray; // String -> char배열
  ```
  

###### 5.7 다차원 배열

![](https://t1.daumcdn.net/cfile/tistory/215D153658A521A401)



- 2차원 배열

  - 선언? `타입[][] 변수이름;` 

  - `int[] [] score` = `new int [3][4]` // 3_y행 4_x열 배열 생성. ,2차원 배열

  - 초기화? 

    `int[] [] arr = new [] [] {{1,2,3},{4,5,6}};`

    ​	2차원 배열을 생성하고,

    ​	1행에 각1,2,3 각요소를 할당

    ​	2행에 각 4,5,6 요소를 저장.

    생성과 초기화 동시에, 다만 {}를 한번 더 쓰는 것을 잊지 말자.

  - 가변 배열

    `int [] [] score = new int[5][]`;
  
    `score[0] = new int [4];`
  
    `score[1] = new int [3];`
  
    이렇게 함으로써 각 행마다 다른 배열을 생성하는 것이 가능
  
- 3차원 배열

  - `int[][][] score = new int [3] [2] [3]` z, y, x순

    ![]()

### 6. 객체지향프로그래밍1

- 좋은 코드란? 중복이 없는 코드.

- 객체지향언어
  - 코드 재사용성이 높고
  - 코드의 관리가 용이하고
  - 신뢰성이 높은 프로그래밍을 가능하게하고,



##### 6.1 클래스, 객체

- 클래스는 객체를 생성하기 위한 설계도.
- 객체는 실제로 존재하는 것., 메모리에 생성된 것을 의미.

###### 6.11 객체와 인스턴스

- 클래스에서 객체를 만드는 과정을 *클래스의 인스턴스화*

- 객체는 속성과 기능으로이루어짐.

  - 속성? 멤버변수..
  - 기능? 매서드, 함수등.

  ```java
  Tv t; //Tv클래스 타입의 참조변수 t를 선언하고
  t = new Tv(); // Tv클래스의 객체를 만들어서, 그 주소를 t에 저장함.
  ```



###### 6.12 객체 배열

- 참조변수들을 하나로 묶은 참조변수배열을 의미하고.

```java
Tv[] tvArr = new Tv[3]; //Tv인스턴스를 3개 담을수 있는 tvArr배열을 만들었음.
```



###### 6.13 추상클래스

- 다른 클래스의 템플릿.
- 공통 속성들을 적어놔서 쓰기 편하도록?\
- `extends` 확장을 이용해서 다른 클래스를 통해 생성된 객체가 사용할 수 있도록..

```java
abstract class Aniaml{
    abstract void cry();
}
```





##### 6.2 변수와 메서드

- 인스턴스변수, 클래스영역에 선언, 
- 클래스변수, 인스턴수 변수 앞에 `static` 붙은것. 한 클래스에서 모든 인스턴스들이 공통적인 값을 유지해야할 경우 사용하고,

- 지역변수, 메서드내에서만 선언되고, 메서드내에서만 사용되는 변수.



###### 6.21 메서드

- 특정작업을 수행하는 일련의 문장들을 하나로 묶은 것.
- 반환타입을 적어야하고, 없을 경우 `void` 라 적어야함.
- 반환값유무에 상관없이 모든 메서드에는 적어도 하나의 `return`문이 있어야함.

##### 6.3 기본형 매개변수, 참조형 매개변수

##### 6.4 재귀호출

- 재귀호출은 조건문이 필수적으로 따라다님.

  ```java
  void method(int n){
      if(n==0)
          return;
      System.out.println(n);
      
      method(--n); //재귀호출, 
  }
  ```



##### 6.5 클래스메서드, 인스턴스메서드

- 메서드 앞에 `static` 이 붙어있으면? 클래스, 아니면? 인스턴스메서드
  - 인스턴스메서드는  인스턴스변수와 관련된 작업을 하는 그래서 인스턴스를 생성해야한 사용할 수 있음.
  - 클래스 메서드는, 인스턴스와는 관계없는 

##### 6.6 오버로딩

- 한 클래스내 같은 이름의 메서드를 여러개 정의하는 것.
  - 메서드이름이 같인데, 매개변수가 달라서, 뭔가 다양한 매개변수에 대응할 수 있도록 만들어줌. 

###### 6.61 조건

1. 메서드 이름이 같아야 하고
2. 매개변수의 개수 또는 타입이 달라야 하는 점.
   - 반환타입은 오버로딩을 구현하는데 아무런 영행을 주지 못함.



##### 6.7 생성자

- 인스턴스 초기화 메서드. 객체를 초기화 시켜주는 것.

###### 6.71 조건

1. 생성자 이름은 클래스와 같아야하고,
2. 생성자는 리턴값이 없음.

###### 6.72 생성자에서 다른 생성자 호출하기, this(), this



##### 6.8 변수의 초기화

- 지역변수는 사용기전에 반드시 초기화해야한다.

- *멤버변수(클래스변수, 인스턴스변수)와 배열의 초기화는 선택적*!

  그렇지만 **지역변수의 초기화는 필수적!**

###### 6.81 명시적초기화

```java
class Car{
    int door = 4; //기본형 변수의 초기화
    Engine e = new Engine(); //참조형 변수의 초기화
}
```





### 7. 객체지향프로그래밍 2

##### 7. 인터페이스

###### 	7.1 인터페이스란?

인터페이스는 일종의 추상(abstract)클래스. 

그렇지만 추상클래스와는 달리, 일반 메서드, 멤버변수를 구성원으로 가질 수 없음.

인터페이스는 다른 클래스를 작성하는데 도움될 목적으로 만들어지고 일종의 기초 설계도. 객체를 만들때 설계되는 최소한의 틀의 느낌.

클래스와 외부세계(다른 클래스..등을) 이어주는 역할

인터페이스 내부에는 추상메서드를 가지고 있고. 

인터페이스를 받은 클래스는 해당 메서드를 **오버라이드** 해서 사용함



*각 클래스가 상속 받을 수 있는 클래스는 최대 1개 였음(단일상속*)

*하지만 인터페이스는 여러개 상속받을 수 있음(다중상속*)





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



###### 7.5 다형성

다양한 형태를 가지는 성질 일컫는 말.

Person 클래스(슈퍼 클래스)를 상속받은 Student클래스(서브클래스)가 생성한 객체 `stu` 는

Student 클래스의 객체 일뿐만 아니라, Person 클래스의 객체로도 다룰 수 있음.

즉 홍길동이라는 학생은 학생일뿐만 아니라 사람이기도 하니까.



서브 클래스의 객체는 슈퍼클래스의 객체가 될 수 있지만, 

슈퍼클래스의 객체는 서브클래스의 객체가 될 수 없다.

**모든 학생은 사람이지만, 모든 사람이 학생은 아니니까**



```java
class Person{
    name, age, weight; 
    eat(); sleep();
}

class Student extends Person{
    super();
    stuNum; study(); //서브클래스만의 특징
}

Person stu = new Student(); //Person 클래스를 데이터타입으로 하는 객체를 생성한것.
//name,age,weight, eat();, sleep();에 접근 가능.
//이렇게 생성한다고 해서, 서브클래스만의 특징에는 접근 할 수 없다.

Student stu = new Studnet(); //Student 클래스를 데이터타입으로 하는 객체를 생성
//Person객체에 데이터,메소드뿐만 아니라 stuNum, Study(); 에 접근 가능하다.

Student stu = new Person(); //생성 불가
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

- Vector랑 Arraylist는 같은 친구지만,

  백터는 멀티쓰레드, 무거움(여러 사용자가 접근).

   arraylist 싱글 쓰레드, 가벼움(한 사용자가 접근)



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

- 입력스트림, 출력스트림

- 데이터가 흘러갈 수 있도록 **스트림을 열고** 데이터를 흘려보낸 뒤, **스트림을 닫는다**

  문자 스트림 Reader | Writer

  ​	FileReader/Writer

  바이트 스트림 InputStream | OutputStream

  ​	모두 추상클래스, 

- 텍스트 파일? 파일 안에 내용이 문자열로 되어있음.

- 바이너리 파일? 파일 안에 내용이 사진,동영상등으로 되어있을 때

###### 15.1 자바에서 입출력



- 키보드 입출력

  `next()` 띄어쓰기 전까지 입력된 문자를 받아옴

  `nextInt()` 띄어 쓰기 전까지 입력된 정수들을 읽어옴

  `nextDouble()` 띄어 쓰기 전까지 입력된 실수들을 읽어옴

  `nextLine()` 엔터로 줄바꿈하기 전까지 입력된 **문자들을** 읽어옴



- 멀티쓰레드

  같은 작업을 한 프로그램내에 여러 쓰레드들을 사용하는 것.. 동시에 여러작업이 할 수 있음.

방법

1. 쓰레드 클래스 상속.
2. 쓰레드 클래스의 run()메서드를 오버라이딩(처리할 일을 적음)
3. 메인 메서드에서 해당 클래스의 객체를 생성하고, strat()메서드로 스레드 실행



```java
class Mthread extends Thread {
    public void run(){
        //~내가 처리할 명령
    }
    public static void main(String[] args){
        Mthread t = new Mthread();
        t.start(); //start()메소드 실행
    }
}
```



쓰레드간에 통신

​	공유 메모리를 생성하여...



네트워크

- TCP 손실되면 안되는, 메일...
- UDP 조금 손실되도 괜찮은 동영상등..