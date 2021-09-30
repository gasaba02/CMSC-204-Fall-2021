package application;

/**
 * This class converts from infix to postfix, from postfix 
 * to infix and evaluates a postfix expression.
 * @author Germain Asaba
 *
 */
public class Notation {

	/**
	 * Default constructor
	 */
	public Notation() {

	}

	/**
	 * This method checks with operator has high precedence
	 * @param ch the operator to be checked
	 * @return returns which operator is of higher precedence
	 */
	static int charPrecedence(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 0;

		case '*':
		case '/':
			return 1;

		}
		return -1;
	}


	/**
	 * This methods converts an infix expression to a postfix expression
	 * @param infix the infix expression
	 * @return returns the postfix expression in a string format
	 * @throws InvalidNotationFormatException throws an exception if the 
	 * postfix format is invalid
	 */
	public static String convertInfixToPostfix(String infix)
			throws InvalidNotationFormatException{

		NotationQueue<Character> solution = new NotationQueue<>();
		NotationStack<Character> operators = new NotationStack<>();

		// traverse the infix expression
		for(int i = 0; i < infix.length(); i++ ) {
			char myChar = infix.charAt(i);

			//ignore space
			if(myChar != ' ') {

				//if the current character is a digit add it to post fix expression
				if(Character.isDigit(myChar)) {
					try {
						solution.enqueue(myChar);
					} catch (QueueOverflowException e) {

						e.printStackTrace();
					}
				}

				//if the character is '(' add it to the stack
				else if(myChar == '(') {
					try {
						operators.push(myChar);
					} catch (StackOverflowException e) {

						e.printStackTrace();
					}
				}

				// if the character is ')' pop everything in the stack till ')' 
				//and add to postfix expression
				else if(myChar == ')') {
					try {
						while(!operators.isEmpty() && operators.top() != '(' ) {
							solution.enqueue(operators.pop());

						}
						if(operators.isEmpty()) {
							throw new InvalidNotationFormatException();
						}
						else {
							operators.pop();
						}

					} catch (StackUnderflowException e) {

						e.printStackTrace();
					} catch (QueueOverflowException e) {

						e.printStackTrace();
					}
				}

				else if(myChar == '+' || myChar == '-' || myChar == '*' || myChar == '/') {
					try {
						while(!operators.isEmpty() && (charPrecedence(myChar) 
								<= charPrecedence(operators.top()))) {
							solution.enqueue(operators.pop());

						}
						operators.push(myChar);

					} catch (StackUnderflowException e) {

						e.printStackTrace();
					} catch (QueueOverflowException e) {

						e.printStackTrace();
					} catch (StackOverflowException e) {
						e.printStackTrace();
					}
				}


			}
		}


		while(!operators.isEmpty() ) {
			try {
				solution.enqueue(operators.pop());
			} catch (QueueOverflowException | StackUnderflowException e) {

				e.printStackTrace();
			}
		}

		return solution.toString();

	}



	/**
	 * This method converts a postfix expression to an infix expression
	 * @param postfix the postfix expression
	 * @return returns the infix expression
	 * @throws InvalidNotationFormatException throws an expression if 
	 * the postfix notation format is invalid
	 */
	public static String convertPostfixToInfix(String postfix)
			throws InvalidNotationFormatException{
		
		NotationStack<String> operators = new NotationStack<>();

		// traverse the infix expression
		for(int i = 0; i < postfix.length(); i++ ) {
			char myChar = postfix.charAt(i);

			//ignore space
			if(myChar != ' ') {
				if(Character.isDigit(myChar)) {

					try {
						operators.push(myChar+"");
					} catch (StackOverflowException e) {
						e.printStackTrace();
					}

				} 
				else if(myChar == '+' || myChar == '-' || myChar == '*' || myChar == '/') {
					if(operators.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					else {
						try {
							String char1 = operators.pop();
							String char2 = operators.pop();
							String str = "" + char2 + myChar + char1;
							String newStr = "(" + str + ")";
							operators.push(newStr);
						} catch (StackUnderflowException e) {
							e.printStackTrace();
						} catch (StackOverflowException e) {
							e.printStackTrace();
						}

					}

				}
			}
		}

		if(operators.size() > 1) {
			throw new InvalidNotationFormatException();
		}

		return operators.toString();
	}



	/**
	 * This method evaluates a postfix expression
	 * @param postfixExpr the postfix expression
	 * @return returns the evaluation of the postfix expression as a double
	 * @throws InvalidNotationFormatException throws an exception if the 
	 * postfix expression notation format is invalid
	 */
	public static double evaluatePostfixExpression(String postfixExpr)
			throws InvalidNotationFormatException{


		NotationStack<Long> operators = new NotationStack<>();
		long result = 0;

		// traverse the infix expression
		for(int i = 0; i < postfixExpr.length(); i++ ) {
			char myChar = postfixExpr.charAt(i);

			//ignore space
			if(myChar != ' ') {
				if(Character.isDigit(myChar) || myChar == '(') {

					try {
						operators.push(Long.parseLong(myChar+""));
					} catch (StackOverflowException e) {
						e.printStackTrace();
					}

				} 
				else if(myChar == '+' || myChar == '-' || myChar == '*' || myChar == '/') {
					if(operators.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					else {
						try {
							long char1 = operators.pop();
							long char2 = operators.pop();
							if (myChar == '*' ) {
								result = Math.multiplyExact(char1, char2);
							} else if (myChar == '+' ) {
								result = Math.addExact(char1, char2);
							} else if (myChar == '-' ) {
								result = Math.subtractExact(char2, char1);
							} else if (myChar == '/' ) {
								result = char2/char1;
							} 


							operators.push(result);
						} catch (StackUnderflowException e) {
							e.printStackTrace();
						} catch (StackOverflowException e) {
							e.printStackTrace();
						}

					}

				}
			}
		}

		if(operators.size() > 1) {
			throw new InvalidNotationFormatException();
		}

		return Double.parseDouble(operators.toString());

	}






}
