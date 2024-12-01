//you should name the file as Main.java for it to work.

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		HashMap<String, String> capitals = new HashMap<>();
		
		
		//one can create these from a csv file.
		//you would have a basic game
		//add a scoreboard and you are done.
		//can try to do this in python using dictionaries
		
		capitals.put("England","London");
		capitals.put("Turkiye","Ankara");
		capitals.put("Germany", "Berlin");
		
		System.out.println(capitals);
		
		int correct = 0;
		
		for(String s : capitals.keySet()) {
			Scanner sc = new Scanner(System.in);
			System.out.println(s);
			String cevap = sc.nextLine();
			if(cevap.equals(capitals.get(s))) {
				System.out.println("Correct");
				correct++;
			} else {
				System.out.println("No. Answer is: " + capitals.get(s));
			}
		}
		System.out.println("Score: " + correct);
		
		
		
	}
	
	

}
