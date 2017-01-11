package queue;

import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E> {

	private Object[] queue;
	private static final int DEFAULT_SIZE = 10;
	private int front, rear, currentSize;
	private static final int maxSize = 100;

	ArrayQueue() {
		queue = new Object[DEFAULT_SIZE];
		/** Is initially -1 */
		front = rear = -1;
		currentSize = DEFAULT_SIZE;
	}

	@Override
	public boolean enQueue(E element) {
		/** If its a start, set front=0 */
		if (isEmpty()) {
			front = 0;
		}
		/**
		 * If reached max, double queue size to twice currentSize and reset
		 * current Size
		 */
		else if (isFull()) {
			if (maxSize <= currentSize) {
				System.out.println("Queue has reached its maximum capacity");
				return false;
			}
			queue = Arrays.copyOf(queue, 2 * currentSize);
			currentSize = queue.length;
		}
		/** rear is set to circular next */
		rear = (rear + 1) % currentSize;
		queue[rear] = element;
		return true;
	}

	@Override
	public E deQueue() {
		if (isEmpty()) {
			return null;
		}
		Object obj = null;
		/**
		 * If front and rear point to same index, that means the queue is about
		 * to be empty. So, fetch the element first and set reset them to -1
		 */
		if (front == rear) {
			obj = queue[front];
			rear = front = -1;
		} else {
			obj = queue[front];
			front = (front + 1) % currentSize;
		}
		return (E) obj;
	}

	@Override
	public E front() {
		return isEmpty() ? null : (E) queue[front];
	}

	@Override
	public boolean isEmpty() {
		return (front == -1 && rear == -1);
	}

	@Override
	public boolean isFull() {
		return (rear + 1) % currentSize == front ? true : false;
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return;
		}
		/** calculate the number of elements in the queue */
		int queueSize = (rear - front + currentSize) % currentSize + 1;
		int index = 0;
		for (int i = 0; i < queueSize; i++) {
			index = (front + i) % currentSize;
			System.out.print(queue[index] + " ");
		}
		System.out.println();
	}

}
