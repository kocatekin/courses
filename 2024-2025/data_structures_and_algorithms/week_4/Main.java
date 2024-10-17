public class Main {

	public static void main(String[] args) {
		String islem  = "10 2 / 3 -";
		solveRPN(islem);
	}
	
	
	public static void solveRPN(String islem) {
		Stack stack = new Stack(100);
		String[] x = islem.split(" ");
		for(int i=0;i<x.length;i++) {
			if(!isOperation(x[i])) {
				stack.push(Integer.parseInt(x[i]));
			}
			else {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(doOperation(x[i],a,b));
			}
		}
		System.out.println(stack.pop());		//since the function is void we need to show something
	}
	
	//we need to check whether something is an operation
	public static boolean isOperation(String x) {
		return x.equals("+") || x.equals("-") || x.equals("/") || x.equals("*");
	}

  //to do the operation
	public static int doOperation(String x, int a, int b) {
		if(x.equals("+")) {
			return b+a;
		}
		else if(x.equals("*")) {
			return b*a;
		}
		else if(x.equals("/")) {
			return b/a;
		}
		else if(x.equals("-")) {
			return b-a;
		}
		else {
			System.out.println("wrong operation");
			return -1;
		}
	}
