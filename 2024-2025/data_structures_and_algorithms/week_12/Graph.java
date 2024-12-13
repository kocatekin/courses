package harrypotterfriends;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
	
		Map<String, String[]> graph = new HashMap<>();
		
		graph.put("harry", new String[]{"ron","hermi","dumble"});
		graph.put("hermi", new String[] {"ron","harry"});
		graph.put("ron", new String[] {"harry","hermi"});
		graph.put("dumble", new String[] {"harry","sirius"});
		graph.put("sirius", new String[] {"dumble"});
		
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Recommend to who? ");
			String temp = sc.nextLine();
			System.out.println(recommend(temp,graph));
			}

	}
	
	public static Set<String> recommend(String name, Map<String, String[]> graph) {
		//1st --> get friends of name
		System.out.println("Recommending friends for " + name);
		ArrayList<String> friends = new ArrayList<String>();
		String[] friendsarray = graph.get(name);
		for(int i=0;i<friendsarray.length;i++) {
			friends.add(friendsarray[i]);
		}
		
		Set<String> f2f = new HashSet<>(); 
		for(String friend : friends) {
			f2f.addAll(Arrays.asList(graph.get(friend)));
		}
		
		f2f.remove(name); //remove herself
		/* remove own friends */
		for(int i=0;i<friends.size();i++) {
			f2f.remove(friends.get(i));
		}
		
		return f2f;
		//return f2f.toString();
		
		
	}
	

}
