package graph;

import java.util.*;

public class AlienLanguage {

	String findOrder(String dict[], int n, int k) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < n - 1; i++) {
			String w1 = dict[i];
			String w2 = dict[i + 1];

			for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
				if (w1.charAt(j) != w2.charAt(j)) {
					adj.get(w1.charAt(j) - 'a').add(w2.charAt(j) - 'a');
					break;
				}
			}
		}

		boolean visited[] = new boolean[k];
		String ans = "";

		for (int i = 0; i < k; i++) {
			if (!visited[i]) {
				DFS(i, adj, visited, ans);
			}
		}

		return ans;
	}

	void DFS(int src, ArrayList<ArrayList<Integer>> adj, boolean visited[], String ans) {
		visited[src] = true;

		for (Integer it : adj.get(src)) {
			if (!visited[it]) {
				DFS(it, adj, visited, ans);
			}
		}
		char ch = (char) (src + 'a');
		ans = ch + ans;
	}

	public static void main(String[] args) {
		String[] words = { "caa", "aaa", "aab" };
		// AlienLanguage sol = new AlienLanguage();
		// System.out.println(sol.findOrder(words, words.length, 3));
		OrderOfCharacters sol = new OrderOfCharacters();
		sol.printOrder(words, 3);
	}

}

class Graph {
	private final ArrayList<ArrayList<Integer>> adj;

	Graph(int V) {
		adj = new ArrayList<>(V);
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}

	void addEdge(int start, int end) {
		adj.get(start).add(end);
	}

	private int getNoOfVertices() {
		return adj.size();
	}

	private void topologicalSortUtil(int current, boolean visited[], Stack<Integer> stack) {
		visited[current] = true;

		for (Integer it : adj.get(current)) {
			if (!visited[it]) {
				topologicalSortUtil(it, visited, stack);
			}
		}
		stack.push(current);
	}

	void topologicalSort() {
		Stack<Integer> stack = new Stack<>();

		boolean visited[] = new boolean[getNoOfVertices()];

		for (int i = 0; i < getNoOfVertices(); i++) {
			if (!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print((char) ('a' + stack.pop()) + " ");
		}
	}

}

class OrderOfCharacters {
	void printOrder(String[] words, int alpha) {
		Graph graph = new Graph(alpha);

		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];

			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
					break;
				}
			}
		}

		graph.topologicalSort();
	}
}
