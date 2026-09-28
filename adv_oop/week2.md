# Advanced Object-Oriented Programming
## Week 2 — Class Relationships and UML
### Lecture Notes


---

# 1. Learning Objectives

1. Explain why object-oriented systems require relationships between classes.
2. Distinguish between **is-a** and **has-a** relationships.
3. Explain and recognize:
   - association,
   - aggregation,
   - composition,
   - dependency,
   - inheritance.
4. Read and write basic UML class diagrams.
5. Interpret multiplicities such as:
   - `1`,
   - `0..1`,
   - `0..*`,
   - `1..*`.
6. Explain the difference between a simple object reference and semantic ownership.
7. Explain how composition differs from aggregation.
8. Recognize when a relationship should become a first-class object, such as `Enrollment`.
9. Translate simple UML relationships into Java code.
10. Explain how a domain model can guide database and AI-assisted application development.

---

# 2. Why Relationships Matter

Beginning OOP examples often focus on isolated classes:

```java
public class Student {
    private String name;
    private int studentNumber;

    public Student(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }
}
```

Real applications do not consist of isolated classes.

A university system may contain:

```text
Student
Course
Instructor
Department
Enrollment
```

An e-commerce system may contain:

```text
Customer
Order
OrderLine
Product
Payment
Shipment
```

The important design question is therefore not only:

> What classes do I need?

It is also:

> How do these classes relate to each other?

Examples:

- A student **enrolls in** a course.
- An order **contains** order lines.
- An order line **refers to** a product.
- A service **uses** another service.
- A car **is a** vehicle.

Object-oriented design is partly the study of these relationships.

---

# 3. IS-A vs HAS-A

This is the first major distinction.

## 3.1 IS-A

An **is-a** relationship usually represents **inheritance** or **subtyping**.

```java
public class Vehicle {
    public void start() {
        System.out.println("Vehicle started.");
    }
}
```

```java
public class Car extends Vehicle {
    public void openTrunk() {
        System.out.println("Trunk opened.");
    }
}
```

We can say:

```text
Car IS-A Vehicle
```

In UML:

```text
        Vehicle
           △
           |
          Car
```

A useful test is:

> Can I naturally say "X is a Y"?

Examples:

```text
Car is a Vehicle.          ✓
Dog is an Animal.          ✓
Manager is an Employee.    ✓

Car is an Engine.          ✗
Student is a University.   ✗
Order is a Customer.       ✗
```

If the statement is conceptually false, inheritance is probably inappropriate.

---

## 3.2 HAS-A

A **has-a** relationship means that one object contains, stores, owns, or refers to another object.

```java
public class Engine {
}
```

```java
public class Car {
    private Engine engine;
}
```

We can say:

```text
Car HAS-A Engine
```

But "has-a" is only a broad idea.

A reference may represent:

- association (weakest)
- aggregation, (medium)
- composition. (strongest)

The main question becomes:

> What is the semantic meaning of the relationship?

---

# 4. UML Class Diagrams

UML stands for **Unified Modeling Language**.

A UML class diagram can represent:

- classes,
- attributes,
- operations,
- visibility,
- inheritance,
- associations,
- multiplicity,
- dependencies,
- aggregation,
- composition.

A basic class:

```text
+-----------------------------+
|          Customer           |
+-----------------------------+
| - name: String              |
| - email: String             |
+-----------------------------+
| + getName(): String         |
| + placeOrder(): void        |
+-----------------------------+
```

The three areas are:

1. class name,
2. attributes,
3. operations.

---

## 4.1 Visibility

| Symbol | Meaning |
|---|---|
| `+` | public |
| `-` | private |
| `#` | protected |
| `~` | package/default |

Example:

```text
- balance: double
+ deposit(amount: double): void
# validateAmount(amount: double): boolean
```

---

## 4.2 Java to UML

Java:

```java
public class BankAccount {

    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
```

UML:

```text
+--------------------------------------+
|             BankAccount              |
+--------------------------------------+
| - accountNumber: String              |
| - balance: double                    |
+--------------------------------------+
| + BankAccount(accountNumber: String) |
| + deposit(amount: double): void      |
| + getBalance(): double               |
+--------------------------------------+
```

