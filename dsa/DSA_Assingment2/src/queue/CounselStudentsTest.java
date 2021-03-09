package queue;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CounselStudentsTest {
	@Before
	public void before() throws IOException {
		ExcelData programs = new ExcelData(10, 2);
		ExcelData students = new ExcelData(300, 6);

		String[] headers1 = { "Program Name", "Program Capacity" };
		String[] headers2 = { "Student Name", "Preference-1", "Preference-2",
				"Preference-3", "Preference-4", "Preference-5" };

		programs.addHeaders(headers1);
		students.addHeaders(headers2);

		for (int i = 1; i <= 10; i++) {
			String[] row = { "IT" + String.valueOf(i),
					String.valueOf(Math.round(Math.random() * 100)) };
			programs.addRow(row);
		}

		for (int i = 1; i <= 300; i++) {
			String[] row = {
					"Name" + String.valueOf(i),
					"IT"
							+ String.valueOf((i + Math.round(Math.random()) * 10) % 11),
					"IT"
							+ String.valueOf((i + Math.round(Math.random()) * 10) % 11),
					"IT"
							+ String.valueOf((i + Math.round(Math.random()) * 10) % 11),
					"IT"
							+ String.valueOf((i + Math.round(Math.random()) * 10) % 11),
					"IT"
							+ String.valueOf((i + Math.round(Math.random()) * 10) % 11) };
			students.addRow(row);
		}

		CounselStudents.createExcelFile("programs.xlsx", programs);
		CounselStudents.createExcelFile("students.xlsx", students);
	}

	@Test
	public void FileCreationTest() throws Exception {
		assertTrue(CounselStudents.Processing(300));
	}

}
