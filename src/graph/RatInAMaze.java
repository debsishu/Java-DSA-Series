package graph;

import java.util.ArrayList;

public class RatInAMaze {
	public static void main(String[] args) {

	}

	public ArrayList<String> findPath(int matrix[][], int n) {
		ArrayList<String> result = new ArrayList<>();
		String output = "";
		ratInMaze(matrix, result, 0, 0, output);
		return result;
	}

	private void ratInMaze(int matrix[][], ArrayList<String> result, int i, int j, String output) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0) {
			return;
		}

		if (i == matrix.length - 1 && j == matrix[0].length) {
			result.add(output);
			return;
		}

		matrix[i][j] = 0;

		ratInMaze(matrix, result, i + 1, j, output + "D");
		ratInMaze(matrix, result, i - 1, j, output + "U");
		ratInMaze(matrix, result, i, j + 1, output + "R");
		ratInMaze(matrix, result, i, j - 1, output + "L");

		matrix[i][j] = 1;
	}
}
