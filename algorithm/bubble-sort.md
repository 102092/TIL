# 정의
- 왜 이런 이름?
    - 정렬 중에, 배열에서 가장 큰 요소가 맨 뒤로 이동 (Bubble up) 되기 때문에 
- 시간 복잡도
    - O(N^2)


# 코드
```java
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 0, 3};
        sort(arr);
        System.out.println(arr);
    }

    public static int[] sort(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

```


# 참고
- https://st-lab.tistory.com/195