---
marp: true
paginate: true
---


# Express

* We start with `npm init -y`
* Creates a default `package.json`
* `npm install express` 

---

# Basic starting file

```javascript
const express = require('express');
const app = express();

//we can also do: const app = require('express')(); 

const PORT = 3000;

app.listen(PORT); //starts the webserver
```

---

# Basic route

* Let's create a route `/` and response: `Welcome to my express server`

```javascript
app.get('/', (req, res) => {
   res.send("welcome to my express server");
})
```

* When we visit `localhost:3000` we will see the result there.

---

# Multiple routes

* Now we can create multiple routes. 
```
/home
/about
/contact
```

Let's fill them in.

---

# Route parameters

* What happens when we call `/hello/john`

```javascript
app.get('/hello/:name', (req, res) => {
   res.send("hello " + req.params.name);
})
```

We can get these by using `req.params`.

---

# Query parameters

We can also support query parameters: `/add?a=5&b=7`

```javascript
app.get("/add", (req,res) => {
   const a = Number(req.query.a);
   const b = Number(req.query.b);
   res.send("Result: " + (a+b));
})
```

---

# JSON response

Up to this point we only returned text. We can also return JSON.

```javascript
app.get("/students", (req,res) => {
   const students = ["harry","ron","hermione"];
   res.json(students);
})
```

---

# Postman

* We need an API testing tool.
  * When developing backend services with express, we create HTTP endpoints:

```
GET /students
POST /students
DELETE /students/1
```

---

* Testing these endpoints from the browser has limitations:
  * Browsers mainly support GET requests
  * Sending JSON bodies is difficult
  * Testing headers and status codes is limited

* Therefore we use API testing tools:
  * Postman
  * Insomnia
  * curl
  * etc.

---

# Postman

Postman is a graphical tool used to:
* Send HTTP requests
* Inspect server responses
* Test APIs during dev.
* Debug services

By using postman, we can simulate client requests without building a frontend.

* Postman also display response body, status, headers, response time etc.


---

# POST 

* Here, if we use REST API, the incoming request will also have a JSON payload. 
* So when we send a POST, PUT request we will put the data in the body in JSON format.
  * We can use a middleware for it.
  * `app.use(express.json())`

---

# POST (Cont) 

Let's say we are adding a new student.
* We do not have a database now, so we are going to use in-memory data.
```
{
   "name": "draco"
}
```

```javascript
let students = ["harry","hermione","ron"];
app.post("/students", (req,res) => {
   students.push(req.body.name);
   res.json(students);
})
```

---

# Random number API

* Let's build an API which gives back a number with every GET request.

```javascript
app.get('/random', (req,res) => {
   const number = Math.floor(Math.random() * 100);
   res.send(number);
})
```

But we can also make it a JSON.

```javascript
app.get('/random', (req,res) => {
   const number = Math.floor(Math.random() * 100);
   res.json({number});
})
```

---

# Random color API

```javascript
app.get('/color', (req,res) => {
   const r = Math.floor(Math.random() * 256);
   const g = Math.floor(Math.random() * 256);
   const b = Math.floor(Math.random() * 256);
   res.json({(r,g,b)});
})
```

---

# Randoms

* random dice
* coinflip --> heads, tails
* password generator --> `/password?length=12`
* text reverse -> `/text/reverse?word=...` 


---

# Callback function

* Nodejs is built on **event-driven** architecture. 
* Instead of executing code sequentially in response to user interaction like a typical script, a Node server **waits for events** such as:
  * an HTTP req. arriving
  * data being received
  * a connection opening or closing

* When one of these occur, Node executes a function that was **registered earlier** to handle that event.
* This is called a **callback function**

---

* A callback function is a function that is **passed as an argument to another function** and is executed later when a specific event occurs.

* In express we use callback functions.
* Multiple ways to use them:
  * Arrow function: `(req,res) => {}`
  * Anonymous function: `funct ion(req,res)`
  * Named function: Create a separate function

---

* Callbacks allow the server to:
  * handle **many simultaneous requests**
  * remain **non-blocking**
  * respond only when events occur

---

* In Express, route handlers are often written as inline callbacks:
```javascript
app.get('/students/random', (req,res) => {
   const index = Math.floor(Math.random() * students.length);
   res.json({ student: students[index]});
})
```

* Although this looks okay, it mixes two different concerns:
  * Routing configuration
  * Business logic

---

# Separating Routing from Logic

* A clearer structure is to use **named handler functions.**

```javascript
function getRandomStudent(req, res) {
  const index = Math.floor(Math.random() * students.length);
  res.json({ student: students[index] });
}

app.get("/students/random", getRandomStudent);
```

As you can see here, we created a separate function. Now routes are much cleaner.

---

* Routes become almost like a configuration table.

```javascript
app.get("/students", getStudents);
app.get("/students/random", getRandomStudent);
app.get("/students/:name", getStudentByName);
app.post("/students", createStudent);
```

* Now readers can easily understand the API structure.

* It is also much better for debugging.
* Also we can use the same functions now in different routes
* We can also do unit testing in a much easier way.

---

# Example

Let's build a small Student API.

Endpoints:
```
GET /students
GET /students/random
GET /students/:name
POST /students
```

---

# Initialize 

```
npm init -y
npm install express
```

---

