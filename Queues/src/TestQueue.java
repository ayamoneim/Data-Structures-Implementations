import java.util.NoSuchElementException;
import java.util.Scanner;


public class TestQueue {
	public static void main(String[]args)
	{
		System.out.println("Implementation of Queues By:\n-------------------------------");
		System.out.println("	1.LINKED LIST");
		System.out.println("	2.ARRAY");
		Scanner in = new Scanner (System.in);
		int choice = in .nextInt();
		boolean flag= true;
		switch(choice)
		{
		case 1:
		{
			menu();
////			LinkedQueue q1 = new LinkedQueue();
//			q1.enqueue(10);
//			q1.enqueue(1);
//			q1.enqueue(-2);
//			q1.enqueue(6);
//			q1.enqueue(4);
//			q1.enqueue(100);
//			q1.enqueue(1);
//			q1.enqueue(-20);
//			q1.enqueue(60);
//			q1.enqueue(40);
//			while(!q1.isEmpty())
//			{
//				System.out.println("Before: "+ q1.getSize());
//				System.out.println(q1.dequeue());
//				System.out.println("After: "+ q1.getSize());
//			}
			break;
		}
		
		case 2:
		{
			arrayMenu();
//			ArrayQueue q = new ArrayQueue(6);
//			q.enqueue(0);
//			q.enqueue(1);
//			q.enqueue(-2);
//			q.enqueue(3);
//			q.enqueue(4);
//			while(!q.isEmpty())
//			{
//				System.out.println("Before: "+ q.size());
//				System.out.println(q.dequeue());
//				System.out.println("After: "+ q.size());
//			}
//		}
		break;
		}
	}
	}

	private static void arrayMenu() {
		System.out.println("	Enter Size\n	------------");
		Scanner in3 =new Scanner (System.in);
		int n = in3.nextInt();
		ArrayQueue q1 = new ArrayQueue();
		for(int i =0;i<n;i++)
		{
			Object element ;
			System.out.println("	Enter Element:\n	---------------");
			Scanner in2 = new Scanner(System.in);
			element =in2.nextInt();
			q1.enqueue(element);
		}
		boolean flag = true;
		do{
		System.out.println("		1.Enqueue\n		2.Dequeue\n		3.Size\n		4.Empty");
		int choice;
		Scanner in =new Scanner (System.in);
		choice = in.nextInt();
		switch(choice)
		
		{
			case 1:
			{
				Object element ;
				Scanner in2 = new Scanner(System.in);
				element =in2.nextInt();
				q1.enqueue(element);
				
				
				break;
			}
			case 2:
			{
				
				try{
				 System.out.println(q1.dequeue());
				 System.out.print("	<--- Element removed  ");
				}catch(NoSuchElementException e )
				{
					System.out.println("Empty Queue");
				}
				break;
			}
			case 3:
			{
				System.out.println("	Size : "+q1.size());
				break;
			}
			case 4:
			{
				if(q1.isEmpty())
				{
					System.out.println("	Empty Queue\n	--------------");
				}else
				{
					System.out.println("	Occupied Queue\n	-----------------");
				}
				break;
				//System.out.println("Empty :"+ q1.isEmpty());
			}
			
		}
		
		System.out.println("	\n --> Continue?(Y/N)");
		Scanner in5 =new Scanner (System.in);
		char ch = in5.nextLine().charAt(0);
		if(ch=='Y')
		{
			flag = true;
		}else
		{
			flag = false;
		}
		}while(flag);
		
	}

	private static void menu() {
		LinkedQueue q1 = new LinkedQueue();
		System.out.println("	Enter Size\n	------------");
		Scanner in3 =new Scanner (System.in);
		int n = in3.nextInt();
		for(int i =0;i<n;i++)
		{
			Object element ;
			System.out.println("	Enter Element:\n	---------------");
			Scanner in2 = new Scanner(System.in);
			element =in2.nextInt();
			q1.enqueue(element);
		}
		boolean flag;
		do{
		System.out.println("		1.Enqueue\n		2.Dequeue\n		3.Size\n		4.Empty");
		int choice;
		Scanner in =new Scanner (System.in);
		choice = in.nextInt();
		switch(choice)
		
		{
			case 1:
			{
				Object element ;
				System.out.println("	Enter Element:	");
				Scanner in2 = new Scanner(System.in);
				element =in2.nextInt();
				q1.enqueue(element);
				
				break;
			}
			case 2:
			{
				try{
				System.out.println("	Element removed : " + q1.dequeue());
				}catch(NoSuchElementException e)
				{
					System.out.println("Empty");
//					System.out.println();
				}
				break;
			}
			case 3:
			{
				System.out.println("	Size : "+q1.getSize());
				break;
			}
			case 4:
			{
				if(q1.isEmpty())
				{
					System.out.println("	Empty Queue\n	--------------");
				}else
				{
					System.out.println("	Occupied Queue\n	-----------------");
				}
				break;
				//System.out.println("Empty :"+ q1.isEmpty());
			}
			
		}
		
		System.out.println("	\n --> Continue?(Y/N)");
		Scanner in5 =new Scanner (System.in);
		char ch = in5.nextLine().charAt(0);
		if(ch=='Y')
		{
			flag = true;
		}else
		{
			flag = false;
		}
		}while(flag);
		
	}
}
