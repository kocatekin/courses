# LIST

What is a list?

* An ordered *collection*. Ordered. Keep the order you added elements.
* Also known as *sequence*
* Indexed like arrays. You can access specific elements in a specific index.
* Can hold *duplicate* values. (In sets, we are not able to do it)
* User can iterate through the elements and **add**, **remove** and **update** elements.

It is an **interface**. So, there are multiple implementations. In Java, one can implement a list using *ArrayList*, *LinkedList* and *Vector*. 

```java
List<String> fruits = new ArrayList<>();
List<String> animals = new LinkedList<>();
```

# Arraylist

An arraylist is different from an array. This is a good time to remember that arrays are **static*. That means the capacity doesn't change. However, we can change the elements in the array by their index. In addition, since arrays are static and *contiguous*, if we know the first element address, we can easily get the $n$th element by adding $n$ to that address. 

Arraylist is a *resizable* array in Java. In arrays, we cannot **add** or **append** elements to it, but in Arraylist we can add and remove elements. Arraylist can dynamically grow and shrink in size. It is already available in Java. Here is how we use it:

```java
ArrayList<String> names = new ArrayList<>();
names.add("Harry");
names.add("Ron");
String name = names.get(0) //access element 0
names.set(1, "Hermione"); //can update elements
names.remove(1); //can remove element by index
names.size() //returns the number of elements
```

If you remember, we cannot directly print out an array. However, we can do it with an ArrayList. We can also use *foreach* and *for* loop too.

When we are writing programs, we are going to use ArrayLists a lot. 

Again, just like we did in previous examples; we are going to implement an ArrayList on our own. 

Remember that it is implemented by using an array. This is done for the speed, because accessing elements in an array is very fast.

We are only going to implement an ArrayList with an *int* data type. As we mentioned before, we can use **generics** to make it possible for every type. Please try it by yourself.

---

## Implementation

So how are we going to implement this? We said we are going to use arrays, but arrays are static. ArrayList is dynamic. So, how can we do it? Well, we are going to create a new array everytime the array is full! 

So, in every `add` we are going to check whether the array is full or not. If full, we will call a `resize()` function. If it is not full, it will just work the same. The resize function will create an array of double capacity, and copy the previous array into the new array. That means we will have the same available capacity now.

The problems arise when we want to remove elements from the list. Now, remember that we are using *arrays*. That means actually we are **not** removing anything. In previous implementation of *queue*, we did not deal with *shifting* the array elements. As a result, we have seen that our capacity is dramatically reduced. That is why, now we are going to shift the array. 

This can be a little confusing, so we are going to go step by step. 

Let's say our initial capacity is 10. As we know, when we create an array of length 10, it will initialize the array where elements are 0 in the case of `int arrays`. 

So, our list is at first: `[0,0,0,0,0,0,0,0,0,0]`.

Let's say we added couple of elements and the list is:
`[3,6,7,1,3,4,6,0,0,0]`

We are going to remove elements by their index. So, if we say `remove(1)`, we are going to remove **6** from the list. Now, what does removing mean? Well, before removing, if I call `get(1)`, I will get 6. After removing, if I call `get(1)`, I should get **7**.

Since this list is implemented as an array, I am going to directly try and access the array elements. That means that **7** must be moved to location 1. However, it is not only 7. Every element after **6**, should be shifted 1 left. 

How can we do this shift? Well, before getting into this specific example, lets try to do it on an arbitrary array. So, let's say that our array is `{1,2,3,4,5}`. I want to shift all elements 1 position left. So it will become: `{2,3,4,5,?}`. Now, there is a problem. What will happen to the last element? If we are doing a **circular shift**, it will be 1. Because 1 will come at the tail. If we did not say anything, we actually are not going to care. 

```java
for(int i=0;i<arr.length;i++) {
    arr[i] = arr[i+1];
}
```

Let's try to run it. Well, it doesn't run. Because $i$ will go up to 4. So the expression in the for will be `arr[4] = arr[5]`. Well, we don't have `arr[5]`. So, we are going to change the for loop a little bit.

```java
for(int i=0;i<arr.length-1;i++){
    arr[i] = arr[i+1];
}
```

This works. Our array is now: `2,3,4,5,5`. What happened though? The last element is still the same. 

Now, in our case, in the arraylist example, this is **not** a problem. Why? Because we keep track of the **size**. Remember the original implementation. When we printed the list, did we see all the empty 0's? No. Why, because the print function only works **up to** the size. Therefore, I am only going to be able to reach up to size. After that, I don't care what is in the array whether it is 0 or not.

So, let's go back to our shift for the arraylist.

`[3,6,7,1,3,4,6,0,0,0]`
We call `remove(1)`. The new array will be:
`[3,7,1,3,4,6,6,0,0,0]`. 

It looks like there is an additional 6. Yes, there is. However, it does not concern us. Because we are going to **decrement** the `size` and we will never let the user see that additional 6. Therefore, it doesn't matter. Just like all the 0's at the end.

So, let's write the `remove` method.

```java
public int remove (int index)
{
  if(index < 0 || index >= size) {
    System.out.println("index out of range");
  }
  int removedElement = data[index];

  //shift elements 
  for(int i=index;i<size-1;i++){
    data[i] = data[i+1];
  }
size--;
return removedElement;
}
```

As you can see here, in the for loop we start from the `i=index` and we go up to `i<size-1`. Just between that range, we shift the array. We are not doing it for the whole array. Later, we decrement the size. We return the deleted element. It is up to us, we can choose not to do it too.


---


So, when we want to add something, we are going to check whether the list is full. If it is not full, we are going to change that index. If it is full, we are going to `resize()`, which means we are going to create a new array and copy the previous into the new one.

```java
class ArelArrayList {
  int[] data;
  int size;
  int capacity = 10;

public ArelArrayList() {
  data = new int[capacity];
  size = 0;
}

public void add(int element){
  if(size == data.length) {
    resize();
  }
  //here we dont have an else. why not? think on it.
  data[size] = element;
  size++;
}

public void resize() {
  int newCapacity = data.length * 2; //doubling is a standard
  int[] newData = new int[newCapacity];
  for(int i=0;i<size;i++){
    newData[i] = data[i];
  }
  data = newData;
}

public int get(int index) {
  if (index < 0 || index >= size) {
    System.out.println("index out of bounds")
    }
  return data[index];
}

public int remove (int index)
{
  if(index < 0 || index >= size) {
    System.out.println("index out of range");
  }
  int removedElement = data[index];

  //shift elements
  for(int i=index;i<size-1;i++){
    data[i] = data[i+1];
  }
size--;
return removedElement;
}

```
