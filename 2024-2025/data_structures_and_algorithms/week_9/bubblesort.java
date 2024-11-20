package bubblesort;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		System.out.println("Bubble sort");
		int[] arr = {2,8,5,3,9,1,4};
		bubblesort(arr);
		
	}
	
	public static void bubblesort(int[] arr) {
		System.out.println("Arr: " + Arrays.toString(arr));
		System.out.println("-------------------");
		int n = arr.length;	
		boolean swapped;
		
		for(int i=0;i<n-1;i++) {
			swapped = false;
			for(int j=0;j<n-1-i;j++) {
				System.out.println("Comparing " + arr[j] + " and " + arr[j+1]); 
				if(arr[j] > arr[j+1]) {
					arr = swap(j, j+1, arr);
					System.out.println("Swapping " + arr[j] + " and " + arr[j+1]);
					System.out.println("Arr: " + Arrays.toString(arr));
					swapped = true;
				}	
			}
			if(!swapped) {
				System.out.println("no swaps in this iteration. that means the array is sorted");
				break;
			}
		}
		System.out.println("Arr :" + Arrays.toString(arr));
		}
		
	
	
	public static int[] swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		return arr;
	}

}
