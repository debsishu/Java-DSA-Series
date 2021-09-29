package trees;

public class InsertNodeInBST {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right = new Node(7);
	}

	static Node insertNode(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}
		Node temp = root;
		while (true) {
			if (temp.data <= data) {
				if (temp.right != null) {
					temp = temp.right;
				} else {
					temp.right = new Node(data);
					break;
				}
			} else {
				if (temp.left != null) {
					temp = temp.left;
				} else {
					temp.left = new Node(data);
					break;
				}
			}
		}
		return root;
	}
}
