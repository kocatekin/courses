# Assertion

An assertion is a statement in a program that declares something the developer believes must always be true at that point in the code.

An assertion expresses a logical assumption that the program relies on.

> If the assumption is false, it means there is a bug.


## Why?

1. **Catch bugs early**

Assertions help find issues *exactly when they occur*. 

2. **Document Assumptions**

Assertions also act as executable documentation. Instead of writing a comment like:

 `This value should always be positive`, you can *assert* it. And now, if it's ever not true, you get an immediate feedback.

3. **Validate internal state**

Assertions help verify invariants, which are conditions **that must always hold true** throughout execution.

e.g.

* A bank account balance should not become negative due to internal operations.


However, one must be careful to see that assertions are not a mechanism to handle normal runtime errors. It is not a substitute for inpu validation as well. Users should not see assertions, which means that they should not be in the production code. 

---

# Java examples

In Java, assertions are not enabled by default. We need to enable assertions in the JVM. 

We do it by using `-ea`.

`java -ea file`

Or, in Eclipse you can get into *Run Configuration* and in VM arguments, add `-ea`. 

Let's start with a very basic example:

```java
int x = -1;
assert x >= 0 : "x must not be negative!";
```

Here, when you run this program it is going to say:

`Exception in thread "main" java.lang.AssertionError: x must not be negative!`

It means we actually put a guard in the code, and it stopped execution. Also, it gives an *AssertionError* and gives us the assertion message.

When we change the code the way we want it to be, we'll see that assertion is not working.

```java
int x = 1;
assert x >= 0 : "x must not be negative!";
```

Let's make another example. Here, we have a *square* function.

```java
public static int square(int number){
   return number*number;
}
```

We want to test this function to see if it works. 

```java
public static void testSquare() {
   System.out.println("Running square tests...");

   //test case 1
   assert square(2) == 4 : "square(2) should be 4";

   //test case 2
   assert square(0) == 0 : "square of 0 should be 0";

   //test case 3
   assert square(-3) == 9 : "square of -3 should be 9";

   System.out.println("all tests passed!");
}
```

We call this `testSquare` in Main. To see when it doesnt work, write the square function wrong first.

---

# JUnit



* JUnit is the most widely used unit testing framework for Java.
* It lets developers write automated tests that check if code works correctly.

Although assertion is good, it is not good enough for proper testing.

* Assertions can be turned off
  * If the program is run without -ea, none of your tests run.
* No reporting
  * Assertions only stop the program—JUnit gives structured test reports.
* Hard to organize
  * You can't group, document, or manage tests easily.
* Not designed for real testing
  * Assertions are for catching developer mistakes, not validating full application behavior.
  

## Advantages of JUnit

* Automated & Repeatable Testing
  * All tests run automatically with one click.
* Clear Test Structure
  * Each test gets its own method, name, and purpose.
* Better Failure Messages  
  * passed tests
  * failed tests
  * number of tests ran
  * what went wrong
* Test Suites
  * You can group hundreds of tests into test classes and test suites.
* No Need for main()
  * JUnit runs tests without any manual setup.
* Rich Assertions
  * JUnit gives many assertion types:
    * `assertEquals`
    * `assertTrue`
    * `assertFalse`
    * `assertThrows`
    * `assertNotNull`
    * etc


---

Let's create a JUnit test example.
We had a `square` method.

We create a new class.

But before, you need to right click on the project and 
`Build path -> Add Libraries`

There, Choose JUnit, Next, and JUnit5, finish.

Now, if you have a module-info;

```java
module testpro {
    requires org.junit.jupiter.api;
    requires org.junit.jupiter.engine;
}
```

create a new junit test;

```java
package testpro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SquareTest {

    @Test
    void testPositiveNumbers() {
        assertEquals(4, Main.square(2));
        assertEquals(9, Main.square(3));
        assertEquals(25, Main.square(5));
    }

    @Test
    void testZero() {
        assertEquals(0, Main.square(0));
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(1, Main.square(-1));
        assertEquals(9, Main.square(-3));
    }
}
```


Right click and run it. 


---

At this point, our program runs. However, how to write test cases?

It depends on the problem we have. For example for this square, if you check the names of the functions, it gives us information about the test we do!

e.g. we test for positive numbers, we test for zero, we test for negative numbers. But we added everything by hand.

We can also check for the upper boundary of integers. Maybe if the user is trying to get the square of some large number, it would fail! So, it is very important how we design our test cases.

For example, if we want to get the square of `1000000`, it will fail! What is the limit? The limit is going to be the **int**. 

The largest integer you can use in Java is 2147483647. So, since we are writing a square function; we are going to be able to use 46340 at max. If the written number is larger than that, we program will **not crash** but give you a **false result**. 

When you write code, you should always be careful with these.

So, make sure you check for the upper limits too. If we add;

```java
@Test
	void testMaxNumber() {
		assertEquals(8100000000, Main.square(90000));
	}
```

and run it again, it will actually fail!

---

