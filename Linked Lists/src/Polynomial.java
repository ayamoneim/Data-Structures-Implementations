
public class Polynomial {
	
	public PolyLinkedList list;
	public Polynomial()
    {
        list = new PolyLinkedList();
    }
	

	public void display() {
		if(list.isEmpty()){
			System.out.println("Polynomial is not set");
			return;
		}
		boolean flag = false;
		PolyNode temp = list.head;
		while(temp!=null)
		{
			if(flag && temp.getCoeff()>0)
				System.out.print(" + ");
			if(temp.getCoeff()!=0)
			{
				if(temp.getCoeff()>0 )
				{
					System.out.print(temp.getCoeff()+" ");
					
				}else if(temp.getCoeff() == -1)
				{
					System.out.print("- ");
				}
				if(temp.getExp()>1)
				{
					System.out.print("x^"+temp.getExp());
				}else if(temp.getExp() == 1)
				{
					System.out.print("x");
				}
				flag = true;
			}
			temp = temp.next;
		}
		System.out.println();
		
	}

	public void add(Polynomial a, Polynomial b) {
		PolyNode one = a.list.head;
		PolyNode two = b.list.head;
		while(one!=null || two!=null)
		{
			PolyNode t = null;
			if(one == null || one.getExp()<two.getExp())
			{
				t = new PolyNode(two.getCoeff(),two.getExp());
				two = two.next;
			}else if(two == null || one.getExp()>two.getExp())
			{
				t = new PolyNode(one.getCoeff(),one.getExp());
				one	= one.next;
			}else 
			{
				int co = one.getCoeff() + two.getCoeff();
				int ex = one.getExp();
				t = new PolyNode(co , ex);
				one = one.next;
				two = two.next;
			}
//			System.out.println(t.getCoeff());
//			System.out.println(t.getExp());
			list.insertLast(t.getCoeff() , t.getExp());
		}
		
	}

	public float eval(int input) {
		float sum = 0;
		PolyNode temp = list.head;
		while(temp!=null)
		{
			sum = temp.getCoeff() + (input*sum);
			temp = temp.next;
		}
		return sum;
		
	}
	public boolean isEmpty()
    {
		return list.head == null;
	}

	public void clear() {
		list.head = null;
		
	}
//not finished
	public void multiply(Polynomial a, Polynomial b) {
		PolyNode x = a.list.head;
		PolyNode y = b.list.head;
		PolyNode c = new PolyNode(0 , 0);
		while(x!=null)
		{
			PolyNode temp = new PolyNode(0 , 0) ;
			while(y!=null)
			{
				temp.setCoeff(x.getCoeff()*y.getCoeff());
				temp.setExp(x.getExp()+y.getExp());
				y = y.next;
			}
			x = x.next;
		}
	}

	public void subtract(Polynomial a, Polynomial b) {
		
		PolyNode one = a.list.head;
		PolyNode two = b.list.head;
		while(one!=null || two!=null)
		{
			PolyNode t = null;
			if(one == null || one.getExp()<two.getExp())
			{
				t = new PolyNode(two.getCoeff(),two.getExp());
				two = two.next;
			}else if(two == null || one.getExp()>two.getExp())
			{
				t = new PolyNode(one.getCoeff(),one.getExp());
				one	= one.next;
			}else 
			{
				int co = one.getCoeff() - two.getCoeff();
				int ex = one.getExp();
				t = new PolyNode(co , ex);
				one = one.next;
				two = two.next;
			}
			list.insertLast(t.getCoeff() , t.getExp());
		}
	}

	public void set(int co, int ex) {
		
			PolyNode temp = list.head;
			int index = 0;
			while(temp!=null)
			{
				if(temp.getExp()<ex)
				{
					break;
					
				}
				temp = temp.getNext();
				index++;
			}
			if(index == 0)
			{
				list.insertFirst(co , ex);
			}else
			{
				list.insertAt(index , co , ex);
			}
		
	}
	
}
