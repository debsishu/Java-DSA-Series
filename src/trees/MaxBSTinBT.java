package trees;

public class MaxBSTinBT {

	static int largestBST(Node root) {
		return solve(root).maxSize;
	}

	static class NodeValue {
		int maxSize;
		int maxNode, minNode;

		NodeValue(int maxSize, int minNode, int maxNode) {
			this.maxSize = maxSize;
			this.maxNode = maxNode;
			this.minNode = minNode;
		}
	}

	static NodeValue solve(Node root) {
		if (root == null) {
			return new NodeValue(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		NodeValue left = solve(root.left);
		NodeValue right = solve(root.right);

		if (left.maxNode < root.data && root.data < right.minNode) {
			return new NodeValue(1 + left.maxSize + right.maxSize, Math.min(root.data, left.minNode),
					Math.max(root.data, right.maxNode));
		}
		return new NodeValue(Math.max(left.maxSize, right.maxSize), Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

}
