package queue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Class that implements StringQueue
 * 
 * @created-on 08-03-2021
 * @author krishna.meghwal_meta
 * */
public class CounselStudents extends CustomStringQueue {

	public CounselStudents(int n) throws FileNotFoundException, IOException {
		super(n);
	}

	/**
	 * Method to create excel sheet from ExcelData object
	 * 
	 * @param String
	 * @param ExcelData
	 * */
	public static void createExcelFile(String fileName, ExcelData excelData)
			throws IOException {
		Workbook wb = new XSSFWorkbook();

		OutputStream File = new FileOutputStream(fileName);
		Sheet sheet = wb.createSheet();

		Row headers = sheet.createRow(0);
		int i = 0;
		for (String header : excelData.headers) {
			headers.createCell(i++).setCellValue(header);
		}

		for (int r = 1; r <= excelData.row; r++) {
			Row row = sheet.createRow(r);
			for (int c = 0; c < excelData.col; c++) {
				row.createCell(c).setCellValue(excelData.data[r - 1][c]);
			}
		}

		wb.write(File);
		File.close();
		wb.close();
	}

	/**
	 * Method to process programs excel file
	 * 
	 * */
	public void programProcessing() throws Exception {

		File programFile = new File("programs.xlsx");
		FileInputStream programFileInput = new FileInputStream(programFile);
		Workbook workbook2 = new XSSFWorkbook(programFileInput);
		Sheet programsSheet = workbook2.getSheetAt(0);
		int k = 0;
		for (Row program : programsSheet) {
			if (k == 0) {
				k++;
				continue;
			}

			String name = String.valueOf(program.getCell(0));
			int capacity = Integer.parseInt(String.valueOf(program.getCell(1)));
			Program p = new Program(name, capacity);
			Program.addProgram(p);
		}
		programFileInput.close();
		workbook2.close();

	}

	/**
	 * Method to process programs students excel file
	 * 
	 * @param int
	 * */
	public static boolean Processing(int noOfStudents) throws Exception {

		CounselStudents process = new CounselStudents(noOfStudents);

		process.programProcessing();
		File studentFile = new File("students.xlsx");
		FileInputStream studentFileInput = new FileInputStream(studentFile);
		Workbook workbook1 = new XSSFWorkbook(studentFileInput);
		Sheet studentsSheet = workbook1.getSheetAt(0);

		for (int k = 0; k < noOfStudents; k++) {
			Row student = studentsSheet.getRow(k + 1);
			String name = String.valueOf(student.getCell(0));
			process.enQueue(name);

		}

		ExcelData data = new ExcelData(noOfStudents, 2);
		String headers[] = { "Student name", "Program" };
		data.addHeaders(headers);

		for (int k = 0; k < noOfStudents; k++) {

			Row student = studentsSheet.getRow(k + 1);
			String[] row = new String[2];
			int i = 0;
			for (Cell col : student) {
				if (i == 0) {
					row[0] = process.deQueue();
					i++;
				} else {
					boolean placeFound = false;
					for (Program p : Program.programList) {
						if (p.programName.equals(col.getStringCellValue())
								&& p.capacity > 0) {
							p.capacity--;
							row[1] = p.programName;
							placeFound = true;
							break;
						}
					}
					if (placeFound)
						break;
				}
			}
			data.addRow(row);

		}

		try {
			CounselStudents.createExcelFile("allocatedCandidates.xlsx", data);
			studentFileInput.close();
			workbook1.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

}
