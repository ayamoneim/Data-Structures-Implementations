import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("ENTER FILE SIZE");
		int N = Integer.parseInt(br.readLine());
		int choice = -1;
		while (choice != 3) {
			System.out.println("1.Method 1\n2.Method 2\n3.EXIT");
			choice = Integer.parseInt(br.readLine());
			if (choice == 1) {
				Method_1 m1 = new Method_1(N);
				System.out.println("NUMBER OF REBUILDS "+m1.getCollisions());
				System.out
						.println("Enter key value /Enter end to change method");
				int key = -1;
				String s = "";
				while (!s.equals("end")) {
					s = br.readLine();
					if (!s.equals("end")) {
						key = Integer.parseInt(s);
						System.out.println(m1.lookUp(key));
					}
				}
			} else if (choice == 2) {
				Method_2 m2 = new Method_2(N);
				System.out.println("Table Size "+m2.getSize());
				System.out
						.println("Enter key value /Enter end to change method");
				int key = -1;
				String s = "";
				while (!s.equals("end")) {
					s = br.readLine();
					if (!s.equals("end")) {
						key = Integer.parseInt(s);
						System.out.println(m2.lookUp(key));
					}
				}

			} else if (choice == 3) {
				break;
			}

		}

	}
}
