import java.util.EmptyStackException;


public class MyStack implements MyLinkedList {
	
	private Node stack;
	private int size;
	
	public MyStack()
	{
		stack = null;
		size = 0;
	}
	
	public Object pop() throws EmptyStackException{
		
		if (isEmpty())
			throw new EmptyStackException();
		
		Object x = stack.getItem();
		stack = stack.getNext();
		size--;
		return x;
	}

	
	public Object peek() throws EmptyStackException{
		
		if (isEmpty())
			throw new EmptyStackException();
		
		return stack.getItem();
	}

	
	public void push(Object element) {
		
		Node newNode = new Node(element,stack);
		stack = newNode;
		size++;
		
	}//we add items at head 

	
	public boolean isEmpty() {
		
		return ( size==0 );
	}

	
	public int size() {
		
		return size;
	}
	
}