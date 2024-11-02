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


* Base case is the simplest instance which can be solved without further recursion.
* Acts as a stopping criteria for the function.
* Recursive case is the part where recursion occurs.
* Function calls itself but **with a different set of parameters**.
* Each recursive case divides the problem into smaller parts.

Every recursive function has **at least** two different returns. One of them will be the recursion case and the other, base case. 



## Examples

**Factorial**

```java
public static int factorial(p x)
{
  if(x == 0) {
    return 1;
  }
  return x * factorial(x-1);
}
```

**Fibonacci**

```java
public static int fibonacci(int x) {
  if(x==0) return 0;
  if(x==1) return 1;
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

**summing a list of numbers**

Here, the solution is a little different. Before, every function we created got a single parameter. But this question cannot be solved by using a single parameter. We also need to give the index.

Let's try to solve it first. Say that we want to get the sum of `3,4,5,6`. This actually means it is `3 + {4,5,6}`. Now, we have a new array: `4,5,6`. We can go as follows:

```
{3,4,5,6} -> 3 + {4,5,6}
{4,5,6} -> 4 + {5,6}
{5,6} -> 5 + {6}
{6} -> 6 + {0}
{0} -> 0 (base case)

So, we now have our base case. That means {6} is 6.
Therefore we go up now:
{5,6} -> 5 + 6 = 11
{4,5,6} -> 4 + 11 = 15
{3,4,5,6} -> 3 + 15 = 18
```

```java
public static int sumArr(int[] arr, int idx) {
  if(idx < 0) return 0;
  return arr[idx] + sumArr(arr, idx-1);
```

However, as a trick, we can create a new function with a *single* parameter and that can call this function we created instead!

```java
public static int sum(int[] arr)
{
  return sumHelper(arr, arr.length-1);
}

public static int sumHelper(int[] arr, int idx)
{
  if(idx < 0) return 0;
  return arr[idx] + sumHelper(arr, idx-1);
}
```

These are called *helper* functions in general. It would be wise to use them.

Another example can be **reversing a string**. First, let's try to imagine it. For help, we are going to introduce two methods for string class. `charAt() and substring()`.

```java
String s = "tugberk";
print(s.substring(1)); //prints ugberk
print(s.charAt(0)); //prints t
```

So, when you look at this, it may give you some ideas.
```
Let's imagine a reversi(string s) function.
reversi("tugberk") -> reversi("ugberk") + t
reversi("ugberk") -> reversi("gberk") + u
..
```

It will go on like this. This is the recursive case. We also need a **base case** to get out. Remember that in recursion we are getting closer and closer to the base case in every iteration. At some point, our string is going to be 1 char. So, that is a base case. Our string can also be a null so we will add that too:

```java
public static String reversi(String s) {
  //base case
  if(s.length() <= 1 || s == null) return s;
  return reversi(s.substring(1)) + s.charAt(0);
```


