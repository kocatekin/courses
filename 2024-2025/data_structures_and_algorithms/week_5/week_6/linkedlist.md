# Linked List

Since we are not using a language with pointers, it may be confusing to understand Linked Lists. That's why here, you have an explanation on how *referencing* works in Java.

In Java, there are two kinds of types: primitive types (int, float, etc) and **reference types**. In addition, there are two kinds of data values that can be stored on variables: **primitive values** and **reference values**.

So, in Java every **non-primitive** type is a reference. 

This is what we mean by that:

`String s = "tugberk"` creates a new String object in memory with the content `tugberk`. The variable `s`, holds a **reference** (_pointer_) to this String object in the memory. Later, we create another string object `String a = ""`. Later, we say `a=s`. What happens here is, we make **a** point to the same memory location as **s**. So, whatever **s** was pointing to, **a** is also pointing to it now.

Let's change `s`. `s = "hey"`. This time, a new String object is created (hey) and **s** is now pointing to it. So, the original `tugberk` still remains in the memory. **a** is still pointing to that location. But now, **s** is pointing to a different location. It is pointing to wherever `hey` object is. 

Therefore, when we are using Java to program LinkedLists, we are actually still storing a **reference** to the *next* location.

Now, try to go through LinkedList examples in this light.
