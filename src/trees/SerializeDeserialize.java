package trees;

import java.util.*;

public class SerializeDeserialize {
	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
			left = right = null;
		}
	}

	public static void main(String[] args) {

	}

	static String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		Queue<TreeNode> q = new LinkedList<>();
		StringBuilder res = new StringBuilder();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode curr = q.poll();
			if (curr == null) {
				res.append("#");
				continue;
			}
			res.append(curr.val);
			q.add(curr.left);
			q.add(curr.right);
		}
		return res.toString();
	}

	static TreeNode deserialize(String s) {
		if (s == "") {
			return null;
		}
		Queue<TreeNode> q = new LinkedList<>();
		char arr[] = s.toCharArray();
		TreeNode root = new TreeNode(Integer.parseInt(String.valueOf(arr[0])));
		q.add(root);

		for (int i = 1; i < arr.length; i++) {
			TreeNode parent = q.poll();
			if (arr[i] != '#') {
				TreeNode left = new TreeNode(Integer.parseInt(String.valueOf(arr[i])));
				parent.left = left;
				q.add(left);
			}
			if (arr[++i] != '#') {
				TreeNode right = new TreeNode(Integer.parseInt(String.valueOf(arr[i])));
				parent.right = right;
				q.add(right);
			}
		}
		return root;
	}
}
