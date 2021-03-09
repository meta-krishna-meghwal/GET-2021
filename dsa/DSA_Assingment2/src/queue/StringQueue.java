package queue;

/**
 * interface for Queue data structure
 * 
 * @created-on 08-03-2021
 * @author krishna.meghwal_meta
 * */
public interface StringQueue {
	boolean enQueue(String s);

	String deQueue();

	boolean isEmpty();

	boolean isFull();
}
