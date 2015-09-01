
public class DNode {
	 private Object element;
     private DNode next;
     private DNode prev;
     
     public DNode(Object element, DNode next,DNode prev)
     {
   	     this.element = element;
         this.next = next;
         this.prev = prev;
     }

	public DNode getNext() {
		return next;
	}

	public void setNext(DNode next) {
		this.next = next;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public DNode getPrev() {
		return prev;
	}

	public void setPrev(DNode prev) {
		this.prev = prev;
	}



	
}
