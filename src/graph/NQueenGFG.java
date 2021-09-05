package graph;

import java.util.ArrayList;

public class NQueenGFG {

	static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

	static boolean isSafe(int board[][], int row, int col) {
		int i, j;
		// This is for checking if a queen is already placed in that col
		for (i = 0; i < col; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}
		// This is for checking left diagonal
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		// This is for checking right diagonal
		for (i = row, j = col; i >= 0 && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	static boolean solveUtil(int board[][], int col) {
		int N = board.length;
		if (col == N) {
			ArrayList<Integer> v = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 1) {
						v.add(j + 1);
					}
				}
			}
			res.add(v);
			return true;
		}

		boolean result = false;
		for (int i = 0; i < N; i++) {
			if (isSafe(board, i, col)) {
				board[i][col] = 1;
				result = solveUtil(board, col + 1);
				board[i][col] = 0;
			}
		}
		return result;
	}

	static ArrayList<ArrayList<Integer>> nQueen(int n) {
		res.clear();
		int board[][] = new int[n][n];
		solveUtil(board, 0);
		return res;
	}

}
