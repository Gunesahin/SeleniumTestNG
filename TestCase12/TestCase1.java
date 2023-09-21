package com.gunesSahin.TestCase12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://masterbranchacademy.com");
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        driver.close();
    }
}
/*
    Test Case-1: Kullanıcı, uygulamada bir ürün seçer ve ödeme sayfasına yönlendirilir.

        Given: Kullanıcı, uygulamanın ana sayfasına erişir.

        And: bir ürün seçer ve “Sepete Ekle” düğmesine tıklar.

        And: Checkout butonuna tıklar.

        And: Guest Radio button'i secer

        And: Contiune butonuna girisi'ne  tıklar

        And: Your Personal Details kismini doldurur.

        When: “Sepetim” sayfasına yönlendirilir ve “Ödeme Yap” düğmesine tıklar.

        And: ödeme sayfasına yönlendirilir ve farklı ödeme seçenekleri arasından seçim yapar.

        And:  Eğer hata yaparsa, kullanıcıya ne yapması gerektiği açıklanmalı ve "Warning: No Payment options are available. Please contact us for assistance!" hatasi dogrulanmalidir.

        And: Hata yoksa Contiunue butonuna tiklar.

        Then: ödeme işlemini tamamlar.
        */