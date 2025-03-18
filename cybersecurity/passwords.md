---
marp: true
paginate: true
---


# Passwords

---

# Entropy

* Entropy is a measure of randomness.
   * Useful when determining the strength of passwords.
* It is measured in **bits**. $log_2(x)$.
   * A fair coin flip gives you 1 bit of entropy.
   * A dice roll with 6 sides gives you 2.58 bits of entropy.
* How many bits of entropy do we need?
   * Depends on the *threat model*.
   * For online guessing ~40 bits are good. For offline, 80 bits or more is much better.

---

# Key Derivation Functions (KDF)

* These algorithms get an input and provide a fixed-length output.
   * The output is used as **keys** in other cryptographic algorithm.
* So we use these algorithms to create **keys** for us out of a given *password*.
* These are **deliberately** slow, unlike hash functions.
   * The aim is to make attacks slower.
   * With a slower function it will take more time to brute force a password.
* Therefore, when we are storing passwords, instead of using *hash* functions we actually use **KDF**.

---

# Password Managers


---

# Multi-factor authentication

---

# Choosing a password

* Minimum length of a password must be enforced by the application.
   * NIST standarts state that any password shorter than 10 characters are considered to be weak.
   * However, if the password is too long users can have a hard time memorizing them.
      * This can be an issue. Sometimes they write it onto a piece of paper to remember.
   * For that reason we have **passphrases**.
      * These are sentences or combination of words which are *longer* but *easier* to remember.
      * However, the **max** number of characters for a password should not be too low, otherwise it would prevent users to create passphrases. 

---

* https://owasp.deteact.com/cheat/cheatsheets/Authentication_Cheat_Sheet.html
* 

---

# Authentication responses

* One should never give more information that they are supposed to.
* Let's imagine a scenario where the user is logging in but with wrong credentials
* We should never return the following:
   * Wrong password for `user`
   * Invalid user id
   * Account disabled
   * User not active
* These responses give information, that means anyone can know learn about the user.
* The correct response should be:
   * Login failed. Invalid username or password

---

# Logging and monitoring

* For every authentication attempt, we need to store logs about it
   * All failures should be logged and reviewed
   * All password failures should be logged and reviewed
   * All lockouts are logged and reviewed

---

# Password storage

* The password **must not be** stored in plaintext.
* We must apply a **one-way function** to it and store it like that.
   * However, a hash by itself is not enough.
   * If two users have the same password, they will have the same hash.

* https://owasp.deteact.com/cheat/cheatsheets/Authentication_Cheat_Sheet.html
* https://owasp.deteact.com/cheat/cheatsheets/Password_Storage_Cheat_Sheet.html


