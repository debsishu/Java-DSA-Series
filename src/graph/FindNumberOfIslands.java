package graph;

public class FindNumberOfIslands {
	public static void main(String[] args) {
		int graph[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		FindNumberOfIslands sol = new FindNumberOfIslands();
		System.out.println(sol.countIslands(graph));
	}

	static final int ROW = 5, COL = 5;

	boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
		return (row >= 0 && row < ROW && col >= 0 && col < COL && M[row][col] == 1 && !visited[row][col]);
	}

	void DFS(int graph[][], int row, int col, boolean visited[][]) {
		int rowNum[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNum[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[row][col] = true;

		for (int k = 0; k < 8; k++) {
			if (isSafe(graph, row + rowNum[k], col + colNum[k], visited)) {
				DFS(graph, row + rowNum[k], col + colNum[k], visited);
			}
		}
	}

	int countIslands(int graph[][]) {
		boolean visited[][] = new boolean[ROW][COL];

		int count = 0;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (graph[i][j] == 1 && !visited[i][j]) {
					DFS(graph, i, j, visited);
					count++;
				}
			}
		}

		return count;
	}

}
