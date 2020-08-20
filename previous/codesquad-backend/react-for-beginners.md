#### 참고

- https://www.youtube.com/watch?v=DLX62G4lc44&t=4s



#### Title

> About JSX, Styling, State, Props, Event Handling, Lifecycle Methods, HTTP, Forms



#### Why React?

- Virtual DOM
  - 참고 : https://www.youtube.com/watch?v=BYbgopx44vo
- Reuseable Web Componets
  - 장황한 HTML code를, 
  - 짦게 참고하면서 재사용을 유용하게 할 수 있음.
- Facebook에 의해 운영되고 있음.
  - 지속적으로 사용될 것을 기대할 수 있음.
- Hirable
  - hot , demanded



#### ReactDOM

```js
import React form "react"
import ReactDOM form "react-dom"

ReactDOM.render(<h1>Hello world</h1>, document.getElementById("root"))
```

- 특정 element를 가져와서, 첫번째 인자로 받은 HTML을 뿌려준다.



#### JSX

- Javascript를 확장한 문법
- 해당 기능이 포함되어 있음.
- `const element = <h1>Hello, {name}</h1>;`
  - `{name}` 같이, 자바스크립트를 넣을 수 있음.



#### components

- 