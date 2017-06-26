package calculator;

public class StackCalculator implements StackInterface{
	protected double[] StackArray;
	private int pointer;
	protected int size;

	//Constructor
	public StackCalculator(){
		StackArray = new double[4];
		pointer = 0; //we use this to keep track of last added element
	}
	
	/**
	 * Returns the current size of the stack, that is number of elements added to it.
	 * @return int Elements in the stack. 
	 */
	public int getSize(){
		return this.size;
	}
	

	@Override
	public boolean empty() {
		if(this.size == 0){
			return true;
		}
		return false;
	}

	@Override
	public double peek() {
		// TODO Auto-generated method stub
		try{
			return StackArray[pointer];
		}
		catch(IndexOutOfBoundsException e){
			System.err.println("IndexOutOfBoundsException: The Stack is empty." + e.getMessage());
			return 0;
		}
	}

	@Override
	public double pop() {
		// TODO Auto-generated method stub
		try{
			double returnValue = StackArray[pointer];
			if(returnValue!=0){
				StackArray[pointer]=0;
				pointer=(pointer+1)%4;
				size--;
			}
			return returnValue;
		}
		catch(IndexOutOfBoundsException e){
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
			return 0;
		}
	}

	@Override
	public boolean push(double item) {
		if(pointer <= 0){
			pointer+=3;
		}
		else{
			pointer=(pointer-1)%3;
		}
		StackArray[pointer] = item;
		if(item!=0){
			size++;
		}
		return true;
		
	}


	@Override
	public void show() {
		System.out.println("The Stack");
		for(int i = 0; i < 4; i++){
			if(i == pointer){
				System.out.println(StackArray[i] + " <-");
			}
			else{
				System.out.println(StackArray[i]);
			}
		}
		
	}
	
	
	

}
