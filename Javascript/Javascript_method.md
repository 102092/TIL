# Javascript_Method

> 공부하면서 기억하면 좋을만한 메소드와 그 해석을 정리.



### 1. Array 매소드 

#### - Reduce 

> **reduce()** 메서드는 배열의 각 요소에 대해 주어진 **리듀서**(reducer) 함수를 실행하고, 하나의 결과값을 반환합니다.

 

```javascript
const array1 = [1, 2, 3, 4];
const reducer = (accumulator, currentValue) => accumulator + currentValue;

// 1 + 2 + 3 + 4
console.log(array1.reduce(reducer));
// expected output: 10

// 5 + 1 + 2 + 3 + 4
console.log(array1.reduce(reducer, 5));
// expected output: 15
```

- function(accumulator, currentValue, currentIndex, array)

- accumulator 콜백의 반환값을 누적

- currentvalue 처리할 현재 요소.

- currentindex

- array

 

##### 객체 배열에서의 값 합산

> 객체로 이루어진 배열에 들어 있는 값을 합산하기 위해서는 반드시 초기값을 주어 각 항목이 여러분의 함수를 거치도록 해야 합니다.

 

```javascript
var initialValue = 0;
var sum = [{x: 1}, {x:2}, {x:3}].reduce(
    (accumulator, currentValue) => accumulator + currentValue.x
    ,initialValue
);

console.log(sum) // logs 6
```

- initialValue를 제공한 경우, accumulator는 initialValue와 같고 currentValue는 배열의 첫 번째 값과 같습니다

- accumulator =0 , currentvalue = 1로 시작한다는 말.

### * navigator 객체.

```javascript
navigator.geolocation.getCurrentPosition(success콜백, error콜백, options);

function success(pos){ //pos객체가 인자로 넘어옴
    pos.coords.latitude;//위도
    pos.coords.longtitude;//경도..이외도 많음.
}
function error(error){
	error.message...
    error.code...
}
```

