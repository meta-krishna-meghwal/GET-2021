package linkedList;

/**
 * Class to create nested node
 * 
 * @author krishna.meghwal_meta
 * @created-on 04-03-2021
 */
public class NestedNode {
	LinkedList list = null;
	int coefficient;
	NestedNode next;

	/**
	 * Method to add node to lisnked list
	 * 
	 * @param int
	 */
	public void addNode(int value) {
		if (list == null) {
			list = new LinkedList();
		}
		list.addNode(value);
	}

	/**
	 * Method to add coefficient
	 * 
	 * @param int coefficient
	 */
	public void addCoefficient(int coefficient) {
		if (list == null) {
			list = new LinkedList();
		}
		this.coefficient = coefficient;
	}
}
