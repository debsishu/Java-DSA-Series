package trees;

public class KthSmallestInBST {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(4);
		root.left.left = new Node(3);
		root.left.left.left = new Node(2);
		root.left.left.left.left = new Node(1);
		root.left.left.right = new Node(4);
		System.out.println(kthSmallestElement(root, 3));
	}

	static int kthSmallestElement(Node root, int k) {
		int store[] = new int[2];
		store[0] = 1;
		helper(root, k, store);
		return store[1];
	}

	private static void helper(Node root, int k, int store[]) {
		if (root == null) {
			return;
		}
		helper(root.left, k, store);
		if (store[0] == k) {
			store[1] = root.data;
			store[0]++;
			return;
		} else {
			store[0]++;
		}
		helper(root.right, k, store);
	}
}