---

# 5. Association (uses-a)

An **association** represents a structural relationship between two classes.

A useful beginner description is:

> One object knows about or is structurally connected to another object.

UML:

```text
Student -------- Course
```

Example:

```java
public class Course {

    private String code;
    private String title;

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }
}
```

```java
public class Student {

    private String name;
    private Course currentCourse;

    public Student(String name) {
        this.name = name;
    }

    public void enroll(Course course) {
        this.currentCourse = course;
    }
}
```

`Student` refers to a `Course`.

However:

- the student does not own the course,
- deleting one student should not eliminate the course, (course still stayss)
- a field reference does not automatically mean composition.

- These two are two different entities in the domain that interact through a business action (enrollment).


---

# 6. Multiplicity

Multiplicity describes **how many objects** may participate in a relationship.

| Multiplicity | Meaning |
|---|---|
| `1` | exactly one |
| `0..1` | zero or one |
| `*` | many |
| `0..*` | zero or many |
| `1..*` | one or many |
| `2` | exactly two |
| `2..5` | between two and five |

A critical rule:

> **The multiplicity written near one end tells you how many objects of that class may be associated with one object at the opposite end.**

Example:

```text
Customer 1 -------- 0..* Order
```

This means:

- each `Order` is associated with one `Customer`,
- each `Customer` may have zero or many `Order` objects.

---

## 6.1 One-to-One

```text
Person 1 -------- 0..1 Passport
```

Possible Java:

```java
public class Person {

    private String name;
    private Passport passport;

    public Person(String name) {
        this.name = name;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
```

---

## 6.2 One-to-Many

```text
Customer 1 -------- 0..* Order
```

Possible Java:

```java
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }
}
```

---

## 6.3 Many-to-Many

```text
Student * -------- * Course
```

This means:

- a student may take many courses,
- a course may contain many students.

But many-to-many relationships often contain information themselves.

For example:

```text
registrationDate
grade
attendance
status
```

That leads to an important design idea.

---

# 7. When the Relationship Becomes an Object

Start with:

```text
Student * -------- * Course
```

Suppose we must store:

```text
grade
attendance
registrationDate
status
```

These values do not naturally belong only to `Student` or only to `Course`.

A better model is:

```text
Student 1 -------- 0..* Enrollment

Course  1 -------- 0..* Enrollment
```

Java:

```java
import java.time.LocalDate;

public class Enrollment {

    private final Student student;
    private final Course course;
    private final LocalDate registrationDate;
    private Double grade;

    public Enrollment(
            Student student,
            Course course,
            LocalDate registrationDate) {

        this.student = student;
        this.course = course;
        this.registrationDate = registrationDate;
    }

    public void assignGrade(double grade) {
        this.grade = grade;
    }
}
```

Now `Enrollment` is a first-class domain concept.

Other examples:

```text
Employee + Project  -> Assignment
Doctor + Patient    -> Appointment
Product + Order     -> OrderLine
Student + Course    -> Enrollment
Player + Match      -> PlayerStatistics
```

---

# 8. Navigability

Navigability answers:

> Which object can directly navigate to the other?

Example:

```java
public class Order {
    private Customer customer;
}
```

Informally:

```text
Order --------> Customer
```

This means that `Order` directly knows its `Customer`.

If `Customer` also stores its orders:

```java
public class Customer {
    private List<Order> orders;
}
```

then the relationship is bidirectional.

Bidirectional relationships can be useful, but they create more coupling and must remain consistent.

For example:

```java
public void addOrder(Order order) {
    orders.add(order);
    order.setCustomer(this);
}
```

> The arrows used in these notes are simplified teaching notation for navigability. UML tools may show navigability differently.

---

# 9. Aggregation

Aggregation represents a **weak/shared whole-part** relationship.

Traditional example:

```text
Team ◇-------- Player
```

The common intuition is:

- a team contains players,
- a player remains independently meaningful outside the team.

Java:

