package employee;

/**
 * Class to provide structure for an employ
 * 
 * @author krishna.meghwal_meta
 * @created-on 11-03-2021
 */
public class Employ {
	public int salary, age;

	public Employ(int age, int salary) {
		this.salary = salary;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employ [salary=" + salary + ", age=" + age + "]";
	}

}
