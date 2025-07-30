
# OOP

---

## Objects

```java
class Dog {
    // fields
    String name;
    int age;

    // method
    void bark() {
        System.out.println(name + " says: Woof!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a Dog object
        Dog myDog = new Dog();
        myDog.name = "Buddy";
        myDog.age = 3;

        myDog.bark();  // Output: Buddy says: Woof!
    }
}
```

* Here, we create a Dog class and we create a method for that.
* In the *Main*, we create a **Dog** object by using `Dog myDog = new Dog()`
* Notice that `myDog` is the **name** of my Dog object.

---
## Using a constructor

```java
class Cat {
    String name;
    int age;

    // Constructor
    Cat(String n, int a) {
        name = n;
        age = a;
    }

    void meow() {
        System.out.println(name + " says: Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a Cat object using constructor
        Cat myCat = new Cat("Whiskers", 2);
        myCat.meow();  // Output: Whiskers says: Meow!
    }
}
```

In this example, there is a difference. We have a **constructor**. As we can see in the first example, we do not **have to** give a constructor. The language automatically creates an **empty** constructor if we did not give it. 

In this example, we created our own constructor. A constructor is a **special method** which does not have a **return type**.

---

## Multiple objects from the same class

```java
class Car {
    String brand;

    void drive() {
        System.out.println("Driving " + brand);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.brand = "Toyota";

        Car car2 = new Car();
        car2.brand = "Honda";

        car1.drive();  // Output: Driving Toyota
        car2.drive();  // Output: Driving Honda
    }
}
```

In this example, we have a Car class. It has a **drive** method. 

In the `Main`, we create 2 cars. Obviously they cannot have the same name. Therefore we have different names for our cars. There are **two** objects here from the **same class**.

Here we can see the logic of classes. A class gives us blueprints to create objects. Class defines what the objects **are** (via attributes), and what they can **do** (via methods).

---

## Four pillars

* Encapsulation
* Inheritance
* Polymorphism
* Abstraction

---

## Encapsulation

Encapsulation is the practice of hiding the internal state and requiring all interaction to be performed through an object’s methods.

* It protects the data from unauthorized access.
* It makes code easier to change and maintain.

```java
public class BankAccount {
   //attributes
    private double balance; // hidden from outside

   //constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

   //methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
```

While writing OOP programs, make sure you follow this structure:
1. Attributes & fields
2. Constructors
3. Methods

Here in the example we can see that our attribute is **balance**. The type of it is **double**, because we use double type for money. 

After that comes the constructor. We can see that it is **not** an *empty constructor*, it needs a parameter inside, the *initialBalance*. Therefore, we are going to create this object by giving an initialBalance. Otherwise, we cannot create an object. (Try this and see if you are able to create a BankAccount object with empty parameters)

At this point, create the BankAccount object with a **double** value. `BankAccount ba = new BankAccount(4.5)`. Now you have a `ba` object. Write the name in your main, and press on `.`. When you do it, IDE helps you to see what you can write here. You will see multiple stuff. Some of them comes by **default** but others are those who you name as **public**. 

So here, other classes can only reach to **methods** and **attributes** if they are **public**. If they are **private**, the only way to reach them is by using **getters**. The only way to *modify* them is by **setters**. This is **encapsulation**. We hide details and direct access to our internal states and we only let other classes control or access them by **how we want it**. We do it by using methods. We can control it.

They can only access those by using **getters** (and we may choose not to give a getter for all of them) and they can modify it by using **setters**. (by they, we mean other classes)

---

## Inheritance

Inheritance allows one class to inherit the fields and methods of another class (a parent class or superclass).

* Promotes code reusability.
* Helps build hierarchies.

```java
class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

```

Here, we create an `Animal` class. It does not have any attributes, an apparently no constructor. That means if we want to create an Animal object, we can just call it and the empty constructor will work. 

Later, we create another class -> A **Dog** class. But there is a difference, we use a new keyword: `extends`. Now, this means Dog is a **subclass** of Animal and it **inherits** whatever properties `Animal` has. 

At this point, we can try an example of leaving the inside of Dog class empty. When we do it, Dog class will have `makeSound()` method again and it will work exactly like in Animal.

In the code block we see something: `@Override`. This actually is an **annotation**. In Java, we have lots of annotations. The reason we use this is that if we make a mistake, the compiler will help us. You can try the same example without using that annotation and it will still work. However, now the compiler checks it and helps us by giving a *compile-time error* if something is wrong.

This is called **method overriding**. As we can see in this example, a **subclass** can **redefine** a method from the superclass. It can change it! 

Let's add a **Cat** class similar to Dog here.

---

## Polymorphism

Polymorphism means "many forms". A class can be used in different forms via **method overriding** or **method overloading**.

There are two types:
* Compile-time polymorphism (method overloading)
* Runtime polymorphism (method overriding with inheritance)

```java
class Animal {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Cat(); // Polymorphism
        myAnimal.makeSound(); // Outputs: Meow!
    }
}
```

Here, we create an Animal class. Later, we have a **Cat** class which extends this Animal class. Therefore a Cat is a **subclass** of the Animal class. 

Later, we define the it differently. Instead of using `Cat myAnimal = new Cat()` we define it as `Animal myAnimal = new Cat()`. There is a reason for this.

