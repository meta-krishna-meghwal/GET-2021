package employee;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OfficeTest {
	Office o1;

	@Before
	public void before() {
		o1 = new Office();
		for (int i = 0; i < 10; i++) {
			int age = (int) Math.round(Math.random() * 50);
			int salary = (int) Math.round(Math.random() * 10000);
			Employ e = new Employ(age, salary);
			o1.addEmploy(e);
		}
	}

	@Test
	public void SalaryTest() {

		o1.employList.printList();
		o1.sortAccordingToSalary();
		o1.employList.printList();

		for (int i = 0; i < o1.employList.getSize() - 1; i++) {
			Employ e1 = o1.employList.nthNode(i).value;
			Employ e2 = o1.employList.nthNode(i + 1).value;
			System.out.println(String.valueOf(e1.salary) + " "
					+ String.valueOf(e2.salary));
			assertTrue(e1.salary > e2.salary
					|| (e1.salary == e2.salary && e1.age <= e2.age));
		}
	}
}
