
public class User {
	private String name;
	
	User(String name) {
		this.name = name;
		System.out.println("Created: " + name);
	}
	
	public String getName() {
		return name;
	}

}
