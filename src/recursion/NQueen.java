package recursion;

import java.util.*;

public class NQueen {
	public static void main(String[] args) {
		NQueen nq = new NQueen();
		List<List<String>> res = nq.solveNQueens(4);
		for (List<String> e : res) {
			System.out.println(e);
		}
	}

	public List<List<String>> solveNQueens(int n) {
		char board[][] = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(board[i], '.');
		}
		List<List<String>> res = new ArrayList<>();
		solve(0, board, res);
		return res;
	}

	private void solve(int col, char[][] board, List<List<String>> res) {
		if (col == board.length) {
			res.add(construct(board));
			return;
		}

		for (int row = 0; row < board.length; row++) {
			if (isValid(board, row, col)) {
				board[row][col] = 'Q';
				solve(col + 1, board, res);
				board[row][col] = '.';
			}
		}
	}

	private boolean isValid(char[][] board, int row, int col) {
		int tempRow = row;
		int tempCol = col;
		// We have to check only for the left three sides because the right sides will
		// always be empty
		// Check for the upper left diagonal
		while (row >= 0 && col >= 0) {
			if (board[row][col] == 'Q') {
				return false;
			}
			row--;
			col--;
		}

		row = tempRow;
		col = tempCol;
		// Check for the left side
		while (col >= 0) {
			if (board[row][col] == 'Q') {
				return false;
			}
			col--;
		}

		row = tempRow;
		col = tempCol;
		// Check for the bottom left diagonal
		while (col >= 0 && row < board.length) {
			if (board[row][col] == 'Q') {
				return false;
			}
			col--;
			row++;
		}
		return true;
	}

	private List<String> construct(char[][] board) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			res.add(s);
		}
		return res;
	}

}
