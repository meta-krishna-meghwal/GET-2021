package employee;

/**
 * Interface for providing methods for Linkedlist
 * 
 * @author krishna.meghwal_meta
 * @created-on 11-03-2021
 */
public interface LinkedList<T> {

	public boolean addNode(T data);

	public void printList();

	public CustomNode<T> nthNode(int n);

}
