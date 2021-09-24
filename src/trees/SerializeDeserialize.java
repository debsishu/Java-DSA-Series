package trees;

import java.util.*;

public class SerializeDeserialize {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {

	}

	static String serialize(Node root) {
		if (root == null) {
			return "";
		}
		Queue<Node> q = new LinkedList<>();
		StringBuilder res = new StringBuilder();
		q.add(root);

		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (curr == null) {
				res.append("#");
				continue;
			}
			res.append(curr.data);
			q.add(curr.left);
			q.add(curr.right);
		}
		return res.toString();
	}

	static Node deserialize(String s) {
		if (s == "") {
			return null;
		}
		Queue<Node> q = new LinkedList<>();
		char arr[] = s.toCharArray();
		Node root = new Node(Integer.parseInt(String.valueOf(arr[0])));
		q.add(root);

		for (int i = 1; i < arr.length; i++) {
			Node parent = q.poll();
			if (arr[i] != '#') {
				Node left = new Node(Integer.parseInt(String.valueOf(arr[i])));
				parent.left = left;
				q.add(left);
			}
			if (arr[++i] != '#') {
				Node right = new Node(Integer.parseInt(String.valueOf(arr[i])));
				parent.right = right;
				q.add(right);
			}
		}
		return root;
	}
}
