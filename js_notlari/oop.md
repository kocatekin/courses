# OOP in Javascript

## NODE.JS

Node.js is a JavaScript runtime built on Chrome's V8 Javascript Engine. It lets us to use Javascript code in the terminal, in Windows or Unix-like operating systems. We need to install NodeJs, so that we can run these codes. Remember that JavaScript is a programming language, you can use it on your own without the browser. It has OOP properties as well as Functional properties as we will see.

---

## Objects

We can create an object very easily as follows: `const person = {}`

It is an empty object. We can fill in our object too.

```Javascript
const person = {
  name: ["Bob", "Smith"],
  age: 32,
  bio: function () {
    console.log(`${this.name[0]} ${this.name[1]} is ${this.age} years old.`);
  },
  introduceSelf: function () {
    console.log(`Hi! I'm ${this.name[0]}.`);
  },
};
```

You start to see some patterns here in the object code. As you can see, we can even define some functions to that specific `person` object. Now, it has some attributes such as `name` and `bio`. On top of that, it has some methods too: `bio()` and `introduceSelf()`.

Just open up the terminal, run `node` and paste the code above to it. Later, you can call `person` and will see the object without the details. You can also call the variables and functions. Let's try it.

```Javascript
person;
person.bio()
person.name
//etc.
```

In the `person` example, we saw that we can put some methods within the object. The previous version is one, we can also do it in another way. 

```Javascript
const person = {
  name: ["Bob", "Smith"],
  age: 32,
  bio() {
    console.log(`${this.name[0]} ${this.name[1]} is ${this.age} years old.`);
  },
  introduceSelf() {
    console.log(`Hi! I'm ${this.name[0]}.`);
  },
};
```

We can also create a much more detailed Object.

```Javascript
const book = {
    title: "The Great Adventure",
    author: {
        firstName: "Alex",
        lastName: "Johnson"
    },
    publication: {
        year: 2021,
        publisher: "Adventure Books Co.",
        ISBN: "123-456-789"
    },
    genres: ["Adventure", "Mystery", "Fantasy"],
    chapters: [
        { chapterNumber: 1, title: "The Mysterious Forest", pages: 20 },
        { chapterNumber: 2, title: "The Hidden Cave", pages: 15 },
        { chapterNumber: 3, title: "The Secret Map", pages: 18 },
        
    ],
    availableFormats: ["Hardcover", "Paperback", "eBook"],
    isAvailable: true
};

