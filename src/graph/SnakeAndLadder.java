package graph;

import java.util.*;

public class SnakeAndLadder {
	static class qentry {
		int v;
		int dist;

		qentry() {
		}

		qentry(int v, int dist) {
			this.v = v;
			this.dist = dist;
		}
	}

	static int getMinDiceThrows(int move[], int n) {
		int visited[] = new int[n];
		Queue<qentry> q = new LinkedList<>();
		qentry qe = new qentry(0, 0);

		// Add the first vertex to the queue and mark it visited
		visited[0] = 1;
		q.add(qe);

		// Do BFS
		while (!q.isEmpty()) {
			qe = q.poll();
			int v = qe.v;

			// we have reached the destination
			if (v == n - 1) {
				break;
			}

			// Try out all the six dice possibilities
			for (int j = v + 1; j < v + 6 && j < n; j++) {
				// This checks for the snakes
				if (visited[j] == 0) {
					qentry a = new qentry();
					a.dist = qe.dist + 1;
					visited[j] = 1;
					if (move[j] != -1) {
						a.v = move[j];
					} else {
						a.v = j;
					}
					q.add(a);
				}
			}
		}

		return qe.dist;
	}

	public static void main(String[] args) {
		int N = 30;
		int moves[] = new int[N];
		Arrays.fill(moves, -1);

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;
		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;
		System.out.println(getMinDiceThrows(moves, N));
	}
}
