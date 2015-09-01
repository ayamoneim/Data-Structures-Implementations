
public class Node {
	private Object item;
	private Node next;
	
	public Node(Object item ,Node next)
	{
		this.setItem(item);
		this.setNext(next);
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}
}
