package trees;

import java.util.*;

public class ConstructBinaryTreePre {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		int preOrder[] = { 3, 9, 20, 15, 7 };
		int inOrder[] = { 9, 3, 15, 20, 7 };
		Node root = buildTree(preOrder, inOrder);
		printTree(root);
	}

	static void printTree(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		printTree(root.left);
		printTree(root.right);
	}

	static Node buildTree(int preOrder[], int inOrder[]) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inOrder.length; i++) {
			map.put(inOrder[i], i);
		}

		Node root = buildTreeUtil(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, map);
		return root;
	}

	private static Node buildTreeUtil(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd,
			Map<Integer, Integer> map) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		Node root = new Node(preOrder[preStart]);
		int inRoot = map.get(root.data);
		int numsLeft = inRoot - inStart;

		root.left = buildTreeUtil(preOrder, preStart + 1, preStart + numsLeft, inOrder, inStart, inRoot - 1, map);
		root.right = buildTreeUtil(preOrder, preStart + numsLeft + 1, preEnd, inOrder, inRoot + 1, inEnd, map);

		return root;
	}

}
