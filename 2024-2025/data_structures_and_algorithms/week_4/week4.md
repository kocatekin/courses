# Stacks and Queues

Before, we talked about FIFO and LIFO. Remember that these are *First in First Out* and *Last in Last Out*. 

When we talk about queue, one of the main examples is a *ticket queue*. Imagine that you want to buy a movie ticket. The gate is closed and people are starting to create a queue, waiting for the ticket gate to be opened. Who is going to buy the first ticket? Whoever came first! So, a *queue* is *first come first serve*. Of course, when you get your ticket, you are going to go out from the queue. So, FIFO.

Like stack, the main operations here are `pop()` and `push(x)`. As a difference, we call them `dequeue()` and `enqueue()`, specific to queue. But the logic is the same. 

Stacks and queues are also called ADT (Abstract Data Types). If we remember, when we say *data structure* we take implementation details into consideration. Since there are *multiple* ways to implement a stack and queue, we call them ADT. Today, we are going to implement them by using a *static array*. However, later we can simply implement them by using an *arraylist* or a *linkedlist*. Or, as a fun project; you can even implement a stack **using** a stack! This goes the same for the queue.

So here, we are going to implement a queue with a static array. Now at this point, the question arises: If we are using an array, why are we bothering with a queue? We can just put data in a container and write a function.

Exactly. You can write the code we'll write everytime you need such a thing. But remember, in an array you can *reach* and *update* objects, where in a stack and queue you can only **do operations** on the **top** element. Since this is our own data structure, we control how someone can reach this data. In an array, the *implementation* of array lets us do certain things. But here, we can eliminate that control. The implementation is ours and we are in control. This also eliminates possible errors which can come due to carelessness.

Now, let's try to implement this Queue. 
For that, we need to create a new class. Remember that since we are working with Java, we don't have `struct` keyword. We are going to build a class to have our data structure.

First, we need to have an array.
We are going to declare this array as a global variable, so the class methods can reach it. We also need to keep track of a **top** value, so that we know where we are going to `push()` to, or `pop()` from.

```java
int[] arr;
int top;

public Queue(int x) { //takes a constructor to init the array
  arr = new int[x];
  top = -1;
}

public void push(int x) {}
public int pop() {}
```

Here, we are making the `top` variable -1. This is not the only solution, this is my approach. 
Here, when we `push()`, we will increase the `top` by one, so that we are adding to location 0. 

Let's fill in the other methods. 

```
public void push(int x) {
  top++;
  arr[top] = x;
  System.out.println("added " + x + " to queue.");
}

public int pop() {
  int temp = arr[top]; //get the top value to a variable
  top--;
  System.out.println("removed " + temp + " from the queue.");
  return temp;
}
```

Again, these methods can be written differently. Here, we are creating a temporary variable, because we need to decrement the `top`. This is a clear way to see what happens.

Up to this point, everything should work. However, we forgot something. Here, we are using an *array* and as we know, arrays are *static*. Which means that after some point, the queue is not going to add another element. What happens when we try to add something? Try and see for yourself!

```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
```

Therefore, we need to check whether the queue is **full** if we are trying to add something. Also, we need to check whether the queue is **empty** when we are trying to *pop* something. For that reason, we will add `isFull()` and `isEmpty()` methods.

```java
public boolean isFull() {}
public boolean isEmpty() {}
```






