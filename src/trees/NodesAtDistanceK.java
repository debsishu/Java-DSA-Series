package trees;

import java.util.*;

public class NodesAtDistanceK {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(5);
		root.right = new Node(1);
		root.left.left = new Node(6);
		root.left.right = new Node(2);
		root.right.left = new Node(0);
		root.right.right = new Node(8);
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(4);
		System.out.println(distanceK(root, root.left, 2));
	}

	static List<Integer> distanceK(Node root, Node target, int k) {
		Map<Node, Node> parentMap = new HashMap<>();
		markParents(root, parentMap);
		Map<Node, Boolean> visited = new HashMap<>();
		Queue<Node> q = new LinkedList<>();
		q.add(target);
		visited.put(target, true);
		int currLevel = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			if (currLevel == k) {
				break;
			}
			currLevel++;
			for (int i = 0; i < size; i++) {
				Node curr = q.poll();
				if (curr.left != null && visited.get(curr.left) == null) {
					q.add(curr.left);
					visited.put(curr.left, true);
				}
				if (curr.right != null && visited.get(curr.right) == null) {
					q.add(curr.right);
					visited.put(curr.right, true);
				}
				if (parentMap.get(curr) != null && visited.get(parentMap.get(curr)) == null) {
					q.add(parentMap.get(curr));
					visited.put(parentMap.get(curr), true);
				}
			}
		}
		List<Integer> res = new LinkedList<>();
		while (!q.isEmpty()) {
			res.add(q.poll().data);
		}
		return res;
	}

	private static void markParents(Node root, Map<Node, Node> parentMap) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (curr.left != null) {
				parentMap.put(curr.left, curr);
				q.add(curr.left);
			}
			if (curr.right != null) {
				parentMap.put(curr.right, curr);
				q.add(curr.right);
			}
		}
	}
}
