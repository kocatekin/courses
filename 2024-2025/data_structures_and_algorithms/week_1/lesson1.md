# Data Representation


* How do we define data?
* Computers doesn't know English.
  * 0 and 1
  * Binary
* Computers speak binary.
  * We need to turn data into computer language


---

In short, we need to be able to turn data into binary so that computers can understand. We built systems for this purpose. How will you define some character data for the computer then? 

---

# Binary

* Writing 0 and 1 all the time can be hard.
* Bytes
  * 8 bits
* Words
  * group of bytes (e.g. 16-bit, 32-bit)

---

# Binary Example

---

# ASCII 

* Define letters as numbers
  * So we can turn them to binary easily.
* A = 65
  * This is **encoding**
  * When the computer see 65, it will understand **A**
    * We can create our own encoding too!
  

---
# ASCII Char Table Example

| Decimal | Binary    | Character |
|---------|-----------|-----------|
| 65      | 01000001  | A         |
| 66      | 01000010  | B         |
| 97      | 01100001  | a         |
| 98      | 01100010  | b         |

---

# Coding Example



---

# Unicode

* ASCII is good and enough for English.
  * But not for emojis, different characters etc
* A *superset* of ASCII
* Provides a unique number for each character
* Can be encoded in different ways
  * UTF-8 is the most common
    * You will see it when writing HTML code
    * `<meta charset='utf-8'>`

---

# Encoding

* Base64
  * Used to encode binary data
    * Binary data: (bin files)
    * Images, files, etc.
  * Turns binary data into plain-text
* However it increases the size of data.
* Uses a set of 64 characters.
  * (a-z)(A-Z)(0-9)(+ and /)
* There are also other versions:
  * Base16 (hex), base32, base58 etc.

---

# Example

![alt text](image.png)

---

# Review

* What is wrong here?
```cpp
if (x < y) {
    cout << "x is less than y\n";
}
else if (x > y) {
    cout << "x is larger than y\n";
}
else if (x == y) {
    cout << "x is equal to y\n";
}
```

---

Why are we using `==` instead of `=` in if/else?

---

# Data types vs data structures

* `int`, `string` etc.
  * These are **data types**
  * They come before or after the *variable name* in languages with *static typing*

```c++
int x;
string y;
```
---

# Types

* **Static typing**
  * Variable types are checked at **compile time**
  * Must declare the type before using it.
  * C, C++, Java, etc. Generally *compiled* languages
* **Dynamic typing**
  * Variable types are checked at **runtime**.
  * Don't need to declare the type explicitly.

---

# Types

* **Strong typing**
  * If the language *enforces* rules about typing, it is called *strongly typed*.
  * They often provide *type safety*
  * If you want to change types, you need to **explicitly** do it. `(int) x`
  * Python, Java, Haskell
```python
x = "10"
y = 5
print(x+y)
```
---

# Types

* **Weak typing**
  * If it allows **implicit** type conversions between incompatible types.
  * Language might automatically convert data types to perform operations.
  * Javascript, PHP

```javascript
x = "10";
y = 5;
console.log(x+y);
```

---

# Types

* **Duck typing**
  * Form of dynamic typing
* **Type inference**
  * Ability of the programming language to automatically deduce the type of a variable
  * `let x = 2`, `x = 2`

---

# Compiler

* Compiled Languages
  * Translates *source code* into *machine code* **or** *bytecode*.
  * C, C++, Rust, Go, etc.
  * The resulting code is run by the **hardware** (CPU) or **virtual machine** (JVM).
  * `gcc`, `clang`, `g++` are examples
  * Many times used with *build tools* such as `make`

---

# Interpreter

* Reads and executes source code line by line.
* Instead of turning it into a *machine code* or *bytecode*, it just runs each line at runtime.
* Python and Javascript are *interpreted* languages.
  * It doesn't matter there is no *compilation* involved.


---

# How Python works?

