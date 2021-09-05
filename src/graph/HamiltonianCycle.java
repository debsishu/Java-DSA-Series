package graph;

import java.util.*;

public class HamiltonianCycle {
	public static void main(String[] args) {
		HamiltonianCycle h = new HamiltonianCycle();
		int V = 5;
		int graph1[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 }, { 0, 1, 1, 1, 0 }, };
		h.hamiltonianCycle(graph1, V);
		int graph2[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, };
		h.hamiltonianCycle(graph2, V);
	}

	int hamiltonianCycle(int graph[][], int V) {
		int path[] = new int[V];
		Arrays.fill(path, -1);
		path[0] = 0;
		if (hamiltoniancycleUtil(graph, path, V, 1) == false) {
			System.out.println("Hamiltonian Path does not exist");
			return 0;
		}
		for (int e : path) {
			System.out.print(e + " ");
		}
		System.out.println();
		return 1;
	}

	private boolean hamiltoniancycleUtil(int[][] graph, int[] path, int V, int pos) {
		if (pos == V) {
			// This means if the cycle's last node has an edge with the cycle's first
			if (graph[path[pos - 1]][path[0]] == 1) {
				return true;
			} else {
				return false;
			}
		}

		for (int i = 1; i < V; i++) {
			if (isSafe(i, graph, path, pos)) {
				path[pos] = i;
				if (hamiltoniancycleUtil(graph, path, V, pos + 1)) {
					return true;
				}
				path[pos] = -1;
			}
		}
		return false;
	}

	private boolean isSafe(int node, int[][] graph, int[] path, int pos) {
		if (graph[path[pos - 1]][node] == 0) {
			return false;
		}
		for (int i = 0; i < pos; i++) {
			if (path[i] == node) {
				return false;
			}
		}
		return true;
	}

}
