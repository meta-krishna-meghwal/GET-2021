package linkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class nestedLinkedListTest {
	nestedLinkedList list;

	@Before
	public void before() {
		list = new nestedLinkedList();

		int powers1[] = { 1, 2, 3 };
		list.addTerm(10, powers1);
		int powers2[] = { 3, 4, 7 };
		list.addTerm(8, powers2);
		int powers3[] = { 8, 7 };
		list.addTerm(2, powers3);
	}

	@Test
	public void maxDegreeTest() {
		assertEquals(15, list.maxDegree());
	}

}
