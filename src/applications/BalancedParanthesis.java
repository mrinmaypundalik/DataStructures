package applications;

import java.util.Stack;

public class BalancedParanthesis {

	public static boolean isBalanced(String exp){
		
		Stack<Character> stack = new Stack<Character>();
		char[] array = exp.toCharArray();
		for(int i=0; i<exp.length();i++){
		
			if(array[i]=='(' || array[i]=='{' || array[i]=='['){
				stack.push(array[i]);
			}
			else if (array[i]==')' || array[i]=='}' || array[i]==']'){
				if(stack.isEmpty() || !isPair(stack.peek(), array[i]) ){
					return false;
				}
				stack.pop();
			}
		}
		return true;
	}
	
	private static boolean isPair(char opening, char closing){
		boolean isPair=false;
		if(opening=='(' && closing==')'){
			isPair=true;
		}
		if(opening=='{' && closing=='}'){
			isPair=true;
		}
		if(opening=='[' && closing==']'){
			isPair=true;
		}
		return isPair;
	}
}
