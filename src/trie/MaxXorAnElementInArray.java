package trie;

import java.util.*;

public class MaxXorAnElementInArray {

	static ArrayList<Integer> maxXor(int nums[], int quaries[][]) {
		Arrays.sort(quaries);
		ArrayList<ArrayList<Integer>> offline = new ArrayList<>();
		int q = quaries.length;
		for (int i = 0; i < q; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(quaries[i][1]);
			temp.add(quaries[i][0]);
			temp.add(i);
			offline.add(temp);
		}

		Collections.sort(offline, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return o1.get(0).compareTo(o2.get(0));
			}
		});

		int index = 0;
		Trie trie = new Trie();
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < quaries.length; i++) {
			res.add(-1);
		}
		for (int i = 0; i < quaries.length; i++) {
			while (index < quaries.length && nums[index] <= offline.get(i).get(0)) {
				trie.insert(nums[index]);
				index++;
			}
			int queryIndex = offline.get(i).get(2);
			if (index != 0) {
				res.set(queryIndex, trie.getMax(offline.get(i).get(1)));
			} else {
				res.set(queryIndex, -1);
			}
		}

		return res;
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