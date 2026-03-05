# Node.js

NodeJS is a Javascript Runtime environment (like a Javascript interpreter) works on V8 engine (Google). It allows Javascript to work in non-client settings, such as a server. Thanks to NodeJs, we can use Javascript on server-side programming. It works in all platforms.

## Why?

Javascript is the de-facto language for front-end. Now, we can use the same syntax in the backend too. 

Node is good in **event-driven** situations. It is efficient for APIs, real-time systems, chat, streaming, etc. It can handle many concurrent connections with low overhead.

It has a huge ecosystem (via `npm`) but this can be also bad. Very good for rapid prototyping.

Node.js uses a single-threaded event loop with asynchronous, non-blocking I/O. All I/O operations (db calls, http requests, file reads, etc) are delegated to the OS or *thread pool*. The main thread remains free to process other events. This results in efficient handling of **many concurrent connections** with low memory footprint.

Node's core API are built around events (streams, callbacks, promises). So event-driven architecture maps cleanly onto Node's execution model.

Since Node does not block while waiting, it is very good for most modern backend systems. Usually we are waiting for databases, external apis, or disk. So, if 10000 requests are waiting on a DB, Node is not using 10000 threads for it.

Most of the time, the bottleneck is not computation (CPU) but the I/O. So Node handles this very good. 

REST API's use JSON. Javascript works natively with JSON. So, easy to serialize.


# Express

A minimal and flexible NodeJS web application framework.


---

# Starting a Project

When we start a new project, we can start by writing `npm init` into the console. This creates a `package.json` file. This file is a manifest for our Node.js project. It defines the:

* project name and version
* entry point (`main`)
* scripts (`start`, `test`, etc)
* dependencies
* metadata (license, author, etc)

It prompts you to enter such details.

However, there is also a quick default setup. We can achieve it by using  `npm init -y` into the Console.

>As an IDE for NodeJs, I recommend using VS Code, since it lets you use Terminal easily.

This command creates a default `package.json`. After that, we install Express by: `npm install express`. 

When we do it, we can see that the `package.json` is changed. Now, in *dependencies*, it shows the express module with a version.

We reinstall Express for every project. Node.js uses a project-local dependency model by design. So, every Node project has a `node_modules/`, `package.json` and `package-lock.json`. When we install express, it places it inside the `package.json`, and locks the dependency graph in `package-lock.json`. That way, different projects can easily use different versions of Express. 

> You can install Express globally by `npm install -g express`. But that only installs CLI (if applicable). It will not install it to projects. It does not rely on global modules. This is true for every module. 

---

Now, let's create an `index.js` file.

```javascript
const express = require('express');
const app = express();

//we can also do: const app = require('express')(); 

const PORT = 3000;

app.listen(PORT); //starts the webserver
```

At this point, we can run our program by: `node index.js` 

We'll see nothing at the terminal, but it is listening. When we open up the browser and try to connect `localhost:3000`, we will see an error message. This actually means our server is working.

Now, we can do some edits so we can see something in the terminal.

```javascript
const express = require('express');
const app = express();

//we can also do: const app = require('express')(); 

const PORT = 3000;

app.listen(PORT, () => console.log('server is running')); //starts the webserver
```

Now, when we run the program again, we will still have the same error message; but we will now see something in the terminal.

>In Javascript, () => {} means: function somename() {}

So now, we can set up some pages. For that, we are going to use the `app` keyword. When you go into the source code and write app and put a dot, you will see every method the *app* object can call.

When you check them, you are going to see a lot of things but some of them are going to be familiar, such as *get*, *post*, *put* etc. 

Remember that when we enter a URL in the address bar and click send, we are sending a GET request.

So, let's create a page on our own for `arel`. So, when the user wants to enter `localhost:3000\arel` they are going to see what *we* want them to see.

Edit `index.js`:

```javascript
const app = require('express')();
PORT = 3000;

app.get('/arel', (req, res) => {

   res.send("Hello there friend!");

})

app.listen(PORT, () => {console.log("server on..")});
```

When we run this and go to `localhost:3000`, we will still see the error message. Because if we don't write anything, it automatically tries `/`. However, we did not write anything for it yet. We wrote something for `/arel`.

So, enter `localhost:3000/arel` and we'll see the result!

In the code, we use Javascript notation again just to shorten stuff. Let's edit the code to prove it. Let's add a `/school` but this time use the long notation.

```javascript

const app = require('express')();
PORT = 3000;

app.get('/arel', (req, res) => {
   res.send("hello there friend!");
});

app.get('/', function noname(req, res) {
   res.send("this is the index page");
});

app.listen(PORT, () => {console.log('server running')});
```

We will see that both endpoints work!


---







