# Recursion


Recursion means "defining a problem in terms of itself". This can be a very powerful tool in writing algorithms. Recursion comes directly from Mathematics, where there are many examples of expressions written in terms of themselves. 

One of the most important thing in recursion is the **base case**. You must have a base case, otherwise the recursion will go on forever. You must exit at some point. 

So, we have a *base case* and a *recursive step*. Now, when we are writing functions in a mathematical form, the **right** way is to write the boundaries. However generally, we exclude them. It is a mistake. 

For example let's think of the Fibonacci series:
`F(3) = F(2) + F(1)` We can generalize this as: `F(n) = F(n-1) + F(n-2)`

This looks correct, but we have no boundaries on $n$. This formula only works for when $n>=2$. So, there is our base case!

Don't forget, when solving a problem in a recursive way, you must call the parent function within the function. 

It is a method where a solution to a problem depends on solutions to smaller instances of the same problem. In simpler terms, recursion occurs when a function calls itself to work towards a solution.

In recursion, the sub-problems must be identical in nature to the original problem, allowing the same solution approach to be applied.

In recursive functions, the function calls itself in order to divide the problem into smaller sub-problems. Each recursive call **must** progress towards a **base case**. If not, the recursion will not stop. However, the recursion must stop at some point, at the point where the problem is in its simplest form. Otherwise, we will have a *stack overflow* error. Because every function is stored in the stack and in recursion, it fills up the stack with every function call. In that sense, recursion is expensive. 

However, there are some cases where defining an *algorithm* is easier in recursion. For example, we did something similar in *binary search*. We will also see it a lot when we are using trees. 

So, while *recursion* is costly, thinking in **recursive way** can help a programmer a lot. After that, we can always turn the solution into a faster, iterative way. Every function can be written in both ways. It is sometimes easier to select one over the other. 




## Examples

**Factorial**

```java
public static int factorial(p x)
{
  if(x == 0) {
    return 0;
  }
  return x * factorial(x);
}
```

**Fibonacci**

```java
public static int fibonacci(int x) {
  if(x==0) return 0;
  if(x==1 || x==2) return 1;
  return fibonacci(x-1) + fibonacci(x-2);
}
```

**sum of numbers**

```java
public static int sumOfNumbers(int x) {
    if(x==0) return 0;
    return x + sumOfNumbers(x-1);
}
```


