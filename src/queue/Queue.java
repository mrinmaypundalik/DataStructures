package queue;

public interface Queue<E> {

	public boolean enQueue(E element);
	public E deQueue();
	public E front();
	public boolean isEmpty();
	public boolean isFull();
}
