---
marp: true
theme: default
paginate: true
header: BLML304 - Görsel Programlama
footer: Istanbul Arel Universitesi - Bahar 2023
---

# Görsel Programlama'ya Giriş
---

# İçerik

* Bu derste amacımız Java programlama dilini öğrenmek ve Swing kütüphanesini kullanarak masaüstü uygulamaları geliştirmek.

---

# Giriş

* CRUD: Create, Read, Update, Delete
* Yazılan birçok program aslında CRUD programlarıdır. En az bir tane veritabanı olur, bu veritabanı üzerinde C, R, U ve D işlemleri yapılır.
  * CLI (Command Line Interface)
  * GUI (Graphical User Interface)


---

# CLI (Command Line Interface)

* Bir bilgisayar mühendisi olarak command line (shell, terminal) kullanmaya alışmak gerekiyor. Özellikle Unix kültüründe **shell** çok sık kullanılır.
* Birçok program CRUD programıdır dedik, ancak hepsi değil. Özellikle bazen belirli veriler üzerinde işlemler yapmak isteriz. O zaman gerçekten bir UI ihtiyacımız yoktur.
* Shell/Terminal üzerinde çalışan programlar için CLI deriz.
  * Bunların da tasarımı olabilir elbette. Ancak çoğu zaman sadece argüman alan programlar olarak tasarlanır.

---

# GUI (Graphical User Interface)

* Shell/Terminal üzerinde çalışmayan programlar GUI programlarıdır.
  * Notepad, Paint, vb. gibi. 
* Bunlarla ilgili detaylı bilgiyi Vize sonrası bölümlerde konuşacağız. 

---

# Masaüstü uygulamaları

* Masaüstü uygulamaları günümüzde eskisi kadar kullanılmamaktadır.
* Artık birçok program web uygulaması haline gelmiş ve tarayıcı üstünde çalışmaktadır.
  * Hatta tarayıcı üstünde çalışmayan programları bile yine aynı dilleri kullanarak **native** bir uygulama gibi kullanabiliriz.
  * Visual Studio Code.
* Standard C#'dır. Windows en yaygın işletim sistemi olduğu için C# öğrenmek o açıdan daha yararlı olabilir.
  * 2 yıllık programlama bölümlerinde öğretilir.

---

# Neden Java?

* Java, back-end alanında dünyada en yaygın dildir.
  * Spring Boot
* Aynı zamanda sürekli geliştirilen, profesyonel alanda kullanımı yüksek ve iş bulma konusunda da size yardımcı edecek bir dildir.
* Ek olarak, programlama kültürünü geliştirmek ve düzenli programlama yapmak açısından da iyidir.
* Nesne tabanlı programlamayı en etkili şekilde kullanmak için Java dili uygundur.
* Multi-platform

---

# Java ve Masaüstü uygulamaları

* Java ile masaüstü uygulamaları yapmanın iki yolu var.
  * JavaFX ve Swing
* JavaFX, Swing'e nazaran daha kapsamlıdır ve daha çok şey yapılabilir. Ancak Swing'e göre öğrenmesi daha zordur.
* Swing, yapılacak masaüstü uygulamaları için yeterli olanağı sağlar, fazlasına çok ihtiyaç yok.

---

# Alternatifler

* Birçok dili kullanarak masaüstü uygulamaları yapabilirsiniz.
* Örneğin **Electron** kullanarak, JS, HTML ve CSS yardımıyla masaüstü uygulaması yapabilirsiniz.
* Python dili seviyorsanız, **Qt** ya da **Tkinter** kullanarak masaüstü uygulamaları yapabilirsiniz.
* Yine keza C++ seviyorsanız, yine **Qt** ya da **Win32** kütüphaneleri kullanılabilir.
* MacOS için ise Objective C ve Swift uygun olacaktır.

---

# Web arayüzü

* Bir diğer alternatif ise web arayüzüdür.
* Web uygulamaları artık standard hale geldiği için, basit HTML, CSS ve JS bilmek önemli hale gelmiştir. Bunlarda uzmanlaşmaya gerek yok.
  * Eğer Front-End alanında ilerlemek istiyorsanız uzmanlaşmanız gerekir.
* Ancak basit bir uygulamaya görsellik eklemek için en kolay yöntem web arayüzüdür.
  * Elbette bunun için ya bir web programlama dili (PHP) ya da bir web framework gerekir.

---

# Web arayüzü

* Multi-platform olması büyük bir avantajdır.
  * Yaptığınız programa ister PC, ister tablet, ister cep telefonundan ulaşılabilir.
  * Güncelleme şansı çok daha yüksektir.
  * Güvenlik açısından daha kuvvetlidir.
  
---

# Yerel uygulamalar

* Elbette yerel uygulamaların da yerine göre daha çok avantajı olacaktır.
    * Donanıma tam hükmetmeye yardımcı olur. (GPS, Kamera, vb.)
    * Mobil uygulamalarda yerel olanlar hız açısından daha iyi.
    * Piyasaya sürmek daha kolay.
    * Kullanıcı için daha akıcı bir deneyim.

---

# Front-end & Back-end & Full-stack

* Genellikle web programlarını iki parçaya ayırırız.
  * İş mantığı (Business Logic) _Backend_, arka yüz
  * Sunum (Presentation) _Frontend_, Ön yüz
* Bu yaklaşımın belirli avantajları var.
  * Bir grup yalnızca backend kodlaması yapar.
  * Bir grup yalnızca sunumla ilgilenir.
* Aynı zamanda, backend kodları farklı sunumlar için kullanılabilir.
  * Mobil, web, yerel uygulama

