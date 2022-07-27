# @Access
> Used to specify an access type to be applied to an entity class, mapped superclass, or embeddable class, or to a specific attribute of such a class.

- 특정 access type을 설정하는 것.
- 타입에는 2가지 있음. (AccessType)
    - FIELD
    - PROPERTY
- 왜 설정하지?
    - JPA가 어떻게 엔티티의 properties에 접근하는 지 알려주는 것.
    - FIELD 방식이면, 해당 필드로 직접 접근 (getter, setter를 통하지 않음.)
    - PROPERTY 방식이면, getter, setter을 통해 field에 접근.
        - 즉 접근 시에 뭔가 처리 코드가 필요하면 PROPERTY 방식을 사용하지 않을까 생각듬.
- default?
    - `@id` 가 field에 있으면 FILED 방식 사용.
    - getter 에 있으면 PROPERTY 방식 사용.


# 참고
- https://devofhwb.tistory.com/92
- https://stackoverflow.com/questions/19264871/what-is-the-use-of-the-access-annoation-in-jpa-means-at-the-entity-level