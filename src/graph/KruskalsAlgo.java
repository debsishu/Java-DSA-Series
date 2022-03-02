package graph;

import java.util.*;

public class KruskalsAlgo {
	public static void main(String[] args) {
		int n = 5;
		ArrayList<Node> adj = new ArrayList<>();

		adj.add(new Node(0, 1, 2));
		adj.add(new Node(0, 3, 6));
		adj.add(new Node(1, 3, 8));
		adj.add(new Node(1, 2, 3));
		adj.add(new Node(1, 4, 5));
		adj.add(new Node(2, 4, 7));

		kruskalsAlgo(adj, n);
	}

	static void kruskalsAlgo(ArrayList<Node> adj, int n) {
		Collections.sort(adj, new Node());
		DisjointSet dj = new DisjointSet(n);

		int costMst = 0;
		ArrayList<Node> mstRes = new ArrayList<>();

		for (Node it : adj) {
			if (dj.findParent(it.u) != dj.findParent(it.v)) {
				costMst += it.weight;
				mstRes.add(it);
				dj.union(it.u, it.v);
			}
		}

		System.out.println("Cost of the MST is " + costMst);
		for (Node it : mstRes) {
			System.err.println(it.u + " -> " + it.v);
		}
	}

	static class Node implements Comparator<Node> {
		int u;
		int v;
		int weight;

		Node() {
		}

		Node(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compare(Node o1, Node o2) {
			if (o1.weight > o2.weight) {
				return 1;
			} else if (o1.weight < o2.weight) {
				return -1;
			}
			return 0;
		}

	}
}
