package trees;

public class CountNodesCompleteBinaryTree {
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
		System.out.println(countNodes(root));
	}

	static int countNodes(Node root) {
		if (root == null)
			return 0;
		int left = leftHeight(root);
		int right = rightHeight(root);
		if (left == right)
			return ((2 << (left)) - 1);
		else
			return countNodes(root.left) + countNodes(root.right) + 1;
	}

	private static int leftHeight(Node root) {
		Node temp = root;
		int count = 0;
		while (temp.left != null) {
			count++;
			temp = temp.left;
		}
		return count;
	}

	private static int rightHeight(Node root) {
		Node temp = root;
		int count = 0;
		while (temp.right != null) {
			count++;
			temp = temp.right;
		}
		return count;
	}
}
