import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		Dictionary d = new Dictionary();
		int choice = printMenu();
		while(choice!=8){
			makeChoice(d,choice);
			System.out.println("------------------------------------------------------------------------------------------");

			System.out.println("TREE HEIGHT : "+d.getAVLHeight());
			System.out.println("TREE SIZE : "+d.printDictionarySize());
			System.out.println("------------------------------------------------------------------------------------------");
			choice = printMenu();
		}
	}

	private static void makeChoice(Dictionary d, int choice) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		if(choice==1)
			d.LoadDictionary();
		if(choice==2)
			d.printDictionarySize();
		if(choice==3){
			System.out.println("Enter Element : ");
			d.delete(br.readLine());
		}
		if(choice==4){
			System.out.println("Enter Element : ");
			System.out.println(d.lookUp(br.readLine()));
		}
		if(choice==5)
		{
			System.out.println("Enter Element : ");
			d.insert(br.readLine());
		}
		if(choice==6){
			d.batchLookUps();
		}
		if(choice==7)
			d.batchDeletions();
		
	}

	public static int printMenu() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("CHOOSE METHOD :");
		System.out.println("----------------");
		System.out.println("1.Load Dictionary");
		System.out.println("2.Print Dictionary Size");
		System.out.println("3.Remove a Word");
		System.out.println("4.Look up a word");
		System.out.println("5.Insert a Word");
		System.out.println("6.Batch Look-ups");
		System.out.println("7.Batch Deletions");
		System.out.println("8.EXIT");
		return Integer.parseInt(br.readLine());
		
	}

}
