package graph;

import java.util.*;

public class LongestPathDAG {

	static class Graph {
		int V;
		ArrayList<ArrayList<Node>> adj;

		Graph(int V) {
			this.V = V;
			adj = new ArrayList<ArrayList<Node>>();

			for (int i = 0; i < V; i++) {
				adj.add(new ArrayList<Node>());
			}
		}

		void addEdge(int u, int v, int weight) {
			Node node = new Node(v, weight);
			adj.get(u).add(node);
		}

		void topoSortUtil(int v, boolean visited[], Stack<Integer> stack) {
			visited[v] = true;
			for (Node it : adj.get(v)) {
				if (!visited[it.v]) {
					topoSortUtil(it.v, visited, stack);
				}
			}
			stack.push(v);
		}

		void longestPath(int src) {
			Stack<Integer> stack = new Stack<Integer>();
			int distance[] = new int[V];
			Arrays.fill(distance, Integer.MIN_VALUE);
			boolean visited[] = new boolean[V];
			for (int i = 0; i < V; i++) {
				if (!visited[i]) {
					topoSortUtil(i, visited, stack);
				}
			}
			distance[src] = 0;

			while (!stack.isEmpty()) {
				int u = stack.pop();

				if (distance[u] != Integer.MIN_VALUE) {
					for (Node it : adj.get(u)) {
						if (distance[it.v] < distance[u] + it.weight) {
							distance[it.v] = distance[u] + it.weight;
						}
					}
				}
			}

			for (int i = 0; i < V; i++) {
				if (distance[i] == Integer.MIN_VALUE) {
					System.out.print("INF ");
				} else {
					System.out.print(distance[i] + " ");
				}
			}
		}

	}

	public static void main(String[] args) {
		Graph g = new Graph(6);

		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 3, 6);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 5, 1);
		g.addEdge(3, 4, -1);
		g.addEdge(4, 5, -2);

		g.longestPath(1);
	}

	static class Node {
		int v;
		int weight;

		Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}
}
