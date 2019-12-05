package com.study.tdd.money;

public class Sum implements Expression {

	Money augend; //augned 피가산수 
	Money addend;

	public Sum(Money augned, Money addend) {
		this.augend = augned;
		this.addend = addend;
	}

	public Money reduce(Bank bank, String to) {
		int amount = augend.amount + addend.amount;
		return new Money(amount, to);
	}
}
