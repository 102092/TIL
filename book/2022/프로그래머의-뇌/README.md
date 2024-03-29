# The programmer's Brain

## Part1

### ch1

> 코드 더 잘 읽기

- 코드를 읽으면서, 이해하면서 왜 혼란이 생기는가?
  1. 지식의 부족, 해당 코드 이해에 필요한 지식(knowlege) 이 부족함.
  2. 정보의 부족, 해당 메서드가 어떤 일을 유추할 수 있지만, 어떻게 동작하는 지는 모름. 정보(information)가 부족하다. 
  3. 처리 능력의 부족, processing power, 메서드 내부 코드가 진행되면서 변수가 어떻게 할당되는지 등의 흐름을 이해하지 못하는 것.(코드 너무 복잡함. 임시 변수가 많고...)

- 지식의 부족은 LTM(long term memory, 장기 기억 공간) 에 해당 내용이 없다는 것.
- 정보의 부족은 STM(short term memory, 단기 기억 공간) 에 해당 내용이 없다는 것.
- 처리 능력이 부족하는 건 working memory, 작업 기억 공간에 부족하다는 것.
- LTM ?
  - e.g Java의 maxInt 는 2147483647 임.
  - 즉 하드 드라이브.
- STM ?
  - e.g 코드의 키워드, 변수, 자료구조등..
  - 즉 캐시 메모리..
  - 보통 이 공간에서 기억할 수 있는 것이 *12개*를 넘지 않는다.
  - 즉 STM을 최대한 활용하기 위해선 12개 미만의 것들을 활용하도록 해야함. (변수 갯수 제한등등..)
- Working Memory?
  - 프로세스
- 코드를 읽으면서 위 세가지 인지 과정이 다 같이 일어나며, 상호 보완적임.

### ch2

> 신속한 코드 분석

- 코드를 읽을 때, 처음 정보가 저장되는 곳?
  - STM
- 프로그램은 사람이 읽을 수 있도록 작성해야한다. 기계가 실행하는 것은 부차원적인 일이다.
- STM은 읽거나 들은 정보를 짦은 시간만 저장함.
  - 이 짦은 시간은 30초를 넘지 않음.
- STM의 용량은 2개에서 6개 사이.
- Chunk
  - 특정한 주제에 대해 두뇌가 더 많은 정보를 저장하고 있다면, 입력된 정보들을 효율적으로 청크로 묶는 것이 수월해짐.
  - abk mrtpi gbar 로 외우는 것 보단, cat loves cake 를 외우는게 더 쉽다.
  - 왜? 후자는 3개로 묶어서 외워지지만, 전자는 각각 한개씩 외워야 하므로.
- 감각 기억 공간
  - STM에 도달하기 전의 buffer 역할.
  - 코드를 읽으면 영상 기억 공간 (iconic memory) 라는 곳에 잠시 저장됨.
- 그룹으로 묶기 쉬운 코드를 작성하려면 디자인 패턴을 사용하면 됨.
  - 디자인 패턴을 사용하면, 코드를 청크 단위로 이해하기가 수월해지는 듯.
- 코드에 주석문이 있으면, 새로운 팀원이 코드를 쉽게 이해할 수 있음.
  - 단 고수준 주석문만.
  - e.g 이 함수는 이진트리를 중위 순회 하며 프린트한다.

### ch3

> 프로그래밍 문법 빠르게 배우기

- 플래시 카드를 사용해 문법 배우기.
- STM에 저장된 정보는 LTM으로 옮겨짐. 그렇지만 LTM에 영원히 저장되는 것은 아님.
- 오랫동안 학습한 만큼, 더 오래 기억한다.
- LTM 어딘가에 저장되어있지만, 그것이 필요할 떄는 정작 가져오지 못하는 경우도 있음.
  - 알고 있지만, 말을 꺼내지 못하는 경우.
  - 즉 정보를 저장하는 것만으로는 충분하지 않고, 쉽게 인출할 수 있도록 연습해야함.
- 정교화 elaboration
  - 기억하고자 하는 내용을 기존 기억과 연관 지으면서 생각하는 것.

### ch4

> 복잡한 코드 읽는 방법

- 인지 부하(cognitive load) 너무 많은 요소가 있어 청크로 나뉘지 않은 문제를 풀려고 할 때 발생
  - overload

