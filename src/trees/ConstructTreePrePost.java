package trees;

import java.util.*;

public class ConstructTreePrePost {
	public static void main(String[] args) {

	}

	Node constructTree(int preorder[], int postorder[]) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < postorder.length; i++) {
			map.put(postorder[i], i);
		}

		return solve(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, map);
	}

	private Node solve(int[] preorder, int prestart, int preend, int[] postorder, int poststart, int postend,
			HashMap<Integer, Integer> map) {
		if (prestart > preend || poststart > postend) {
			return null;
		}
		Node node = new Node(preorder[prestart]);

		if (prestart + 1 < preend) {
			int index = map.get(preorder[prestart + 1]);

			int sum = index - poststart;

			node.left = solve(preorder, prestart + 1, prestart + sum + 1, postorder, poststart, poststart + sum, map);
			node.right = solve(preorder, prestart + sum + 2, preend, postorder, poststart + sum + 1, postend - 1, map);
		}
		return node;
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

}
