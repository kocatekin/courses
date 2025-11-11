# Polymorphism


* Çok biçimlilik 

* Java'da aynı isme sahip olan bir nesne ya da metot, **farklı davranışlar** gösteriyosa, **polimorfik** bir yapı vardır.
   * Aynı isim, farklı davranış.

* Bir `konuş()` metodu olsun:
   * İnsan -> *merhaba*
   * kopek -> *hav*
   * kedi -> *miyav*

Hepsi aynı komutu kullanmasına rağmen farklı şey yaparlar. Buna **polymorphism** denir.


# Amaç

* Kod tekrarını azaltmak
* Esneklik ve genişletilebilirlik sağlamak
* Ortak bir üst sınıf üzerinden farklı alt sınıfların davranışlarını çalıştırabilmek.



# Türler

## Compile-Time (Method overloading)
* Aynı metot adı, farklı parametreler
## Run-time (Method overriding)
* Subclass, parent'ta olan bir metodu değiştirir.



# Compile Time

* Bir class içerisinde, aynı **isme** sahip, fakat **farklı parametreler** alan birden fazla **metot** varsa olur.
* Compile-time denir çünkü program çalışmadan önce hangisinin çalışacağına *compiler* karar verir.

Bir ödeme sistemi düşünün. Bu ödeme sisteminde (Payment class) aynı isimde metotlar olacak, ancak farklı parametreler alacaklar.

# Kurallar

* Metot isimleri aynı olmalı.
* Parametreler farklı olmalı
* Farklı return tipleri olabilir
* Compiler karar verir.


# PaymentService

```java
class PaymentProcessor {

    // Pay by credit card
    void pay(String cardNumber, double amount) {
        System.out.println("Paid " + amount + " using card: " + cardNumber);
    }

    // Pay by cash
    void pay(double amount) {
        System.out.println("Paid " + amount + " in cash.");
    }

    // Pay with discount code
    void pay(double amount, String discountCode) {
        System.out.println("Paid " + amount + " using discount: " + discountCode);
    }
}
```


```java
public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        processor.pay(100.0);
        processor.pay("1234-5678-9999-0000", 250.0);
        processor.pay(80.0, "SUMMER10");
    }
}
```
* Örneğin burada tüm metotlar `pay()`, ancak hepsi farklı parametreler alıyor.
* Hangisinin çalışacağı parametrelere göre compiler tarafından kararlaştırılıyor.



# Run-time 

* Eğer bir **subclass**, hali hazırda **superclas** (parent) da olan bir metodu, kendine göre değiştiriyorsa olur.
* Java, hangi metodu çalıştıracağına runtime da karar verdiği için böyle denir.

# Kurallar

* Aynı metot adı
* Aynı parametre listesi
* Farklı sınıflarda olmalı (inheritance gerekiyor)
* Metotlar `final`, `static` ya da `private` olamaz.
* Runtime da karar verilir.

Örneğin bir Lojistik sistemi düşünelim.


```java
class Shipment {
    void deliver() {
        System.out.println("Delivering shipment by standard method...");
    }
}

class AirShipment extends Shipment {
    void deliver() {
        System.out.println("Delivering shipment by air — fast delivery!");
    }
}

class SeaShipment extends Shipment {
    void deliver() {
        System.out.println("Delivering shipment by sea — cheaper but slower.");
    }
}
```

Burada, `Shipment` class var. Bu class inherit edilmiş iki farklı class tarafından. Her ikisi de, `deliver()` metodunu kendine göre değiştirmiş.



```java
public class Main {
    public static void main(String[] args) {
        Shipment s1 = new AirShipment();
        Shipment s2 = new SeaShipment();
        Shipment s3 = new Shipment();

        s1.deliver();  // Air version
        s2.deliver();  // Sea version
        s3.deliver();  // Standard version
    }
}
```

* Burada **referans türü** (reference type) `Shipment` ama **obje türü** farklı. Sol taraftaki reference type, sağdaki object type.


# Örnek

```java
class Employee {
    double getBonus() {
        return 5000;
    }
}

class Manager extends Employee {
    double getBonus() {
        return 10000;
    }
}

class Intern extends Employee {
    double getBonus() {
        return 1000;
    }
}

public class Payroll {
    public static void main(String[] args) {
        Employee e1 = new Manager();
        Employee e2 = new Intern();

        System.out.println("Manager bonus: " + e1.getBonus());
        System.out.println("Intern bonus: " + e2.getBonus());
    }
}
```


## Her iki tür aynı anda kullanılabilir
```java
class ReportGenerator {
    // Overloading (compile-time)
    void generate(String fileName) {
        System.out.println("Generating report: " + fileName);
    }

    void generate(String fileName, String format) {
        System.out.println("Generating " + format + " report: " + fileName);
    }
}

class PDFReportGenerator extends ReportGenerator {
    // Overriding (runtime)
    void generate(String fileName, String format) {
        System.out.println("Generating " + fileName + " in secure PDF format.");
    }
}

public class Main {
    public static void main(String[] args) {
        ReportGenerator r1 = new ReportGenerator();
        ReportGenerator r2 = new PDFReportGenerator();

        r1.generate("sales");
        r1.generate("sales", "HTML");     // compile-time (overloaded)
        r2.generate("sales", "PDF");      // runtime (overridden)
    }
}
```


# Özet

 **Override (Runtime)** için:
   * Metot adı, dönüş tipi ve parametre listesi aynı olmalı.
   * `@Override` eklemek iyi bir pratiktir.
   * `static`, `final`, `private` metotlar override edilemez.
   * Erişim belirleyicisi (access modifier) daha dar olamaz.
   * Çalışma anında (runtime) **nesne türüne** göre karar verilir.

**Overload (Compile-time)** için:
   * Aynı metot adı, farklı parametre listesi olmalı.
   * Dönüş tipi değişse de tek başına overloading sayılmaz!

# Örnek 1: Kalıtım ve method overriding

```java
class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound...");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.makeSound(); // Woof! Woof!
        a2.makeSound(); // Meow!
    }
}
```

# Örnek 2: Farklı dillerde selamlama

```java
class Greeter {
    void greet() {
        System.out.println("Hello!");
    }
}

class SpanishGreeter extends Greeter {
    void greet() {
        System.out.println("¡Hola!");
    }
}

class FrenchGreeter extends Greeter {
    void greet() {
        System.out.println("Bonjour!");
    }
}

public class Main {
    public static void main(String[] args) {
        Greeter g1 = new SpanishGreeter();
        Greeter g2 = new FrenchGreeter();

        g1.greet(); // ¡Hola!
        g2.greet(); // Bonjour!
    }
}
```

# Örnek 3: Alan hesaplama
```java
abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double radius;
    Circle(double radius) { this.radius = radius; }
    double area() { return Math.PI * radius * radius; }
}

class Rectangle extends Shape {
    double width, height;
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    double area() { return width * height; }
}

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(4, 6);

        System.out.println("Circle area: " + s1.area());
        System.out.println("Rectangle area: " + s2.area());
    }
}
```

# Örnek 4: Ödeme sistemi (interface)

```java
interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

public class Main {
    public static void main(String[] args) {
        Payment p1 = new CreditCardPayment();
        Payment p2 = new PayPalPayment();

        p1.pay(120.0);
        p2.pay(85.5);
    }
}
```

# Örnek 5: Notification

```java
interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SMSNotifier implements Notifier {
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Notifier[] notifiers = { new EmailNotifier(), new SMSNotifier() };

        for (Notifier n : notifiers) {
            n.send("System update available!");
        }
    }
}
```

