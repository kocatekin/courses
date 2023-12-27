//wont run as is. change the name to main.java

package twodarray;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("size: ");
		int size = sc.nextInt();
		//sc.close();
		
		int[][] matrix = new int[size][size];
		for(int i=0; i < size; i++) {
			for(int j=0; j < size; j++) {
				System.out.println("Enter data: (" + i +"," + j + ")" );
				int temp = sc.nextInt();
				matrix[i][j] = temp;
			}
		}
		System.out.println("Filled!");
		String res = neighbors(2, matrix);
		System.out.println(res);
		
	}
	
	//no error handlings
	//giving the array as an arg. if we dont want to do it, we should init the array
	//on top, before the main. to make it global to all functions
	public static String neighbors(int idx, int[][] arr) {
		System.out.println("Getting the neighbors of : " + idx);
		String res = "";
		for(int i=0;i<arr.length; i++) {
			if(arr[idx][i] == 1)
			res += Integer.toString(i) + ",";
		}
		return res;
	}

}
