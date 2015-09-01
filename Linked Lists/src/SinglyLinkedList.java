
import java.util.*;

public class SinglyLinkedList implements MyLinkedList {
	private Node head;
	static int size;
	public SinglyLinkedList()
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
	         Node temp = head;
	         while(temp.getNext() != null) {
	        	 temp = temp.getNext();
	         }

	          temp.setNext(new Node(element, null));
	         size++;
	      }
	   }
	public void remove(int index)
	   {
	       int counter = 1;
	       Node temp = head;
	       Node temp2 = null;
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
		Node temp = head;
		int counter = 1;
		while(counter!=index)
		{
			temp = temp.getNext();
			counter++;
		}
		Node newNode = new Node(element,temp.getNext());
		temp.setNext(newNode);
		size++;
		
	}
	 public void clear()
     {
	     head = null;
	 }
	 public int size()
	 {
		Node temp = head;
		int counter = 0;
		while(temp.getNext()!=null)
		{
			temp = temp.getNext();
			counter++;
		}
		return counter;
	 }

	public Object get(int index) {
		Node temp = head;
		 int counter = 0;
		 while(counter!=index)
		 {
			 temp = temp.getNext();
			 counter++;
		 }
		 return temp.getElement();
	}
	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MyLinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean contains(Object o) {
		
		return false;
	}
	 
}