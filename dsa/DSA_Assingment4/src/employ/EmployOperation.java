package employ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to perform operations on employ object
 * 
 * @created-on 09-03-2021
 * @author krishna.meghwal_meta
 */
public class EmployOperation {
	List<Employ> employees = new ArrayList<Employ>();

	@Override
	public String toString() {
		return "EmployOperation [employees=" + employees + "]";
	}

	/**
	 * Method to add an employ
	 * 
	 * @param Employ
	 * */
	public void addEmployee(Employ e) {
		employees.add(e);
	}

	/** Method to sort employ list by name */
	public void sortByName() {
		Collections.sort(employees, new EmploySortByName());
	}

	/** Method to sort employ list by id */
	public void sortById() {
		Collections.sort(employees, new EmploySortById());
	}

}
