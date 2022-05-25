
import java.lang.IndexOutOfBoundsException;
import java.util.ArrayList;

public class MyStringStack {
	private ArrayList<String> v = new ArrayList<String> ();
	
	public void push(String newElement){
		if (newElement != null) 
			v.add(newElement);	
	}	
	
	public String pop() throws IndexOutOfBoundsException {
		if (v.isEmpty()) 
			throw new IndexOutOfBoundsException();
		
		String result = v.get(v.size()-1);
		v.remove(result);
		return result;
	}
	
	public boolean isEmpty(){
		return v.isEmpty();		
	}
	
	public void clear(){
		v = new ArrayList<String> ();		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "World!";
		String s2 = "Hello";
		MyStringStack stack = new MyStringStack();
		System.out.println(stack.isEmpty());
		stack.push(s1);
		stack.push(s2);
		
		System.out.println(stack.pop() + " "+ stack.pop());

	}

}
