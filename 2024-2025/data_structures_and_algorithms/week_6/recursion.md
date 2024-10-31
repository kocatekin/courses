# Recursion


Recursion means "defining a problem in terms of itself". This can be a very powerful tool in writing algorithms. Recursion comes directly from Mathematics, where there are many examples of expressions written in terms of themselves. 

One of the most important thing in recursion is the **base case**. You must have a base case, otherwise the recursion will go on forever. You must exit at some point. 

So, we have a *base case* and a *recursive step*. Now, when we are writing functions in a mathematical form, the **right** way is to write the boundaries. However generally, we exclude them. It is a mistake. 

For example let's think of the Fibonacci series:
`F(3) = F(2) + F(1)` We can generalize this as: `F(n) = F(n-1) + F(n-2)`

This looks correct, but we have no boundaries on $n$. This formula only works for when $n>=2$. So, there is our base case!

Don't forget, when solving a problem in a recursive way, you must call the parent function within the function. 

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