```

Previously, it was very easy for us to reach all variables. Copy and paste this to your Node shell, and let's play with it.

First, if we write `book` it will give us the object. When we write `book.author` it will give us both **firstName** and **lastName**. If we only want to get the `firstName` we will write `book.author.firstName`. 

It is the same for publication as well. However, in the **genres** section, we do not have an **object** but an **array**. That is why we need to use the index to reach that. `book.genres` will give us the list. But if we want to get the first one, we need to write `book.genres[index]`.

**Exercise 1:** 
Here, as an exercise, try to get the **title** of the first chapter by code.

---

**Exercise 2:**

Write a for loop which goes through this object and give the total number of pages in all chapters.

---

Let's go back to dealing with Objects in JavaScript. There are also other ways to play with them. Let's create a `car` Object.

```Javascript
const car = {
    name: "BMW",
    model: "318"
};
```

When we say `car` in the Node shell, it will give us the result. However, we can also change stuff here. `car.name = "Mercedes"` will change the name of the `name` attribute. We can also use `car['name'] = 'Renault'`

Let's try something. Can we add a function?

```Javascript
car.park = function() { console.log("i am parking");}
```

By writing this, we actually added a `park()` function and we can call it `car.park()`. 

We can also add new fields: `car.year = 1999`. Now we have added a new year to the `car` object. 

Let's try one more thing. Cars need to go through inspection every two years. What if we want to store the previous inspections too? First, we will create a different **object** named `inspection`. Later, we will add more variables in there!

```JavaScript
car.inspection = {};
car.inspection.first = "1999";
car.inspection.last = "2023";
```

Remember that we can also use `car["inspection"]["first"]` too.


---

## Object Prototypes

As we know from the other languages, when we write the name of an object and press `.`; we see the possible properties for that object. Some of there are specific to that (like the ones we created) and some of them are generic, such as `toString()`. 

Every object has a built-in property, which is called its **prototype**. It is an object, so it will have its own prototype, which is called a **prototype chain**. The chain ends when we reach the prototype `null`. The prototype of an object that points to its prototype is called `__proto__`. The standard way to access an object's prototype is `Object.getPrototypeOf()` method.

Let's say you want to access a propery of an object. If it cannot be found in the object, the prototype is searched for it. If still can't be found, then the prototype's prototype is searched. It goes on until the property is found or the end of the chain is reached. If that is the case, we get `undefined`.

When we call `myObject.toString()` it first looks for `toString` method in `myObject`. If it cannot find it there, it looks in the prototype object of `myObject` for `toString`. It finds it there and calls it. (It is a generic property)

---






## JSON

JSON is short for *JavaScript Object Notation*. It is a standard text-based format to represent structured data based on JavaScript Object syntax. It is also used heavily to transmit data in web applications. We use it in RESTApi extensively. It is created by *Douglas Crockford*. It is very similar to the object syntax of Javascript. However, it is used in almost all places and almost all programming languages have the ability to parse and generate JSON.

When you want to access the data, you need to turn it into a native JavaScript object. It can be done by using the global JSON object of JavaScript. 

    Converting a string into a native object is called *deserialization*. Converting a native object to a string so it can be transmitted across the network is called *serialization*.

Here is a JSON file.
```JSON
{
    "characters": [
        {
            "name": "Harry Potter",
            "house": "Gryffindor",
            "patronus": "Stag",
            "bestFriend": "Ron Weasley",
            "knownFor": "The Boy Who Lived"
        },
        {
            "name": "Hermione Granger",
            "house": "Gryffindor",
            "patronus": "Otter",
            "bestFriend": "Harry Potter",
            "knownFor": "Brightest Witch of Her Age"
        },
        {
            "name": "Ron Weasley",
            "house": "Gryffindor",
            "patronus": "Jack Russell Terrier",
            "bestFriend": "Harry Potter",
            "knownFor": "His loyalty and bravery"
        },
        {
            "name": "Albus Dumbledore",
            "house": "Gryffindor",
            "patronus": "Phoenix",
            "bestFriend": "Fawkes",
            "knownFor": "Headmaster of Hogwarts"
        },
        {
            "name": "Severus Snape",
            "house": "Slytherin",
            "patronus": "Doe",
            "bestFriend": "Lily Potter",
            "knownFor": "Potions Master and double agent"
        },
        {
            "name": "Voldemort",
            "house": "Slytherin",
            "patronus": "None",
            "bestFriend": "Nagini",
            "knownFor": "He Who Must Not Be Named"
        }
    ]
}
```

Let's try to put this JSON as an object variable in JavaScript. 
`const hp = ...`

Now we can reach elements in this object. `hp.characters`. Since the elements are like array, we can use the index to reach those. `hp.characters[0]`. Then, we are referring to an object. And now, we can use the other notation to get the values. `hp.characters[0].name`.

Later, we will heavily use these JSON, because they are used a lot in RestAPI's. We will do some examples too. That is why, understanding how to reach elements in a JSON is crucial. 

**Exercise:** Here, write a program which will output the name of a house and number of people in it. Try not to do it manually.

---








---

## OOP

    First let's talk about Object oriented programming in general. As we know, C is a procedural language, not an OOL. Although OOP is very popular, it is very much possible to create any functionality by using procedural programming languages like C. However, there are some advantages of OOP; especially as programs grow larger. In addition, sometimes we work in groups and it helps to modularize the program. (This again can be done with functions). 

### Procedural Programming & OOP

An example to a language using this paradigm is C. C language is procedural, it centers around procedures or rputines (functions). Programs are generally a sequence of instructions (commands) and functions. 

The programs are organized around the functions and main data is usually passed between these functions. Data is passed around as arguments within these functions. 

OOP on the other hand centers around objects and classes. An object is an *instance* of a class and a class is a **blueprint** for the object. 

The programs are organized around data (objects) and methods (functions) which operate on this data. For example, in OOP we call a function as follows `object.function(args)`. However in procedural languages, we call them as `function(args)`. In the OOP approach, the methods are specific to the classes they are defined in and can be called by the objects created from the class.

OOP is good for modeling complex systems. It allows us to model real-world entities more intuitively and therefore aims to make the development more natural.

However, nowadays we use programming languages which are multi-paradigm. For example JavaScript supports OOP, but you can also write procedurally in it. Same goes with Python. They even have some *Functional Programming* paradigm in them, which we will talk about later. 

Since almost all languages we will use are going to have these properties, we need to know how and when to use them. 

**When to create a class?**

If we need to represent an entity with both data and behavior, classes are useful. If we have the need to create multiple instances with similar properties but different values, we use classes. For example, we can have a `Wizard` class and we can have multiple wizards with same properties (name, school, etc.) but different values for different wizards. 

However, if we have a specific and well-defined operation that doesn't fit into an object context, we create a *function*.  If the operation is not related to a single object, or if it is very simple enough; we use functions.

---

We create the class similar to other languages. The difference is, since Javascript is Dynamically Typed, we don't use `var` or `let`, etc. 

In OOP, the order is `instance variables`, then the `Constructor` and later the `methods`.

```Javascript
class Car {
  name;
  model;

