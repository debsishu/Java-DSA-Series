package graph;

import java.util.*;

public class PrimsAlgo {
	public static void main(String[] args) {

	}

	static int minimumSpanningTree(ArrayList<ArrayList<ArrayList<Integer>>> adj, int V) {
		int key[] = new int[V];
		boolean mst[] = new boolean[V];
		int parent[] = new int[V];

		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			parent[i] = -1;
			mst[i] = false;
		}

		PriorityQueue<Node> pq = new PriorityQueue<>(V, new Node());
		key[0] = 0;
		pq.add(new Node(0, key[0]));

		while (!pq.isEmpty()) {
			int node = pq.poll().v;
			mst[node] = true;

			for (ArrayList<Integer> it : adj.get(node)) {
				if (!mst[it.get(0)] && it.get(1) < key[it.get(0)]) {
					parent[it.get(0)] = node;
					key[it.get(0)] = it.get(1);
					pq.add(new Node(it.get(0), key[it.get(0)]));
				}
			}
		}

		int res = 0;
		for (int e : key) {
			res += e;
		}
		return res;
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
		public int compare(Node n1, Node n2) {
			if (n1.weight < n2.weight) {
				return -1;
			} else if (n1.weight > n2.weight) {
				return 1;
			}
			return 0;
		}

	}
}
