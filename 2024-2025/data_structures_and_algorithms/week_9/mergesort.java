package bubblesort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int[] arr = {7,2,1,8,6,3,5,4};
		mergeSort(arr);
		
		
	}
	
	public static void bubblesort(int[] arr) {
		System.out.println("Arr: " + Arrays.toString(arr));
		System.out.println("-------------------");
		int n = arr.length;	
		boolean swapped = true;
		int cnt = 0;
		
		while(swapped) {
			System.out.println("Count " + cnt);
			cnt++;
			swapped = false;
			
		
			for(int i=0;i<n-1;i++) {
				if(arr[i] > arr[i+1]) {
					arr = swap(i,i+1,arr);
					System.out.println("Swapped: " + arr[i] + " and " +arr[i+1]);
					swapped = true;
				}
				System.out.println("Iteration " + i + ": " + Arrays.toString(arr));
			}
			n--;
			
		}
	}
	
	//---------------------------------------------------------
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
	
	
	public static int[] mergeSort(int[] arr) {
		
		if(arr.length <= 1) {
			return arr;
		}
		
		int n = arr.length;
		//divide the array into two halves
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[mid];
		
		for(int i=0;i<mid;i++) {
			left[i] = arr[i];
		}
		System.out.println("Left: " + Arrays.toString(left));
		
		int j = 0; 
		for(int i=mid;i<n;i++) {
			right[j] = arr[i];
			j++;
			
		}
		System.out.println("Right: " + Arrays.toString(right));
		/*
		 * the part above can also be implemented
		 * by using Arrays.copyOfRange(arr,0,mid)
		 * Arrays.copyOfRange(arr,mid,n)
		 */
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right);
			
	}
	
	public static int[] merge(int[] left, int[] right) {
		
		System.out.println("Merge function is running...");
		
		
		//create new array
		int[] merged = new int[left.length + right.length];
		//variables as pointers for left, right and merged
		int i = 0;
		int j = 0;
		int k = 0;
		
		// Compare elements from both arrays and add the smallest to the merged array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k] = left[i];
                k++; i++;
            } else {
                merged[k] = right[j];
                k++; j++;
            }
        }

        // as long as there are elements in the left -- 
        while (i < left.length) {
            merged[k] = left[i];
            k++;
            i++;
        }

        // as long as there are elements in the right
        while (j < right.length) {
            merged[k] = right[j];
            k++; j++;
        }
        
        
        System.out.println(Arrays.toString(merged));
        return merged;
	}
	
	
	
}
