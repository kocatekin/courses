//Main.java
//example of a very simple, primitive hash function
//it gets the location of letters in the alphabet - sums them up and returns the remainder for a boundary
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static String s = "abcdefghijklmnopqrstuvwxyz";
	static char[] alp = s.toCharArray();
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String cevap = sc.nextLine();
		int x = hash(cevap, 10);
		System.out.println(x);
		
	}
	
	public static int hash(String s, int bound) {
		int sum = 0;
		
		for(int i=0;i<s.length();i++) {
			char x = s.toCharArray()[i];
			sum += Arrays.toString(alp).indexOf(x);
		}
		
		return sum % bound;
		
	}

}
