## 목표

- python 기본을 다시 복습하고

- python scrapper를 만든다.



## 0. introduction

- https://repl.it/~ 가입



## 1. Theory

###  variable

- 텍스는 반드시 ' ' single quote or " " double quote로 감싸져있어야함.
- True 1, False 0 으로 컴퓨터에서 인식한다.
  - True != "True" 완전히 다른 것.
- float = 3.12...
- None = null , 존재하지 않음을 의미.

- 변수는 lowercase 그리고 이름이 길 때는 _ snake case를 사용한다.
  - 의무적인 것은 아니지만, 유저들간의 약속.

### List

- days = ["Mon", " Tue", "Wed", " Thur", "Fri"]
- `[]` 로 감싸면 python에서는 List로 인식한다
- Mutable 바꿀수 있음. cf)Immutable 못바꿈
- **List는 sequence이며 Mutable한 속성**을 가지고 있음
  - append, remove, reverse...등 한 method를 사용할 수 있지만.

```python
print("Mon" in days) #true
print(len(days)) #5
```



### tuple

- days = ("Mon", " Tue", "Wed", " Thur", "Fri")
- `print(type(days))` .... `<class 'tuple'>`
- Immutable 즉 한번 값을 설정해놓으면 바꿀 수 없음.
  - append, remove, reverse...등 한 method를 사용할 수 없겠네?

- **dictionary** key, value로 만들어진 구조

  ```python
  nico = {
    "name" : "Nico",
    "age" : 29,
    "korean" : True,
    "fav_food" : ["Kimchi", "Sshimi"]
  }
  
  nico["hansome"] = true
  print(nico)
  nico = {
    "name" : "Nico",
    "age" : 29,
    "korean" : True,
    "fav_food" : ["Kimchi", "Sshimi"],
    "hansome" : True
  }
  ```

  - value mutable
  - 그렇지만 key 값은 immutable



### function

- 행동을 반복해서 실행할 수 있는 것.

- how to define function?

```python
def say_hello(arguments):
  print("hello")
```

- python {} 으로 시작, 마무리를 결정짓지 않고, 들여쓰기를 통해 결정하므로 조심하자
- tab을 사용함.

```python
def say_hello(arguments):
  print("hello", who)
  
say_hello(man); #hello man
```

- def로 설정한 arguments갯수가 funciton을 실행할 때  없다면 오류가 나올 수 있음.
- 이럴경우 default 설정

```python
def minus (a, b=0):
  print(a-b)
minus(2) # 2
```



### Return

```python
def p_plus(a,b):
  print(a+b) 
  
def r_plus(a,b):
  return a + b
	print("adqwdasdas") #이줄은 실행되지 않는다. return이 실행되면 function은 종료됨.

p_result = p_plus(2,3) #None
r_result = r_plus(2,3) #5

print(p_result, r_result) # None, 5
```

- return키워드를 사용하면 function이 그 값으로 대치됨



### Keyword Arguments

```python
def say_hello(name,age):
  return f"Hello {name} you are {age} years old"

hello = say_hello(name= "nico", age="12")
print(hello)
```

- `f` , `{}` 을 통해 keyword가 자동으로 return값에 대입되도록 할 수 있음.



### Code Challenge

```python
def plus(a, b):
  return int(a)+int(b)
def minus(a, b):
  return int(a)-int(b)
def product(a,b):
 return int(a)*int(b)
def divide(a,b):
  return int(a)/int(b)
def negative(a):
  return -int(a)
def remainder(a,b):
  return int(a)%int(b)
def power(a,b):
  return pow(int(a),int(b))
r_plus= plus(a=2, b='3')
r_minus= minus(a=3,b=4)
r_product= product(a=4, b=5)
r_divide= divide(a='6',b='2')
r_negative= negative(a=3)
r_remainder= remainder(a=5,b=4)
r_power= power(a=2, b=3)
print(r_plus)
print(r_minus)
print(r_product)
print(r_divide)
print(r_negative)
print(r_remainder)
print(r_power)
```



### If-else

```python
def plus(a,b):
  if type(b) is int or type(b) is float:
    return a+b
  else:
    return None
```

- 참고 : https://tech.songyunseop.com/post/2017/09/python-comparing/

  is는 레퍼렌스 체크

  = 는 값 체크



### for

```python
days= ["mon", "tue", "wed", "thu", "fri"]

for day in days:
  if day is "wed":
    break #for loop를 멈춰라
  else:
    print(day)
for letter in "nicolas":
  print(letter) #가능 n i c o l a s 이렇게 나옴
```



### modules

- 라이브러리를 일컫는 말인듯.
- 필요한 기능을 import해서 우리가 써줌.

```python
import math #모든 math아래 모듈을 가져오게 됨. 비효율적

print(math.ceil(1.2)) #2
```

```python
from math import ceil, fsum as sexy_sum

print (sexy_sum([1,2,3,4,5,6,7]))
```

- as module이름을 재정의함. nick name :)

- print는 무한의 arguments를 받을 수 있음.