- 내재적 인지 부하 (intinsic cognitive load)
  - 직각 삼각형의 두변의 길이가 주어진 상태 (다른 변수 할당 없이 직접)
  - 직각 삼각형 빗변의 길을 계산하기 위해선 피타고라스 정리를 알고 있어야함.
  - 모르면 풀 방법 없음.
  - 즉 문제의 부하는 문제에 내재되어있음.

- 외재적 인지 부하 (extraneous cognitive load)
  - 직각 삼각형의 두 변의 길이가 변수로 주어진 상태 (a,b)
  - a,b라는 값을 실제 길이와 연결시켜야함.
  - 추가적인 작업이 있음.
  - 이 떄 외재적 인지 부하가 발생.

```python
above_ten = [a for a in item if a > 10]

above_ten = []
for a in items:
    if a > 10: above_ten.append(a)
```

- 첫번째, 두번째 코드는 같은 일을 하고 있지만,
- 파이썬의 리스트 컴프리헨션에 대해 모르고 있으면, 첫번째 코드를 읽음으로써 발생하는 외재적 인지 부하가 그렇지 않은 사람보다 큼.

- 그러면 인지 부하를 어떻게 줄일 수 있을까?
  - 리팩토링
- 코드를 바탕으로 의존 그래프 (dependency graph) 를 만들면 흐름을 이해하고 논리적 흐름에 따라 코드를 읽는데 도움이됨.
  - 예를 들면 모든 변수를 원으로 표시
  - 그리고 동일한 변수끼리 선으로 연결. (데이터가 사용된 위치를 이해하는데 도움이 됨.)
- 계산이 많은 코드에 도움이 되는 건?
  - 상태표
  - tracing, cognitive compiling
