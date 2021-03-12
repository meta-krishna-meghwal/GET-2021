package employee;

/**
 * Class that implements Queue
 * 
 * @created-on 08-03-2021
 * @author krishna.meghwal_meta
 * */
public class CustomQueue<T> implements Queue<T> {

	@Override
	public String toString() {
		return "CustomQueue [queue=" + queue + ", size=" + size + ", front="
				+ front + ", rear=" + rear + "]";
	}

	public CustomLinkedList<T> queue;
	public int size = 0;
	public CustomNode<T> front = null, rear = null;

	public CustomQueue() {
		queue = new CustomLinkedList<T>();

	}

	/**
	 * Method to enqueue an element into queue
	 * 
	 * @param T
	 * @return boolean
	 */
	@Override
	public boolean enQueue(T x) {
		CustomNode<T> node = new CustomNode<T>(x);
		if (this.rear == null) {
			this.front = this.rear = node;
		}
		size++;
		this.rear.next = node;
		this.rear = node;
		return true;
	}

	/**
	 * Method to dequeue an element from queue
	 * 
	 * 
	 * @return T
	 */
	@Override
	public T deQueue() {

		if (this.front == null)
			return null;

		CustomNode<T> temp = this.front;
		this.front = this.front.next;
		
		if (this.front == null)
			this.rear = null;
		size--;
		if(temp != null)
			return temp.value;
		else 
			return null;
	}

	/**
	 * Method to check if queue is empty
	 * 
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		if (front == null) {
			return true;
		}
		return false;
	}

}
