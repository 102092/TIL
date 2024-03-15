 - char, primitive type
 - Java 8에서는 version 6.2 of the Unicode Standard 를 사용.
 - 16비트임. (2바이트)
 - *Basic Multilingual Plane* 범위는 U+0000 ~ U+FFFF
 - *supplementary characters* 는 U+FFFF보다 큰 범위를 의미.
 - 자바 플랫폼은 UTF-16 을 사용
 - char array, String, StringBuffer Class에서 사용됨.
 - 이 기준에서는 *supplementary characters* 는 pair of char (이런식으로..\uD800-\uDBFF)  나타내짐.
 - 이를 Surrogate Pair라고도 불리는듯?

>  String vs Char

- String은 Char 배열로 이루어져 있음.
	- 즉 String은 0 또는 그 이상의 char의 배열
- 왜 Char 배열보다 String을 사용할까?
	- Immutable 하기 때문에 <-> Char 배열은 변경 가능하다.
	- String을 관리하는 String Contant pool 이 있어서 <-> Char 배열은 Heap에 저장될 것. 


## 참고

- [Character (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html)
- https://docs.oracle.com/javase/tutorial/java/data/characters.html
- https://www.sysnet.pe.kr/2/0/1710
- [Difference between String and Character array in Java - GeeksforGeeks](https://www.geeksforgeeks.org/difference-between-string-and-character-array-in-java/)