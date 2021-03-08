package stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixEvaluationTest {

	@Test
	public void booleanTest() {
		try {
			String s = "( 36 / 2 + 45 * 5 <= 1  * 500)";
			String answer = "true";
			assertEquals(answer, InfixEvaluation.evalute(s));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void arithemeticTest() {
		try {
			String s = "( 36 / 2 + 45 * 5 )";
			String answer = "243";
			assertEquals(answer, InfixEvaluation.evalute(s));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
