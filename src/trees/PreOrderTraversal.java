package trees;

import java.util.*;

public class PreOrderTraversal {
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

		preOrder(root);
		System.out.println();
		preOrderIter(root);
	}

	static void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	static void preOrderIter(Node root) {
		Stack<Node> s = new Stack<>();
		if (root == null)
			return;
		s.push(root);
		while (!s.isEmpty()) {
			root = s.pop();
			System.out.print(root.data + " ");
			if (root.right != null)
				s.push(root.right);
			if (root.left != null)
				s.push(root.left);
		}
	}
}
