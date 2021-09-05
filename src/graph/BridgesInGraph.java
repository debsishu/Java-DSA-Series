package graph;

import java.util.*;

public class BridgesInGraph {
	public static void main(String[] args) {
		int n = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(0).add(2);
		adj.get(2).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(1).add(3);
		adj.get(3).add(1);

		adj.get(3).add(4);
		adj.get(4).add(3);

		printBridges(adj, n);
	}

	static void printBridges(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean visited[] = new boolean[V];
		int tin[] = new int[V];
		int low[] = new int[V];

		int timer = 0;
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				DFS(i, -1, visited, tin, low, adj, timer);
			}
		}
	}

	private static void DFS(int node, int parent, boolean visited[], int tin[], int low[],
			ArrayList<ArrayList<Integer>> adj, int timer) {
		visited[node] = true;
		tin[node] = low[node] = timer++;

		for (Integer it : adj.get(node)) {
			if (it == parent)
				continue;
			if (!visited[it]) {
				DFS(it, node, visited, tin, low, adj, timer);
				low[node] = Math.min(low[node], low[it]);

				if (low[it] > tin[node]) {
					System.out.println(it + " " + node);
				}
			} else {
				low[node] = Math.min(low[node], tin[it]);
			}
		}
	}
}
