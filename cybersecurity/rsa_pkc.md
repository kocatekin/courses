---
marp: true
paginate: true
---

# Public key encryption & RSA

---

# Philosophy

In symmetric key, we used the **same key** to encrypt and decrypt messages.
* In asymmetric cryptography, encryption and decryption are done using a **key pair**.
* Public key & Private key ($PU_t$, $PR_t$)

Every user has a **key pair**.
* Those who wants to communicate with others, publish their **public keys**.
* **Private keys** are only known to the owner.

---

# Used for

Key establishment
   * Establishing **secret keys** to be used in symmetric cryptography.
      * DHE is the most popular.

Nonrepudiation
* Digital signatures

Encryption
* RSA, ElGamal, etc.

---

# Protocols

There are three popular ways to realize:

* Integer factorization
* Discrete Logarithm
* Elliptic Curve

These are mathemtical problems, which the modern computers are not able to solve in polynomial time.
* However, not safe in the quantum world due to **Shor's Algorithm**
* We'll use **lattice based** algorithms in the future.

---

# Key lengths

An algorithm is said to have a **security level** of $n$ bits if the best known attack requires $2^n$ steps.
* Symmetric algorithms with a security level of $n$, have a key length of $n$ bits.

Asymmetric encryption bits require **very long** keys.

<table>
<tr><th>Family</th><th>Security Level (256)</th></tr>
<tr><td>RSA</td><td>15360 bits</td></tr>
<tr><td>AES</td><td>256 bits</td></tr>
</table>

---

Since keys are long, it is arithmetically intensive.
* That is why it is much slower compared to symmetric encryption.

A digital signature can be 2-3 times slower, compared to encryption of one block using AES or 3DES.
* Computers are fast enough, but think about IoT devices, etc.

---

# PU & PR

If something is encrypted by Bob's PU -> $PU_{Bob}$
* Only Bob's PR can **decrypt** it ($PR_{Bob}$)

If something is encrypted with Bob's $PR$
* Only Bob's $PU$ can **decrypt** it.
* This step is used for **authentication**, not **confidentiality** (because if Bob encrypts using his $PR$, everyone can decrypt it.)

---

# Encryption

Alice wants to send a message to Bob.
* Everyone knows Alice's and Bob's **public key**s. They are **public** information.

Alice prepares the message and encrypts it using $PU_{Bob}$.
* $C = E(PU_{Bob}, M)$
If anyone intercepts the message, they will see the *ciphertext*. They are not going to be able to **decrypt** it, because they don't have $PR_{Bob}$.

---

# Decryption

Remember that if something is encrypted using $PR$, $PU$ can open it, and vice versa.
* Therefore, Bob now uses his $PR$ and decrypts the message.
* $M = D(PR_{Bob},C)$

---

# Authentication

By encrypting $M$ with the $PU$ of the destination (Bob), we provided **confidentiality**.
* Now, even if someone intercepts, they cannot read it.

However, since Bob's **public key** is known, everyone can send a message.
* How does Bob understand the message is sent by Alice?

---

# Authentication

Alice encrypts $M$ with $PR_{Alice}$, and encrypts the output of this operation with $PU_{Bob}$.

1. $A = E(PR_{Alice},M)$
2. $C = E(PU_{Bob},A)$

It is like opening up an envelope. When Bob receives $C$, he will first decrypt that by using his $PR_{Bob}$. He will get $A$ out of that. Later, he will use $PU_{Alice}$ (public key of Alice) to decrypt $A$ and will see $M$.

This means the message came to **him** and from **Alice**. We applied **confidentiality** and **authentication**.

---

Later, we will see that this approach is going to be used in **digital signatures**.
* There, instead of encrypting $M$, we will encrypt (sign) $hash(M)$.

---

# RSA

Created by Ron **R**ivest, Adi **S**hamir and Leonard **A**dleman.
* In 1977. 

It is a very popular public-key algorithm. 
* Used for encrypting small pieces of data.
* Digital signatures

Usually we use RSA to encrypt the **keys** we use in symmetric encryption.
* Cannot replace symmetric encryption because it is very slow.

---

# RSA

Relies on **integer factorization problem**.

Public key:
* Pair of integers $(e,n)$ 

