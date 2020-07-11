package com.divyaank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

	private MathUtils mu;
	
	@BeforeAll
	static void runBeforeAll() {
		//This method is static as @BeforeAll is triggered even before class is initialized
		System.out.println("@BeforeAll hook triggered");
	}
	
	@BeforeEach
	void initObj() {
		mu = new MathUtils();
	}
	
	@AfterEach
	void afterEachMethod() {
		System.out.println("@AfterEach hook triggered");
	}
	
	@AfterAll
	static void runAfterAll() {
		//This method is static as @AfterAll is triggered after class instance is destroyed
		System.out.println("@AfterAll hook triggered");
	}
	
	@Test
	void testAdd() {
		int expected = 2;
		int actual = mu.add(1,1);
		assertEquals(expected, actual, "Add 2 numbers");
	}
	
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mu.divide(1, 0), 
				"Divide should throw ArithmeticException when denominator is zero");
	}
	
	@Test 
	void computeCircleArea() {
		assertEquals(314.1592653589793, mu.computeCircleArea(10), 
				"Should return right circle area");
	}
}
