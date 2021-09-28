package trees;

public class CeilInBST {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		System.out.println(findCeil(root, 4));
	}

	static int findCeil(Node root, int target) {
		int ceil = Integer.MIN_VALUE;
		Node curr = root;
		while (curr != null) {
			if (curr.data == target) {
				ceil = curr.data;
				return ceil;
			}
			if (target > curr.data) {
				curr = curr.right;
			} else {
				ceil = curr.data;
				curr = curr.left;
			}
		}
		return ceil;
	}
}
