package trie;

public class CompleteString {

	String completeString(int n, String arr[]) {
		Trie obj = new Trie();

		for (int i = 0; i < arr.length; i++) {
			obj.insert(arr[i]);
		}

		String res = "";
		for (int i = 0; i < arr.length; i++) {
			if (obj.checkIfAllPrefixExists(arr[i])) {
				if (arr[i].length() > res.length()) {
					res = arr[i];
				} else if (arr[i].length() == res.length() && arr[i].compareTo(res) < 0) {
					res = arr[i];
				}
			}
		}

		if (res == "") {
			return "None";
		}
		return res;
	}

	static class Trie {
		private Node root;

		Trie() {
			root = new Node();
		}

		void insert(String word) {
			Node node = root;

			for (int i = 0; i < word.length(); i++) {
				if (!node.containsKey(word.charAt(i))) {
					node.put(word.charAt(i), new Node());
				}
				node = node.get(word.charAt(i));
			}
			node.setEnd();
		}

		boolean checkIfAllPrefixExists(String word) {
			Node node = root;
			boolean res = true;

			for (int i = 0; i < word.length(); i++) {
				if (node.containsKey(word.charAt(i))) {
					node = node.get(word.charAt(i));
					if (node.isEnd() == false) {
						return false;
					}
				} else {
					return false;
				}
			}

			return res;
		}
	}

	static class Node {
		private Node links[] = new Node[26];
		private boolean flag = false;

		boolean containsKey(char ch) {
			return (links[ch - 'a'] != null);
		}

		Node get(char ch) {
			return links[ch - 'a'];
		}

		void put(char ch, Node node) {
			links[ch - 'a'] = node;
		}

		void setEnd() {
			flag = true;
		}

		boolean isEnd() {
			return flag;
		}
	}
}
