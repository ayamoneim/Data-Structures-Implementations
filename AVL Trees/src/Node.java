
public class Node<Element extends Comparable<Element>> implements Comparable<Element> {

	private Node left;
	private Node right;
	private Element data;
	private int height;
	
	// Constructor
	
	
	public Node(Element e) {
		this.data = e;
		this.left = null;
		this.height = 0;
		this.right = null;
	}

	
	public Node(Element e,Node left ,Node right) {
		this.data = e;
		this.left = left;
		this.height = 0;
		this.right = right;
	}

	@Override
	public int compareTo(Element o) {
		return this.getData().compareTo(o);
	}


	public Node getLeft() {
		return left;
	}


	public void setLeft(Node left) {
		this.left = left;
	}


	public Node getRight() {
		return right;
	}


	public void setRight(Node right) {
		this.right = right;
	}


	public Element getData() {
		return data;
	}


	public void setData(Element data) {
		this.data = data;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}

	
	
}
