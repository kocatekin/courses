# Encoding

Information is a weird concept. We can think about it in different terms. Now, we use words to communicate. Words are combined by using letters. If these are written or conversed in a language we know, we understand them. However, in other languages; although they are still letters and words, we cannot understand them.

Well, in computer systems everything is defined in terms of 0's and 1's. Even letters. First, they used ASCII, which means that for every letter they used 8 bits. Later, they've seen that this was not enough because not every country was using English alphabet. They created **unicode** (*a universal character encoding standard that assigns a unique code point to every character*) which now uses 16bits instead of 8, which means now they can define more letters in 0's and 1's.

This means **encoding**. Transforming information from one form of representation to another. For example, if you give me 2 light bulbs; I can give you 4 types of information! A bulb can be open or closed, which means 1 or 0. If we have two light bulbs, we have 00, 01, 10 and 11. In simpler terms $2^2$.

So, we can also convey information in such terms. We can use a coin to do it too. A heads can mean 1 and a tails can mean 0. Of course, for it to have meaning, you need to have a map of these numbers to some terms. Pre-defined messages of sorts. For example, this is what we have with ASCII:

```
A - 01000001
C - 01000011
...
```

That means I can actually give you a letter by using 8 coins.

There are lots of opportunities like that. Previous examples were using binary, but we can also use *ternary*. A traffic light can mean something. Now, we can have 0, 1 and 2. It can hold more information!

---

However, although it looks like we are *hiding* information, we are not. To have **secrecy**, we need to use some sort of a *key*. That *key* is what separates *information hiding* from *encoding*. Philosophically speaking, some can argue that the *knowledge* of the map can be a *key*, but it is not the case. 

There are several kinds of encoding algorithms. The most popular ones are **base64** and **hexadecimal encoding**. 

## Hex Encoding

It is commonly used to represent binary data in a more *human-readable* format. It uses a base of 16. Remember that the *decimal* system is base 10, which means we can only describe something by using symbols (numbers) from 0 to 10. We do not have 10 in decimal system, we only have `0,1,2,3,4,5,6,7,8,9`. Similarly, hexadecimal system uses base 16. It has `0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F`.

Since 16 is $2^4$, we get the binary digits in sets of 4 and translate them into a single hex digit. 

```
0000 : 0
0001 : 1
.
.
1001 : 9
1010 : A
.
.
1111 : F
```

Those who are interested in character codes, refer to: [here](http://falsedoor.com/doc/ascii_evolution-of-character-codes.pdf)

As you can see, it is much more compact representing data in hexadecimal instead of binary. That is why, it is very convenient to display *memory addresses*, *machine code instructions* and *raw binary data*. 

## Base64

It uses a base of 64. It represents each value with 6 bits. The base consists of `A-Z, a-z, 0-9, +, /, =`

So, in binary we have 2 possibilities 0 and 1. In ternary, we have 3: 0,1,2. In hexadecimal, we have 16 and in base64 we have 64. 

Here, we have a data. Like everything, that data is represented as bits! So, we take those bits and group them into chunks of 6 bits. In *hex encoding* we grouped them into 4 because of base 16. 

Later, each group is converted to a single character from a specific set of 64 characters. 

We said that we group them into 6 bits. What happens if the last group has 4 bits? Then, we apply **padding**. We add padding characters `=` at the end, so that the *encoded* data ends on a multiple of 6. 

This conversion allows binary data to be represented as text. Therefore it becomes readable, compact and robuts. However, keep in mind that base64 is not **compression**. On the contrary, it increases the size of the data! 

Remember that **base64** actually converts every 6 bits into a character. Remember that characters requires 8 bits to represent! 

We can use base64 in the terminal pretty easily.

```bash
echo hi | base64
echo SGkK | base64 -d
```
---




