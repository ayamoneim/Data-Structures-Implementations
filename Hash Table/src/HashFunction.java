import java.util.*;


public class HashFunction {
	
	private Random randomGenerator = new Random();
	private int[]h ;
	private int rows = 0;
	public HashFunction(int b){
		h = new int[b];
		this.rows = b;
		for(int i = 0;i<b;i++)
			h[i] = randomGenerator.nextInt();
	}
	
	public int getBinIndex(int x){
		int index = 0;
		for(int i = 0;i<rows;i++){
			index = index<<1;
			index = index|getParityOf(h[i] & x);
		}
		return index;
		
	}

	private int getParityOf(int i) {
		int curr = 0;
		while(i!=0){
			curr^=1;
			i&=(i-1);
		}
		return curr;
	}
	
	
	

}
