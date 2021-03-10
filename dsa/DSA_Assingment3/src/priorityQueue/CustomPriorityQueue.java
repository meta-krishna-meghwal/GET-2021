package priorityQueue;

public class CustomPriorityQueue implements PriorityQueue<Integer> {
	public int[] queue;
	public int front = -1, rear = -1, capacity, size = 0;

	public CustomPriorityQueue(int capacity) {
		queue = new int[capacity];
		this.capacity = capacity;
	}

	@Override
	public boolean isEmpty() {
		if (front == -1)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if (rear == capacity - 1) {
			return true;
		}
		return false;
	}

	@Override
	public Integer deQueue() {
		int temp;
		if (isEmpty()) {
			return -1;
		}

		if (front == 0 && rear == 0) {
			temp = queue[front];
			front = -1;
			rear = -1;

		} else {
			temp = queue[front++];

		}
		size--;
		return temp;
	}

	@Override
	public Integer peek() {
		if (front == -1)
			return -1;

		return queue[front];
	}

	@Override
	public boolean enQueue(Integer x) {
		if (isFull()) {
			return false;
		} else if (front == -1 && rear == -1) {
			front = 0;
			rear = 0;
			queue[rear] = x;

		} else {
			int pos = rear;
			rear++;
			while (pos >= 0 && queue[pos] < x) {
				queue[pos + 1] = queue[pos];
				pos--;
			}
			queue[pos + 1] = x;

		}
		size++;
		return true;
	}

}
