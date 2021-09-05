package trees;

import java.util.*;

public class BoundaryTraversal {
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
		System.out.println(boundary(root));
	}

	static ArrayList<Integer> boundary(Node root) {
		if (root == null) {
			return null;
		}
		ArrayList<Integer> res = new ArrayList<>();
		if (isLeaf(root)) {
			res.add(root.data);
			return res;
		}
		res.add(root.data);
		addLeftNodes(root, res);
		addLeafNodes(root, res);
		addRightNodes(root, res);
		return res;
	}

	private static void addRightNodes(Node root, ArrayList<Integer> res) {
		Node curr = root.right;
		Stack<Integer> s = new Stack<>();
		while (curr != null) {
			if (!isLeaf(curr)) {
				s.push(curr.data);
			}
			if (curr.right != null) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		while (!s.isEmpty()) {
			res.add(s.pop());
		}
	}

	private static void addLeftNodes(Node root, ArrayList<Integer> res) {
		Node curr = root.left;
		while (curr != null) {
			if (!isLeaf(curr)) {
				res.add(curr.data);
			}
			if (curr.left != null) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
	}

	private static void addLeafNodes(Node root, ArrayList<Integer> res) {
		if (isLeaf(root)) {
			res.add(root.data);
			return;
		}
		if (root.left != null) {
			addLeafNodes(root.left, res);
		}
		if (root.right != null) {
			addLeafNodes(root.right, res);
		}
	}

	private static boolean isLeaf(Node node) {
		return (node.left == null && node.right == null);
	}
}
