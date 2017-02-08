package com.fererlab.aa.factorial.tests;

import com.fererlab.aa.factorial.Factorials;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorialsTest {

	private static final Factorials factorials = new Factorials();
	private static final int TEST_INPUT = 4;
	private static final int TEST_RESULT = 24;
	private static final int LOWER_CORNER = 0;

	@BeforeClass
	public static void preClass() {
	}

	@AfterClass
	public static void postClass() {
	}

	@Before
	public void preOperation() {
	}

	@After
	public void postOperation() {
	}

	@Test
	public void factorialLowerCorner() {
		int factorial;

		factorial = factorials.factorial1(LOWER_CORNER);
		assertEquals(factorial, 1);
		factorial = factorials.factorial2(LOWER_CORNER);
		assertEquals(factorial, 1);
		factorial = factorials.factorial3(LOWER_CORNER);
		assertEquals(factorial, 1);
		factorial = factorials.factorial4(LOWER_CORNER);
		assertEquals(factorial, 1);

	}

	@Test
	public void factorialTests() {
		int factorial;

		factorial = factorials.factorial1(TEST_INPUT);
		assertEquals(factorial, TEST_RESULT);
		factorial = factorials.factorial2(TEST_INPUT);
		assertEquals(factorial, TEST_RESULT);
		factorial = factorials.factorial3(TEST_INPUT);
		assertEquals(factorial, TEST_RESULT);
		factorial = factorials.factorial4(TEST_INPUT);
		assertEquals(factorial, TEST_RESULT);

	}


}
