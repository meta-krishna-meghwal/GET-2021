package mathematicalFunctions;

import static org.junit.Assert.*;

import org.junit.Test;

public class mathematicalFunctionsTest {

	@Test
	public void lcmOfTwoNumbersTest() {
		int x = 12;
		int y = 18;
		int correctResult1 = 36;
		int result = mathematicalFunctions.lcmOfTwoNumbers(x, y);
		assertEquals(result, correctResult1);
	}

	@Test
	public void hcfOfTwoNumbersTest() {
		int x = 12;
		int y = 18;
		int correctResult2 = 6;
		int result = mathematicalFunctions.hcfOfTwoNumbers(x, y);
		assertEquals(result, correctResult2);
	}

}
