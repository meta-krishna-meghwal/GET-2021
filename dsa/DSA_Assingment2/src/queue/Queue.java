package queue;

public interface Queue {

	boolean enQueue(int x);

	int deQueue();

	boolean isEmpty();

	boolean isFull();

}
