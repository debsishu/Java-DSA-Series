package trie;

public class CountDistinctSubstrings {

	static int countDistinctSubstrings(String word) {
		int count = 0;
		Node root = new Node();

		for (int i = 0; i < word.length(); i++) {
			Node node = root;
			for (int j = i; j < word.length(); j++) {
				if (!node.containsKey(word.charAt(j))) {
					node.put(word.charAt(j), new Node());
					count++;
				}
				node = node.get(word.charAt(j));
			}
		}
		return count + 1;
	}

	static class Node {
		private Node links[] = new Node[26];

		boolean containsKey(char ch) {
			return (links[ch - 'a'] != null);
		}

		Node get(char ch) {
			return links[ch - 'a'];
		}

		void put(char ch, Node node) {
			links[ch - 'a'] = node;
		}
	}
}
