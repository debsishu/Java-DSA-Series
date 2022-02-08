package trie;

public class MaximumXor {

	int maxXor(int arr1[], int arr2[]) {
		Trie trie = new Trie();

		for (int e : arr1) {
			trie.insert(e);
		}
		int maxi = 0;
		for (int e : arr2) {
			maxi = Math.max(maxi, trie.getMax(e));
		}
		return maxi;
	}

	static class Trie {
		private Node root;

		Trie() {
			root = new Node();
		}

		void insert(int num) {
			Node node = root;
			for (int i = 31; i >= 0; i--) {
				int bit = (num >> i) & 1;
				if (!node.containsKey(bit)) {
					node.put(bit, new Node());
				}
				node = node.get(bit);
			}
		}

		int getMax(int num) {
			Node node = root;
			int maxNum = 0;

			for (int i = 31; i >= 0; i--) {
				int bit = (num >> i) & 1;
				if (node.containsKey(1 - bit)) {
					maxNum = maxNum | (1 << i);
					node = node.get(1 - bit);
				} else {
					node = node.get(bit);
				}
			}
			return maxNum;
		}
	}

	static class Node {
		Node links[] = new Node[2];

		boolean containsKey(int bit) {
			return (links[bit] != null);
		}

		Node get(int bit) {
			return links[bit];
		}

		void put(int bit, Node node) {
			links[bit] = node;
		}
	}
}
