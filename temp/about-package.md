# package.json vs package-lock.json

## package.json
```json
{
    "name": "Your project name",
    "version": "1.0.0",
    "description": "Your project description",
    "main": "app.js",
    "scripts": {
        "test": "echo \"Error: no test specified\" && exit 1",
    },
    "author": "Author name",
    "license": "ISC",
    "dependencies": {
        "dependency1": "^1.4.0",
        "dependency2": "^1.5.2"
    }
}
```

- json 형태
- 해당 프로젝트의 메타데이터를 포함.
- 모든 프로젝트에 **필수적**
- dependency의 name, version을 명시
	- `^1.4.0` 는 1.4.0 < 2.0.0 사이의 버전까지 사용한다는 뜻.
	- 즉 범위를 명시하고 있음.
	- 특정 dependency 이상으로 명시하다보니, 해당 버젼 상위 중 몇몇에서는 예상치 못한 문제가 발생할 수 도 있음.
	- 그래서 나온 개념이 `package-lock.json`

## package.lock.json

```json
{
    "name": "Your project name",
    "version": "1.0.0",
    "lockfileVersion": 1,
    "requires": true,
    "dependencies": {
        "dependency1": {
            "version": "1.4.0",
            "resolved": 
"https://registry.npmjs.org/dependency1/-/dependency1-1.4.0.tgz",
            "integrity": 
"sha512-a+UqTh4kgZg/SlGvfbzDHpgRu7AAQOmmqRHJnxhRZICKFUT91brVhNNt58CMWU9PsBbv3PDCZUHbVxuDiH2mtA=="
        },
        "dependency2": {
            "version": "1.5.2",
            "resolved": 
"https://registry.npmjs.org/dependency2/-/dependency2-1.5.2.tgz",
            "integrity": 
"sha512-WOn21V8AhyE1QqVfPIVxe3tupJacq1xGkPTB4iagT6o+P2cAgEOOwIxMftr4+ZCTI6d551ij9j61DFr0nsP2uQ=="
        }
    }
}
```

- json 형태
- 의존성 트리
- 프로젝트의 메타데이터를 명시하지면, 설치 버젼을 명시함.
	- **locking the dependency with the installed version**

## 어떻게 사용해야할까?

- 가능하면 `package-lock.json` 도 생성하고, 원격 저장소(github) 에 같이 트랙킹 되도록 설정.
- 해당 프로젝트가 정상적으로 동작했을 당시의 의존성 트리를 기억해야함. 
	- 핵심이 이 용도.


## 참고

- <https://velog.io/@songyouhyun/Package.json%EA%B3%BC-Package-lock.json%EC%9D%98-%EC%B0%A8%EC%9D%B4>
- <https://www.geeksforgeeks.org/difference-between-package-json-and-package-lock-json-files/>
- <https://stackoverflow.com/questions/22343224/whats-the-difference-between-tilde-and-caret-in-package-json>
