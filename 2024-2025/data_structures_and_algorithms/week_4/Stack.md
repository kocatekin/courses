# Stacks

Stacks and queues are both ADT's (*Abstract Data Types*) and Data structures.

When we talk about ADT's, we talk about *interfaces*. We say the problems and the ways to solve them, but we don't give any implementation details.

Data structures are our *solutions*, *implementations* to the problem at hand.

Let's start with Stack. There are multiple ways to use Stacks. In due time, we will talk about different usages of it. For now, we are going to give some general information and talk about the implementation of it, using *arrays*. Later on, we may implement them with the new data structures we will learn along the way.

Stacks can be visualized vertically.
```
| |
| |
|_|
```

The easiest way to visualize them is using real life examples. For example, number of plates on top of each other. In addition, another good example can be the clothes we fold. We fold each shirt and put it on top of another folded shirt. 

The thing we need to see here is, we can only see the **top** shirt, or **top** plate. And if we want to reach an element, we need to remove the top element step by step to see it. This is how a stack works.

In general, we have **two** operations, or two **crucial** operations: `pop()` and `push(x)`.

`pop()`, returns the top element and removes it  from the stack.
`push(x)`, adds the element `x` to the top of the stack.

Remember, in stacks we only control the top element. We add to top, and we remove from the top. This phenomenon is also called **LIFO**. 

## LIFO 

This term is short for *last in first out*. Imagine this scenario. We have an empty stack and we are given these operations:

```
push(4)
push(5)
pop()
```

First, we add 4 to the stack. At the bottom (and the top, because it is the *first* element), we have 4. Later, we see `push(5)`. So, we add 5 on **top of** 4. Then, we see `pop()`, so we are going to remove the top element, which is 5. If you remember, that was the **last** element we pushed to the stack!

Of course, we may have some additional methods on the stack, such as `isEmpty()`  and `isFull()`. We can also keep track of the **size** of the Stack, to learn the number of elements in it.

In Java, when we want to build our own data structure, we are going to use a Class for it. If we were to use C, C++ or Go languages, we could use **struct**, instead of class. However, the logic is the same.

In OOP, remember that we need to define our *global variables* first, so that the methods can reach them. After that, we have the constructor and we have methods. For this course, we are always going to use *public* keyword, just to be free from the hassle of creating *getters* and *setters*.

Lastly, there are multiple ways to implement a Stack. We can use an *array*, we can use a *linkedlist*, or we can use an *arraylist*. Since at this point, only thing we know is *arrays* we are going to use them to implement. 

Here is the structure:

```java
int[] arr;
int size;
int top;

public Stack(int x){
    //constructor
    //gets x, it will give us the capacity of stack
} 

//methods
public int pop() {

}

public void push(int x){

}

public boolean isEmpty() {

}

public boolean isFull() {

}
```

Here, we gave our four basic methods. We are going to use methods in each other too. For example, we don't want to try and pop something if the stack is empty - or we don't want to push something if it is at full capacity!

When we write the code, we can start from just pop and push. They will just write. Later we ask for the problem. The problem will be, what happens when stack is full or empty?

how do we understand if it is empty or full? we can check the top value? or we can check the size?

