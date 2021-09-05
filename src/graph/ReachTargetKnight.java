package graph;

import java.util.*;

public class ReachTargetKnight {

	static class cell {
		// the dis variable stores the upto distance from the source
		int x, y, dis;

		public cell(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}

	static boolean isIndide(int x, int y, int N) {
		if (x >= 1 && x <= N && y >= 1 && y <= N) {
			return true;
		}
		return false;
	}

	static int minStepToReachTarget(int knightPos[], int targetPos[], int N) {
		// These are the X and Y coordinates where a knight could move according to
		// chess rule
		int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
		int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

		Queue<cell> q = new LinkedList<>();

		// Add initial posisiton into the queue same as the BFS
		q.add(new cell(knightPos[0], knightPos[1], 0));

		boolean visited[][] = new boolean[N + 1][N + 1];

		visited[knightPos[0]][knightPos[1]] = true;

		// simple BFS
		while (!q.isEmpty()) {
			cell t = q.poll();
			if (t.x == targetPos[0] && t.y == targetPos[1]) {
				return t.dis;
			}

			// visit all of the adjacent positions
			for (int i = 0; i < 8; i++) {
				int x = t.x + dx[i];
				int y = t.y + dy[i];

				if (isIndide(x, y, N) && !visited[x][y]) {
					visited[x][y] = true;
					q.add(new cell(x, y, t.dis + 1));
				}
			}
		}

		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		int N = 30;
		int knightPos[] = { 1, 1 };
		int targetPos[] = { 30, 30 };

		System.out.println(minStepToReachTarget(knightPos, targetPos, N));
	}

}
