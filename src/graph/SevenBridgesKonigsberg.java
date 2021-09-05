package graph;

import java.util.*;

public class SevenBridgesKonigsberg {

	public static void main(String[] args) {
		int V = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(2).add(1);
		adj.get(1).add(2);
		adj.get(0).add(3);
		adj.get(3).add(0);
		adj.get(3).add(4);
		adj.get(4).add(3);

		findEulerPathCycle(V, adj);
	}

	static int findEuler(int V, ArrayList<ArrayList<Integer>> adj) {
		if (!connectedGraph(V, adj)) {
			return 0;
		}
		int odd = 0;
		for (int i = 0; i < V; i++) {
			if (adj.get(i).size() % 2 == 1) {
				odd++;
			}
		}
		if (odd > 2) {
			return 0;
		}
		return (odd == 0) ? 2 : 1;
	}

	private static boolean connectedGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean visited[] = new boolean[V + 1];
		int node = -1;
		for (int i = 0; i < V; i++) {
			if (adj.get(i).size() > 0) {
				node = i;
				break;
			}
		}
		if (node == -1) {
			return true;
		}
		DFS(node, visited, adj);
		for (int i = 0; i < V; i++) {
			if (visited[i] == false && adj.get(i).size() > 0) {
				return false;
			}
		}
		return true;
	}

	private static void DFS(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
		visited[node] = true;
		for (Integer it : adj.get(node)) {
			if (!visited[it]) {
				DFS(it, visited, adj);
			}
		}
	}

	static void findEulerPathCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		int ret = findEuler(V, adj);
		if (ret == 0) {
			System.out.println("Graph is not a Euler Graph");
		} else if (ret == 1) {
			System.out.println("Graph is a Semi Eulerian Graph");
		} else {
			System.out.println("Graph is a Eulerian Graph");
		}
	}
}
