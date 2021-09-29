package trees;

public class DeleteNodeInBST {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {

	}

	static Node deleteNode(Node root, int key) {
		if (root == null) {
			return null;
		}
		if (root.data == key) {
			return helper(root);
		}
		Node tempRoot = root;
		while (root != null) {
			if (root.data > key) {
				if (root.left != null && root.left.data == key) {
					root.left = helper(root.left);
					break;
				} else {
					root = root.left;
				}
			} else {
				if (root.right != null && root.right.data == key) {
					root.right = helper(root.right);
					break;
				} else {
					root = root.right;
				}
			}
		}
		return tempRoot;
	}

	static Node helper(Node root) {
		if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			return root.left;
		} else {
			Node rightChild = root.right;
			Node lastRight = findLast(root.left);
			lastRight.right = rightChild;
			return root.left;
		}
	}

	static Node findLast(Node root) {
		if (root.right == null) {
			return root;
		}
		return findLast(root.right);
	}
}
