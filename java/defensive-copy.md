
## 의미
- 방어적 복사.
	- 어떤 취약점을 막기 위한 복사 방법?

## 취약점
- TOCTOU(Time Of Check / Time Of Use)

```java
public final class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException("start가 end보다 늦으면 안된다");
        }
        this.start = start;
        this.end = end;
    }

    public Date getStart() { return start; }
    public Date getEnd() { return end; }
```

- `start.compareTo(end) > 0` 해당 코드 validation 이후에 `Date end` 를 수정할 수 있음.
	- Time of Check
- 혹은 사용 시점에 `Date start` or `Date end` 를 외부에서 수정할 수 있음.
	- 같은 주소값을 공유하는 인스턴스 이니.
	- 그러면 예상치 못한 결과가 초래됨.
- 결과적으로는 `final class Period` 로 선언했어도 **immutable한 클래스가 전혀 아님**.


## 사용하는 이유
- 취약점을 기반으로 생각해볼 때, 방어적 복사는, 인스턴스를 생성할 때, 매개변수를 받는 객체를 새로운 객체로 감싸서 복사하는 방법인듯.
- 즉 생성되는 객체에서 참조하고 있는 멤버 객체와, 외부에서 들어오는 객체의 의존성을 끊어주기 위함.

## 해결 방법

```java
public Period(Date start, Date end) {
    this.start = new Date(start.getTime()); // defensive copy
    this.end = new Date(end.getTime());     // defensive copy
    if (this.start.compareTo(this.end) > 0) {
        throw new IllegalArgumentException("start가 end보다 늦으면 안된다");
    }
}
```

- `new Date()`  객체의 생성자로 새로운 인스턴스를 생성.
	- 외부 참조를 끊음 -> defensive copy


## 참고
- <https://johngrib.github.io/wiki/defensive-copy/>
- <https://abcstudyguide.com/java-defensive-copying/>