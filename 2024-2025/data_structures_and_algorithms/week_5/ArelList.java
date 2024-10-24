package pckg;

public class ArelList {
	
	Node head;
	int size;
	
	public ArelList() {
		head = null;
		size = 0;
	}
	
	public void add(int data) {
		Node newNode = new Node(data);
		if(head == null) { //that means it is the first
			head = newNode;
		}
		else {
			//i need the last node and change its next to newnode.
			Node current = head;
			
			while(current.next != null) {
				current = current.next;
			}
			current.next = newNode;
			
		}
		size++;
	
	}
	
	public void removeAt(int index) {
		//the index should not be smaller or larger than size
		if(index < 0 || index >= size) {
			System.out.println("out of bounds");
			//throw an exception
			return; //get out
		}
		
		if(index == 0) { //that means the first element. so, our head should point to the next element.
			head = head.next;
		}
		else {
			Node current = head;
			for(int i = 0; i < index -  1; i++) {
				current = current.next;
			}
			current.next = current.next.next;
		}
		size--;
	}
	
	
	public int getElement(int index) {
		if(index < 0 || index >= size) {
			System.out.println("out of bounds");
			//throw an exception
			return -1; //get out
		}
		if(index == 0) { //that means the first element. so, our head should point to the next element.
			return head.data;
		}
		else {
			Node current = head;
			for(int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.data;
			//current.next = current.next.next;
		}
		
		
		
	}
	
	public String toString() { //override
	    String s = ""; //can use a stringbuilder too. it is more efficient
	    Node current = head;
	    s += "[";
	    for(int i=0;i<size;i++){
	        s += Integer.toString(current.data);
	        current = current.next;

	        if(i != size-1){
	            s += ", ";
	            continue;
	        }
	        if(i == size-1){
	            s += "]";
	            return s;
	        }
	    }
	    return s;

}
	
	
	
}
