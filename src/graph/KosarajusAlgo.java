package graph;

import java.util.*;

public class KosarajusAlgo {

	static void DFS(int node, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {
		visited[node] = true;
		for (Integer it : adj.get(node)) {
			if (!visited[it]) {
				DFS(it, stack, adj, visited);
			}
		}
		stack.push(node);
	}

	static void revDFS(int node, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {
		visited[node] = true;
		System.out.print(node + " ");
		for (Integer it : adj.get(node)) {
			if (!visited[it]) {
				revDFS(it, adj, visited);
			}
		}
	}

	static void kosarajuAlgo(ArrayList<ArrayList<Integer>> adj, int n) {
		boolean visited[] = new boolean[n];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				DFS(i, stack, adj, visited);
			}
		}

		ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < n; i++) {
			transpose.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < n; i++) {
			visited[i] = false;
			for (Integer it : adj.get(i)) {
				transpose.get(it).add(i);
			}
		}

		while (!stack.isEmpty()) {
			int node = stack.pop();
			if (!visited[node]) {
				System.out.print("SCC : ");
				revDFS(node, transpose, visited);
				System.out.println();
			}
		}

		// THIS IS FOR GFG SOLUTION
		
		// int count = 0;
		// while (!stack.isEmpty()) {
		// 	int node = stack.pop();
		// 	if (!visited[node]) {
		// 		count++;
		// 		revDFS(node, transpose, visited);
		// 	}
		// }
		// return count;
	}

	public static void main(String[] args) {
		int n = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(0);
		adj.get(1).add(3);
		adj.get(3).add(4);

		kosarajuAlgo(adj, n);
	}
}
