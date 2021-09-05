package graph;

import java.util.*;

public class ReverseEdgeToReachDest {

	public static void main(String[] args) {
		int V = 7;
		int edge[][] = { { 0, 1 }, { 2, 1 }, { 2, 3 }, { 5, 1 }, { 4, 5 }, { 6, 4 }, { 6, 3 } };
		reverseEdge(edge, V);
	}

	static void reverseEdge(int edge[][], int V) {
		ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < edge.length; i++) {
			adj.get(edge[i][0]).add(new Node(edge[i][1], 0));
			adj.get(edge[i][1]).add(new Node(edge[i][0], 1));
		}
		shortestPathDijkstra(0, adj, V, 6);
	}

	static void shortestPathDijkstra(int src, ArrayList<ArrayList<Node>> adj, int N, int dest) {
		int distance[] = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[src] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());
		pq.add(new Node(src, 0));

		while (pq.size() > 0) {
			Node node = pq.poll();

			for (Node it : adj.get(node.v)) {
				if (distance[node.v] + it.weight < distance[it.v]) {
					distance[it.v] = distance[node.v] + it.weight;
					pq.add(new Node(it.v, distance[it.v]));
				}
			}
		}
		System.out.println(distance[dest] == Integer.MAX_VALUE ? "No solution found" : distance[dest]);
	}

	static class Node implements Comparator<Node> {
		int v;
		int weight;

		Node() {
		}

		Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compare(Node node1, Node node2) {
			if (node1.weight < node2.weight) {
				return -1;
			}
			if (node1.weight > node2.weight) {
				return 1;
			}
			return 0;
		}
	}

}
