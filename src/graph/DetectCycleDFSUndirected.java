package graph;

import java.util.*;

public class DetectCycleDFSUndirected {
	public static void main(String[] args) {

	}

	static boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (DFS(i, -1, visited, adj)) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean DFS(int node, int parent, boolean visited[], ArrayList<ArrayList<Integer>> adj) {
		visited[node] = true;

		for (Integer it : adj.get(node)) {
			if (!visited[it]) {
				if (DFS(it, node, visited, adj)) {
					return true;
				}
			} else if (it != parent) {
				return true;
			}
		}
		return false;
	}
}
