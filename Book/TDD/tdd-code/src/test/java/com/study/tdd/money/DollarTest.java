package com.study.tdd.money;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

		// 테스트 통과를 위해 가짜로 구현하는 방법
		public boolean equals(Object object) {
			// 코드 일반화
			Dollar dollar = (Dollar) object;
			return amount == dollar.amount;
		}

	}

	@Test
	public void testEquality() {
		assertTrue(new Dollar(5).equals(new Dollar(5)));
		assertFalse(new Dollar(5).equals(new Dollar(6)));
	}

}
