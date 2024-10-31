/*
Here, we are creating a very simple game by using the reversi function we previously coded in a recursive way.
A good way to practice.
*/
package reversi;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		words.add("harry");
		words.add("hermione");
		words.add("dumbledore");
		words.add("mcgonagall");
		
		startGame(words);

	}
	
	public static void startGame(ArrayList<String> words) {
		int score = 0;
		while(words.size() > 0) {
			//get a random word
			Random rnd = new Random();
			int sayi = rnd.nextInt(0,words.size());
			String word = words.get(sayi);
			System.out.println(reversi(word));
			Scanner sc = new Scanner(System.in);
			String tahmin = sc.nextLine();
			if(tahmin.equals(word)) {
				score++;
				System.out.println("dogru");
				words.remove(words.indexOf(word));
			}
			else {
				words.remove(words.indexOf(word));
				continue;
			}
			
		}
		print("tum kelimeler bitti.");
		print("score: " + score);
	}
	
	public static String reversi(String s) {
		//base case
		if(s.length() <= 1 || s == null) {
			return s;
		}
		//recursive case
		return reversi(s.substring(1)) + s.charAt(0);
	}
	
	public static void print(Object o) {
		System.out.println(o.toString());
	}
	
	
	

}
