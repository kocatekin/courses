# Composition

In previous lectures we saw that inheritance can create:

* tight coupling between classes
* force unwanted behavior down the hierarchy
* make systems hard to test and maintain

**Composition** solves this problem. It lets object to **contain** or **collaborate with** other objects instead of inheriting from them. 

# What is it?

Composition models the **has-a** relationship. 

* Here, a class contains *another class* as a **field**
* Contained object is often essential to the outer class. 
* If the container is destroyed, the part usually dies with it.

---

# Example

```java
class Course {
    String title;
    Course(String title) { this.title = title; }
}

class Teacher {
    String name;
    Course course;   // has-a relationship

    Teacher(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    void teach() {
        System.out.println(name + " is teaching " + course.title);
    }
}

public class Main {
    public static void main(String[] args) {
        Course oop = new Course("Object-Oriented Programming");
        Teacher t = new Teacher("Tugberk", oop);
        t.teach();
    }
}
```

Here, we have two classes: `Course` and `Teacher`. They are separate from each other, no inheritance. However, they have a relationship.

When we check the relationship, we can see that it is not:

* Teacher is a Course

but instead,

* Teacher has a Course.

So, we are going to use `Course` as something the `Teacher` **has**. As we remember, those are the **fields**. (We have the has, and can do.)

In the Main, we create a Course and we create the Teacher with that Course inside. In class, we will do more real-life examples.

---

# Composition vs Inheritance

| Aspect          | Inheritance (`is-a`)   | Composition (`has-a`)         |
| --------------- | ---------------------- | ----------------------------- |
| Relationship    | Hierarchical           | Containment                   |
| Coupling        | Tight (changes ripple) | Loose (objects collaborate)   |
| Flexibility     | Fixed at compile time  | Can be swapped at runtime     |
| Reuse mechanism | Extends parent code    | Delegates to contained object |
| Typical keyword | `extends`              | Field + method calls          |


---

# Example

Let's see a wrong use of Inheritance and later see how we can correct it by using Composition.

```java
class GPSModule {
    void track() { System.out.println("Tracking..."); }
}

class Truck extends GPSModule { } // “Truck is a GPSModule”? No!
```

Here, we do not have an *is-a* relationship.  But instead, we have **has-a** relationship! A Truck has a GPSModule.

So,
```java
class Truck {
    private GPSModule gps; // has-a

    Truck(GPSModule gps) {
        this.gps = gps;
    }

    void deliver() {
        gps.track(); // delegate
        System.out.println("Delivering cargo...");
    }
}
```

We will just use it like a *field* in Truck.

---

# Aggregation (Weak Composition)

In **aggregation**, the part can exist independently of the whole. For example, a `Department` may have `Employee`s who can *exist* **outside the department**.

```java
class Employee {
    String name;
    Employee(String name) { this.name = name; }
}

class Department {
    String name;
    List<Employee> employees = new ArrayList<>();

    Department(String name) { this.name = name; }

    void addEmployee(Employee e) { employees.add(e); }

    void listEmployees() {
        System.out.println("Department: " + name);
        for (Employee e : employees)
            System.out.println(" - " + e.name);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Harry");
        Department d = new Department("IT");
        d.addEmployee(e1);
        d.listEmployees();
    }
}
```

At this example, even if we destroy the Department object, employees will still live. 

---

# Composition and Delegation

Sometimes these are combined together, and we *delegate* work to the contained object.


```java
class Logger {
    void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}

class PaymentService {
    private Logger logger = new Logger(); // composed

    void processPayment() {
        logger.log("Payment started");
        // logic...
        logger.log("Payment completed");
    }
}
```

For example here, we have a PaymentService and it has `processPayment()` method. When it runs, it will run the `logger.log()`. Logger here is a separate class, but is used as a field. However, it has its own public methods and we can delegate the *logging* to that.