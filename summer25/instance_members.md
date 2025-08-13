# Instance members and class members


Instance members belong to a **specific** object. Each object has its own copy. These are declared **without** writing `static`. *Class members* on the other hand, they belong to the **class** itself. This is **shared** among all objects of the class. They are declared **with** `static`.

Let's use some examples to visualize this:

```java
import java.util.Scanner;

class Player {
    String name;           // instance member
    int personalScore = 0; // instance member

    static int totalScore = 0; // class member

    Player(String name) {
        this.name = name;
    }

    void scorePoints(int points) {
        personalScore += points;
        totalScore += points;
    }

    void showScore() {
        System.out.println(name + "'s Score: " + personalScore);
    }

    static void showTotalScore() {
        System.out.println("Total Score (All Players): " + totalScore);
    }
}

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Player p1 = new Player("Alice");
        Player p2 = new Player("Bob");

        System.out.print("Points for Alice: ");
        int pointsAlice = sc.nextInt();
        p1.scorePoints(pointsAlice);

        System.out.print("Points for Bob: ");
        int pointsBob = sc.nextInt();
        p2.scorePoints(pointsBob);

        p1.showScore();
        p2.showScore();
        Player.showTotalScore();

        sc.close();
    }
}
```

Here, we create two players. We assign points to both players. Later, we can see a score for each (instance), and we can see the score of `static` which does not belong to a specific instance - but to the class.

---

Another example is going to be a Library example. Here, every `LibraryUser` will borrow a book. They will have their own borrowed book count, but we also need the **total** number of borrowed books. We can use a `static` variable for that.

```java
import java.util.Scanner;

class LibraryUser {
    String name;                 // instance member
    int booksBorrowed = 0;        // instance member

    static int totalBooksBorrowed = 0; // class member

    LibraryUser(String name) {
        this.name = name;
    }

    void borrowBook(int count) {
        booksBorrowed += count;
        totalBooksBorrowed += count;
    }

    void showUserStats() {
        System.out.println(name + " borrowed " + booksBorrowed + " books.");
    }

    static void showLibraryStats() {
        System.out.println("Total books borrowed by everyone: " + totalBooksBorrowed);
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LibraryUser u1 = new LibraryUser("Sarah");
        LibraryUser u2 = new LibraryUser("Tom");

        System.out.print("How many books did Sarah borrow? ");
        u1.borrowBook(sc.nextInt());

        System.out.print("How many books did Tom borrow? ");
        u2.borrowBook(sc.nextInt());

        u1.showUserStats();
        u2.showUserStats();
        LibraryUser.showLibraryStats();

        sc.close();
    }
}
```

In this example I want you to be careful with one thing. Here, `showLibraryStats` itself is `static`. That is why, we can call it in Main in the following way: `LibraryUser.showLibraryStats()`. As you can see here, we use the *class* name. Because that method is a `static` method. If we make it a normal method, that line would not work. We would call it as `u1.showLibraryStats()`.

---

Another good example is in a cafeteria setting. Here, we will have multiple cashiers, they will sell individual items and we are going to be able to get the whole number of sales! Let's write the code yourself this time. Also, at the end i want to see the total number of users too!




