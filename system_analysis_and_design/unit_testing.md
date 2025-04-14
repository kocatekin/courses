---
marp: true
paginate: true
---

# Unit testing

- Testing is important for every product. You would not want to fly in an **untested** aircraft. Untested means something *built*, but never verified. 

- However, **individual parts** must be verified before **integrating** them with other parts.
	- Later, we need to **verify** and **test** the **integrated** subsystems.
 - If we test every part, we can make sure that they are working **independently**.
    - That means if a new part breaks the system, the problem is related to the recently added part. We can now track down and fix it.

---


- Programs consists of many smaller pieces such as *classes*, *methods*, *packages*, etc.
- **Unit** is a generic term for these smaller pieces.
- There are 3 important types of **software testing**:
	- Unit testing (testing units in isolation)
	- Integration testing (testing integrated units)
	- System testing (testing the entire system)
	
- Unit testing is done to test the **smaller pieces in isolation**, before they are combined with other pieces.
- Unit tests are written by the programmer. (You test your own code)

---

* Unit tests create objects, call methods and verify that the **returned** results are correct.
   - Actual results vs expected results

* Unit tests should be automated so they can run frequently.
   - So we ensure that any changes done to code have not broken it.
      - This is called **regression testing**
      - Aims to catch if there is something wrong after modifications to code

---

# Test Drivers

* Tests are run by a test driver.
   * A program that runs all of the unit test cases
* It should be easy to add new tests to test drivers
* After running it, it either tells you everything worked or gives you a list of tests that failed.
* Running tests and checking the results should not be cumbersome.

---

# Tests

- Unit tests
   - Focused, low-level. Test individual methods or pieces of methods
   - Control is easier to ensure that each piece of code is tested
   - Easier to write and run
   - May not catch problems coming from interactions between different pieces of code.
- System Tests
   - Good for making sure all pieces work together
   - Can generate more complex interactions between pieces
   - Harder to write and run

---

# Why write tests?

- Bugs are found earlier in the development cycle are much chapter to fix than those found later
- Makes it easier to refactor code later
- Engineers should write their own unit tests.
   - QA should only run the unit tests written by engineers
- There are unit testing frameworks for most languages
   - Junit
   - cppunit, gtest
   - unittest, pytest
   
---

# Technical Debt

- Referred to as *tech debt* or *code debt*.
- Happens when speedy delivery is prioritized over perfect code.
   - Accumulates costs when dev teams take shortcuts or make compromises
   - Does not refer to a single thing:
      - Bugs, missing documentation, etc.
- In agile, there is a tradeoff between launching later and technical debt
- Accumulates over time, making it costly to address in the future.
- Can hinder productivity and slow down development.

---

# Software Testing Approaches

- White box testing
  - Testing the internals
  - Not the functionality of the program
  - Done by programmers
- Black box testing
  - Don’t know how it works
  - Don’t need to!

---

# White-box Testing

- Testing the internal structures or workings of an application
   - Not the functionality
- Testers have full visibility into the source code, architecture and configuration.
- Checks for possible code optimization, examines how code flows through the software and looks into the security and integration of components.
- Methods
   - Code path testing, code coverage analysis, unit testing, integration testing and static code analysis.
   - Typically conducted by developers.

---

# Black-box Testing

- Treats the software as a black-box. Have no idea about the internal implementations.
- Testers evaluate the software by providing inputs and examines the outputs
   - Ensures that the software behaves as expected under various conditions.
- Concentrates on the functionality and UX of the application.
   - Verifies business requirements, checks for unexpected behavior of inputs, ensures software meets the user expectations.
- Methods:
   - Functional testing, system testing, user acceptance testing, performance and usability testing.
- Usually done by QA engineers.

---

# Assert

`assert` is used to validate conditions and assumptions during program execution. It is not used in production code but can be used in development process.

If the assertion made is wrong, the program stops execution and it raises an `AssertionError`. If the assertion made is true, program continues execution. Therefore, sometimes it is also good to check the state. 

