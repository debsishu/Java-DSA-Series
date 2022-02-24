package graph;

import java.util.*;

public class ShortestDistanceUndirected {
	public static void main(String[] args) {

	}

	void shortestDistance(ArrayList<ArrayList<Integer>> adj, int V, int src) {
		int distance[] = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);

		Queue<Integer> q = new LinkedList<>();

		distance[src] = 0;
		q.add(src);

		while (!q.isEmpty()) {
			int node = q.poll();

			for (Integer it : adj.get(node)) {
				if (distance[node] + 1 < distance[it]) {
					distance[it] = distance[node] + 1;
					q.add(it);
				}
			}
		}

		for (int e : distance) {
			System.err.print(e + " ");
		}
		System.err.println();
	}

}
