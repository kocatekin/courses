# Dependency Injection

## Tight coupling

In object-oriented systems, a class is **tightly coupled** when:
* it directly creates or depends on a specific concrete class. 
  * This reduces flexibility and makes systems difficult to maintain, extend, and test.

Example of tight coupling:
```java
public class OrderService {

    private Database database = new Database();

    public void placeOrder(String product) {
        database.connect();
        database.save(product);
    }
}
```

Here there are problems:
* `OrderService` depends on a concrete class (`Database`)
* Changing the database requires modifying `OrderService`
* Unit testing is difficult

## DI: Dependency Injection

Dependency Injection is a design technique where an object receives its dependencies from an external source rather than creating them internally.

So, we are going to use **interfaces** to decouple the code.

We introduce an interface that represents the *dependency*.

```java
public interface DataStore {
    void connect();
    void save(String data);
}
```

**Benefits**:
* Removes direct dependency on concrete classes
* Enables polymorphism
* Allows easy replacement of implementations

---

Now, for *DataStore* we can have different solutions: MySqlDatabase, FileStorage, etc.

```java
public class MySqlDatabase implements DataStore {

    @Override
    public void connect() {
        System.out.println("Connected to MySQL database");
    }

    @Override
    public void save(String data) {
        System.out.println("Saved to MySQL: " + data);
    }
}
```

```java
public class FileStorage implements DataStore {

    @Override
    public void connect() {
        System.out.println("Opened file storage");
    }

    @Override
    public void save(String data) {
        System.out.println("Saved to file: " + data);
    }
}
```

---

## Constructor Injection (Preferred Approach)

We refactor the `OrderService`.

```java
public class OrderService {

    private final DataStore dataStore;

    public OrderService(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public void placeOrder(String product) {
        dataStore.connect();
        dataStore.save(product);
        System.out.println("Order placed for " + product);
    }
}
```

Why?
* Dependencies are explicit
* Object is always in a valid state
* Encourages immutability
* Easiest to test

---

Later, we move the object creation is moved outside business logic.

```java
public class Main {
    public static void main(String[] args) {

        DataStore mySql = new MySqlDatabase();
        OrderService orderService1 = new OrderService(mySql);
        orderService1.placeOrder("Laptop");

        DataStore file = new FileStorage();
        OrderService orderService2 = new OrderService(file);
        orderService2.placeOrder("Phone");
    }
}
```

---

## Benefits of dependency injection

* Loose coupling
* Easier maintenance
* Better testability
