# Queue


QUEUE -> FIFO (First in First Out)

Later, we are going to use Queue (like Stack) for tree traversal. However now, we are just learning how to use it. 
If you remember, we gave the example of a *ticket booth*. A *waiting line* is a good example for a queue. Whoever gets in the line first, gets the ticket first! A *buffer* is also a good way to visualize the queue. Imagine that a party wants to communicate with another, but the destination is busy. All the messages coming from the *source* would be lost. Therefore, we store them in someplace (buffer) so that when the destination is no longer busy, they can `pop()` the first item in the buffer and act on it.

Stacks and queues are also referred to as ADT (Abstract Data Types). We talked about these in depth in the class. Stacks and queues are ADT because there are multiple ways to implement them. When we implement them, they become the *data structure*. Here, for the beginning we are implementing them by using arrays. However, this is not fully correct and our implementation is not perfect. Later, we are going to implement them again using lists. Stacks and queues are generally *dynamic* unlike arrays, which are static. Of course, we can control the capacity.

In addition, these *data structures* or *abstract data types* are already in the programming language. Most of the languages have this, except C. Therefore, you can easily check the implementation and interface of these in the programming language we use, Java. There, you would see that the *queue* and *stack* are **interfaces** and we can choose the implementation method: *arraylist* and *linkedlist*.

Check out: https://docs.oracle.com/javase/8/docs/api/?java/util/Queue.html

In this page you will see that Queue is an **interface**. 

So, we are implementing Queues using arrays just as a practice to better understand how queues work. As stated before, we imagine a *line* and the line has a **front** and a **rear**.

```java
class Queue {

int[] arr;
int front;
int rear;
int size;

public Queue(int x) {
  arr = new int[x];
  front = 0;
  rear = -1;
  size = 0;
}
```

Later, we go on to add the methods. To make it basic, we just put `add` and `remove`, following the Java way.

```java
public int remove() {
  int item = arr[front];
  front++;
  size--;
  System.out.println("removed " + item);
  return item;
}

public void add(int x) {
  rear++;
  arr[rear] = x;
  size++;
  System.out.println("added " + x);
}
```

Of course, we are not utilizing the array fully. We can add more stuff to do it. For now, we don't need that but if you are curious, let me know.
Here, we also need to add `isEmpty()` and `isFull()` methods. You can write them by using the `size` variable on your own. Check out the *stack* code for help.
