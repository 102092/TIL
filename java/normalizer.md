# unicode?

- 숫자와 글자가 1(key):1(value)로 매핑된 표
- 아스키코드의 `0x41` = `A`로 맵핑된 것 처럼, 아스키 코드로 표현할 수 없는 문자들을 숫자로 맵핑해놓은 것 (전세계 문자 대상)
- 한글의 경우 조합형을 위한 자모, 완성형을 위한 한글이 모두 포함되어있음.
- 숫자에 `U+` 접두어가 붙어있으면 유니코드로 맵핑되어있는 숫자라는 의미인듯.
    - `U+0041` = `A`

## UTF-8, UTF-16 ?

- 숫자로 이루어진 키를 어떻게 표현하는 지 결정하는 **인코딩** 방식
- `A` 라는 문자는..
    - `UTF-8` 에서는 `0x41`로 표현됨 
        - 가변바이트 1~4 byte 사용하고 있는데,A의 경우 1바이트로 표현이 가능하기 떄문에)
        - 즉 U+0041 -> 0x41 로 인코딩 되는 의미인듯
    - `UTF-16` 의 경우, `0x0041` 로 표현됨.
        - 마찬가지로 가변바이트 2~4 byte


## 참고
- https://norux.me/31
- https://namu.wiki/w/UTF-8

# normalizer?
- 표현 방법이 다른 문자들을 통합 혹은 정리를 의미하는듯.
- 즉 이모지, 특수문자등을 제거 혹은 공백으로 대처하는 작업을 말하는 듯.
- 왜 필요함?
    - OS 별로 사용하는 unicode 정규화 방식이 다른 경우가 있는듯. (i.g max os에서 만든 한글 파일을, 윈도우에 전송하면 자모가 분리되어있는 경우)
    - 그래서 이 부분은 하나로 통합해주는 게 필요함. 

- 4가지 유니코드 텍스트를 정규하는 방식이 있음.
    1. NFC: Normalization Form Canonical Composition
        - 코드를 정준 분해 -> 정준 결합
    2. NFD: Normalization Form Canonical Decomposition
        - 코드를 정준 분해
        - 즉 발음 구별 기호가 붙은 문자가 하나로 처리되었을 경우에 나누어 처리(정규화) 함.
    3. NFKC: Normalization Form Compatibility Composition
    4. NFKD: Normalization Form Compatibility Decomposition

![](https://user-images.githubusercontent.com/71244638/179165772-0174ee1c-003a-4bee-b353-598f532beb3a.png)

- 위 첨부된 스크린샷을 보면 `o` 문자위에 부호가 있음.
- 이러한 문자가 4가지 방식에 따라 어떻게 정규화 되는지 보여줌

- 자바에서는 `java.text.Normalizer` 클래스에서 해당 기능을 제공하고 있음.
    - This class provides the method normalize which transforms Unicode text into an equivalent composed or decomposed form




## 참고
- https://docs.oracle.com/javase/7/docs/api/java/text/Normalizer.html#:~:text=This%20class%20provides%20the%20method,%2315%20%E2%80%94%20Unicode%20Normalization%20Forms.
- https://docs.oracle.com/javase/tutorial/i18n/text/normalizerapi.html
- https://velog.io/@leejh3224/%EB%B2%88%EC%97%AD-%EC%9C%A0%EB%8B%88%EC%BD%94%EB%93%9C-%EC%8A%A4%ED%8A%B8%EB%A7%81%EC%9D%84-%EB%85%B8%EB%A9%80%EB%9D%BC%EC%9D%B4%EC%A7%95-%ED%95%B4%EC%95%BC%ED%95%98%EB%8A%94-%EC%9D%B4%EC%9C%A0
- https://www.hungrydiver.co.kr/bbs/detail/develop?id=68&scroll=comment