```java
public class Player {

    private final String name;

    public Player(String name) {
        this.name = name;
    }
}
```

```java
import java.util.ArrayList;
import java.util.List;

public class Team {

    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }
}
```

Usage:

```java
Player player = new Player("Ali");

Team team = new Team();
team.addPlayer(player);
```

The player exists independently of the team.

---

# 10. Composition

Composition represents a **strong whole-part relationship**.

The whole conceptually owns the part.

UML:

```text
Order ◆-------- OrderLine
```

Typical example:

```text
Order
 |
 +---- OrderLine
 +---- OrderLine
 +---- OrderLine
```

An `OrderLine` such as:

```text
Product = Laptop
Quantity = 2
```

is primarily meaningful as part of a particular order.

---

## 10.1 Java Example

```java
public class Product {

    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
```

```java
public class OrderLine {

    private final Product product;
    private final int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
}
```

```java
import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<OrderLine> lines = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));
    }
}
```

The `OrderLine` is created inside `Order` here, but this is not what defines composition.

> **Composition is about semantic ownership, not about which class calls `new`.**

A part may be created elsewhere and still belong to one composite whole.

---

# 11. Aggregation vs Composition

| Question | Aggregation | Composition |
|---|---|---|
| Whole-part relationship? | Yes | Yes |
| Ownership | weak/shared | strong |
| Independent identity | usually yes | usually no |
| Lifecycle/identity tied to whole | weakly | strongly |
| UML | hollow diamond | filled diamond |
| Example | `Team ◇-- Player` | `Order ◆-- OrderLine` |

A useful question is:

> If the whole disappeared from the domain, would this particular part still have an independent identity or purpose?

For example:

```text
Team ◇-------- Player
```

If the team stops existing, a player still makes sense independently.

But:

```text
Order ◆-------- OrderLine
```

If the order disappears as a domain concept, that particular order line no longer has an independent purpose.

---

# 12. A Field Does Not Tell You the Relationship

Consider:

```java
public class OrderLine {
    private Product product;
}
```

A beginner might say:

> OrderLine has Product, therefore composition.

That is wrong.

We must ask:

> Does the `OrderLine` own the `Product`?

No.

The product exists independently in the product catalog.

Therefore:

```text
OrderLine * -------- 1 Product
```

is ordinary association.

This distinction is essential:

> A Java field tells us that a reference exists.  
> The domain tells us what that reference means.

---

# 13. Dependency

A dependency is usually weaker than an association.

A class depends on another class when it **uses** that class to perform some work.

UML usually uses a dashed arrow:

```text
ReportService - - - - > PdfWriter
```

A useful simplification is:

```text
Association = structurally knows
Dependency  = temporarily uses
```

---

## 13.1 Method Parameter Dependency

```java
public class EmailService {

    public void sendWelcomeEmail(User user) {
        System.out.println(user.getEmail());
    }
}
```

`EmailService` depends on `User`, but it does not necessarily store a `User`.

---

## 13.2 Local Variable Dependency

```java
public class InvoiceService {

    public void createInvoice() {
        PdfDocument document = new PdfDocument();

        document.addText("Invoice");
        document.save();
    }
}
```

`InvoiceService` depends on `PdfDocument`.

---

## 13.3 Association vs Dependency

Compare:

```java
public class ReportGenerator {

    private PdfWriter writer; //held in state

    public ReportGenerator(PdfWriter writer) {
        this.writer = writer;
    }
}
```

with:

```java
public class ReportGenerator {

    public void generate(PdfWriter writer) {
        writer.write("Report");
    }
}
```

The first represents a structural relationship more naturally.
* `ReportGenerator` holds a **reference** to `PdfWriter` as part of its internal **state**.
* As long as the `ReportGenerator` instance lives in memory, it retains that connection to `PdfWriter`.
* It has it configured and it is ready to use.
  

The second is a temporary use.
* `ReportGenerator` do not store the `PdfWriter`. Writer is passed in, used to execute a single task, and immediately discarded once the method finishes.
* Relationship exists **only while** `generate()` is running on the call stack.
* A `ReportGenerator` does not own or hold a `PdfWriter`, simply uses it to perform some tasks.


