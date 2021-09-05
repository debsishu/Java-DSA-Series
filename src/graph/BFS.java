package graph;

import java.util.*;

public class BFS {
	public static void main(String[] args) {

	}

	static ArrayList<Integer> BFSTraversasl(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> res = new ArrayList<>();
		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				visited[i] = true;

				while (!q.isEmpty()) {
					int node = q.poll();
					res.add(node);
					for (Integer it : adj.get(node)) {
						if (!visited[it]) {
							visited[it] = true;
							q.add(it);
						}
					}
				}
			}
		}
		return res;
	}
}
