

public class Queue {
	
	int[] arr;
	int front;
	int rear;
	int size;
	int capacity;
	
	public Queue(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
		front = 0;
		rear = -1;
		size = 0;
	}
	
	public void add(int x) {
		if(!isFull()) {
			rear++;
			arr[rear] = x;
			size++;
			System.out.println("added " + x);
		}
		System.out.println("the queue is full cant add");
		return;
	}
	
	public int remove() {
		if(!isEmpty()) {
			int item = arr[front];
			front++;
			size--;
			System.out.println("removed " + item);
			return item;
		}
		System.out.println("queue is empty, cant remove");
		return -1;
		
		
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == capacity;
		
	}
	

}
