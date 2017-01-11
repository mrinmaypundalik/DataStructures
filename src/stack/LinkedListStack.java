package stack;

import java.util.EmptyStackException;

/**Stack implementation using LinkedList*/
public class LinkedListStack<E> implements Stack<E>{
	private Node head;
	
	class Node{
		private Node next;
		private E data;
		
		Node(){
			this.next=null;
			this.data=null;
		}
		
		Node(E element){
			this.data=element;
			this.next=null;
		}
	}
	
	/**Get top, point head to next node*/
	public E pop(){
		
		E data = peek();
		head=head.next;
		return data;
	}
	
	public E peek(){
		if(head==null){
			throw new EmptyStackException();
		}
		
		return head.data;
	}
	
	public boolean push(E element){
		
		Node node = new Node(element);
		node.next=head;
		head=node;
		return true;
	}
	
	public boolean isEmpty(){
		if(head==null){
			return true;
		}
		return false;
	}
}