- [python tutor](https://pythontutor.com/)

## Part 2

### ch5

> 코드를 더 깊이 있게 이해하기

- 변수가 어떤 정보를 담고 있는지 이해하는 것은 코드를 추론하고 수정하는데 결정적인 역할을 함.
- 변수 역할
  1. fixed value (고정값), 값이 할당된 이후 변경되지 않는 변수
  2. stepper, 루프를 반복 실행하며 값이 단계적으로 변하는 변수
      - e.g for문의 i 변수
  3. flag, 무엇인가 발생했거나 어떤 경우에 해당하는 지를 나타내는 변수.
      - e.g is_set, is_available..
  4. walker, stepper와 유사. 단 자료구조를 순회.
      - e.g 스택, 트리를 순회할 때 사용되는 변수
  5. most recent holder (최근값 보유자), 어떤 값이 변해가는데 가장 최근에 변경된 값을 갖는 변수
  6. most wanted holder (목적값 보유자), 어떤 값이 변해가는데 특정한 값을 찾고자 할 때 그 특정한 값.
      - e.g 최소값, 최대값
  7. gatherer (모집자), 데이터를 모으거나, 어떤 연산 수행하여 얻은 값.
  8. container, 값을 새로 추가하거나 삭제할 수 있는 자료구조
      - e.g 리스트, 배열, 스택..
  9. follower (추적자), 어떤 알고리즘에서 이전 값 혹은 다음 값을 추적해야할 필요가 있을 때, 그 역할을 수행하는 변수.
  10. organizer (조직자), 다른 값을 저장하기 위한 목적으로 사용되는 변수. 임시 변수와 비슷
      - e.g 문자열 -> 문자열 배열로 변경할 때, 문자열 배열을 담고 있는 변수.
  11. temporary, 잠시만 사용하기 위한 변수, 보통 temp, t 라는 변수명을 많이 사용함.
- 프로그래머가 코드를 읽을 때..
  - 초점 focal point를 먼저 찾음. (`main()...`)
  - 초점은 어디서부터 코드를 읽어야 할지 알려주는 포인트.

### ch6

> 코딩 문제 해결을 더 잘하려면

- 정신모델, 개념적 기계..
- 별로 흥미롭진 않았음.

### ch7

> 생각의 버그

- 학습 전이 transfer of learning
- 근거리 전이, 원거리 전이
- 프로그래밍을 배움으로써 논리적인 추론에 대한 기술을 얻거나 심지어 일반적인 지능을 증가시킬 것이라 주장. 그렇지만 아님 (거의 효과 없음.)
- 오개념 (오해)

## Part3

### ch8

> 명명 잘하는 방법

- 왜 명명이 중요함?
  - 표식 역할.
  - 이름을 잘 짓는 것이, 문서화의 가장 쉬운 형태임.
- 좋은 명명?
  - 일관성이 있어야함.
  - 너무 많은 단어는 안 좋음 (4~5단어 정도가 소소)
  - 가능한 자연어에 가깝게 명명하자.

- 스네이크 케이스 or 카멜 케이스
  - 카멜케이스가 나음.

### ch9

> 나쁜 코드와 인지 부하를 방지하는 두 가지 프레임 워크

- 인지 부하는 작업 기억 공간이 꽉 차서 뇌가 더 이상 제대로 처리하지 못할 때 발생.
- 메서드 수준
  - 많은 라인, 많은 기능.
  - 많은 매개변수.
- 클래스 수준
  - 방대한 기능을 할 때
  - 너무 작은 기능만 할 때
- 코드 베이스 수준
  - 중복 코드
- 긴 매개변수, 복잡한 스위치문은 작업 기억 공간의 용량을 초과시키게 함.
  - 즉 코드 이해가 어려워짐.

### ch10

> 복잡한 문제 해결을 더 잘하려면

- 두뇌에 명시적 기억으로 저장되려면, 명시적 주의가 필요함.
  - 즉 for 루프는 for (i = 0; i < n; i++) {}.. 로 정의된다는 건을 알고 있는 것.
- 암시적 기억은 반복에 의해 생성됨.
- 프로그래밍에 대한 암시적 기억이 많을수록 인지 부하를 더 절약할 수 있음.
- 암시적인 기억은 어떻게 생성될까?
  1. 인지 단계, 예를 들면 리스트의 인덱스는 0부터 시작한다는 것을 인지하는 단계
  2. 연상 단계, 리스트에서 내가 찾고자하는 순서에서 1을 빼면, 올바른 인덱스다 라는 걸 알 수 있는 단계
  3. 자율 단계, 리스트에서 인덱스를 찾고자 숫자를 계산하지 않고 즉각적으로 알 수 있는 상태
- 자율 단계에 다다르면, 기술을 자동화했다고 볼 수 있음.
- 암시적인 기억을 개선하기 위해선?
  - 연습하고자 하는 기술가 유사하지만 다른 프로그램을 많이 작성
  - 예를 들면 for 루프를 연습 중이라면, 정방향, 역방향, 단계가 다른 스테퍼 등등 여러가지 방향으로 for 루프를 이용해봄.
- 어떤 문제에 대해 스스로 풀기 힘들고, 풀이가 있다면, 풀이를 보고 이해하는 것이 도움이 됨.
  - 스스로 무작정 풀어보는 것보다..
  - 즉 설명을 통해 배우는 것이, 작성하며 배울 때보다 배우는 것이 더 많음.

## part4

### ch11

> 코드를 작성하는 행위

- 검색
  - 코드 베이스를 살펴보고, 특정 정보를 검색.
  - STM에 부하
  - 종이나 별도의 문서에 해당 내용을 작성하면 도움이 됨.
- 이해
  - 코드를 읽고, 실행. 검색과 비슷하지만 코드 세부 기능에 대한 이해가 부족할 경우 진행.
  - 보통 개발 업무의 60%를 차지
  - 리팩토링 작업도 포함.
  - 작업 기억 공간에 부하.
- 전사
  - 단순히 코딩하는 활동
  - LTM에 부하 왜? 문법 구조를 떠올려야함.
- 증가
  - 검색 + 이해 + 전사
  - 새 기능을 추가 (코드 작성
  - STM, LTM, 작업 기억 공간 3곳에 모두 부하.
- 탐구
  - 코드를 사용해서 스케치하는 것.
  - 예를 들면, 코드 작성, 실행, 테스트 실행, 코드 읽기, 리팩토링등이 포함됨.
  - IDE에 크게 의존
  - 3곳에 모두 영향
- 업무를 중간에 중단하는 것은 인지 부하를 높인다.
  - 왜?
  - 업무가 중단되면 작업 기억 공간에서 정보들이 사라짐.
- 업무 중단을 어떻게 대비해야 하나?
  - 정신 모델 저장.
  - 주석문을 좀 방대하게 남긴다.
  - TODO...
  - 하위 라벨 붙이기
- 깊은 인지 작업을 하는 동안 여러가지 일을 동시에 할 수 없다.
  - 멀티 태스킹이 안된다.

### ch12

> 대규모 시스템의 설계와 개선

### ch13

> 새로운 개발자 팀원의 적응 지원
