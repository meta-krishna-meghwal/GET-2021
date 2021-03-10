package queue;

public class CustomStringQueue implements Queue<String> {
	String[] queue;
	int size = 0;
	int front = -1, rear = -1;

	public CustomStringQueue(int n) {
		queue = new String[n];
	}

	/**
	 * Method to enqueue an element into queue
	 * 
	 * @param String
	 * @return boolean
	 */
	@Override
	public boolean enQueue(String s) {
		if (isFull()) {
			return false;
		} else if (front == -1) {
			front = 0;
			rear = 0;
			queue[rear] = s;
		} else if (rear == queue.length - 1 && front != 0) {
			rear = 0;
			queue[rear] = s;
		} else {
			rear++;
			queue[rear] = s;
		}
		this.size++;
		return true;
	}

	/**
	 * Method to dequeue an element from queue
	 * 
	 * 
	 * @return String
	 */
	@Override
	public String deQueue() {
		String temp;

		if (isEmpty()) {
			return null;
		}

		temp = queue[front];

		if (front == rear) {
			front = -1;
			rear = -1;
		}

		else if (front == queue.length - 1) {
			front = 0;
		} else {
			front = front + 1;
		}

		return temp;

	}

	/**
	 * Method to check if queue is empty
	 * 
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		if (front == -1) {
			return true;
		}

		return false;
	}

	/**
	 * Method to check if queue is full
	 * 
	 * 
	 * @return boolean
	 */

	public boolean isFull() {
		if (rear == front - 1 || rear == queue.length - 1 && front == 0) {
			return true;
		}
		return false;
	}

}
