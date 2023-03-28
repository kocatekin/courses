---
marp: true
theme: beamer
header: Front-end, back-end, full-stack
footer: System analysis and design
paginate: true
size: 4:3
---

<!-- _class: title -->
# Front-end and Back-end

---

# Front-end

We have a _client_ and a _server_. The client is the **browser**, and the server is the **webserver**.
- The client can also be an application too!

Client sends _requests_ and the server gives back _responses_.
- The part on the browser is called **front-end**.
  - That is what the user _sees_.

It is about the **presentation**.
  - How things look.
  - Images, content, structure.

On the web, it is written by using HTML, CSS and JS.

---

# Back-end

Back-end is about _how things work_.
- What are you going to present in the front-end?

Business Logic and Data are on the back-end.
- Database is here.

When a user wants to add something to the website, the form is sent to the back-end.

Generally the used languages are PHP, Ruby, Python, Java, .NET, etc.

---

# Website

Let's open a website and go through stuff to see what is what.

---

# Frontend

All about Presentation!
- Not only the web. What about mobile applications?
  - Java, Kotlin for Android
  - Objective C and Swift for IOS
  - What else?

Although these are not generally called as front-end, they are.
The difference is, we are using a different language now.
- All the user interface we see is _rendered directly on the device of the user_.

---

# Frontend programming

* While building an application, there will be design teams.
  * UX, UI
* This design will come to front-end developers and they will _code_ (realize) these images.
  * By using **html, css and js**.

* If you want to be a front-end engineer, you should be very good at CSS and JS.

---

# Frontend programming > js

* Javascript is a _client side_ language.
  * We can see the javascript code in a website by checking the source.
* The code works on **our** computer, not on the server.
* There are different libraries of Javascript.
  * The original one is called _vanilla_ javascript.


---

# Frontend programming > js

* Instead of using vanilla JS, many developers and systems are using different libraries.
* The most common library is React by Meta.
  * In the old times, there were JQuery, CoffeeScript, etc.
    * It is still being used. Because **maintenance**.
  * Angular by Google has a user base.
  * VueJS is also very popular.
* However, React is the golden standard.

---

# Frontend programming > js

* There is also **Typescript**. It is a strongly typed programming language that builds on Javascript.
  * You write in Typescript, it compiles to Javascript.
  * Helps write better code.
* If you want to be a front-end programmer, you must improve yourself on Javascript. 
  * Try to start with _vanilla js_ and then move on to libraries like React.

---

# Frontend programming > css

* Front end programming is not only about Javascript. CSS is also very important.
  * If you want to be a good front-end programmer, you should improve yourself on CSS.
  * Do not rely on simple tutorials and try to move beyond them.
* There are interviews done on Turkish on Youtube about front-end development. Watch to see what they want.
  * LinkedIn Jobs is also good to see what companies want.
* There are not much front-end developers in Turkey.

---

# Frontend programming > mobile

* Mobile development is mainly front-end.
  * The business logic is _backend_ and it is not written specifically for Mobile.
* However, _mobile application_ still needs to _look good_ and _reach_ backend data.
* This is what mobile programming is.
  * Apart from gaming of course.
* Therefore, jobs on mobile development deals with the _presentation_ too.

---

# Frontend programming > mobile

* It is not _mandatory_ to create mobile applications with the native languages.
  * React Native
  * Xamarin
  * ..
* You can code in React(Js), C# and make it multiplatform.
* This is good for small companies or personal stuff.
  * However, enterprises _usually_ go for native languages.
  * So it would be good for you to learn them and improve yourself on them.

---

# Frontend programming > good to know

- CSS Pre-processors such as Sass and Stylus.
- JS Libraries and Frameworks (Lodash; Angular, React, Vue, etc.)
- Build tools (npm, Webpack, etc.)

Frontend developers are not going to be involved with server-side languages, database queries, server configurations or server-side business logic such as _user auth_, _order handling_ etc. 


---

# Backend programming

Called _backend_ because it is working in the _back_; not on our computer.
- Remember that frontend _runs_ on our computer, our browser.
- Backend on the other hand runs on a _server_ which we call a **webserver**.

This server can be on the _cloud_ or it can be on our own computer.

---

# Backend programming

For example, when we are using an app, the **data** is not on our computer. It resides on a different computer and we _see_ them by pushing/clicking on the _frontend_.

- In other terms, data is in the backend, and we use _frontend_ to reach that data!
- Backend is not only about _data storage_. 
  - **Logic!**

---

# Backend programming

There are some things that we should not do on frontend.
  - Interactions with the file system. 
  - Server-side input validation
  - Database interactions, etc.

Frontend should only contain code that is related to the _presentation_. It should _fetch_ data, _send_ data and _present_ data to the user.

---

# Backend programming > languages

You can use different programming languages for backend. Almost all languages are suitable, but some are better equipped.
- PHP: A web programming language. Designed for this task only. It was very popular (still is), but nowadays people who learn web programming are not learning PHP.
- Python: It is not a _web programming_ language but there are _frameworks_ to help build web applications such as **Flask** and **Django**. Very popular especially with Startups.
- cont.

---

# Backend programming > languages

- Java: One of the most popular languages used in web. Has a very good web framework called Spring (Boot).
  - Many large applications are using Spring Boot. 

Although it is possible to make a web application using $C$ or _C++_ it is not a standard. We generally use scripting languages or compiled languages like Java and C#.

- Javascript can also be used as a backend programming language with _NodeJS_!. Very good and popular for _fullstack_ development. NodeJS let's us use Javascript outside the browser and _Express_ framework helps us develop web applications.

---

# Backend programming > good to know

* Server-side languages & frameworks (PHP, Python, Java, etc.)
* Databases & Query Languages (SQL, ORM, etc.)
* **Basic** frontend knowledge
* Server configuration

---

# Backend programming > works on

* Data validation (security)
* Notifications
* Business Logic (User auth, etc.)
* Data storage, database access
* Scheduled processes (cronjobs, etc.)
  
Does not care about advanced CSS or Javascript, build tools, etc. 
They will not work on client-side stuff in general.

---

# Fullstack development

In big enterprises or applications, _frontend_ and _backend_ are separated.
- Frontend developers are backend developers are different!
- This helps in terms of expertise.

If these are not divided _or_ if you are doing both the _backend_ and the _frontend_ it is called **fullstack development**.
- You are responsible for both frontend and backend.

It is good to start with fullstack when you are learning. Learn some CSS and JS and a backend language to build a website.
- You can always use CSS frameworks like Bootstrap to help you.

---
# Communication

The frontend and backend are communicating with each other.
- By using HTTP requests.

Frontend sends data to backend. Backend _validate_ that data, store it in the database or do some additional stuff and saves, etc it.

* BFF

---

# Going online.

## What happens when we write a url and press enter?














