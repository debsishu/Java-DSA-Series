package trees;

public class InsertNodeInBST {
	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int data) {
			this.val = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(7);
	}

	static TreeNode insertNode(TreeNode root, int data) {
		if (root == null) {
			return new TreeNode(data);
		}
		TreeNode temp = root;
		while (true) {
			if (temp.val <= data) {
				if (temp.right != null) {
					temp = temp.right;
				} else {
					temp.right = new TreeNode(data);
					break;
				}
			} else {
				if (temp.left != null) {
					temp = temp.left;
				} else {
					temp.left = new TreeNode(data);
					break;
				}
			}
		}
		return root;
	}
}
