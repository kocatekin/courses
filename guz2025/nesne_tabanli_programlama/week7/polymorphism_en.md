# Polymorphism

* Means **many forms**. 
* Allows one entity (method, variable, object) to behave in **multiple ways** depending on the context.

* In Java, it allows a **single interface** to represent **different types of objects**.
    * Each having its **own implementation**  of the same behavior.

**Example:**
* Speak
    * A dog barks, cat meows a human talks
    * Same command, different behavior.
    * Polymorphism!


# Why?


* Reduce code duplication
* Write flexible and maintainable code
* Handle different object types using one reference
* Allow easy scalability (add new classes without changing existing code)

e.g. If we add a new `DroneShipment` to a Logistics system, we don't need to change any code that already works with `Shipment`. 



# Two types of polymorphism

| Type                          | When It Happens          | Achieved By        |
| ----------------------------- | ------------------------ | ------------------ |
| **Compile-time polymorphism** | During compilation       | Method Overloading |
| **Runtime polymorphism**      | During program execution | Method Overriding  |

  
---

# Compile-time (Method overloading)

* Happens when **multiple methods** in the **same class** share the **same name** but have **different parameters**.
* Called compile-time, because the *compiler* decides which method to use before the program runs.

Imagine a payment system. We will have multiple methods in this payment class with the same name but they will have different parameters.

---

# Rules

* Methods must have the same name
* Parameter lists must be different
* Can have different return types
* The compiler decides which version to call — before the program runs



# PaymentService

```java
class PaymentProcessor {

    // Pay by credit card
    void pay(String cardNumber, double amount) {
        System.out.println("Paid " + amount + " using card: " + cardNumber);
    }

    // Pay by cash
    void pay(double amount) {
        System.out.println("Paid " + amount + " in cash.");
    }

    // Pay with discount code
    void pay(double amount, String discountCode) {
        System.out.println("Paid " + amount + " using discount: " + discountCode);
    }
}
```



```java
public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        processor.pay(100.0);
        processor.pay("1234-5678-9999-0000", 250.0);
        processor.pay(80.0, "SUMMER10");
    }
}
```

* Here, all the methods are `pay()`, but they accept **different parameters**.
* The compiler decides which one to run based on the parameters.

---

# Runtime polymorphism (method overriding)

This happens when a **child class** provides its **own version** of a method that already exists in the **parent class**.
* Called *runtime*, because Java decides **at runtime** which method to run, based on the actual object type.

As an example, we will look at a Logistics system. 



# Rules

* Same method name
* Same parameter list
* Must be in **different classes** (needs inheritance)
* Method **cannot** be final, private or static
* Decided at runtime, based on the object type


```java
class Shipment {
    void deliver() {
        System.out.println("Delivering shipment by standard method...");
    }
}

class AirShipment extends Shipment {
    void deliver() {
        System.out.println("Delivering shipment by air — fast delivery!");
    }
}

class SeaShipment extends Shipment {
    void deliver() {
        System.out.println("Delivering shipment by sea — cheaper but slower.");
    }
}
```

Here, we have different classes each extending the Shipment class. They have the *same* method name: `deliver()` and it does something different.

---

```java
public class Main {
    public static void main(String[] args) {
        Shipment s1 = new AirShipment();
        Shipment s2 = new SeaShipment();
        Shipment s3 = new Shipment();

        s1.deliver();  // Air version
        s2.deliver();  // Sea version
        s3.deliver();  // Standard version
    }
}
```

* The reference type is `Shipment`, but the **object type** changes. (The left is the reference type, right is the object type)
* Java picks the `deliver()` method at runtime.

---

# Employee Bonus System

```java
class Employee {
    double getBonus() {
        return 5000;
    }
}

class Manager extends Employee {
    double getBonus() {
        return 10000;
    }
}

class Intern extends Employee {
    double getBonus() {
        return 1000;
    }
}

public class Payroll {
    public static void main(String[] args) {
        Employee e1 = new Manager();
        Employee e2 = new Intern();

        System.out.println("Manager bonus: " + e1.getBonus());
        System.out.println("Intern bonus: " + e2.getBonus());
    }
}
```

---

# Let's mix both types

```java
class ReportGenerator {
    // Overloading (compile-time)
    void generate(String fileName) {
        System.out.println("Generating report: " + fileName);
    }

    void generate(String fileName, String format) {
        System.out.println("Generating " + format + " report: " + fileName);
    }
}

class PDFReportGenerator extends ReportGenerator {
    // Overriding (runtime)
    void generate(String fileName, String format) {
        System.out.println("Generating " + fileName + " in secure PDF format.");
    }
}

public class Main {
    public static void main(String[] args) {
        ReportGenerator r1 = new ReportGenerator();
        ReportGenerator r2 = new PDFReportGenerator();

        r1.generate("sales");
        r1.generate("sales", "HTML");     // compile-time (overloaded)
        r2.generate("sales", "PDF");      // runtime (overridden)
    }
}
```

---


# Examples: Basic inheritance and method overriding

```java
class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound...");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.makeSound(); // Woof! Woof!
        a2.makeSound(); // Meow!
    }
}
```

# Example 2: Greeting in Multiple Languages (Overriding)

```java
class Greeter {
    void greet() {
        System.out.println("Hello!");
    }
}

class SpanishGreeter extends Greeter {
    void greet() {
        System.out.println("¡Hola!");
    }
}

class FrenchGreeter extends Greeter {
    void greet() {
        System.out.println("Bonjour!");
    }
}

public class Main {
    public static void main(String[] args) {
        Greeter g1 = new SpanishGreeter();
        Greeter g2 = new FrenchGreeter();

        g1.greet(); // ¡Hola!
        g2.greet(); // Bonjour!
    }
}
```

Here, we have the same `greet()`, but it produces different behavior!


# Example 3: Shape Area Calculation

```java
abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double radius;
    Circle(double radius) { this.radius = radius; }
    double area() { return Math.PI * radius * radius; }
}

class Rectangle extends Shape {
    double width, height;
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    double area() { return width * height; }
}

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(4, 6);

        System.out.println("Circle area: " + s1.area());
        System.out.println("Rectangle area: " + s2.area());
    }
}
```

# Example 4: Payment System (Interface)

```java
interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

public class Main {
    public static void main(String[] args) {
        Payment p1 = new CreditCardPayment();
        Payment p2 = new PayPalPayment();

        p1.pay(120.0);
        p2.pay(85.5);
    }
}
```

# Example 5: Notification System

```java
interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SMSNotifier implements Notifier {
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Notifier[] notifiers = { new EmailNotifier(), new SMSNotifier() };

        for (Notifier n : notifiers) {
            n.send("System update available!");
        }
    }
}
```



