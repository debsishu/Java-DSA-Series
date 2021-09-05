package graph;

public class BellmanFordGFG {
	public static void main(String[] args) {

	}
}

// { {0,1,-1}
//   {1,2,-2}
//   {2,0,-3} }
// Here the graph is in an 2d array
// Where every row has three elements
// [1, 2, -1] -> this means their is an edge between 1 and 2 with -1 weight

class Solution {
	public int isNegativeCycle(int n, int edges[][]) {
		int dist[] = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[0] = 0;

		// Relax all the edges exactly n - 1 times
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < edges.length; j++) {
				int u = edges[j][0];
				int v = edges[j][1];
				int weight = edges[j][2];

				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
					dist[v] = dist[u] + weight;
				}
			}
		}

		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int weight = edges[i][2];

			if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
				return 1;
			}
		}
		return 0;
	}
}
