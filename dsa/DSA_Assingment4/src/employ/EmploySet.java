package employ;

import java.util.HashSet;
import java.util.Set;

/**
 * Class to define structure to hold unique employ
 * 
 * @created-on 09-03-2021
 * @author krishna.meghwal_meta
 */
public class EmploySet {
	Set<Employ> employSet = new HashSet<Employ>();

	/**
	 * Method to add a new employ in the set
	 * 
	 * @param Employ
	 * @return Boolean
	 */
	public boolean uniqueEmploy(Employ employ) {
		if (employ == null)
			return false;

		for (Employ e : employSet) {
			if (e.empId == employ.empId) {
				return false;
			}
		}
		employSet.add(employ);
		return true;
	}
}
