package trees;

public class IdenticalTree {
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

		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(55);
		System.out.println(isSame(root, root1));
	}

	static boolean isSame(Node p, Node q) {
		if (p == null || q == null)
			return (p == q);
		boolean left = isSame(p.left, q.left);
		boolean right = isSame(p.right, q.right);
		return p.data == q.data && left && right;
	}
}
