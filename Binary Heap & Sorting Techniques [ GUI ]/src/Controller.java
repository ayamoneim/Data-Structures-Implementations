import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Controller extends JPanel implements KeyListener, Runnable {

	private static final String[] END_MENU = { "Start Again", "Quit" };
	private static final String[] START_MENU = { "Bubble Sort",
			"Selection Sort", "Insertion Sort", "Merge Sort", "Quick Sort",
			"Heap Sort", "Quit" };
	private int choice = 0;
	private int menuNum = 0;
	private int[] a = {};
	private BufferedImage image;
	private Graphics2D g;
	private boolean running = false;
	private Thread thread;
	private long DELTA = 1000 / 20;
	private int heapLen = 10;
	private int size;
	private int[] sortedArray;
	private int[] sortedArray0;
	private boolean sorting = false;

	private int mode = 0;

	public Controller() {
		super();
		addKeyListener(this);
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
		setPreferredSize(new Dimension(860, 880));
		setFocusable(true);
		requestFocus();

	}

	private void getEndMenu() {
		g.setFont(new Font("Arial", Font.PLAIN, 30));

		for (int i = 0; i < END_MENU.length; i++) {
			if (i == choice)
				g.setColor(Color.RED);
			g.drawString(END_MENU[i], 400, 400 + 40 * i);
			g.setColor(Color.WHITE);
		}

	}

	BufferedImage getBackgroundImage() {
		BufferedImage img = null;

		try {
			img = ImageIO.read(new File("startbg.jpg"));
		} catch (Exception e) {
			e.getStackTrace();
		}
		return img;
	}

	void buildMaxHeap() {
		for (int i = size / 2; i > 0; i--) {
			maxHeapify(i);
		}
	}

	public void maxHeapify(int i) {
		int leftChild = 2 * i;
		int rightChild = 2 * i + 1;

		int indexOfMax = i;
		if (leftChild <= size
				&& sortedArray[leftChild] > sortedArray[indexOfMax])
			indexOfMax = leftChild;
		if (rightChild <= size
				&& sortedArray[rightChild] > sortedArray[indexOfMax])
			indexOfMax = rightChild;
		if (indexOfMax != i) {
			swap(indexOfMax, i);
			maxHeapify(indexOfMax);
		}
	}

	int extractMax() {
//		try {
		if(size-1>=0){
			int max = sortedArray[1];
			// System.out.println(heapSize);
			sortedArray[1] = sortedArray[size];
			size--;
			maxHeapify(1);
			return max;
//		} catch (Exception e) {
		}else
			System.out.println("The Heap is Empty");
//		}
		return 0;
	}

	private boolean heap = false;

	public void isHeap(boolean f) {
		heap = f;
	}

	public boolean getIsHeap() {
		return heap;
	}

	void setInputArray(int[] in) {
		size = in.length;
		
		
		heapLen = Math.max(size + 1, heapLen);
		if (heap)
			sortedArray = new int[heapLen];
		else
			sortedArray = new int[size];

		originalArray = new int[sortedArray.length];

		int x = 0;
		if (heap) {
			x = 1;
		}
		for (int i = 0; i < in.length; i++) {
			originalArray[i + x] = sortedArray[i + x] = in[i];

		}
//		System.out.println(heap);

		sortedArray0 = new int[in.length + 1];
		for (int i = 0; i < in.length; i++)
			sortedArray0[i] = in[i];
		System.out.println(size);
		if(heap){
		for(int i = 1;i<=size;i++)
			System.out.print(sortedArray[i]+" ");
		System.out.println();
		}
	}

	void displayResultArray() {
		System.out.print("{ ");
		int x = 0;
		if (heap) {
			x = 1;
		}
		for (int i = 0; i < size - 1; i++) {
			System.out.print(sortedArray[i + x] + ",");
		}
		if (size != 0)
			System.out.print(sortedArray[size - 1 + x]);
		System.out.println(" }");
	}

	void heapInsert(int element) {
		while (size + 1 >= heapLen)
			expandHeap();
		sortedArray[size + 1] = element;
		size++;
		int curr = size;
		while (curr > 1) {
			if (sortedArray[curr] > sortedArray[curr / 2]) {
				swap(curr, curr / 2);
			} else
				break;
			curr /= 2;
		}
	}

	private void getStartMenu() {

		g.drawImage(getBackgroundImage(), 0, 0, null);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		for (int i = 0; i < START_MENU.length; i++) {
			if (i == choice)
				g.setColor(Color.RED);
			g.drawString(START_MENU[i], 350, 400 + 40 * i);
			g.setColor(Color.WHITE);

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			if (menuNum == 0)
				choice = (choice + 1) % 7;
			else
				choice = (choice + 1) % 2;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (menuNum == 0)
				choice = Math.abs(choice - 1) % 7;
			else
				choice = Math.abs(choice - 1) % 2;
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if ((menuNum == 0 && choice == START_MENU.length - 1)
					|| (menuNum == 2 && choice == END_MENU.length - 1)) {
				System.exit(0);
			} else {
				if(menuNum==0)
				menuNum = 1;
				else{
					if(menuNum==2 && choice==0){
						menuNum = 0;
					}
				}
					
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (choice == 0) {
				if (heap) {
					heap = false;
					shiftLeftOriginal();
				}
				bubbleSort();
			}
			if (choice == 3) {
				if (heap) {
					heap = false;
					shiftLeftOriginal();
				}
				mergeSort(0, size);
			}

			if (choice == 4) {
				if (heap) {
					heap = false;
					shiftLeftOriginal();
				}
				quickSort(0, size - 1);
			}
			if (choice == 1) {
				if (heap) {
					heap = false;
					shiftLeftOriginal();
				}
				SelectionSort();
			}
			if (choice == 2) {
				if (heap) {
					heap = false;
					shiftLeftOriginal();
				}
				insertionSort();
			}
			if (choice == 5) {
				if (!heap) {
					heap = true;
					shiftRightOriginal();
				}
				heapSort();
			}

		} else if (e.getKeyCode() == KeyEvent.VK_END) {
			resetSorted();

			choice = 0;
			menuNum = 2;
		}
	}

	public void resetSorted() {
		int x = 0;
		if (heap)
			x = 1;
		for (int i = 0; i < size + x; i++) {
			sortedArray[i] = originalArray[i];
		}
	}

	public void shiftRightOriginal() {
		sortedArray = new int[size + 1];
		for (int i = 0; i < size; i++)
			sortedArray[i + 1] = originalArray[i];
		originalArray = new int[size + 1];

		for (int i = 0; i <= size; i++)
			originalArray[i] = sortedArray[i];
	}

	public void shiftLeftOriginal() {
		sortedArray = new int[size];
		for (int i = 0; i < size; i++)
			sortedArray[i] = originalArray[i + 1];
		originalArray = new int[size];
		for (int i = 0; i < size; i++)
			originalArray[i] = sortedArray[i];
	}

	void expandHeap() {
		int[] temp = new int[size + 1];
		for (int i = 1; i <= size; i++)
			temp[i] = sortedArray[i];
		sortedArray = new int[heapLen * 2];
		for (int i = 1; i <= size; i++)
			sortedArray[i] = temp[i];

	}

	private int[] originalArray;

	void bubbleSort() {

		for (int i = 0; i < size - 1; i++) {

			for (int j = 0; j < size - i - 1; j++) {

				if (sortedArray[j] > sortedArray[j + 1]) {
					swap(j, j + 1);
				}

			}

		}
		sorting = false;

	}

	void swap(int i, int j) {
		int temp = sortedArray[i];
		sortedArray[i] = sortedArray[j];
		sortedArray[j] = temp;
		if (mode == 1) {
			try {
				thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}

	}

	void SelectionSort() {
		for (int i = 0; i < size; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (sortedArray[j] < sortedArray[min]) {
					min = j;

				}
			}
			swap(i, min);
		}
		sorting = false;
	}

	void insertionSort() {
		for (int i = 1; i < size; i++) {
			int j = i - 1;
			int key = sortedArray[i];
			while (j >= 0 && key < sortedArray[j] ) {
				sortedArray[j + 1] = sortedArray[j];
				j--;

			}
			sortedArray[j + 1] = key;
		}
	}

	void mergeSort(int begin, int end) {
		if (end - begin < 2)
			return;
		int mid = (begin + end) / 2;
		if (mode == 1) {
			try {
				thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		mergeSort(begin, mid);
		mergeSort(mid, end);
		merge(begin, mid, end);

		copyToOriginalArray(begin, end);

	}

	private void copyToOriginalArray(int begin, int end) {
		for (int i = begin; i < end; i++)
			sortedArray[i] = sortedArray0[i];

	}

	private void merge(int begin, int mid, int end) {
		int ptr1 = begin;
		int ptr2 = mid;
		for (int i = begin; i < end; i++) {
			if ((ptr2 == end || sortedArray[ptr1] < sortedArray[ptr2])
					&& ptr1 < mid) {
				sortedArray0[i] = sortedArray[ptr1];
				ptr1++;
			} else if ((ptr1 == mid || sortedArray[ptr1] >= sortedArray[ptr2])
					&& ptr2 < end) {
				sortedArray0[i] = sortedArray[ptr2];
				ptr2++;
			}

		}

	}

	void quickSort(int from, int to) {
		if (from < to) {
			int pivotIndex = partition(from, to);
			quickSort(from, pivotIndex - 1);
			quickSort(pivotIndex + 1, to);
		}
	}

	private int partition(int from, int to) {
		int pivotIndex = from + (to - from) / 2;
		int pivot = sortedArray[pivotIndex];

		swap(to, pivotIndex);
		int curr = from;

		for (int i = from; i < to; i++) {
			if (sortedArray[i] < pivot) {
				swap(i, curr);
				curr++;
			}
		}
		swap(to, curr);
		return curr;
	}

	void heapSort() {
		buildMaxHeap();
		int temp = size;
		for (int i = size; i > 0; i--) {
			swap(i, 1);
			size--;
			maxHeapify(1);
		}
		size = temp;
	}

	void drawSortWindow() {

		g.drawImage(getBackgroundImage(), 0, 0, null);
		g.setColor(new Color(190, 190, 190));

		g.drawString(START_MENU[choice], 100, 80);
		int n = size;
		if (choice == 5)
			n = size;
		int l = 0;
		if (heap)
			l = 1;
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < 15; y++) {
				g.drawLine(100 + 40 * x + y, 600, 100 + 40 * x + y,
						600 - sortedArray[x + l] * 20);

			}
			g.setFont(new Font("Arial", Font.PLAIN, 16));
			g.drawString("" + x, 100 + 40 * x + 4, 600 + 29);

		}
		g.setColor(new Color(200, 10, 40));

		g.drawLine(95, 613, 95 + n * 40, 613);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private void getOnScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, 860, 680, null);
		g2.dispose();
	}

	@Override
	public void run() {

		image = new BufferedImage(860, 680, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();

		running = true;
		long start;
		long elapsed;
		long wait;

		while (running) {

			start = System.nanoTime();

			if (mode == 1) {
				setWindow();

				getOnScreen();
			}
			elapsed = System.nanoTime() - start;

			wait = DELTA - elapsed / 1000000;
			if (wait < 0)
				wait = 5;

			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private void setWindow() {
		if (menuNum == 0)
			getStartMenu();
		if (menuNum == 1)
			drawSortWindow();
		if(menuNum==2)
			getEndMenu();
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getArratSize() {
		return size;
	}

}
