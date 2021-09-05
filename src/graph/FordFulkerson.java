package graph;

import java.util.*;

public class FordFulkerson {
	public static void main(String[] args) {
		int[][] capacity = { { 0, 3, 0, 3, 0, 0, 0 }, { 0, 0, 4, 0, 0, 0, 0 }, { 3, 0, 0, 1, 2, 0, 0 },
				{ 0, 0, 0, 0, 2, 6, 0 }, { 0, 1, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 9 }, { 0, 0, 0, 0, 0, 0, 0 } };
		System.out.println(maxFlox(capacity, 0, 6));
	}

	static int maxFlox(int capacity[][], int source, int sink) {
		int residualCapacity[][] = new int[capacity.length][capacity[0].length];
		for (int i = 0; i < capacity.length; i++) {
			for (int j = 0; j < capacity[0].length; j++) {
				residualCapacity[i][j] = capacity[i][j];
			}
		}

		Map<Integer, Integer> parent = new HashMap<>();

		List<List<Integer>> augmentedPaths = new ArrayList<>();

		int maxFlow = 0;

		while (BFS(residualCapacity, parent, source, sink)) {
			List<Integer> augmentedPath = new ArrayList<>();
			int flow = Integer.MAX_VALUE;
			int v = sink;
			while (v != source) {
				augmentedPath.add(v);
				int u = parent.get(v);
				if (flow > residualCapacity[u][v]) {
					flow = residualCapacity[u][v];
				}
				v = u;
			}
			augmentedPath.add(source);
			Collections.reverse(augmentedPath);
			augmentedPaths.add(augmentedPath);

			maxFlow += flow;
			v = sink;
			while (v != source) {
				int u = parent.get(v);
				residualCapacity[u][v] -= flow;
				residualCapacity[v][u] += flow;
				v = u;
			}
		}
		printPaths(augmentedPaths);
		return maxFlow;
	}

	private static void printPaths(List<List<Integer>> augmentedPaths) {
		System.out.println("Augmented Paths are : ");
		for (List<Integer> it : augmentedPaths) {
			System.out.println(it);
		}
	}

	private static boolean BFS(int[][] residualCapacity, Map<Integer, Integer> parent, int source, int sink) {
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		visited.add(source);
		boolean foundAugmentedPath = false;
		while (!queue.isEmpty()) {
			int u = queue.poll();

			for (int v = 0; v < residualCapacity.length; v++) {
				if (!visited.contains(v) && residualCapacity[u][v] > 0) {
					parent.put(v, u);
					visited.add(v);
					queue.add(v);

					if (v == sink) {
						foundAugmentedPath = true;
						break;
					}
				}
			}
		}
		return foundAugmentedPath;
	}

}
