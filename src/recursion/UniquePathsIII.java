package recursion;

public class UniquePathsIII {
	public static void main(String[] args) {
		int grid[][] = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
		System.out.println(uniquePaths(grid));
	}

	public static int uniquePaths(int grid[][]) {
		int zero = 0;
		int starti = 0, startj = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					zero++;
				} else if (grid[i][j] == 1) {
					starti = i;
					startj = j;
				}
			}
		}
		return solve(starti, startj, grid, zero);
	}

	private static int solve(int i, int j, int grid[][], int zero) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) {
			return 0;
		}
		if (grid[i][j] == 2) {
			return zero == -1 ? 1 : 0;
		}

		grid[i][j] = -1;
		zero--;

		int res = solve(i + 1, j, grid, zero) + solve(i, j + 1, grid, zero) + solve(i - 1, j, grid, zero)
				+ solve(i, j - 1, grid, zero);

		grid[i][j] = 0;
		zero++;
		return res;
	}
}
