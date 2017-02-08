package com.fererlab.aa.shunting_yard.tests;

import com.fererlab.aa.shunting_yard.DijkstraInterpreter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * can
 */
public class DijkstraInterpreterTest {

	public static final String EXPRESSION_4_P_9 = "( 4 + 9 )";
	public static final String EXPRESSION_2_T_6 = "( 2 * 6 )";
	public static final String EXPRESSION_ALL = "( " + EXPRESSION_4_P_9 + " + " + EXPRESSION_2_T_6 + " )";
	private static final Double EXPRESSION_4_P_9_RESULT = 13D;
	private static final Double EXPRESSION_2_T_6_RESULT = 12D;
	private static final Double EXPRESSION_ALL_RESULT = EXPRESSION_4_P_9_RESULT + EXPRESSION_2_T_6_RESULT;

	@Test
	public void interpret() {
		DijkstraInterpreter interpreter = new DijkstraInterpreter();

		Double result = interpreter.interpret(EXPRESSION_4_P_9);
		assertEquals(result, EXPRESSION_4_P_9_RESULT);

		result = interpreter.interpret(EXPRESSION_2_T_6);
		assertEquals(result, EXPRESSION_2_T_6_RESULT);

		result = interpreter.interpret(EXPRESSION_ALL);
		assertEquals(result, EXPRESSION_ALL_RESULT);

	}

}
