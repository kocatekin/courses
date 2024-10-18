
public class BinarySearch {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i] = i;
		}
		
		System.out.println(binarysearch(-1,arr));
		
	}
	
	public static boolean binarysearch(int x, int[] arr) {
		//assume the array is sorted
		int lo = 0;
		int hi = arr.length - 1;
		
		int iter = 0;
		
		while(lo<=hi) {
			iter++;
			System.out.println("iteration " + iter);
			int pivot = lo + (hi-lo)/2;
			int pivotNum = arr[pivot]; //to make it easier
			
			if(x < pivotNum) {
				hi = pivot-1;
				pivot = lo + (hi-lo)/2;
			}
			else if(x > pivotNum) {
				lo = pivot + 1;
				pivot = lo + (hi-lo)/2;
			}
			else {
				return true;
			}
				
		}
		return false;
		
	}
	
	

}
