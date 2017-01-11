package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
	
	private int top=-1;
	private Object[] stack;
	private static final int DEFAULT_SIZE = 10;
	
	/**Initialize array to default size of 10*/
	public ArrayStack(){
		stack= new Object[DEFAULT_SIZE];
		}
	
	/**Pops the last in element out of the stack*/
	public E pop(){
		Object temp = peek();
		/**top points to the penultimate element*/
		top--;
		return (E)temp;
	}
	
	/**Pushes element on the stack*/
	public boolean push(E element){
		/**If array is full, create an array double the current size*/
		if(top==stack.length-1){
			stack = Arrays.copyOf(stack, 2*stack.length);
		}
		stack[++top] = element;	
		return true;
	}
	public E peek(){
		if(isEmpty()){
		System.out.println("The list is empty");	
		throw new EmptyStackException();
		}
		return (E)stack[top];
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
}
