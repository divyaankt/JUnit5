package com.divyaank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void testAdd() {
		MathUtils mu = new MathUtils();
		int expected = 2;
		int actual = mu.add(1,1);
		assertEquals(expected, actual, "Add 2 numbers");
	}
	
	@Test
	void testDivide() {
		MathUtils mu = new MathUtils();
		assertThrows(ArithmeticException.class, () -> mu.divide(1, 0), 
				"Divide should throw ArithmeticException when denominator is zero");
	}
	
	@Test 
	void computeCircleArea() {
		MathUtils mu = new MathUtils();
		assertEquals(314.1592653589793, mu.computeCircleArea(10), 
				"Should return right circle area");
	}
}
