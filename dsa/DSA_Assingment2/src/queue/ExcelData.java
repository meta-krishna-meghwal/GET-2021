package queue;

/**
 * Class that reperesent excel sheet structure
 * 
 * @created-on 08-03-2021
 * @author krishna.meghwal_meta
 * */
public class ExcelData {
	public String[][] data;
	public String[] headers;
	public int row, col, currentRow = 0;

	public ExcelData(int row, int col) {
		data = new String[row][col];
		headers = new String[col];
		this.row = row;
		this.col = col;
	}

	/**
	 * Method to add headers to excel data
	 * 
	 * @param String[]
	 *            
	 */
	public void addHeaders(String[] headers) {
		this.headers = headers;
	}

	/**
	 * Method to add row to excel data
	 * 
	 * @param String[]
	 *            
	 */
	public boolean addRow(String[] rowData) {
		if (currentRow < row) {
			for (int i = 0; i < col; i++) {
				data[currentRow][i] = rowData[i];
			}
			currentRow++;
			return true;
		} else
			return false;
	}

}
