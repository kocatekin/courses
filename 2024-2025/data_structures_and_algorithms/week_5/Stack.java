package pckg;

public class Stack {
	ArelList al;
	int size;

	public Stack() {
		al = new ArelList();
		size = -1;
		
	}
	
	public void push(int x) {
		al.add(x);
		size++;
		
	}
	
	public int pop() {
		int num = al.getElement(size);
		al.removeAt(size);
		size--;
		return num;
	}
	
	
}
