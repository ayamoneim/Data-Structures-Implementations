import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Application {
	static Polynomial A = new Polynomial();
	static Polynomial B = new Polynomial();
	static Polynomial C = new Polynomial();
	static Polynomial R = new Polynomial();
	public static void main(String[] args)
	{
		
		boolean go = true ;
		while(go)
		{
			int choice = menu();
			
		switch(choice)
		{
		case 1 :
		{
			setPolynomials();
			break;	
		}
		case 2 :
		{
			printPolynomials();
			break;	
		}
		case 3 :
		{
			addPolynomials();
			break;	
		}
		case 4 :
		{
			subtractPolynomials();
			break;	
		}
		case 5 :
		{
			multiplyPolinomials();
			break;	
		}
		case 6 :
		{
			evalPolynomial();
			break;
			
		}
		case 7 :
		{
			delPolynomial();
			break;	
		}
		}
		System.out.println("Continue ? (Y/N)");
		Scanner in = new Scanner(System.in);
		String line ;
		line = in.nextLine();
		if(line.matches("Y"))
		{
			go = true;
		}else
		{
//			System.out.println("End");
			go = false;
		}
		
	}
	
}
private static void delPolynomial() {
	System.out.println("Insert the variable name: A, B or C");
	Scanner in = new Scanner(System.in);
	String ch;
	ch = in.next();
	char x = ch.charAt(0);
	if(x == 'A')
	{
		if(A.isEmpty())
			System.out.println("Polynomial A is not set");
		else{
			A.clear();
			System.out.println("Polynomial A is Deleted");
		}
	}else if(x == 'B')
	{
		if(B.isEmpty())
			System.out.println("Polynomial B is not set");
		else{
			B.clear();
			System.out.println("Polynomial B is Deleted");
		}
	}else
	{
		if(C.isEmpty())
			System.out.println("Polynomial C is not set");
		else{
			C.clear();
			System.out.println("Polynomial C is Deleted");
		}
	}
		
	}
private static void evalPolynomial() {
	Scanner in;
	boolean flag = true;
	char x;
	do{
	System.out.println("Insert the variable name: A, B or C");
	in = new Scanner(System.in);
	String ch;
	ch = in.next();
	x = ch.charAt(0);
	if(x == 'A')
	{
		flag = A.isEmpty();
	}else if(x == 'B')
	{
		flag = B.isEmpty();
	}else
	{
		flag = C.isEmpty();
	}
	if(flag && (A.isEmpty() || (B.isEmpty()) || (C.isEmpty()))){
		System.out.println("Polynomial is not set");
	}else if(flag && !(A.isEmpty() || (B.isEmpty()) || (C.isEmpty())))
	{
		System.out.println("NO Polynomial is not set");
		return;
	}
	}while(flag);
	System.out.println("Enter value of X");
	Scanner in15 = new Scanner(System.in);
	int input = 0;
	input = in15.nextInt();
	if(x == 'A')
	{
		float out = A.eval(input);
		System.out.println(out);
	}else if(x == 'B')
	{
		B.eval(input);
	}else
	{
		C.eval(input);
	}	
	}
private static void multiplyPolinomials() {
	System.out.println("1.Set two new Polynomials ");
	System.out.println("2.Multiply Existing Polynolmials");
	int choice ;
	Scanner in;
	String x;
	char ch1 = 0,ch2 = 0;
	in = new Scanner(System.in);
	choice = in.nextInt();
	if(choice == 1)
	{
		System.out.println("Set First Polynomial");
		setPolynomials();
		System.out.println("Set Second Polynomial");
		setPolynomials();
	}else if(choice == 2)
	{
		boolean flag;
		do{
			System.out.println("Choose A or B or C");
			in = new Scanner(System.in);    
			x = in.next();
			ch1 = x.charAt(0);
			if(ch1 == 'A')
			{
				flag = A.isEmpty();
			}else if(ch1 == 'B')
			{
				flag = B.isEmpty();
			}else
			{
				flag = C.isEmpty();
			}
			if(flag)
				System.out.println("Polynomial is not set");
			}while(flag);
			System.out.println("Enter Number Of Terms In Polynomial");
			in = new Scanner(System.in);
			int n;
			n = in.nextInt();
			while(n!=0)
			{
				int ex,co;
				System.out.println("Enter Coefficient");
				in = new Scanner(System.in);
				co = in.nextInt();
				System.out.println("Enter Exponent");
				in = new Scanner(System.in);
				ex = in.nextInt();
				if(ch1 == 'A')
				{
					A.set(co,ex);
				}else if(ch1 == 'B')
				{
					B.set(co,ex);
				}else
				{
					C.set(co,ex);
				}
				n--;
			}
			flag = false;
			do{
				System.out.println("Choose A or B or C");
				in = new Scanner(System.in);    
				x = in.next();
				ch2 = x.charAt(0);
				if(ch2 == 'A')
				{
					flag = A.isEmpty();
				}else if(ch2 == 'B')
				{
					flag = B.isEmpty();
				}else
				{
					flag = C.isEmpty();
				}
				if(flag)
					System.out.println("Polynomial is not set");
				}while(flag);
				System.out.println("Enter Number Of Terms In Polynomial");
				in = new Scanner(System.in);
				n = in.nextInt();
				while(n!=0)
				{
					int ex,co;
					System.out.println("Enter Coefficient");
					in = new Scanner(System.in);
					co = in.nextInt();
					System.out.println("Enter Exponent");
					in = new Scanner(System.in);
					ex = in.nextInt();
					if(ch2 == 'A')
					{
						A.set(co,ex);
					}else if(ch2 == 'B')
					{
						B.set(co,ex);
					}else
					{
						C.set(co,ex);
					}
					n--;
				}
		
	}
	if(ch1 == 'A' && ch2 == 'B')
	{
		R.multiply(A,B);
	}else if(ch1 == 'A' && ch2 == 'C')
	{
		R.multiply(A,C);
	}else if(ch1 == 'B' && ch2 == 'A')
	{
		R.multiply(B,A);
	}else if(ch1 == 'B' && ch2 == 'C')
	{
		R.multiply(B,C);
	}else if(ch1 == 'C' && ch2 == 'A')
	{
		R.multiply(C,A);
	}else if(ch1 == 'C' && ch2 == 'B')
	{
		R.multiply(C,B);
	}
	
	System.out.println("The Result");
	R.display();
		
	}
// handle polynomials being set or not 
	private static void subtractPolynomials() {
		System.out.println("1.Set two new Polynomials ");
		System.out.println("2.Subtract Existing Polynolmials");
		int choice ;
		Scanner in;
		String x;
		char ch1 = 0,ch2 = 0;
		in = new Scanner(System.in);
		choice = in.nextInt();
		if(choice == 1)
		{
			System.out.println("Set First Polynomial");
			setPolynomials();
			System.out.println("Set Second Polynomial");
			setPolynomials();
		}else if(choice == 2)
		{
			boolean flag;
			do{
				System.out.println("Choose A or B or C");
				in = new Scanner(System.in);    
				x = in.next();
				ch1 = x.charAt(0);
				if(ch1 == 'A')
				{
					flag = A.isEmpty();
				}else if(ch1 == 'B')
				{
					flag = B.isEmpty();
				}else
				{
					flag = C.isEmpty();
				}
				if(flag)
					System.out.println("Polynomial is not set");
				}while(flag);
				System.out.println("Enter Number Of Terms In Polynomial");
				in = new Scanner(System.in);
				int n;
				n = in.nextInt();
				while(n!=0)
				{
					int ex,co;
					System.out.println("Enter Coefficient");
					in = new Scanner(System.in);
					co = in.nextInt();
					System.out.println("Enter Exponent");
					in = new Scanner(System.in);
					ex = in.nextInt();
					if(ch1 == 'A')
					{
						A.set(co,ex);
					}else if(ch1 == 'B')
					{
						B.set(co,ex);
					}else
					{
						C.set(co,ex);
					}
					n--;
				}
				flag = false;
				do{
					System.out.println("Choose A or B or C");
					in = new Scanner(System.in);    
					x = in.next();
					ch2 = x.charAt(0);
					if(ch2 == 'A')
					{
						flag = A.isEmpty();
					}else if(ch2 == 'B')
					{
						flag = B.isEmpty();
					}else
					{
						flag = C.isEmpty();
					}
					if(flag)
						System.out.println("Polynomial is not set");
					}while(flag);
					System.out.println("Enter Number Of Terms In Polynomial");
					in = new Scanner(System.in);
					n = in.nextInt();
					while(n!=0)
					{
						int ex,co;
						System.out.println("Enter Coefficient");
						in = new Scanner(System.in);
						co = in.nextInt();
						System.out.println("Enter Exponent");
						in = new Scanner(System.in);
						ex = in.nextInt();
						if(ch2 == 'A')
						{
							A.set(co,ex);
						}else if(ch2 == 'B')
						{
							B.set(co,ex);
						}else
						{
							C.set(co,ex);
						}
						n--;
					}
			
		}
		if(ch1 == 'A' && ch2 == 'B')
		{
			R.subtract(A,B);
		}else if(ch1 == 'A' && ch2 == 'C')
		{
			R.subtract(A,C);
		}else if(ch1 == 'B' && ch2 == 'A')
		{
			R.subtract(B,A);
		}else if(ch1 == 'B' && ch2 == 'C')
		{
			R.subtract(B,C);
		}else if(ch1 == 'C' && ch2 == 'A')
		{
			R.subtract(C,A);
		}else if(ch1 == 'C' && ch2 == 'B')
		{
			R.subtract(C,B);
		}
		
		System.out.println("The Result");
		R.display();
		
	}

	private static void printPolynomials() {
		Scanner in;
		boolean flag = true;
		char x;
		do{
		System.out.println("Insert the variable name: A, B or C");
		in = new Scanner(System.in);
		String ch;
		ch = in.next();
		x = ch.charAt(0);
		if(x == 'A')
		{
			flag = A.isEmpty();
		}else if(x == 'B')
		{
			flag = B.isEmpty();
		}else
		{
			flag = C.isEmpty();
		}
		if(flag && (A.isEmpty() || (B.isEmpty()) || (C.isEmpty()))){
			System.out.println("Polynomial is not set");
		}else if(flag && !(A.isEmpty() || (B.isEmpty()) || (C.isEmpty())))
		{
			System.out.println("NO Polynomial is not set");
			return;
		}
		}while(flag);
		if(x == 'A')
		{
			A.display();
		}else if(x == 'B')
		{
			B.display();
		}else
		{
			C.display();
		}
		
	}

	private static void setPolynomials() {
		Scanner in;
		char x;
		boolean flag;
		do{
		System.out.println("Insert the variable name: A, B or C");
		in = new Scanner(System.in);    //why warning?
		String ch;
		ch = in.next();
		x = ch.charAt(0);
		if(x == 'A')
		{
			flag = A.isEmpty();
		}else if(x == 'B')
		{
			flag = B.isEmpty();
		}else
		{
			flag = C.isEmpty();
		}
		if(!flag)
			System.out.println("Polynomial is set");
		}while(!flag);
		System.out.println("Enter Number Of Terms In Polynomial");
		in = new Scanner(System.in);
		int n;
		n = in.nextInt();
		while(n!=0)
		{
			int ex,co;
			System.out.println("Enter Coefficient");
			in = new Scanner(System.in);
			co = in.nextInt();
			System.out.println("Enter Exponent");
			in = new Scanner(System.in);
			ex = in.nextInt();
			if(x == 'A')
			{
				A.set(co,ex);
			}else if(x == 'B')
			{
				B.set(co,ex);
			}else
			{
				C.set(co,ex);
			}
			n--;
		}
		
	}

	private static int menu() {
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1- Set a polynomial variable");
		System.out.println("2- Print the value of a polynomial variable");
		System.out.println("3- Add two polynomials");
		System.out.println("4- Subtract two polynomials");
		System.out.println("5- Multiply two polynomials");
		System.out.println("6- Evaluate a polynomial at some point");
		System.out.println("7- Clear a polynomial variable");	
		Scanner scan = new Scanner(System.in);
		int choice;
		choice = scan.nextInt();
		return choice;
		
	}

	private static void addPolynomials() {
		System.out.println("1.Set two new Polynomials ");
		System.out.println("2.Add Existing Polynolmials");
		int choice ;
		Scanner in;
		String x;
		char ch1 = 0,ch2 = 0;
		in = new Scanner(System.in);
		choice = in.nextInt();
		if(choice == 1)
		{
			System.out.println("Set First Polynomial");
			setPolynomials();
			System.out.println("Set Second Polynomial");
			setPolynomials();
		}else if(choice == 2)
		{
			boolean flag;
			do{
				System.out.println("Choose A or B or C");
				in = new Scanner(System.in);    
				x = in.next();
				ch1 = x.charAt(0);
				if(ch1 == 'A')
				{
					flag = A.isEmpty();
				}else if(ch1 == 'B')
				{
					flag = B.isEmpty();
				}else
				{
					flag = C.isEmpty();
				}
				if(flag && (A.isEmpty() || (B.isEmpty()) || (C.isEmpty()))){
					System.out.println("Polynomial is not set");
				}else if(flag && !(A.isEmpty() || (B.isEmpty()) || (C.isEmpty())))
				{
					System.out.println("NO Polynomial is not set");
					return;
				}
				}while(flag);
				System.out.println("Enter Number Of Terms In Polynomial");
				in = new Scanner(System.in);
				int n;
				n = in.nextInt();
				while(n!=0)
				{
					int ex,co;
					System.out.println("Enter Coefficient");
					in = new Scanner(System.in);
					co = in.nextInt();
					System.out.println("Enter Exponent");
					in = new Scanner(System.in);
					ex = in.nextInt();
					if(ch1 == 'A')
					{
						A.set(co,ex);
					}else if(ch1 == 'B')
					{
						B.set(co,ex);
					}else
					{
						C.set(co,ex);
					}
					n--;
				}
				flag = false;
				do{
					System.out.println("Choose A or B or C");
					in = new Scanner(System.in);    
					x = in.next();
					ch2 = x.charAt(0);
					if(ch2 == 'A')
					{
						flag = A.isEmpty();
					}else if(ch2 == 'B')
					{
						flag = B.isEmpty();
					}else
					{
						flag = C.isEmpty();
					}
					if(flag && (A.isEmpty() || (B.isEmpty()) || (C.isEmpty()))){
						System.out.println("Polynomial is not set");
					}else if(flag && !(A.isEmpty() || (B.isEmpty()) || (C.isEmpty())))
					{
						System.out.println("NO Polynomial is not set");
						return;
					}
					}while(flag);
					System.out.println("Enter Number Of Terms In Polynomial");
					in = new Scanner(System.in);
					n = in.nextInt();
					while(n!=0)
					{
						int ex,co;
						System.out.println("Enter Coefficient");
						in = new Scanner(System.in);
						co = in.nextInt();
						System.out.println("Enter Exponent");
						in = new Scanner(System.in);
						ex = in.nextInt();
						if(ch2 == 'A')
						{
							A.set(co,ex);
						}else if(ch2 == 'B')
						{
							B.set(co,ex);
						}else
						{
							C.set(co,ex);
						}
						n--;
					}
			
		}
		if(ch1 == 'A' && ch2 == 'B')
		{
			R.add(A,B);
		}else if(ch1 == 'A' && ch2 == 'C')
		{
			R.add(A,C);
		}else if(ch1 == 'B' && ch2 == 'A')
		{
			R.add(B,A);
		}else if(ch1 == 'B' && ch2 == 'C')
		{
			R.add(B,C);
		}else if(ch1 == 'C' && ch2 == 'A')
		{
			R.add(C,A);
		}else if(ch1 == 'C' && ch2 == 'B')
		{
			R.add(C,B);
		}
		
		System.out.println("The Result");
		R.display();
		
	}
}
