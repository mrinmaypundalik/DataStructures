package List;

public class DoublyLinkedList<T> {
	private Node head;

	class Node {
		private T data;
		private Node next;
		private Node previous;

		Node(T data) {
			this.next = null;
			this.previous = null;
			this.data = data;
		}

		Node() {
			this.next = null;
			this.previous = null;
			this.data = null;
		}

	}

	/** Insert element at head */
	public void insertAtHead(T element) {
		Node node = new Node(element);
		/** If list is empty, head refers to newly created node */
		if (head == null) {
			head = node;
			return;
		}
		/**
		 * node.next refers to what head is pointing at, and head.previous i.e.
		 * the current 1st node's previous to newly created node. Finally, point
		 * head to new node
		 */
		node.next = head;
		head.previous = node;
		head = node;
		return;
	}

	/** Insert at the end */
	public void insertAtEnd(T element) {
		Node node = new Node(element);
		if (head == null) {
			head = node;
			return;
		}
		/** Traverse till the last node */
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		/**
		 * Point new node's previous to the current last node. Point current
		 * node's next to new node
		 */
		node.previous = temp;
		temp.next = node;
	}

	/** Insert element at nth position */
	public void insert(T element, int position) {

		/** If 1st position, insert at head is called */
		if (position == 1) {
			insertAtHead(element);
			return;
		}

		Node node = new Node(element);
		if (head == null) {
			head = node;
			return;
		}
		/** Traverse to the n-1 th node */
		Node temp = head;
		for (int i = 0; i < position - 2; i++) {
			temp = temp.next;
		}
		/**
		 * Point new node's next to n-1 th node's next. Now both node's next
		 * points at the same next node
		 */
		node.next = temp.next;

		/** new nodes previous should point to n-1th */
		node.previous = temp;

		/** Point n-1th node's next to newly created node */
		temp.next = node;

		/** Now point n+1th node's previous to new node */
		node.next.previous = node;
	}

	/** Delete element at a position */
	public void delete(int position) {
		if (head == null) {
			System.out.println("List is Empty ");
			return;
		}
		/** If 1st position, call deleteAtHead() */
		if (position == 1) {
			deleteAtHead();
			return;
		}

		/** Traverse to the n-1th node */
		Node temp = head;
		for (int i = 0; i < position - 2; i++) {
			temp = temp.next;
		}
		/**
		 * If n-1th node is the second last node, i.e. if we are deleting the
		 * last node, then call deleteAtEnd()
		 */
		if (temp.next.next == null) {
			deleteAtEnd();
			return;
		}

		/** Point n-1th node's next to next to next node i.e. n+1th node */
		temp.next = temp.next.next;
		/** Now, point n+1th node's previous to n-1th node */
		temp.next.previous = temp;
	}

	/** Delete at end */
	public void deleteAtEnd() {
		Node temp = head;
		/** Traverse to the end */
		while (temp.next != null) {
			temp = temp.next;
		}

		/** Set the previous i.e. n-1th node's next to null */
		temp.previous.next = null;
	}

	/** Delete at head */
	public void deleteAtHead() {
		head = head.next;
		head.previous = null;
	}

	public void print() {
		if (head == null) {
			System.out.println("List is Empty ");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void printReverse() {

		if (head == null) {
			System.out.println("List is Empty ");
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		while (temp != null) {
			// System.out.println(temp.data+" "+temp.previous+" "+temp+"
			// "+temp.next);
			System.out.print(temp.data + " ");
			temp = temp.previous;
		}
		System.out.println();
	}

}
