# 28.12.2023



# Concurrency

It is possible that sometimes people mix up the meaning of *concurrency* and *parallelism*. They are not the same and they cannot be used for each other. Concurrency creates the illusion of parallelism. It means *managing* multiple tasks at once. It doesn't mean that they are happening **at the same time**. The system *switches* between tasks, but it does it so fast that we think they are happening at the same time. 


# Parallelism

If processes are running **at the same time**, then we can talk about parallelism. For that to happen, we need to have either multiple cores or processors. If we have a single core, it is **impossible** to have parallelism because the CPU can only do a single thing at a given time. In such cases, we have **concurrency**. 


# MultiThreading

Threads are lightweight processes. Remember that in each process we create a PCB (*process control block*). However, threads have some advantages over processes, but they are within it. Since threads are living *in* the process, they share the same **memory space**. This allows communication between them very easy. If we remember, in processes (IPC) they can either share information via *message passing* or *shared memory*.

The reason we use multithreading is to speed up the process. However, for this to make sense we need to talk about cores / processors. If we are using a single core, then multithreading can only help us with I/O bound tasks. It cannot help us with CPU-bound tasks because the CPU is already working on something. It is not idle. It would help us with multiple cores, because now we are able to run **a** thread in each of the cores, thus making it really parallel and logical. Then we would utilize all computing power of all cores.

For example, Python has multithreading. However, the GIL (*Global interpreter lock*) does not allow threads to run on different cores/processors. However, you can use multithreading for I/O tasks and it works fairly good. For other tasks, *multiprocessing* can be used. (However, there are some ways to overcome it by using C extensions.)

# Asynchronous Programming

Some functions are blockers. For example, let's say you have listed functions sequentially:
```javascript
function a() {
	//runs for 10 seconds
}
function b() {
	//runs for 5 seconds
}
a();
b();
```

For example, here when we run `a()`, we are going to wait for 10 seconds and we are not going to be able to do anything in that time. So, both functions will end after 15 seconds. 

However, it is possible that functions a and b have nothing to do with each other. If that is the case, we can do async programming. Here, tasks will run without blocking the other. It will use a **single-thread**, **event-driven** approach. It is often implemented with *promises*, *futures* or *callbacks*.

It is usually best for I/O tasks where the program spends a lot of time. With async, we can perform such operations without tying up the system resources. They have low overhead compared to threads (because even creating them is a job) and easier to scale and manage. It is also much easier to read compared to multithreading code.

We use these a lot in Javascript, because sometimes when we are trying to fetch an API it is going to take some time. In Javascript, we use *promise* and *callback functions* as well as *async/await* to do asynchronous programming.

## Promises

Here, we are actually giving a *promise*. It takes two arguments: **resolve** and **reject**. If the promise is fulfilled, resolve will run and if not, the other.

```javascript
const myPromise = new Promise((resolve, reject) => {
  // Do something asynchronous which eventually calls either:
  resolve(someValue); // fulfilled
  reject("failure reason"); // rejected
});

myPromise.then((value) => {
  // success
}).catch((error) => {
  // failure
});
```

## Async / Await

When we run a function by typing *async* before them, it means that function returns a **promise** at all times. All values are stored in the *resolved* promise. Let's try:


```javascript
async function f() {
	return 1;
}
f(); //returns a promise
f().then(console.log); //1
```

The function `f()` can also be written as:
```javascript
function f() {
	return Promise.resolve(1);
}
```

However, keep in mind that they are not the same. One resolves the promise and the other returns the promise.

So here, by using *async* we are ensuring that we are going to return a promise, and wraps non-promises in it. We also have **await**. 

**Await**: It suspends the function execution until the promise settles. After that, it resumes with the promise result. This is good because Javascript is doing other tasks in the meantime. However, we cannot use *await* for regular functions. We can only use it together with `async`.

When we use await, we don't need to use `then` anymore. So now, when we write await, it is going to resume with the promise's resolve.

```javascript
function resolveAfter2Seconds() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve('resolved');
    }, 2000);
  });
}

async function asyncCall() {
  console.log('calling');
  const result = await resolveAfter2Seconds();
  console.log(result);
  // Expected output: "resolved"
}

asyncCall();
```

So, here the `await` is waiting for the Promise to end. When done, we see the result. 

Another example may help. Normally, it is possible to use Promises and be done with asynchronous. But *async/await* makes the code understandable and easier.

For example;
```javascript
fetch('https://jsonplaceholder.typicode.com/todos/1')
  .then(response => response.json())
  .then(json => console.log(json))
  .catch(error => console.log(error));
```

This can be written as:
```javascript
const response = await fetch('https://jsonplaceholder.typicode.com/todos/1');
const json = await response.json();
console.log(json)
```

Instead of the `then` method chaining, we used await. However, this code is not going to work because in order to use `await` we need to use `async`. So let's edit the code:

```javascript
async function runProcess() {
	const response = await fetch('https://jsonplaceholder.typicode.com/todos/1');
	const json = await response.json();
	console.log(json);
}
```

If we want to catch errors, we put it in a try-catch. 
```javascript
async function runProcess() {
  try {
    const response = await fetch('https://jsonplaceholder.typicode.com/todos/1');
    const json = await response.json();
    console.log(json);
  } catch (error) {
    console.log(error);
  }
}
```

Let's remember that we can define the function as `const runProcess => (async) => {..` this as well.

# API calls

To fetch APIs, we use `fetch()` which returns a promise. So, we can use an `await` on it. 

```javascript
const apiURL = "https://jsonplaceholder.typicode.com/posts/1";

async function fetchPost() {
	try{ 
		let res = await fetch(apiURL);
		let data = await res.json();
		console.log(data);
	} catch(error) {
		console.error("error fetching: " + error);
	}
}
```

By using this, we can create a very basic API service and read through some well-known APIs. Instead of console.log, we can create a new element or use a previously created element to show information (image, or etc.). Of course first we need to parse the incoming JSON.

If we are using a key to get or post data to a website, we can use:
```javascript
const apiKey = process.env.API_KEY; // Assume you've set your API key in an environment variable
const apiURL = 'https://api.example.com/data';

async function fetchProtectedData() {
  try {
    // Include the API key in the request headers
    const response = await fetch(apiURL, {
      method: 'GET', // or 'POST'
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${apiKey}` // Or 'Key apiKey' or another format depending on the API
      }
      // If you need to send a body, add it here
      // body: JSON.stringify(data)
    });

    if (response.ok) {
      const data = await response.json();
      console.log(data);
    } else {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
  } catch (error) {
    console.error("Error fetching data: ", error);
  }
}

fetchProtectedData();
```







