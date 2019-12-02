package com.study.tdd.money;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DollarTest {

	class Dollar {

		int amount = 10;

		public Dollar(int amount) {

		}

		void times(int multiplier) {

		}
	}

	@Test
	public void TestMultipiaction() {
		Dollar five = new Dollar(5);
		five.times(2);
		assertEquals(10, five.amount);
	}

}
