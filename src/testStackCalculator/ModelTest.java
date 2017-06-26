package testStackCalculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import calculator.Model;
import calculator.Operation;
import calculator.StackCalculator;

public class ModelTest {


	private Model TestClass;

	@Before
	public void setUp() throws Exception {
		TestClass = new Model();
	}

	@After
	public void tearDown() throws Exception {
		TestClass = null;
	}

	@Test
	public void testFirstExample() {
		System.out.println("First Example");
		TestClass.setEntry(23);
		TestClass.doOperation(Operation.BUTTON);
		TestClass.show();
		
		TestClass.doOperation(Operation.ENTER);
		TestClass.show();
		
		TestClass.setEntry(45);
		TestClass.doOperation(Operation.BUTTON);
		
		TestClass.doOperation(Operation.PLUS);
		TestClass.show();
		
		assertEquals("Expected value of 68", 68, TestClass.getValue(),1e-15);
	}
	
	@Test
	public void testSecondExample(){
		System.out.println("Examle Two");
		TestClass.setEntry(2);
		TestClass.doOperation(Operation.BUTTON);
		TestClass.show();
		TestClass.doOperation(Operation.ENTER);
		TestClass.show();
		TestClass.setEntry(3);
		TestClass.doOperation(Operation.BUTTON);
		TestClass.show();
		TestClass.doOperation(Operation.PLUS);
		TestClass.show();
		TestClass.doOperation(Operation.ENTER);
		TestClass.setEntry(4);
		TestClass.doOperation(Operation.BUTTON);
		TestClass.show();
		TestClass.doOperation(Operation.TIMES);
		TestClass.show();
		
		assertEquals("Expected value of 20", 20, TestClass.getValue(),1e-15);
		
	}
	
	@Test
	public void testThirdExample(){
		System.out.println("Third Example");
		TestClass.setEntry(2);
		TestClass.doOperation(Operation.BUTTON);
		TestClass.show();
		
		TestClass.doOperation(Operation.ENTER);
		TestClass.show();
		
		TestClass.setEntry(3);
		TestClass.doOperation(Operation.BUTTON);
		TestClass.show();
		
		TestClass.doOperation(Operation.ENTER);
		TestClass.show();
		
		TestClass.setEntry(4);
		TestClass.doOperation(Operation.BUTTON);
		TestClass.show();
		
		TestClass.doOperation(Operation.PLUS);
		TestClass.show();
		
		TestClass.doOperation(Operation.TIMES);
		TestClass.show();
		
		assertEquals("Expected value of 14", 14, TestClass.getValue(),1e-15);
	}
	
	@Test
	public void testFourthExample(){
		TestClass.setEntry(2);
		TestClass.doOperation(Operation.BUTTON);
		
		TestClass.doOperation(Operation.ENTER);
		TestClass.doOperation(Operation.ENTER);
		TestClass.doOperation(Operation.ENTER);
		
		TestClass.doOperation(Operation.PLUS);
		
		TestClass.show();
		
		TestClass.doOperation(Operation.PLUS);
		
		TestClass.show();
		
		TestClass.doOperation(Operation.PLUS);
		
		TestClass.show();
		
		assertEquals("Expected value of 8",8,TestClass.pop(),1e-15);
		assertEquals("Expected value of 8",2,TestClass.pop(),1e-15);
		assertEquals("Expected value of 8",2,TestClass.pop(),1e-15);
		assertEquals("Expected value of 8",2,TestClass.pop(),1e-15);
		
	}
	
	@Test
	public void testFifthExample(){
		TestClass.setEntry(2);
		TestClass.doOperation(Operation.BUTTON);
		
		TestClass.doOperation(Operation.ENTER);
		
		TestClass.setEntry(4);
		TestClass.doOperation(Operation.BUTTON);
		
		TestClass.doOperation(Operation.PLUS);
		
		TestClass.doOperation(Operation.ENTER);
		
		TestClass.setEntry(5);
		TestClass.doOperation(Operation.BUTTON);
		
		TestClass.doOperation(Operation.ENTER);
		TestClass.setEntry(3);
		TestClass.doOperation(Operation.BUTTON);
		TestClass.show();
		TestClass.doOperation(Operation.MINUS);
		TestClass.show();
		TestClass.doOperation(Operation.DIVIDES);
		
		assertEquals("Expected value of 3", 3, TestClass.getValue(),1e-15);
		
	}

}
