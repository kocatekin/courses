# ENUM


An `enum` is a special type in Java used to define a fixed set of constants. It is short for **enumeration**. 

- Used to improve readability
- Provides **type safety**. This means, you cannot pass in something invalid.


## Basic example

```java
enum Day {
   MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
}

public class EnumBasics {
   public void static main(String[] main) {
      Day today = Day.WEDNESDAY;
      System.out.println("Today is:" + today);
   }
}
```

As we can see in the example, we can reach these values by using the enum name, `Day`. We can create a `Day` object again, by using it like a Class name. 

---

```java
enum Flavor {
    CHOCOLATE, VANILLA, STRAWBERRY, PISTACHIO, MANGO
}

public class IceCreamShop {
    public static void main(String[] args) {
        Flavor myChoice = Flavor.MANGO;

        switch (myChoice) {
            case CHOCOLATE -> System.out.println("You chose chocolate! Classic choice.");
            case VANILLA -> System.out.println("Vanilla – smooth and simple.");
            case STRAWBERRY -> System.out.println("Strawberry – fruity and fresh!");
            case PISTACHIO -> System.out.println("Pistachio – for the adventurous.");
            case MANGO -> System.out.println("Mango – tropical vibes!");
        }
    }
}

```

---


Enums can also have:
- instance variables
- constructors (must be `private`)
- methods

Another example is, we can use Enum with Fields & Constructor. Here, we can see that enums can **store data** for each constant!

```java

enum Difficulty {
   EASY(1), MEDIUM(2), HARD(3);

   private int level;

   Difficulty(int level) {
      this.level = level;
   }

   public int getLevel() {
      return level;
   }
}

public class Game {
   public static void main(String[] args){
      Difficulty diff = Difficulty.HARD;
      System.out.println("Difficulty: " + diff);
      System.out.println("Level: " + diff.getLevel());
   }
}
```

---

```java
enum PizzaSize {
    SMALL(8), MEDIUM(10), LARGE(12), EXTRA_LARGE(15);

    private final int price;

    PizzaSize(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

public class PizzaOrder {
    public static void main(String[] args) {
        PizzaSize size = PizzaSize.LARGE;
        System.out.println("You ordered a " + size + " pizza. Price: $" + size.getPrice());
    }
}
```

---

Just like we add integers, we can add Strings to our enums.

```java
enum Superhero {
    BATMAN("Martial arts, gadgets"),
    SUPERMAN("Super strength, flight"),
    FLASH("Super speed"),
    IRONMAN("Genius, powered armor");

    private final String powers;

    Superhero(String powers) {
        this.powers = powers;
    }

    public void showPowers() {
        System.out.println(this.name() + " has: " + powers);
    }
}

public class ComicWorld {
    public static void main(String[] args) {
        for (Superhero hero : Superhero.values()) {
            hero.showPowers();
        }
    }
}
```

In this example, we see that there are specific methods for Enums. 

```
values() - for(Day d : Day.values()) - Lists all constants
valueOf(String) - Day.valueOf("MONDAY") - returns Day.MONDAY
name() - Day.MONDAY.name() - "MONDAY"
```

---

**Mini Example**

Let's create an enum `MovieGenre` with at least 5 genres, where each has a 
- short description
- a recommended movie title

Later, we will write a program which lets the user choose a genre, and print the description and recommendation.


First, we need to come up with the genres. Five genres can be : action, scifi, comedy, drama and horror.

For each, we need a description and we need a movie example. Let's use LLM's for this.

```
I want you to generate an explanation and an example movie for the following 5 genres: action, comedy, drama, horror and scifi. use the following format:
- explanation, example
```

---

```java
enum MovieGenre {
    ACTION("Fast-paced scenes, explosions, and high stakes.", "Mad Max: Fury Road"),
    COMEDY("Light-hearted and humorous storytelling.", "The Hangover"),
    DRAMA("Deep emotional themes and character development.", "The Shawshank Redemption"),
    HORROR("Scary, tense, and thrilling.", "The Conjuring"),
    SCI_FI("Futuristic, imaginative, and often with advanced technology.", "Interstellar");

    private final String description;
    private final String recommendation;

    MovieGenre(String description, String recommendation) {
        this.description = description;
        this.recommendation = recommendation;
    }

    public String getDescription() {
        return description;
    }

    public String getRecommendation() {
        return recommendation;
    }
}
```

```java
import java.util.Scanner;

public class MoviePicker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🎬 Available Genres:");
        for (MovieGenre genre : MovieGenre.values()) {
            System.out.println("- " + genre.name());
        }

        System.out.print("\nEnter a genre: ");
        String userChoice = sc.nextLine().toUpperCase();

        try {
            MovieGenre chosen = MovieGenre.valueOf(userChoice);
            System.out.println("\nYou chose: " + chosen.name());
            System.out.println("Description: " + chosen.getDescription());
            System.out.println("Recommended Movie: " + chosen.getRecommendation());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Invalid genre. Please choose from the list.");
        }

        sc.close();
    }
}
```



