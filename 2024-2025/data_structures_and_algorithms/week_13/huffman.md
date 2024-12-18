Let's say that we want to send a message from one party to another.

```
msg = BCCABBDDAECBBAEDDCC
```

There are 20 characters in this message. The size of the message is going to be what? If we use ASCII letters and let's assume we do, we will use 8 bits per character/symbol. (In unicode, it can be 16-bits)

So, our message is now 160 bits. 
Well, is it possible to decrease the size? Yes.

First, we will use *fixed size encoding* to reduce the size.
In order to understand this, we need to understand how we represent data. We talked about this before, let's do a quick recap.

```
_ bits --> it can either get 0,1. 2 chars. (2 ^ 1)
__ bits --> can have 00, 01, 10, 11. So, 4 chars (2 ^ 2)
...
```

Well, the message is carefully designed so we can see that we are only using A, B, C, D and E letters. ASCII is 8 bits, because it actually can represent 2^7 symbols (there is an additional bit). However, now we don't need that. We are not using $2^7$ symbols, we are only using 5 symbols. Well, we can represent 5 symbols using **three** digits. ($2^3$ will be sufficient)

We still have 20 characters but now each character is going to use 3 bits instead of 8. Now our data became 60 bits.

However, there is a problem. Yes, ASCII is a standard but we created something else. Here, how is the *destination* going to be able to decode this message? We need to send them our *encoding scheme*. So, we are going to send them a table. We will send them the sequences we represent the symbols.

So, for A we are going to send the ASCII first (8 bits) and later we will send our own 3 bits. We send the ASCII because it is universal. At this point, we had 60 bits but now we have 5 symbols and will send them with ASCII -> 8 bits. Plus we will add our own 3 bits --> 11 bits. In total, we are going to add 55 bits.

Well, 60 + 55 = 115 bits.
Still, much better compared to 160 bits. This is called **fixed size** encoding.

However, is there a better way?
Huffman encoding tells us that there is!

Huffman encoding cares about the frequency of symbols. Frequency means how many times that symbol is seen in the text. If a symbol is repeated too much, we can represent it with less digits. It will have a very positive effect.
