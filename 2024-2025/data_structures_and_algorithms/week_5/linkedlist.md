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



For that reason, first we are going to have a *Node* class.
```java
class Node {
 int data;
 Node next;

Node(int data) {
 this.data = data;
 this.next = null;
 }
}
```

Here, this node is going to be an element in the chain of elements. Every *value* we add is going to be added to the *data* part of the Node. The *next* is going to show the next element in the chain.

Later, we are going to create our LinkedList data structure.

```java
class LinkedList {
   Node head;

public void 












