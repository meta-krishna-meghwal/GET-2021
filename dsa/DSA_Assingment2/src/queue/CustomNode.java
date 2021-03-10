package queue;

public class CustomNode<T> {
	public T value;
	public CustomNode<T> next;

	public CustomNode(T value) {
		this.value = value;
		next = null;
	}

}
