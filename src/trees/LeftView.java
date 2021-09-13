package trees;

import java.util.*;

public class LeftView {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
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
		System.out.println(leftView(root));
		System.out.println(leftViewRecursive(root));
	}

	static ArrayList<Integer> leftView(Node root) {
		// add code here.
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Node curr = q.poll();
				if (i == 0) {
					res.add(curr.data);
				}
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
			}
		}
		return res;
	}

	static ArrayList<Integer> leftViewRecursive(Node root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		solve(root, res, 0);
		return res;
	}

	private static void solve(Node root, ArrayList<Integer> res, int level) {
		if (root == null) {
			return;
		}
		if (level == res.size()) {
			res.add(root.data);
		}
		solve(root.left, res, level + 1);
		solve(root.right, res, level + 1);
	}
}
