# Dosya okuma

Java’da dosya okumak için birden fazla yöntem kullanılabilir. Detaylı bilgi için referans kitaplara bakabilirsiniz. Buradaki örneklerde,

* Files
* BufferedReader
* Scanner

yöntemlerini görelim.

## Files

Bu, tüm satırların hepsini bir `List<String>` yapısına atar ve döner. Burada okuduğunuz metin neyse eğer, o bellekte yer tutar çünkü tüm veri o değişkene yüklenir. Büyük dosyalarda etkili bir yöntem değildir.

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilesExample {
    public static void main(String[] args) {
        try {
            List<String> satirlar = Files.readAllLines(Paths.get("example.txt"));

            for (String satir : satirlar) {
                System.out.println(satir);
            }
        } catch (IOException e) {
            System.out.println("Dosya okunamadı: " + e.getMessage());
        }
    }
}
```

## BufferedReader

Satır satır okuma işlemi yapar. `FileReader` ile birlikte kullanılır.

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                System.out.println(satir);
            }
        } catch (IOException e) {
            System.out.println("Dosya okunamadı: " + e.getMessage());
        }
    }
}
```

Belleğe *buffer* ile okuduğu için, büyük dosyalarla kullanımı uygundur.

---

## Scanner

Esnektir. Satır, kelime bazlı vb. okuma işlemi yapabilir. 

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("example.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı: " + e.getMessage());
        }
    }
}
```

Bunları derste örneğini yaptığımız gibi, Statik metodlar olarak tanımladığınız bir `FileOps` sınıfı tanımlayabilirsiniz. Bu şekilde `FileOps.read()` olarak çağırıp dosya okuyabilir, ve okuduğunuz dosyayla ilgili işlemleri yapabilirsiniz.








