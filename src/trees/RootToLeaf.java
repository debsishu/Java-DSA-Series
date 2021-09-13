package trees;

import java.util.*;

public class RootToLeaf {
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
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		ArrayList<ArrayList<Integer>> res = rootToLeafPath(root);
		for (ArrayList<Integer> e : res) {
			System.out.println(e);
		}
	}

	static ArrayList<ArrayList<Integer>> rootToLeafPath(Node root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		Stack<Integer> path = new Stack<>();
		solve(root, res, path);
		return res;
	}

	private static void solve(Node root, ArrayList<ArrayList<Integer>> res, Stack<Integer> path) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			path.push(root.data);
			ArrayList<Integer> temp = new ArrayList<>();
			for (Integer e : path) {
				temp.add(e);
			}
			res.add(temp);
			path.pop();
			return;
		}
		path.push(root.data);
		solve(root.left, res, path);
		solve(root.right, res, path);
		path.pop();
	}

}
