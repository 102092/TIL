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

## 3. State

- dynamic data를 다루기 위해 필요한 것? state

- baby extends human

  - samsung extends cellphone
  - extends? 기본적으로 공유하는 특성들을 부여한다음에 추가적으로 뭔가 만들려고 할때 상속?을 사용

- class react component

  ```javascript
  class App extends React.Component {
    render() {
      return <h1>I'm class Component</h1>;
    }
  }
  ```

  - react 자동으로 class component 의 render method를 사용함

- state는 object

  - 변할 데이터는 state안에 넣는다.

- <button onClick = {this.add} --> Class 안에 있는 add Function를 실행시킴 (단 눌렀을 때만)

  - this.add() --> 즉시 실행시킴.

- Do not mutate State directly

  - 왜? 그렇게 변경하면 react가 render하지 않게됨. 
  - 우리는 state를 변경함으로써 react가 바로 class를 Render기 원하지만.
  - setState를 사용하지 않으면 render function이 작동하지 않을것.

  ```javascript
  class App extends React.Component {
    state = {
      count: 0
    };
  
    add = () => {
      this.setState({ count: 1 });
    };
    minus = () => {
      this.setState({ count: -1 });
    };
    render() {
      return (
        <div>
          <h1>The number is : {this.state.count}</h1>
          <button onClick={this.add}>Add</button>
          <button onClick={this.minus}>Minus</button>
        </div>
      );
    }
  }
  ```

  

- current function arrow

  ```javascript
  class App extends React.Component {
    state = {
      count: 0
    };
  
    add = () => {
      this.setState(current => ({
        count: current.count + 1
      }));
    };
    minus = () => {
      this.setState(current => ({
        count: current.count - 1
      }));
    };
    render() {
      return (
        <div>
          <h1>The number is : {this.state.count}</h1>
          <button onClick={this.add}>Add</button>
          <button onClick={this.minus}>Minus</button>
        </div>
      );
    }
  }
  
  export default App;
  
  ```

  - state.count에 직접 접근하지 않고, 현재값을 가져와서 그 현재값에 할당하는 방법
  - state에 직접 접근할 수도 있지만 성능이슈가 있음. 멀티쓰레드 이슈도 있지 않을까???



- Component LifeCycle
  - component가 웹사이트에 갈때

    1. constructor() 
    2. render()

    순으로 실행됨.

  - render()될때

    - componentDidUpdate()실행됨.



#### 4. Making the Movie App

- Axios : fetch위에 작은 레이어.
- YTS Api 사용
  - nomad coder에서 제공하는 proxy server : https://yts-proxy.now.sh/list_movies.json
  - 왜 YTS Api 가 계속 바뀌어서.

- async , await 같이 사용

  ```javascript
    getMovies = async () => {
      const movies = await axios.get("https://yts-proxy.now.sh/list_movies.json");
    };
  ```

  