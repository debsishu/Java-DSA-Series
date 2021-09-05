package trees;

import java.util.Stack;

public class InorderTraversal {

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

		inOrder(root);
		System.out.println();
		inOrderIter(root);
	}

	static void inOrder(Node root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	static void inOrderIter(Node root) {
		Stack<Node> s = new Stack<>();
		if (root == null)
			return;
		Node node = root;
		while (true) {
			if (node != null) {
				s.push(node);
				node = node.left;
			} else {
				if (s.isEmpty()) {
					break;
				}
				node = s.pop();
				System.out.print(node.data + " ");
				node = node.right;
			}
		}
	}
}
