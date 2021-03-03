package nQueen;

import static org.junit.Assert.*;

import org.junit.Test;

public class nQueenTest {

	@Test
	public void NoOfQueensTest() {
		int n = 3;
		if (n == 1 || n >= 4) {
			assertTrue(nQueen.nQueens(n));
		} else {
			assertFalse(nQueen.nQueens(n));
		}
	}

}
