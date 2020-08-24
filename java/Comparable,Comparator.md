# Comparable
- interface
- 정렬 수행 시에, 기본적으로 적용되는 인터페이스
  - `Integer`, `Double` 은 오름 차순 정렬
  -  `String` 은 사전순으로 정렬된다.
- 어떻게 구현하는가?
  - 정렬할 **객채** 에 `implements` 를 통해, `compareTo()` 메서드를 오버라이드 하여 구현한다.
  - ComparaTo() 작동방법
    - **음수, 또는 0** 이면 객체의 자리가 그대로 유지되며, **양수** 일 경우 , 파라미터로 넘어온 객체와 자리가 바뀐다.
    - 현재 객체 < 파라미터로 넘어온 객체 : 음수 리턴... --> 현재객체 자리가 유지된다.
    - 현재 객체 == 파라미터로 넘어온 객체 : 0 리턴.. --> 현재 객체의 자리가 유지된다
    - 현재 객체 > 파라미터로 넘어온 객체 : 양수 리턴 --> 파라미터로 넘어온 객체와 자리가 바뀐다.
 - 인터페이스가 구현된 메서드
  - Arrays.sort();
  - Collections.sort()


## Arrays.sort vs Collections.sort 

- Arrays.sort의 경우
  - byte[], char[], double[]등 Object Array에서 **배열 정렬**의 경우 TimSort(MergeSort + Insertion SOrt) 를 사용한다.
  - Primitive Array에서는 Dual pivot + QuickSort(Quick Sort, Insertion Sort)를 사용한다.
- Collections.sort의 경우
  - ArrayList, LinkedList, Vector 자료구조에서 내부적으로 Arrays.sort를 사용한다.
  
## 예시 코드
```java
class Point implements Comparable<Point> {
    int x, y;

    @Override
    public int compareTo(Point p) {
        if(this.x > p.x) {
            return 1; // x에 대해서는 오름차순
        }
        else if(this.x == p.x) {
            if(this.y < p.y) { // y에 대해서는 내림차순
                return 1;
            }
        }
        return -1;
    }
}

// main에서 사용법
List<Point> pointList = new ArrayList<>();
pointList.add(new Point(x, y));
Collections.sort(pointList);
```
- x좌표가 증가하는 순, x좌표가 같으면 y좌표가 감소하는 순으로 정렬하는 코드

---



# Comparator
- interface
- Comparable을 구현하면 기본적으로 **오름차순** 정렬인데, 이와 다르게 사용하고 싶을 떄 사용한다?
- 익명클래스로 많이 이용됨.
- 어떻게 구현하는가?
  - `compare()` 메서드를 오버라이드 한다!
  - 파라미터끼리 비교하는 컨셉
  - 첫번째 파라미터 객체 < 두번쨰 파라미터 객체 : 음수 리턴 --> 자리 안 바뀜
  - 첫번째 파라미터 객체 == 두번째 파라미터 객체 : 0 리턴 --> 자리 안바뀜
  - 첫번쨰 파라미터 객체 > 두번쨰 파라미터 객체 : 양수 리턴 --> 자리 바뀜

- 사용방법은?
  - Arrays.sort(arry, myComparator)
  - Collections.sort(list, myComparator)

- 특이한것!
  - PriorityQueue 생성자 두번째 인자로 Comparator 를 받을 수 있음!
  - 즉 **우선순위** 기준을 정해줄 수 있따
  

 ## 예시 코드
 ```java
 class MyComparator implements Comparator<Point> {
  @Override
  public int compare(Point p1, Point p2) {
    if (p1.x > p2.x) {
      return 1; // x에 대해서는 오름차순
    }
    else if (p1.x == p2.x) {
      if (p1.y < p2.y) { // y에 대해서는 내림차순
        return 1;
      }
    }
    return -1;
  }
}

// main에서 사용법
List<Point> pointList = new ArrayList<>();
pointList.add(new Point(x, y));
MyComparator myComparator = new MyComparator();
Collections.sort(pointList, myComparator);
 ```
 - 좌표가 증가하는 순, x좌표가 같으면 y좌표가 감소하는 순으로 정렬


 ```java
 Comparator<Point> myComparator = new Comparator<Point>() {
  @Override
  public int compare(Point p1, Point p2) { 위와 동일 }
};

List<Point> pointList = new ArrayList<>();
pointList.add(new Point(x, y));
Collections.sort(pointList, myComparator);
````
- 익명클래스로 구현한 방법
- 두개의 차이가 있다면..?
- 둘다 인터페이스
- 매개변수를 몇개 받는가 차이...?



# 참고

- https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html