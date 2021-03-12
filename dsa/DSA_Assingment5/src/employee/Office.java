package employee;

/**
 * Class to represent a list of employs
 * 
 * @author krishna.meghwal_meta
 * @created-on 11-03-2021
 */
public class Office {
	CustomLinkedList<Employ> employList = new CustomLinkedList<Employ>();

	/**
	 * Method to add an employ in the list
	 * 
	 * @param Employ
	 * @return boolean
	 */
	public boolean addEmploy(Employ e) {
		employList.addNode(e);
		return true;
	}

	/**
	 * Method to sort list of employ according to salary
	 * 
	 * 
	 */
	public void sortAccordingToSalary() {

		CustomNode<Employ> insertPointer = employList.head;
		CustomNode<Employ> currentPointer = employList.head.next;

		while (currentPointer != null) {
			insertPointer = employList.head;
			while (insertPointer != currentPointer) {
				Employ e1 = insertPointer.value;
				Employ e2 = currentPointer.value;

				if (e1.salary < e2.salary
						|| (e1.salary == e2.salary && e1.age > e2.age)) {
					insertPointer.value = currentPointer.value;
					currentPointer.value = e1;
				} else
					insertPointer = insertPointer.next;
			}
			currentPointer = currentPointer.next;
		}

	}

}
