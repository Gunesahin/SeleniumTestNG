package com.gunesSahin.TestCase12;

public class TestCase2 {
}


/*
Test Case-2:  Ödeme yöntemi seçeneği olmadan siparişi tamamlamaya çalışın
Görev:  Ödeme yöntemi seçeneği olmadan siparişi tamamlamaya çalışan bir kullanıcıyı simüle eder.
Açıklama: Kullanıcı, sepetine bir veya daha fazla ürün ekledikten sonra, ödeme yapmak için checkout sayfasına gider. Ancak, Payment Method kısmında herhangi bir ödeme yöntemi seçeneği görünmez. Kullanıcı, bu durumda siparişi tamamlamaya çalışır.
Ön Koşul: Kullanıcı, sepetine bir veya daha fazla ürün eklemiş olmalıdır.

Test Adımları:
Given: Sepetinizdeki ürünleri kontrol edin ve ana sayfadaki urunlerden herhangi birine tıklayın.
And:  Checkout sayfasında,Your Personal Details, Shipping Address ve Shipping Method kısımlarını doldurun veya varsayılan değerleri bırakın.
When: Payment Method kısmına gelin ve herhangi bir ödeme yöntemi seçeneği olup olmadığını kontrol edin.
And:  Shopping Cart’da Checkout  butonuna tıklayın ve sonucu gözlemleyin.

Then: ödeme işlemini tamamlanamaz.
Beklenen Sonuç: Payment Method kısmında en az bir ödeme yöntemi seçeneği görünmelidir. Countunie butonu , ödeme yöntemi seçilmeden aktif olmamalıdır. Kullanıcı, ödeme yöntemi seçmeden siparişi tamamlamaya çalıştığında, uygun bir hata mesajı almalıdır.
Gerçekleşen Sonuç: Payment Method kısmında herhangi bir ödeme yöntemi seçeneği görünmemektedir. Kullanıcı, ödeme yöntemi seçmeden siparişi tamamlamaya çalıştığında, “Warning: Payment method required!” hata mesajı alamaktadır.
Test Durumu: Failed

=================================================
*/