Do not treat this as a syntax-only rule. The design meaning matters.

We need to ask the question: **Does this object belong to the long-term configuration of my class, or is it just an input to a specific action?**

* If it's configuration / long-term state $\rightarrow$ Field (Association).
* If it's an input / temporary tool for one method $\rightarrow$ Method Parameter (Dependency).

---


# 15. Inheritance vs Composition

Consider this bad design:

```java
public class Engine {
}
```

```java
public class Car extends Engine {
}
```

This says:

```text
Car IS-A Engine
```

which is false.

Better:

```java
public class Car {
    private Engine engine;
}
```

Now:

```text
Car HAS-A Engine
```

A famous design guideline is:

> Favor composition over inheritance.

This does **not** mean:

> Never use inheritance.

It means:

> Do not use inheritance merely for code reuse.

Inheritance should represent a meaningful subtype relationship.

---

## 15.1 Bad Inheritance for Code Reuse

```java
public class FileLogger {

    public void log(String message) {
        System.out.println(message);
    }
}
```

Bad:

```java
public class OrderService extends FileLogger {

    public void placeOrder() {
        log("Order placed.");
    }
}
```

This implies:

```text
OrderService IS-A FileLogger
```

which is conceptually wrong.

Better:

```java
public class OrderService {

    private final FileLogger logger;

    public OrderService(FileLogger logger) {
        this.logger = logger;
    }

    public void placeOrder() {
        logger.log("Order placed.");
    }
}
```

Now `OrderService` collaborates with `FileLogger`.

This idea will become important later in:

- testing,
- dependency injection,
- SOLID,
- Strategy,
- Decorator.

---

# 16. Worked Example — University Registration

Requirements:

> Students enroll in courses.  
> Each enrollment stores registration date, attendance, status, and grade.

Naive model:

```text
Student * -------- * Course
```

Better model:

```text
Student 1 -------- 0..* Enrollment

Course  1 -------- 0..* Enrollment
```

Why?

Because:

```text
grade
attendance
registrationDate
status
```

describe the **relationship between one student and one course**.

* They do not describe the student globally.

* They do not describe the course globally.


---

# 17. Worked Example — E-Commerce

Requirements:

> A customer places orders.  
> Each order contains one or more order lines.  
> Each order line refers to one product and stores a quantity.

Possible model:

```text
Customer 1 -------- 0..* Order

Order 1 ◆----------- 1..* OrderLine

OrderLine * -------- 1 Product
```

* A `Customer` places zero or many orders, but each `Order` belongs to exactly one `Customer`. A Customer can exist without any orders. If an `Order` is deleted or cancelled, `Customer` still exists. This is standard association.
* An `Order` owns one or more `OrderLine`. An `Order` must have at least one `OrderLine`. An `OrderLine` cannot exist without an Order. If an `Order` is deleted, all `OrderLine` are gone with it. An `OrderLine` has no independent meaning or existence outside `Order`. Here we have **composition**.
* Each `OrderLine` specifies exactly one `Product`. But a single `Product` can be in many `OrderLines`. Standard association.


Why?

### Customer → Order

A customer can exist without placing an order.

Therefore ordinary association is reasonable.

### Order → OrderLine

An order line belongs to a particular order.

Therefore composition is reasonable.

### OrderLine → Product

A product exists independently of any one order.

Therefore ordinary association is appropriate.

---

## 17.1 A Useful Invariant Discussion

The UML says:

```text
Order 1 ◆-------- 1..* OrderLine
```

That means a valid order must contain at least one order line.

But this Java code:

```java
public class Order {

    private final List<OrderLine> lines = new ArrayList<>();
}
```

allows an empty order to exist temporarily.

This raises a design question:

> Should the class allow a temporarily incomplete object, or should the invariant be enforced immediately?

This question will return later when discussing:

- validation,
- exceptions,
- constructors,
- object invariants.

---

# 18. From Requirements to an Object Model

A useful modeling process is:

