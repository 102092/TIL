- boolean array가 있을 때, natureOrder, reverseOrder가 어떻게 정렬되는지 확인.

```java
List<Boolean> booleans = Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE);
booleans.sort(Comparator.naturalOrder());
System.out.println(booleans); // [false, false, true]
```

```java
List<Boolean> booleans = Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE);
booleans.sort(Comparator.reverseOrder());
System.out.println(booleans); // [true, false, false]
```
