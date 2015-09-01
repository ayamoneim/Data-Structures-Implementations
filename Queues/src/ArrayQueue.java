import java.util.NoSuchElementException;


public class ArrayQueue implements MyQueue{

	private int size;
	private Object[]Q ;
	private int rear;
	
	public ArrayQueue()
	{
		this.size = 0;
		rear = 0;
		Q = new Object[1000];
	}

	public void enqueue(Object item) {
		if(rear == size)
		{
//			throw new IllegalStateException();
		}
		Q[rear] = item;
		if(rear == size-1)
			rear = 0;
		else
			rear++;
		size++;
	}

	public Object dequeue() throws  NoSuchElementException{
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		Object temp = Q[0];
		int i;
		for(i=0 ; i<size-1;i++)
		{
			Q[i] = Q[i+1];
		}
		rear--;
		size--;
		return temp;
	}

	public boolean isEmpty() {
		
		return (size==0);
	}

	
	public int size() {
		return size;
	}

}
