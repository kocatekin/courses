---
marp: true
theme: beamer
header: Computer network and security
footer: Istanbul Arel University - Spring 2023
paginate: true
---

<!-- _class: title -->

# Stream Ciphers


---

# Introduction

* In symmetric cryptography, there are two types of encryption. Stream ciphers and block ciphers.
* A stream cipher encrypt bits _individually_, bit by bit. 
  * It is used to encrypt _streaming_, _flowing_ data.
  * That is why it is used for communication data where the size of the incoming data can be unknown.

---

# Encryption and Decryption

Encryption and decryption are very simple. It uses **XOR**.

Encryption: $y_i = e(x_i) = x_i + s_i$ mod2
Decryption: $x_i = d(y_i) = y_i + s_i$ mod2

where $x_i, y_i, s_i \in Z_2$

Summation in binary is just XOR.

---

# Example

Let's encrypt the letter **A** in ASCII form.

A: 1000001
S: 0101101

Here, S is chosen randomly.
When we take the XOR, the result ($y_i$) becomes:
$y_i$: 1101100

In order to _decrypt_, we need to XOR $y_i$ with $s_i$.
When we do it, we will get the original $x_i$, A.

---

# Key stream

Everything looks good, but the problem is _generating_ the **key stream**. We need a _random_ keystream so that people cannot find them and break our system.

In order to create random numbers, we use **Random Number Generator (RNG)**'s. There are three main types of them.

---

# TRNG: True Random Number Generator

It generally stems from physical processes. A coin flip, lottery, thermal noise, mouse movement, time between keypresses, etc. 

When we say **true random** it means that it is impossible to **recreate** them.

---

# PRNG: Pseudo Random Number Generator

- These are not **true random**. 
  - That means they can be **recreated**.
- PRNs are **computed**, and therefore **deterministic**.
- They are often computed as follows:
  - There is a _seed_ $s_0$. This seed can be truly random.
  - Then, the bits of the keystream are calculated by using the previous key bit.
  - $s_{i+1} = f(s_i)$
    - This means that the next bit in the key stream is a function of the previous bit. It all goes back to seed.
    - If the seed is the same, the keystream will be the same too.

---

# Example

* The `rand()` function in C programming language is an example to it. It has a fixed seed $s_0$ 12345 and the function is:

* $S_{i+1} = 1103515245*s_i + 12345$   mod$2^{31}$ 

We cannot use PRNG's in cryptography. We need them, but with some additional properties.

---

# CPRNG: Cryptographically Secure PRNGs.

* These are just PRNG with that additional property we mentioned. The numbers are **unpredictable**. 
* Remember that each bit is a function of a previous one. So here, we say that:

* Given $n$ output bits, $s_i, s_{i+1}, ..., s_{i+n-1}$ it is computatinally **infeasible** to construct $s_n$.

We use PRNGs a lot in life and we are okay with them. But if we want to use them in our cryptographic systems, we need this **unpredictability**.

---

# One time pad (OTP)

* We want to build a **perfect** encryption algorithm. 
  * Perfect means it cannot be broken.

* A cipher is _unconditionally secure_ if it cannot be broken even with infinite computing resources.
  * OTP!

* OTP is a stream cipher where:
  * key stream bits $s_i$ stem from a **TRNG**.
  * each key stream bit is used **only once**.

---

# OTP

* OTP cannot be broken.
* However, remember that if the destination want to decrypt the message, they need the key!
* And the problem with OTP is that the _key length_ must be the same with the _message_ (plaintext).
### Example
If we want to encrypt a 400MB files, the key will be 8.400 = 3.2Gbits long!

Sending this many keys is hard and in addition to that, you must **never** use the key again!

---

# What to do?

- Well, we have seen that TRNG works but it is not that useful. 
  - OTP uses TRNG. The key must be truly random.
- Let's go to the second RNG --> PRNG.
  - We said not to use it in cryptography and we will see why.

---

# LCG: Linear Congruential Generator

* The previous example `rand()` is such a generator. This is a part of PRNG.

