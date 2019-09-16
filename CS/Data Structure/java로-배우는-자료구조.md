## 3.1 상속(Inheritance)

- 무언가를 부모로 부터 상속 받는다.
- 그래서 코드의 중복을 피한다.

```java
public class Notebook extends Computuer{
 //노트북클래스는 컴퓨터클래스로 확장한다라는 의미.
 //그러면 노트북 클래스는 컴퓨터 클래스를 상속받는다.
    
     public Notebook(String man, String proc, int rom, int disk..){
         super(man, proc, rom, disk..);
     }
   
}
```

- A Notebook **is a** Computer.
  - extends하려면 i**s-a**관계인지 확인
  - 노트북은 일종의 컴퓨터.
  - 컴퓨터 클래스 안에 있는 멤버들은 노트북클래스에도 필요하다.
- Student is a Human..

- `super()` 상위 클래스의 생성자 중에서 매개변수 리스트가 일치하는 생성자를 호출한다. 반드시 생성자 내에서는 첫문장이어야함.



### 상속과 생성자

- 자바에서 클래스는 반드시 생성자를 가진다.
  - 만약에 클래스에 생성자가 없으면, **자동으로 생성자를 만들어줌**
  - 이러한 생성자는 껍질만 있는 생성자. 아무일도 하지 않음
    - 어떤 매개변수도 받지 않고,  무늬만 생성자.



- 모든 서브 클래스의 생성자는, 슈퍼 클래스의 생성자를 먼저 호출한다.
  - 노트북 클래스 생성자는, 컴퓨터 클래스의 생성자를 먼저 호출한다.
    1. `super()`를 통해서 **명시적**으로 호출
    2. 그렇지 않을 경우 no-parameter  슈퍼 생성자를 호출함
       - 노트북클래스생성자 안에서, 컴퓨터 클래스의 no-parameter 생성자를 호출함. 
       - 만약에 컴퓨터 클래스에 파라미터가 없는 생성자가 없다면, 오류!



### Method Overriding

- 부모로 부터 상속 받은 메서드를, 자식에서 다시 작성하는 것**(고치는 것)**
  - 자식 클래스 필요에 맞도록.

- 부모클래스 안에 멤버변수가 `private`이면 <u>자식클래스에서 접근할 수 없음.</u>

- `protected` 멤버는 <u>자식 클래스에서는 접근할 수 있음.</u>

- `super.toString()` 내 부모로부터의 toString 메서드를 쓴다는 의미



### 다형성(Polymorphism)

- 객체지향프로그래밍에서 가장 중요한 의미.

- 수퍼 클래스 타입의 변수가, 서브 클래스타입의 객체를 참고할 수 있음.
  - 그 역은 성립하지 않음

````java
Computer theComputer = new Notebook("Bravo",....);
//만들어진 객체는 노트북객체인데
//theCompter라는 참조변수의 타입을 Computer로 해도, 문법적 오류가 아니다.
````

- <u>만들어진 객체와, 데이터 타입이 달라도 문법적 오류가 아니다</u>

- static binding vs dynamic binding
  - 수퍼클래스와 서브클래스가 동일한 메서드를 가지고 있는 경우 어떤 것이 호출될 것인가?
  - static 컴파일러가 내릴때
  - 실제로 코드를 실행할 때 결정을 내리면, dynamic
- Java에서는 항상 동적 바인딩을 함(dynamic binding)
  - 변수의 타입이 문제가 아니라, 이 변수가 실제로 가리키고 있는 객체의 메서드가 호출됨



## 3.3 클래스 Object, Wrapper 클래스

### Object

- 클래스는 계층적으로 구성되어있음
- Java의 모든 클래스는 `Object` 클래스를 상속받는다
  - 그러면 내가 만들어주지 않아도, `equals` , `toString` 메서드를 가지고 있음.
  - 내가 원하는 대로 작동하기 위해서는 `Override`을 해야함

- `equals(Object)` 
  - 객체들의 주소를 비교하여 같은 주소인지 확인하는 메서드
- `getClass`
  - 동일한 클래스인지 검사



### Wrapper

- Java에서 primitive type 데이터와, non-primitive type데이터가 근본적으로 처리됨.
- Object 타입의 변수에는 어떠한 객체든 참조할 수 있음. 저장할 수 있음.
  - 그렇지만 int,double, char등의 primitive type 데이터는 저장할 수 없음.
  - 그러면 primitive타입의 데이터를 저장하려하면? 이걸 객체로 만들어주면됨.
- 이때 `Wrapper` 클래스를 사용한다.
  - 포장하다.

```java
int a =20;
Integer age = new Integer(a); //객체로 int 20을 만들었음 wrapping
//다형성에 의해서 배열(object)에 저장할 수 있게됨.

//포장한 객체를 다시 int로 풀려면?
int b = age.intValue(); //unwrapping

```

- 데이터 타입간의 변환기능을 제공

```java
String str = "1234";
int c = Integer.parseInt(str);
```



#### Autoboxing, unboxing

```java
int a = 20;
//Integer age = new Integer(a);

array[0] = a; //autoboxing

int b = (Integer) array[0] //autounboxing
```

