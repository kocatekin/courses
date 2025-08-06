# Reading files


When we are reading files in Java, there are several ways to do it. 

For example in Python, we read the whole file into a list
```python
f = open("text","r")
lines = f.readlines()
```

Here, `lines` variable have the **whole** text. 

However, if the file is *large*, it would be a problem. In Java, we can read a file just like we do in Python, and we can also read it step by step.

## Whole File

This here is ideal for small to medium size files.

```java
public class WriteWholeFile {
    public static void main(String[] args) throws Exception {
        List<String> lines = List.of("Line 1", "Line 2", "Line 3");
        Files.write(Paths.get("wholefile.txt"), lines, StandardOpenOption.CREATE);
    }
}
```

To read:

```java
public class ReadWholeFile {
    public static void main(String[] args) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("wholefile.txt"));
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
``` 

Please be aware of the `throws Exception`. If you do not put this or use a `try catch` block, the program will not compile. Because the compiler has no idea what to do if `wholefile.txt` is not there! That is why we need to catch it, or throw an exception so that we understand what is going on.

Right click on the project name, add a text file with this same name. You are going to be able to read and write to this.


---

## Line by Line

For **large** files, this is a better approach. Otherwise, the whole text will be loaded into RAM.

We use `FileWriter` and `BufferedReader`. Keep in mind, there are several more ways and for them, refer to the textbook.

```java
public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("streamfile.txt"))) {
            writer.write("Line A");
            writer.newLine();
            writer.write("Line B");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```

**Reading:**

```java
public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("streamfile.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```


For simple stuff, the first example is going to be enough. For now, we can do our examples with it.

---

Let's do a basic example. 
We ask user for personal information and save it!


For that, we are going to have a `Main` class, a `Person` class and a `FileOps` class.

`FileOps.java`
```java
package ooppractice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileOps {
	
	String filename;
	
	FileOps(){
		//empty constructor
	}
	
	public void writeFile(String filename, List<String> lines) {
		try {
			Files.write(Paths.get(filename), lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> readFile(String filename){
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get(filename));
			return lines;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
}
```

`Person.java`
```java
public class Person {
	private String name;
	private String surname;
	private int age;
	
	Person() {
		this.name = null;
		this.surname = null;
		this.age = 0;
	}
	
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
```

`Main.java`
```java
public class Main {

	public static void main(String[] args) throws Exception {
		
		Person p1 = new Person();
		Scanner sc = new Scanner(System.in);
		System.out.println("Create a person and save to file!");
		
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		p1.setName(name);
		
		System.out.println("Enter surname: ");
		String surname = sc.nextLine();
		p1.setSurname(surname);
		
		System.out.println("Enter age: ");
		int age = sc.nextInt();
		p1.setAge(age);
		
		FileOps f = new FileOps();
		
		List<String> lines = new ArrayList<>();
		lines.add(p1.getName());
		lines.add(p1.getSurname());
		lines.add(Integer.toString(p1.getAge()));
		
		f.writeFile("wholefile.txt", lines);
		f.readFile("wholefile.txt");				
}
}
```

Here, we did not write it as csv, but wrote it as a file. Every line in the `lines` is saved as a new line.

The reason for that is in the `FileOps` we use `Files.write(Paths.get(filename), lines, StandardOpenOption.CREATE);`. Here, we use `lines` directly, so it automatically does it. Instead, we can change it to:

```java
String content = "name, surname, age";
Files.write(Paths.get(filename), content.getBytes());
```

Here, we see that if we give `getBytes()` it works. So, instead of this -- we can change our code to this:

`Files.write(Paths.get(filename), String.join(", ", lines).getBytes(), ..)`


---

This example is a basic example and do not strictly follow OOP principles. Now, we can make a workout tracker using this approach. This time, we want it to follow good OOP principles.

Let's start thinking from objects.

- We have a Workout. It will have a date and a name. For example *Upper body*. It will also have the *logs* for that workout.
- We will have a *log*, indicating the movement (squat, etc) and sets and reps.
   - We can choose to write every set separately.


For simplicity, we are only going to implement *adding*. We will also add these to a csv file instead of a database. However, the **business logic** is the same. It doesn't change. 

First, we are going to create a Workout. That workout will get the date automatically, and we will put the name in it.

Later, we are going to *add* logs to our workout. Each log will have a;
- movement
- reps
- weight (opt)

This log will be added to *that* specific workout.

Apparently, we also need something else where we store our **workouts**. Imagine that you want to list all the workouts you do, they must be somewhere. For that we will add another class called `WorkoutManager` etc. The name is not important. 

So, our aim is this:
- We create a workout
- We add our logs there

That's it. In the homepage, we also will have the option to see all our workouts, and get into them too.

This is hard to do in CLI, but try to imagine. Also, we can start creating basic GUI for such stuff later.

---




