# Abstract Classes

## What is an abstract class in Java?

* A class that **cannot be** instantiated and **meant to be** inherited by other classes.
* Used to provide a **common base** with **partial implementation**
  * This is important. This is the core reason for A.C.
  * Partial! - A mix of **defined** and **undefined** (abstract) methods

```java
abstract class Animal {
    abstract void sound();  // abstract method (no body)
    
    void sleep() {          // concrete method (has body)
        System.out.println("Sleeping...");
    }
}
```

---

## How is an abstract class different from a regular class?

| Feature              | **Abstract Class**                                                                                      | **Regular Class**                                               |
| -------------------- | ------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------- |
| **Instantiation**    | ❌ Cannot be instantiated directly                                                                       | ✅ Can be instantiated                                           |
| **Keyword**          | Declared using `abstract`                                                                               | No special keyword                                              |
| **Abstract Methods** | Can have abstract (unimplemented) methods                                                               | Cannot have abstract methods                                    |
| **Concrete Methods** | Can have both abstract and concrete methods                                                             | Can have only concrete methods                                  |
| **Purpose**          | Acts as a **base class** — provides common behavior and forces subclasses to implement specific methods | Used to create **fully defined objects** with complete behavior |
| **Constructors**     | ✅ Can have constructors (called when subclass objects are created)                                      | ✅ Can have constructors                                         |
| **Usage**            | Used for **partial abstraction** and **shared logic**                                                   | Used for **complete implementation**                            |


**Example:**

```java
abstract class Shape {
    abstract void draw();  // abstract
    void display() {       // concrete
        System.out.println("This is a shape");
    }
}
```

Regular class:

```java
class Circle extends Shape {
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Test {
    public static void main(String[] args) {
        Circle c = new Circle(); // ✅ allowed
        c.draw();
        c.display();
    }
}
```

* In short, an **abstract class** provides a **template** with some methods left undefined for subclasses to complete, while a **regular class** provides **fully defined** implementation that can be directly instantiated.

---

## What is the purpose of an abstract method?

* The purpose is to define a **method signature** without implementation.
  * Forces subclasses to provide their own version of that method.

```java
abstract void display();
```

* It has **no body**.
* Subclass **must** override it to give a **concrete** implementation.

This way, we can:
* Enforce a common behavior contract
  * Ensures all subclasses **implements certain methods**.
  * E.g. every *shape* must know how to draw itself.
* Enable polymorphism
  * Abstract methods lets us define general behavior in a superclass and rely on subclass-specific version in runtime.
* Support partial abstraction
  * Meaning that A.C can define *shared code* (concrete methods) while *abstract methods* enforce subclass-specific behavior.

```java
abstract class Shape {
    abstract void draw(); // abstract method
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square extends Shape {
    void draw() {
        System.out.println("Drawing a square");
    }
}
```

Here, we show that every subclass **must** override this. However, it was also possible to have a concrete method in `Shape`, where all classes would inherit it as such.

In short;
* The purpose of an abstract method is to declare a behavior that all subclasses must implement, ensuring consistency while allowing flexibility in how that behavior is carried out.

---

## Why can’t we instantiate an abstract class directly?

* Because an A.C. is not **complete**
* It is possible that it has **abstract methods**
  * If we were to create an object out of it, what would those abstract methods do?

The main objective of abstract classes are to **act as templates**.
* They are designed to be base classes that define structure and shared behavior, not to create actual objects.

---

## Can an abstract class have constructors?

* Yes!
  * Because when a subclass inherits an AC, they can call the constructor of the AC.
* This allows the AC to **initialize common fields or perform setup tasks** needed by all subclasses.


```java
abstract class Vehicle {
    String type;

    Vehicle(String type) {
        this.type = type;
        System.out.println("Vehicle constructor called");
    }
}

class Car extends Vehicle {
    Car(String type) {
        super(type); // calls abstract class constructor
        System.out.println("Car constructor called");
    }
}

public class Main {
    public static void main(String[] args) {
        Car c = new Car("Sedan");
    }
}
```

