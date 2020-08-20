package com.study.tdd.money;

public class Money implements Expression {

	protected int amount;
	protected String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	// 각 화폐 생산하는 팩토리 메서드 
	static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	public Expression times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}

	String currency() {
		return currency;
	}

	public boolean equals(Object object) {
		Money money = (Money) object;
		return amount == money.amount && currency().equals(money.currency());
	}

	public String toString() {
		return amount + "  " + currency;
	}
	
	// 같은 화폐끼리 덧셈
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}
	
	//환율계산하여 넘기는 것.
	public Money reduce(Bank bank, String to) {
		int rate = bank.rate(currency, to);
		return new Money(amount / rate, to);
	}
}
