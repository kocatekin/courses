# Functional Programming

There are several concepts in functional programming.

## Why?

- Less bugs
- Less time
- Easier unit testing

## Concepts

## Higher-order Functions

Let's write a regular function here. 

```javascript
function increment(x) {
	return x+1;
}
```

In javascript, there is a concept called *higher-order functions*. It means that now we can use these functions as values. For example, 

```javascript
var increment = function(x) {
	return x+1;
}
```

Here, we created a function; and later we assigned to the `increment` variable. Now, if we call `increment(5)` it will give us 6. 

By assigning to a variable, we can also move that function around. For example, if we say `var b = increment`; now we can call `b(3)` as well, and it will work. If we use the `typeof()` function we have learned before and try it here, it will give us not **number** or **string**, but **function** as a type.

Now, this also enables something else. We can now give these as a variable to **other** functions. This is called **composition**. We can take one function and put it into **another** function. So, we can now combine a lot of small functions into a large function!

Also, higher-order functions are possible in programming languages where the functions are referred to as **first-class citizens**.

It means that functions are treated like any other variable. A function can be passed as an argument, it can be returned as a value from other functions and can be assigned to variables. 

---

## Filter

Let's do an example.
```javascript
var pokemon = [

	{name: "pikachu", type: "electric"},
	{name: "bulbasaur", type: "ground"},
	{name: "charmander", type: "fire"},
	{name: "squirtle", type:"water"},
	{name: "raichu", type:"electric"},
	{name: "oddish", type:"ground"}
];
```

Imagine that we want to get pokemons of type **ground**. Normally, we would do a for loop.

```javascript
var ground = [];
for(let i=0;i<pokemon.length;i++) {
	if(pokemon[i].type == "ground"){
		ground.push(pokemon[i]);
	}
}
```

This for loop will create a new list and push ground type pokemon in it.

Now, let's do this in a functional way. For that, we will use a function called `filter()`. 

```javascript
let ground = pokemon.filter(function(pokemon) {
	return pokemon.type === "ground";
})
```

Functions that we send into other functions are called **callback functions**. Filter will loop through each item in the array and it's going to pass it into the **callback** function. There, it will either return a *true* or *false* and this will go into **filter**. 

So, here for every `pokemon` the *callback* function is going to return **true** or **false**. If it is true, it is going to get into the filter function, if not; it is not going to. We can see that we are writing a lot less code here.

Here, the callback function has no name. They are called **lambda** functions and we will talk about them later.

Let's now separate the callback function into its own function.

```javascript
let isGround = function(pokemon) {
	return pokemon.type === "ground";
}

let ground = pokemon.filter(isGround);
```

Now, we have a function `isGround` to return us true or false depending on whether a given `pokemon` is of type ground or not. And, we can give it as a function to the `filter()` function.

`filter()` is a built-in function and there are some built-in functions like that: *map*, *reduce*, *reject*, etc.

For example, if we want to get the names of pokemon which are not of type ground, we can use `reject()`: `let others = pokemon.reject(isGround);`

This will give us all the others. 

	Reusing functions can be beneficial. In both small programs and large programs, breaking problems into separate functions would be beneficial. However, you need to be careful and not create too much little programs.


**Exercise**

Given the list below, find those who are older than age 35.
```javascript
const people = [
    { name: 'Alice', age: 25 },
    { name: 'Bob', age: 30 },
    { name: 'Charlie', age: 35 },
	{ name: 'Keanu', age: 40}
];
```

**Answer**
`let x = people.filter((x)=>x.age > 30);`

---

## Map

Map is a higher-order function. It goes through the array, but it doesn't throw away the objects. It transforms them.

Let's use the same example from the previous section.

```javascript
var pokemon = [

	{name: "pikachu", type: "electric"},
	{name: "bulbasaur", type: "ground"},
	{name: "charmander", type: "fire"},
	{name: "squirtle", type:"water"},
	{name: "raichu", type:"electric"},
	{name: "oddish", type:"ground"}
];

```
Now, let's say that we want to get the names of the pokemon. How can we solve this with a for loop?

```javascript
var names = [];
for(let i=0;i<pokemon.length;i++) {
	names.push(pokemon[i].name);
}
```
Let's solve this by using a `map` function. This is a function on the array object, like `filter`.

```javascript
let names = pokemon.map(function(pokemon) { 
	return pokemon.name;
})
```

There is a difference here. In the `filter` we expected a **true** or **false** to tell filter whether we need/want the object or not. But in `map` we actually apply the same thing to every object. 

So know, the callback function is going to transform the object and return it. 

We can also use this function to create new objects. Getting the name is an example, but we can do lots of stuff. Here are some examples:

```javascript
let names = pokemon.map(function(pokemon) {
	return `${pokemon.name} is of type ${pokemon.type}` 
})
```

