import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Method_1 {
	private final String FILENAME = "keys_1000.txt";
	
	private int[]hashTable;
	private boolean[]bool;
	private HashFunction func;
	private int N = 0;
	private int b = 0;
	private int collisions = 0;
	public Method_1(int N) throws NumberFormatException, IOException{
		
		if(N<2){
			this.N = 2;
		}
//		System.out.println("1");
		this.N = lowerPowerOf2(N*N);
//		System.out.println("2");
		b = getPowerOf(this.N);
//		System.out.println("3");
		createTable();
//		System.out.println("4");
		loadKeys(N);
//		System.out.println("5");
	}
	private int getPowerOf(int n2) {
		int i = 0;
		while(n2!=1){
			n2/=2;
			i++;
		}
		return i;
	}
	private void createTable() {

		hashTable = new int[this.N];
		bool = new boolean[this.N];
	}
	private int lowerPowerOf2(int n2) {
		return (int)Math.pow(2, Math.floor(Math.log(n2) / Math.log(2)));
	}
	
	
	private void loadKeys(int fileSize) throws NumberFormatException, IOException{
		int[]keys = readFile(fileSize);
//		System.out.println("*********");
		int i = 0;
		func = new HashFunction(b);
		while(i!=fileSize){
			if(bool[func.getBinIndex(keys[i])] && hashTable[func.getBinIndex(keys[i])]!=keys[i]){
				i = 0;
				func = new HashFunction(b);
				emptyTable();
				collisions++;
			}
			hashTable[func.getBinIndex(keys[i])] = keys[i];
			bool[func.getBinIndex(keys[i])] = true;
			i++;

		}
		
	}
	private void emptyTable() {
		for(int i = 0;i<N;i++){
			bool[i] = false;
		}
		
	}
	private int[] readFile(int fileSize) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		int[]keys = new int[fileSize];
		for(int i = 0;i<fileSize&&i<10000;i++){
			keys[i] = Integer.parseInt(br.readLine());
			System.out.println("************");
		}
		return keys;
	}
	public int getCollisions() {
		return collisions;
	}
	
	public boolean lookUp(int key){
		return bool[func.getBinIndex(key)] && hashTable[func.getBinIndex(key)]==key;
	}

	
}
