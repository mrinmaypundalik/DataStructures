package List;

public class LinkedList<T> {

	private Node head;

	class Node {
		private Node next;
		private T data;

		Node(T data) {
			next = null;
			this.data = data;
		}

		Node() {
			next = null;
			data = null;
		}
	}

	/** Insert element at nth position */
	public void insert(T element, int position) {
		/** create a new Node named temp */
		Node node = new Node(element);

		/**
		 * if it is the first node, then it should refer to what head is
		 * referring to but not head.next as head is not a node as such but only
		 * a reference. Then the head refers to the newly created node. Again no
		 * head.next or temp.next, just direct referencing.
		 */
		if (position == 1) {
			node.next = head;
			head = node;
			return;
		}
		/**
		 * If node is inserted at a position other than 1, create another
		 * temporary node reference temp1 which refers to the same node as head.
		 * Now traverse to the second last node of the desired node i.e. n-1
		 * node. For that we have to loop n-2 times as we are already referring
		 * to the 1st node.
		 */
		Node temp1 = head;
		for (int i = 0; i < position - 2; i++) {
			temp1 = temp1.next;
		}
		/**
		 * refer newly created temp node's next to the now traversed node n-1 th
		 * node's next so that temp now becomes nth node. Also, set n-1 th next
		 * to refer nth node i.e. temp
		 */
		node.next = temp1.next;
		temp1.next = node;
	}

	/** Insert element in the Linked-List */
	public void insert(T element) {
		Node node = new Node(element);
		/** If 1st node, refer head to node */
		if (head == null) {
			node.next = head;
			head = node;
			return;
		}
		/** If not 1st node, traverse from head to last node */
		Node temp1 = head;
		while (temp1.next != null) {
			temp1 = temp1.next;
		}
		/**
		 * Refer node to what nth node is referring to, and refer nth node to
		 * node
		 */
		node.next = temp1.next;
		temp1.next = node;
	}

	public void delete(int position) {
		/** Temp refers to 1st node */
		Node temp = head;
		/** If 1st node is to be deleted, head should refer to 1st.next */
		if (position == 1) {
			head = temp.next;
			return;
		}
		/**
		 * Travel to n-2 as n-2.next refers to n-1 So now temp is a reference to
		 * n-1 i.e. temp is n-1
		 */
		for (int i = 0; i < position - 2; i++) {
			temp = temp.next;
		}
		/**
		 * n-1.next i.e. nth node is referred by temp1. So temp1 is nth node Now
		 * refer n-1.next to n+1 i.e. temp.next refers to n+1th node
		 */
		Node temp1 = temp.next;
		temp.next = temp1.next;
	}

	public void reverseUsingIteration() {
		Node current, next, previous;
		/** current points to 1st node and previous is null */
		current = head;
		previous = null;
		while (current != null) {
			/** next points to 2nd node */
			next = current.next;
			/** 1st node points to previous */
			current.next = previous;
			/** previous now refers current i.e. 1st node */
			previous = current;
			/** current points to next i.e. 2nd node */
			current = next;
		}
		/** head points to previous i.e. nth node */
		head = previous;
	}

	public void reverseUsingRecursion() {
		recursion(head);
	}

	private void recursion(Node node) {
		/** Refer last node by head */
		if (node.next == null) {
			head = node;
			return;
		}
		/**
		 * Recursive calls are made. When it reaches the last node, IF condition
		 * executes and control goes back to n-1th iteration.
		 */
		recursion(node.next);
		/** Temp node refers to the n-1.next i.e. last node */
		Node temp = node.next;
		/** last node points to n-1th node */
		temp.next = node;
		/** n-1th node points to null */
		node.next = null;
	}

	public void print() {
		Node node = head;
		int count = 0;
		while (node != null) {
			count++;
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println("Total Elements: " + count);
	}

	/** Print Reverse using Recursion */
	public void printReverseUsingRecursion(Node node) {
		if (node == null) {
			return;
		}
		printReverseUsingRecursion(node.next);
		System.out.print(node.data + " ");
		System.out.println();
	}

	/** Print using Recursion */
	public void printUsingRecursion(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		printUsingRecursion(node.next);
	}
}
