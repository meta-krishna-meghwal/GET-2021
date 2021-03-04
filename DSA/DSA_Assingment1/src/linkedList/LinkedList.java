package linkedList;

public class LinkedList {
	Node head = null;
	Node tail = null;
	int size = 0;

	public void addNode(int value) {
		Node newNode = new Node(value);
		if (head == null && tail == null) {
			head = newNode;
			tail = head;
		} else {
			tail.next = newNode;
			tail = tail.next;
		}

		size++;
	}

	@Override
	public String toString() {
		return "LinkedList [head=" + head + ", tail=" + tail + ", size=" + size
				+ "]";
	}

	public void printList() {
		Node curNode = this.head;
		String answer = "";
		while (curNode != null) {
			answer += String.valueOf(curNode.value);
			if (curNode.next != null)
				answer += " -> ";
			curNode = curNode.next;
		}

		System.out.println(answer);
	}

	public Node nthNode(int n) {
		if (n > size || size == 0)
			return null;

		Node curNode = this.head;

		int count = 0;

		while (count < n) {
			curNode = curNode.next;
			count++;
		}
		return curNode;
	}

	public Node rotate(int l, int r, int n) {

		Node curNode = this.head;
		Node prev = null;
		int count = 1;
		if (l >= 1 && l < r && l < size && r <= size) {
			while (count < l) {
				prev = curNode;
				curNode = curNode.next;
				count++;
			}

			Node leftNode = curNode;
			int subListSize = r - l + 1;
			if (n > subListSize) {
				n %= subListSize;
			} else if (n == subListSize) {
				return head;
			}
			Node temp = null;
			while (n < subListSize) {
				subListSize--;
				temp = curNode;
				curNode = curNode.next;
			}

			if (prev != null) {
				prev.next = curNode;

			} else {
				this.head = curNode;
			}

			while (subListSize - 1 > 0) {
				subListSize--;
				curNode = curNode.next;
			}

			if (temp != null && curNode != null) {
				temp.next = curNode.next;
				curNode.next = leftNode;
			}

		}
		return head;
	}

	public boolean detectLoop() {

		Node slow_p = this.head, fast_p = this.head;

		while (slow_p != null && fast_p != null && fast_p.next != null) {
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if (slow_p == fast_p) {
				return true;
			}
		}
		return false;
	}


}