It is a tool to verify the assumptions in the code. Acts like a checkpoint: tests whether a given condition is true. If the condition **fails**, we will have an `AssertionError`, with a custom message. Helps catch bugs before they occur. 

Imagine a very simple summation function:

```python
def sum(a,b):
	return a + b

# test cases using assert
assert sum(2,3) == 5
assert sum(0,0) == 0
assert sum(-1,1) == 0
print("everything is ok")
```

This will give no errors. If the calculation was wrong we would have assertionerrors.

---

Assert is used as follows: `assert condition, message`

Here, we are going to write the condition and the message which will be printed if the assertion is False.

```python
def calculate_average(numbers):
    assert len(numbers) > 0, "List must not be empty"
    total = sum(numbers)
    avg = total / len(numbers)
    return avg

data = [5,10,15,20]
result = calculate_average(data)
```

Here, the program will work just fine. However, if we put an empty list, it will give us an `AssertionError` with the message we provided.

---

Any condition can be put in the assertion. 

We should remember that `assert` command is primarily used for debugging, and the system should not rely upon them in production code. However, they can still be useful.

We aim to remove all `assert` in code, we will use them in testing later on. 

---

# Using unittest

- In Python, `unittest` is a built-in test module. We also have `pytest` which has more options. However, our aim is just to use the basics to get an understanding of unit testing.

- In Test Driven Development, tests are written before the code. This helps the developer to think about how the functionality should be. If the test cases are good, the code will be written with less number of bugs. However, the developer should think about the functionality and edge cases. 
   - The aim is to pass all test cases. First, we are going to fail and in every iteration, our aim is to pass the tests. 

---

Here, we are first going to write a test method and later we are going to try and write the code which passes that.

Here below, the function name is important. If you change the function name, it is not going to work. The function name must start with `test`.

```python
import unittest
from math_tools import square, triple

class TestToolkit(unittest.TestCase):
    def testTriple(self):
        self.assertEqual(triple(5), 15)
        self.assertEqual(triple(1), 3)
        self.assertEqual(triple(0), 0)

if __name__ == "__main__":
    unittest.main()
```

---

First, we wrote our test. Now, let's write the `triple` code. Simple, 

```
2 + 2 + 2 
3 + 3 + 3
...
```

```python
def triple(x):
    return 15
```

This is called **stubbing out**. Sometimes we'll need to do this, because for some test cases we won't have the necessary data. So we are going to *stub out*.

```python
def triple(x):
    total = 0
    for i in range(3):
        total += x
    return total
```

Let's run test. It passes! Let's add more to our test case for `square`.

---

```python
def test_square(self):
    self.assertEqual(square(5), 25)
    self.assertEqual(square(1), 1)
    self.assertEqual(square(0), 0)
```

Now, we need to write the square. Actually, it looks like the first one. 

```
2+2
3+3+3
4+4+4+4
...
```

```python
def square(x):
    total = 0
    for i in range(x):
        total += i
    return total
```

---


When we run the test, it is going to pass. But, is it actually passing everything? For example, let's try `square(-5)`. 

It will fail. That means we have a **bug**. That is going to be a bug report. That also means we need to test it again.

```python
def test_case_4545(self):
    self.assertEqual(square(-5),25)
```

For every bug, we need to add a new test case. We are not going to change the previous test cases because they need to pass.

Eventually, we are going to refactor our code. Square will be `return x*x`.

---

So, can we simplify the `triple` and make it `return x*3`. 

Is everything okay now? A new bug report comes! `triple("hello")`.

```python
def test_case_2(self):
    with self.assertRaises(TypeError):
        triple("hello")
```

Now, it gives an error. Now, you need to correct the code.

```python
def triple(x):
    if not isinstance(x,int):
        raise TypeError
    return x*3
```

This code can also be written without using `isinstance` as follows:

---

```python
def triple(x):
    if type(x) != int:
        raise TypeError
    return x*3

def square(x):
    return x*x
```

---



# Previous Code

Let's go back to the code we wrote last week which turns a given text into different case conventions.

Here was the code:

