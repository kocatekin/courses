# Interfaces 2

## What is an interface in Java?

* A **reference type** (like a class) that defines a **set of abstract methods** that a class **must** implement.
* It is a **contract**. It tells what a class **must** do, but now **how** to do it.

```java
interface Animal {
    void eat();
    void sleep();
}
```

* If we are creating the interface as a separate file, we should do it in the following way:
  
```java
public interface Animal {
    void eat();
    void sleep();
}
```

---

## How does a class use this interface?

* A class uses the `implements` keyword.
* Later, provides *concrete* behavior for interface methods.
```java
class Dog implements Animal {
    public void eat() {
        System.out.println("Dog eats bones");
    }
    public void sleep() {
        System.out.println("Dog sleeps in a kennel");
    }
}
```

---

## Why do we use interfaces?

* To define a **common contract** that multiple classes can follow. 
    * Ensures consistency, flexibility and better software design.

---

## How does an interface support abstraction ?

* Interfaces let you focus on what an object should do, not how it does it.
* Each class can have its own implementation details, but the overall behavior stays consistent.

```java
interface Payment {
    void pay();
}

class CreditCardPayment implements Payment {
    public void pay() { System.out.println("Paid using Credit Card"); }
}

class PayPalPayment implements Payment {
    public void pay() { System.out.println("Paid using PayPal"); }
}
```

Here, both classes follow the same contract, but they implement `pay()` differently.

---

## How can I achieve loose coupling with interfaces?

* Interfaces help separate the definition of an operation from its implementation.
* This makes code flexible and easy to maintain
  * you can swap out implementations without changing other parts of the code.

```java
class PaymentService {
    private Payment payment;

    PaymentService(Payment payment) {
        this.payment = payment;
    }

    void processPayment() {
        payment.pay();
    }
}
```

---

## Can an interface have instance variables or constructors? Why or why not?

* No, an interface **cannot** have instance variables or constructors.
* All variables in an interface are **public**, **static** and **final** by default. This means they are **constants**, not instance-specific.
* Interfaces cannot hold state for objects.
* Since there are **no** constructors, interfaces cannot be instantiated. (This means we cannot create objects out of an interface)
* They only declare methods that *implementing classes* must define. 

---

## What happens if a class doesn’t implement all methods of an interface?

* If a class does not implement all methods of an interface, the class must be declared **abstract**.
* Because a concrete (non-abstract) class must provide implementations for **all** abstract methods in the interface.

```java
interface Animal {
    void eat();
    void sleep();
}

abstract class Dog implements Animal {
    public void eat() {
        System.out.println("Dog eats food");
    }
    // sleep() not implemented → class must be abstract
}
```

Here, if we do not implement `sleep()`, it means that we are going to turn `Dog` into an abstract class.

---

## What is the difference between implements and extends?

* Extends is used:
  * When a class inherits another class
    * or an interface inherits another interface
  * It represents inheritance (is-a) relationship
  * A class can extend **only one** class
  * The *subclass*, inherits the properties and methods of the *superclass*

* Implements is used:
  * When a class implements an *interface*
  * It represents a **contractual** relationship. 
    * The class promises to provide implementations for all interface methods.
  * A class can implement **multiple** interfaces.

---

## Can an interface extend another interface? Can it extend multiple ones?

* Yes, an interface can extend another interface. It can also extend **multiple interfaces**.
  * We did not have this in classes.
* Interfaces can form inheritance hierarchies using the `extends` keyword.
* This allows one interface to **inherit** all the abstract methods from other interfaces.
* A single interface can **extend multiple interfaces**.

```java
interface A {
    void methodA();
}

interface B {
    void methodB();
}

interface C extends A, B {
    void methodC();
}
```

* Here, `C` inherits both `methodA()` from A and `methodB()` from B. 
* Any class that *implements* `C`, must implement `methodA()`, `methodB()` and `methodC()`.

---

## What are default, static, and private methods in interfaces (Java 8+)?

* In Java 8 and later, interfaces can include three kinds of non-abstract methods: `default`, `static` and `private` methods.

**Default methods:**
* Declared with keyword `default`
* Provide a *default implementation*
* Allows new methods to be added to interfaces **without breaking** existing classes.
* Can be **overridden** by implementing classes.

```java
interface Vehicle {
    default void start() {
        System.out.println("Vehicle starting...");
    }
}

class Car implements Vehicle {
    // optional override
}
```

* At this example, if the `Car` do not override the `start()` method, now it has a default version. It will be used. 
* This lets us add new behavior to interfaces while keeping backward compatibility.
  * Because now it is possible *not to* override all methods.

**Static methods**

* These are declared with `static` keyword.
* They belong to the interface themselves, **not** to the implementing classes.
* They are called using the interface name.

```java
interface Vehicle {
    static void service() {
        System.out.println("Servicing vehicle...");
    }
}

class Car implements Vehicle {}

class Main {
    public static void main(String[] args) {
        Vehicle.service(); 
    }
}
``` 

This is used to provide utility or helper functions.

**Private Methods**

* Declared with `private`
* Used **only inside** the interface to **avoid code duplication** among default or static methods.
  * (We did a similar example, we used it like this in classes)
* Cannot be accessed or overridden by implementing classes.

```java
interface Vehicle {
    default void start() {
        log("Starting vehicle...");
    }

    private void log(String msg) {
        System.out.println(msg);
    }
}
```

Here, we can share common code *among methods* inside the interface without **exposing it**.


**Summary:**

* Default methods give behavior to classes
* Static methods give tools to interfaces
* Private methods help keep code inside interfaces clean and reusable.

---

## Can an interface contain fields? If so, what are their default modifiers?

* Yes, but they are **constants**, not normal instance variables.
* All fields are **automatically** -> public, static and final.
  * Even if we don't say anything, they are applied.

```java
interface Vehicle {
    int MAX_SPEED = 120;  // same as: public static final int MAX_SPEED = 120;
}
```

For example if you implement this interface, you will not be able to change the `MAX_SPEED`.

---

## Let's write a simple interface and implement it in multiple classes

```java
interface Payment {
    void pay(double amount);
}
```

Classes:

```java
class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class PayPalPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

class BankTransferPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Bank Transfer.");
    }
}
```

Test with a Main class:

```java
public class Main {
    public static void main(String[] args) {
        Payment creditCard = new CreditCardPayment();
        Payment paypal = new PayPalPayment();
        Payment bank = new BankTransferPayment();

        creditCard.pay(250.00);
        paypal.pay(125.50);
        bank.pay(600.00);
    }
}
```

* Here, the `Payment` interface defines a **common contract**.
  * Every payment type **must** have a `pay()` method.
* Each class provides its own implementation.
  * Polymorphism!
* Main program can handle all from the same interface and do not care about the internal details.




