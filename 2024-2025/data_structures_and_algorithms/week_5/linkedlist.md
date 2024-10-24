# LinkedList

It is a **dynamic** data structure. It means that you can change the size, etc but the data in the memory is **non-contiguous**. 

There are several LinkedLists:
* Singly Linked List
* Doubly Linked List
* Circular Linked List

Like ArrayList, LinkedList also implements the List interface. Therefore, the user can *add* items, *remove* items and *update* them. However, the implementation of LinkedList is much different than ArrayList. Remember that in the ArrayList, we were using static arrays. Here, we are not doing it.

Linked list is a data structure consisting of a collection of **nodes**, which together represent a sequence. A node stores *data* and a *reference* (or link) to the next node in the sequence. (In C, C++; it stores the *address* of the next node)

All nodes are serially linked. 


* Linked List is a **linear** data structure where elements are stored in **nodes**. Each node points to the **next** node in the sequence.
* Different from *arrays* because they are not stored in **contiguous memory**. There is a **chain**. It is dynamic, can use any memory location available to it. That is why we can add more stuff.
* Since it is **dynamic** it can grow and shrink as needed.
* It is **efficient** in insertion and deletion. Why?
  * Because we are not **shifting** elements. In the ArrayList, since we are using a *static* structure; we need to shift the elements in the array. Otherwise, we would lose capacity. And shifting is an additional process.
 * However, in arrays you can *directly* access to elements. Remember that we can just add the index number to the address of the first element, and we can access instantly `arr[2]`. Here, since they are not stored in *contiguous memory*, we need to go through all previous nodes to get to the node we want. Because every node only holds the address (reference) to the next node.
 * Another small disadvantage is, here we have a *node* which holds a *value* **and** a reference to next node.


Remember that when we want to implement a List in Java, there are several ways to implement it: ArrayList, LinkedList or Vector. For now, we are not interested in vector implementation. We have seen the ArrayList, it is the same:

```java
List mylist = new LinkedList();
mylist.add(4);
mylist.add("hello");
System.out.println(mylist);
```

However, there are much more methods available for LinkedList. You can check them out in your IDE, you will see them when you press `.`. 

Before getting into the code, we need to understand the concepts. For example, we are going to *add an element* and *remove an element by the index*. Remember that each node is going to be in an arbitrary place in the memory. They are not going to be contiguous. Therefore, we are going to go through each element to get to the element we want.

    A -> B -> C -> D

If we want to reach to **C**, we need the *address* of the C. Remember, since we are using Java, we are not using pointers - but the logic is the same. The address of C is **only** known by **B**. Therefore, to get to C, I need to get to **B** first. Well, what is the address of B? The address of B is stored in **A**, which is the **head** at this example. So, to get to C, I need to go through A and B. Therefore, I need to go through the list to get to the point I want. 

When you compare this to arrays (or ArrayList) you can easily see that it is going to be slower. Therefore, **accessing** elements in an Array is **faster** compared to accessing an element in a LinkedList.

## Adding an element to tail

When we are **adding** or **appending** an element to a Linkedlist, we add it to the last. So, let's say we want to add **E**. Well, that means the **D** is going to *show* E. Therefore, when we want to add an element, first we need to get to the last element. Then, we modify the *next* of that element. It was showing **null** before, now it will show **E**.

## Removing an element by the index

The same logic applies here too. First, we get the index from the user. For example, they say `remove(2)`. Our list is `A -> B -> C -> D -> E`. So, we want to remove C. Well, actually we are not **deleting** anything here, unlike arrays. 

**B** was showing **C**. Now, when we remove **C**, where should it show, or refer to? It must show **whatever C was showing**. Therefore, we get to **C** first. We get its **next** and we put it in **B**'s **next**.

In the end, B should show D, instead of C. 

All these explanations are for *singly linked list*. We will talk about the others too, but understanding the *singly linked list* is crucial.

Now, we implemented our *Node*. It will have a value and it will have a part which shows the next node. Therefore, the type of it will be Node. If this is confusing, you should think in this way:

