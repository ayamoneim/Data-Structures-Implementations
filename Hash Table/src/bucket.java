import java.util.ArrayList;


public class bucket {

	public int n;
	ArrayList<Integer>list;
	bin[]hashTable;
	HashFunction func ;
	int b = 0;
	int tableSize = 0;;
	public bucket(){
		list = new ArrayList<Integer>();
	}
	
	public void add(int e){
		list.add(e);
	}

	private void emptyTable() {
		for(int i = 0;i<tableSize;i++){
			hashTable[i].occupied = false;
		}
		
	}
	
	public void create() {
		createHashTable();

		int i = 0;
		func = new HashFunction(b);
		while(i!=list.size()){
			if(hashTable[func.getBinIndex(list.get(i))].occupied && hashTable[func.getBinIndex(list.get(i))].element!=list.get(i)){
				i = 0;
				func = new HashFunction(b);
				emptyTable();
			
			}
			hashTable[func.getBinIndex(list.get(i))].element =list.get(i);
			hashTable[func.getBinIndex(list.get(i))].occupied = true;
			i++;

		}
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
	private void createHashTable() {
		if(list.size()<2){
			tableSize = lowerPowerOf2(2*2);
			b = getPowerOf(tableSize);
			hashTable = new bin[tableSize];	
		}else{
			tableSize = lowerPowerOf2(list.size()*list.size());
			b = getPowerOf(tableSize);
			hashTable = new bin[tableSize];
		}

		for(int i = 0;i<tableSize;i++){
			hashTable[i] = new bin();
		}
		
	}

	public boolean lookUpBucket(int key) {
		return hashTable[func.getBinIndex(key)].occupied && hashTable[func.getBinIndex(key)].element==key;
	}
}
