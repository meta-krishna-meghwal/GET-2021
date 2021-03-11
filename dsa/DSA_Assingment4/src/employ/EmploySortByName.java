package employ;

import java.util.Comparator;

/**
 * Class to implement Comparator interface for employ
 * 
 * @created-on 09-03-2021
 * @author krishna.meghwal_meta
 */
public class EmploySortByName implements Comparator<Employ> {

	/**
	 * Overridden method to compare two employ objects
	 * 
	 * @param Employ
	 * @param Employ
	 * @return int
	 */
	@Override
	public int compare(Employ e1, Employ e2) {
		return e1.empName.compareTo(e2.empName);
	}

}
