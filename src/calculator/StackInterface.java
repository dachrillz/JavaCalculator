package calculator;

public interface StackInterface {
	/**
	 * Checks whetherthe stack is empty or not.
	 * @return boolean if Stack is empty return true, otherwise return false
	 */
	boolean empty();
	
	/**
	 * Look at the top Object of the stack and then put it back.
	 * @return double Top item of the stack.
	 */
	double peek();
	
	/**
	 * Look at the top Object of the stack and then return it. Removes the top item from
	 * the stack.
	 * @return double Top item of the stack.
	 */
	double pop();
	
	/**
	 * Puts item of top of stack. Returns true if successful, otherwise false.
	 * @param: double: item The item to be added.
	 * @return boolean True if successful, false if item failed to be added.
	 */
	boolean push(double item);
	
	/**
	 * Prints the stack, with a pointer to where current top object is.
	 */
	void show();
}
