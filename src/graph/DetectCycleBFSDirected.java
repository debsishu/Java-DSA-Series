package graph;

import java.util.*;

public class DetectCycleBFSDirected {
	public static void main(String[] args) {

	}

	static boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
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
		int count = 0;
		while (!q.isEmpty()) {
			int node = q.poll();
			count++;
			for (Integer it : adj.get(node)) {
				indegree[it]--;
				if (indegree[it] == 0) {
					q.add(it);
				}
			}
		}

		if (count == V) {
			return false;
		}
		return true;
	}
}
