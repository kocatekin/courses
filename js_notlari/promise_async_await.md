Bir programı düz `function()` olarak çağırdığımız zaman, bu senkronize bir sistem oluyor. O fonksiyon bitiyor, ondan sonra devam eden fonksiyon çalıştırılıyor. Ancak, biz aslında asenkron olarak da çalışabiliriz. Bunu yapabilmek için *promise* yapısına bakmamız gerekiyor.

Bir *promise* yarattığımızda, sonuç olarak gelecek değeri bilmiyoruz. Bu bilmediğimiz değer için aslında *promise* kullanıyoruz. Burada *proxy* yerine geçiyor. Bu şekilde, bu asenkron çalışma neyse eğer, onun başarılı ya da başarısız olduğunda ne yapacağımızı kontrol etmemizi sağlıyor.

Bir promise sadece üç state de bulunabilir:
* **pending**: başlama state, operasyon ne başarılı ne başarısız
* **fulfilled**: operasyon başarıyla tamamlandığında
* **rejected**: operasyon başarısız olduğunda

![](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/promises.png)

---

Asenkron olarak bir fonksiyon çalıştırmak istediğimiz zaman, başına *async* ekliyoruz. Bunu yaptığımız zaman, aslında bu fonksiyonun asenkron olarak çalışabileceğini söylüyoruz.

Bunu yaptığımız zaman, bir *Promise* oluşturuluyor. Bu Promise'in *resolve* ya da *reject* olduğunu beklememiz gerekiyor. Bunu *beklemek* için **await** yazmamız gerekiyor. Yani aslında *await* kelimesi, ondan sonra gelen fonksiyonun bitmesini bekliyor. 

```javascript
async function fetchData() {
    const response = await fetch("https://dog.ceo/api/breeds/image/random");
    const data = await response.json();
    console.log(data);
}
```

Örneğin, bunu çalıştırdığımız zaman ilk olarak konsolda bir *promise* oluştuğunu göreceğiz. Ardından, o promise resolve edilecek ve bizim istediğimiz veri ekrana çıktı olarak dönecek.

Şimdi, `fetch()` içine anlamsız bir şey yazıp tekrar çalıştıralım. Bu sefer, yine bir `Promise {<pending>}` göreceğiz ancak bundan sonra bir *error* gelecek.

`Uncaught (in promise) ..` diye başlayan bir hata olacak.

Örneğin, yukarıda doğru olan örnekteki `response.json()` önündeki *await* i kaldıralım. Bu durumda, `console.log(data)` hiç çalışmayacak.

Özetle, bir async fonksiyon çağırdığımız zaman, bir promise oluşturuluyor, bir söz veriliyor. Biz de bu söz bir şekilde tamamlanana kadar beklemek için *await* kullanıyoruz.

Eğer `fetch()` içerisine biz yanlış bir veri yazarsak, error geldiğini söylemiştik. Bu error'u da `try catch` içerisinde yakalayıp ona göre error harici bir mesaj döndürebiliriz. 

Peki, bu süreci biz *async/await* dışında, sadece promiseler kullanarak yapabilir miyiz?

```javascript

const fetchPromise = fetch("https://dog.ceo/api/breeds/image/random");

fetchPromise.then(response => { return response.json();})
.then(data => { console.log(data);})
.catch(error => {
    console.error("something wrong", error);
})
```

Bunu çalıştırdığımızda da aynı işlemin olduğunu görebiliriz.
Async/await yapısı, Promise'lerle çalışmayı kolaylaştırıyor.
