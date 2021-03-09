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
public class CounselStudents implements StringQueue {
	String[] queue;
	int size = 0;
	int front = -1, rear = -1;

	public CounselStudents(int n) throws FileNotFoundException, IOException {
		queue = new String[n];
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
	public static void Processing(int noOfStudents) throws Exception {

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
		CounselStudents.createExcelFile("allocatedCandidates.xlsx", data);
		studentFileInput.close();
		workbook1.close();

	}

	/**
	 * Method to enqueue an element into queue
	 * 
	 * @param String
	 * @return boolean
	 */
	@Override
	public boolean enQueue(String s) {
		if (isFull()) {
			return false;
		} else if (front == -1) {
			front = 0;
			rear = 0;
			queue[rear] = s;
		} else if (rear == queue.length - 1 && front != 0) {
			rear = 0;
			queue[rear] = s;
		} else {
			rear++;
			queue[rear] = s;
		}
		this.size++;
		return true;
	}

	/**
	 * Method to dequeue an element from queue
	 * 
	 * 
	 * @return String
	 */
	@Override
	public String deQueue() {
		String temp;

		if (isEmpty()) {
			return null;
		}

		temp = queue[front];

		if (front == rear) {
			front = -1;
			rear = -1;
		}

		else if (front == queue.length - 1) {
			front = 0;
		} else {
			front = front + 1;
		}

		return temp;

	}

	/**
	 * Method to check if queue is empty
	 * 
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		if (front == -1) {
			return true;
		}

		return false;
	}

	/**
	 * Method to check if queue is full
	 * 
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isFull() {
		if (rear == front - 1 || rear == queue.length - 1 && front == 0) {
			return true;
		}
		return false;
	}

}
