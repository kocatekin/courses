# Git

Version control is one of the fundamental skills every developer needs. Whether you are working alone or with a large team, version control keeps your work organized, safe, and collaborative.

Version Control System (VCS) is a tool that tracks changes in files over time.

It allows you to:
* Go back to previous versions
* Compare changes
* Restore deleted code
* Experiment safely
* Collaborating with others without overwriting work

Git is the most widely used version control system today.

---

Git can be downloaded for Windows or *nix systems. In Windows, it comes with its own *Git Bash*. A little bash to work Git commands. 

When you first install git, you set up your Git account. After you did all, you are ready to use it.

---

## Cloning an existing directory

Sometimes, you may find a Git repository online and might want to download them to your machine locally, so you can work on that in your local machine, offline.

For that we use `git clone` command. For example, go into: https://github.com/kocatekin/courses

There, you will see a green button: `<>Code`. When you click on it, you will see some settings for Cloning. Choose HTTPS and copy that url ending with git. Now you can do `git clone https://github.com/kocatekin/courses.git` do get that repository to your local machine.

You will see something like this: 
```bash
Cloning into 'something'...
remote: Enumerating objects: 1203, done.
Receiving objects: 100% (1203/1203), 3.9 MiB | 2.0 MiB/s
Resolving deltas: 100% (820/820)
```

---

## Creating a repo

Git repositories (repos) are the core of version control. A repository is where Git tracks all your files, versions, commits, branches, and history.

We use `git init` to turn any folder into a Git repository. When you run this command, it creates a hidden file: `.git`, and will output:

`Initialized empty Git repository in /Users/ali/FleetTrackingApp/.git/`

At this point, Git is going to track everything in this directory. 

First, without doing anything type `git status`. This part gives you the **staging area**. And you will see that at first, it is empty.

```bash
On branch main

No commits yet

nothing to commit (create/copy files and use "git add" to track)
```

As you see, there is no file in the directory and when we run `git status` this is what we see. Now, let's create a *text* file named `course.txt`, and write the name of the course inside. After that, let's run `git status` again.

```bash
On branch main

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
	course.txt

nothing added to commit but untracked files present (use "git add" to track)
```

This is the output. Now we have something new: **untracked files**. Git saw that there was a new file, but giving us information that it does not *track* this, in other terms it does not *track changes* on that file. 

If we want to track this, as it points out, we need to add this to our repository. We do that by using `git add` command. For example now, let's do `git add course.txt`. After that, we do `git status` again.

```bash
On branch main

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
	new file:   course.txt
```

Now, we can see that it does not write *untracked changes* anymore. Now it says, **changes to be committed**, in other terms now we can commit this because there is something new (changed) compared to the previous commit.

When we commit, it means we are saving this as a snapshop in time. This means if we need to, we can go back to it whenever we want!

So, we commit this change. In every commit, we need to give a *message* with it. This message is not going to be long, but it should not be very short either. It should always give some meaningful description of what *we did*.

We commit by: `git commit -m "our commit message"`.

```bash
[main (root-commit) da4dbf0] first commit
 1 file changed, 1 insertion(+)
 create mode 100644 course.txt
```

You will get a similar message. At this point if we run `git status` again, we will see:

```bash
On branch main
nothing to commit, working tree clean
```

Now, for the sake of experimentation let's add something more to this text. Just add a line. Run `git status` again:

```bash
On branch main
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
	modified:   course.txt

no changes added to commit (use "git add" and/or "git commit -a")
```

Now, it says again *not staged for commit*, which means we need to **add** this again. By the way, be careful, now it says **modified**. Before it was **created**. What do you think will happen if you removed the file?

Now, sometimes we are going to change multiple files, so it's possible that it may come hard for you to write *git add* all the time, so we can do `git add .` in short and add everything that's changed!

Let's do it and commit again. 

---

## Log

When we want to see all our previous commits, we can run `git log` command. 

