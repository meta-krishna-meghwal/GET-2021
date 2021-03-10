package queue;

public class CustomLinkedList<T> implements LinkedList<T> {
	CustomNode<T> head = null;
	CustomNode<T> tail = null;
	public int size = 0;

	/**
	 * Method to add a node LinkedList
	 * 
	 * @param T
	 * @return boolean
	 */
	@Override
	public boolean addNode(T value) {
		CustomNode<T> newNode = new CustomNode<T>(value);
		if (head == null && tail == null) {
			head = newNode;
			tail = head;
		} else {
			tail.next = newNode;
			tail = tail.next;
		}

		size++;
		return false;
	}

	/** Method to print linkedlist */
	@Override
	public void printList() {
		CustomNode<T> curNode = this.head;
		String answer = "";
		while (curNode != null) {
			answer += String.valueOf(curNode.value);
			if (curNode.next != null)
				answer += " -> ";
			curNode = curNode.next;
		}

		System.out.println(answer);
	}

	/**
	 * Method to get nth node
	 * 
	 * @param int
	 * @return CustomNode<T>
	 */
	@Override
	public CustomNode<T> nthNode(int n) {
		if (n > size || size == 0)
			return null;

		CustomNode<T> curNode = this.head;

		int count = 0;

		while (count < n) {
			curNode = curNode.next;
			count++;
		}
		return curNode;

	}
	
	public int getSize(){
		return size;
	}

}