  constructor(name, model) {
    this.name = name;
    this.model = model;
  }

  introduceSelf() {
    console.log(`Hi! I'm ${this.name}`);
  }
}
```

We create an object like we do it in other languages again.

```javascript 
const myCar = new Car("Renault","Megane");
myCar.introduceSelf(); 
```

If we don't use any constructor, it is going to create an empty constructor by itself, just like as it does in Java. 

```javascript
class Animal {
    sleep() {
        console.log("zzz");
    }
}

const bear = new Animal();
bear.sleep();
```

## Inheritance

We use `extends` keyword. 

```Javascript

class ElectricCar extends Car{
    batteryLife;

    constructor(name, model, batteryLife) {
        super(name);
        super(model); //gets from the parent
        this.batteryLife = batteryLife;
    }

    introduce() {
        console.log(`I am ${this.name} and my battery power is ${this.batteryLife} hrs`);
    }

}

const myECar = new ElectricCar("Tesla","Model M", 5);
myECar.introduce();

```

This above will not work. Because we are calling `super()` multiple times. We should only call it once. So, the snippet should be:

```Javascript
constructor(name, model, batteryLife) {
    super(name, model);
    this.batteryLife = batteryLife;
}
```

---

**Exercise:** Create a Person class with `name` attribute and `walk()` method. Later, create a **Student** class and extend the Person class. Student should have an additional attribute named `studentId` and a method `study()`.

---

## Encapsulation

In Java, we usually don't use **public** variables. Instead, we use **private** variables. Methods within that class can reach those variables but other classes cannot. In Javascript, we declare the variables and methods with private by using the `#` symbol.

Let's add something private to our `ElectricCar` class. 

```Javascript

class ElectricCar extends Car{
    batteryLife;
    #year;

    constructor(name, model, batteryLife, year) {
        super(name);
        super(model); //gets from the parent
        this.batteryLife = batteryLife;
        this.#year = year; //notice the # char
    }

    introduce() {
        console.log(`I am ${this.name} and my battery power is ${this.batteryLife} hrs`);
    }

    getYear() {
        return this.#year;
    }

}

const myECar = new ElectricCar("Tesla","Model M", 5);
myECar.introduce();
```

First, let's try whether we can reach that variable. `console.log(myECar.year)`  When we run it, we will see **undefined**. 

However, when we run the `getYear()` method, we will see the result.

Keep in mind that Google Chrome's Developer Tools has a relaxation and they can reach private values. When you are dealing with the developer tools, if you see them that is the reason.

We can also do private methods. Just add `#` at the start. 
```Javascript

#myPrivateMethod() {
    console.log("i am private, you can't call me from outside");
}

```

---


