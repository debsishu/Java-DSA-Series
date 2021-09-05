package trees;

public class DiameterOfBinaryTree {
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

		System.out.println(diameterOfTree(root));
	}

	static int diameterOfTree(Node root) {
		if (root == null) {
			return 0;
		}
		int res[] = new int[1];
		res[0] = Integer.MIN_VALUE;
		solve(root, res);
		return res[0];
	}

	private static int solve(Node root, int[] res) {
		if (root == null) {
			return 0;
		}
		int left = solve(root.left, res);
		int right = solve(root.right, res);

		res[0] = Math.max(res[0], 1 + left + right);
		return Math.max(left, right) + 1;
	}
}
