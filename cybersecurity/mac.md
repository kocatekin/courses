---
marp: true
paginate: true
---

# MAC

---

# Introduction

- We want parties to be able to communicate over an *open communication* channel
   - Insecure channel

- We can do this by using **encryption**. Encryption prevents an eavesdropper from learning anything about the content of messages.

- However, not all security concerns are related to **secrecy**.

- We also need to think about **message integrity**

---

# Message Integrity

- Alice is sending a message to Bob.
- If the message is encrypted, we provide secrecy.
   - However, how do Bob know if the message was sent by Alice?
- This is as important as **encryption**
- Each party should be able to identify when a received message is sent by the claiming party **and** not modified in transit.

---

# Example 1

- User is communicating with a bank over the internet.
- Bank receives a request to transfer $1000 from Alice to Bob.
   - Is the request **authentic**?
      - Did Alice really issue this request or maybe it was issued by someone else?
   - If the request is authentic, are the **details** correct?
      - Are we sure the transfer amount is not modified?

---

# Example 2

- HTTP is stateless.
   - Therefore, client and server communicate in some session.
   - The session id is stored in the cookies and cookies are sent to server in each requests.
- Let's imagine that cookie stored by some user includes the items in the user's shopping cart along with the price of each good.
   - What if I can change it?
- If I can change it, the server **must** know that the contents of the cookie is changed or not!

---

# Ensuring the integrity of the communication

- We need to **ensure** the integrity of the communication.
- Do not trust if an email came from someone you know
   - Or an SMS, phone call etc.

---

# Encryption vs Message Authentication

- Goals are different.
   - Secrecy vs integrity
- Techniques and tools to achieve them are different as well.
- **Encryption does not provide integrity.**
   - It should never be used to achieve message authentication.
   - Yes, it hides the contents of the message and an attacker cannot modify an encrypted message in a meaningful way.

---

# Encryption using stream ciphers

- Remember in stream ciphers we XOR the **key** and **plaintext** to get a ciphertext. Decryption is the same.
   - What happens when someone **flips a bit** in the ciphertext.
   - It causes a change (modification) in the plaintext. The destination can read a **different** but **meaningful** message.
- This is a serious attack.

---

- Imagine a case where the user is encrypting some amount of money he wants to transfer to a bank account.
- The amount is in binary.
   - 01100100 -> 100 in decimal
   - Flipping the most significant bit
      - 11100100 --> 228 !

- With this attack, the **secrecy** is still there.
   - Even with one-time pad (perfect secrecy), this attack works.

---

# MAC

- Encryption does not solve the problem of message integrity.
   - We need an additional mechanism which will enable the parties whether or not the message was tampered with.
- We will use a **message authentication code** for this (MAC)
- The purpose is to prevent an adversary from modifying the message or injecting a new one.
- Just like encryption, it is only possible if communicating parties share a secret that is unknown to the attacker.

---

# Syntax

- Two users, Alice and Bob wish to communicate in an authenticated manner.
   - They generate and share a secret key $k$ in advance.
- When Alice wants to send a message $m$, he computes a MAC tag $t$
   - This is based on the message and the shared key.
   - Sends $m$ and $g$ to Bob.
- Tag is computed by using a *tag-generation algorithm* and denoted by $Mac$.


---

# Working

- Alice has the message $m$, computes $Mac_k(m)$ and transmits $(m,t)$ to Bob!
- Bob receives $(m,t)$ and first it *verifies* whether $t$ is a valid tag on the message $m$.
   - Uses a *verification algorithm* $Vrfy$ which takes as input the $k$, $m$ and $t$. 
- Actually, Bob does the same thing that Alice did.
- Bob has $m$ and secret key $k$.
   - He creates the **tag** himself.
   - If the tags are the same, that means everything is good.
   - If not, that means message $m$ was changed in transit!
- Message integrity is provided as a security service!

---

- If an attacker (Oscar), changes the message during transmission, he cannot compute a valid MAC
   - Because he doesn't have the **secret key**.
- Any malicious forgery or accidents (e.g. transmission errors) will be detected by the receiver due to a **failed MAC**.

---

- In practice, the message $m$ is much larger than the corresponding MAC. 
- Similar to hash functions, the output of a MAC is a fixed-length authentication tag, independent of the length of the input.

---

# Properties of Message Authentication Codes

- Generates a cryptographically secure authentication tag for a given message.
- Symmetric MACs are based on symmetric keys. 
- MACs accept messages of arbitrary length.
- Has fixed output length.
- Provides message integrity & authentication.

---

# HMAC

* An option to realize MAC's is to use cryptographic hash functions such as SHA-1 as a building block.
* HMAC is very popular.
   * Used in both TLS and IPSec.
* The basic idea behind HMAC is that the **key** is **hashed** together with the message. 
* There are two constructions:
* For message $x$ and key $k$:
   - 1. $m = MAC_k(x) = h(k||x)$
   - 2. $m = MAC_k(x) = h(x||k)$

- First is called **secret prefix** and second is called **secret suffix** MAC.

---



