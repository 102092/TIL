package com.study.tdd.money;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DollarTest {

	class Dollar {

		int amount;

		public Dollar(int amount) {
			this.amount = amount;
		}

		Dollar times(int multiplier) {
			return new Dollar(amount * multiplier);
		}
	}

	@Test
	public void TestMultipiaction() {
		Dollar five = new Dollar(5);
		Dollar product = five.times(2);

		assertEquals(10, product.amount);
		product = five.times(3);
		assertEquals(15, product.amount);
	}

}
