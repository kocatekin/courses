package pckg;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		int[] myarr = new int[20];
		for(int i=0;i<myarr.length;i++) {
			Random rnd = new Random();
			int sayi = rnd.nextInt(2,100);
			myarr[i] = sayi;
		}
		
		System.out.println(Arrays.toString(myarr));
		//int idx = getMin(0, myarr);
		//System.out.println("Minimum elm: " + myarr[idx] + " with index of " + idx);
		
		int[] sorted = selectionsort(myarr);
		System.out.println("LAST:" + Arrays.toString(sorted));
		
		
		
		
	
	}
	
	
	public static int[] swap(int a, int b, int[] arr)  {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		return arr;
	}
	
	
	
	public static int getMin(int start, int[] arr) {
		//we can return the minimum number or we can return the index of the minimum number
		//here we need the idx
		
		int min = arr[start];
		int minindex = start;
		for(int i=start;i<arr.length;i++) {
			if(arr[i] < min) {
				min = arr[i];
				minindex = i;
			}
			start++;
		}
		return minindex;

	}

	
	public static int[] selectionsort(int[] arr) {
		
		System.out.println("Starting sorting: " + Arrays.toString(arr));
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("Iteration: " + i + Arrays.toString(arr));
			int minidx = getMin(i,arr);
			arr = swap(i,minidx,arr);
		}
		return arr;
		
		
	}
	
	


}