* CPython turns the *source code* into *bytecode*.
  * It is a *lower-level* representation.
  * Closer to machine language.
  * Bytecode is stored in `pyc` files. Portable across platforms.
* CPython **interprets** the bytecode using a **virtual machine**.
  * Called PVM. (Similar to JVM)
  * It executes the bytecode **line by line**.
    * That is why it is an *interpreted* language.
* In the latest Python, they added a JIT compiler.

---

# Compiler types

* JIT (Just in Time)
  * Compiles code during **runtime**.
    * Creates an overhead but has advantage of dynamic optimizations.
* AOT (Ahead of time)
  * Compiles code into machine code before the program runs.
  * Faster startup time but less flexible for optimization.

---

# How Javascript works?

* Executed by a Javascript engine. 
  * Every web browser has a JS engine.
  * Chrome: **V8**.
  * Firefox: **Spidermonkey**.
  * Safari: **Nitro**
* Engine translates source code into bytecode
  * Or into *machine code* using JIT.

---

# Pointers

```C++
string food = "lahmacun";
cout << food + "\n";
cout << &food;
```
* What is the second output?
  * It is the **memory address** where the variable is stored!

* A **pointer** is a **variable** which stores the **address number** as the value.
```c++
string food = "lahmacun";
string *ptr = &food; //same as string* ptr
cout << ptr; //gives the address
cout << *ptr; //gives what?
```
* Here, we are storing the **address** of `food` in the `ptr` pointer.

---
# Pointers

```c++
string food = "lahmacun";
string *ptr = &food;
cout << "food is: " << food << "\n";
cout << "address:  " << ptr << "\n";
cout << "ptr value: " << *ptr << "\n";
*ptr = "pide";
cout << "----------";
cout << "food is: " << food << "\n";
cout << "address:  " << ptr << "\n";
cout << "ptr value: " << *ptr << "\n";
```


---

# Pass by value & Pass by reference

* Very important concepts
* They determine how function arguments are passed.
  * How do they affect the original variable


## Pass by value
* Copy of the variable's value is passed to function
  * Changes done within the function will not affect the global variable.
## Pass by reference
* The reference or **memory address** is passed to function.
  * Any changes to the parameter here will change the original value.
---

# Example

```c++
void modifyValue(int &x){
    x = 10;
}
int main(void) {
    int a = 5;
    modifyValue(a);
    cout << a;
}
```

What is the output?

---

# Example

```c++
void modifyValue(int x){
    x = 10;
}

int main(void){
    int a = 5;
    modifyValue(a);
    cout << a;
}
```

What is the output?

---
# Scope

* Refers to the region of the program where a variable is defined and accessible.
* **Global scope**
  * Variables declared outside of any function or block.
  * Accessible throughout the program.
* **Local scope**
  * Variables declared in a function or block.
  * Only accessible within that region.

---

# Example

```c++
int x = 5;
int main(void) {
    cout << x;
}
```
`x` here is declared in global scope.
* However, everytime we write a `for` loop:
  * `for(int i=0;i<5;i++)` the `i` is in **local scope**.
  * You cannot reach it outside the for loop. It will give an error.


---
# Side Effects

* When a function is run, it is possible that it can change some **global** variables.
  * This is called a **side effect**
```c++
int x = 5;
int main(void){
    x++;
    cout << x; //6
}
```

---

# For vs While loops

* For is ideal for *count-controlled* iterations when you know the number of iterations.
* While is ideal for *condition-controlled* iterations when the iteration number is unknown.
## Infinite loops
* `while True`
* `for(;;)`

---

# Function vs Method

* A *method* belongs to a class/object.
  * In C, there are no methods. Why?
* A function can also be a called a *global function* where it is a separate function.
  * Not bound to any class or object.

When we say a programming language is object oriented, it does not mean that we **must** program in that way. But the programming language is designed like that.
* *e.g.* In Java, a *string* is a class. 
```java
String s = "hello";
System.out.println(s.length());
```
Wait! If `String` is a class, why not use `new` keyword?

---







