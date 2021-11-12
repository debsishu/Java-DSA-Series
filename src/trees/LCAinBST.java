package trees;

public class LCAinBST {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

	}

	static Node lowestCommonAncestor(Node root, Node p, Node q) {
		if (root == null) {
			return null;
		}
		if (root.data > p.data && q.data > root.data) {
			return root;
		} else if (root.data > p.data && root.data > q.data) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (root.data < p.data && root.data < q.data) {
			return lowestCommonAncestor(root.right, p, q);
		}
		return root;
	}
}
