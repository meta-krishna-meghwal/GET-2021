package queue;


public interface LinkedList<T> {
	
	public boolean addNode(T data);

	public void printList();

	public CustomNode<T> nthNode(int n);

}
