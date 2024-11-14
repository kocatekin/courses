Which button is calling?

There are two ways to solve this. 
Refer to the VSCODE. We talked about event listeners there.
We are going to connect to it now.
But first, we need to talk about the first problem and how to solve it.


Before, we have seen that we can have multiple buttons and we can change their `onclick` attribute. However, it is possible that we have multiple buttons calling for the same function in their onclick method. When that happens, we must have a way to understand which button is calling. 

To do so, we can do the following:
```html
<button id="btn1" onclick="run(this)">Button 1</button>
<button id="btn2" onclick="run(this)">Button 2</button>
```

This is the HTML code. As you can see we changed `run()` into a function with an argument. Now, we need to change the code in the `<script>` tag as well:

```javascript
function run(button) {
	if(button.id == "btn1") {
		console.log("btn1 is calling")
	}
	else if(button.id == "btn2") {
		console.log("btn2 is calling");
	}
}
```

Here, we see that by giving `this` we are giving information on the caller. However, this is not a good practice. The better way is to solve it by using event handlers. In that case, the HTML code becomes:

```html
<button id="btn1">1</button>
<button id="btn2">2</button>
```

And now the Javascript code is going to be a little different:

```javascript
const btn1 = document.getElementById("btn1");
const btn2 = document.getElementById("btn2");

btn1.addEventListener("click", run);
btn2.addEventListener("click", run);

function run() {
	if(event.target == btn1) {
		console.log("btn1 is calling")
	}
	else if(event.target == btn2) {
		console.log("btn2 is calling");
	}
}

```

Okay. `event.target` is new here. It refers to our element. So, if we want to refer to the elements value for example, or innerText, we can write `event.target.innerText`. Let's see an example again. 

Create two button elements in the HTML file.
```html
<button id="btn1">First button</button>
<button id="btn2">Second button</button>
```

In the Javascript, we will now create a function.

```javascript


let btn1 = document.getElementById("btn1");
let btn2 = document.getElementById("btn2");

btn1.addEventListener("click", run);
btn2.addEventListener("click", run);

function run() {

	console.log(event.target.innerText);

}
```

Now, when you press a button, it will give you the innertext of the button that you pressed!
