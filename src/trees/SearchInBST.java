package trees;

public class SearchInBST {
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
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		System.out.println(searchInBST(root, 1).data);
	}

	static Node searchInBST(Node root, int target) {
		Node curr = root;
		while (curr != null) {
			if (curr.data > target) {
				curr = curr.left;
			} else if (curr.data < target) {
				curr = curr.right;
			} else {
				return curr;
			}
		}
		return null;
	}
}
