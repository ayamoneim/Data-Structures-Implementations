
public class PolyNode {
	private int exp;
	private int coeff;
	public PolyNode next;
	public PolyNode(int coefficient , int exponent)
	{
		this.setCoeff(coefficient);
		this.setExp(exponent);
	}
	public PolyNode getNext() {
		return next;
	}
	public void setNext(PolyNode next) {
		this.next = next;
	}
	public int getCoeff() {
		return coeff;
	}
	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}

	
}
