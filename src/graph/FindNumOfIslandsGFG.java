package graph;

public class FindNumOfIslandsGFG {
	public static void main(String[] args) {

	}

	boolean isSafe(char graph[][], int row, int col, boolean visited[][]) {
		return (row >= 0 && row < graph.length && col >= 0 && col < graph[0].length && graph[row][col] == '1'
				&& !visited[row][col]);
	}

	int findIslands(char graph[][]) {
		boolean visited[][] = new boolean[graph.length][graph[0].length];

		int count = 0;
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				if (isSafe(graph, i, j, visited)) {
					DFS(graph, i, j, visited);
					count++;
				}
			}
		}
		return count;
	}

	void DFS(char graph[][], int row, int col, boolean visited[][]) {
		int rowNum[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNum[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[row][col] = true;
		for (int i = 0; i < 8; i++) {
			if (isSafe(graph, row + rowNum[i], col + colNum[i], visited)) {
				DFS(graph, row + rowNum[i], col + colNum[i], visited);
			}
		}
	}

}

class leetCodeSol {
	int n;
	int m;

	int numOfIslands(char grid[][]) {
		n = grid.length;
		if (n == 0)
			return 0;
		m = grid[0].length;
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					DFSMark(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	void DFSMark(char grid[][], int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
			return;
		}

		grid[i][j] = '0';

		DFSMark(grid, i + 1, j);
		DFSMark(grid, i - 1, j);
		DFSMark(grid, i, j + 1);
		DFSMark(grid, i, j - 1);
	}
}
