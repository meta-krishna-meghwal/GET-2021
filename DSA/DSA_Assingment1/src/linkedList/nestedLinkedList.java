package linkedList;

/**
 * Class to create nested Linked List
 * 
 * @author krishna.meghwal_meta
 * @created-on 04-03-2021
 */
public class nestedLinkedList {
	nestedNode head = null;
	int size = 0;

	/**
	 * Method to add a nested node
	 * 
	 * @return nestedNode
	 */
	public nestedNode addNestedNode() {
		if (head == null) {
			head = new nestedNode();
			size++;
			return head;
		}

		nestedNode curNode = head;
		while (curNode != null) {
			curNode = curNode.next;
		}

		curNode = new nestedNode();
		size++;
		return curNode;

	}

	/**
	 * Method to add a term of any equation
	 * 
	 * @param int coefficient : coefficient of the term
	 * @param int[] powers: array of powers of variables
	 */
	public void addTerm(int coefficient, int[] powers) {
		nestedNode node = addNestedNode();
		node.addCoefficient(10);
		for (int i : powers) {
			node.addNode(i);
		}
		node.list.printList();
	}

	/**
	 * Method to find out maximum degree
	 * 
	 * @return int
	 */
	public int maxDegree() {
		int max = 0;

		if (head != null) {

			nestedNode curNestedNode = head;

			while (curNestedNode != null) {
				int sum = 0;
				LinkedList list = curNestedNode.list;
				Node curNode = list.head;

				while (curNode != null) {
					sum += curNode.value;
				}

				max = Math.max(sum, max);
			}

		}

		return max;

	}
}
