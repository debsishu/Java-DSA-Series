package trees;

import java.util.Stack;

public class FlattenBinaryTree {
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
		root.left.right.right = new Node(6);
	}

	static Node prev = null;

	static void flattenTree(Node root) {
		if (root == null) {
			return;
		}
		flattenTree(root.right);
		flattenTree(root.left);

		root.right = prev;
		root.left = null;
		prev = root;
	}

	static void flattenTreeIter(Node root) {
		if (root == null) {
			return;
		}

		Stack<Node> st = new Stack<>();
		st.push(root);

		while (!st.isEmpty()) {
			Node curr = st.peek();
			st.pop();

			if (curr.right != null) {
				st.push(curr.right);
			}
			if (curr.left != null) {
				st.push(curr.left);
			}
			if (!st.isEmpty()) {
				curr.right = st.peek();
			}
			curr.left = null;
		}
	}

	// These two are O(N) time and O(N) spece complexity
	// This one has O(N) time but O(1) space complexity
	// This concept uses the threaded binary tree concept
	static void flattenTreeOpt(Node root) {
		Node curr = root;
		while (curr != null) {
			if (curr.left != null) {
				Node prev = curr.left;
				while (prev.right != null) {
					prev = prev.right;
				}
				prev.right = curr.right;
				curr.right = curr.left;
				curr.left = null;
			}
			curr = curr.right;
		}
	}
}
