package queue;

/**
 * Class that implements Queue
 * 
 * @created-on 08-03-2021
 * @author krishna.meghwal_meta
 * */
public class CustomQueue implements Queue {
	int[] queue;
	int size = 0;
	int capacity;
	int front = -1, rear = -1;

	public CustomQueue(int size) {
		capacity = size;
		queue = new int[capacity];

	}

	/**
	 * Method to enqueue an element into queue
	 * 
	 * @param int
	 * @return boolean
	 */
	@Override
	public boolean enQueue(int x) {
		if (isFull()) {
			return false;
		} else if (front == -1) {
			front = 0;
			rear = 0;
			queue[rear] = x;
		} else if (rear == capacity - 1 && front != 0) {
			rear = 0;
			queue[rear] = x;
		} else {
			rear++;
			queue[rear] = x;
		}
		size++;
		return true;
	}

	/**
	 * Method to dequeue an element from queue
	 * 
	 * 
	 * @return int
	 */
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

		else if (front == capacity - 1) {
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
	@Override
	public boolean isFull() {
		if (rear == front - 1 || rear == capacity - 1 && front == 0) {
			return true;
		}
		return false;
	}

}
