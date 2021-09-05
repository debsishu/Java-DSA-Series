package trees;

import java.util.Stack;

public class PostOrderOneStack {
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
		postOrder(root);
	}

	static void postOrder(Node root) {
		if (root == null) {
			return;
		}
		Node curr = root;
		Stack<Node> s = new Stack<>();
		while (!s.isEmpty() || curr != null) {
			if (curr != null) {
				s.push(curr);
				curr = curr.left;
			} else {
				Node temp = s.peek().right;
				if (temp == null) {
					temp = s.pop();
					System.out.print(temp.data + " ");
					while (!s.isEmpty() && temp == s.peek().right) {
						temp = s.pop();
						System.out.print(temp.data + " ");
					}
				} else {
					curr = temp;
				}
			}
		}
	}
}
