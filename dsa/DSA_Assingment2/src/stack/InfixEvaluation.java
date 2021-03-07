package stack;

public class InfixEvaluation implements Stack {
	public String[] list;
	int size = 0;

	public InfixEvaluation(int length) {
		list = new String[length];

	}

	@Override
	public boolean isEmpty() {
		if (list.length == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int push(String x) {
		list[size++] = x;
		return 0;
	}

	@Override
	public String pop() {
		String s = null;
		if (!isEmpty()) {
			s = list[size - 1];
			list[size - 1] = null;
			size--;

		}
		return s;
	}

	@Override
	public String peek() {
		if (!isEmpty())
			return list[size - 1];
		return null;
	}

	private static boolean isBooleanOperator(String operator) {
		if (operator.equals("<") || operator.equals(">")
				|| operator.equals("=") || operator.equals("==")
				|| operator.equals("||") || operator.equals("!")
				|| operator.equals("!=") || operator.equals("&&")
				|| operator.equals(">=") || operator.equals("<=")) {
			return true;
		}
		return false;
	}

	private static boolean isArithmeticOperator(String operator) {
		if (operator.equals("+") || operator.equals("-")
				|| operator.equals("*") || operator.equals("/")) {
			return true;
		}
		return false;
	}

	public static boolean isConstant(String operand) {

		for (int i = 0; i < operand.length(); i++) {
			char c = operand.charAt(i);
			if (c >= '0' && c <= '9') {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	// public static boolean isVariable(String operand){
	// for (int i = 0; i < operand.length(); i++) {
	// char c = operand.charAt(i);
	// if (c >= 'a' && c <= 'z' || c >= 'A'
	// && c <= 'Z'){
	// continue;
	// }
	// }
	// }

	public static int arithmeticPrecedence(String operatorAtPeek, String current) {
		if (operatorAtPeek.equals("+") || operatorAtPeek.equals("-")) {
			if (current.equals("+") || current.equals("-")) {
				return 1;
			}
		} else if (operatorAtPeek.equals("*") || operatorAtPeek.equals("/")) {
			if (current.equals("+") || current.equals("-")) {
				return 2;
			} else if (current.equals("*") || current.equals("/")) {
				return 1;
			}
		}
		return 0;

	}

	private static String solveArithemetic(String operator, String operand1,
			String operand2) {

		if (!operand1.equals("true") && !operand1.equals("false")
				&& !operand2.equals("true") && !operand2.equals("false")) {
			int op1 = Integer.parseInt(operand1);
			int op2 = Integer.parseInt(operand2);

			if (operator.equals("+")) {
				return String.valueOf(op1 + op2);
			} else if (operator.equals("-")) {
				return String.valueOf(op1 - op2);
			} else if (operator.equals("*")) {
				return String.valueOf(op1 * op2);
			} else
				return String.valueOf(op1 / op2);
		} else {
			throw new UnsupportedOperationException();
		}

	}

	private static int booleanPrecedence(String op1, String operator) {
		if (operator.equals("!")) {
			return 2;
		} else if (op1.equals("<") || op1.equals(">") || op1.equals(">=")
				|| op1.equals("<=")) {
			if (operator.equals("==") || operator.equals("!=")
					|| operator.equals("&&") || operator.equals("||")
					|| operator.equals("=")) {
				return 2;
			} else if (operator.equals("<") || operator.equals(">")
					|| operator.equals(">=") || operator.equals("<=")) {
				return 1;
			}
		} else if (op1.equals("==") || op1.equals("!=")) {
			if (operator.equals("&&") || operator.equals("||")
					|| operator.equals("=")) {
				return 2;
			} else if (operator.equals("==") || operator.equals("!=")) {
				return 1;
			}
		} else if (op1.equals("&&") || op1.equals("||")) {
			if (operator.equals("=")) {
				return 2;
			} else if (operator.equals("&&") || operator.equals("||"))
				return 1;
		} else if (op1.equals("=")) {
			if (operator.equals("=")) {
				return 1;
			}
		}

		return 0;
	}

	private static String solveBoolean(String operator, String operand1,
			String operand2) throws Exception {
		int op1 = 0, op2 = 0;
		boolean opB1, opB2;
		if (operand1.equals("true") || operand1.equals("false")
				&& operand2.equals("true") || operand2.equals("false")) {

			if (operand1.equals("true"))
				opB1 = true;
			else
				opB1 = false;

			if (operand2.equals("true"))
				opB2 = true;
			else
				opB2 = false;

			if (operator.equals("||"))
				return String.valueOf(opB1 || opB2);
			else if (operator.equals("&&"))
				return String.valueOf(opB1 && opB2);
		} 
		else {

			op1 = Integer.parseInt(operand1);
			op2 = Integer.parseInt(operand2);

			if (operator.equals("<"))
				return String.valueOf(op1 < op2);

			else if (operator.equals(">"))
				return String.valueOf(op1 > op2);

			else if (operator.equals("="))
				return String.valueOf(op1 = op2);

			else if (operator.equals("<="))
				return String.valueOf(op1 <= op2);

			else if (operator.equals(">="))
				return String.valueOf(op1 >= op2);

			else if (operator.equals("!="))
				return String.valueOf(op1 != op2);

			else if (operator.equals("=="))
				return String.valueOf(op1 == op2);

			else
				throw new UnsupportedOperationException();
		}
		throw new UnsupportedOperationException();
	}

	public static String evalute(String infixExp) throws Exception {

		int length = infixExp.length();

		InfixEvaluation operatorStack = new InfixEvaluation(length);
		InfixEvaluation operandStack = new InfixEvaluation(length);

		int index = 0;

		while (index < length) {

			String token = "";

			while (index < length && infixExp.charAt(index) != ' ') {
				token += infixExp.charAt(index++);
			}

			if (isBooleanOperator(token)) {
				while (operatorStack.size > 0) {
					if (isArithmeticOperator(operatorStack.peek())
							|| booleanPrecedence(operatorStack.peek(), token) > 0) {
						String operand1 = operandStack.pop();
						String operand2 = operandStack.pop();
						String operator = operatorStack.pop();
						String ans;

						if (isBooleanOperator(operator))
							ans = solveBoolean(operator, operand2, operand1);
						else
							ans = solveArithemetic(operator, operand2, operand1);

						operandStack.push(ans);

					} else {
						break;
					}
				}
				operatorStack.push(token);
			} else if (isArithmeticOperator(token)) {
				while (operatorStack.size > 0) {
					if (!isBooleanOperator(operatorStack.peek())
							&& arithmeticPrecedence(operatorStack.peek(), token) > 0) {
						String operand1 = operandStack.pop();
						String operand2 = operandStack.pop();
						String operator = operatorStack.pop();
						String ans = solveArithemetic(operator, operand2,
								operand1);

						operandStack.push(ans);

					} else {
						break;
					}
				}
				operatorStack.push(token);

			} else if (isConstant(token)) {

				operandStack.push(token);

			} else if (token.charAt(0) == '(') {

				operatorStack.push(token);

			} else if (token.charAt(0) == ')') {

				while (operandStack.size > 0
						&& operatorStack.peek().charAt(0) != '(') {

					String operator = operatorStack.pop();
					String operand1 = operandStack.pop();
					String operand2 = operandStack.pop();
					if (isArithmeticOperator(operator)) {
						String ans = solveArithemetic(operator, operand2,
								operand1);

						operandStack.push(ans);
					} else if (isBooleanOperator(operator)) {
						String ans = solveBoolean(operator, operand2, operand1);

						operandStack.push(ans);
					}
				}

				operatorStack.pop();

			} else {
				throw new UnsupportedOperationException();
			}

			index++;
		}
		while (operatorStack.size > 0) {

			String operator = operatorStack.pop();
			String operand1 = operandStack.pop();
			String operand2 = operandStack.pop();
			if (isArithmeticOperator(operator)) {
				String ans = solveArithemetic(operator, operand2, operand1);

				operandStack.push(ans);
			} else if (isBooleanOperator(operator)) {
				String ans = solveBoolean(operator, operand2, operand1);

				operandStack.push(ans);
			}
		}
		return operandStack.pop();
	}

}
