import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyStringStackTest {

	private String s1,s2;
	private MyStringStack stack;
	
	@Before
	public void setUp() throws Exception{
		//HL: Setup the test data s1 and s2 & stack - Run before each test method
		s1 = "Hello";
		s2 = "World!";
		stack = new MyStringStack();		
	}
	
	@Test
	public void testPush(){
		//Empty stack is still empty after pushing a null element 
		assertTrue(stack.isEmpty());
		String o1 = null;
		stack.push(o1);
		assertTrue(stack.isEmpty());
		
		//New stack is empty, after pushing an s1 element, stack is no longer empty
		assertTrue(stack.isEmpty());
		stack.push(s1);
		assertFalse(stack.isEmpty());
		
		//HL Demo: After pushing an element s2, pop will retrieve s2
		//pop() must be implemented for this to work
		//stack.push(s2);
		//String o2 = Null;
		//o2 = stack.pop();
		//assertSame (s2,o2);
		
	}
	
	@Test
	public void testPop(){
		//HL: Popping from empty stack must generate exception
		String o1 = null;
		assertTrue("Initial Stack state: ",stack.isEmpty());
		try {
			o1= stack.pop();
			fail();			
		}catch (IndexOutOfBoundsException e) {}		
		
		//HL: Pushed an element, stack is not empty, popping does not cause exception
		stack.push(s1);
		assertFalse("Stack should not be empty after push", stack.isEmpty());
		try {
			o1= stack.pop();			
		}catch (IndexOutOfBoundsException e) {
			fail();
		}
		//HL: Popped element is the same as last pushed element
		assertSame (s1,o1);
		assertTrue(stack.isEmpty());
	}	
	
	@Test
	public void testIsEmpty(){
		//HL: New stack is empty; Pushed an element; stack is not empty
		String s3 = null;
		assertTrue(stack.isEmpty());
		stack.push(s1);
		assertFalse(stack.isEmpty());
		
		//HL: pop last pushed element from stack; stack becomes empty;
		try{
			s3 = stack.pop();
		}catch (IndexOutOfBoundsException e){
			fail();
		}
		assertSame(s1, s3);
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testClear(){
		//HL: New stack is empty; push 2 elements; stack not empty
		String o1 = null;		
		assertTrue("stack should be empty", stack.isEmpty());
		stack.push(s1);
		stack.push(s2);
		assertFalse("stack should not be empty",stack.isEmpty());
		//HL: Clear the stack; stack is empty
		stack.clear();
		assertTrue(stack.isEmpty());
		try{
			o1= stack.pop();
			fail();			
		} catch(IndexOutOfBoundsException e){}
	}
	
	@Test
	public void testStackNull(){
		String o1 = null;	
		assertTrue(stack.isEmpty());
		stack.push(o1);
		assertTrue(stack.isEmpty());
		stack.push(null);
		stack.push(s1);
		stack.push(null);		
		try{
			o1= stack.pop();
			assertSame(o1,s1);
			
		} catch(IndexOutOfBoundsException e){
			fail();
		}
		assertTrue(stack.isEmpty());	
		try{
			o1= stack.pop();
			fail();
			
		} catch(IndexOutOfBoundsException e){

		}
	}

	
	@Test
	public void testStackSequence(){
		String o1 = null;

		assertTrue(stack.isEmpty());
		stack.push(s1);
		try{
			o1= stack.pop();
			assertSame(o1,s1);
			
		} catch(IndexOutOfBoundsException e){
			fail();
		}
		stack.push(s1);
		stack.push(s2);
		try{
			o1= stack.pop();
			assertSame(o1, s2);
			o1= stack.pop();
			assertSame(o1, s1);
			
		} catch(IndexOutOfBoundsException e){
			fail();
		}
		assertTrue(stack.isEmpty());
	}
	

	@After
	public void tearDown() throws Exception {
	}


}
