package com.study.tdd.money;

public class Sum implements Expression {

	Expression augend; // augned 피가산수
	Expression addend;

	public Sum(Expression augned, Expression addend) {
		this.augend = augned;
		this.addend = addend;
	}

	public Money reduce(Bank bank, String to) {
		int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
		return new Money(amount, to);
	}

	public Expression plus(Expression addend) {
		return null;
			
	}
}
