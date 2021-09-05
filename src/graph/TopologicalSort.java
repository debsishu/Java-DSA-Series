package graph;

import java.util.*;

public class TopologicalSort {
	public static void main(String[] args) {

	}

	public int[] topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
		Stack<Integer> stk = new Stack<>();
		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				find(adj, i, stk, visited);
			}
		}

		int res[] = new int[V];
		int i = 0;
		while (!stk.isEmpty()) {
			res[i++] = stk.pop();
		}
		return res;
	}

	private void find(ArrayList<ArrayList<Integer>> adj, int src, Stack<Integer> stk, boolean visited[]) {
		visited[src] = true;

		for (Integer it : adj.get(src)) {
			if (!visited[it]) {
				find(adj, it, stk, visited);
			}
		}
		stk.push(src);
	}
}

class kahnsAlgorithm {

	int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
		int topo[] = new int[V];
		int indegree[] = new int[V];
		for (int i = 0; i < V; i++) {
			for (Integer it : adj.get(i)) {
				indegree[it]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		int index = 0;
		while (!q.isEmpty()) {
			int node = q.poll();
			topo[index++] = node;
			for (Integer it : adj.get(node)) {
				indegree[it]--;
				if (indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		return topo;
	}

}