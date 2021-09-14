package trees;

public class ChildrenSumProperty {
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
	}

	static void changeTree(Node root) {
		if (root == null) {
			return;
		}
		int child = 0;
		if (root.left != null)
			child += root.left.data;
		if (root.right != null)
			child += root.right.data;

		if (child >= root.data) {
			root.data = child;
		} else {
			if (root.left != null)
				root.left.data = root.data;
			if (root.right != null)
				root.right.data = root.data;
		}
		changeTree(root.left);
		changeTree(root.right);

		int total = 0;
		if (root.left != null)
			total += root.left.data;
		if (root.right != null)
			total += root.right.data;

		if (root.left != null || root.right != null) {
			root.data = total;
		}
	}
}
