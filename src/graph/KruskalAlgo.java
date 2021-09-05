package graph;

import java.util.*;

public class KruskalAlgo {
	public static void main(String[] args) {
		int n = 5;
		ArrayList<Node> adj = new ArrayList<>();

		adj.add(new Node(0, 1, 2));
		adj.add(new Node(0, 3, 6));
		adj.add(new Node(1, 3, 8));
		adj.add(new Node(1, 2, 3));
		adj.add(new Node(1, 4, 5));
		adj.add(new Node(2, 4, 7));

		KruskalAlgo obj = new KruskalAlgo();
		obj.kruskalsAlgo(adj, n);

	}

	int findPar(int u, int parent[]) {
		if (u == parent[u]) {
			return u;
		}
		// This is path compression;
		return parent[u] = findPar(parent[u], parent);
	}

	void union(int u, int v, int parent[], int rank[]) {
		u = findPar(u, parent);
		v = findPar(v, parent);

		if (rank[u] < rank[v]) {
			parent[u] = v;
		} else if (rank[v] < rank[u]) {
			parent[v] = u;
		} else {
			parent[v] = u;
			rank[u]++;
		}
	}

	void kruskalsAlgo(ArrayList<Node> adj, int N) {
		Collections.sort(adj, new SortComparator());
		int rank[] = new int[N];
		int parent[] = new int[N];

		for (int i = 0; i < N; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		int cost = 0;
		ArrayList<Node> mst = new ArrayList<>();

		for (Node it : adj) {
			if (findPar(it.u, parent) != findPar(it.v, parent)) {
				cost += it.weight;
				mst.add(it);
				union(it.u, it.v, parent, rank);
			}
		}
		System.out.println("Total cost of MST is : " + cost);
		for (Node it : mst) {
			System.out.println(it.u + " -- " + it.v);
		}
	}

	class SortComparator implements Comparator<Node> {
		@Override
		public int compare(Node n1, Node n2) {
			if (n1.weight < n2.weight) {
				return -1;
			}
			if (n1.weight > n2.weight) {
				return 1;
			}
			return 0;
		}
	}

	static class Node {
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
	}
}
