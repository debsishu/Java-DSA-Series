package trees;

import java.util.*;

public class PathToGivenNode {
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
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		System.out.println(pathToNode(root, 6));
	}

	static ArrayList<Integer> pathToNode(Node root, int target) {
		ArrayList<Integer> res = new ArrayList<>();
		solve(root, target, res);
		return res;
	}

	private static boolean solve(Node root, int target, ArrayList<Integer> res) {
		if (root == null) {
			return false;
		}
		res.add(root.data);
		if (root.data == target) {
			return true;
		}
		if (solve(root.left, target, res) || solve(root.right, target, res)) {
			return true;
		}
		res.remove(res.size() - 1);
		return false;
	}
}