Private key:
* Pair of integers $(d,n)$

When we want to 
* Encrypt something: $C = M^e$ (mod $n$)
* Decrypt something: $M = C^d$ (mod $n$)

---

![alt text](image.png)

---

# Prime numbers

* A natural number {0,1,...} greater than 1 which is **not** a product of two *smaller* natural numbers.

* A natural number greater than 1 which is **not** a prime number is called a **composite number**.

* Every natural number greater than 1 is either a **prime** or can be **factorized** as a **product of primes** that is unique up to their order.

---

# Prime factorization

Writing a number as a product of **prime numbers**

$20 = 4*5 = 2*2*5 = 2^2 * 5$

---

# GCD - Greatest Common Divider

$gcd(r_0, r_1)$
* The result is the **largest** positive number that divides both $r_0$ and $r_1$.

Example:
* Let $r_0 = 84$ and $r_1 = 30$. Calculate the $gcd(84,30)$.

---

# Solution 1 - Prime factorization

* $84 = 4*21 = 2^2 * 3 * 7$
* $30 = 2*3*5$

We can see that $2$ and $3$ are common.
* We can get the $gcd()$ by getting the product of **all common factors**
   * That'd give us the **greatest divider** which is $6$.

---

# Solution 2 - Euclid's Algorithm

Given two positive integers $a$ and $b$ such that $a>b$, the common divisors of $a$ and $b$ are the same as the common divisors of $a-b$ and $b$.

$gcd(84,30)$ => $gcd(54,30)$ => $gcd(24,30)$ => $gcd(6,24)$ => $gcd(18,6)$ => $gcd(12,6)$ => $gcd(6,6)$ => $gcd(0,6)$ => $6$

---

# Solution 3 - Euclidean Algorithm

A more efficient method compared to others.
The difference of two numbers $a$ and $b$ is replaced by the *remainder* of the Euclidean division of $a$ by $b$.

So, $(a,b)$ is replaced by $(b,a$ mod $b)$

So;
$gcd(84,30)$

---

$gcd(84,30)$ = $gcd(30, 24)$
$gcd(30,24)$ = $gcd(24, 6)$
$gcd(24,6)$ = $gcd(6, 0)$
=$6$.

We can also write a program for this!

---

```javascript
function run(first, second) {
   while(1==1){
      let r0 = Math.max(first, second);
      let r1 = Math.min(first, second);
      first = r1;
      second = r0 % r1;
      if(first == 0 || second == 0) {
         return Math.max(first, second);
      }
   }
}
```

---

# Euler's Phi (totient) Function: $\phi(m)$

Gives the total number of numbers that are **relatively prime** to $m$.

* If $gcd(a,b)$ = $1$ ; that means $a$ and $b$ are **coprimes**
   * Relatively primes.

---

# Example

Let $m = 6$. Find $\phi(m)$

* We are looking for numbers which are **coprimes** to 6.
   * We will check $0,1,2,3,4,5$ for it.

So, we will calculate $gcd(0,6) , gcd(1,6)$ and so on.
* If the $gcd$ is 1, that means $a$ and $b$ are coprimes.


---

$gcd(0,6)$ = 6
$gcd(1,6)$ = 1 ⭐
$gcd(2,6)$ = 2
$gcd(3,6)$ = 3
$gcd(4,6)$ = 2
$gcd(5,6)$ = 1 ⭐


We see that there are **two** numbers which are **coprimes** to 6.
* The result is $2$.

---

Let $m=5$, find $\phi(m)$.

* Let's write a program for this too! We'll make use of the function before.

```javascript
function phi_of_m(m) {
   let res = 0;
   for(let i=0;i<m;i++){
      let result = run(i,m);
      if(result == 1) res++;
   }
   return res;
}
```
---

# Better way

Write $m$ in **canonical factorization form**.

$m = p_{1}^{e_1}.p_{2}^{e_2}..p_{n}^{e_n}$

* where $p_i$ are distinct prime numbers and $e_i$ are positive integers.


$\phi(m) = \displaystyle\prod_{i=1}^{k} \left(p_{i}^{e_i} - p_{}^{{e_i}-1} \right)$

---

Let $m=240$, calculate $\phi(m)$.

