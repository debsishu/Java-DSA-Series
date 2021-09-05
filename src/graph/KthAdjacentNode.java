package graph;

import java.util.*;

public class KthAdjacentNode {
	static class Pair {
		int first, second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		static void printKthNode(ArrayList<ArrayList<Pair>> adj, int weight[], int n, int k) {
			for (int i = 0; i < n; i++) {
				Collections.sort(adj.get(i), new Comparator<Pair>() {
					public int compare(Pair p1, Pair p2) {
						return p1.first - p2.first;
					}
				});
			}
			for (int i = 0; i < n; i++) {
				if (adj.get(i).size() >= k) {
					System.out.print(adj.get(i).get(adj.get(i).size() - k).second + " ");
				} else {
					System.out.print("-1");
				}
			}
		}

		public static void main(String[] args) {
			int n = 3;
			int k = 2;
			int weight[] = { 2, 4, 3 };

			ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
			for (int i = 0; i < n + 1; i++) {
				adj.add(new ArrayList<Pair>());
			}

			adj.get(0).add(new Pair(weight[2], 2));
			adj.get(2).add(new Pair(weight[0], 0));

			adj.get(0).add(new Pair(weight[1], 1));
			adj.get(1).add(new Pair(weight[0], 0));

			adj.get(1).add(new Pair(weight[2], 2));
			adj.get(2).add(new Pair(weight[1], 1));

			printKthNode(adj, weight, n, k);
		}
	}
}
