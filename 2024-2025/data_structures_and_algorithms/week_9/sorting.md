# Sorting

## Information

When I am uploading the code, I am using the wrong name most of the time. For example, if you look at the first line of the `quicksort.java` it will write `package bubblesort` and `public class Main`. Therefore, if you try to copy paste it all, it won't work. Please try to find a workaround to that. If you are not able to do it, it is bad.

---

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

## Quick Sort

In quick sort, we need to choose a **pivot**. We can choose any element we want here. It doesn't necessarily have to be the middle element. Most of the time, it is going to be in the wrong position. So, first we need to find the right position for the pivot element. That is called **partioning** because when we put the pivot in the place, it means that we partitioned the array into *left* and *right* parts, where all the elements in the *left* is smaller than the pivot; and all elements in the *right* are larger than pivot. 

Later, we apply the same to each subpart recursively and find the sorted array.

`7,2,1,8,6,3,5,4` Lets choose 4 as pivot.

We need to pointers. These are going to point to the elements. Lets call them **lo** and **hi**, just like in binary search. 

hi is going to show the last index in the array. lo is going to show the first, at first.
We also have *i* where `iptr = lo - 1`

First, we are going to go from 0 (lo) to last element (hi); and compare elements. If the element is larger than pivot, we don't do anything and continue. If the element is **smaller** than pivot, we increment `i` and do a swap between `i` and `j`.

After that, when we finish all, the pivot is going to be at location `i+1`.

```java
public static int partition(int[] arr, int lo, int hi){
	int pivot = arr[hi]; //selecting last element as pivot
	int i = lo-1; //pointers for elements smaller than pivot

	for(int j = lo; j < hi; j++){
		if(arr[j] < pivot) {
			i++;
			arr = swap(i,j,arr);
		}
		System.out.println("After swap: " + Arrays.toString(arr));
	}

	//put the pivot in the right place --> hi was our pivot location, we swap it with i+1.
	arr = swap(i+1,hi,arr); 
	System.out.println("Pivot in right location: " + Arrays.toString(arr)); //2,1,3,4,6,7,5,8

	return i+1; //because the pivot is not going to be at i, but next to i.
}
```

So, we expect to see the pivot's location returning from this function.
When we run it for `{7,2,1,8,6,3,5,4}` we get **3** in return. Which means we are going to put it at that location.


So now, we have the pivot at the right place. It means that whatever we have on the left side is going to be smaller than pivot. Whatever we have on the right side, is going to be larger than pivot. 

Now we need to add our *quicksort* algorithm. 

This algorithm is going to apply itself to the left and right part.

We have something similar to *binary search* here. Remember that in each part, we are going to select a pivot. So again, we have *left* and *right* parts, but we need to define them by using *lo* and *hi*. 

So, our left is going to be from *lo* to *pivotindex-1* and our **right** is going to be from *pivotindex+1* to *hi*.

```java
public static int[] quickSort(int[] arr, int lo, int hi){
	if(lo < hi) {
		int pivotIndex = partition(arr, lo, hi);

		//left and right
		quickSort(arr, lo, pivotIndex-1);
		quickSort(arr, pivotIndex+1,hi);
	}
	return arr;
}
```

---


## Merge Sort

- Usually done recursively. Found by John Von Neumann.
- Divide and conquer
	- Divide it into smaller parts.

```
2,8,5,3,9,4,1,7

2,8,5,3    9,4,1,7

2,8   5,3   9,4   1,7

2  8  5  3  9  4  1  7
```

After that, we start going up.

```
2,8   3,5   4,9   1,7
```

After that we go up again:

```
2,3,5,8   1,4,7,9
```

We do it again;

```
1,2,3,4,5,7,8,9
```

So we see that at the start, we need to divide the array into two halves.

```java
public static int[] mergeSort(int[] arr){

	int n = arr.length;

	int mid = n/2;
	//we will have two arrays on left and right
	/*
	int[] left = Arrays.copyOfRange(arr,0,mid);
	int[] right = Arrays.copyOfRange(arr,mid,n);
	*/

	//lets do it the manual way
	int[] left = new int[mid];
	int[] right = new int[mid];

	//fill the left
	for(int i=0;i<mid;i++){
		left[i] = arr[i];
	}

	//fill the right
	int j = 0;
	for(int i=mid;i<n;i++){
		right[j] = arr[i];
		j++;
	}
}
```

At this point, we are able to halve the arrays into two parts, *left* and *right*.
We need to do this recursively.

So, 
```java

left = mergeSort(left);
right = mergeSort(right);
```
At this point, if we run the program we will encounter an error. Yes, we did not put a return but it is simple. Just add `return arr`, the error is something else. The error is, the program will try to run forever and at some point we need to stop. Remember, it was called the **base case**. You will see the base case when you run the code like this.

To solve that problem, we need to end the program when the *length* of the array is 1 or smaller. 
So on top, we add
```java
if(arr.length <= 1){
	return arr;
}
```


At this point, our *mergeSort* code becomes:
```java
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
		
	return arr;
			
	}
```


Okay, we did the first part. We divided the array into halves recursively. We need to *merge* it eventually. That is why, our return will change from `return arr` to `return merge(left, right)`. Remember, we divide the array and then we *merge* it by sorting. Now, we are going to write the `merge` function.

Here, we are going to **compare** the elements of the array.
We need three pointers for that. i, j and k. Why? 

Well, we are *comparing* arrays to *i* will be a pointer for one array, *j* will be a pointer for another. *k* on the other hand will be a pointer for our final *merged* array. Remember, we are going to return *an* array, and it will be the **merged** one. So first, lets create the merged array.

```java
public static int[] merge(int[] left, int[] right){
	int[] merged = new int[left.length + right.length];
	int i=0;
	int j=0;
	int k=0;
}
```

Then we start comparing. 
We have two arrays to compare: left and right.
```java
//as long as we are in the array - we compare elements of left and right
while(i < left.length && j < right.length) { 
	
	//compare left and right array
	//if left is smaller, add left to merged -- else, add right to merged
	if(left[i] <= right[j]) {
		merged[k] = left[i]; 
		k++; i++; 
	}
	else {
		merged[k] = right[j];
		k++; j++;
	}
}

//there are still elements in the left and right
	while(i < left.length){
		merged[k] = left[i];
		k++; i++;
	}

	//add remaining elements on the right
	while(j < right.length){
		merged[k] = right[j];
		k++; j++;
	}
	return merged;
```
