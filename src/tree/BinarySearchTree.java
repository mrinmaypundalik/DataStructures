package tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinarySearchTree {
	private Node root;
	private Node previous;

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

		if (isEmpty()) {
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
		if (isEmpty())
			return 0;
		return findHeight(root);
	}

	private int findHeight(Node node) {
		if (node == null)
			return -1;

		return Math.max(findHeight(node.left), findHeight(node.right)) + 1;
	}

	public boolean search(int data) {
		return search(root, data);
	}

	private boolean search(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		}
		return data > node.data ? search(node.right, data) : search(node.left, data);
	}

	/** Get Min using iteration */
	/*
	 * public int getMin() { if (isEmpty()) { throw new
	 * RuntimeException("Tree is Empty!"); } Node node = root; while (node.left
	 * != null) { node = node.left; } return node.data; }
	 */

	/** Get Min using recursion */
	public int getMin() {
		if (isEmpty()) {
			throw new RuntimeException("Tree is Empty!");
		}
		return getMin(root);
	}

	public int getMin(Node node) {
		if (node.left == null) {
			return node.data;
		}
		return getMin(node.left);
	}

	public int getMax() {
		if (isEmpty()) {
			throw new RuntimeException("Tree is Empty!");
		}
		return getMax(root);
	}

	private int getMax(Node node) {
		if (node.right == null) {
			return node.data;
		}
		return getMax(node.right);
	}

	/** Breadth-First Traversal */
	public void levelOrderTraversal() {
		if (isEmpty()) {
			System.out.println("Tree is empty!");
			return;
		}
		Queue<Node> queue = new LinkedBlockingQueue<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			if (queue.peek().left != null) {
				queue.add(queue.peek().left);
			}
			if (queue.peek().right != null) {
				queue.add(queue.peek().right);
			}
			System.out.println(queue.poll().data);
		}
	}

	/** Depth-First Traversal */
	public void preorderTraversal() {
		if (isEmpty()) {
			System.out.println("Tree is empty!");
		}
		preorderTraversal(root);
	}

	private void preorderTraversal(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}

	public void inorderTraversal() {
		if (isEmpty()) {
			System.out.println("Tree is empty!");
		}
		inorderTraversal(root);
	}

	private void inorderTraversal(Node node) {
		if (node == null) {
			return;
		}
		inorderTraversal(node.left);
		System.out.println(node.data);
		inorderTraversal(node.right);
	}

	public void postorderTraversal() {
		if (isEmpty()) {
			System.out.println("Tree is empty!");
		}
		postorderTraversal(root);
	}

	private void postorderTraversal(Node node) {
		if (node == null) {
			return;
		}
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.println(node.data);
	}

	public boolean isBinarySearchTree() {
		if (isEmpty()) {
			return true;
		}
		return isBinarySearchTree(root);
	}

	private boolean isBinarySearchTree(Node node) {
		if (node == null) {
			return true;
		}
		if (node.left != null && node.data < node.left.data) {
			return false;
		}
		if (node.right != null && node.data > node.right.data) {
			return false;
		}
		return isBinarySearchTree(node.left) && isBinarySearchTree(node.right);
	}

	public boolean isBinarySearchTreeByInorderTraversal() {
		if (isEmpty()) {
			return true;
		}
		return isBinarySearchTreeByInorderTraversal(root);
	}

	private boolean isBinarySearchTreeByInorderTraversal(Node node) {
		if (node == null) {
			return true;
		}
		if (!isBinarySearchTreeByInorderTraversal(node.left)) {
			return false;
		}
		if (previous != null && previous.data > node.data) {
			return false;
		}
		return isBinarySearchTreeByInorderTraversal(node.right);
	}

	public boolean isBinarySearchTreeByMinMax() {
		if (isEmpty()) {
			return true;
		}
		return isBinarySearchTreeByMinMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBinarySearchTreeByMinMax(Node node, int min, int max) {
		if (node != null) {
			if (node.data < min || node.data > max) {
				return false;
			}
			return isBinarySearchTreeByMinMax(node.left, min, node.data)
					&& isBinarySearchTreeByMinMax(node.right, node.data, max);
		}
		return true;
	}

	public void delete(int value) {
		if (isEmpty()) {
			return;
		}
		delete(root, value);
	}

	private Node delete(Node node, int data) {
		if (node == null) {
			return node;
		}
		/** Check right */
		if (data > node.data) {
			node.right = delete(node.right, data);
		}
		/** Check left */
		else if (data < node.data) {
			node.left = delete(node.left, data);
		}
		/** Got it! */
		else {
			/** Case 1: No children nodes */
			if (node.left == null && node.right == null) {
				node = null;
			}
			/** Case 2: One Child Node */
			else if (node.left == null) {
				node = node.right;
			} else if (node.right == null) {
				node = node.left;
			}
			/** Case 3: Two Children nodes */
			else {
				/**
				 * This can be done by getting max from the left branch or min
				 * from the right branch
				 */
				node.data = getMax(node.left);
				node.left = delete(node.left,
						node.data);/**
									 * node.data = getMin(node.right);
									 * node.right = delete(node.right,
									 * node.data);
									 */
			}
		}
		return node;
	}

	public int getSuccessor(int data) {
		if (isEmpty()) {
			throw new RuntimeException("Tree is Empty!");
		}
		Node current = getNode(root, data);
		/**
		 * Case 1: When Left is scanned and we are referring to the Middle node.
		 * Then successor is the Min in the left branch
		 */
		if (current.right != null) {
			return getMin(current.right);
		}
		/**
		 * Case 2: When there is no right branch, successor is the next
		 * immediate ancestor whose data value is not yet fetched
		 */
		else {
			Node successor = null;
			Node ancestor = root;
			while (current != ancestor) {
				if (current.data < ancestor.data) {
					successor = ancestor;
					ancestor = ancestor.left;
				} else {
					ancestor = ancestor.right;
				}
			}
			return successor.data;
		}
	}

	public boolean isEmpty() {
		return root == null ? true : false;
	}

	private Node getNode(Node node, int data) {
		if (node == null) {
			return null;
		}
		if (data < node.data) {
			node = getNode(node.left, data);
		}
		if (data > node.data) {
			node = getNode(node.right, data);
		}
		return node;
	}

}