package trees;

import java.util.*;

public class AllTraveralInOne {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	static class Pair {
		Node node;
		int count;

		Pair(Node node, int count) {
			this.node = node;
			this.count = count;
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
		allTraversals(root);
	}

	static void allTraversals(Node root) {
		Stack<Pair> s = new Stack<>();
		s.push(new Pair(root, 1));
		List<Integer> preOrder = new LinkedList<>();
		List<Integer> inOrder = new LinkedList<>();
		List<Integer> postOrder = new LinkedList<>();

		if (root == null) {
			return;
		}

		while (!s.isEmpty()) {
			Pair it = s.pop();

			if (it.count == 1) {
				preOrder.add(it.node.data);
				it.count++;
				s.push(it);

				if (it.node.left != null) {
					s.push(new Pair(it.node.left, 1));
				}
			} else if (it.count == 2) {
				inOrder.add(it.node.data);
				it.count++;
				s.push(it);

				if (it.node.right != null) {
					s.push(new Pair(it.node.right, 1));
				}
			} else {
				postOrder.add(it.node.data);
			}
		}

		System.out.println("Pre-Order\n" + preOrder);
		System.out.println("In-Order\n" + inOrder);
		System.out.println("Post-Order\n" + postOrder);
	}
}
