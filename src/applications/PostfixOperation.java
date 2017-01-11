package applications;

import stack.ArrayStack;
import stack.Stack;


public class PostfixOperation extends OperationsUtil {

	public static double evaluateExpression(String expression){
		
		Stack<Double> stack = new ArrayStack<Double>();
		String[] str = expression.split("\\s");
		for(int i=0;i<str.length;i++){
			if(!isOperator(str[i])){
				stack.push(Double.valueOf(str[i]));
				continue;
			}
			double op2 = stack.pop();
			double op1 = stack.pop();
			stack.push(evaluate(op1,op2,str[i]));
		}
		
		return stack.pop();
	}
	
}
