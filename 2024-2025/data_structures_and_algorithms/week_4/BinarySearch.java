
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
		
		int i = 0;
		
		while(lo<=hi) {
			i++;
			System.out.println("iteration " + i);
			int pivot = lo + (hi-lo)/2;
			int pivotNum = arr[pivot];
			
			if(x < pivotNum) {
				
				hi = pivot-1;
				pivot = (hi-lo)/2;
			}
			else if(x > pivotNum) {
				lo = pivot + 1;
				pivot = (hi-lo)/2;
			}
			else {
				return true;
			}
				
		}
		return false;
		
	}
	
	

}
