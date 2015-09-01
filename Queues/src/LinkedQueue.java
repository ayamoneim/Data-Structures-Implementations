import java.util.NoSuchElementException;


public class LinkedQueue implements MyQueue{
	
	private Node rear;
	private Node front;
	private int size ;
	
	public LinkedQueue()
	{
		this.setSize(0);
		this.rear = null;
		this.front = null;
	}
	
	public void enqueue(Object item) {
		Node temp = new Node(item ,null);
		if(rear ==null)
		{
			rear = temp;
			front = temp;
		}else
		{
			rear.setNext(temp);
			rear = rear.getNext();
		}
		setSize(getSize() + 1);
		
	}

	
	public Object dequeue()throws  NoSuchElementException {
		if(isEmpty())
			throw new NoSuchElementException();
		Object temp =front.getElement();
		front = front.getNext();
		if(front == null)
			rear=null;
		size--;
		return temp;
	}

	public boolean isEmpty() {
		return (getSize()==0);
	}

	public int size() {
		return getSize();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
