---
date: 2025-01-27
link: https://www.youtube.com/watch?v=vQPHtAxOZZw
talker: richard feldman
title: the return of procedural programming - richard feldman
---

Alan Kay's definition of OOP emphasizes messaging, local retention and protection (encapsulation), and extreme late binding. According to Kay, objects communicate through messages, and objects decide at runtime how to respond based on their state and the message received

Bjarne Stroustrup's C++ is a different approach to OOP focusing on program organization rather than messaging. C++ added classes and stronger static type checking to C.

Composition is preferred over implementation inheritance in OOP. Composition involves using an existing class as a member of a new class, rather than subclassing, which reduces the chance of bugs

---

python is not actually oop.
wanted to add simula ideas. object, classes.
he did not put the messaging idea.
it didnt fit in alan kay's idea.
ruby is more oop -> more like smalltalk. 
self -> adopted prototype for object creation
javascript is also like that. prototypal.
later they chose classes over prototypes.


what is late-binding? -> dynamicity ?

industry is moving away from late-binding and messaging.

"oop to me means only messaging, encapsulation and extreme late-binding of all things."


procedural on the other hand.
plain old functions and plain old data.

bjarne. --> c with classes --> he was with booch actually.
he also added strong type checknig -> opposite of alan kays vision (late binding)
so added more features --> c++
so, it was not the objects to make cpp popular.
alan kay later said -> i made up the term oop, i did not have c++ in mind.

descendant from cpp, java.
originally, js was supposed to be like scheme. but at that time, java was **very** popular, so they wanted him to create something similar to java.

php is also another offshoot from c++.

c# is from java. but these are all coming from c++. so not into *oop* alan kay wanted.

kay -> architecture for programming
bjarne -> program organization

organizing around actions on data types.
we also have this in modules. so instead of classes, one can have modules to do this purpose.

pillars: abstraction, encapsulation, polymorphism, inheritance
these are not benefits but a *statement of values*. these are the things you should value when you are doing oop. 

abstraction -> dont depend on imp.
encaps -> prevent depending on imp.
poly -> implementation determined by type

these three are in every modern language. (polymorphism -> generics)

inheritance -> uniquely oop. 
there is *interface inheritance* and *implementation inheritance* these are different.
imp --> oop specific.

inheritance -> hierarchical code sharing
composition -> non-hierarchical code sharing

composition --> basically every language.

why composition?
----------------
instead of using subclasses, i can make a new class with original as a member. so i am not overriding. all methods are there, i have additional methods. this is like *nesting structs* in c.


# the essence of the paradigm

procedural: use procedures over GOTOs.
functional: avoid mutation and side effects
kay oop: messaging and late-binding of all things
classical oop: hierarchical code sharing


---

let data be data, actions be actions -> procedural
data and procedures working on them.

sandy metz -> oop person


## procedure vs function ? 

* **procedure**: a set of instructions or a block of code designed to perform a specific task. it does not return a value, but can modify variables etc (side effect)

```python
def greet_user(name):
	print(f"hello {name}")
```

These can be used where returning is unnecessary. Logging data, sending email, updating a database.


* **function**:  also set of instructions or code, but it specifically designed to **return a value**.

```python
def add(a,b):
	return a+b
```


Many programming languages do not differentiate between them. Because usually it returns something (none). 


---

btw, oop also means the programming language is using classes and objects. everything has hierarchical classification.

go is not an oop language, but it also has **abstractions**. it uses *interface* for it. rust calls it *trait*. haskell uses *class* name for it.


* do we have interfaces in python?
