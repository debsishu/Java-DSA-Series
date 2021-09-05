package trees;

import java.util.*;

public class ZigZagTraversal {
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

		List<List<Integer>> res = zigZag(root);
		for (List<Integer> e : res) {
			System.out.println(e);
		}
	}

	static List<List<Integer>> zigZag(Node root) {
		List<List<Integer>> res = new LinkedList<>();
		Queue<Node> q = new LinkedList<>();
		if (root == null) {
			return res;
		}
		boolean choice = true;
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> subRes = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				if (q.peek().left != null) {
					q.add(q.peek().left);
				}
				if (q.peek().right != null) {
					q.add(q.peek().right);
				}
				if (choice) {
					subRes.add(q.poll().data);
				} else {
					subRes.add(0, q.poll().data);
				}
			}
			choice = !choice;
			res.add(subRes);
		}
		return res;
	}
}
