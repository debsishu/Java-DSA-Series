package graph;

public class DisjointSet {

	int parent[];
	int rank[];

	public DisjointSet(int n) {
		parent = new int[n];
		rank = new int[n];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	int findParent(int node) {
		if (node == parent[node]) {
			return node;
		}
		return parent[node] = findParent(parent[node]);
	}

	void union(int u, int v) {
		u = findParent(u);
		v = findParent(v);

		if (rank[u] < rank[v]) {
			parent[u] = v;
		} else if (rank[v] < rank[u]) {
			parent[v] = u;
		} else {
			parent[v] = u;
			rank[u]++;
		}
	}
}
