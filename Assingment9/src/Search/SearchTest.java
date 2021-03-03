package Search;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest {

	@Test
	public void linearSearchTest() {
		int[] array = {10,12,14,11,7,3,1,2,5};
		int x = 2;
		int correctResult = 7;
		int result = Search.linearSearch(array, x);
		System.out.println(result);
		assertEquals(result, correctResult);
	}

	@Test
	public void binarySearchTest() {
		int[] array = {10,12,14,15,79,90};
		int x = 12;
		int correctResult = 1;
		int result = Search.binarySearch(array, x);
		System.out.println(result);
		assertEquals(result, correctResult);
	}

}
