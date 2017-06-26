package calculator;


public class Model extends StackCalculator{
	Operation operation;
	private double entry;
	private boolean PushBool;
	
	public Model(){
		//get access to the Stack
		super();
		entry = 0;
	}
	
	/**
	 * Gets every item in the stack of the model and adds them to an array in FILO order.
	 * @return double[] of the stackElements in FILO order.
	 */
	public double[] getWholeStack(){
		double[] showStack = new double[4];
		
		double temp1 = this.pop();
		double temp2 = this.pop();
		double temp3 = this.pop();
		double temp4 = this.peek();
		
		showStack[0] = temp1;
		showStack[1] = temp2;
		showStack[2] = temp3;
		showStack[3] = temp4;

		this.push(temp3);
		this.push(temp2);
		this.push(temp1);
		
		return showStack;
		
		
	}
	
	
	/**
	 * Sets the current entry in the model. The entry variable is a holder for input into the model
	 * A getEntry method is provided to access this variable.
	 * @param entryIn int Value entered into the model.
	 */
	public void setEntry(int entryIn){
		this.entry = entryIn;
	}
	
	/**
	 * Get the current entry.
	 * @return double returns the entry. A setEntry method is provided to alter this variable
	 * from outside the class.
	 */
	private double getEntry(){
		return this.entry;
	}
	
	/**
	 * If the stack is assumed to be full that is this.size() == 3
	 * Then the bottom element is duplicated, as specified by instructions.
	 */
	private void duplicateBottom(){
		double temp1 = this.pop();
		double temp2 = this.pop();
		double temp3 = this.pop();
		
		this.push(temp3);
		this.push(temp3);
		this.push(temp2);
		this.push(temp1);
	}
	

	/**
	 * The doOperation method gives access to the operations of a calculator. 
	 * These are the operations specified by the Operations enumerator.
	 * They consist of
	 * BUTTON: Clears out the old value on the top of the stack and pushes entry onto it.
	 * PLUS: pops the top two values from the stack and adds them. If the size of the stack is 3.
	 * 		The bottom value is duplicated.
	 * MINUS: pops the top two values from the stack and subtracts them. If the size of the stack is 3.
	 * 		The bottom value is duplicated.
	 * TIMES: pops the top two values from the stack and multiplies them. If the size of the stack is 3.
	 * 		The bottom value is duplicated.
	 * DIVIDES: pops the top two values from the stack and divides them. If the size of the stack is 3.
	 * 		The bottom value is duplicated. Checks whether value in denominator is zero. If denominator is 
	 * 		zero, it pushes the non zero element back onto the stack.
	 * ENTER: Pushes a copy of the top value onto the stack
	 * CLEAR: Pops the top value of the stack.
	 * CHS: Multiplies top value of the stack and puts it back on top of the stack.
	 * CLEARSTACK: Empties the stack.
	 * @param operation The operation to perform, see description of method. 
	 */
	public void doOperation(Operation operation){
		switch (operation){
		case BUTTON:
			this.pop();
			this.push(getEntry());	
			break;
		case PLUS:
			this.push(this.pop() + this.pop());
			//size = 3 means that bottom element will be dublicated
			if(this.getSize() == 3){
				this.duplicateBottom();
			}
			
			break;
		case MINUS:
			//tempMinus helps control order of -, i.e first - second or vice versa.
			double tempMinus = this.pop();
			this.push(this.pop() - tempMinus);
			
			//size = 3 means that bottom element will be dublicated
			if(this.getSize() == 3){
				this.duplicateBottom();
			}
			
			break;
		case TIMES:
			this.push(this.pop() * this.pop());
			
			//size = 3 means that bottom element will be duplicated
			if(this.getSize() == 3){
				this.duplicateBottom();
			}
			
			break;
		case DIVIDES:
			double temp1 = this.pop();
			double temp2 = this.pop();
			if(temp2==0){
				this.push(temp1);
			}
			else{
				this.push(temp2/temp1);	
			}
			
			//size = 3 means that bottom element will be dublicated
			if(this.getSize() == 3){
				this.duplicateBottom();
			}
			break;
		case ENTER:
			this.push(this.peek());
			break;
		case CLEAR:
			this.pop();
			break;
		case CHS:
			this.push(-1*this.pop());
			break;
		case CLEARSTACK:
			this.pop();
			this.pop();
			this.pop();
			this.pop();	
		}
	}
	
	/**
	 * Returns the top value from the stack.
	 * @return double The top element of the calculator model.
	 */
	public double getValue(){
		return this.peek();
	}
	
	
}
