import java.util.EmptyStackException;


public class TestMyStack {
	
	public static void main(String[] args)
	{
		MyStack x = new MyStack();
		//x.pop();
		x.push(1);
		x.push(2);
		x.push(0);
		x.push(3);
		x.push(-10);
		x.push(1000);
		x.push(11);
		x.push(12);
		x.push(90);
		x.push(30);
		x.push(-19);
		x.push(15);
		
		while(!x.isEmpty())
		{
			System.out.println("	Size was " + x.size());
			System.out.println("	Element on top" +x.peek());
			System.out.println("	Element popped" + x.pop());
			System.out.println("	Size became = "+ x.size());
			System.out.println("	----------------------");
		}
		try{
		x.pop();
		}catch(EmptyStackException e)
		{
			System.out.println("Empty");
		}
	}
	
}
