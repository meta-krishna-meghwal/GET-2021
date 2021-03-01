package sparseMatrices;

/**
 * Main Class
 * 
 * @author krishna.meghwal_meta
 * @created-on 23-02-2021
 */
public class Main {
	public static void main(String[] args) {
		Integer sparseMatrix1[][] = { { 0, 0, 3, 0, 4 }, { 0, 0, 5, 7, 0 },
				{ 1, 0, 0, 2, 0 }, { 0, 2, 6, 0, 0 } };
		Integer sparseMatrix2[][] = { { 0, 1, 3, 0, 4 }, { 0, 0, 5, 7, 0 },
				{ 2, 0, 0, 0, 0 }, { 0, 2, 6, 0, 0 } };
		SparseMatrix m1 = new SparseMatrix(8, sparseMatrix1);
		SparseMatrix m2 = new SparseMatrix(8, sparseMatrix2);
		Integer[][] sum = SparseMatrix.addMatrix(m1, m2);

	}
}
