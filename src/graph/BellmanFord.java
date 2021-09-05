package graph;

import java.util.*;

public class BellmanFord {
	public static void main(String[] args) {
		int n = 6;
		ArrayList<Node> adj = new ArrayList<>();

		adj.add(new Node(3, 2, 6));
		adj.add(new Node(5, 3, 1));
		adj.add(new Node(0, 1, 5));
		adj.add(new Node(1, 5, -3));
		adj.add(new Node(1, 2, -2));
		adj.add(new Node(3, 4, -2));
		adj.add(new Node(2, 4, 3));

		bellmanFord(adj, n, 0);
	}

	static void bellmanFord(ArrayList<Node> adj, int V, int src) {
		int distance[] = new int[V];
		Arrays.fill(distance, 10000000);
		distance[src] = 0;

		for (int i = 1; i <= V - 1; i++) {
			for (Node n : adj) {
				if (distance[n.u] + n.weight < distance[n.v]) {
					distance[n.v] = distance[n.u] + n.weight;
				}
			}
		}

		boolean flag = false;
		for (Node n : adj) {
			if (distance[n.u] + n.weight < distance[n.v]) {
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println("Negative cycle found");
		} else {
			for (int i = 0; i < V; i++) {
				System.out.println(i + " -- " + distance[i]);
			}
		}
	}

	static class Node {
		int u;
		int v;
		int weight;

		Node(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
	}
}
