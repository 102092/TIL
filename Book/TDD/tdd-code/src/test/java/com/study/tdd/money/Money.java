package com.study.tdd.money;

public class Money {

	protected int amount;
	protected String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	Money times(int multiplier) {
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
}
