package testStackCalculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import calculator.StackCalculator;

public class StackCalculatorTest {



	private StackCalculator TestClass;

	@Before
	public void setUp() throws Exception {
		TestClass = new StackCalculator();
	}

	@After
	public void tearDown() throws Exception {
		TestClass = null;
	}
	
	@Test
	public void testPeekPopPeek(){
		TestClass.push(10);
		assertEquals("Expected peek of 10", 10, TestClass.peek(),0.1);
		assertEquals("Expected pop of 10", 10, TestClass.pop(),0.1);
		assertEquals("Expected peek of 0", 0, TestClass.peek(),0.1);
		
		
	}
	
	@Test
	public void testPeekandPopEmpty(){
		assertEquals("Expected peek of 0", 0, TestClass.peek(),0.1);
		assertEquals("Expected pop of 0", 0, TestClass.pop(),0.1);
	}
	
	@Test
	public void testPushAndPop(){
		TestClass.push(4);
		TestClass.push(3);
		TestClass.push(2);
		TestClass.push(1);
		
		assertEquals("Expected pop of 1", 1, TestClass.pop(),0.1);
		assertEquals("Expected pop of 2", 2, TestClass.pop(),0.1);
		assertEquals("Expected pop of 3", 3, TestClass.pop(),0.1);
		assertEquals("Expected pop of 4", 4, TestClass.pop(),0.1);
	}
	
	@Test
	public void testPushFive(){
		TestClass.push(5);
		TestClass.push(4);
		TestClass.push(3);
		TestClass.push(2);
		TestClass.push(1);
		
		assertEquals("Expected pop of 1", 1, TestClass.pop(),0.1);
		assertEquals("Expected pop of 2", 2, TestClass.pop(),0.1);
		assertEquals("Expected pop of 3", 3, TestClass.pop(),0.1);
		assertEquals("Expected pop of 4", 4, TestClass.pop(),0.1);
	}
	
	@Test
	public void testPopFive(){
		TestClass.push(5);
		TestClass.push(4);
		TestClass.push(3);
		TestClass.push(2);
		TestClass.push(1);
		
		assertEquals("Expected popof 1", 1, TestClass.pop(),0.1);
		assertEquals("Expected popof 2", 2, TestClass.pop(),0.1);
		assertEquals("Expected popof 3", 3, TestClass.pop(),0.1);
		assertEquals("Expected popof 4", 4, TestClass.pop(),0.1);
		
		//Should be zero
		assertEquals("Expected popof 0", 0, TestClass.pop(),0.1);
	}
	
	@Test
	public void testPeekFive(){
		TestClass.push(5);
		TestClass.push(4);
		TestClass.push(3);
		TestClass.push(2);
		TestClass.push(1);
		
		assertEquals("Expected peek of 1", 1, TestClass.peek(),0.1);
	}
	
	@Test
	public void testkWeirdIfManyPush(){
		for(int i = 0; i < 1001; i++){
			TestClass.push(i);	
		}
		
		assertEquals("Expected peek of 1000",1000,TestClass.peek(),0.1);
		
		assertEquals("Expected pop of 1000",1000,TestClass.pop(),0.1);
		assertEquals("Expected pop of 999",999,TestClass.pop(),0.1);
		assertEquals("Expected pop of 998",998,TestClass.pop(),0.1);
		assertEquals("Expected pop of 997",997,TestClass.pop(),0.1);
		
		//test peek and pop of empty
		assertEquals("Expected peek of 0", 0, TestClass.peek(),0.1);
		assertEquals("Expected pop of 0", 0, TestClass.pop(),0.1);
		
		TestClass.show();
	}

	@Test
	public void test() {
		TestClass.push(10);
		TestClass.push(5);
		TestClass.push(4);
		TestClass.push(6);
		TestClass.push(7);
		TestClass.show();
	}

}
