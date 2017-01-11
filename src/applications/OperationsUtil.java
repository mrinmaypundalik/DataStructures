package applications;

public class OperationsUtil {

	protected static boolean isOperator(String operator){
		if(operator.equals("*") || operator.equals("/") || operator.equals("+") || operator.equals("-")){
			return true;
		}
		return false;
	}
	
	protected static double evaluate(double op1, double op2, String operator){
		
		double result=0.0;
		switch(operator){
		case "*": result=op1*op2;
		break;
		case "/": result=op1/op2;
		break;
		case "+": result=op1+op2;
		break;
		case "-": result=op1-op2;
		break;
		}
		return result;
	}
}