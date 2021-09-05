// GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

package graph;

import java.util.*;

public class DijkstrasAlgo {
	public static void main(String[] args) {

		// READ CAREFULLY

		// Here the graph is in some modified form
		// ArrayList<ArrayList<ArrayList<Integer>>>
		// last arraylist 0th position stores the edge
		// and the 1st position stores the edge weight

	}

	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
		int distance[] = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[src] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(V, new Node());
		pq.add(new Node(src, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			for (ArrayList<Integer> it : adj.get(node.v)) {
				if (distance[node.v] + it.get(1) < distance[it.get(0)]) {
					distance[it.get(0)] = distance[node.v] + it.get(1);
					pq.add(new Node(it.get(0), distance[it.get(0)]));
				}
			}
		}

		return distance;
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
