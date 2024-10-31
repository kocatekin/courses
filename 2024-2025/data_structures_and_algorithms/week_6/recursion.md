# Recursion


Recursion means "defining a problem in terms of itself". This can be a very powerful tool in writing algorithms. Recursion comes directly from Mathematics, where there are many examples of expressions written in terms of themselves. 

One of the most important thing in recursion is the **base case**. You must have a base case, otherwise the recursion will go on forever. You must exit at some point. 

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
