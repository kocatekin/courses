# LIST

What is a list?

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

So how are we going to implement this? We said we are going to use arrays, but arrays are static. ArrayList is dynamic. So, how can we do it? Well, we are going to create a new array everytime the array is full!  

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









