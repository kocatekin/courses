# Exceptions

* An **exception** is an event that occurs during program execution that **disrupts** the normal flow of instructions. 
* In Java, exceptions are *objects* that represent error conditions.


If we don't have exceptions, we would have to **manually check** after every operation. By using exceptions we can have:
- Cleaner code
- Consistency
- Readability.

Cleaner code helps us separate *normal logic* from *error-handling logic*. So our program is going to be the same and the exception will be separately handled.

Consistency -> All Java code handles errors in the same structured way.

Readability -> Again, logic is not cluttered with `if` checks.

In the following example, we want to read data from a file without using exceptions:

```java
String text = readFromFile("data.txt");
if (text == null){
   System.out.println("Error reading file");
}
else {
   System.out.println(text);
}
```

Here, we manually check if the text is null or not. If not, we are going to print it. If we don't check this, the system is going to shut down with an error (FileNotFound). Obviously, we don't want the program to shut down. That's why we need to **handle** these errors.

Now we are going to try this with an Exception.
```java
try {
   String text = readFromFile("data.txt");
   System.out.println(text);
} catch (IOException e) {
   System.out.println("Error reading file: " + e.getMessage());
}
```

In these examples, we are *catching* errors and handling them. Now the program is not going to shut down, but print out an error message, informing us about the issue.

---

## Checked vs Unchecked

**Checked Exceptions:**
- These occur due to **external** factors which are outside the program's control.
- They must be declared in method signature using `throws` or caught in a `try..catch` block.


```java
public void readFile(String filename) throws IOException {
   FileReader fr = new FileReader(filename);
}
```

For example here, we are not using `try..catch`, but we are using `throws`. 

**Unchecked Examples**
- These are usually caused by programming errors.
- Not required to declare or handle.
- Examples:
   - `NullPointerException`
   - `ArrayIndexOutOfBoundsException` etc.

```java
int[] nums = {1,2,3};
System.out.println(nums[5]);
```

This here is an `ArrayIndexOutOfBoundsException`. 

---

## Try, catch, finally

This is the basic syntax:

```java
try {
    // risky code
} catch (ExceptionType e) {
    // handling code
} finally {
    // cleanup code (always runs)
}
```

Let's do this example in reading a file.

```java
try {
    FileReader reader = new FileReader("data.txt");
    int ch;
    while ((ch = reader.read()) != -1) {
        System.out.print((char) ch);
    }
    reader.close();
} catch (IOException e) {
    System.out.println("File error: " + e.getMessage());
} finally {
    System.out.println("File read attempt complete.");
}
```

Here, we use `try` for the operations which can throw an error. `catch` handles that by catching the error. But, we only check for IOException here. It is possible to have multiple `catch` blocks. `finally` always works! 


