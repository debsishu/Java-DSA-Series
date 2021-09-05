package graph;

import java.util.*;

public class DFS {
	public static void main(String[] args) {

	}

	static ArrayList<Integer> DFSTraversal(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean visited[] = new boolean[V];
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				DFSUtil(i, adj, visited, res);
			}
		}
		return res;
	}

	static void DFSUtil(int node, ArrayList<ArrayList<Integer>> adj, boolean visited[], ArrayList<Integer> res) {
		visited[node] = true;
		res.add(node);

		for (Integer it : adj.get(node)) {
			if (!visited[it]) {
				DFSUtil(it, adj, visited, res);
			}
		}
	}
}
