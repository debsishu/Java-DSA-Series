package trees;

import java.util.*;

public class TopView {
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
		System.out.println(topView(root));
	}

	static class Pair {
		int level;
		Node node;

		Pair(int level, Node node) {
			this.level = level;
			this.node = node;
		}
	}

	static ArrayList<Integer> topView(Node root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, root));
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			int level = pair.level;
			Node temp = pair.node;
			if (map.get(level) == null) {
				map.put(level, temp.data);
			}
			if (temp.left != null) {
				q.add(new Pair(level - 1, temp.left));
			}
			if (temp.right != null) {
				q.add(new Pair(level + 1, temp.right));
			}
		}
		for (Integer e : map.values()) {
			res.add(e);
		}
		return res;
	}

}
