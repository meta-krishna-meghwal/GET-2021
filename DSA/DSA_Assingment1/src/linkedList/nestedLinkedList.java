package linkedList;

public class nestedLinkedList {
	nestedNode head = null;
	int size = 0;

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

	public void addTerm(int coefficient, int[] powers) {
		nestedNode node = addNestedNode();
		node.addCoefficient(10);
		for (int i : powers) {
			node.addNode(i);
		}
		node.list.printList();
	}

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
