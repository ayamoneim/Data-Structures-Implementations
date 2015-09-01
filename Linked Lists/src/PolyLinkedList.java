
public class PolyLinkedList {
	
	public PolyNode head;
	public PolyLinkedList()
	{
		head = null;
		
	}
	


	public void insertFirst(int co, int ex) {
		PolyNode temp = new PolyNode(co,ex);
		temp.next = head;
		head = temp;
		
	}

	public void insertAt(int index , int co , int ex) {
		
		PolyNode newNode = new PolyNode(co , ex);
		PolyNode now = head;
		index--;
		while(index!=0)
		{
			now = now.getNext();
			index--;
		}
		newNode.next = now.next;
		now.next = newNode;
	}


	public void insertLast(int coeff, int exp) {
		if( head == null)
	         insertFirst(coeff , exp);
	      else
	      {
	         PolyNode temp = head;
	         while(temp.next != null) temp = temp.next;

	         temp.next = new PolyNode(coeff , exp);
	      }
	}

	public boolean isEmpty()
    {
		return head == null;
	}
	
}
