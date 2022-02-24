package graph;

import java.util.*;

public class ShortestDistanceDirected {
	public static void main(String[] args) {

	}

	static void shortestPath(ArrayList<ArrayList<Pair>> adj, int V, int src) {
		Stack<Integer> s = new Stack<>();
		boolean visited[] = new boolean[V];

		int distance[] = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				topoSortUtil(adj, i, s, visited);
			}
		}

		distance[0] = 0;

		while (!s.isEmpty()) {
			int node = s.pop();

			if (distance[node] != Integer.MAX_VALUE) {
				for (Pair it : adj.get(node)) {
					if (distance[node] + it.w < distance[it.v]) {
						distance[it.v] = distance[node] + it.w;
					}
				}
			}
		}

		for (int e : distance) {
			if (e == Integer.MAX_VALUE) {
				System.out.print("Unreachable ");
			} else {
				System.out.print(e + " ");
			}
		}
	}

	static private void topoSortUtil(ArrayList<ArrayList<Pair>> adj, int node, Stack<Integer> s, boolean visited[]) {
		visited[node] = true;

		for (Pair it : adj.get(node)) {
			if (!visited[it.v]) {
				topoSortUtil(adj, it.v, s, visited);
			}
		}

		s.push(node);
	}

	static class Pair {
		int v;
		int w;

		Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

}