Another example can be to take the square of every value in a list.

```javascript
let numbers = [0,1,2,3,4,5,6,7];
let squares = numbers.map(function(numbers) {
	return numbers*numbers;
})
```

This will give you the square of every number in the list. We can also name our *callback function* here and call it with map.

	We also make use of these operations in Python programming language a lot.

**Exercise**
As an exercise, create a square function and try to use it within `map`.

```javascript

function square(x) {
	return x*x;
}

let numbers= [0,1,2,3];
let squares = numbers.map(square);
console.log(squares);
```

Here, we are applying the **square** function to every number in the numbers. In Python, instead of calling it as an array (list) method, we call it as a global function:

```python
def square(x):
	return x*x

numbers = [1,2,3,4]
map(square, numbers)
```

It is also possible to use **lambda functions** in Python for this purpose too! It has a different syntax.

```python
numbers = [1,2,3,4]
squares = map(lambda x:x*x, numbers)
print(list(squares)) #otherwise it is a map object
```



### Arrow Functions

Actually, in Javascript there is something called as arrow functions. It lets us to define functions in a different way. If you check any recent Javascript code, it's likely that you will see this notation. It is not specific to *functional programming*.


To understand it better, let's first talk about lambda functions.

### Lambda functions

These functions are also known as **anonymous functions**. They small function with no name. They are used extensively in Python and Javascript. In Javascript, they are usually referred to and used as arrow functions.

They should be small functions, usually written in a single line. They should be throwaway functions which are not needed more than once. Because if that is the case, we should name them properly.

They are commonly used within other functions like `map`, `reduce` and `filter`. Remember that we use callback functions in those, and it is possible to define them as lambda functions in these functions.

For example, in Javascript if we want to create a function which takes two argument and gives the sum of them, we can do it as `function(a,b) { return a+b; }` or as arrow functions `(x,y) => x + y`.


So, let's go back to our example. Now, we can write the same function as an arrow function.

```javascript
let numbers = [1,2,3,4];
let squares = numbers.map(numbers => numbers*numbers);
```

Here, we omit the `function` keyword as well as `return` keyword. Since we are usually using lambda functions for one line, this is enough.

There are some additional information about lambda functions. For example in Javascript, these are also possible!

**Example**:
```javascript
const greet = (name = "Tugberk") => `hello, ${name}`;
```
Here, we can call lambda functions with a default parameter. 

Here, if we call the function with an empty parameter like `greet()` it is going to print out *Tugberk*. However, if we call it like `greet('tom')`, it will print out *Tom*. 


**Example**: 
We can also do *function composition*, which means we can combine multiple functions together.

```javascript
const add = (a,b) => a+b;
const square = x => x*x;
const addThenSquare = (a,b) ==> square(add(a,b));
console.log(addThenSquare(2,3)) //25
```

**Example**:
We can immediately invoke a function when we define it.

```javascript
((name) => console.log(`hello, ${name}`))("tom");
```

One can find a lot of examples, but these are important. 

---

## Reduce

In the previous functions, we have changed our data to something else. We did not mutate the original data, but we got something out of it and usually the result is also a list/array. They are transforming the list.

Reduce can be used to express any list transformation. Reduce can be used to implement any other list transformation such as `map`, `filter` etc. It is the **super** list transformator. (We are not going to do it.)

Reduce is used to accumulate values in an array to a single result. That is the main purpose of the function. 

Let's have a function.

```javascript
var orders = [
	{ amount: 200 },
	{ amount: 400 },
	{ amount: 100 },
	{ amount: 300 },
]
```

Let's sum all the amounts we have sold. First, with a for loop.

```javascript
let sum = 0;
for(let i=0;i<orders.length;i++){
	sum += orders[i].amount;
}
```

Now, let's try to do it with reduce!
```javascript
let total = orders.reduce(function(sum, order) {
	return sum + order.amount;
}, 0);
```
`reduce` function is somewhat confusing compared to others. Here, we are actually recursively calling the function for every element in the **orders**.

The 0 we enter is the initial case. If we change it for example to 10, the answer will be 1010 instead of 1000.

So first, it is going to add the `order.amount`, and it will be the next sum value. Later, since sum is changed it is going to add the next orders amount, etc.

We can understand what is going on in the function by using a `console.log` in the reduce function.

```javascript
let total = orders.reduce(function(sum, order) {
	console.log(`Hello sum: ${sum} and order: ${order.amount}`);
	return sum + order.amount;
}, 0);
```
If we want to write this callback function as an arrow function:

```javascript
let total = orders.reduce((sum,order) => sum+order.amount,0);
```

Let's give some more examples. 

**Example**

There are cases where `reduce()` can be confusing but useful. For that you need to spend some time on it. However, here below is a good and useful example for you.

