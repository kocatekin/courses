# Introduction to Time & Space Complexity

There are problems, and there are solutions to them. Sometimes, some solutions are better than the others. For example, when we look at *searching* algorithms, we've seen that binary search works much better than linear search. 

There are a lot of cases like this. So, how can we compare these algorithms? We generally use the *time* it takes to complete the function, program. So, we check the runtime. We can create a timer in the program, or if we are using a unix-like shell, we can use the `time` program. I encourage you to write a timer to see how much time it takes for your program or function to run. 

However, this approach has limitations. It is not possible to test every program across all possible inputs. So, we rely on analytical methods to evaluate the performance. For now, we are not going to get into detail and learn some information on this matter.

We have a notation called **Big O** or **Big Oh** and shown by `O(..)`. This is short for *ordnung* because of the german inventors. There is a family of mathematical notations called *Bachman-Landau notation* or *asymptotic notation*, and `O` is a part of it.

PUT GRAPH HERE

These notations show how **fast** or **slow** an algorithm is. It gives us an idea, an **approximation**. That is what we care about! 

We have:
```
O(n): linear time
O(logn)
O(1): constant time
O(n^2): quadratic time
```

The Big Oh notation gives us the **worst-time** or the **worst-case** that can happen. Because most of the time, that is what we care about. 

In O(n), running time grows linearly with the size of the input. If you remember the linear search, that runs in O(n) time. Remember that, in the worst case, the element we are looking for is either the last element or it is not even in the list. That means we need to go through **all** *n* elements. In other terms, as the size of the input increase, the running time increases linearly.

O(1) is **constant time**. It means that the running time is **not** effected by the number of elements. For example, accessing an element in an array is O(1). Remember that in arrays, the address location of elements are consecutive. That is why, if we know the first element address we just do an *addition*. Whether it is 10, or 100; it doesn't matter. Another example can be this: Let's say that we said everyone stand up at the same time. It will take the same time whether 100 or 10000 people are doing it.

In O(logn), as the input size grows, the time to execute the algorithm grows **much more slowly** compared to input size. This is good, because it scales very well for large inputs. It often comes up where we divide the input in half with each step. If you remember, *binary search* is a very good example of this.

O(n^2) is quadratic time. Here, the running time is proportional to the **square** of the input size. If you **double** the input size, the running time will be **quadrupled**. We usually see this in **nested loops**. If there are two nested loops, you probably have quadratic runtime. Although it is okay for small inputs, if we size grows too much it can become a problem. 

For example, when a student shakes hands with every other student, it is O(n). But if **every** student shakes hands with everyone, it is $O(n^2)$.

Apart from these, it is also possible that sometimes we can just find the solution immediately. For example, in linear search or binary search, it is possible that the element we are looking for is the *first* element or the *pivot* element. In this case, we talk about **best-case** and we represent it by using *omega* symbol. Ω 

O is showing the **upper bound** and omega is showing the **lower bound**. For example, the lower bound for binary search and linear search is Ω(1). 

Lastly, we have *theta* as well. When the lower bound and upper bound are the same, we say Θ(n). For example, the attendance is O(1) in worst case and best case (Ω(1)) so we can show it as: Θ(1) 

After the midterms, we will see more of these notations.



