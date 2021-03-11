package employ;

/**
 * Class to define structure for Employ
 * 
 * @created-on 09-03-2021
 * @author krishna.meghwal_meta
 */
public class Employ {
	public int empId;
	public String empName;
	public String empAddress;

	public Employ(int id, String name, String address) {
		empId = id;
		empName = name;
		empAddress = address;

	}

	public Employ() {

	}

	@Override
	public String toString() {
		return "Employ [empId=" + empId + ", empName=" + empName
				+ ", empAddress=" + empAddress + "]";
	}

}
