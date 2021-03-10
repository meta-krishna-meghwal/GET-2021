package priorityQueue;

import java.util.ArrayList;
import java.util.List;

public class Bowling implements PriorityQueue<Bowler> {
	int size = 0, capacity, front = -1, rear = -1;
	Bowler[] bowlers;

	public Bowling(int noOfBowlers) {
		bowlers = new Bowler[noOfBowlers];
		capacity = noOfBowlers;

	}

	@Override
	public boolean enQueue(Bowler b) {
		if (isFull()) {
			return false;
		} else if (front == -1 && rear == -1) {
			front = 0;
			rear = 0;
			bowlers[rear] = b;

		} else {
			int pos = rear;
			rear++;
			while (pos >= 0 && bowlers[pos].bowlsLeft < b.bowlsLeft) {

				bowlers[pos + 1] = bowlers[pos];

				pos--;
			}
			bowlers[pos + 1] = b;

		}
		size++;
		return true;

	}

	public List<Bowler> chooseToBowl(int totalBowls) {
		List<Bowler> order = new ArrayList<Bowler>();
		while (totalBowls > 0) {
			Bowler currentBowler = deQueue();
			order.add(currentBowler);
			if (currentBowler != null) {
				System.out.println(currentBowler.toString() + " "
						+ peek().toString());
				if (currentBowler.bowlsLeft > 0) {
					int temp = currentBowler.bowlsLeft;
					if (peek().bowlsLeft > 0) {
						currentBowler.bowlsLeft = peek().bowlsLeft - 1;
					} else {
						currentBowler.bowlsLeft = 0;
					}

					totalBowls = totalBowls - (temp - currentBowler.bowlsLeft);
				}
				if (currentBowler.bowlsLeft > 0)
					enQueue(currentBowler);
				else {
					break;
				}
			}
		}
		
		return order;

	}

	@Override
	public Bowler deQueue() {
		if (isEmpty()) {
			return null;
		}
		int pos = 0;
		Bowler temp = bowlers[pos];

		while (pos < rear) {
			bowlers[pos] = bowlers[pos + 1];
			pos++;
		}
		size--;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		if (front == -1)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if (rear == front - 1 || rear == capacity - 1 && front == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Bowler peek() {
		if (front == -1)
			return null;

		return bowlers[front];
	}

}
