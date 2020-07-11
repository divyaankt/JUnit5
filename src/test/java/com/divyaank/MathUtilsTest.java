package com.divyaank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;


//Create one instance for each class, not each method(default behaviour)
//Using this @BeforeAll and @AfterAll hooks can have non-static methods
@TestInstance(TestInstance.Lifecycle.PER_CLASS) 
@EnabledOnJre(JRE.JAVA_8)
@EnabledOnOs(OS.WINDOWS)
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
	@DisplayName("Testing add() method")
	void testAdd() {
		int expected = 2;
		int actual = mu.add(1,1);
		assertEquals(expected, actual, "Add 2 numbers");
	}
	
	@Test
	@DisplayName("Testing divide() method")
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mu.divide(1, 0), 
				"Divide should throw ArithmeticException when denominator is zero");
	}
	
	@Test
	@DisplayName("Testing computeCircleArea() method")
	void testComputeCircleArea() {
		assertEquals(314.1592653589793, mu.computeCircleArea(10), 
				"Should return right circle area");
	}
	
	@Test
	@Disabled
	@DisplayName("testDisabled() should not run")
	void testDisabled() {
		fail("Method should not run, implementation incomplete:(");
	}
}