```bash
commit a2fcd8de37dbfab4d5ce687dc302353de54eb0e6 (HEAD -> main)
Author: kocatekin <tugberk+course@gmail.com>
Date:   Tue Dec 2 23:31:13 2025 +0300

    second commit

commit da4dbf0d4d2931a3e7a9f454903d9812f992b02c
Author: kocatekin <tugberk+course@gmail.com>
Date:   Tue Dec 2 23:28:28 2025 +0300

    first commit
```


As you can see there are some information here. I can see every commit here, the author, the date and the commit hash. Commit hash is a unique value, indicating that specific commit. It works as an ID. It uses SHA1.

Underneath we can see the commit message. Obviously, the commit messages here are not that meaningful, but we are not doing meaningful stuff anyway. 

Whenever you add or remove something (a functionality), you do a commit.

If you have lots of commits, *git log* will take up too much space. For that reason, we can use `git log --oneline` which turns the output into:

```bash
a2fcd8d (HEAD -> main) second commit
da4dbf0 first commit
```

This is much shorter. `HEAD -> main` tells us that we are at main now. Do not worry about it for now, you will learn about it in Software Engineering course next semester.


---

## Going back

So, now we committed everything and we can see all our commits! What happens if we did something bad and broke the system, and want to go back?

For that, we use `git checkout` command. Remember the *hashes* we had, we need to add them too. We will do `git checkout hash`. However as we saw in *git log*, the hash is too long. Fortunately, `git log --oneline`  gives us the first 7 chars of the hash - and we can use it.

In our example, we did two commits. HEAD -> main, tells us that we are at the top. Let's say we want to go back to the first edition. We do: `git checkout da4dbf0`.

```bash
Note: switching to 'da4dbf0'.

You are in 'detached HEAD' state. You can look around, make experimental
changes and commit them, and you can discard any commits you make in this
state without impacting any branches by switching back to a branch.

If you want to create a new branch to retain commits you create, you may
do so (now or later) by using -c with the switch command. Example:

  git switch -c <new-branch-name>

Or undo this operation with:

  git switch -

Turn off this advice by setting config variable advice.detachedHead to false

HEAD is now at da4dbf0 first commit
```

Git, gave us a warning. We are now in *detached HEAD* state. Meaning that we are not showing the most recent anymore. We want back in time. At this point, if you read your text file, you will not see the thing you added for the second commit. You went back in time!

However, if you want to RESET, that is different. That means, you want *that* to be your **new HEAD**. For that, there are multiple ways but for now we can just use:

`git reset --hard <hash>`

This will remove everything after that commit. Another way is, you just create a new branch from the old commit. So, the previous addings you did are still there, but now you are working on a different branch. 

However, if you do that, you will be in a different branch and **not** in main (master) branch. When you want it to be the main, you need to do *reset* or a *merge* later. 

You will learn about branches later, but let's do an introduction to them. First, lets use the reset to see what will happen.

```bash
HEAD is now at da4dbf0 first commit
```

At this point if you do *git log*, you will only see this. Second commit is gone.

---

# Branches

A branch in Git is simply a pointer to a specific line of development.

They are:
* Lightweight “labels” that point to commits
* A way to work on features, fixes, or experiments safely
* Separate timelines that won’t affect each other unless merged

When you create a branch, main branch is not affected. You are working on a *copy* of the project and anything you do cannot break the original code. That way multiple people can work on the same project without breaking the full code. One can switch between branches by using `git checkout branchname`. 

At last, when everyone is done, they need to *merge* their branch with the **main** branch. We use *merge* command for that. However, it is possible to have *merge conflicts*. 

Remember that you will use Git in your professional life and this is just a very basic introduction. This information alone is enough for the project.

---

# Github

GitHub is the website where you store and collaborate on Git projects. You **do not** have to use Github to use Git. Git is separate, can work locally. 

However, most of the time people use Github nowadays. It also comes with lots of additional properties. You can have a free static website, it has *Github Actions* for CI/CD, it has *Github Projects* for project management and so on. There is something called *Github Education* for you too.

Github is not the only one, but the most popular. 

In our project, you are going to use Git locally. At the end, you can manually add your project to Github. However, if you want to get more serious, Sign Up, and make an SSH key to be used in your personal machine. That way, every commit you do, you can **push** it to cloud, where everyone can see your changes.
