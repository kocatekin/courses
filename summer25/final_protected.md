# Final, protected

Before, we talked about `public` and `private`. Private keyword gives us encapsulation. 

## Final

It means **this cannot be changed or overridden**. This can apply to, *variables*, *methods*, *classes*. That means:
- Variables cannot be reassigned.
- Methods cannot be overridden in subclasses.
- Classes cannot be inherited.

In short, these are **constant** values.

Please try these at home. Try to reassign final variables, try to override methods and inherit classes.

## Protected

It works like `private`, but it **allows** access in subclasses (even if it is in a different package). Good for letting child classes use / modify something without making it *public*.

So `protected` means, only family members (subclasses) can know about this.


