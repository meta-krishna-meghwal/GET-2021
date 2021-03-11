package employ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/** @author krishna.meghwal_meta */
public class EmployOperationTest {
	EmployOperation e;

	@Before
	public void before() {
		e = new EmployOperation();
		int salt = 15;
		for (int i = 1; i <= 10; i++) {
			salt += 5;
			String name = "Name" + String.valueOf(salt);
			int id = salt;
			String address = "Address" + String.valueOf(salt);

			Employ employ = new Employ(id, name, address);
			e.addEmployee(employ);
		}
	}

	@Test
	public void SortByNameTest() {
		System.out.println(e.toString());
		e.sortByName();
		System.out.println(e.toString());

		for (int i = 0; i < e.employees.size() - 1; i++) {
			Employ e1 = e.employees.get(i);
			Employ e2 = e.employees.get(i + 1);

			assertTrue(e2.empName.compareTo(e1.empName) > 0);
		}
	}

	@Test
	public void SortByIdTest() {
		System.out.println(e.toString());
		e.sortById();
		System.out.println(e.toString());

		for (int i = 0; i < e.employees.size() - 1; i++) {
			Employ e1 = e.employees.get(i);
			Employ e2 = e.employees.get(i + 1);

			assertTrue(e1.empId < e2.empId);
		}
	}

	@Test
	public void createUniqueSetTest() {
		EmploySet e = new EmploySet();
		int salt = 15;
		for (int i = 1; i <= 10; i++) {
			salt += 5;
			String name = "Name" + String.valueOf(salt);
			int id = salt;
			String address = "Address" + String.valueOf(salt);

			Employ employ = new Employ(id, name, address);
			assertTrue(e.uniqueEmploy(employ));
			assertFalse(e.uniqueEmploy(null));

		}

	}
}