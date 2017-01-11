package queue;

public class LinkedListQueue<E> implements Queue<E> {
	/** One rear and one front reference */
	private Node front, rear;

	private class Node {
		Node next;
		E data;

		Node() {
			this(null);
		}

		Node(E element) {
			next = null;
			data = element;
		}
	}

	public LinkedListQueue() {
		rear = front = null;
	}

	@Override
	public boolean enQueue(E element) {

		Node node = new Node(element);
		/** If empty queue, refer both nodes to newly created node */
		if (isEmpty()) {
			front = rear = node;
			return true;
		}
		/** If queue is not empty, insert new node at the end */
		rear.next = node;
		rear = node;
		return true;
	}

	@Override
	public E deQueue() {

		if (isEmpty()) {
			return null;
		}
		Node temp = front;
		front = front.next;
		return temp.data;
	}

	@Override
	public E front() {
		return isEmpty() ? null : front.data;
	}

	/** If front is referencing null, then it is empty */
	@Override
	public boolean isEmpty() {
		return (front == null) ? true : false;
	}

	/** Can never be full */
	@Override
	public boolean isFull() {
		return false;
	}

	public void print() {
		Node tempFront = front;
		while (tempFront != null) {
			System.out.print(tempFront.data + " ");
			tempFront = tempFront.next;
		}
		System.out.println();
	}

}
