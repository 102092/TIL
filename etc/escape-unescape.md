# escape, unescape
- 탈출, 도피, 모면
- 뭔가를 피하기 위해 사용한다고 볼 수 있을듯.

# 설명
- 특정 문자는 특수한 기능으로 사용하겠다고 **약속** 되어있음
- 예를 들면 웹에서는 URL, `http://a.com?name=egoing&job=programmer&job=programmer` 에서 보면, `&` 문자는 파라미터를 구분하는데 사용하고 있음.
- 그런데 `http://a.com?name=egoing&job=programmer&blogger` 이런 형식의 URL이 온다면? `programmer&blogger` 에서 사용된 `&` 특수한 기능을 목적으로 사용된 것이 아님. 
    - 그냥 문자 그대로 사용하고 싶은 것.
- 이런 문제가 생기는 것을 막기 위해서 (회피 하기 위해서), 이러한 웹에서는 특수한 목적으로 사용되도록 약속되었지만 *그냥 문자* 로 사용하기 위해서는 변환, 치환해줘야한다.
    - `http://a.com?name=egoing&job=programmer%26blogger`
    - & -> %26 으로 되었음. (encodeURL)
    - 이러한 과정을 이스케이핑 이라 부른다.
- 정리하자면,
    - ecsape 란, 특정 문자(약속된 문자) 를 약속된 목적이 아닌 다른 목적(그냥 문자)로 사용하기 위해서 치환해주는 것을 의미.
    - unecsape 란, ecsape 된 문자 (치환된 문자) 를 원래 문자로 되돌리는 작업.

# Javascript
- `encodeURI()`
    - Not Escaped: `A-Z a-z 0-9 ; , / ? : @ & = + $ - _ . ! ~ * ' ( ) #`
    - 위 문자를 제외한 모든 문자를 UTF-8로 치환,인코딩 한다 (escape)

- `decodeURI()`
- 참고 문서 :  https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/encodeURI

# HTML , Java.. etc..
- 해당 언어에서 설정한 약속된 문자가 있고, 사용자가 해당 약속된 문자를 *그냥 문자* 로 사용하고 싶을 때는 이스케이핑을 해야함.
- 즉 환경에 따라서, 약속된 문자 다르다는 걸 알 수 있을듯.

# 정리
- 단어에서 나타나듯이, 뭔가를 피하기 위해서임.
- 그 뭔가가 무엇이냐? 약속된 문자임.
- 약속된 문자지만, 그 용도로 사용하고 싶지 않을 때 `escape` 를 사용한다고 보면 될듯.
- 그리고 탈출된 문자들을, 정상으로 돌리고 싶을 때 (약속된 문자들로), `unescape` 한다고 보면 될 듯함.


# 참고
- https://opentutorials.org/course/50/199#:~:text=unescape%EB%8A%94%20escape%EB%A1%9C%20%EC%9D%B4%EC%8A%A4,%EB%8A%94%20decodeURI%2C%20decodeURIComponent%EA%B0%80%20%EC%9E%88%EB%8B%A4.
- https://steady-snail.tistory.com/111
- https://starrecode.tistory.com/11