package string;

import static org.junit.Assert.*;

import org.junit.Test;

/** @author krishna.meghwal_meta */
public class UniqueCharactersTest {

	@Test
	public void UniqueTest() {
		UniqueCharacters c = new UniqueCharacters();
		assertEquals(4, c.getUniqueCharactersCount("abbcd"));
	}

}
