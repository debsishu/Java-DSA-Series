package trees;

public class FloorInBST {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(13);
		root.left.left = new Node(3);
		root.left.right = new Node(6);
		root.right.left = new Node(11);
		System.out.println(findFloor(root, 7));
	}

	static int findFloor(Node root, int key) {
		Node temp = root;
		int floor = -1;
		while (temp != null) {
			if (temp.data == key) {
				return temp.data;
			}
			if (key > temp.data) {
				floor = temp.data;
				temp = temp.right;
			} else {
				temp = temp.left;
			}
		}
		return floor;
	}
}
