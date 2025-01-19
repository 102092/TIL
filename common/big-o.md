#algorithm

- `O` -> Order
- order of complexity
- 알고리즘을 실행하는데 걸리는 **최대 시간**
![image](https://www.freecodecamp.org/news/content/images/2021/06/1_KfZYFUT2OKfjekJlCeYvuQ.jpeg)

## O(1)
- 상수형 알고리즘
- 데이터 입력량이랑 무관하게, 실행 시간이 일정

## O(logn)
- 로그형 알고리즘.
- 데이터 입력량이 늘어날 수록, 단위 입력랑 실행 시간이 줄어듬.

## O(N)
- 선형 알고리즘
- 데이터 입력량에 비례해서, 실행 시간이 증가

## O(nlogn)
- 선형-로그 알고리즘.
- 데이터 입력량이 n 배 늘어나면, 실행시간은 n배 보다 조금 더 늘어남.

## O(n^2)
- 2차 알고리즘
- 데이터 입력량의 제곱에 비례해서 실행시간 증가.

## O(2^n)
- 지수형 알고리즘.
- 데이터 입력이 추가로 될 때마다, 2배씩 실행시간이 늘어남.


## O(n!)
- 팩토리얼 알고리즘.
- 데이터 입력이 추가 될 때 마다, 실행시간이 n배로 늘어남


> 성능

- 위 순서대로 성능상 이점이 있음.
- 즉 O(1) 이 가장 성능이 좋고, O(n!) 이 가장 성능이 나쁨.


# 참고
- https://www.freecodecamp.org/news/big-o-notation-why-it-matters-and-why-it-doesnt-1674cfa8a23c/