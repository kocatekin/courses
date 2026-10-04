# Types


In Javascript, what happens when you do `”5” + 3` ? It will give you `”53”`. Python will give you an error and Java will give you “53”. 

Let’s say we have a Python code:
```python
def print_length(text):
  print(text.upper())

print_length("hello") #works
print_length(42) #error
```

Python program will run without any errors, but when you want to print the length of an `integer`, it will give you an error. This error happens in **runtime** (while the program is running), therefore we call it **runtime error**. 

What happens when we try something similar in Java?

```java
public class Main {

    static void printLength(String text) {
        System.out.println(text.toUpperCase());
    }

    public static void main(String[] args) {
        printLength("hello");  // OK
        printLength(42);       // compile-time error
    }
}
```

Here, the program **will not compile**. Because Java is going to reject the `printLength(42)` line. Why? Because when creating the method we stated that the method parameter will be of type `String`. But now we changed it. The program will not even compile. Since this error happened in **compile time**, we call them **compile-time errors**.

This does not tell us that Java is a better language. This example shows us what the **type system** can do. 

- Types provide information.
- That information allows the compiler to *reason* about the program.
- That reasoning lets it reject certain invalid operations before runtime.

This is good because maybe we would have not seen it and it would create an issue for us.


For example, 
```java
Dog dog = new Dog();
dog.bark();
```

Compiler allows this method to run because the `dog` has type `Dog`, which itself have the `bark()` function. Therefore the compiler knows the contract of `Dog`.

**Typing is how the compiler knows what you are allowed to do with a value.**

## What is a type?

* A type is a set of values plus the operations allowed on them.
* A type error means applying an operation to a value that does not support it.


## The Four Axes

### Static vs Dynamic

In order to understand this, we need to ask the question: **When are types checked?**

- For **static typing**, the answer is: mainly before execution. (Java)
- For **dynamic typing**, the answer is: type validity is checked as the program executes. (Python)

Therefore we can say that Java is a **statically typed language** whereas Python is a **dynamically typed language**.

### Strong vs Weak

Ask the question: **How freely does the language allow values of one type to be treated as another?**

Java is generally considered **strongly typed**. For example:
```java
int x = 10;
String s = x; //not allowed
```

The code above is not allowed. If we want to make `10` into `”10”`, we need to explicitly convert it. `String s = String.valueOf(x)`.

However, a **weakly typed language** (Javascript) may perform more **implicit** coercions.

`”5” + 2` will produce `”52”`; while `”5” - 2` will produce `3`.



### Explicit vs Inferred

**Do programmers have to write the type, or can the compiler determine it?**


Java traditionally uses explicit typing:
```java
String name = "Alice";
Dog dog = new Dog();
```

However, Modern Java also performs **type inference**.

```java
var name = "Alice";
var dog = new Dog();
```

Here the compiler infers that `name -> String` and `dog -> Dog`. 

An important thing to remember is that even if Java allows `var x = “hello”`, it does not make Java dynamically typed language. Because the compiler still determines a fixed static type `x : String` and you cannot later do `x = 42`. 

**Type inference is not dynamic typing.**

### Nominal vs Structural

**What makes two types compatible? Their declared identity, or their shape?**

Java is primarily **nominally typed**.

Suppose that we have two classes `Student` and `Employee` with the same attribute `String name`. They will have the same structure, but that does not make them *interchangeable*.

```java
class Student {
    String name;
}

class Employee {
    String name;
}
```

The following does not hold:
```java
Student s = new Employee();   // compile-time error
```

If we want to do such thing we either use inheritance or interfaces. If we have `class Dog extends Animal`, that means `Dog` is explicitly declared as a **subtype** of `Animal` and therefore `Animal a = new Dog()` will work. Same goes for interfaces.

However, a structurally typed language such as Typescript focuses on the **shape**.

Example:
```TypeScript
interface Printable {
    print(): void;
}

class Report {
    print() {}
}
```

Here, a `Report` may be accepted as `Printable` because it has the required structure, even without explicitly declaring `implements Printable`. 



### Summary

