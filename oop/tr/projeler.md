# OOP Proje Örnekleri (Türkçe)

Bu belge, Nesne Yönelimli Programlama (Object-Oriented Programming) dersi için **hazır proje fikirleri** sunar. Her proje, ne yapmanız gerektiğini açıkça anlamanıza yardımcı olacak şekilde yapılandırılmıştır.

Bu projelerden herhangi birini seçebilir veya kendi projenizi oluştururken ilham alabilirsiniz.

---

# 📘 Her Projede Bulunan Bölümler

Her proje aşağıdaki bölümlere sahiptir:

* **Açıklama**
* **Gerekli Sınıflar**
* **OOP Gereksinimleri**
* **Minimum Özellikler**
* **Opsiyonel Gelişmiş Özellikler**

---

# ⭐ Proje Örneği 1: Kütüphane Yönetim Sistemi

### **Açıklama**

Kitapların ve üyelerin yönetildiği bir sistemdir. Kullanıcılar kitap ödünç alabilir, iade edebilir ve sistem kitapların durumunu takip eder.

### **Gerekli Sınıflar**

* Book
* Member
* StudentMember (Member'dan kalıtım alır)
* Loan
* LibraryManager

### **OOP Gereksinimleri**

* Kapsülleme: private değişkenler, getter/setter
* Kalıtım: Member → StudentMember
* Polimorfizm: `calculateFee()` metodu override edilir
* Arayüz: `Searchable`

### **Minimum Özellikler**

* Kitap ekleme/çıkarma
* Kitap arama
* Kitap ödünç alma/iade
* Müsaitlik durumu gösterme

### **Opsiyonel Özellikler**

* Dosya kaydı
* Gecikme ücreti hesaplama
* Kütüphaneci giriş sistemi

---

# ⭐ Proje Örneği 2: Online Yemek Sipariş Sistemi

### **Açıklama**

Kullanıcıların menülere göz attığı, sepete ürün eklediği ve sipariş verebildiği bir sistem.

### **Gerekli Sınıflar**

* MenuItem
* User
* Customer (User'dan türetilir)
* Order
* Restaurant

### **OOP Gereksinimleri**

* Kalıtım: User → Customer
* Kapsülleme: adres, telefon bilgileri
* Polimorfizm: farklı ödeme tipleri
* Arayüz: `Orderable`

### **Minimum Özellikler**

* Menü görüntüleme
* Sepete ürün ekleme
* Sipariş oluşturma
* Sipariş özeti gösterme

### **Opsiyonel Özellikler**

* Farklı ödeme yöntemleri
* Restoran puanlama
* Kupon/indirim sistemi

---

# ⭐ Proje Örneği 3: Öğrenci Ders Kayıt Sistemi

### **Açıklama**

Öğrencilerin derslere kayıt olup mevcut derslerini takip ettiği bir sistem.

### **Gerekli Sınıflar**

* Student
* Course
* Instructor
* Registration
* CourseCatalog

### **OOP Gereksinimleri**

* Kalıtım: Student → GraduateStudent
* Polimorfizm: `calculateTuition()` override edilir
* Arayüz: `Registrable`

### **Minimum Özellikler**

* Ders ekleme/çıkarma
* Ders listesi görüntüleme
* Derse kayıt olma
* Aynı derse tekrar kayıt engeli

### **Opsiyonel Özellikler**

* GPA hesaplama
* Eğitmen atama
* Saat çakışmasını engelleme

---

# ⭐ Proje Örneği 4: Otel Rezervasyon Sistemi

### **Açıklama**

Farklı oda tiplerine rezervasyon yapılabilen bir sistem.

### **Gerekli Sınıflar**

* Room
* Reservation
* Customer
* Payment
* Hotel

### **OOP Gereksinimleri**

* Kalıtım: Room → DeluxeRoom / StandardRoom
* Polimorfizm: oda fiyatı hesaplaması
* Arayüz: `Reservable`

### **Minimum Özellikler**

* Boş odaları arama
* Oda rezervasyonu
* Rezervasyon iptali
* Detaylı rezervasyon gösterme

### **Opsiyonel Özellikler**

* Sezonluk fiyatlandırma
* Oda servisi talebi
* Sadakat puanı

---

# ⭐ Proje Örneği 5: Araç Kiralama Sistemi

### **Açıklama**

Araçların kiralanabildiği ve iade edildiği bir sistem.

### **Gerekli Sınıflar**

* Car
* Rental
* Customer
* Payment
* CarInventory

### **OOP Gereksinimleri**

* Kalıtım: Car → ElectricCar / GasCar
* Polimorfizm: `calculateRentalFee()` override
* Arayüz: `Rentable`

### **Minimum Özellikler**

* Araç ekleme/çıkarma
* Kiralama
* Araç iadesi
* Müsait araçları listeleme

### **Opsiyonel Özellikler**

* Yakıt tüketimi hesaplama
* Hasar raporu
* Filtreleme (marka, yakıt türü)

---

# ⭐ Proje Örneği 6: Bankacılık Sistemi

### **Açıklama**

Kullanıcıların temel bankacılık işlemlerini gerçekleştirebildiği bir sistem.

### **Gerekli Sınıflar**

* Account
* SavingsAccount
* CheckingAccount
* Transaction
* Bank

### **OOP Gereksinimleri**

* Polimorfizm: `withdraw()` davranışları
* Kapsülleme: bakiye koruma
* Arayüz: `Transferable`

### **Minimum Özellikler**

* Para yatırma
* Para çekme
* Havale/transfer
* İşlem geçmişi görüntüleme

### **Opsiyonel Özellikler**

* Aylık rapor
* Faiz hesaplama
* Kredi sistemi

---

# ⭐ Proje Örneği 7: Envanter Yönetim Sistemi

### **Açıklama**

Ürünlerin, stok seviyelerinin ve tedarikçilerin takip edildiği bir sistem.

### **Gerekli Sınıflar**

* Product
* Supplier
* Inventory
* Order
* StockManager

### **OOP Gereksinimleri**

* Kapsülleme: ürün bilgileri
* Kalıtım: Product → PerishableProduct
* Arayüz: `Storable`

### **Minimum Özellikler**

* Ürün ekleme/çıkarma
* Stok güncelleme
* Ürün arama
* Az stok uyarısı

### **Opsiyonel Özellikler**

* Otomatik stok yenileme
* Fiyat analizleri
* Dosya kaydı

---

# ⭐ Proje Örneği 8: Quiz / Sınav Sistemi

### **Açıklama**

Öğrencilerin quiz çözdüğü ve puan aldığı bir sistem.

### **Gerekli Sınıflar**

* Question
* MultipleChoiceQuestion
* TrueFalseQuestion
* Quiz
* Student

### **OOP Gereksinimleri**

* Kalıtım: Question hiyerarşisi
* Polimorfizm: `checkAnswer()` override
* Arayüz: `Gradable`

### **Minimum Özellikler**

* Soru yükleme
* Quiz başlatma
* Puan hesaplama
* Sonuç gösterme

### **Opsiyonel Özellikler**

* Sayaç (timer)
* Soruları karıştırma
* Zorluk seviyeleri

---

# ⭐ Proje Örneği 9: Görev & Proje Yönetim Aracı

### **Açıklama**

Görev oluşturup projelere atayabileceğiniz basit bir yönetim sistemi.

### **Gerekli Sınıflar**

* Task
* User
* Project
* Deadline
* Notification

### **OOP Gereksinimleri**

* Kapsülleme: deadline, öncelik bilgileri
* Kalıtım: Task → TimedTask
* Arayüz: `Completable`

### **Minimum Özellikler**

* Görev oluşturma
* Görevi projeye atama
* Görev tamamlama
* Yaklaşan görevleri listeleme

### **Opsiyonel Özellikler**

* Öncelik seviyesi
* Hatırlatma sistemi
* Dosyaya aktarma

---

# ⭐ Proje Örneği 10: Sinema Bilet Rezervasyon Sistemi

### **Açıklama**

Kullanıcıların film seçip koltuk ayırdığı bir sistem.

### **Gerekli Sınıflar**

* Movie
* ShowTime
* Seat
* Booking
* Customer

### **OOP Gereksinimleri**

* Kalıtım: Movie → 3D / 2D Movie
* Polimorfizm: fiyatlandırma farkları
* Arayüz: `Bookable`

### **Minimum Özellikler**

* Film listesi görüntüleme
* Seans seçme
* Koltuk seçimi
* Rezervasyon onayı

### **Opsiyonel Özellikler**

* Koltuk haritası gösterimi
* İndirim seçenekleri
* Rezervasyon geçmişi

