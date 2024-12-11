This week, we talked about **hash maps**. For a given (k,v), we are going to store it in the array. As we know, accessing elements is very fast.
However, where are we going to put our pair? Yes, there is an array but which index? 

In order to find the index, we use the **key** $k$, and we apply a hash function to it in order to get it between two numbers (0, and `len(array)`-1). There are several hash functions, but simplicity we are going to use a very basic hash function: modulo operator. For example if the key is 10 and our array has 5 slots, we are going to do `10%5` to get the index -> which will be 0.

However, since this is a very basic hash function, we are going to have collisions. How are we going to solve them? To solve them, we have several strategies. Open addressing, closed addressing and double hashing. In class, we saw *open addressing* and *closed addressing*.

## Closed addressing

This is also called *separate chaining*. When we hash a key, if we get an index number which is already full, we create a linkedlist and add our k,v pair into that bucket. If we have another key with the same hash, we are going to add a node to the linkedlist. Here, by looking at the examples you will see that it is possible to have empty slots in the array. Not memory efficient.

## Open addressing

In open addressing, we have two ways: *linear probing* and *quadratic probing*. In both approaches, we apply the hash function first. Later, if the slot is full, we do a *rehash*. This time, for the *linear* probing we are going to add `1` to the previous key and hash it again. If it is full, we do the same thing. Until we find an empty slot, we will repeat that.

In quadratic probing, instead of using a linear function (adding 1), we are going to use a *quadratic* function to find the next available slot. So, the *i*-th probe $hash(key) + (c_1 * i) + (c_2 * i^2)$. Instead of adding one we are going to add this.

