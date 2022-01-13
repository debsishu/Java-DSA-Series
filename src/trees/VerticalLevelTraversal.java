package trees;

import java.util.*;

public class VerticalLevelTraversal {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	static class Tuple {
		Node node;
		int row;
		int col;

		Tuple(Node node, int row, int col) {
			this.node = node;
			this.row = row;
			this.col = col;
		}
	}

	static class Pair {
		Node root;
		int level;

		Pair(int level, Node root) {
			this.level = level;
			this.root = root;
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

		List<List<Integer>> res = verticalTraversal(root);
		for (List<Integer> e : res) {
			System.out.println(e);
		}
	}

	static List<List<Integer>> verticalTraversal(Node root) {
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		Queue<Tuple> q = new LinkedList<>();
		q.add(new Tuple(root, 0, 0));

		while (!q.isEmpty()) {
			Tuple tuple = q.poll();
			Node node = tuple.node;
			int x = tuple.row;
			int y = tuple.col;

			if (!map.containsKey(x)) {
				map.put(x, new TreeMap<>());
			}
			if (!map.get(x).containsKey(y)) {
				map.get(x).put(y, new PriorityQueue<>());
			}

			map.get(x).get(y).offer(node.data);

			if (node.left != null) {
				q.offer(new Tuple(node.left, x - 1, y + 1));
			}
			if (node.right != null) {
				q.offer(new Tuple(node.right, x + 1, y + 1));
			}
		}

		List<List<Integer>> res = new LinkedList<>();
		for (TreeMap<Integer, PriorityQueue<Integer>> e : map.values()) {
			res.add(new LinkedList<>());
			for (PriorityQueue<Integer> nodes : e.values()) {
				res.get(res.size() - 1).addAll(nodes);
			}
		}
		return res;
	}

	// This is the GFG solution. The question states that the nodes that are in the
	// same level they should appear in the same order
	static ArrayList<Integer> verticalOrder(Node root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, root));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			ArrayList<Integer> list1 = map.get(p.level);
			if (list1 == null) {
				list1 = new ArrayList<>();
			}
			list1.add(p.root.data);
			map.put(p.level, list1);
			if (p.root.left != null) {
				q.add(new Pair(p.level - 1, p.root.left));
			}
			if (p.root.right != null) {
				q.add(new Pair(p.level + 1, p.root.right));
			}
		}
		for (ArrayList<Integer> e : map.values()) {
			res.addAll(e);
		}
		return res;
	}

	static List<List<Integer>> verticalTraveralRecursive(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		preOrder(root, map, 0, 0);
		for (TreeMap<Integer, PriorityQueue<Integer>> v : map.values()) {
			List<Integer> temp = new ArrayList<>();
			for (PriorityQueue<Integer> pq : v.values()) {
				while (!pq.isEmpty()) {
					temp.add(pq.remove());
				}
			}
			res.add(temp);
		}
		return res;
	}

	private static void preOrder(Node root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, int row,
			int col) {
		if (root == null) {
			return;
		}
		if (!map.containsKey(row)) {
			map.put(row, new TreeMap<>());
		}
		if (!map.get(row).containsKey(col)) {
			map.get(row).put(col, new PriorityQueue<>());
		}
		map.get(row).get(col).add(root.data);

		preOrder(root.left, map, row - 1, col + 1);
		preOrder(root.right, map, row + 1, col + 1);
	}

}
