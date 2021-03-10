package priorityQueue;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {
	Bowling bw;
	int totalBowls = 0;

	@Before
	public void before() {
		bw = new Bowling(10);
		for (int i = 1; i <= 10; i++) {
			int bowls = (int) Math.round(Math.random() * 10);
			totalBowls += bowls;
			Bowler b = new Bowler(i, bowls);
			bw.enQueue(b);
		}
	}

	@Test
	public void ChooseBowlerTest() {
		List<Bowler> order = bw.chooseToBowl(totalBowls);

		for (int i = 0; i < order.size() - 1; i++) {
			assertTrue(order.get(i).bowlsLeft >= order.get(i + 1).bowlsLeft);
		}

	}

}
