
public class DLinkedList {
	private DNode head;
	static int size;
	
	public DLinkedList()
	{
		head = null;
	}
	public boolean isEmpty()
    {
		return head == null;
	}
	public void add(Object element)
	   {
	      if( head == null)
	         add(element);
	      else
	      {
	         DNode temp = head;
	         while(temp.getNext() != null) {
	        	 temp = temp.getNext();
	         }

	          temp.setNext(new DNode(element, null));
	         size++;
	      }
	   }
	public void remove(int index)
	   {
	       int counter = 1;
	       DNode temp = head;
	       DNode temp2 = null;
	       while(counter!=index)
	       {
	    	   temp = temp.getNext();
	    	   counter++;
	       }
	       temp2 = temp.getNext().getNext();
	       temp = temp2;
	   }
	
	public void add(int index, Object element)
	{
		DNode temp = head;
		int counter = 1;
		while(counter!=index)
		{
			temp = temp.getNext();
			counter++;
		}
		DNode newNode = new DNode(element,temp.getNext());
		temp.setNext(newNode);
		size++;
		
	}
	 public void clear()
     {
	     head = null;
	 }
	 public int size()
	 {
		DNode temp = head;
		int counter = 0;
		while(temp.getNext()!=null)
		{
			temp = temp.getNext();
			counter++;
		}
		return counter;
	 }

	@Override
	public Object get(int index) {
		DNode temp = head;
		 int counter = 0;
		 while(counter!=index)
		 {
			 temp = temp.getNext();
			 counter++;
		 }
		 return temp.getElement();
	}
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		
	}
	public MyLinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean contains(Object o) {
		
		return false;
	}
	 
}

