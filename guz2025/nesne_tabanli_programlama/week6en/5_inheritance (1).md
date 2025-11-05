# Inheritance

---

# Introduction

* Inheritance allows one class to **reuse**, **extend** or **specialize** another class.
* Implements the *is-a* relationship.
   * Superclass (Parent)
   * Subclass (Child)

Here, we aim to avoid repetition, promote reusability and express hierarchies.

---

# Basic Syntax

```java
class Superclass {
    // fields and methods
}

class Subclass extends Superclass {
    // extra fields and methods
}
```
We use **extends** keyword to create subclasses and inheritance. Here, SubClass is using extends keyword to create a SubClass of the SuperClass.

---

# Example

```java
class Student {
    String name;
    int id;

    void attendClass() {
        System.out.println(name + " attends class.");
    }
}

class GraduateStudent extends Student {
    String thesisTopic;

    void submitThesis() {
        System.out.println(name + " submits thesis on " + thesisTopic);
    }
}

public class Main {
    public static void main(String[] args) {
        GraduateStudent gs = new GraduateStudent();
        gs.name = "Harry";
        gs.thesisTopic = "LLMs in Education";
        gs.attendClass();     // inherited
        gs.submitThesis();    // subclass method
    }
}
```

Here, we have a Student class with name and id. For simplicity, we did not employ encapsulation. But remember, we always use *private* keyword. Any object of this Student class have the method `attendClass()`. 

Later, we see that a new class is created: GraduateStudent. However, it **extends** Student class. This means that this new class **inherits** the Student class. So, everything that the `Student` class has, it also has them. Everything that the `Student` class do, it can do them too. 

However, it has the option to do **more**. For example here, we can see that the `GraduateStudent` can `submitThesis()` whereas a Student object cannot.

---

# Accessing Parent Methods with `super`

The `super` keyword is a special keyword which allows the *subclass* to call:
1. The **superclass constructor**
2. The **superclass version of an overridden method**

```java
class User {
    User() {
        System.out.println("User created.");
    }

    void showRole() {
        System.out.println("Generic user.");
    }
}

class AdminUser extends User {
    AdminUser() {
        super(); // call User() constructor
        System.out.println("Admin user created.");
    }

    @Override
    void showRole() {
        super.showRole(); // call parent's version
        System.out.println("This user has admin privileges.");
    }
}
```

Here, we have a `User` class with `showRole()` method. Later, we create an `AdminUser` class which **extends** the `User` class, meaning that AdminUser is a subclass of User class.

In the constructor, we see `super()`. What happens here is, when we want to create an `AdminUser` object, it will run `AdminUser` constructor. So when it runs, it will run `super()` which means that we are going to run the superclass constructor. Therefore it will print out;

* User created
* Admin user created

If we later call `super.showRole()`, it will run the superclass' version of the method -> will print out:

* Generic user
* This user has admin privileges.

---

# Method overriding

A subclass can **replace** a parent's method with a customized version. In that case, we will use `@Override`.

```java
class Vehicle {
    void start() { System.out.println("Vehicle starting..."); }
}

class ElectricTruck extends Vehicle {
    @Override
    void start() { System.out.println("Electric truck powering up silently."); }
}
```

In this example, we create a new subclass called `ElectricTruck`. By default, this class will have a `start()` method, it will be the same as `Vehicle`. However, we may choose to write our version of this by overriding it. Because if we do not override it, it will print out

* Vehicle starting...

There are some rules here though:
* They must have identical signature
* Cannot reduce visibility (e.g. public -> private)
* Should use `@Override`. If you don't, it still works. But it decreases readability. 

---

# Constructor chaining

Constructors are not inherited. But subclasses can call them using `super()`. 

```java
class Employee {
    Employee(String name) {
        System.out.println("Employee: " + name);
    }
}

class Manager extends Employee {
    Manager(String name) {
        super(name); // must be first line
        System.out.println("Manager: " + name);
    }
}
```

Here, when we want to create a Manager, we can use the superclass' constructor. 

---

# Inheritance Levels

We can have levels to our inheritance. 

* Single Inheritance
* Multilevel Inheritance
* Hierarchical Inheritance

However in Java, **multiple inheritance** is not allowed. This will be solved by **interfaces**.

## Single Inheritance

```java
class Vehicle {}
class Truck extends Vehicle {}
```

## Multilevel inheritance

```java
class Vehicle {}
class Truck extends Vehicle {}
class ElectricTruck extends Truck {}
```

## Hierarchical Inheritance

```java
class User {}
class AdminUser extends User {}
class CustomerUser extends User {}
```

---

# `instanceof` operator

This is used to check is an object belongs to a specific type or hierarchy:

```java
GraduateStudent gs = new GraduateStudent();
System.out.println(gs instanceof Student);   // true
System.out.println(gs instanceof Object);    // true
```

---

# Example

```java
class Shipment {
    int id;
    void track() {
        System.out.println("Tracking shipment " + id);
    }
}

class ExpressShipment extends Shipment {
    int priorityLevel;
    void track() {
        System.out.println("Express tracking for shipment " + id +
                           " with priority " + priorityLevel);
    }
}
```

Here, we have `Shipment` class and a subclass: `ExpressShipment`. Here, we see that ExpressShipment **is a** Shipment. It can override the behavior. For example `track()` method does two different things here.

We can also use `super.track()` in our subclass too. Try and see what happens.

---

# More about inheritance

In real-world software, especially in large-scale systems, devs often avoid deep inheritance hierarchies.

This creates something called **tight coupling**. If class **B** inherits from **A**, any change in **A** can break **B**.

Imagine the following:
```java
class Report {
    void generate() { System.out.println("Generating report..."); }
}

class PDFReport extends Report {
    void export() { generate(); }
}
```

If we later rename or modify the `generate()` in Report, `PDFReport` must change too.

Instead, we are going to use **composition** most of the time.

Another problem may be that when the base classes become too generic or powerful, all subclasses may inherit wanted **and** unwanted behavior. For example, if you modify `Vehicle` class to add a `licenseNumber`, every subclass (including something like **Drone**) will inherit it. But a drone does not have a licensenumber, still a vehicle.

Developers often inherit just to reuse methods, even when the relationship is not **is-a**. So, remember that inheritance must be used for **is-a** relationships.

In addition to these, it is harder to **test** and **maintain** the code. It is harder to test because subclasses depend on complex parent logic. If you change anything in a parent, you need to test everything in subclasses again. Also, if you maintaining the code and not written it (or you forgot), deep hierarchies will be too hard to understand.

For that reason, most of the time we:

* **Favor composition over inheritance**

It means that:
* use a **has-a** (containment) unless *is-a* truly fits.
* easier to change behaviors in runtime by swapping contained objects.

We should only use inheritance if:
* The subclas is a **true specialization** of the parent.
* We expect to use **polymorphism**.
* When we are modeling **hierarchical domains** such as GUI frameworks, shapes, etc.

We must avoid using inheritance for the following tasks:
* reusing methods only
* utility or helper purposes
* runtime behavior swapping