```python
class Text:
	
	def __init__(self, text="jon snow"):
		self.text = text
	
	def pascalcase(self):
		return ''.join([x.title() for x in self.text.split(" ")])

	def camelcase(self):
		a = self.text.split(" ")[0]
		return a+''.join([x.title() for x in self.text.split(" ")[1::]])

	def snakecase(self):
		return self.text.replace(" ","_").lower()

	def kebabcase(self):
		return self.text.replace(" ","-").lower()

	def flatcase(self):
		return self.text.replace(" ","").lower()

	def traincase(self):
		return '-'.join([x.title() for x in self.text.split(" ")])

	def cobolcase(self):
		return '-'.join([x.upper() for x in self.text.split(" ")])
```

We are going to add some test cases to it. Instead of writing a unittest, let's write it in the most basic version.

In the `__name__ == '__main__'` we are going to add:

```python
if __name__ == "__main__":
        text = Text("first second")
        assert text.pascalcase() == 'FirstSecond', "Pascalcase failed"
        assert text.camelcase() == 'firstSecond', 'Camelcase Failed'
        assert text.snakecase() == 'first_second', "snakecase Failed"
        assert text.kebabcase() == 'first-second', "kebabcase Failed"
        assert text.flatcase() == 'firstsecond', "flatcase Failed"
        assert text.traincase() == 'First-Second', "traincase Failed"
        assert text.cobolcase() == 'FIRST-SECOND', 'cobolcase Failed'
        print("All tests are passed")
```

Here, we see that we need to create te Text with some information. Are we going to write everything one by one? Do we have some way to automate it in a better way?

Let's write a separate file.

```python
import unittest
from convertClass import Text

class TestToolkit(unittest.TestCase):
    def test_pascalcase(self):
        pass
    def test_camelcase(self):
        pass
    def test_snakecase(self):
        pass
    def test_kebabcase(self):
        pass
    def test_flatcase(self):
        pass
    def test_traincase(self):
        pass
    def test_cobolcase(self):
        pass

if __name__ == "__main__":
    unittest.main()
```

At this point, we need to create an object for Text class. Therefore, let's write it in. We are only going to fill the pascalcase to make it simpler.

```python
import unittest
from convertClass import Text

class TestToolkit(unittest.TestCase):
    def test_pascalcase(self):
        myobj = Text("first second")
        self.assertEqual(myobj.pascalcase(), "FirstSecond")

        myobj = Text("First Second")
        self.assertEqual(myobj.pascalcase(), "FirstSecond")

        myobj = Text("FIRST SECOND")
        self.assertEqual(myobj.pascalcase(), "FirstSecond")

if __name_ ...
```

When we run it, we are going to see that it passes for every test. To make it easier, we can leave the others as `pass`. However, we can easily see that we are writing a lot of boilerplate code. Can we make it simpler?

For example, we can add a for loop:

```python

cases = ["first second", "First Second", "FIRST SECOND"]
expected = ["FirstSecond","FirstSecond","FirstSecond"]

for case in cases:
    myobj = Text(case)
    self.assertEqual(myObj.pascalcase(), expected[cases.index(case)])
```

or a better way;

```python
class TestToolkit(unittest.TestCase):
    def generate_test_cases(self):
        test_cases = [
            ("Jon Snow", "JonSnow"),
            ("hello world", "HelloWorld"),
            ("arel university", "ArelUniversity")
        ]
        return test_cases

    def test_pascalcase(self):
        for input_text, expected in self.generate_test_cases():
            with self.subTest(input_text=input_text):
                text_obj = Text(input_text)
                self.assertEqual(text_obj.pascalcase(), expected)
if __name__ == "__main__":
    unittest.main()
```

Here, we see something new: `subTest`. subTest is used when there are multiple test cases in a single test method. Therefore, if some fails, it will help to identify which one failed. The arguments are the arguments of the function we want to test. Here, we are only using the `input_text` as the input. If we were checking an `addition` with parameters (a,b) our subTest would be `subTest(a=a, b=b)`.

Since we have a lot of methods, we need to write a generator for each of them. This is important because we need to see whether they are working properly or not.

You can check out CPython source in Github to see how they implemented unit tests by using `unittest` module.
