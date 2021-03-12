package employee;

/**
 * interface for Queue data structure
 * 
 * @created-on 08-03-2021
 * @author krishna.meghwal_meta
 * */
public interface Queue<T> {

	boolean enQueue(T x);

	T deQueue();

	boolean isEmpty();

}
