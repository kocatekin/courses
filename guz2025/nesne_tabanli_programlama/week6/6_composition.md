# Composition

## Giriş

Önceki derslerde kalıtımın bazen şu problemlere yol açabileceğini gördük:

* Sınıflar arası sıkı bağlılık (tight coupling)
* İstenmeyen davranışların alt sınıflara taşınması
* Test ve bakım zorluğu


Bileşim (**Composition**) bu sorunları çözer. Bir sınıfın başka bir sınıfı içermesini (*has-a*) sağlar.

---

## Nedir?

*has-a* ilişkisini modeller. Yani, bir sınıf başka bir sınıfı **alan (field)** olarak tutar. 

Eğer kapsayıcı nesne yok edilirse, içindeki parça genellikle onunla birlikte yok olur.

```java
class Course {
    String title;
    Course(String title) { this.title = title; }
}

class Teacher {
    String name;
    Course course;

    Teacher(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    void teach() {
        System.out.println(name + " is teaching " + course.title);
    }
}
```

Örneğin burada `Teacher` sınıfı, `Course`'u içerir. Yani:

* teacher **is-a** course değil;
* teacher **has-a** course'tur.

## Kıyas

| Özellik          | Kalıtım (`is-a`)            | Bileşim (`has-a`)                  |
| ---------------- | --------------------------- | ---------------------------------- |
| İlişki türü      | Hiyerarşik                  | İçerme (containment)               |
| Bağlılık         | Sıkı (tight)                | Gevşek (loose)                     |
| Esneklik         | Derleme zamanında sabit     | Çalışma zamanında değiştirilebilir |
| Yeniden kullanım | Üst sınıf kodunu genişletir | İçerilen nesneye delege eder       |
| Anahtar kelime   | `extends`                   | Alan (field) + metod çağrısı       |


---

## Kalıtımın yanlış kullanımı

```java
class GPSModule {
    void track() { System.out.println("Tracking..."); }
}

class Truck extends GPSModule { } // “Truck is a GPSModule”? Hayır!
```

Örneğin bu yanlış bir kullanım. Çünkü *is-a* ilişkisi yok. Ancak *has-a* ilişkisi var.

```java
class Truck {
    private GPSModule gps;

    Truck(GPSModule gps) {
        this.gps = gps;
    }

    void deliver() {
        gps.track();
        System.out.println("Delivering cargo...");
    }
}
```

bu doğru bir kullanım.


---

## Zayıf bileşim (aggregation)

Bazı durumlarda, parça (örneğin çalışanlar) bütünden bağımsız olarak da var olabilir.

```java
class Employee {
    String name;
    Employee(String name) { this.name = name; }
}

class Department {
    String name;
    List<Employee> employees = new ArrayList<>();

    Department(String name) { this.name = name; }

    void addEmployee(Employee e) { employees.add(e); }

    void listEmployees() {
        System.out.println("Department: " + name);
        for (Employee e : employees)
            System.out.println(" - " + e.name);
    }
}
```

Örneğin burada Department silinse bile Employee nesneleri yaşamaya devam eder. Buna **aggregation** denir.

---

## Composition, Delegation

Bazen bileşimle birlikte **delegation** (yetkilendirme) kullanılır. Yani bir nesne, işi başka bir nesneye yaptırır (delege eder).

```java
class Logger {
    void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}

class PaymentService {
    private Logger logger = new Logger();

    void processPayment() {
        logger.log("Payment started");
        // logic...
        logger.log("Payment completed");
    }
}
```

Burada, `PaymentService`, `Logger` sınıfını içeriyor. Yani `log()` işini `Logger`a delege ediyor.



