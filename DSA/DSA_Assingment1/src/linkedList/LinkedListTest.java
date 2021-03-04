package linkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/** @author krishna.meghwal_meta */
public class LinkedListTest {
	LinkedList list;

	@Before
	public void before() {
		list = new LinkedList();

		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);

	}

	@Test
	public void rotatedListTest() {
		LinkedList rotatedList = new LinkedList();

		rotatedList.addNode(4);
		rotatedList.addNode(5);
		rotatedList.addNode(6);
		rotatedList.addNode(1);
		rotatedList.addNode(2);
		rotatedList.addNode(3);

		Node head = rotatedList.head;
		Node rotatedHead = list.rotate(1, 6, 3);

		while (head != null && rotatedHead != null) {
			assertEquals(head.value, rotatedHead.value);
			head = head.next;
			rotatedHead = rotatedHead.next;
		}

	}

	@Test
	public void detectLoopTestPositive() {
		assertFalse(list.detectLoop());
	}

	@Test
	public void detectLoopTestNegative() {
		list.tail.next = list.head;
		assertTrue(list.detectLoop());
	}

}
