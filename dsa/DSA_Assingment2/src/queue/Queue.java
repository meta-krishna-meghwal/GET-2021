package queue;

/**
 * interface for Queue data structure
 * 
 * @created-on 08-03-2021
 * @author krishna.meghwal_meta
 * */
public interface Queue {

	boolean enQueue(int x);

	int deQueue();

	boolean isEmpty();

	boolean isFull();

}
