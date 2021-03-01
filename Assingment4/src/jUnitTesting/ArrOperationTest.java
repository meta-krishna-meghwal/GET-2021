package jUnitTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrOperationTest {

	@Test
	public void fixXYTest_when_input_is_correct() {

		int values[] = { 1, 4, 1, 5, 5, 4, 1 };
		int x = 4;
		int y = 5;
		try {
			ArrOperation a = new ArrOperation(values);

			int[] result = a.fixXY(x, y);
			int[] correctResult = { 1, 4, 5, 1, 1, 4, 5 };

			assertArrayEquals(correctResult, result);
		} catch (AssertionError e) {
			e.getMessage();
		}

	}

	@Test
	public void fixXYTest_when_array_is_empty() {

		int values[] = {};
		int x = 4;
		int y = 5;
		try {
			ArrOperation a = new ArrOperation(values);

			int[] result = a.fixXY(x, y);
			int[] correctResult = {};

			assertArrayEquals(correctResult, result);

		} catch (AssertionError e) {
			e.getMessage();
		}
	}

	@Test
	public void fixXYTest_when_two_adjacents_X_values() {

		int values[] = { 5, 9, 4, 4, 9, 5 };
		int x = 4;
		int y = 5;
		try {
			ArrOperation a = new ArrOperation(values);

			int[] result = a.fixXY(x, y);
			int[] correctResult = {};

			assertArrayEquals(correctResult, result);

		} catch (AssertionError e) {
			e.getMessage();
		}
	}

	@Test
	public void fixXYTest_when_X_occurs_at_last_index() {

		int values[] = { 5, 9, 4, 4, 9, 4 };
		int x = 4;
		int y = 5;
		try {
			ArrOperation a = new ArrOperation(values);

			int[] result = a.fixXY(x, y);
			int[] correctResult = {};

			assertArrayEquals(correctResult, result);
		} catch (AssertionError e) {
			e.getMessage();
		}
	}

	@Test
	public void fixXYTest_when_unequal_numbers_of_X_and_Y() {

		int values[] = { 5, 9, 4, 9, 4 };
		int x = 4;
		int y = 5;
		try {
			ArrOperation a = new ArrOperation(values);

			int[] result = a.fixXY(x, y);
			int[] correctResult = {};

			assertArrayEquals(correctResult, result);
		} catch (AssertionError e) {
			e.getMessage();
		}
	}

	@Test
	public void largestMirrorTest() {
		int values[] = { 1, 2, 3, 8, 9, 3, 2, 1 };
		int correctResult = 3;
		try {
			ArrOperation a = new ArrOperation(values);
			int result = a.largestMirror();
			assertEquals(correctResult, result);
		} catch (AssertionError e) {
			e.getMessage();
		}
	}

	@Test
	public void largestMirrorTest_when_array_is_empty() {
		int values[] = {};
		int correctResult = 0;
		try {
			ArrOperation a = new ArrOperation(values);
			int result = a.largestMirror();
			assertEquals(correctResult, result);
		} catch (AssertionError e) {
			e.getMessage();
		}
	}

	@Test
	public void clumpsTest() {
		int values[] = { 1, 2, 2, 3, 4, 4 };
		int correctResult = 2;
		try {
			ArrOperation a = new ArrOperation(values);
			int result = a.clumps();
			assertEquals(correctResult, result);
		} catch (AssertionError e) {
			e.getMessage();
		}
	}

	@Test
	public void clumpsTest_when_array_is_empty() {
		int values[] = {};
		int correctResult = 0;
		ArrOperation a = new ArrOperation(values);
		try {
			int result = a.clumps();
			assertEquals(correctResult, result);
		} catch (AssertionError e) {
			e.getMessage();
		}
	}

	@Test
	public void splitArrayTest() {
		int values[] = { 1, 1, 1, 2, 1 };
		int correctResult = 3;
		try {
			ArrOperation a = new ArrOperation(values);
			int result = a.splitArray();
			assertEquals(correctResult, result);
		} catch (AssertionError e) {
			e.getMessage();
		}
	}

	@Test
	public void splitArrayTest_when_array_is_empty() {
		int values[] = {};
		int correctResult = 0;
		try {
			ArrOperation a = new ArrOperation(values);
			int result = a.splitArray();
			assertEquals(correctResult, result);
		} catch (AssertionError e) {
			e.getMessage();
		}
	}

}
