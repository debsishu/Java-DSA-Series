package trees;

import java.util.*;

public class WidthOfBinaryTree {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	static class Pair {
		Node node;
		int index;

		Pair(Node node, int index) {
			this.node = node;
			this.index = index;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(widthOfBinaryTree(root));
	}

	static int widthOfBinaryTree(Node root) {
		if (root == null) {
			return 0;
		}
		int ans = 0;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0));

		while (!q.isEmpty()) {
			int size = q.size();
			int minIndex = q.peek().index;
			int first = 0, last = 0;
			for (int i = 0; i < size; i++) {
				int curr = q.peek().index - minIndex;
				Node node = q.poll().node;
				if (i == 0) {
					first = curr;
				}
				if (i == size - 1) {
					last = curr;
				}
				// The child index will be (2 * i) + 1 and (2 * i) + 2 respectively
				if (node.left != null) {
					q.add(new Pair(node.left, curr * 2 + 1));
				}
				if (node.right != null) {
					q.add(new Pair(node.right, curr * 2 + 2));
				}
			}
			ans = Math.max(ans, last - first + 1);
		}
		return ans;
	}

}
