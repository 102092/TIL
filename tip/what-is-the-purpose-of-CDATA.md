- `mybatis` sql문에서 종종 보던 구문.
- 해당 구문은 왜 필요한가?
## 정의
- 문자형 데이터 (Character data)
- 특수 문자를 문자열로 인식하도록 하는 기능

## 예시

```xml
<select id="findAll" resultMap="MemberResultMap">
 
    select *
 
    from employees
 
    where salary > 100
 
</select>
```

- 에러남
	- 왜? `salary > 100` 에서 `>` 를 '비교연산자' 로 인식하기 때문
- 이를 막기 위해 사용하는 듯

## 정리
- XML markup으로 해석되면 안되는데, 해석되는 문자열들이 쿼리 문에 있기 때문에, 이를 방지하기 위해 사용되는 선언.

- 반복문을 사용하기 위해서.. 아래 보단
  
  ```xml
  <example-code>
  while (x &lt; len &amp;&amp; !done) {
      print( &quot;Still working, &apos;zzz&apos;.&quot; );
      ++x;
      }
  </example-code>
  ```

- 이게 낫다. (가독성 등..)
  
  ```xml
  <example-code><![CDATA[
  while (x < len && !done) {
      print( "Still working, 'zzzz'." );
      ++x;
      }
  ]]></example-code>
  ```

### 참고
- https://stackoverflow.com/questions/2784183/what-does-cdata-in-xml-mean
- https://gdtbgl93.tistory.com/53
- https://epthffh.tistory.com/entry/Mybatis-%EC%97%90%EC%84%9C-CDATA-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0