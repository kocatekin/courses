import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //cin
		
		System.out.println("username: ");
		String username = sc.nextLine();
		System.out.println("password: ");
		String password = sc.nextLine();
		
		if(username.equals("ilayda") && password.equals("123456")) {
			System.out.println("right user");
			User user = new User(username);
			Diary d1 = new Diary(user);
			System.out.println("Write your text: \n");
			String text = sc.nextLine();
			
			d1.addRecord(new DiaryRecord(text));
			List<DiaryRecord> records = d1.listAll();
			for(DiaryRecord record : records) {
				System.out.println("Date: " + record.getDate());
				System.out.println("Text: " + record.getText());
			}
			
			
			
			
			
			
		} else {
			System.out.println("get out");
		}
			
			
		
	}

}
