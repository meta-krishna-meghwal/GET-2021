package nQueen;

/**
 * Implementation of N Queens Problem using Recursion
 * 
 * @author krishna.meghwal_meta
 * @created-on 01-03-2021
 */

public class nQueen {

	static int noOfQueens;

	/**
	 * Method to implement nqueen algorithm
	 * 
	 * @param int : number of queens
	 * @return boolean
	 * */
	public static boolean nQueens(int n) {
		noOfQueens = n;

		int[][] board = new int[noOfQueens][noOfQueens];

		for (int row = 0; row < noOfQueens; row++) {
			for (int col = 0; col < noOfQueens; col++) {
				board[row][col] = 0;
			}
		}
		return printNQueens(board, 0, noOfQueens);

	}

	/**
	 * Method to place and print queens
	 * 
	 * @param int[][]board
	 * @param int currentRow
	 * @param int dimensionOfMatrix
	 * @return boolean
	 */
	static boolean printNQueens(int[][] board, int currentRow,
			int dimensionOfMatrix) {

		if (currentRow == dimensionOfMatrix) {
			String answer = "";
			for (int row = 0; row < dimensionOfMatrix; row++) {
				for (int col = 0; col < dimensionOfMatrix; col++) {
					if (board[row][col] == 1)
						answer += "Q ";
					else
						answer += "_ ";
				}
				answer += "\n";
			}
			System.out.println(answer);
			return true;

		} else {
			for (int col = 0; col < dimensionOfMatrix; col++) {
				if (isSafe(board, currentRow, col, dimensionOfMatrix)) {
					board[currentRow][col] = 1;
					if (printNQueens(board, currentRow + 1, noOfQueens)) {
						return true;
					}
					board[currentRow][col] = 0;
				}
			}
		}

		return false;
	}

	/**
	 * Method to check if the placing queen is safe at a particular cell
	 * 
	 * @param int[][]board
	 * @param int currentRow
	 * @param int col
	 * @param int dimensionOfMatrix
	 * @return boolean
	 */
	private static boolean isSafe(int[][] board, int currentRow, int col,
			int dimensionOfMatrix) {
		for (int row = 0; row < currentRow; row++) {
			if (board[row][col] == 1) {
				return false;
			}
		}

		int x = currentRow, y = col;
		while (x >= 0 && y >= 0) {
			if (board[x][y] == 1) {
				return false;
			}
			x--;
			y--;
		}

		x = currentRow;
		y = col;
		while (x >= 0 && y < dimensionOfMatrix) {
			if (board[x][y] == 1) {
				return false;
			}
			x--;
			y++;
		}
		return true;
	}
}
