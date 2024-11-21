package bubblesort;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		int[] arr = {7,2,1,8,6,3,5,4};
		int pivotLocation = partition(arr,0,arr.length-1);
		System.out.println(pivotLocation);
		
		quicksort(arr,0,arr.length-1);
		
	}
	
//partition here
  public static int partition(int[] arr, int lo, int hi) {
		
		int pivot = arr[hi]; //last element is the pivot
		int i = lo-1; //a pointer for elements smaller than the pivot
		
		//at first, it starts from 0 to hi (last)
		for(int j = lo; j < hi; j++) {
			if (arr[j] < pivot) {
				i++;
				arr = swap(i,j,arr);
			}
			System.out.println("After swap: ");
			System.out.println(Arrays.toString(arr));
		}
		
		arr = swap(i+1,hi,arr);
		System.out.println("Pivot in right location: " + Arrays.toString(arr));
		
		return i+1; //because the pivot is going to be at location i + 1
	
	}

  //quicksort here - can be simplified with a helper function
	public static int[] quicksort(int[] arr, int lo, int hi) {
		if(lo < hi) { 
			int pivotIndex = partition(arr,lo,hi);
			
			//recursively apply it to left and right
			quicksort(arr, lo, pivotIndex - 1);
			quicksort(arr, pivotIndex+1, hi);
		}
		return arr;
	}
		
	public static int[] swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		return arr;
	}
	
}
