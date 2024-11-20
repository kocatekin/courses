# Sorting

## Bubble sort

We are using the swap algorithm from the previous code.

In bubble sort, we are comparing element $i$ with element $i+1$, and check whether the smaller one is on the left. If not, we swap.

For that, we need to go through every element several times. At each iteration, we are pushing the largest number on the right.

Lets try: `2,8,5,3,9,4,1`

```java
public static int[] bubbleSort(int[] arr) {
	int n = arr.length;
	for(int i=0;i<n-1;i++){
		for(int j=0;j<n-1;j++){
			System.out.println("Comparing " + arr[j] + " and " + arr[j+1])
			if(arr[j] > arr[j+1]) {
				arr = swap(i,j,arr);
				System.out.println("Swapping " + arr[j] + " and " + arr[j+1]);
			} 
			else {
				System.out.println("No change");

			}
		}
	}
}
```

Although this code works, it is not the most effective version. In bubble sort, we put the largest number on the right at every iteration. Run the code and check it for yourself. First, just add a single for loop where you compare numbers. You will see that we will put the highest number on the rightest side. 

That means, we don't have to check for that number in the following iteration. In the inner loop, we can change the loop to `j<n-1-i`. Because `i` is the number of elements we put as largest. 

```java
for(int i=0;i<n-1;i++){
		for(int j=0;j<n-1-i;j++){
			System.out.println("Comparing " + arr[j] + " and " + arr[j+1])
			if(arr[j] > arr[j+1]) {
				arr = swap(i,j,arr);
				System.out.println("Swapping " + arr[j] + " and " + arr[j+1]);
			} 
			else {
				System.out.println("No change");

			}
		}
	}
```

We decreased the number of iterations here. There is actually something else that we can do.
When you run the code, you will see there are going to be several times where we say there is no *swapping*. If we go through a **whole** iteration without any swaps, it means that the list is sorted. 

It is possible that we can actually get rid of some iterations by adding a boolean variable. 

Let's change the code for it:

```java
public static void bubbleSort(int[] arr) {
	int n = arr.length;
	boolean swapped;

	for(int i=0;i<n-1;i++){
		swapped = false;
		for(int j=0;j<n-i-1;j++){
			if(arr[j] > arr[j+1]) {
				swapped = true;
				arr = swap(j,j+1,arr);
			}
		}
		if(!swapped) {
			System.out.println("no swapping done in this iteration. that means the array is sorted. can exit to reduce the number of iterations");
			break;

		}
	}
}
```

In our first example, we won't see this. If you change the original array to : `2,8,5,3,9,4,1` you will see it happen.

---

We can also apply this by using a **while** loop. For me personally, I see the while loop better to understand for bubblesort.

First, we write our for loop where we compare elements and swap them.

```java
	public static void bubblesort(int[] arr) {
		System.out.println("Arr: " + Arrays.toString(arr));
		System.out.println("-------------------");
		int n = arr.length;	
		
		for(int i=0;i<n-1;i++) {
			if(arr[i] > arr[i+1]) {
				arr = swap(i,i+1,arr);
				System.out.println("Swapped: " + arr[i] + " and " +arr[i+1]);
			}
			System.out.println(Arrays.toString(arr));
		}
	}
```

As you can see here, this for loop is going to run `n-1` times and will end. However, we see from the result that it needs to run couple of times. We actually don't know exactly how many times it should run. We can state it like `n-1` just like we did, but we saw that it *may* be unnecessary. We used `while` when we don't know the iteration number beforehand. So, we need a *condition* for the while to end. 

In the previous solution, we actually saw it. If the for loop **does not** do any swaps, it means that the array is sorted. So, in other words; we understand the array is sorted by going through a **single for loop**. If there are no swaps, that means the array is sorted.

So, here how the code changes:
```java
	public static void bubblesort(int[] arr) {
		System.out.println("Arr: " + Arrays.toString(arr));
		System.out.println("-------------------");
		int n = arr.length;	
		boolean swapped = true;
		int cnt = 0;
		
		while(swapped) {
			//cnt is created to help in the output. we will see that in count 5, we dont have any swap and therefore it ends.
			System.out.println("Count " + cnt);
			cnt++;
			//we want swap to be true in the for loop if happened
			swapped = false;
			
			for(int i=0;i<n-1;i++) {
				if(arr[i] > arr[i+1]) {
					arr = swap(i,i+1,arr);
					System.out.println("Swapped: " + arr[i] + " and " +arr[i+1]);
					swapped = true;
				}
				System.out.println("Iteration " + i + ": " + Arrays.toString(arr));
			}
			n--; //we decrease the number of iterations inthe for loop. remember, in every iteration we were able to put the max element to the right. it also works without this line, but this is an improvement
			
		}
	}
```

---

## Merge Sort

A *divide and conquer* algorithm. It works by splitting an array into *smaller* subarrays, sorting them, and merging them back together. 

1. **Divide:** Split the array in halves recursively until each subarray contains a single element.
2. **Conquer:** Sort the smaller subarrays during the merging.
3. **Combine:** Merge the sorted subarrays.


