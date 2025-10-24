# Static

Java'da `static` kelimesi, bir değişkenin ya da metodun bir **sınıfa** ait olduğunu belirtir. **Nesneye** değil, **sınıfa** aittir.

Bu sayede, o sınıfın tüm objeleri, aynı `static` değişkenini paylaşır.

## Örnek: Student

```java
public class Student {
    public static int ogrenciSayisi = 0; // sınıfa ait değişken

    private String isim;

    public Student(String isim) {
        this.isim = isim;
        ogrenciSayisi += 1; // her yeni öğrenci oluşturulunca 1 artırılır
    }
}
```

Bu örnekte, `ogrenciSayisi` değişkenine erişmek isterseniz eğer o zaman Main içinde bu veriye erişim için bir obje oluşturmak gerekmiyor. 

```java
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Ali");
        Student s2 = new Student("Ayşe");
        Student s3 = new Student("Can");

        System.out.println(Student.ogrenciSayisi); // 3
    }
}
```

Elbette encapsulation ilkesine uygun olarak, tüm değişkenlerimiz `private` olmalı. Bu değişkeni de `private` olarak değiştirdiğimizde, ona erişim için bir *getter* yazmak gerekiyor. Ancak eğer bunu normal bir getter metodu olarak tanımlarsak, o objeye ait olur. O yüzden onu da `static` kelimesiyle tanımlamak gerekiyor.

```java
public class Student {
    private static int ogrenciSayisi = 0;
    private String isim;

    public Student(String isim) {
        this.isim = isim;
        ogrenciSayisi += 1;
    }

    public static int getOgrenciSayisi() {
        return ogrenciSayisi;
    }
}
```

Erişmek için;
```java
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Ali");
        Student s2 = new Student("Ayşe");
        Student s3 = new Student("Can");

        System.out.println(Student.getOgrenciSayisi()); // 3
    }
}
```



