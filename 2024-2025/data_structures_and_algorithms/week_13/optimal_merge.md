Optimal merge pattern


First we ask this question. Let's say we have two sorted lists **A** and **B**. We want to combine them together and get a list **C**, where it is also sorted. How can we solve this problem? We can use *two pointers* and by comparing elements we can do it.

```
A -> 3, 8, 12, 20
B -> 5, 9, 11, 16
```

We will compare 3 and 5. The minimum will be added to **C**. Later, we are going to increase the index for A, and compare 8 with 5. 

```
i=0
j=0
n = len(a) + len(b)
while(len(c) != n):
  c.push( min(a[i],b[j]) )
  if( min(min(a[i],b[j])) == a[i])
    i++
  else:
    j++
```

The cost here is len(a) + len(b).

Well, lets generalize the problem. Lets say we are given 5 lists and they give the number of elements instead. Because we care about the cost. We dont care about the elements inside.

List -> A B C D
size -> 6 5 2 3

So, if we just do it like before, we are going to combine A and B first. Then that with C. Then, the result with D.
The cost will be 40.

Can we decrease the cost?

What if we combine A and B first, then C and D --> Lastly combine the combinations.
The cost will be 32.

Can we decrease it?
First lets combine C and D. Result with B. Reslt with A.
Cost will be 31.

We see something here. If we start merging from the lists with minimum elements, we can decrease the cost! So, minimizing the cost. This is the strategy for *greedy algorithm*.

Lets do anothe examples

List -> A  B  C  D E 
Size -> 20 30 10 5 30

Lets order them first

5 10 20 30 30
D C A B E

Here, we will first merge D and C. Result is 15.
Result will be merged with A.
Result is 35.
B and E are smaller, merge them.
Merge the result with the prev. result.
We have it.
Total cost is 205.