In the first one, the **reference type** is `Cat` and the **object type** is `Cat`. That means we can access **all** methods and fields of `Cat`, *including* those which is **not** present in `Animal`. This is just a normal Object creation, not **polymorphism**. But in the second one, the **reference type** is `Animal` but **object type** is `Cat`. This is **polymorphism**. We treat `Cat` as if it is an `Animal`. Here, we can **only** call the methods we have in `Animal` class, even though `myAnimal` is a `Cat` at runtime. However, if those methods are **overridden** in `Cat`, the `Cat` version will be used! (dynamic dispatch)

**Why?**

This allows us to write more generic, flexible and reusable code.

Imagine this:
```java
public void makeAnimalSound(Animal a) {
   a.makeSound(); 
}
```

At this point, we can pass **any** subclass of Animal:

```java
makeAnimalSound(new Dog());
makeAnimalSound(new Cat());
```

Now, we do not have to write separate methods for Dog and Cat. 

Here, the `Animal` class is like a **remote control** (interface), and `Cat` is the actual device (implementation). With the remote, we can only press buttons that exists on **all animals**. But if the object is `Cat`, the **Cat's version** will run.

```java
class Animal {
    public void makeSound() {
        System.out.println("Some generic sound");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    public void jumpOnTable() {
        System.out.println("Cat jumps on the table");
    }
}

public class Test {
    public static void main(String[] args) {
        Animal a = new Cat();    // polymorphic reference
        a.makeSound();           // Outputs: Meow!

        // a.jumpOnTable();      // ❌ Compile-time error

        Cat c = new Cat();       // direct reference
        c.jumpOnTable();         // ✅ Allowed
    }
}
```

---

## Abstraction

Abstraction means showing only essential features and hiding unnecessary details. It’s about defining what an object does, not how it does it.

Achieved by:
- Abstract Classes
- Interfaces

### Abstract Classes

- A class that **cannot be instantiated**.
   - You cannot create objects from this class.
- May contain **abstract methods** (without a body) and **concrete methods** (with implementation)
- Can have fields (attributes, variables) and constructors.
- Can provide **partial abstraction**

```java
abstract class Animal {
    String name;

    // Abstract method (no body)
    abstract void makeSound();

    // Concrete method
    void eat() {
        System.out.println(name + " is eating...");
    }
}
```

When you see this, you cannot create an object directly. However, other classes can **inherit** them. 

```java
class Dog extends Animal {
    Dog(String name) {
        this.name = name;
    }

    // Must implement the abstract method
    @Override
    void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog("Buddy");
        myDog.makeSound(); // Buddy says: Woof!
        myDog.eat();       // Buddy is eating...
    }
}
```

### Interfaces

* Is a **contract** that a class **agrees to implement**.
* All methods are `public` and `abstract` - unless they are `static` or `default`.
* A class can **implement** multiple interfaces
   - In *abstract classes* you only have single inheritance.

So, classes **extends** (inherits) abstract classes, but **implement** interfaces.

```java
interface Vehicle {
    void start();  // implicitly public and abstract
    void stop();
}
```

This is an interface. Classes are going to **implement** them. As you can see, we only give the *name* and *type* of methods.

```java
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car has stopped.");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start(); // Car is starting...
        myCar.stop();  // Car has stopped.
    }
}
```

In this example, we create a `Car` class which implements the `Vehicle` interface. Here, the `Car` **must** define `start()` and `stop()` methods. 

Most of the time we are going to use **interfaces**. Inheritance is risky when the project becomes too large. 

### Summary

* Abstraction helps you focus on what an object does, not how it does it.
* Java uses abstract classes (for partial abstraction) and interfaces (for full abstraction and contracts).
* Use abstract classes when there's a strong relationship (is-a) and shared implementation.
* Use interfaces when you want to define capabilities or behaviors (can-do), e.g., 
Flyable, Drivable.

---
## Super

It is a **special keyword** used to refer to the **immediate** parent class (superclass) of the current object. Common in **inheritance** scenarios.

- We can use `super()` to explicitly call the constructor of the superclass, from the subclass constructor.
- We can call a method from the parent class, even if it is **overridden** in the subclass.
- We can access a variable from the parent class, which is hidden by a field in the child class.

First example:
```java
class Animal {
    Animal() {
        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {
    Dog() {
        super(); // calls Animal's constructor
        System.out.println("Dog constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
    }
}
```

Here, we have an `Animal` class. It has an empty constructor. Later, we create a Dog class which *inherits* the Animal class. Here, we use `super()` and we call the `Animal` constructor.

**Second example:**

```java
class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        super.makeSound(); // calls Animal's version
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.makeSound();
    }
}
```

Here, we create Animal class again. It has an empty constructor and a method. We again inherit that class, but this time we don't call `super()`, we call `super.makeSound()` which is a method from the superclass.

**Third example:**
```java
class Animal {
    String type = "Generic Animal";
}

class Dog extends Animal {
    String type = "Dog";

    void printTypes() {
        System.out.println(type);         // Dog
        System.out.println(super.type);   // Generic Animal
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.printTypes();
    }
}
```

Here, similarly we have the **type**.

---




---
```java
interface Swimmer {
    void swim();
}

abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void makeSound();

    void sleep() {
        System.out.println(name + " is sleeping...");
    }
}

class Dolphin extends Animal implements Swimmer {
    Dolphin(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " makes clicking sound.");
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming in the ocean.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dolphin d = new Dolphin("Flipper");
        d.makeSound();  // Flipper makes clicking sound.
        d.swim();       // Flipper is swimming in the ocean.
        d.sleep();      // Flipper is sleeping...
    }
}
```` 

