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

---

# Infix, Prefix, Postfix

In our mathematics life, we do calculations as such: `(2+3)*4`. This is called **infix** notation. Because the *operation* is between the operands (numbers). We also have *prefix* and *postfix* notations. The *prefix* notation is also called **Polish notation**, **Lukasiewicz notation** or **warsaw notation**. The name comes from **Jan Lukasiewicz** who invented it, a Polish mathematician/logician. 

In the *infix* notation, the equation `3+4` would be written as `+ 3 4` in *prefix* notation. We call it as such because the operation comes *before* the operands. 

Later, we are introduced to *Reverse Polish Notation* (RPN) or *postfix* notation. Here, the operations follow the operands, so the previous example becomes `3 4 +`. Here, we can eliminate the parenthesis if we make sure every operation has a fixed number of operands. In computer science, this notation is used in *stack-oriented programming languages* such as Forth, PostScript, etc. 

## RPN

When we are doing calculations, we know the importance of precedence. So we know which operation comes first, we know we need to calculate whatever is in the parentesis, etc. However, computers doesn't know that. And although this can be put in an algorithm, it is much easier if we are able to use RPN. So, a well known pioneer in CS, Edsger W. Dijkstra invented *shunting-yard algorithm* to convert **infix** into **postfix** expressions. 

To make an example in the class, we are going to use our own stack data structure to calculate a postfix expression. We are not going to implement the *shunting-yard algorithm*, we can do it later in the course. So, we will write our program to make some examples.

For that, we are going to create a *solver* function.

```java
public static void solveRPN(String islem) {
    //lets do it void for now, we can change it at last
    Stack stack = new Stack(100); //arbitrary number
    String[] params = islem.split(" ");
    for(int i=0;i<params.length;i++) {
        //if the character is an operation, we are going to apply it
        //if the character is not an operation, we are going to push it  
    }

}
```

So now, we need to have a function where we actually check whether the element we have in the string array is an operation or not.

```java
public static boolean isOperation(String x) {
    return x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/");
}
```

So, we can add this in the for loop and if the character is an operation, we are going to *pop* two numbers from the stack and apply the operation. So now, we need another function to **apply** the operation. Let's call it *doOperation*. This is going to get multiple parameters. It needs numbers and the operation. 

```java
public static int doOperation(String op, int a, int b) {
    if(op.equals("+")) {
        return b+a;
    }
    else if(op.equals("*")) {
        return b*a;
    }
    else if(op.equals("/")) {
        return b/a;
    }
    else if(op.equals("-")) {
        return b-a;
    }
    else {
        System.out.println("no such operation");
        return -1;
}
}
```


So now, we know these: If the character is **not** an operation (+,-,*,/) we assume it is a valid number and add it to the stack. If it is an operation, we **pop** two values, **do** the operation and push it to the stack. The code becomes:

```java
public static void solveRPN(String islem) {
    Stack stack = new Stack(100);
    String[] x = islem.split(" ");
    for(int i=0;i<x.length;i++){
        if(!isOperation(x[i])) {
            stack.push(Integer.parseInt(x[i])); //change to integer
        }
        else {
            //it means it is an operation
            int a = stack.pop();
            int b = stack.pop();
            //we need to do an operation and add it to stack
            stack.push(doOperation(x[i], a, b));
        }
    }
    System.out.println(stack.pop()); //to see the last result, because we are returning void
}
```

You can try this code with the following examples:
`10 2 / 3 -` should return 2
`5 1 2 + 4 * + 3 -` should return 20
`6 3 /` should return 2
`2 3 + 4 *` should return 20


A good practice can be to write a test function to yourself and run that test function. You need to turn the *void* into *int* and create your own test function. After that, you can try to do it in Junit.

---

A somewhat visual example can be found at:
https://kocatekin.github.io/apps/stack.html




