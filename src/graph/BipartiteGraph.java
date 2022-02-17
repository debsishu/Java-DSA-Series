package graph;

import java.util.*;

public class BipartiteGraph {
	public static void main(String[] args) {

	}

	static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
		int color[] = new int[V];
		Arrays.fill(color, -1);
		for (int i = 0; i < V; i++) {
			if (color[i] == -1) {
				if (!checkDFS(i, adj, color)) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean checkBFS(int node, ArrayList<ArrayList<Integer>> adj, int color[]) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		color[node] = 1;

		while (!q.isEmpty()) {
			int tempNode = q.poll();

			for (Integer it : adj.get(tempNode)) {
				if (color[it] == -1) {
					color[it] = 1 - color[tempNode];
					q.add(it);
				} else if (color[it] == color[tempNode]) {
					return false;
				}
			}
		}

		return true;
	}

	static boolean checkDFS(int node, ArrayList<ArrayList<Integer>> adj, int color[]) {
		if (color[node] == -1) {
			color[node] = 1;
		}

		for (Integer it : adj.get(node)) {
			if (color[it] == -1) {
				if (!checkDFS(it, adj, color)) {
					return false;
				}
			} else if (color[it] == color[node]) {
				return false;
			}
		}
		return true;
	}
}
