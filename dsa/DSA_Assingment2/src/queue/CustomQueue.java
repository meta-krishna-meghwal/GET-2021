package queue;

public class CustomQueue implements Queue {
	int[] queue;
	int size = 0;
	int capacity;
	int front = -1, rear = -1;

	public CustomQueue(int size) {
		capacity = size;
		queue = new int[capacity];

	}

	@Override
	public boolean enQueue(int x) {
		if (isFull()) {
			return false;
		} else if (front == -1) {
			front = 0;
			rear = 0;
			queue[rear] = x;
		} else if (rear == size - 1 && front != 0) {
			rear = 0;
			queue[rear] = x;
		} else {
			rear++;
			queue[rear] = x;
		}
		size++;
		return true;
	}

	@Override
	public int deQueue() {
		int temp;

		if (isEmpty()) {
			return -1;
		}

		temp = queue[front];

		if (front == rear) {
			front = -1;
			rear = -1;
		}

		else if (front == size - 1) {
			front = 0;
		} else {
			front = front + 1;
		}

		return temp;
	}

	@Override
	public boolean isEmpty() {
		if (front == -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (rear == front - 1 || rear == size - 1 && front == 0) {
			return true;
		}
		return false;
	}

}
