## Understanding Java method invocation with invokedynamic

> As of Java 8, invokedynamic is used as a primary implementation mechanism to provide advanced platform features. One of the clearest and simplest examples of this use of the opcode is in the implementation of lambda expressions. To follow along with the rest of this article, you’ll need to have some familiarity with how the JVM invokes methods, or you’ll need to read the first article in this series.

- Java8부터, invokedynamic이 주요한 구현체로 추가된듯.
- invokeddyanmic을 이용해서 lambda expression이 우리가 예상한대로 동작하도록 하는 듯.

### Lambdas are object references

> Java has only two types of values: primitive types (such as char and int) and object references. Lambdas are obviously not primitive types, so they must be object references. Consider the following lambda:

- Java는 2가지 타입이 있음.
- primitive type (char, int 같은) 그리고 object reference
- 람다는 primitive type은 명백하게 아니고.. 그렇다면 object reference 임.

```java
public class LambdaExample {
   private static final String HELLO = "Hello";
   public static void main(String[] args) throws Exception {
      Runnable r = () -> System.out.println(HELLO);
      Thread t = new Thread(r);
      t.start();
      t.join();
   }
}
```

> The lambda expression is assigned to a variable of type Runnable. This means that the lambda evaluates to a reference to an object that has a type that is compatible with Runnable.

- `() -> System.out.println(HELLO);` 가 Runnable 변수에 할당됨.
- 이 이야기는 람다는 object reference로 판단된다는 것. (누구에게? 컴파일러에게)

> Essentially, this object’s type will be some subclass of Object that has defined one extra method (and has no fields). The extra method is understood to be the run() method expected by the Runnable interface.

- 아마 람다로 생성되는 객체는 Object의 서브 클래스 일꺼고, Runnable 이라는 인터페이스로 치환되는 것으로 보아서 run() 이라는 메서드를 가지고 있을 것이라 생각됨.

> Before Java 8, such an object was represented only by an instance of a concrete anonymous class that implemented Runnable. In fact, in the initial prototypes of Java 8 lambdas, inner classes were used as the implementation technology.

