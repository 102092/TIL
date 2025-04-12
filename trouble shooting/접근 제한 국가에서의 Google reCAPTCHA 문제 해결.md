# 문제
---
- 구글 도메인은 특정 국가에서 접근 불가함. (e.g CN)
- 예를 들면 `https://www.google.com/recaptcha/api.js` 를 통해 스크립트를 불러올 경우, 자동으로 블락되어 정상적으로 로드되는 것 같지 않음.

## 해결

> ..replace src="https://www.google.com/recaptcha/api.js" with src="https://www.recaptcha.net/recaptcha/api.js"

- google 도메인이 아닌, recapcha 도메인으로 변경하니 정상적으로 작동.

## 참고
---
- https://groups.google.com/g/recaptcha/c/XBhetkVgh84
- https://stackoverflow.com/questions/57827914/google-recaptcha-in-china