```javascript
const data = [['name', 'Alice'], ['age', 25], ['country', 'Canada']];
const object = data.reduce((obj, [key, value]) => {
    obj[key] = value;
    return obj;
}, {});

console.log(object); 
// Output: { name: 'Alice', age: 25, country: 'Canada' }
```

Here, we are given an array with array elements. It is a 2D array. We can turn it into an object with the `reduce()` as followed.

**Example**

We can also use it to count characters in a string.
```javascript
const str = "Hello World!";
const charCount = str.split('').reduce((count, char) => {
    count[char] = (count[char] || 0) + 1;
    return count;
}, {});

console.log(charCount);
// Output: { H: 1, e: 1, l: 3, o: 2, ' ': 1, W: 1, r: 1, d: 1, !: 1 }
```

Reduce is somewhat confusing. You need to write some code to understand it better and look for examples!

---

## Find


Find is used in Javascript to search through an array and find the element that satisfies our condition. If there are no such elements, we will get `undefined`.

**Example**

```javascript
const items = [
    { id: 1, name: 'Apple' },
    { id: 2, name: 'Orange' },
    { id: 3, name: 'Banana' }
];

const item = items.find(item => item.id === 2);
console.log(item); // Output: { id: 2, name: 'Orange' }

```

Here, we have items and what we do is we are looking for the item with the id 2.


---

# Closures

A closure combines functions and the lexical environment within which they were declared.

It gives you access to an outer function's scope from an inner function. Usualy used for *data privacy*, *implementing call backs and event handlers* and *functional programming* patterns.

## Lexical Scoping (Static scoping)


Functions in Javascript are lexically scoped. It means that they run in the scope in which they were defined, not the scope they are executed in. Important for closures.

In a lexically scoped language, variables declared within a function can only be accessed within that function and cannot be accessed from outside of the function. 

```javascript
function outerFunction() {
  var outerVariable = 10;

  function innerFunction() {
    console.log(outerVariable);
  }

  innerFunction();
}

outerFunction(); // This will print 10
```


Here, `outerVariable` is declared within the `outerFunction`. The `innerFunction` is declared within the `outerFunction`. Therefore, `innerFunction` has access to `outerVariable`.

This makes it possible to create closures. Closures are functions that have access to variables from their outer scope. Mainly used for *event handling* and *data encapsulation*.

**Hint:** Python, C and Java, etc. is also a lexically scoped language. 

Let's go back to *closures*. Closures allow us to create functions that remember and access their surrounding state, even after the function execution context has ended. It is possible because of **lexical scoping**.

Here is an example:
```javascript

function createCounter() {
	let count = 0;

	function increment() {
		count++;
		console.log(count);
	}

	return increment;
}

const myCounter = createCounter();
myCounter(); //1
myCounter(); //2
```

Here, `createCounter` function creates a closure that contains the `count` variable and the `increment` function. `increment` function has access to **counter** variable even after the `createCounter()` finished execution.

Normally, since `counter` variable was declared in the function, you would expect it to give the same answer everytime! But here, the `increment` function can still access the `count` even after the execution. This is a closure.

Technically, closures can be considered *side effects* because they can affect the state of the program outside the current function execution context. However, when using closures the side effects are intentional. 

Let's see some real life usages of closures.

**Example**: Data Encapsulation / Private Variables

```javascript
function createBankAccount() {
    let balance = 0;  // Private variable

    return {
        deposit: function(amount) {
            balance += amount;
            return balance;
        },
        withdraw: function(amount) {
            if (amount <= balance) {
                balance -= amount;
                return balance;
            } else {
                return "Insufficient funds";
            }
        },
        getBalance: function() {
            return balance;
        }
    };
}

const account = createBankAccount();
console.log(account.deposit(100));  // 100
console.log(account.getBalance());  // 100
console.log(account.withdraw(50));  // 50
```

Here, `balance` variable cannot be reached from outside the function. So, we are making it a **private variable** here. 

**Example**: Function factories

Closures also allow the creation of function factories, where we can create multiple functions!

```javascript
function makeMultiplier(multiplier) {
    return function(number) {
        return number * multiplier;
    };
}

const double = makeMultiplier(2);
const triple = makeMultiplier(3);

console.log(double(5));  // 10
console.log(triple(5));  // 15
```

Here, `makeMultiplier` is a function factory, where we can create different functions by using it!


In some cases, closures can be used like OOP like classes, methods; especially in regards to data encapsulation. They provide a way to bunlde data and functionality together. (That is actually what classes are mainly used)

Sometimes, closures can be lightweight and efficient than creating classes, especially for simple tasks. They can also be used where classes are not suitable; but they can be harder to understand.


However, we should keep in mind that *lexical scoping* can be different for different languages. 


self-note: https://bard.google.com/chat/149120b51b17a179

---



## Side-effects


