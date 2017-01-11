package applications;

import java.util.Stack;

public class InfixToPostfix extends OperationsUtil {
	private static final String SPACE = " ";

	public static String converToPostfix(String expression) {
		String[] infix = expression.split("\\s");
		Stack<String> stack = new Stack<String>();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < infix.length; i++) {
			if (isOpeningParanthesis(infix[i])) {
				stack.push(infix[i]);
				continue;
			}
			if (isClosingParanthesis(infix[i])) {
				while (!isOpeningParanthesis(stack.peek())) {
					builder.append(stack.pop()).append(SPACE);
				}
				stack.pop();
				continue;
			}
			if (isOperator(infix[i])) {
				if (stack.isEmpty() || !isOperator(stack.peek())) {
					stack.push(infix[i]);
				} else if (hasHigherPrecedence(infix[i], stack.peek())) {
					stack.push(infix[i]);
				} else {
					builder.append(stack.pop()).append(SPACE);
					stack.push(infix[i]);
				}
				continue;
			}
			builder.append(infix[i]).append(SPACE);
		}

		while (!stack.isEmpty()) {
			builder.append(stack.pop()).append(SPACE);
		}
		return builder.toString();
	}

	private static boolean isOpeningParanthesis(String s) {

		if (s.equals("(") || s.equals("{") || s.equals("["))
			return true;
		return false;
	}

	private static boolean isClosingParanthesis(String s) {

		if (s.equals(")") || s.equals("}") || s.equals("]"))
			return true;
		return false;
	}

	private static boolean hasHigherPrecedence(String firstOp, String secondOp) {
		int firstValue = getOperatorValue(firstOp);
		int secondValue = getOperatorValue(secondOp);
		if (firstValue > secondValue) {
			return true;
		}
		return false;
	}

	private static int getOperatorValue(String operator) {
		int value = 0;
		switch (operator) {
		case "*":
			value = 3;
			break;
		case "/":
			value = 4;
			break;
		case "+":
			value = 2;
			break;
		case "-":
			value = 1;
			break;
		}
		return value;
	}
}
