---
marp: true
paginate: true
---

# Diffie Hellman Key Exchange

---

Alice and Bob wants to communicate. However, they need a key so that they can encrypt their communication. 

How to come up with a key?

---

They first decide on 2 numbers. These are **public** numbers, they are no secret. 

These are $g$ and $n$.

- $g$ is a *small* **prime** number.
- $n$ is a *large* **prime** number, up to 4000 bits!

---

After establishing $g$ and $n$, Alice and Bob pick **two** numbers.
- These two numbers $a$ and $b$ are between $1$ and $n$.
($1 < a,b < n$)

- Alice picks $a$ and Bob picks $b$.

   - These numbers are **secret**. They don't share it with anyone. 
---

First, Alice takes $g$ to the power $a$ and takes modulo $n$.
   - $g^a$ (mod $n$)

Bob does the same, but with his own $b$.
   - $g^b$ (mod $n$)

After having these numbers, they send them to each other.
   - At this point, they can use an insecure line! Does not matter!

---

At this point, Alice and Bob sent each other some numbers.

Bob has:
   - $g^a$ (mod $n$)

Alice has:
   - $g^b$ (mod $n$)

Let's remember. Since $g$ and $n$ are public;

Alice knows:
   - $a$, $g$ and $n$

Bob knows:
   - $b$, $g$ and $n$
---

What happens when Alice and Bob takes what each other sent; and take it to $a$ or $b$'th power modulo $n$?

Alice knows $a$ and if she takes what Bob sent to a'th power:
   - $g^{b^a}$ (mod $n$)

Bob knows $b$ and if he takes what Alice sent to b'th power:
   - $g^{a^b}$ (mod $n$)

Mathematics says that these are the same!
   - $g^{ab}$ (mod $n$)

They arrived at the same number! They've established a key!

---

# Security

- Let's imagine that we are an attacker. 
   - We know $g$ and $n$ because they are **public**.

- The attacker needs $g^{ab}$ --> $a$ and $b$ are **private**.

- The attacker can get $g^a$ and $g^b$.
   - But these are not helpful to **generate** $g^{ab}$ because of **modulo** operation.
   - Let's say that $g^a$ (mod 3) is 0.
      - How can you know whether $g^a$ is 3, 6, 9 or 12 ?

- This is called **discrete logarithm problem**.

---

# Security

* There is a problem here!
   * This can be hacked by using MITM (man in the middle attack)

Remember that Alice and Bob are trying to communicate using an **insecure** channel.
- Which means someone can listen in on their conversation (they won't be able to understand anything but nonetheless, they can)

Let's say **T** is listening to the conversation!

---

Alice is going to send $g^a$ to Bob.
   - I will intercept and **steal** that information!
   - I will send $g^t$ to Alice.
      - Alice is going to take it to $a$ power and get -> $g^{at}$ mod($n$)
   - **We established a key with Alice!**

I will also do the same thing with Bob.
   - I will send bob $g^t$ and he will send me $g^b$.
   - We will both have $g^{tb}$. **We established a key with Bob!**.

---

Alice will send a message to **me**, thinking I am **Bob**.
- She will encrypt the message with $g^{at}$. I have the key so i an decrypt.

I decrypt and read the message. Later, I **encrypt** it with the key **I** have with **Bob**.
- I will encrypt the message using $g^{tb}$.

Now, Alice and Bob are communicating, thinking everything is fine and dandy.
- Here I am reading all their information!

---

# Solution

In order to understand the following, you need to know how **RSA** works.

Alice **needs** to make sure that the other party is **actually** Bob.

We can use **RSA** to make sure!
- In RSA, every user have a **public key** and a **private key**
- These can be used to **identify** a user.

Alice sends $g^a$ to Bob again, and Bob is going to send $g^b$.
- But this time, Bob is going to **hash** $g^b$ and **sign it** with his **private key**. Send this alongside $g^b$.
   - Remember that when something is encrypted by using **private key**, the other can decrypt it by using the **public key**.

---

# Solution

Since Bob's **public key** is public, Alice knows Bob's public key.
- She can use this to decrypt the message. When she decrypts, she will see the **hash**.
- She also received $g^b$. When she hashes this, she must get the same **hash** (which was the result of the decryption). Thus, she can **verify**

If any attacker tries to do MITM like before, he/she will not be able to replicate, because they don't have Bob's **private key**.
- Since Alice is going to use **Bob's** public key, we cannot cheat this.

---
DHE is used everywhere, in VPN, TLS, etc. Almost every connection we have through the Internet uses it.

However, now we know about RSA. Why don't we just use RSA and get over with it?
- Because RSA is **slow**.

In addition, what happens when the key is stolen?
   - **Then, every message before and after will be broken!**

DHE gives us a quick way to establish keys, and these are used only a few times.
- We use RSA to **verify** that there is not a **man in the middle**.

DHE and RSA are used together in order to create a **key** for **symmetric encryption**.
- In TLS -> `TLS_DHE_RSA_WITH_AES_256_GCM_SHA384`: Meaning use DHE for key exchange, authenticate using RSA, and encrypt with AES using Galois Counter Mode and SHA (for MAC).



   
