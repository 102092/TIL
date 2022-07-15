# high-ASCII characters ?

- Non-ASCII characters 를 의미하는 듯.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FxwtrN%2FbtqF1nHXx6x%2FCXyhbK53t0BdTjcRyPkTY1%2Fimg.png)

- 0x0 ~ 0x7F 밖의 문자를 지우고 싶으면.. (all non-US-ASCII )
- 아래와 같이 코드 작성하면 됨.

```java
s = s.replaceAll("[^\\x00-\\x7f]", "");
```


# 참고
- https://stackoverflow.com/questions/5008422/how-to-remove-high-ascii-characters-from-string-like-in-java
- https://developer-p.tistory.com/72