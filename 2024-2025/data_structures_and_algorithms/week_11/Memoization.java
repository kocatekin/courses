//Save it as Main.java
//here we are using a hashmap to store previously calculated items in factorials
//therefore, when we want to calculate a new factorial, we are using the previous information
//in addition, we can also make a storage number so that we are not filling the hashmap
//it is going to be a somewhat introduction to cache --> maybe there are cache strategies to learn? (e.g. cache aside)



import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

	static HashMap<Integer, Long> factorials = new HashMap<>();
	public static void main(String[] args) {
		
		factorials.put(0, 1L); //1L bc it is long.
		factorials.put(1, 1L);
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter number: ");
			int num = sc.nextInt();
			System.out.println(factorial(num));
		}
		
	}
	
	public static long factorial(int x) {
			if(x == 0) return 1;
			
			if(factorials.containsKey(x)) {
				System.out.println("Found in hashmap...");
				System.out.println("Retrieving from hashmap...");
				return factorials.get(x);
			}
			System.out.println("Not found in hashmap...");
			
			long result = x * factorial(x-1);
			factorials.put(x, result);
			System.out.println("Added to hashmap...");
			
			return result;	
	}
	
	

}
