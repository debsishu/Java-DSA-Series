package trees;

import java.util.*;

public class MorrisTraversal {
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
		System.out.println(morrisInOrderTraversal(root));
		System.out.println(morrisPreOrderTraversal(root));
	}

	static ArrayList<Integer> morrisInOrderTraversal(Node root) {
		ArrayList<Integer> inOrder = new ArrayList<>();
		Node curr = root;

		while (curr != null) {
			if (curr.left == null) {
				inOrder.add(curr.data);
				curr = curr.right;
			} else {
				Node prev = curr.left;
				while (prev.right != null && prev.right != curr) {
					prev = prev.right;
				}
				if (prev.right == null) {
					prev.right = curr;
					curr = curr.left;
				} else {
					prev.right = null;
					inOrder.add(curr.data);
					curr = curr.right;
				}
			}
		}
		return inOrder;
	}

	static ArrayList<Integer> morrisPreOrderTraversal(Node root) {
		ArrayList<Integer> preOrder = new ArrayList<>();
		Node curr = root;

		while (curr != null) {
			if (curr.left == null) {
				preOrder.add(curr.data);
				curr = curr.right;
			} else {
				Node prev = curr.left;
				while (prev.right != null && prev.right != curr) {
					prev = prev.right;
				}
				if (prev.right == null) {
					prev.right = curr;
					preOrder.add(curr.data);
					curr = curr.left;
				} else {
					prev.right = null;
					curr = curr.right;
				}
			}
		}
		return preOrder;
	}
}
