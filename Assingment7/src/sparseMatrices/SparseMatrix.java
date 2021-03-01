package sparseMatrices;

/**
 * Class to perform operations on parse matrix
 * 
 * @author krishna.meghwal_meta
 * @created-on 23-02-2021
 */
public final class SparseMatrix {

	private final Integer[][] sparseMatrix;
	private final int nonZeroCount;
	private final int rows;
	private final int columns;

	public SparseMatrix(int count, Integer[][] matrix) {

		this.sparseMatrix = new Integer[count][3];
		this.nonZeroCount = count;
		int rows = matrix.length;
		this.rows = rows;

		if (rows != 0) {
			int cols = matrix[0].length;
			this.columns = cols;
			int k = 0;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (matrix[i][j] != 0) {
						sparseMatrix[k][0] = i;
						sparseMatrix[k][1] = j;
						sparseMatrix[k][2] = matrix[i][j];
						k++;
					}
				}
			}
		} else {
			this.columns = 0;
			System.out.println("Empty matrix!!");
		}
	}

	/**
	 * Method to get number of rows
	 * 
	 * @return int
	 */
	public int getRows() {
		return this.rows;
	}

	/**
	 * Method to get number of non zero element
	 * 
	 * @return int
	 */
	public int getnonZeroCount() {
		return this.nonZeroCount;
	}

	/**
	 * Method to get number of columns
	 * 
	 * @return int
	 */
	public int getCols() {
		return this.columns;
	}

	/**
	 * Method to get sparse matrix
	 * 
	 * @return Integer[][]
	 */
	public Integer[][] getSparseMatrix() {
		return this.sparseMatrix;
	}

	/**
	 * Method to convert matrix
	 * 
	 * @param Integer
	 *            [][] sparseMatrix
	 * @param int rows
	 * @param int cols
	 * @return Integer[][]
	 */
	private static Integer[][] formMatrix(Integer[][] sparseMatrix, int rows,
			int cols) {

		int count = sparseMatrix.length;
		Integer[][] matrix = null;

		if (rows > 0 && cols > 0) {
			matrix = new Integer[rows][cols];

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					matrix[i][j] = 0;
				}
			}

			for (int i = 0; i < count; i++) {

				int r = sparseMatrix[i][0];
				int c = sparseMatrix[i][1];
				int value = sparseMatrix[i][2];

				matrix[r][c] = value;
			}
		}

		return matrix;

	}

	/**
	 * Method to transpose a matrix
	 * 
	 * @return Integer [][]
	 */
	public Integer[][] transpose() {

		Integer[][] transposeMatrix = null;
		if (this.rows == this.columns) {
			transposeMatrix = new Integer[this.nonZeroCount][3];
			for (int i = 0; i < this.nonZeroCount; i++) {
				transposeMatrix[i][0] = this.sparseMatrix[i][1];
				transposeMatrix[i][1] = this.sparseMatrix[i][0];
				transposeMatrix[i][2] = this.sparseMatrix[i][2];
			}
		}

		return transposeMatrix;
	}

	/**
	 * Method to check if the matrix is symmetrical
	 * 
	 * @return boolean
	 */
	public boolean isSymmetrical() {

		Integer[][] transposeMatrix = SparseMatrix.formMatrix(this.transpose(),
				this.rows, this.columns);
		Integer[][] matrix = SparseMatrix.formMatrix(this.getSparseMatrix(),
				this.rows, this.columns);

		if (transposeMatrix != null && matrix != null) {
			for (int i = 0; i < this.rows; i++) {
				for (int j = 0; j < this.columns; j++) {
					if (transposeMatrix[i][j] != matrix[i][j]) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Method to add two matrix
	 *
	 * @param SparseMatrix
	 *            m1
	 * @param SparseMatrix
	 *            m2
	 * @return Integer[][]
	 */
	public static Integer[][] addMatrix(SparseMatrix m1, SparseMatrix m2) {

		int r1 = m1.getRows();
		int c1 = m1.getCols();
		int r2 = m2.getRows();
		int c2 = m2.getCols();
		int nonZeroCount1 = m1.getnonZeroCount();
		int nonZeroCount2 = m2.getnonZeroCount();
		Integer[][] result = null;

		if (r1 == r2 && c1 == c2) {

			Integer[][] sparseMatrix1 = m1.getSparseMatrix();
			Integer[][] sparseMatrix2 = m2.getSparseMatrix();
			int maxCount = nonZeroCount1 + nonZeroCount2;

			result = new Integer[maxCount][3];
			int index1 = 0, index2 = 0;
			int curIndex = 0;
			while (index1 < nonZeroCount1 && index2 < nonZeroCount2) {

				int row1 = sparseMatrix1[index1][0];
				int col1 = sparseMatrix1[index1][1];
				int val1 = sparseMatrix1[index1][2];

				int row2 = sparseMatrix2[index2][0];
				int col2 = sparseMatrix2[index2][1];
				int val2 = sparseMatrix2[index2][2];

				if (row1 < row2) {
					result[curIndex][0] = row1;
					result[curIndex][1] = col1;
					result[curIndex][2] = val1;
					index1++;
				} else if (row1 > row2) {
					result[curIndex][0] = row2;
					result[curIndex][1] = col2;
					result[curIndex][2] = val2;
					index2++;
				} else {
					if (col1 > col2) {
						result[curIndex][0] = row2;
						result[curIndex][1] = col2;
						result[curIndex][2] = val2;
						index2++;
					} else if (col1 < col2) {
						result[curIndex][0] = row1;
						result[curIndex][1] = col1;
						result[curIndex][2] = val1;
						index1++;
					} else {
						result[curIndex][0] = row1;
						result[curIndex][1] = col1;
						result[curIndex][2] = val1 + val2;
						index1++;
						index2++;
					}
				}

				curIndex++;
			}

			while (index1 < nonZeroCount1) {
				int row1 = sparseMatrix1[index1][0];
				int col1 = sparseMatrix1[index1][1];
				int val1 = sparseMatrix1[index1++][2];

				result[curIndex][0] = row1;
				result[curIndex][1] = col1;
				result[curIndex++][2] = val1;
			}

			while (index2 < nonZeroCount2) {
				int row2 = sparseMatrix2[index1][0];
				int col2 = sparseMatrix2[index1][1];
				int val2 = sparseMatrix2[index1++][2];

				result[curIndex][0] = row2;
				result[curIndex][1] = col2;
				result[curIndex++][2] = val2;
			}
		}
		return result;
	}

	/**
	 * Method to multiply two matrix
	 *
	 * @param Integer
	 *            [][] m1
	 * @param Integer
	 *            [][] m2
	 * @return Integer[][]
	 */
	public static Integer[][] multiplyMatrix(Integer[][] m1, Integer[][] m2) {

		Integer[][] result = null;
		if (m1 != null && m2 != null) {
			int r1 = m1.length;
			int c1 = m1[0].length;
			int r2 = m2.length;
			int c2 = m2[0].length;
			if (c1 == r2) {
				result = new Integer[r1][c2];
				for (int i = 0; i < r1; i++) {
					for (int j = 0; j < c2; j++) {
						result[i][j] = 0;
						for (int k = 0; k < r2; k++) {
							result[i][j] += m1[i][k] * m2[k][j];
						}
					}
				}
			}
		}
		return result;
	}

}
