package employee;

/**
 * Class to create a custom node for a linkedlist
 * 
 * @author krishna.meghwal_meta
 * @created-on 11-03-2021
 */
public class CustomNode<T> {
	public T value;
	public CustomNode<T> next;

	public CustomNode(T value) {
		this.value = value;
		next = null;
	}

}
