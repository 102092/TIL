- 증분배치
- 데이터 베이스에서 변경된 데이터만 배치작업을 통해 처리하는 방식

## 구현 방법
- [[transaction]] - id를 통해 변경된 데이터 식별하는 방법
- timestamp 를 통해 변경된 데이터 식별
- database log 를 통해 변경된 데이터 식별

## 참고
- https://cwiki.apache.org/confluence/display/KAFKA/KIP-95%3A+Incremental+Batch+Processing+for+Kafka+Streams
- https://en.wikipedia.org/wiki/Incremental_computing