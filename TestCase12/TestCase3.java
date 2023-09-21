package com.gunesSahin.TestCase12;

public class TestCase3 {

}
/*
Test Case-3: Sayfayı yenileyerek ödeme yöntemi seçeneğini görüntülemeye çalışın
Görev:  Ödeme yöntemi seçeneği olmadığını fark eden bir kullanıcının, sayfayı yenileyerek bu sorunu çözmeye çalışmasını simüle eder.
Açıklama:  Kullanıcı, sepetine bir veya daha fazla ürün ekledikten sonra, ödeme yapmak için checkout sayfasına gider. Ancak, Payment Method kısmında herhangi bir ödeme yöntemi seçeneği görünmez. Kullanıcı, bu durumda sayfayı yenileyerek ödeme yöntemi seçeneğini görüntülemeye çalışır.
Ön Koşul: Kullanıcı, sepetine bir veya daha fazla ürün eklemiş olmalıdır.

Test Adımları:
Given: Sepetinizdeki ürünleri kontrol edin ve  Checkout butonuna tıklayın.
And:  Checkout sayfasında, New Customer kısmını işaretleyip Continue butonuna tıklayın

And:  Checkout sayfasında, Your Personal Details, Shipping Address ve Shipping Method kısımlarını doldurun veya varsayılan değerleri bırakın.
When: Payment Method kısmına gelin ve herhangi bir ödeme yöntemi seçeneği olup olmadığını kontrol edin.
And: Tarayıcınızın yenileme butonuna tıklayın veya F5 tuşuna basın ve sayfanın yenilenmesini bekleyin.
And: Payment Method kısmına tekrar bakın ve ödeme yöntemi seçeneği olup olmadığını kontrol edin.

Then: ödeme işlemini tamamlanamaz.
Beklenen Sonuç: Payment Method kısmında en az bir ödeme yöntemi seçeneği görünmelidir. Kullanıcı, ödeme yöntemini seçebilmeli ve siparişi tamamlayabilmelidir.
Gerçekleşen Sonuç: Payment Method kısmında herhangi bir ödeme yöntemi seçeneği görünmemektedir. Sayfayı yenilemek, sorunu çözmemektedir.
Test Durumu: Failed
 */
