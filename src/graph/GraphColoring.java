package graph;

import java.util.*;

public class GraphColoring {
	private int V;
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	GraphColoring(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	void greedyColoring() {
		int result[] = new int[V];
		Arrays.fill(result, -1);

		result[0] = 0;

		boolean available[] = new boolean[V];
		Arrays.fill(available, true);

		for (int u = 0; u < V; u++) {
			for (Integer it : adj[u]) {
				if (result[it] != -1) {
					available[result[it]] = false;
				}
			}

			int cr;
			for (cr = 0; cr < V; cr++) {
				if (available[cr]) {
					break;
				}
			}

			result[u] = cr;
			Arrays.fill(available, true);
		}

		for (int u = 0; u < V; u++) {
			System.out.println(u + " -- " + result[u]);
		}
	}

	public static void main(String[] args) {
		GraphColoring g = new GraphColoring(5);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(3, 4);

		g.greedyColoring();
	}
}
