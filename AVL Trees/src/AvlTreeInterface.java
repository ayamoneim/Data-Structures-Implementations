
public interface AvlTreeInterface<Element> {

	public void insert(Element e );
	
	public boolean lookUp(Element e);
	
	public Node delete(Element e);
	
	public int getTreeHeight();
	
}
