package com.study.tdd.money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MoneyTest {

//	@Test
//	public void testDollarMultiplication() {
//		Money five = Money.dollar(5);
//		assertEquals(Money.dollar(10), five.times(2));
//		assertEquals(Money.dollar(15), five.times(3));
//
//	}
//
//	@Test
//	public void testFrancMultiplication() {
//		Franc five = Money.franc(5);
//		assertEquals(Money.franc(10), five.times(2));
//		assertEquals(Money.franc(15), five.times(3));
//
//	}
//
//	@Test
//	public void testEquality() {
//		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
//		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
//		assertFalse(Money.franc(5).equals(Money.dollar(5)));
//
//	}
//
//	@Test
//	public void testCurrency() {
//		assertEquals("USD", Money.dollar(1).currency());
//		assertEquals("CHF", Money.franc(1).currency());
//	}

//	@Test
//	public void testDifferentClassEquality() {
//		assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
//	}
//	@Test
//	public void testSimpleAddition() {
//		Money five = Money.dollar(5);
//		Expression result = five.plus(five);
//		Sum sum = (Sum) result;
//		Bank bank = new Bank();
//		Money reduced = bank.reduce(sum, "USD");
//		assertEquals(Money.dollar(10), reduced);
//	}
//	@Test
//	public void testReduceMoney() {
//		Bank bank = new Bank();
//		Money result = bank.reduce(Money.dollar(1), "USD");
//		assertEquals(Money.dollar(1), result);
//	}
	
//	@Test
//	public void testReduceSum() {
//		Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
//		Bank bank = new Bank();
//		Money result = bank.reduce(sum, "USD");
//		assertEquals(Money.dollar(7), result);
//	}
	
	@Test
	public void testIdentityRate() {
		assertEquals(1, new Bank().rate("USD", "USD"));
	}
}
