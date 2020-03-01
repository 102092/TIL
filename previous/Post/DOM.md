>   궁금했던 부분을 찾아가며 정리하고 있습니다.
> 혹시 잘못된 부분이 있으면, 언제든지 댓글로 편하게 알려주세요 :)



----



##  DOM

![](https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/DOM-model.svg/1200px-DOM-model.svg.png)

- 문서 **객체** 모델(The Document Object Model, 이하 DOM) 

- 웹페이지에 대한 **interface**

- 여러 프로그램들이 웹페이지를 조작할 수 있도록 API를 제공해주는 역할을 함.

- `DOM` 객체는 **노드 트리** 형식

  ![](https://wit.nts-corp.com/wp-content/uploads/2019/02/-3-768x423.)

  

  - Loot는 html



### 웹페이지 

1. 읽어드릴 문서를 파싱하여, 어떤 내용을 페이지에 렌더링 할지 결정

   (랜더 트리 생성)

2. 브라우저는 1번에서 결정된 렌더링을 수행



### DOM이 아닌것

1. HTML = DOM은 아님.

   - DOM은 HTML문서로부터 생성되는 것이지만, 항상 같진 않음.

     올바르지 않은 HTML문서도, 유효한 HTML규칙에 따라, 생성된 DOM에는 교정되어 나타남.

     즉 알아서 수정되어서.

   - 또한, 자바스크립트가 DOM을 수정할 경우,

     HTML은 수정되지 않지만, DOM에는 새로운 노드가 추가됨.



2. DOM은 보이지 않는 요소도 포함.

   ![](https://wit.nts-corp.com/wp-content/uploads/2019/02/-7-768x243.)

   

   **DOM**

   ![](https://wit.nts-corp.com/wp-content/uploads/2019/02/-9-768x326.)

   **렌더트리** (브라우저에 보이는 부분)

   ![](https://wit.nts-corp.com/wp-content/uploads/2019/02/-8-768x193.)



3. DOM은 개발도구에서 보이지 않음.

- 개발도구는  DOM에 없는 추가적인 정보도 포함

- CSS가상요소 `::befor` , `::after` 선택자를 사용하면 렌더트리를 구성할 뿐 DOM을 구성하진 않음. 

  왜냐면 DOM은 HTML로부터만 빌드되고, 스타일은 포함하지 않아서.
  이러한 요소는 DOM에 포함되지 않음에도, **개발도구에서 확인 가능**

  ![](https://wit.nts-corp.com/wp-content/uploads/2019/02/-10-1024x657.)

****

> 참고

- [https://developer.mozilla.org/ko/docs/Web/API/Document_Object_Model/%EC%86%8C%EA%B0%9C](https://developer.mozilla.org/ko/docs/Web/API/Document_Object_Model/소개)
- https://wit.nts-corp.com/2019/02/14/5522