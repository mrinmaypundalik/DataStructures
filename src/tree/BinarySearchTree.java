package tree;

public class BinarySearchTree {
	private Node root;

	class Node {
		private Node right, left;
		private int data;

		Node() {
			this(0);
		}

		Node(int data) {
			this.right = null;
			this.left = null;
			this.data = data;
		}
	}

	public boolean insert(int element) {

		if (root == null) {
			Node node = new Node(element);
			root = node;
			return true;
		}

		insert(root, element);
		return true;
	}

	private Node insert(Node node, int element) {

		if (node == null) {
			Node temp = new Node(element);
			return temp;
		}
		if (element <= node.data) {
			node.left = insert(node.left, element);
		} else {
			node.right = insert(node.right, element);
		}
		return node;
	}

	public int findHeight() {
		if (root == null)
			return 0;
		return findHeight(root);
	}

	private int findHeight(Node node) {
		if (node == null)
			return -1;

		return Math.max(findHeight(node.left), findHeight(node.right)) + 1;
	}

}
