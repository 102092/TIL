# Python fundamental

#### 정리목록

0. [데이터 분석을 위한 파이썬 철저입문](<http://www.yes24.com/Product/goods/63033697>) - 기본

1. [Python_자습서](<<https://docs.python.org/ko/3/tutorial/index.html>>) - 기본
2. [Python_wiki](<https://wikidocs.net/17090>) - 참고



## 1. 파이썬은?

- 쉽고, 무료, 방대한 라이브러리, 어느 운영체제에서도 사용할 수 있음.
- 주석기호 `#`



#### 1.1 설치

- [아나콘다](<https://www.anaconda.com/distribution/>)

  - 파이썬 2.x, 3.x서로 완벽하게 호환되지 않음. 3버젼대는 유니코드를 지원해서 한글을 읽고 쓰기게 편해졌음. 

  - <u>주피터 노트북 기억해야할 단축키</u>

    ```
    shift + enter : 현재 셀 수행하고 아래 셀 선택, if 아래에 셀 없으면 새로운 셀 추가
    alt + enter : 현재 셀 수행하고 아래에 새로운 셀 추가
    ctrl + enter : 현재 셀 수행, 아래 셀 추가 선택 없음
    ctrl + / : 주석/비주석 처리
    ```

    

- [파이참](<https://www.jetbrains.com/pycharm/download/>)



#### 1.2 기타

- 거듭제곱은 `5 **2` 이런식으로

- 진수변환법 

  10진수 에서 해당 진수로,

  - 2진수? `bin()`

  - 8 진수? `oct()`

  - 16 진수? `hex()`
  - 해당 함수의 output은 문자열로 줌.

- 논리연산자




## 2. 변수 ,자료형

#### 2.1 변수

- 변수 생성 규칙

  1. 문자, 숫자, 밑줄기호(_) 를 사용해서 만들 것. 다만 특별한 경우를 제외하고 밑줄기호로는 시작하지 말자.
  2. 숫자로 시작하는 변수명은 만들 수 없다.
  3. 대소문자 구분 할것
  4. 공백을 포함할 수는 없음.

- 문자열

  1. '', ""로 묶여있는 것.

     - 만약 문자열 안에 큰 따옴표, 작은 따옴표를 포함하려면? 

       `'this is a "double" quotation test'` 요런식으로 번갈아가면서 쓰던가

     - 삼중 따옴표를 사용하면, 큰,작음따옴표를 동시에 쓸 수 있음.

     - 한글도 문자열에 이용할 수 있음. 왜? 파이썬 3.x는 유니코드를 지원해서.
     
  2. 문자열은 +, *연산자 사용 가능함., 곱하면 그만큼 문자열을 반복하게 됨.
  
  
#### 2.2 자료형

- 리스트 []

  `student = [90,95,85,80]` 

  index는 0부터 시작. 마지막 요소는? `student[-1]`

  리스트 특정 항목을 변경하려면? `student[i] = 특정 값`

  <u>리스트는 다양한 타입의 데이터들로 구성할 수 있음. 즉 숫자,문자가 공존할 수 있음.</u>

  리스트 끼리 덧셈, 곱셈 가능함.

  ```python
  list_con1 = [1,2,3,4]
  list_con2 = [5,6,7,8]
  list_con1 + list_con2 = [1,2,3,4,5,6,7,8] #덧셈은 두개의 리스트를 연결함.
  
  list_con1 * 2 = [1,2,3,4,1,2,3,4]  #곱셈은 반복하고
  ```

  - 리스트에서 항목 삭제? `del 리스트[i]` 를 이용

  - 리스트에서 특정 항목이 있는지 알아보려면 ? `항목 in 리스트`

  - **기억해야할 리스트 매서드**

    ```python
    append(값) #리스트에서 항목하나를 맨 마지막에 추가
    insert(위치, 값) #특정 위체 값을 삽입
    extend([값1,값2...]) #항목 여러개를 맨 마지막에 추가
    remove(값) #입력값과 일치하는 첫번째 항목을 리스트에서 제거
    pop() #리스트에서 마지막 항목을 제거한다음에 반환
    index(값) #입력값과 일치하는 첫번째 항목의 위치를 반환
    count(값) #리스트에서 입력값이 몇개나 있는지 반환
    sort() #숫자,문자열을 순방향으로 정렬
    reverse() #리스트 항목을 끝에서부터 역순으로 정렬
    ```

- 튜플 ()

  튜플 생성 `tuple1 = (1,2,3,4)`

  <u>한번 생성된 튜플은 변경하거나 삭제할 수 없음</u>

  `변수명[i]`로 튜플의 특정 요소 지정할 수 있음.

  `index(), count()` 메서드는 사용 가능



- 세트 {}

  세트 생성 `set1 = {1, 2, 3}`

  수학의 집합 개념. 

  리스트나 튜플과 다른점? **데이터의 순서가 없고, 데이터를 중복으로 쓸 수 없다는 점.**

  교집합, 합집합, 차집합을 구할 수 있음.

  	1. `A.intersection(B)` A와 B의 교집합
   	2. `A.union(B)` A와 B의 합집합
   	3. `A.difference(B)` A와 B의 차집합



- 리스트, 튜플, 세트간 타입 변환

  1. 리스트에서 튜플로?

  ```python
  a = [1,2,3,4,5] #리스트 생성
  b = tuple(a) #리스트 -> 튜플
  return b # (1,2,3,4,5)
  ```

  2. 리스트 에서 세트로?

  ```python
  c = set(a) #리스트 -> 세트
  return c # {1,2,3,4,5}
  ```

  선언해주고 넣어주면 끝.



- 딕셔너리

  항상 `key`, `value` 값으로 구성됨. 

  리스트나 튜플은 인덱스를 이용해서 내용물을 다뤘지만,

  딕셔너리는 `key` 을 이용해서 다룸.

  리스트 튜플 인덱스는 0부터 시작했지만

  딕셔너리의 `key` 는 임의의 숫자, 문자열이 될 수 있음.



​		딕셔너리 생성 : `dict_name = {key : value, key2 : value2....}`

​		`value`값을 얻고 싶을 때는? `dict_name["key"]`

​		딕셔너리 안에는 `숫자, 문자열,튜플, 리스트, 또다른 딕셔너리`등 다양한 데이터를 사용할 수 있음.



  1. 딕셔너리 다루기

     - 추가,변경하기 : `dict_variable[key] = new value`
     - 삭제하기 : `del dict_variable[key]` ? 해당 키와 쌍을 이루는 `value` 값도 삭제됨.

  2. 딕셔너리 메서드

     ```python
     key() #딕셔너리 키 전체를 리스트 형태로 변환
     values() # 값 전체를 리스트 형태로
     items() # 키와 값의 쌍을 (키,값) 형태의 튜플로
     update(idct_date2) # 딕셔너리에 입력된 딕셔너리를 추가
     clear() #딕셔너리 모든 항목 삭제
     ```
     
     
     
     

## 3. 제어문

#### 3.1 if문

```python
if x >= 90:
    print...
```

- 비교연산자 = , !=, < , > , <=, >=
- 논리연산자 and, or, not



```python
if<조건문> :
    <실행될문장>
else:
    <if문이 성립하지 않으면 실행될 문장>
```



#### 3.2 for문

```python
for <반복변수> in <반복범위> :
    <코드블럭>        
```

- `리스트[]`는 반복범위에 사용가능

- `range(start, stop, step)` 함수

  ```python
  print(list(range(0,10,1))) #같음 range(10), range(0,10)
  #out [0,1,2,3,4,5,6,7,8,9]
  ```

- 여러개의 리스트 다루기

  리스트가 한개라면 `for` 문의 반복범위를 잉해서 출력할 수 있지만 리스트가 2개면??

  `len()` 함수를 이용해서(리스트,튜플,세트,딕셔너리 항복 갯수를 셀수 있는)

  ```python
  names = ['james','Robert','Lisa','Mary']
  scores = [95,96,97,98]
  
  for k in range(len(names)) #names배열만큼 돔 즉 4번 돌고 k가 0~3까지
  print(names[k],scores[k])
  
  ```



#### 3.3 while 문

```python
while <조건문> :
    <코드블록>
#조건문 만족하면 코드블록 계속 실행, 아니면 빠져나옴
```

- 무한반복 시키고 싶을때는? <조건문>에 `true` 이라고 쓴다.

- `break?` 반복문을 빠져나오고 싶을때

- `continue` 반복분의 처음으로 돌아가서 다음 반복을 진행함.

  ```python
  k = 0
  while True:
      k = k+1
      
      if(k=2):
          print("continue next")
          continue
      if(k >4):
          break
      print(k)
      
  #out?
  #1
  #continue next
  #3
  #4
  ```



#### 3.4 한줄 for 문

- 리스트,세트,딕셔너리 컴프리헨션. 해당 배열구조는 한 줄 for문을 지원함.

- `[반복실행문 for 반복변수 in 반복범위]`

  ```python
  numbers =[1,2,3,4,5]
  square = []
  
  for i in numbers:
      square.append(i**2)
      
  #위아래 같은 코드
  
  numbers =[1,2,3,4,5]
  square =[i**2 for i in numbers]    
  ```

  

- `[반복실행문 for 반복변수 in 반복범위 if 조건문]`]

  ```python
  numbers =[1,2,3,4,5]
  square = []
  
  for i in numbers:
  	if i>=3:
          square.append(i**2)
      
  #위아래 같은 코드
  numbers =[1,2,3,4,5]
  square = [i**2 for i in numbers if i>=3]
  ```

  


## 4. 입출력

- 기본출력 `print()`

- `print()` 안에 `\n` 넣으면 enter 효과

- `print("best", "python", "book", sep ="-:*:-")`

  `best-:*:-python-:*:-book`로 아웃풋됨. sep에 원하는 인자를 지정하면. 비워두면 **빈칸**이 기본

#### 4.1 형식지정출력

- 문자열 %s, 정수 %d or %i, 실수 %f or %F (기본적으로 소수점 6자리까지 표시)

- `print("%type %type" % (data1, data2))`

- 형식 지정 문자열에서 출력 위치를 지정해주는 방법

  - print("{0} {1} {2}...".format(data_0, date_1, data_2...))

  ```python
  animal_0 = "cat"
  animal_1 = "dog"
  
  print("Animal : {0}".format(animal_0)) # Animal : cat
  print("Animal : {0},{1}".format(animal_0,animal_1)) # Animal : cat,dog
  print("Animal : {},{}".format(animal_0,animal_1)) # Animal : cat,dog
  ```

  ```python
  name = "tomas"
  age = 10
  a = 0.123456798013245987
  fmt_string ="String: {0}. Integer Number {1}. Floating Number {2}" #출력 형식을 지정해주고
  print(fmt_string.format(name,age,a)) #순서대로 넣어라
  
  #String: tomas. Integer Number 10. Floating Number 0.123456798013245987
  ```

- 형식 지정 문자열에서 숫자 출력 형식 지정

  ```python
  a = 0.1234567890123456789
  print("{0: .2f},{0: .5f}".foramt(a)) #출력형식지정
  # 0.12, 0.12345
  ```

#### 4.2 입력

- `data = input("문자열")` 기본형식

  ```python
  b = input("정사각형 한변의 길이는?")
  area = int(a) **2
  print("정사각형 넓이: {}".format(area)) #입려되는 숫자의 타입을 모를때는 큰거 써라float
  ```



#### 4.3 읽고 쓰기

- `f = open('file_name', 'mode')` 읽기

  - mode에는.. 

  ![](http://1p9tpk1c3jcx2qvybv1oynit.wpengine.netdna-cdn.com/wp-content/uploads/2011/09/python_file3.png)

  

- ```python
  f = open('file_name,' 'w') #읽고 쓰기 모드 같은 이름의 파일이 있으면 기존 내용 모두 삭제
  f.write(str) #str문자열을 쓰고
  f.close() #f객체를 없애주고
  ```



- 파일에서 문자열 한줄씩 읽으려면? `readline()`

- with문을 통해

  ```python
  with open('file_name' ,'mode') as f:
      <코드블럭>
  ```

  

## 5. 함수

- 기본구조

  ```python
  def 함수명 ([인자1, 인자2....]):
      <코드블럭>
      [return <반환값>]
  ```

  예시

  ```python
  def my_func():
      print("my first function!")
  # my_func() 실행시 my first function! 출력
  
  def my_friends(friendName):
      print("{}는 나의 친구!".format(friendname))
  #my_friends("영미") 영미는 나의 친구 출력
  
  def my_calc(x,y):
      z = x*y
      return z
  # my_calc(3,4) 12 출력
  ```

- 변수의 유효범위

  1. 전역변수

  2. 지역변수, 함수 생성시 같이 생성되었다가 함수가 끝나면 살아지는 변수



#### 5.1 람다함수

- `(lamda <인자> : <인자 활용 수행 코드>) (<인자>)`

  - 람다를 다른 변수에 할때는 람다 함수 전체를 소괄호로 감싸지 않아도됨.

  ```python
  (lamda x : x**2) (3)
  # out 9
  
  mySquare = lamda x : x**2
  mySquare(2)
  # out 9
  ```



#### 5.2 유용한 내장함수

- 형변환함수

  1. 정수형으로 변환 `int()`, 실수에게 쓸 경우 소수점 이하는 버리게됨.

     `int(0.123)` ? 0

  2. 실수형으로 변환 `float()` 

     `float(123)` ? 123.0

  3. 문자형으로 변환 str()

     `str(123)` ? '123'

  4. **리스트,튜플 세트형으로 변환**

     `list(), tuple(), set()`

     서로서로 변환가능 리스트 -> 튜플, 세트형 / 튜플 -> 리스트 세트형 / 세트 -> 리스트 ,튜플

  

- bool 함수

  숫자 0 이면 `false`, 0이외의 숫자(양음정수 양음실수)는 `true`

  문자열인 경우, 문자열이 있으면 `true` 없으면 `false`

  단! 공백문자열은 문자열이 있는 것이고, 빈문자열('') 은 문자열이 없는 것. 그리고 `none`은 아무것도 없는 것으로 간주함.



- 최대,최소함수

  `max(),min()`은 리스트,튜플,세트 의 항목이나 문자열 중에서 최대 최솟값을 구함.

  단 로마자 알파벳 A~Z , a~z순서

  숫자와 로마자 알파벳을 비교했을 때 숫자가 더 작다.



- 절대값, 전체합

  `abs()` 절대값

  `sum()` 전체합



- 항복을 수하는 함수

  `len()` 문자열, 리스트[], 튜플[], 딕셔너리{}에서 사용



## 6. 객체와 클래스

#### 6.1 객체

- 파이썬은 객체지향 언어 OOP,

- 객체는 클래스의 인스턴스.

  - 붕어빵을 만드는 틀이 클래스라면, 객체는 붕어빵. 다만 단팥, 크림등등..속성이 다를 수 있지

  ```PYTHON
  class 클래스명():
  	변수1 #클래스의 변수
      
      def 함수() : #클래스 함수
          코드블록
  ```

  - 클래스에서 정의한 함수를 객체 생성후 이용할 떄는 메서드라고도 함.

  ```python
  class Bicycle():
      
      def move(self, speed):
          print("자전거 : 시속 {0}킬로미터로 전진".format(speed))
      def turn(self, direction):
          print("자전거 : {0}회전".format(direction))
      def stop(self):
          print("자전거({0},{1}) : 정지".format(self.wheel_size, self.colr))
          
  my_bicycle = Bicycle() #객체 생성
  #객체의 속성을 설정하려면?
  my_bicycle.wheel_size = 26
  my_bicycle.color = 'black'
  
  #객체의 변수에 접근해서 객체의 속성을 가져오려면?
  print("바퀴크기는?",my_bicycle.wheel_size) # 바퀴크기는?26
  
  #객체의 매서드를 호출하려면?
  my_bicycle.move(30) #자전거 : 시속 30킬로미터로 전진.
  my_bicycle.stop() #자전거(26,black) : 정지 self인자만 들어감.
  ```



- 객체 초기화

```python
def __init__(self,wheel_size,color):
	self.wheel_size = wheel_size
    self.color = color
#__init__이용, 받는 인자들로 초기화.    
```



#### 6.2 클래스

- 클래스에서 사용하는 변수
  - 사용하는 위치에 따라, 클래스 변수와 인스턴스 변수로 구분.
  - 클래스변수는 *클래스.변수*로 접근하고
  - 인스턴스변수는 *객체.변수*로 접근

- 클래스에 사용하는 함수

  - **인스턴스메서드, 정적메서드, 클래스 메서드**

  

  1. 인스턴스 메서드

     - 각 객체에서 개별적으로 동작하는 함수를 만들고자 할 때 사용함.

     - 인스턴스 메서드는 `self` 를 이용해 인스턴스 변수를 만들고 사용

       ```python
       class 클래스명():
       	def 함수명(self,[인자...]):
               self.변수명1 = 인자1
               self.변수명2 = 인자2...
               
       # 객체 생성후 호훌 할 수 있음.
       객체명 = 클래스명()
       객체명.메서드명([인자1,인자2...])
                         
       ```

  2.  정적 메서드

     - 클래스와 관련있음. 클래스 안에 두긴 하지만, 클래스나 클래스의 인스턴스와는 무관하게 독립적으로 동작하는 함수를 만들고 싶을 때 사용.
     - `staticmethod`를 선언

     ```python
     class 클래스명():
     	@staticmethod
         def...
     ```

  3. 클래스 메서드

     - 클래스변수를 사용하기 위한 함수. 첫번째 인자로 `cls` 를 받고
     - `classmethod`선언
     - 생성된 객체의 갯수를 반환하는 등의 클래스 전체를 관리해야할 기능을 여기에 선언함

     ```python
     class 클래스명():
         @classmethod
         def...
     ```

  4. 클래스 상속

  ```python
  class 자식클래스 이름(부모 클래스 이름):
      코드블록
  ```

  ```python
  class Bicycle():
      
      def __init__(self,wheel_size,color):
          self.wheel_size = wheel_size
          self.color = color
      
      def move(self, speed):
          print("자전거 : 시속 {0}킬로미터로 전진".format(speed))
      def turn(self, direction):
          print("자전거 : {0}회전".format(direction))
      def stop(self):
          print("자전거({0},{1}) : 정지".format(self.wheel_size, self.colr))
  
          
  class FoldingBicycle(Bicycle): #상속받았음.
      
     def __init__(self,wheel_size,color,state): #초기화
      Bicycle.__init__(self,wheel_size,color) #Bicycle 초기화 기능 재사용
      #super()...으로도 사용가능
      self.state = state #자식 클래스에서 새로 추가된 인자
      
      def fold(self):
  		self.state ='folding'
          print("자전거 : 접기,state ={0}".format(self.state))
          
      def unfold(self):
  		self.state ='unfolding'     
          print("자전거 : 펴기,state ={0}".format(self.state))
  ```

  ```python
  fb = FoldingBicycle(27,'white','unfolding') #객체 생성
  
  fb.move(20) #부모클래스에서 함수를 호출 한것
  fb.fold() #자식클래스에서 정의한 함수를 호출한것.
  ```



## 7.  모듈

- 상수, 변수,함수,클래스를 포함한 코드가 저장된 파일을 일컫음.

```python
%%writefile 주소\my_first_module.py

def my_function():
    print("this is my first module")    
```

- 모듈은 `import`를 이용해서 불러옴.
- `import my_first_module`
- `from 모듈명 import *` 모듈 내 모든 변수,함수,클래스를 불러옴.
- `import 모듈명 as 별명` 



#### 7.1 내장 모듈

1. 난수 발생 모듈

   - `import random`
   - `ramdom.ramdon()` 0.0 <= 실수 <1.0 범위 임의의 실수를 반환
     - `randint(a,b)` a<=정수 <=b 범위의 임의의 정수를 반환
     - `randrange(start, stop, step)` 
     - `sample(population, k)` 모집단에서 중복되지 않는 k개 인자를 반환


2. 날찌,시간관련 모듈

   - `import datetime`
   -  date = year, month, day , time = hour,minute, second 가 있음.
   - `now = datetime.datetime.now()` 현재시각을 구하는..
