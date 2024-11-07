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



So, we need some functions here.
First, we need a function to swap.

```Java
public static void swap(int a, int b, int[] arr) {
  int temp = arr[a];
  arr[a] = arr[b];
  arr[b] = temp;
}
```
