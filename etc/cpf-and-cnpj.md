# What is..
- 브라질에서 발급되는 세금 관련 식별자
- CPF는 개인, CNPJ는 회사에게 발급됨.
- 두 종류는 포멧이 다르기 때문에 유의할 필요가 있을 듯.
- 왜 필요한가?
    - A CPF is essential to be able to do almost anything in Brazil
    - 거의 모든 공적, 사적 업무를 할 때 필요한 식별자 인듯. 

# In Hibernate
- 이에 해당하는 Validator 로 사용할 수 있는 annotation 이 이미 존재한다!
- [CPF](https://docs.jboss.org/hibernate/stable/validator/api/org/hibernate/validator/constraints/br/CPF.html)
- [CNPJ](https://docs.jboss.org/hibernate/stable/validator/api/org/hibernate/validator/constraints/br/CNPJ.html)
- 또한 Hibernate 에서 `CPFValidator`, `CNPJValidator` 가 구현되어있는 걸로 보아, 위 어노테이션에 존재하는 Pattern을 통한 검증을 제외한 추가적인 validation이 있는 걸로 여겨진다.
    - https://docs.jboss.org/hibernate/stable/validator/api/org/hibernate/validator/internal/constraintvalidators/hv/br/CPFValidator.html


# 참고
- https://wise.com/gb/blog/cpf-cnpj-meaning-brazil
- https://docs.swissuplabs.com/m2/extensions/firecheckout/brazil/cpf-cnpj/
- https://www.4devs.com.br/gerador_de_cpf