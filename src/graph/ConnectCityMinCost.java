// THIS QUESTION IS NOTHING BUT FINDING MINIMUM SPANNING TREE WITH PRIM'S ALGORITHM

package graph;

import java.util.*;

public class ConnectCityMinCost {

	static void findCost(int n, int city[][]) {
		int parent[] = new int[n];
		int key[] = new int[n];
		boolean mst[] = new boolean[n];

		Arrays.fill(key, Integer.MAX_VALUE);

		parent[0] = -1;
		key[0] = 0;

		for (int i = 0; i < n - 1; i++) {
			int u = minNode(n, key, mst);
			mst[u] = true;

			for (int v = 0; v < n; v++) {
				if (city[u][v] > 0 && mst[v] == false && city[u][v] < key[v]) {
					key[v] = city[u][v];
					parent[v] = u;
				}
			}
		}

		int cost = 0;
		for (int i = 1; i < n; i++) {
			cost += city[parent[i]][i];
		}
		System.out.println(cost);
	}

	private static int minNode(int n, int[] key, boolean[] mst) {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;

		for (int i = 0; i < n; i++) {
			if (mst[i] == false && key[i] < min) {
				min = key[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static void main(String[] args) {
		int n = 5;
		int city[][] = { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, { 3, 0, 6, 0, 0 }, { 4, 7, 0, 0, 0 } };
		findCost(n, city);
	}
}