For example when we say `int x = 5` the right hand of the equation is the **type**. So, in the Node class, our `next` attribute is going to be showing a *Node*. That means the right hand side of this will be of that type. In the `int` example, it was an integer, so the type is `int`. Here, the right hand side will be a *node* itself, so the type is `Node`.

So we start creating the linkedlist.

```java
class ArelList {
    Node head;
    int size;
}
```

When we create a list, it must have something to build on. That is why we create a Node called *head* which represent the **head** node. We also have a size to get the size of the linkedlist.

```java
public ArelList() {
    head = null; //there is a node, but it is null. there is no value
    size = 0; //at the start we dont have a size
}

public void add(int data){

}

public void remove(int index){

}
```

This is going to be the structure at first. We are going to add *int* and we are going to remove items **by the index**. So, remember that when we want to add a data, we need to get to the end. What do we mean by **the end**? Well, if there is a node with the attribute `next` showing `null`, that means it is the **last** element. So, in other terms we are going to look for the node which is pointing to **null**.

```java
public void add(int data){
    Node newNode = new Node(data); //we create a new node
    //if there is no element yet, our node will be the head node
    if(head == null) {
        head = newNode;
    }
    else {
        //means there are elements already
        //i need to find the last element
        Node current = head; //i am starting my search
        while(current.next != null){ //if it is showing null, exit.
            current = current.next;
        }
        //at this point if i am out of the loop, that means i found the current showing the null
        //that should not point to null, it should point to my new node
        current.next = newNode;
    }
    size++;
}
```

So, I found the last node. I made it show my new node. 

When we want to remove an item by the index, it is similar:

```java
public void remove(int index){
    //first lets check the index
    if(index < 0 || index >= size){
        //throw an error
        System.out.println("out of bounds");
        return;
    }

    //if we want to remove the first element
    if(index == 0) {
        head = head.next;
        //here, we change the head.
    }
    else {
        //not the first element
        Node current = head;
        for(int i=0;i<index-1;i++) { //here, we are going to loop until we are at the index.
            current = current.next; //moving through the list
        }
        current.next = current.next.next; //B.next will be C.next (C is b.next -> b.next.next)
    }
    size--;
}
```

Later, we want to see what we have in the list. Therefore, we can write a `print()` function.

```java
public void print()
{
    Node current = head;
    for(int i=0;i<size;i++) {
        System.out.println(current.data);
        current = current.next;
    }
}
```

However, this does not look like the default print. Maybe we can make it better looking, like `[3, 4]`. For that we are going to modify the code.

In Java, when we say `System.out.println(myList)`, it is actually calling the `toString()` method. Therefore, if we change our `print()` to `toString()`, we can call it by `System.out.println(mylist)` instead of `mylist.print()`..

```java
public String toString() { //override
    String s = ""; //can use a stringbuilder too. it is more efficient
    Node current = head;
    s += "[";
    for(int i=0;i<size;i++){
        s += Integer.toString(current.data);
        current = current.next;

        if(i != size-1){
            s += ", ";
            continue;
        }
        if(i == size-1){
            s += "]";
            return s;
        }   
    }
    return s;
}
```


In the previous weeks, we implemented Stack and Queue by using arrays. Now, we can actually implement them using our own list structure. We will implement a stack using `ArelList`.

```java
class Stack {
    ArelList al;
    int size;

    public Stack() {
        al = new ArelList();
        size = -1;
    }

    public void push(int x){
        al.add(x);
        size++;
    }

    public int pop() {
        //how to do it?
    }
}
```

Well, up to this point we actually did not implement a `getElementByIndex` method in our ArelList. So, lets add it. We will name it `getElement(int index)`.

```java
public int getElement(int index){
    if(index < 0 || index >= size){
        return -1;
    }
    if(index == 0) {
        return head.data;
    }
    else {
        Node current = head;
        for(int i=0;i<index;i++) { //not index-1 here
            current = current.next;
        }
        return current.data;
    }
    }
```

Now, we can modify the `pop()` in the Stack.

```java
public int pop() {
    int num = al.getElement(size);
    al.removeAt(size); //we remove it
    size--;
    return num;
}
```

We have a functioning Stack. 

