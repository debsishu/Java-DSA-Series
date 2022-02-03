package trie;

public class Trie2 {
	private Node root;

	public Trie2() {
		root = new Node();
	}

	void insert(String word) {
		Node node = root;

		for (int i = 0; i < word.length(); i++) {
			if (!node.containsKey(word.charAt(i))) {
				node.put(word.charAt(i), new Node());
			}
			node = node.get(word.charAt(i));
			node.increasePrefix();
		}
		node.increaseEnd();
	}

	int countWordsEqualTo(String word) {
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			if (node.containsKey(word.charAt(i))) {
				node = node.get(word.charAt(i));
			} else {
				return 0;
			}
		}
		return node.getEnd();
	}

	int countWordsStartingWith(String word) {
		Node node = root;

		for (int i = 0; i < word.length(); i++) {
			if (node.containsKey(word.charAt(i))) {
				node = node.get(word.charAt(i));
			} else {
				return 0;
			}
		}
		return node.getPrefix();
	}

	void erase(String word) {
		Node node = root;

		for (int i = 0; i < word.length(); i++) {
			if (node.containsKey(word.charAt(i))) {
				node = node.get(word.charAt(i));
				node.reducePrefx();
			} else {
				return;
			}
		}
		node.deleteEnd();
	}

	static class Node {
		private Node links[] = new Node[26];
		private int countEndWith = 0;
		private int countPrefix = 0;

		boolean containsKey(char ch) {
			return (links[ch - 'a'] != null);
		}

		Node get(char ch) {
			return links[ch - 'a'];
		}

		void put(char ch, Node node) {
			links[ch - 'a'] = node;
		}

		void increaseEnd() {
			countEndWith++;
		}

		void increasePrefix() {
			countPrefix++;
		}

		void deleteEnd() {
			countEndWith--;
		}

		void reducePrefx() {
			countPrefix--;
		}

		int getEnd() {
			return countEndWith;
		}

		int getPrefix() {
			return countPrefix;
		}
	}
}
