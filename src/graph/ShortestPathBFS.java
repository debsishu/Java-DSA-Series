package graph;

import java.util.*;

public class ShortestPathBFS {
	public static void main(String[] args) {

	}

	static int[] shortestPath(int src, int V, ArrayList<ArrayList<Integer>> adj) {
		int distance[] = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);

		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		distance[src] = 0;

		while (!q.isEmpty()) {
			int node = q.poll();
			for (Integer it : adj.get(node)) {
				if (distance[node] + 1 < distance[it]) {
					distance[it] = distance[node] + 1;
					q.add(it);
				}
			}
		}
		return distance;
	}
}
