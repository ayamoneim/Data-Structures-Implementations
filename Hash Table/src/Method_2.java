import java.io.*;



public class Method_2 {

	private final String FILENAME = "keys_10000.txt";

	private int size = 0;
	HashFunction func ;
	private bucket[]hashTable;
	int N = 0;
	public Method_2(int N){
		this.N = lowerPowerOf2(N);
		func = new HashFunction(getPowerOf(this.N));
		hashTable = new bucket[this.N];
		this.setSize(0);
		create_level_1();
		try {
			loadKeys(N);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		create_level_2();
	}
	private void create_level_2() {
		for(int i = 0;i<N;i++){
			if(hashTable[i].list.size()>0){
				hashTable[i].create();
				setSize(getSize() + hashTable[i].tableSize);
			}
		}
	}
	public boolean lookUp(int key){
		if(hashTable[func.getBinIndex(key)].list.size()>0)
			return hashTable[func.getBinIndex(key)].lookUpBucket(key);
		return false;
	}
	private int getPowerOf(int n2) {
		int i = 0;
		while(n2!=1){
			n2/=2;
			i++;
		}
		return i;
	}
	private int lowerPowerOf2(int n2) {
		return (int)Math.pow(2, Math.floor(Math.log(n2) / Math.log(2)));
	}

	private void loadKeys(int fileSize) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		int key;
		for(int i = 0;i<fileSize;i++){
			key= Integer.parseInt(br.readLine());
			hashTable[func.getBinIndex(key)].add(key);
		}
		return ;
	}
	private void create_level_1() {
		for(int i = 0;i<N;i++)
			hashTable[i] = new bucket();
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
