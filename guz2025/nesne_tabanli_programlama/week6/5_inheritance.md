# Kalıtım

* Kalıtım, bir sınıfın başka bir sınıfı yeniden kullanmasına, genişletmesine veya özelleştirmesine olanak tanır.

* *is-a* ilişkisini uygular.
   * üst sınıf (parent / superclass)
   * alt sınıf (child / subclass)

Buradaki amaç tekrarları önlemek, yeniden kullanılabilirliği artırmak ve hiyerarşileri ifade etmektir.


```java
class Superclass {
    // fields and methods
}

class Subclass extends Superclass {
    // extra fields and methods
}
```

Subclass oluşturmak ve kalıtım sağlamak için **extends** keyword'unu kullanıyoruz. 

# Örnek

```java
class Student {
    String name;
    int id;

    void attendClass() {
        System.out.println(name + " attends class.");
    }
}

class GraduateStudent extends Student {
    String thesisTopic;

    void submitThesis() {
        System.out.println(name + " submits thesis on " + thesisTopic);
    }
}
```

Burada `Student` sınıfımız var. `GraduateStudent` ise **extends** anahtar sözcüğüyle `Student` sınıfını kalıtım alır.

Bu şu anlama gelir: `GraduateStudent`, `Student` sınıfındaki her özelliğe ve metoda sahiptir.

Ayrıca yeni özellikler de ekleyebilir. Örneğin `submitThesis()` sadece bu sınıfta vardır.


## `super` ile Üst Sınıf Metotlarına Erişim

`super` anahtar kelimesi, alt sınıfın:

1. Üst sınıfın yapıcısını (constructor)
2. Üst sınıfın metotlarını (özellikle override edilmiş olanları)

çağrılmasına olanak tanır.

```java
class User {
    User() {
        System.out.println("User created.");
    }

    void showRole() {
        System.out.println("Generic user.");
    }
}

class AdminUser extends User {
    AdminUser() {
        super();
        System.out.println("Admin user created.");
    }

    @Override
    void showRole() {
        super.showRole();
        System.out.println("This user has admin privileges.");
    }
}
```

* Burada `AdminUser` sınıfı `User` sınıfını genişletir.
* `super()` çağrısı, User yapıcısını (constructor) çalıştırır.
* `super.showRole()` ise üst sınıftaki metodu çağırır.


---

# Method overriding

Alt sınıf, üst sınıfın metodunu kendi versiyonuyla değiştirebilir.

```java
class Vehicle {
    void start() { System.out.println("Vehicle starting..."); }
}

class ElectricTruck extends Vehicle {
    @Override
    void start() { System.out.println("Electric truck powering up silently."); }
}
```


Bu örnekte `ElectricTruck`, `Vehicle`’dan kalıtım alıyor fakat `start()` metodunu yeniden yazıyor.

**Kurallar:**

* Aynı imzaya (signature) sahip olmalı
* Görünürlüğü azaltmamalı (ör. public → private olamaz)
* `@Override` kullanılmalı (okunabilirliği artırır)

---

# Constructor chaining

Constructor, kalıtıma dahil değildir. Eğer superclass'ın constructor'ını çağırmak istersek, `super()` ile çağırmalıyız.

```java
class Employee {
    Employee(String name) {
        System.out.println("Employee: " + name);
    }
}

class Manager extends Employee {
    Manager(String name) {
        super(name);
        System.out.println("Manager: " + name);
    }
}
```

Burada `Manager` nesnesi oluşturulurken önce `Employee`’ın yapıcısı çalışır.

---

# Kalıtım türleri

Java’da üç tür kalıtım vardır:

* Tekli kalıtım (Single)
* Çok seviyeli kalıtım (Multilevel)
* Hiyerarşik kalıtım (Hierarchical)

**Çoklu kalıtım** Java’da desteklenmez — bunun yerine arayüzler (**interface**) kullanılır.

## `instanceOf` operatörü

Bir nesnenin hangi türden olduğunu kontrol eder.

```java
GraduateStudent gs = new GraduateStudent();
System.out.println(gs instanceof Student);   // true
System.out.println(gs instanceof Object);    // true
```

**ek bilgi:**

Gerçek hayatta, özellikle büyük sistemlerde derin kalıtım zincirleri tercih edilmez.
Çünkü bu sıkı bağlılık (tight coupling) yaratır: üst sınıftaki bir değişiklik alt sınıfları bozabilir.

Bu nedenle, çoğu durumda:

**Kalıtımdan ziyade bileşimi (composition) tercih edin.**

Yani:
* is-a ilişkisi varsa kalıtım (inheritance)
* has-a ilişkisi varsa bileşim (composition) kullanın.

Kalıtım yalnızca şu durumlarda uygundr:
* Alt sınıf gerçekten üst sınıfın *özel* bir haliyse
* Polimorfizm gerekiyorsa
* Hiyerarşik yapılarda (GUI, vb.)



