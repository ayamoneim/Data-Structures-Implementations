import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class Dictionary {

	
	private AVLTree tree;
	private int size;
	public Dictionary(){
		this.tree = new AVLTree<String>();
		this.size = 0;
	}
	
	public void insert(String e){
		if(!tree.lookUp(e))
			size++;
		else
			System.out.println("ERROR: Word already in the dictionary!");
		tree.insert(e);
		
	}
	
	public int getAVLHeight(){
		return tree.getTreeHeight();
	}
	
	public void delete(String e){
		if(tree.lookUp(e))
			size--;
		else{
			System.out.println("ERROR:Word doesn't exist in the dictionary!");
		}
		tree.delete(e);
		
	}
    public void LoadDictionary() throws IOException{
		LinkedList<String>words = new LinkedList<String>();
		words = readFile("dictionary.txt");
		for(int i = 0;i<words.size();i++)
			insert(words.get(i));
	}
    
    public LinkedList<String> readFile(String filename) throws IOException{
		LinkedList<String>lines = new LinkedList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String temp = null;
			while((temp = br.readLine())!=null){
				lines.add(temp);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File "+filename+" can't be read!");
			e.printStackTrace();
		}
		return lines;
	}
    
    public int printDictionarySize()
    {
    	return this.size;
    }
	
    public String lookUp(String e){
    	if(tree.lookUp(e))
    		return e+"--> YES";
    	return e+"--> NO";
    }
    
    public void batchLookUps() throws IOException{
    	int counter = 0;
    	LinkedList<String>words = new LinkedList<String>();
		words = readFile("queries.txt");
		for(int i = 0;i<words.size();i++){
			System.out.println(lookUp(words.get(i)));
			if(tree.lookUp(words.get(i)))
				counter++;
		}
		System.out.println("NO OF MATCHES FOUND : "+counter);
    }
    
    public void batchDeletions()throws IOException{
    	LinkedList<String>words = new LinkedList<String>();
		words = readFile("deletions.txt");
		for(int i = 0;i<words.size();i++){
			delete(words.get(i));
		}
    }
    
    public void printDictionary(){
    	tree.printTree(tree.getRoot());
    }
    
}
