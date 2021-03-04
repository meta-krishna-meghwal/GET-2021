package linkedList;

public class nestedNode {
	LinkedList list = null;
	int coefficient;
	nestedNode next;

	public void addNode(int value) {
		if(list == null){
			list = new LinkedList();
		}
		list.addNode(value);
	}
	
	public void addCoefficient(int coefficient) {
		if(list == null){
			list = new LinkedList();
		}
		this.coefficient = coefficient;
	}
}
