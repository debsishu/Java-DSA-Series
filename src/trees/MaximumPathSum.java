package trees;

public class MaximumPathSum {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(-10);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		System.out.println(maxPathSum(root));
	}

	static int maxPathSum(Node root) {
		int res[] = new int[1];
		res[0] = Integer.MIN_VALUE;
		solve1(root, res);
		return res[0];
	}

	static int solve(Node root, int[] res) {
		if (root == null) {
			return 0;
		}

		int left = solve(root.left, res);
		int right = solve(root.right, res);

		int temp = Math.max(root.data, Math.max(left, right) + root.data);
		int ans = Math.max(root.data, root.data + left + right);

		if (ans > res[0]) {
			res[0] = ans;
		}
		return temp;
	}

	// Alternative Way
	static int solve1(Node root, int res[]) {
		if (root == null)
			return 0;
		int left = Math.max(0, solve1(root.left, res));
		int right = Math.max(0, solve1(root.right, res));
		res[0] = Math.max(res[0], root.data + left + right);
		return Math.max(left, right) + root.data;
	}
}
