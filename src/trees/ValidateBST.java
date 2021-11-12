package trees;

public class ValidateBST {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(1);
		root.right = new Node(4);
		root.right.left = new Node(3);
		root.right.right = new Node(6);
		System.out.println(validateBST(root));
	}

	static boolean validateBST(Node root) {
		return validate(root, Long.MIN_VALUE, Long.MIN_VALUE);
	}

	private static boolean validate(Node root, long left, long right) {
		if (root == null) {
			return true;
		}
		if (root.data <= left || root.data >= right) {
			return false;
		}
		return (validate(root.left, left, root.data) && validate(root.right, root.data, right));
	}
}
