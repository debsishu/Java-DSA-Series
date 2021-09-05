package graph;

import java.util.*;

public class MGraphColoring {
	public static void main(String[] args) {

	}
}

class solve {
	// Here i is the starting vertex
	public static boolean graphColoring(List<Integer> graph[], int color[], int i, int m) {
		int size = graph.length;
		if (solveGraphColor(i, graph, color, size, m)) {
			return true;
		}
		return false;
	}

	static boolean solveGraphColor(int node, List<Integer> graph[], int color[], int size, int m) {
		if (node == size) {
			return true;
		}
		// Here the m colors are 1, 2, 3, .....m
		for (int i = 1; i <= m; i++) {
			if (isSafe(node, graph, color, i)) {
				color[node] = i;
				if (solveGraphColor(node + 1, graph, color, size, m)) {
					return true;
				}
				color[node] = 0;
			}
		}
		return false;
	}

	static boolean isSafe(int node, List<Integer> graph[], int color[], int currentColor) {
		for (int it : graph[node]) {
			if (color[it] == currentColor) {
				return false;
			}
		}
		return true;
	}
}
