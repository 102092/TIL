# Recursion

- 참고
  - Java로
  - [Youtube_강의](<https://www.youtube.com/watch?v=ln7AfppN7mY&list=PL52K_8WQO5oUuH06MLOrah4h05TZ4n38l&index=2&t=85s>)
  - 하루 1강씩..



### 1. Recursion 순환

- 항상 무한루프에 빠지진 않는다.
  - 왜? 적절한 제한문을 주면 됨.

```java
public static void func(int k){
    if(k<=0)//base case
        return;
    else{
        System.out.println("Hello!");
        func(k-1);// Recursive case
    }
}
```

- 어떤 적절한 제한문을 줘야할까?
  1. **Base Case** : 적어도 하나의 recursion에 빠지지 않는 경우가 있어야하고,
  2. **Recursive case**: 진행되면 진행될수록 **Base Case**에 가까워져야함



```java
public staic int Main(String [] args){
    int result = func(4);
    
}
public static int func(int n){
    if(n==0)//base case
        return 0;
    else{
        return n+func(k-1);// Recursive case 4+f(3)=3+f(2)=2+f(1)=1+f(0)=0 전체 10도출
    }
}

//즉 n =4를 넣어줬다는 의미는 0~4까지의 합을 구한 것이라 볼수 있음
//다시 생각하면 0~n까지의 합을 구할 수 있겠네? 순환을 이용해서?
```

- 이건 *수학적 귀납법* 과 완전히 동일하다?
  - 왜?
    1. basecase가 성립하고
    2. 임의의 양의 정수 k가 n<k인 경우에, 0~n까지 합은 올바르게 계산하여 반환한다고 가정하면
    3. n=k인 경우에도 성립한다.
- `func(n)` 함수는 음이아는 정수 n에 대해서, 0~n까지 합을 계산하는 함수이다.



**Q1) Factorial을 recursion을 통해서 만들어보자.**

1. 0! =1 -- basecase
2. n! = n*(n-1)! 단! n>0일떄 -- 2번 조건식이 성립한다면
3. n=k 인경우에도 성립함.



```java
public static int Main(String [] args){
    int result = factorial(10);
}
public static int factorial(int n){
    if(n==0) //basecase
        return 1;
	else
    	return n*factorial(n-1);//recursive case
}
```

- 수학적 귀납법

  1. n=0이면 1을반환하고 이건 맞지

  2. 임의의 양의 정수 k에 대해서, n <K 에 대해 n!을 올바르게 계산한다면

  3. n=k인 경우에, `factorial(k-1)`을 먼저 호출하는데, 이게 올바르게 계산됨. 따라서 메서드인 `factorial(k)`는 `k*(k-1)!`를 반환하게됨.

     

**Q2) X^n을 계산하는 함수를 만들어보자**

1. X^0 = 1
2. X^n = x*x^n-1 (n은 음이아닌 정수)
3. n=k일때도 성립함.



```java
public static double Main(String [] args){
    int result = power(5);
}
public static dobule power(double n, int k){
    if(n==0) //basecase
        return 1;
	else
    	return n*power(k-1);//recursive case
}

```



**Q3) fibonacci Number을 계산하는함수는??**

1. f0 = 0
2. f1 = 1
3. fn = fn-1 + fn-2



```java
public static int Main(String [] args){
    int result = fibonacci(5);
}
public static int fibonacci(int k){
//    if(k==0) 
//        return 0;
//    if(k==1)
//        return 1; 안써도 되네,..ㅠㅠ
    if(k<2)
        return n; //basecase
	else
    	return fibonacci(k-1)+fibonacci(k-2);//recursive case
}
```



**Q4) 최대공약수 : Euclid method**

- 바로 감이 안왔음 어떻게? 순환을 이용해서?

```
m>=n인 두 양수 m과 n에 대해서 m이 n이 배수라면 gcd(m,n)=n이고,
그렇지 않으면 gcd(m,n) = gcd(n,m%n) 이다..
```

```java
public static int gcd(int m , int n){
    if(m<n){
        int tmp = m; m =n; n =temp; //swap m and n 왜? 저 공식 자체가 m>=n이므로
    }
    if(m%n==0) //즉 m을 n으로 나눠서 나머지가 없다면, m이 n의 배수라면
        return n;
    else
        return gcd(n,m%n);
}
```

- 좀 더 단순히...

```
gcd(p,g) =..
if q =0 //둘중하나가 0이면, 최대공약수는 p이고 그렇지 않다면
gcd(q,p%q)
이 정리에서는 p가 반드시 q보다 클 필요는 없다!
```

```java
public static int gcd(int m , int n){
    if(q==0) 
        return p;
    else
        return gcd(q,p%q); //무한루프에 빠지지 않을까?
}
```

