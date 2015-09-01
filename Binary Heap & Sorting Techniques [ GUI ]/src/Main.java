import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import javax.swing.JFrame;

public class Main {

	private static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int choice = setModeMenu();


		Controller c = new Controller();

//		 c.setMode(0);
//		 int[]a={1,3,2,0};
//		 c.setInputArray(a);
//		 c.bubbleSort();
//		 c.displayResultArray();
//		 c.setInputArray(a);
//		 c.buildMaxHeap();
//		 c.displayResultArray();
//		 System.out.println(c.extractMax());
//		 for(int i = 0;i<4;i++)
//		 System.out.println("************"+a[i]);
//		 c.heapInsert(0);
//		 c.displayResultArray();
//		 c.setInputArray(a);
//		 c.mergeSort(0, a.length);
//		 c.displayResultArray();
//		 setFrame(c);
//		 c.setMode(1);
		
		if (choice == 2) {
			
			int action = chooseAction();
			int[] arr = null;
			while (action != 0) {
				
				System.out.println("0.Set/Reset Input Array");
				if (Integer.parseInt(br.readLine()) == 0) {
					arr = setInputArray();
					c.setInputArray(arr);
				}else{
					if(action<=4 || action==10){
						if(!c.getIsHeap()){
							c.isHeap(true);
							if(action==10)
								c.setInputArray(arr);
						}
						
					}else{
						if(c.getIsHeap()){
							c.isHeap(false);
							c.setInputArray(arr);
						}
						
					}
				}

				takeAction(c, action, c.getArratSize());
				c.displayResultArray();
				action = chooseAction();
			}
			System.exit(0);
		} else if (choice == 1) {

			setInputMethod(c);
			setFrame(c);
			c.setMode(1);
		} else {
			graphAnalysis(c);
		}

	}

	private static void takeAction(Controller c, int act, int n)
			throws NumberFormatException, IOException {
		if (act == 1) {
			c.buildMaxHeap();
		} else if (act == 2) {
			
			System.out.println("Enter element value");
			c.heapInsert(Integer.parseInt(br.readLine()));
		} else if (act == 3) {
			System.out.println("Max Element"+" "+c.extractMax());
		} else if (act == 4) {
			System.out.println("Enter Index of Element");
			c.maxHeapify(Integer.parseInt(br.readLine()) );
		} else if (act == 5) {
			c.bubbleSort();
		} else if (act == 6) {
			c.insertionSort();
		} else if (act == 7) {
			c.SelectionSort();
		} else if (act == 8) {
			c.mergeSort(0, n);
		} else if (act == 9) {
			
			c.quickSort(0, n - 1);
		} else if(act==10){
			c.heapSort();
		}else
			System.exit(0);

	}

	private static void graphAnalysis(Controller c) {
		for(int i = 100;i<=100000;i*=10){
			c.setInputArray(generateArray(i));
			long s = System.currentTimeMillis();
			c.bubbleSort();
			long t = System.currentTimeMillis();
			System.out.println((t-s)+" "+i);

		}
		System.out.println("*************************");
		
		for(int i = 100;i<=100000;i*=10){
			c.setInputArray(generateArray(i));
			long s = System.currentTimeMillis();
			c.insertionSort();
			long t = System.currentTimeMillis();
			System.out.println((t-s)+" "+i);

		}
		System.out.println("*************************");
		
		for(int i = 100;i<=100000;i*=10){
			c.setInputArray(generateArray(i));
			long s = System.currentTimeMillis();
			c.SelectionSort();
			long t = System.currentTimeMillis();
			System.out.println((t-s)+" "+i);

		}
		System.out.println("*************************");
		
		for(int i = 100;i<=100000;i*=10){
			c.setInputArray(generateArray(i));
			long s = System.currentTimeMillis();
			c.mergeSort(0,i);
			long t = System.currentTimeMillis();
			System.out.println((t-s)+" "+i);

		}
		System.out.println("*************************");

		for(int i = 100;i<=100000;i*=10){
			
			
			c.setInputArray(generateArray(i));
			long s = System.currentTimeMillis();
			c.quickSort(0,i-1);
			long t = System.currentTimeMillis();
			System.out.println((t-s)+" "+i);

		}
		System.out.println("*************************");
		for(int i = 100;i<=100000;i*=10){
			c.setInputArray(generateArray(i));
			long s = System.currentTimeMillis();
			c.isHeap(true);
			c.heapSort();
//			c.isHeap(false);
			long t = System.currentTimeMillis();
			System.out.println((t-s)+" "+i);

		}
		System.out.println("****************");

	}

	private static void setInputMethod(Controller c) throws Exception {
		System.out.println("Enter a valid choice");
		System.out.println("   1.Manually set input array");
		System.out.println("   2.Auto generate input array");
		if(Integer.parseInt(br.readLine())==1)
		c.setInputArray(setInputArray());
		else{
			System.out.println("Enter array size ");
			c.setInputArray(generateArray(Integer.parseInt(br.readLine())));
		}
	}

	private static int[] generateArray(int i) {
		int[]arr = new int[i];
		for(int j = 0;j<i;j++){
			Random r = new Random();
			arr[j] = r.nextInt(20);
		}
		return arr;
	}

	private static void setFrame(Controller c) {
		JFrame f = new JFrame("Sorting Application");
		f.setContentPane(c);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.pack();
		f.setResizable(false);
		f.setVisible(true);
	}

	private static int setModeMenu() throws Exception {
		System.out.println("Choose Mode");
		System.out.println("   1.Animation Mode");
		System.out.println("   2.Testing Mode");
		System.out.println("   3.Analysis Mode");

		return Integer.parseInt(br.readLine());
	}

	private static int chooseAction() throws Exception {
		System.out.println("Choose Procedure");
		System.out.println("   1.Build Max Heap");
		System.out.println("   2.Insert in Built Heap");
		System.out.println("   3.Extract Max from Built Heap");
		System.out.println("   4.Heapify a certain Heap Node");
		System.out.println("   5.Bubble Sort");
		System.out.println("   6.Insertion Sort");
		System.out.println("   7.Selection Sort");
		System.out.println("   8.Merge Sort");
		System.out.println("   9.Quick Sort");
		System.out.println("   10.Heap Sort");
		System.out.println("   0.Exit");
		return Integer.parseInt(br.readLine());
	}

	private static int[] setInputArray() throws Exception {
		System.out.println("Enter input array size");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter Array Elements");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		return arr;
	}

	
	
}
