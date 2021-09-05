package graph;

import java.util.*;

public class DetectCycleBFSUndirected {
	public static void main(String[] args) {

	}

	static class Node {
		int first;
		int second;

		Node(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	static boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (BFS(i, visited, adj)) {
					return true;
				}
			}
		}

		return false;
	}

	static boolean BFS(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj) {
		Queue<Node> q = new LinkedList<>();

		q.add(new Node(node, -1));
		visited[node] = true;

		while (!q.isEmpty()) {
			int curr = q.peek().first;
			int parent = q.peek().second;
			q.poll();

			for (Integer it : adj.get(curr)) {
				if (!visited[it]) {
					q.add(new Node(it, curr));
					visited[it] = true;
				} else if (parent != it) {
					return true;
				}
			}
		}
		return false;
	}
}