```text
Requirements
    ↓
Candidate concepts/classes
    ↓
Responsibilities
    ↓
Relationships
    ↓
Multiplicity
    ↓
Ownership
    ↓
UML model
```

A beginner technique is to first identify important nouns and verbs.

Example:

> A customer places orders. Each order contains one or more order items. Each order item refers to one product.

Candidate nouns:

```text
Customer
Order
OrderItem
Product
```

Relationship verbs:

```text
places
contains
refers to
```

Possible model:

```text
Customer 1 -------- 0..* Order

Order 1 ◆----------- 1..* OrderItem

OrderItem * -------- 1 Product
```

Not every noun becomes a class.

For example:

```text
name
quantity
price
date
```

may simply become attributes or value types.

Likewise, not every verb becomes a method.

Modeling requires interpretation.

---

# 19. UML and Database Design

UML class diagrams and database schemas are closely related, but they are **not identical**.

A UML class diagram describes the domain/object model:

- important concepts,
- relationships,
- ownership,
- multiplicity,
- responsibilities.

A relational schema describes persistence:

- tables,
- primary keys,
- foreign keys,
- constraints,
- indexes,
- normalization.

A useful mental model is:

```text
Requirements
    ↓
Domain Model / UML
    ↓
Persistence Design
    ↓
Database Schema
```

Example:

```text
Student * -------- * Course
```

may become:

```text
students
courses
enrollments
```

If `Enrollment` has:

```text
grade
attendance
registrationDate
status
```

then it is both:

- a meaningful domain object,
- a natural persistence structure.

Avoid simplistic equations such as:

```text
class = table
association = foreign key
composition = ON DELETE CASCADE
```

These mappings may sometimes be reasonable, but they are not definitions.

---

# 20. Domain Model vs Technical Representations

A domain relationship:

```text
Order 1 ◆-------- 1..* OrderLine

OrderLine * -------- 1 Product
```

might become Java:

```java
public class Order {
    private List<OrderLine> lines;
}
```

and relational tables:

```text
orders
order_lines
products
```

and an API representation:

```json
{
  "orderId": 1001,
  "items": [
    {
      "productId": 42,
      "quantity": 2
    }
  ]
}
```

These are different technical representations of the same domain meaning.

---

# 21. Why Modeling Matters in AI-Assisted Development

Consider this prompt:

```text
Build an e-commerce backend.
```

An AI system must guess:

- entities,
- relationships,
- multiplicities,
- ownership,
- constraints,
- persistence structure.

Now compare it with:

```text
Customer 1 -------- 0..* Order

Order 1 ◆----------- 1..* OrderLine

OrderLine * -------- 1 Product
```

plus rules:

```text
- Products exist independently of orders.
- Every OrderLine belongs to one Order.
- A valid Order contains at least one OrderLine.
- Removing an Order must not imply removing Products.
```

The model provides far more semantic information.

A modern workflow may look like:

```text
Requirements
    ↓
Domain model
    ↓
Classes + relationships + multiplicities + constraints
    ↓
AI-assisted generation
    ↓
ORM models / schema / migrations / APIs / tests
    ↓
Human review and validation
```

The key idea:

> **AI reduces implementation effort; it does not eliminate the need for correct modeling.**

As implementation becomes easier to generate, the ability to define, communicate, and review the model becomes more important.

---

# 22. Lecture Summary

The most important ideas are:

```text
Inheritance
    IS-A

Association
    KNOWS-A / RELATED-TO

Aggregation
    WHOLE-PART
    weak/shared ownership

Composition
    WHOLE-PART
    strong ownership

Dependency
    USES-A
```

Multiplicity:

```text
1
0..1
0..*
1..*
```

Key modeling examples:

```text
Student ---- Enrollment ---- Course
```

and:

```text
Customer 1 -------- 0..* Order

Order 1 ◆----------- 1..* OrderLine

OrderLine * -------- 1 Product
```

The main skill is not memorizing UML symbols.

It is being able to explain:

- what the important domain concepts are,
- how they relate,
- which relationships imply ownership,
- how many objects may participate,
- whether a relationship itself deserves to become an object,
- whether generated code or database structures actually match the intended model.