| Axis | Java | Meaning |
|---|---|---|
| **Static vs Dynamic** | **Static** | Types are checked primarily at compile time. |
| **Strong vs Weak** | **Strong** | Java does not freely coerce unrelated types in unsafe ways. |
| **Explicit vs Inferred** | **Mostly explicit, with some inference** | Types are usually written, but Java can infer some types, e.g. `var` and generic type arguments. |
| **Nominal vs Structural** | **Nominal** | Type compatibility depends mainly on declared names and relationships such as `extends` and `implements`. |

---

## Subtyping and substitutability

We said that type is a set of values plus allowed operations. Now, what if one type is a *special case* of another? Is `Dog` also an `Animal`? What does this *also* provides us?

Anywhere that an `Animal` is expected, can I hand over a `Dog`? 

> S is a subtype of T if a value of type S can be used anywhere a value of Type T is expected.

```java

class Animal {
  void eat() { print("eating"); }
}

class Dog extends Animal {
  void bark() { print("woof"); }
}

class Cat extends Animal {
  void meow() { print("meow"); }
}

void feed(Animal a) {
  a.eat();
}
```

So, what will happen if I put a `Dog` or `Cat` inside `feed()`. It will work, because a `Dog` and `Cat` are actually `Animal`. 

> `Dog` is a subtype of `Animal`. `Animal` is a super type of `Dog`.

So, a **subtype** is a type that can be used in places where its **supertype** is expected. A useful informal way to understand sub typing is the **is-a relationship**.

However, if we did `void walkDog(Dog d)` and called with a `new Animal()` inside, it would not work because not every `Animal` is a `Dog`. 

If you treat a `Dog` as `Animal`, it is called **upcasting**. However, `(Dog) animal` is **downcasting**.


### Subtype vs Subclass

In ordinary Java class inheritance, subclassing creates subtyping.

```java
class Dog extends Animal {}
```

* Dog is a subclass of `Animal`.
* Dog is a subtype of `Animal`.

However, this may not hold for every programming language or every type system. For Java, the important practical rule is, both extends and implements keywords are subtype relationships.

### Substitutability

Subtyping becomes useful because of substitutability.

A subtype object should be usable wherever a supertype object is expected. Suppose we have:

```java
void feed(Animal animal) {
  animal.eat();
}
```

In that case all the following are valid:
```java
feed(new Animal());
feed(new Dog());
feed(new Cat());
```

Because `Dog` and `Cat` can substitute for an `Animal`.

So the definition we made earlier (If S is a subtype of T, then an object of type S can generally be used where an object of type T is expected.) means: **S can be substituted for T**.

- Subtyping does not mean same type.

Consider: `Animal animal = new Dog();`. Here the types are related, but they are not identical. `Dog` type and `Animal` types are not the same. The `Dog` type is more specific and `Animal` type is more general.

### Using General Types

Suppose that we write:

```java
void makeDogEat(Dog dog) {
	dog.eat();
}
```

This will work only for Dogs. If we later introduce a similar thing for `Cat`, we need to add another method. This will become repetitive. Instead, we can just use the general type and it will work with all subtypes!

```java
void feed(Animal animal) {
  animal.eat();
}
```

### Substitutability and Polymorphism

Substitutability is what makes subtype polymorphism possible.
Suppose:

```java
class Animal {
    public void speak() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("Meow");
    }
}
```

Now:

```java
void makeSpeak(Animal animal) {
    animal.speak();
}
```

can accept different subtypes:

```java
makeSpeak(new Dog());
makeSpeak(new Cat());
```

The method sees both values as: `Animal` but the runtime behavior differs.

### Polymorphic Collections

Substitutability also allows collections of a general type to store objects of different subtypes.

For example:

```java
Animal[] animals = {
    new Dog(),
    new Cat(),
    new Dog()
};
```

Each element here is statically treated as `Animal`. However, the runtime objects may differ.

We can write:

```java
for (Animal animal : animals) {
  animal.speak();
}
```

And Java dispatches to the appropriate override method.

### Substitutability is about expectations


## Static vs dynamic type and polymorphism

## Generics and variance

## Duck Typing