---

## Can an abstract class have instance variables?

* Yes. It is still a *class*.
* It can contain:
  * Instance variables
  * Constructors
  * Concrete methods
  * Abstract methods

* These are used to store **data** or **state** that will be *shared* or *customized* by the subclasses.
* It can store **common data**.
  * Subclasses *can* modify that data.
  * Helps maintain *shared state and behavior* across related subclasses.

```java
abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract void work();

    void showDetails() {
        System.out.println(name + " earns $" + salary);
    }
}

class Manager extends Employee {
    Manager(String name, double salary) {
        super(name, salary);
    }

    void work() {
        System.out.println(name + " manages the team.");
    }
}

public class Main {
    public static void main(String[] args) {
        Manager m = new Manager("Alice", 80000);
        m.showDetails();
        m.work();
    }
}
```

---

## What happens if a subclass doesn’t implement all abstract methods?

* If that happens, than the subclass **must** become an **abstract class**
  * If a class has abstract methods, it is an abstract class.


---

## Can an abstract class be final? Why or why not?

* No.
* Final means it cannot be *inherited*.
  * But the main purpose of AC is so it can be inherited.

---

## Can an abstract class extend another abstract class?

* Yes.
* If it implements all, it becomes a concrete class.
  * If not, it stays as an abstract class.
  * Remember, the subclass must implement, otherwise it is an abstract class.

```java
abstract class Shape {
    abstract void draw();
    void display() {
        System.out.println("This is a shape");
    }
}

abstract class Polygon extends Shape {
    // draw() not implemented → Polygon remains abstract
    abstract void sides();
}

class Triangle extends Polygon {
    void draw() {
        System.out.println("Drawing a triangle");
    }

    void sides() {
        System.out.println("A triangle has 3 sides");
    }
}
```

* Since `Polygon` extends `Shape` but not implement `draw()`, it stays abstract.
* Triangle implements all, so it becomes a concrete method.

---

## When should I use an abstract class vs an interface?

* AC: When classes share **common fields** or **implementation**
* Interface: When we need to define a **contract** of behavior (no shared state)


| Feature              | **Abstract Class**                                                            | **Interface**                                                            |
| -------------------- | ----------------------------------------------------------------------------- | ------------------------------------------------------------------------ |
| **Purpose**          | Provides a **base class** with shared code and structure.                     | Defines a **contract** that other classes must follow.                   |
| **Methods**          | Can have both abstract and concrete methods.                                  | Can have abstract, default, static, and private methods (since Java 8+). |
| **Variables**        | Can have **instance variables** (store object state).                         | Only has **public static final constants** (no state).                   |
| **Constructors**     | ✅ Can have constructors.                                                      | ❌ Cannot have constructors.                                              |
| **Inheritance**      | A class can **extend only one** abstract class.                               | A class can **implement multiple** interfaces.                           |
| **Use Case**         | When there’s a **“is-a” relationship** and some **common behavior** to share. | When different classes just need to **agree on a behavior**.             |
| **Access Modifiers** | Can have protected, private, etc.                                             | All methods are **public** by default.                                   |


* When we want to **share code**, we use AC.
  * All classes have a **common base**.
  * When we want to **partially implement** functionality and let subclasses fill the rest.

* When we only want to define **behavioral contracts** we use Interfaces.
  * Classes are **unrelated** but **share behavior**: printer, scanner, camera they all `start()`
  * When we need **multiple inheritance of type**.

**Real world analogy**

| Example                                       | Explanation                                                                                           |
| --------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| **Abstract Class:** `Vehicle` → `Car`, `Bike` | All vehicles share wheels, engine, etc. (shared code).                                                |
| **Interface:** `Drivable`, `Flyable`          | Defines capabilities — a car, drone, or plane can all be drivable/flyable, even if they’re unrelated. |
