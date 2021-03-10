package priorityQueue;

public interface PriorityQueue<T> {

	boolean enQueue(T x);

	T deQueue();

	boolean isEmpty();

	boolean isFull();

	T peek();
}
