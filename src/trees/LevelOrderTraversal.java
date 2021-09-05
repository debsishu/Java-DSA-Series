package trees;

import java.util.*;

public class LevelOrderTraversal {

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

		List<List<Integer>> res = levelOrder(root);
		for (List<Integer> e : res) {
			System.out.println(e);
		}
	}

	static List<List<Integer>> levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		List<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> subAns = new LinkedList<>();

			for (int i = 0; i < size; i++) {
				if (q.peek().left != null)
					q.add(q.peek().left);
				if (q.peek().right != null)
					q.add(q.peek().right);
				subAns.add(q.poll().data);
			}
			res.add(subAns);
		}
		return res;
	}
}
