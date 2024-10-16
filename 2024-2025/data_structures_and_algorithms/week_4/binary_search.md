# Binary search

Before, we learned about *linear search* and we saw that the worst case scenario is the algorithm running *n* times, *n* being the number of elements in the array we are searching in. We also talked about if the number of elements is too much, it is going to take a *loooong* time to see whether we have the data or not.

There is a better searching algorithm: binary search. Most important thing to remember is binary search only works on **sorted** data. Having a *sorted* data is very important for searches.

We all have mobile phones and we all have *contact list* in them. How do you search for someone? Well, most probably you just *write* the name you are looking for. But before, we had notebooks for our contacts, which is sorted in alphabetical order. You can think of this as *grouping the data*. You group together every name starting with the same first character. 

Imagine that you have a notebook, where there is a name every line, in unsorted fashion. You must look at every line to see whether the person you are looking for is included or not. However, if you group them together by using their first character, than you just have to check their first name and *read* lines of *those* pages. This makes the search much faster.

There are a lot of visualizations to see binary search better. You can check *youtube* or *google* to help you more. In the class, we solved binary search by hand. Now, we are going to write the code for it.

We can implement binary search in two ways: *iteratively* and/or *recursively*. We are going to implement it recursively after we have a course on recursion. For now, we are going to implement it iteratively.

Since we are going to implement it as a *global function* we need to give it the list we are looking in as a parameter. 

```java
public static boolean binarySearch(int x, int[] arr) {}
```

As we remember from the course, we determine a *pivot* (a middle point) and by comparing our term with the pivot, we understand where we should check for the next part. If our data is smaller than pivot, we know that it must be on the left hand side.

However, *left* and *right* terms are meaningful only to us. To computer, we need to give a *start* point and *end* point. These are traditionally called `lo` and `hi`.

So, we are going to have such variables.

```java
public static boolean binarySearch(int x, int[] arr)
{
  int lo = 0; //starting point
  int hi = arr.length - 1; //last index

}
```

Here, when you try to write the code first, you will just write the pivot command and go through it. But here, we know that there is a *loop*. If you remember the difference between *for* and *while* loop, it was the knowledge of iteration number. Here, we know that we are going to be in a loop, but we don't know how many times it will go. Looks like a good use case for while loop.

What we know at this point is, we are going to calculate the pivot, we are going to compare our `x` with the pivot. Let's do it.

```java

...
int hi = arr.length - 1;

int pivot = (hi-lo)/2;
int pivotNum = arr[pivot];
if(x < pivotNum) {
  //look left
}
if(x > pivotNum) {
  //look right
}
if(x == pivotNum) {
  //found the number
  //return
}
```

Okay, we put our comparisons. As stated above, we say *look left* but what do we mean by that. Well, we were looking at the **whole** array. `lo` was 0 and `hi` was the last index of the array. So, if we are looking at the **left** now, what is **lo** and **hi**?

Well, since we are looking at *left*, **lo** is still 0 but **hi** is now **up to** pivot, which means;
```
hi = pivot-1;
```

If the number is on the *right*, we need to change our **hi** and **lo** again.
```
lo = pivot + 1;
hi = arr.length - 1;
```
Why, because we know the value we search is **not** the pivot (if it were, it would return). Therefore, we are searching for elements which are between `pivot+1` and last element. 

So, what now? Okay, it looks like we need to put this in a loop somehow, just as we stated. We cannot do a *for* because we don't know how long this will keep on. The only thing we know is, if we find it, it means we returned; so if we are not returning; it will go on forever. 

For example, we can put this in an empty while loop, and if we have the value in the array, we will eventually get *true*. But if the value is not in the array, it will go on forever!
