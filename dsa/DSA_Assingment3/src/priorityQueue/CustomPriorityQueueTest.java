package priorityQueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomPriorityQueueTest {
	CustomPriorityQueue pq;
	int max;

	@Before
	public void before() {
		pq = new CustomPriorityQueue(10);
		max = 0;
		for (int i = 0; i < 10; i++) {
			int temp = (int) Math.round(Math.random() * 100);
			pq.enQueue(temp);
			if (temp > max)
				max = temp;
		}

	}

	@Override
	public String toString() {
		return "CustomPriorityQueueTest [pq=" + pq + ", max=" + max + "]";
	}

	@Test
	public void sizeTest() {
		assertEquals(10, pq.size);
	}

	@Test
	public void maxTest() {
		System.out.println(toString());
		assertEquals(max, pq.queue[pq.front]);
	}

}
