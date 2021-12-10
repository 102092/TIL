# 두 날짜 사이의 기간(period) 구하기

```java
LocalDate today = LocalDate.now(); // 오늘 날짜를 구할때 사용한다
LocalDate hiredDate = LocalDate.of(2015, 6, 29);
// 입사일로부터 오늘까지의 날짜 차이 계산
Period period = hiredDate.until(today);
System.out.println(period.getYears());  // 2년
System.out.println(period.getMonths()); // 3개월
System.out.println(period.getDays());   // 21일
```
- `getYears()` 연도
- `getMonth()` 개월
- `getDays()` 일수
  - 연도와 개월을 뺸 나머지(일수)가 반환된다.
  - 해당 기간 전체의 일수를 리턴하는 것이 아님.
  



# 두 날짜 사이의 전체 일수를 구하려면?

```java
long days = ChronoUnit.DAYS.between(hiredDate, today);
System.out.println(days);    // 884일
```

- `ChronoUnit` 클래스를 사용하자
- `between` 메서드를 통해, 전체 일 수를 구할 수 있다. (이른시간이 앞에, 늦은 시간이 뒤에 오도록!!)
  - ChronoUnit.YEARS : 년
  
  - ChronoUnit.MONTHS : 월
  
  - ChronoUnit.WEEKS : 주
  
  - ChronoUnit.DAYS : 일
  
  - ChronoUnit.HOURS : 시간
  
    


# LocalDateTime을 LocalDate 으로 변환할때
- 서로 다른 타입을 계산하려고 하면 오류가 생김
- 즉 같은 타입으로 일치 시켜야 한다.



# 참고
- http://june0313.github.io/2017/10/19/java8-date-compare
- http://yoonbumtae.com/?p=675