First we write it in canonical factorization form:
* $240 = 16*15 = 2^4 * 3 * 5$
* There are 3 distinct prime factors: 2,3 and 5.
   * This means $n=3$.

Calculating $\phi(m)$: 
* $(2^4 - 2^3) * (3^1 - 3^0) * (5^1 - 5^0)$
* $(16 - 8) * (3 - 1) * (5 - 1)$
* $64$

This means that between 0..240, there are 64 integers which are **coprimes** to 240.

---

Actually there are some relationships between $n$ and $\phi(n)$.

<table>
   <tr><th>n</th><th>phi(n)</th></tr>
   <tr><td>1</td><td>1</td></tr>
   <tr><td>2</td><td>1</td></tr>
   <tr><td>3</td><td>2</td></tr>
   <tr><td>4</td><td>2</td></tr>
   <tr><td>5</td><td>4</td></tr>
   <tr><td>6</td><td>2</td></tr>
   <tr><td>7</td><td>6</td></tr>
</table>

When $n$ is a prime number, $\phi(n)$ is $n-1$.
When $m$ and $n$ are **coprimes**, $\phi(m*n) = \phi(m) * \phi(n)$ **TRY!**

---

# RSA Key generation

We learned all that number theory to be able to understand how RSA works.

When generate keys, we are going to end up with a **key pair**
   * $PU$ and $PR$

$PU : (n, e)$
$PR : d$

---

* First, choose two **large** primes: $p$ and $q$
   * No useful techniques for this, generally pick a random number and test whether it is prime or not.
* Compute $n = p*q$
* Compute $\phi(n) = (p-1)(q-1)$ -> remember from last slide!
* Now, select a number $e$ between 0 and $\phi(n)-1$ such that $gcd(e,\phi(n))=1$.
   * In other words, select and $e$ such that $e$ and $\phi(n)$ are **coprimes**
* Compute private key $d$ such that
   * $d*e =$$(mod$ $\phi(n)$)

---

* Let's select $p = 17$ and $q=11$
* Calculate $n = pq$ --> $187$
* Calculate $\phi(n) = 16*10$ -> $160$
* Select $e$ which is relatively prime to $160$ and less than that: $7$
* Determine $d$ such that $de \equiv 1$ ($mod$ $160$) and $d < 160$.
   * So here, we need to find a $d$ -> $23$ is possible.

So, $e=7$, $d=23$, $n=187$ and $\phi(n)=160$.
$PU = {7,187}$
$PR = {23,187}$

---

So, for a given $M=88$, we can encrypt it:

* $C = 88^7$ $mod$ $187$

and vice versa to decrypt.

---

# Decryption

$M = ({C^e})^d$ $mod$ $n$
* $(C^{ed})$ $mod$ $n$



---

# Security

$p$ and $q$ are **very large** numbers, consisting of several *hundred* digits.
* They should not be close to each other.
* They should also pass primality tests (to see whether they are primes)

Size of $p$ and $q$ effects $n$, therefore the **key size**.
* Length of the $n$ is the sum of bit lengths of $p$ and $q$.
* So if they are 1024 bits, key will be roughly 2048 bits.
* Length of $n$ is commonly referred to as key size.

---

# Security

Larger key size means better security.
* Makes the system more secure against brute-force attacks
* But, more computational overhead.

2048 bit key is considered minimum for strong security.
* 3072 and 4096 are of course, better. 
   * For situations requiring long-term protection.

---

# Security

$p$ and $q$ are **secrets**.
* They are **not** public.
* However, $n$ is **public**. (public key)
* $\phi(n)$ **private**.
   * Because we need $(p-1)$ and $(q-1)$ for that.
* $e$ is public, $d$ is private.

Can we find $p$ and $q$?

---

If an attacker can find $p$ and $q$; what can they do?
* They already know $n$ and $e$ (bc public key)

So, what they are missing is $d$ and $\phi(n)$.
* Well, if they know $p$ and $q$ they can find $\phi(n)$.
   * They can find $d$ from there too! ($de \equiv 1$ ($mod$ $\phi(n)$))

We already know $n$ though, can we find $p$ and $q$ from that??
* No! Because of **prime factorization problem**. This cannot be solved in polynomial time!

---

# DHE time!

