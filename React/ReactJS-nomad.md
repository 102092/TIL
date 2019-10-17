> https://academy.nomadcoders.co/courses/216871/lectures/10881270



## 0. intro

- node v10, v12
- npm

- npm install npx -g
  
  - mac에서는 sudo -s 명령어를 통해 관리자모드에서 실행할것
- `npx create-react-app move_app_2019`

  



## 1. setup

1. git init
2. git add remote orgin ....
3. git add .
4. git commit -m "..."
5. git push origin master



- react : js code를 rendering 한다 html로 쉽게



## 2. JSX, Props

- component

  - function which return HTML

- JSX :  html inside of javascript

  ```javascript
  import React from "react";
  import Potato from "./Potato";
  
  function App() {
    return (
      <div>
        <h1>Hello!!</h1>
        <Potato />
      </div>
    );
  }
  
  export default App;
  
  ```

  - Potata.js라는 component만들어주고, App.js에 import후 사용

- react application은 단 한번에의 rendering만 할 수 있음.

  ```javascript
  ReactDOM.render(<App />,<Potato /> document.getElementById("potato"));
  ```

  - 위의 코드는 작동하지 않음.



- component는 계속 재사용이 가능하다. 
  - component to component?
  - component to child component?

```javascript
import React from "react";

function Food() {
  return <h1>I like Potato</h1>;
}

function App() {
  return (
    <div>
      <h1>Hello!!</h1>
      <Food name="kimchi" />
      <Food fav="kimchi"/>
    </div>
  );
}

export default App;
```

- jsx에게 name 값 주기. Food component에 name = kimchi

  - fav = kimchi

- props

  - Object
  - component를 전달할 때 사용되는 매개 변수? 객체?
  - 전해지는 매개변수가 요구하는 것인지 확인할 수 있음.

  ```javascript
  Food.propTypes = {
    name: PropTypes.string.isRequired,
    picture: PropTypes.string.isRequired,
    rating: PropTypes.number.isRequired
  };
  ```

  - 반드시 `propTypes`로 할것. 아니면 react가 읽지 못함