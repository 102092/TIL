>   궁금했던 부분을 찾아가며 정리하고 있습니다.
> 혹시 잘못된 부분이 있으면, 언제든지 댓글로 편하게 알려주세요 :)



----



## equal()

- 메서드의 한 종류
- 객체의 값(**내용**)을 비교한다.
- 기본형 변수에 대해서는 사용할 수 없다.
- 반환 형태는 `==` 와 같이 boolean 값이다.



## ==

- 두 개의 객체가 같은 메모리 값을 가리키고 있는지 확인하려 사용

- 기본형 타입(primitive) 변수에도 사용할 수 있음

- 항등 연산자(Operator) :  >,< !=...

- true or false(Boolean) 로 반환 된다

- <u>객체 유형에도 적용</u>이 된다.

  호환성이 있을 경우, 즉 부모-자식관계 혹은 동일한 유형...

  호환성이 없으면, **컴파일 오류**!



### equals vs ==

```java
public class Test { 
    public static void main(String[] args) 
    { 
        String s1 = new String("HELLO"); 
        String s2 = new String("HELLO"); 
        System.out.println(s1 == s2); //false
        System.out.println(s1.equals(s2)); //true
    } 
} 
```

- 생성자를 통해(참조형으로) string값을 만들었을 때, JVM안 heap메모리 영역에 인스턴스가 생성됨.
- s1, s2 그 객체의 값은 같지만, 그 주소는 다르게 만들어졌음.
- 그래서 `==` 에는 `false` , .`equals` 에는 `true`





```java
class Test { 
    public static void main(String[] args) 
    { 
        // integer-type 
        System.out.println(10 == 20); //false
  
        // char-type 
        System.out.println('a' == 'b'); //false
  
        // char and double type 
        System.out.println('a' == 97.0); //true
  
        // boolean type 
        System.out.println(true == true); //true
    } 
} 
```

- `char` 형은 기본형 타입. 기본형이라는 부모 아래 있음. 그래서 double 실수형이랑 비교했을 때 true값을 도출한듯.

  ![](https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile22.uf.tistory.com%2Fimage%2F211DB03B576D199130D62B)

  

```java
public class Test {
    public static void main(String[] args) {
        System.out.println((int) 'a'); // cast char to int
        System.out.println('a' == 97); // char is automatically promoted to int
        System.out.println('a' + 1); // char is automatically promoted to int
        System.out.println((char) 98); // cast int to char
    }
}
```

![](https://t1.daumcdn.net/cfile/tistory/99F8D73359F9601E32)

- 또한 묵시적 형변환을 통해, `char` 형 변수는 `int` ,`long` ,`float` ,`double` 값으로 변할 수 있음..
- 명시적은 casting 해줘야하고



```java
class Test { 
    public static void main(String[] args) 
    { 
        Thread t = new Thread(); 
        Object o = new Object(); 
        String s = new String("GEEKS"); 
  
        System.out.println(t == o); //false
        System.out.println(o == s); //false
  
       // Uncomment to see error  
       System.out.println(t==s); 
    } 
} 
```

- 객체 비교에도 `==` 를 사용할 수 있음.
  - 다만 비교를 하려면, 객체간의 관계가 부모-자식 혹은 같은 타입이어야함. 
  - 자바 자료형에 대해 다시 한번 정리하자.



> 참고

- https://limkydev.tistory.com/139
- http://blog.naver.com/PostView.nhn?blogId=yysvip&logNo=220104814267&categoryNo=7&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView
- [https://postitforhooney.tistory.com/entry/Java자바자바에서-스트링-비교하기equals와-의-차이점]([https://postitforhooney.tistory.com/entry/Java자바자바에서-스트링-비교하기equals와-의-차이점)

- https://www.geeksforgeeks.org/difference-equals-method-java/
- https://gmlwjd9405.github.io/2018/10/06/java-==-and-equals.html