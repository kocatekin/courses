
public class Queue {
	
	int[] arr;
	int top;
	int size;
	
	public Queue(int x) {
		arr = new int[x];
		top = -1;
		size = 0;
	}
	
	public void push(int x) {
		if(!isFull()) {
			top++;
			arr[top] = x;
			System.out.println("Added " + x + " to Queue.");
			size++;
		}
		else {
			System.out.println("The queue is full!");
		}
		
		
	}
	public int pop() {
		if(!isEmpty()) {
			int temp = arr[top];
			top--;
			System.out.println("Popped " + temp + " from the queue.");
			size--;
			return temp;
		}	
		else {
			System.out.println("The queue is empty. Can't take it out");
			return -1;
		}
	}
	
	public boolean isFull() {
		if(size == arr.length) {
			return true;
		}
		return false;
	}
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	

}
