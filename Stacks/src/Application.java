import java.lang.*;
import java.util.*;
import java.io.*;
 
 
class Application
{
	public static void main (String[]args)
	{
		int choice ;
		
		System.out.println("Main Menu");
		System.out.println("	1.Symbolic Expresseion)");
		System.out.println("	2.Nummeric Expression");
		System.out.println("\nEnter Your Choice PLease");
		Scanner in = new Scanner(System.in);
		choice = in.nextInt();
		Object[]arr = readExp();
		boolean flag1 = checkBrackets(arr);
		boolean flag2 = correctFormat(arr);
		while(!flag1 || !flag2)
		{
			arr = readExp();
			flag1 = checkBrackets(arr);
			flag2 = correctFormat(arr);
		}
		switch(choice)
		{
			case 1:
			{
				
				symbolicExp(arr);
				break;
			}
			case 2:
			{
				nummericExp(arr);
				break;
			}
		}
		 

	}

	private static boolean correctFormat(Object[] infix) {
		
		for(int i=0;i<infix.length;i++)
		{
			if((infix[i].equals("+")|| infix[i].equals("*")|| infix[i].equals("/")  )&& i+1<infix.length &&(infix[i+1].equals("+")|| infix[i+1].equals("*")|| infix[i+1].equals("/")))
			{
				return false;
			}
		}
		return true;
		
	}

	private static boolean checkBrackets(Object[] infix) {
		
		MyStack s = new MyStack();
		for(int i = 0;i<infix.length ;i++)
		{
			if(infix[i].equals("("))
			{
				s.push(infix[i]);
			}else if(infix[i].equals(")"))
			{
				if(s.isEmpty())
				{
					return false;
				}else if(!s.pop().equals("(")) 
				{
					return false;
				}
			}
			
		}
		if(s.isEmpty())
			return true;
		else
			return false;
		
	}

	private static void nummericExp(Object[] infix) {
		System.out.println("	1.Convert to Postfix");
		System.out.println("	2.Evaluate Expression");
		System.out.println("\nEnter Your Choice PLease");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		switch(choice)
		{
		case 1:
		{
			System.out.println(toPostfix(infix));
			break;
		}
		case 2:
		{
			Object[]arr = toPostfix(infix).split(" ");
			System.out.println("RESULT: " + evalPostfix(arr));
			break;
		}
		}
	}

	private static void symbolicExp(Object[] infix) {
		System.out.println("	1.Convert to Postfix");
		System.out.println("	2.Evaluate Expression");
		System.out.println("\nEnter Your Choice PLease");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		switch(choice)
		{
		case 1:
		{
	
			System.out.println(toPostfix(infix));
			break;
		}
		case 2:
		{
			Object[]arr = toPostfix(findSymbols(infix)).split(" ");
			System.out.println("RESULT: " + evalPostfix(arr));
			break;
		}
		}
		
		
	}

	private static Object[] findSymbols(Object[] postfix) {
		Object[] newInfix = new Object[postfix.length];
		for(int i=0;i<postfix.length;i++)
		{
			if(!postfix[i].equals("+") && !postfix[i].equals("-") && !postfix[i].equals("*") && !postfix[i].equals("/"))
			{
				int x ;
				System.out.print(postfix[i] + " = ");
				Scanner in = new Scanner(System.in);
				x = in.nextInt();
				newInfix[i] =(Object) x;
				
			}else
			{
				newInfix[i]=(Object) postfix[i];
			}
		}
		return newInfix;
		
		
	}

	private static Object[] readExp() {
		
		System.out.println("Enter Expression\n	(spaces are required between terms)");
		Object[] infix =new Object[1000];
		InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        try {
        	infix =reader.readLine().split(" ") ;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
       // Object[]arr = toPostfix(infix).split(" ");
        return infix;
		
	}

	private static float evalPostfix(Object[] arr) {
		MyStack s = new MyStack();
		for(int i=0 ;i<arr.length;i++)
		{
			float x,y;
		
			if(!s.isEmpty() &&(arr[i].equals("+")|| arr[i].equals("*")|| arr[i].equals("/")||(arr[i].equals("-") && i>0 && (!arr[i-1].equals("*") && !arr[i-1].equals("/")))))
			{
				
				x = (float)s.pop();
				y = (float)s.pop();
				if(arr[i].equals("*"))
				{
					s.push(y*x);
				}else if(arr[i].equals("/"))
				{
					if(x!=0)
						s.push(y/x);
					
					
				}else if(arr[i].equals("+"))
				{
					s.push(y+x);
				}else 
				{
					s.push(y-x);
				}
			}else 
			{
				s.push(Float.parseFloat(arr[i].toString()));
			}
		}
		float res = 0;
		if(!s.isEmpty())
			 res = (float) s.pop();
		return res;
	}

	private static String toPostfix(Object[] infix) {
		String postfix = "";
		MyStack s = new MyStack();
		for(int i=0;i<infix.length;i++)
		{
			String ch = infix[i].toString();
		
			if(!ch.equals("*") && !ch.equals("/") && !ch.equals("+") && !ch.equals("-") && !ch.equals("(") && !ch.equals(")"))
			{
				postfix+=ch;
				postfix+=" ";
			}else if(ch.equals(")"))
			{
				while(!s.isEmpty()  &&!s.peek().equals("("))
				{
					postfix+=(String)s.pop();
					postfix+=" ";
				}
				if(!s.isEmpty())
					s.pop();
			}else if(!s.isEmpty() && (((s.peek().equals("+") || s.peek().equals("-"))&&(infix[i].equals("*")|| infix[i].equals("/") ))||s.peek().equals("(")))
			{
				s.push(infix[i]);
			}else if(!s.isEmpty() &&( ((s.peek().equals("/") || s.peek().equals("*")) && (infix[i].equals("+") || infix[i].equals("-")|| infix[i].equals("*") || infix[i].equals("/")))||(( s.peek().equals("-")||s.peek().equals("+")) &&(infix[i].equals("+") || infix[i].equals("-")))))
			{
				boolean flag =true;
				while(flag)
				{
					postfix+=(String)s.pop();
					postfix+=" ";
					if(!s.isEmpty() &&( ((s.peek().equals("/") || s.peek().equals("*")) && (infix[i].equals("+") || infix[i].equals("-")|| infix[i].equals("*") || infix[i].equals("/")))||(( s.peek().equals('-')||s.peek().equals("+")) &&(infix[i].equals("+") || infix[i].equals("-")))))
					{
						continue;
					}else
					{
						flag = false ;
					}
				}
				s.push(infix[i]);
			}else if(s.isEmpty())
			{
				s.push(infix[i]);
			}else if(ch.equals("("))
			{
				s.push(infix[i]);
			}

		}
		
		while(!s.isEmpty())
		{
			postfix+=(String)s.pop();
			postfix+=" ";
		}
		return postfix;
	}
}