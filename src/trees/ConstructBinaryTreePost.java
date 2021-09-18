package trees;

import java.util.*;

public class ConstructBinaryTreePost {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		int inOrder[] = { 9, 3, 15, 20, 7 };
		int postOrder[] = { 9, 15, 7, 20, 3 };
		Node root = buildTree(inOrder, postOrder);
		printTree(root);
	}

	static void printTree(Node root) {
		if (root == null)
			return;
		printTree(root.left);
		System.out.print(root.data + " ");
		printTree(root.right);
	}

	static Node buildTree(int inOrder[], int postOrder[]) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inOrder.length; i++) {
			map.put(inOrder[i], i);
		}
		Node root = solve(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length - 1, map);
		return root;
	}

	private static Node solve(int postOrder[], int postStart, int postEnd, int inOrder[], int inStart, int inEnd,
			Map<Integer, Integer> map) {
		if (postStart > postEnd || inStart > inEnd) {
			return null;
		}
		Node root = new Node(postOrder[postEnd]);
		int inRoot = map.get(root.data);
		int numsLeft = inRoot - inStart;

		root.left = solve(postOrder, postStart, postStart + numsLeft - 1, inOrder, inStart, inRoot - 1, map);
		root.right = solve(postOrder, numsLeft + postStart, postEnd - 1, inOrder, inRoot + 1, inEnd, map);

		return root;
	}
}
