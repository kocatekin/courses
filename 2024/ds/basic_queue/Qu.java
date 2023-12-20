
public class Qu {
	
	int[] myArr;
	int size;
	int head;
	int tail;
	
	Qu(int size) {
		this.size = size;
		myArr = new int[size];
		head = 0;
		tail = 0;
	}
	
	public void enqueue(int data) {
		//this.data = data;
		myArr[tail] = data;
		tail++;	
	}
	
	public int dequeue() {
		int temp = myArr[head];
		myArr[head] = 0;
		head++;
		return temp;
	}
	
	public void display() {
		System.out.println("The queue in array form:");
		for(int i=0;i<this.size;i++) {
			System.out.print(this.myArr[i]);
			System.out.print(", ");	
		}
		System.out.println("");
	}

}