* Here we have a **seed** again.
* $S_{i+1} = A.S_i + B$ (mod m)
  * And the _key_ is $(A,B)$.

Here, if the message is 30 bits, A, B and $S_i$ are 30 bits too.

However, this system can be broken very easily!

---

# Example

The way we use PRNGs are as follows.
- Normally, we get the message $x$ and keystream $s$ and XOR them bit by bit.
  - Here, we do the same but now the $s$ keystream comes from the **PRNG**.
  - Remember that we need to have the same keystream in both source and destination.
  - So, by giving the same key $K$ to both **PRNG**, we can get the same $s$ output and XOR $x$ and $y$ with it.

So what is the problem?
The problem happens when an attacker gets a hold of some plaintext. This can easily happen, for example _header_ files are good examples to it.

---

# Attack

Let's say that the attacker got a hold of three plaintext $X_1, X_2, X_3$. We know that the attacker also has the ciphertext naturally, $Y_1, Y_2, Y_3$. 

Now, the formula is very simple. It is a _linear equation_ with 2 unknowns. 

$S_{2} = A.S_1 + B$ (mod m)

Attacker knows $S_2$ and $S_1$. He also knows $S_3$. By adding a new equation we can solve $A$ and $B$.

$S_{2} = A.S_1 + B$ (mod m)
$S_{3} = A.S_2 + B$ (mod m)

If he can get $A$ and $B$, he can get every $S$ bit.

So, we do not use **LCG** in cryptography!

---


# LFSR

---

# Shift register

FILL HERE

---

# LFSR: Linear Feedback Shift Register

Let's select 4 random bits to see how this works.

1001

Now, we shift this to the right. So, the $1$ at the rightest end will be the _output_. So, we now have **_001**. The first is empty. What are we going to write there?

For that, we actually create a **rule** that we want to follow. It is also called a **tap**.

For example, lets define the numbers as $x_3, x_2, x_1, x_0$. 
We will say that $x_3 = x_1 + x_0$ mod2 (which is XOR)
- Therefore, we will XOR $x_1$ and $x_0$ and write it as the first digit.

---

# LFSR

It will go as follows:
$1001$ -> $1$
We will XOR 0 and 1; 

$1100$ and the output is: 0
We XOR 0 and 0;

$0110$ ...

It will carry on like this! What will we wait for?

---

# LFSR

When we carry on like this, we will actually get the initial $1001$ at some point. We know that since there are 4 bits, the number of all combinations is $2^4$, 16. But if you check it, you will never have $0000$, that means that the maximum number of steps can be 15 at most. ($2^n - 1$) for $n$ bits.

Here, by just using a simple _rule_, we were able to get all possible combinations of this bit stream. This holds for any bitstream, regardless of the length. However, the _rule_ we choose is very important. 

Let's say that we chose to XOR 3 elements instead of 2. Here, we will XOR $x_3, x_1, x_0$.

---

# LFSR

We start with $1001$ again.

We XOR 1,0,1. First digit becomes 0.

$0100$. We XOR 0, 0, 0. First digit becomes 0.

$0010$. We XOR 0, 1, 0. First digit becomes 1.

$1001$. 
As we see here, it only takes 4 steps. 
- So, selecting taps is very important. 
- There are mathematical ways to make sure that we get the maximum number of periods.
  - Why? Because we want a _long_ random number. That is the aim!

---

# LFSR

There are used _all the time_ for random number generators. Advanced versions are used for some of the popular random generators.
- Not cryptographically secure. If you are able to get a _part_ of the stream, you can actually solve some linear functions to get the rule!
  - Then, you can compute every step.

At this stage, we can see that these are not good candidates for _stream ciphers_. Because it is _linear_. 
- However, if we have multiple LFSR's and if they don't _shift_ at the same time, we can have a **non-linear** combination of LFSR's and this can be used.
  - Trivium Cipher
  - GSM

LFSR's are very **quick** and cheap in hardware so very useful for low-powered devices.

---




