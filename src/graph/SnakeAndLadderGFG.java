package graph;

import java.util.*;

public class SnakeAndLadderGFG {

	public static void main(String[] args) {
		int arr[] = { 3, 22, 5, 8, 11, 26, 20, 29, 17, 4, 19, 7, 27, 1, 21, 9 };
		System.out.println(minThrow(8, arr));
	}

	static int minThrow(int N, int arr[]) {
		if (N % 2 != 0) {
			return 0;
		}
		int moves[] = new int[30 + 1];
		Arrays.fill(moves, -1);

		for (int i = 0; i < arr.length; i += 2) {
			moves[arr[i]] = arr[i + 1];
		}
		return diceThrow(moves);
	}

	static int diceThrow(int move[]) {
		int visited[] = new int[31];
		Queue<qentry> q = new LinkedList<>();
		qentry qe = new qentry(1, 0);
		visited[1] = 1;
		q.add(qe);

		while (!q.isEmpty()) {
			qe = q.poll();
			int v = qe.v;

			if (v == 30) {
				break;
			}

			for (int j = v + 1; j < v + 6 && j <= 30; j++) {
				if (visited[j] == 0) {
					qentry a = new qentry();
					a.step = qe.step + 1;
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
		return qe.step;
	}

	static class qentry {
		int v;
		int step;

		qentry() {
		}

		qentry(int v, int step) {
			this.v = v;
			this.step = step;
		}
	}
}

// N = 8
// arr[] = {3, 22, 5, 8, 11, 26, 20, 29,
// 17, 4, 19, 7, 27, 1, 21, 9}

// 1
// 22 10

class nothing {
	static class Info {
		int source;
		int destination;

		Info(int source, int destination) {
			this.source = source;
			this.destination = destination;
		}
	}

	static int bfs(Info[] board, int position) {
		if (position == 30)
			return 0;

		LinkedList<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[30 + 1];

		int moves = 0;

		visited[board[1].source] = true;
		visited[board[1].destination] = true;

		queue.add(board[1].destination);

		while (!queue.isEmpty()) {

			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int curr = queue.poll();
				for (int roll = 1; roll <= 6; roll++) {
					int pos = curr + roll;
					if (pos <= 30) {
						int source = board[pos].source;
						int destination = board[pos].destination;
						if (destination == 30) {
							return moves + 1;
						}
						if (!visited[destination]) {
							visited[destination] = true;
							visited[source] = true;
							queue.add(destination);
						}
					}
				}
			}

			moves++;
		}

		return moves;

	}

	static int minThrow(int N, int arr[]) {
		Info[] board = new Info[30 + 1];

		for (int i = 1; i <= 30; i++) {
			board[i] = new Info(i, i);
		}

		for (int i = 0; i < arr.length - 1; i += 2) {
			int src = arr[i];
			int dest = arr[i + 1];
			board[src].source = src;
			board[src].destination = dest;
		}

		return bfs(board, 1);
	}
}