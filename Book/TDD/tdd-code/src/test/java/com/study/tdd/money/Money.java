package com.study.tdd.money;

public abstract class Money {

	protected int amount;

	// 팩토리 메서드
	static Money dollar(int amount) {
		return new Dollar(amount);

	}

	static Franc franc(int amount) {
		return new Franc(amount);
	}

	abstract Money times(int mutiplier);

	public boolean equals(Object object) {
		Money money = (Money) object;
		return amount == money.amount && getClass().equals(money.getClass());
	}

}
