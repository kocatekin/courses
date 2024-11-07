# Selection sort


There are multiple ways to sort a list or array. Here, we are going to implement selection sort. You can find countless implementations of it, I will try to do something different, which aims to show that there are multiple ways to solve a problem. Although the underlying principles are the same, the code can be different.

Here, this is our goal:
In a given list, we want to find the minimum number and put it in the beginning of the list.
Let's say our list is: {6,4,8,2}

### Iteration 0

Find the minimum number of the list and swap it.
min_number = min(6,4,8,2)
swap(0, min_number) --> since this is our first iteration, we are going to put the first element. 
arr becomes 2,6,4,8

### Iteration 1 


min_number = min(6,4,8) --> Remember that in the first iteration, we got the min (2), and swapped it. I know that it is the minimum so I am not going to check it.
swap(1, min_number)
arr becomes 2,4,6,8

At this point, you can realize that we are actually swapping the *iteration count*.

### Iteration 2


min_number = min(6,8)
swap(2, min_number)
arr becomes 2,4,6,8 

### Iteration 3

Self explanatory!



So, we can create a bird-eye view of the program.



```
public static int[] selectionSort(int[] arr)
{
  for(int i=0;i<arr.length;i++) {
    int min = getMinimumIndex(i, arr);
    arr = swap(i,min,arr);
  }
  return arr;  
}
```

That is apparently what we need here. In this approach, for every step we need to find the minimum number. Later, we want to swap it with the element in the right order. So, we need to functions: `swap` and `getMin`.
Here, when we are writing the `swap` function, we are going to think in terms of *indexes*. Otherwise we cannot swap numbers, because it is possible that an array can have duplicate elements. 


```Java
public static int[] swap(int a, int b, int[] arr) {
  int temp = arr[a];
  arr[a] = arr[b];
  arr[b] = temp;
  return arr;
}
```

We use a temporary value to swap elements. It will get three inputs, two indexes and the array we want to operate on. We are writing a global function, that is why instead of dot notation we are putting the array as a parameter. This swap function will return us the swapped array.

Next, we want to do the `getMin` function.

```java
public static int getMin(int start, int[] arr) {
  int min = arr[start];
  int minindex = start;
  for(int i=start; i<arr.length;i++) {
    if(arr[i] < min) {
      min = arr[i]; //min element
      minindex = i; //get the index of the min element
}
  return minindex;
```

The reason we give another *start* parameter is that we don't want to find the **min** of the same array. By adding a start parameter, we can change our for loop's starting point, making it possible to find the minimum element of **a section** of an array. Remember in the binary search we were using two pointers `hi` and `lo` for a similar purpose.

From the general algorithm, we can see that every iteration is actually done for that specific iteration index. Therefore, we can swap the iteration count with the index of the minimum element of the remaining array.

So now, our original `selectionSort` function becomes:

```java
public static int[] selectionSort(int[] arr)
{
  for(int i=0;i<arr.length;i++) {
    int minidx = getMin(i, arr);
    arr = swap(i, minidx, arr);
    }
return arr;
}
```

