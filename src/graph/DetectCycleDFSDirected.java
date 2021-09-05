package graph;

import java.util.*;

public class DetectCycleDFSDirected {
	public static void main(String[] args) {

	}

	public static boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean visited[] = new boolean[V];
		boolean dfsVisited[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (DFS(i, visited, dfsVisited, adj)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean DFS(int node, boolean visited[], boolean dfsVisited[], ArrayList<ArrayList<Integer>> adj) {
		visited[node] = true;
		dfsVisited[node] = true;

		for (Integer it : adj.get(node)) {
			if (!visited[it]) {
				if (DFS(it, visited, dfsVisited, adj)) {
					return true;
				}
			} else if (dfsVisited[it]) {
				return true;
			}
		}
		dfsVisited[node] = false;
		return false;
	}

}
