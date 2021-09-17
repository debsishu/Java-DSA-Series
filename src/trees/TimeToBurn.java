package trees;

import java.util.*;

public class TimeToBurn {
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
		root.left.left.right = new Node(7);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		System.out.println(timeToBurn(root, 2));
	}

	static int timeToBurn(Node root, int tar) {
		Map<Node, Node> parentMap = new HashMap<>();
		Node target = markParents(root, parentMap, tar);
		if (target == null)
			return 0;
		Queue<Node> q = new LinkedList<>();
		Map<Node, Boolean> visited = new HashMap<>();
		q.add(target);
		int time = 0;
		visited.put(target, true);

		while (!q.isEmpty()) {
			int size = q.size();
			boolean flag = false;
			for (int i = 0; i < size; i++) {
				Node curr = q.poll();
				if (curr.left != null && visited.containsKey(curr.left) == false) {
					flag = true;
					q.add(curr.left);
					visited.put(curr.left, true);
				}
				if (curr.right != null && visited.containsKey(curr.right) == false) {
					flag = true;
					q.add(curr.right);
					visited.put(curr.right, true);
				}
				if (parentMap.get(curr) != null && visited.containsKey(parentMap.get(curr)) == false) {
					flag = true;
					q.add(parentMap.get(curr));
					visited.put(parentMap.get(curr), true);
				}
			}
			if (flag)
				time++;
		}
		return time;
	}

	private static Node markParents(Node root, Map<Node, Node> parentMap, int target) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		Node res = null;
		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (curr.data == target) {
				res = curr;
			}
			if (curr.left != null) {
				parentMap.put(curr.left, curr);
				q.add(curr.left);
			}
			if (curr.right != null) {
				parentMap.put(curr.right, curr);
				q.add(curr.right);
			}
		}
		return res;
	}
}