- 자바 8 이전에는 이러한 객체(람다로 인해 생성되는 객체가 Runnable 인터페이스를 구현한 익명 클래스로만 표현되었음.
- Java8 의 초기 프로토 타입은, inner class를 이용해서 람다가 생성하는 객체를 구현했다고 함. (잘 이해는 안됨. 어떻게 내부 클래스를 통해 해결 할 수 있었을까)

> ..Fixing the representation to use explicit inner classes would prevent a different representation from being used by a future version of the platform

- inner class를 사용하도록 명시하면, 다른 버전의 JDK에서는 사용하지 못할 수도 있음. (유연성이 떨어지는 점이 있었는듯)

```java

public static void main(java.lang.String[]) throws java.lang.Exception;
   Code:
      0: invokedynamic #2, 0 // InvokeDynamic
                                             // #0:run:()Ljava/lang/Runnable;
      5: astore_1
      6: new #3 // class java/lang/Thread
      9: dup
      10: aload_1
      11: invokespecial #4 // Method java/lang/Thread."<init>":
                                        // (Ljava/lang/Runnable;)V
      14: astore_2
      15: aload_2
      16: invokevirtual #5 // Method java/lang/Thread.start:()V
      19: aload_2
      20: invokevirtual #6 // Method java/lang/Thread.join:()V
      23: return

```

- inner class를 사용한 bytecode 인듯.
- offset 0 이 invokedynamic(동적으로...) 을 통해 호출.
    - 아마도 람다코드가 Runnable을 구현한 익명클래스로 stack 에 쌓였다는 의미 아닐까?

### How invokedynamic operates

> n the case of invokestatic and invokespecial sites, which I discussed in the previous article, the exact implementation method (referred to as the call target) is known at compile time. In the case of invokevirtual and invokeinterface, the call target is determined at runtime. However, the target selection is subject to the constraints of the Java language inheritance rules and type system. As a result, at least some call target information is known at compile time.

- `invokestatic`, `invokespecial` 의 경우 컴파일 타임에 어떤 대상을 호출할지 알 수 있음.
- `invokevirtual`, `invokeinterface`의 경우에는 란타임에 어떤 대상이 호출될지 결정됨.
    - 그렇지만 Java 언어 특성상..? 아마 위 타입이라 해도 몇몇 호출은 컴파일 타임에 알 수 있는듯.

> In contrast, invokedynamic is far more flexible about which method will actually be called when the opcode is dispatched. To allow for this flexibility, invokedynamic opcodes refer to a special attribute in the constant pool of the class that contains the dynamic invocation. This attribute contains additional information to support the dynamic nature of the call, called bootstrap methods (BSMs).

- `invokedynamic` 어떤 메서드가 실제로 호출될지 결정하는 부분에서 유연함.
- 이러한 유연성을 보장하기 위해서, invokedynamic opcodes 는 class constant pool에 특별한 속성(dynamic invocation을 포함한) 참조하고 있음.
    - opcodes? is the portion of a machine language instruction that specifies the operation to be performed
- 이러한 속성은 bootstrap method 라고 하는 동적 호출을 지원하기 위한 정보를 가지고 있음.

> BSMs are a key part of invokedynamic, and every invokedynamic call site has a constant pool entry for a corresponding BSM. To allow the association of a BSM to a specific invokedynamic call site, a new entry type, also called InvokeDynamic, has been added to the class file format as of Java 7.

- BSM은 invokedynamic 중요한 부분.
- 모든 동적 호출은 constant pool entry를 가지고 있는데, BSM에 대응되는 값인듯.

> The call site of the invokedynamic instruction is said to be unlaced at class loading time. The BSM is called to determine what method should actually be called, and the resulting CallSite object will then be laced into the call site.

> In the simplest case, that of a ConstantCallSite, as soon as the lookup has been done once, it will not need to be repeated. Instead, the target of the call site will be directly called on all future invocations without any further work. This means that the call site is now stable and is, therefore, friendly to other JVM subsystems, such as the just-in-time (JIT) compiler.

- invokedynamic instruction 은 class loading 시점에 unlaced 되고 (올라가지 않는뜻인듯)
- 실제로는 어떤 메서드가 호출되는 지 판단하기 위해서 BSM을 호출. 그리고 그 객체가 racing 됨 (올라감)
- 이러한 작업은 한번 수행되면, 다시 반복할 필요가 없는듯 

> For this mechanism to work efficiently, the JDK must contain suitable types to represent the call site, the BSMs, and other parts of the implementation. Java’s original core reflection types are capable of representing methods and types. However, the API dates from the very early days of the Java platform and has several aspects that make it a less-than-ideal choice.

> For example, reflection predates both collections and generics. As a result, method signatures are represented by Class[] in the Reflection API. This can be cumbersome and error-prone, and it is hampered by the verbose nature of Java’s array syntax. It is further complicated by the need to manually box and unbox primitive types and to work around the possibility of void methods.

- 위와 같은 작업을 JAva Reflection API를 통해서 할 수 있긴 했는데.. 이상적인 선택은 아니었음.
- Reflection은 Collection, Generic 보다 앞서 개발되어 있어서, 호출 대상에 대한 적절한 메서드를 찾지 못하였는 듯.
- 또한 리플렉션을 사용하면 수동으로 box or unbox 해야했고, void 메서드에 대한 가능성도 해결해야했는듯.


## Method handles to the rescue

> Instead of forcing the programmer to deal with these issues, Java 7 introduced a new API, called MethodHandles, to represent the necessary abstractions. The core of this API is the package java.lang.invoke and especially the class MethodHandle. Instances of this type provide the ability to call a method, and they are directly executable. 

- 리플렉션을 사용하면 프로그래머로부터 위에서 제기된 문제에 대해서 알아서 핸들링하라는 이야기가 되니까..
- Java7에 MethodHandless 라는 API 도입
- java.lang.invoke 패키지의 MethodHanlde 클래스 도입을 통해, 메서드를 호출할 수 있는 기능을 제공.

> To get a handle for a method, the method must be looked up via a lookup context. The usual way to get a context is to call the static helper method MethodHandles.lookup(). This method returns a lookup context based on the currently executing method....

> One important difference between method handles and reflection is that lookup contexts return only methods that were accessible from the scope where the lookup object was created. There is no way to subvert this; there is no equivalent of the setAccessible() back door that is present in reflection. This means that method handles are safe to use under all circumstances, including using them with a security manager.

- method를 위한 handle을 얻으려면 `MethodHandles.lookup()` 호출을 통해 컨텍스트를 가져오는 것.
- 메서드 핸들과 리플렉션의 차이점은, lookup context는 메서드만 반환한다는 점. 
    - 이를 무력화할 방법 없음.
    - 리플렉션에서 제공하는 `setAccessbile()` 와 같은 방법 없음.
- 이 이야기는 메서드 핸들은 모든 환경에서 안전성을 보장하는 것.

> However, care must be taken, as the access control check has been moved to method-lookup time. This means that a lookup context can hand out references to private methods that were visible to the lookup but are not necessarily visible at the time when the method handle is invoked.

> To solve the problems of representing method signatures, the MethodHandles API also includes the MethodType class. This is a simple immutable type that has some very useful properties and does the following:

- 조심해야할 점도 있긴함.
- lookup context에서는 private 메서드에 대한 참조가 가능함.
- method handle이 호출할 때는 보이지 않는데..
- 이러한 접근관련 문제를 해결하기 위해서, Method Type 클래스를 포함했음. 이 클래스는 변경불가한 클래스로 여러모로 유용한 properties를 가지고 있음.

```java
// toString()
MethodType mtToString = MethodType.methodType(String.class);

// A setter method
MethodType mtSetter = MethodType.methodType(void.class, Object.class);

// compare() from Comparator<String>
MethodType mtStringComparator = MethodType.methodType(int.class, String.class, String.class);
```

- 매 접근가능한 메서드 마다 새로온 MethodType을 생성하지 않도록 함.


```java
public MethodHandle getToStringHandle() {
      MethodHandle mh = null;
      MethodType mt = MethodType.methodType(String.class);
      MethodHandles.Lookup lk = MethodHandles.lookup();
      try {
             mh = lk.findVirtual(getClass(), "toString", mt);
      } catch (NoSuchMethodException | IllegalAccessException mhx) {
           throw new AssertionError().initCause(mhx);
      }
      return mh;
}
```

- MethodType을 일단 만들면, MethodHandle 보고 메서드 이름을 통해 찾으라고 할 수 있음.

```java
MethodHandle mh = getToStringMH();
try {
      mh.invoke(this, null);
} catch (Throwable e) {
      e.printStackTrace();
}
```

- reflective 호출과 비슷하고 동작하는데, receiver object (mh) 가 인스턴스 메서드를 공급받아야 함.
- 그리고 호출할 때 예외처리도 해야하고.

> The concept of a BSM should now be clear: When program control reaches an invokedynamic call site for the first time, the associated BSM is called. The BSM returns a call site object containing a method handle to the method that will actually be bound into the call site. For this mechanism to function correctly with static typing, the BSM must return a handle to a method of the correct method signature.

> To get back to the lambda expression example I gave earlier, you can think of the invokedynamic opcode as representing a call to some sort of platform factory method for a lambda expression. The actual body of the lambda has been transformed into a private static method on the class where the lambda is defined.

- 처음 invokedynamic 호출되면, 관련된 BSM을 호출함.
- 그러면 BSM은 MethodHandle이 포함된 객체를 반환.
- 앞선 람다 코드의 경우를 생각해보면, 람다의 실제 본문은 클래스의 `private static method` 로 변환되었음.

```java
private static void lambda$main$0();
   Code:
      0: getstatic #7           // Field
                                       // java/lang/System.out:Ljava/io/PrintStream;
      3: ldc #9                   // String Hello
      5: invokevirtual #10 // Method
                                       // java/io/PrintStream.println:
                                       // (Ljava/lang/String;)V
      8: return
```

- 람다 팩토리는 Runnable을 구현한 어떤 타입의 인스턴스를 반환
- run() 이 호출될 떄, ptivate method 가 실행될 것. (람다 바디)

```java
#2 = InvokeDynamic #0:#40 //
#0:run:()Ljava/lang/Runnable;
```

- constant pool

```java
BootstrapMethods:
0: #37 REF_invokeStatic
java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodH
andles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/i
nvoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodT
ype;)Ljava/lang/invoke/CallSite;
Method arguments:
#38 ()V
#39 REF_invokeStatic optjava/LambdaExample.lambda$main$0:()V
#38 ()V
```

- BSM 
- LambdaMetaFactory.metafactory() 정적 팩토리 메서드를 참조하고 있는데,
- 이 부분이 람다가 생성될 경우, 런타임에 linkage bytecode를 생성하는 부분.
- metafactory 는 lookup object 와 MethodTypes 를 가지고 있는데 이게 type safety를 위한 것.
    - MethodHandle(lookup) 객체는 priavte static method를 가르키고 있는데.
    - 이 private static method가 lambda body임

## 참고

- <https://blogs.oracle.com/javamagazine/post/understanding-java-method-invocation-with-invokedynamic>
- <https://www.baeldung.com/java-invoke-dynamic>