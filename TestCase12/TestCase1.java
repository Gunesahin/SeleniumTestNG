package com.gunesSahin.TestCase12;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1 {
    WebDriver driver;

    @BeforeMethod

    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciKapat() {
        driver.quit();
    }

    @Test
    public void testPayment() throws InterruptedException {

        // Uygulamanın ana sayfasına git
        WebElement product = driver.findElement(By.xpath("//*[@id='logo']/h1/a"));

        // Bir ürün seç
        WebElement add = driver.findElement(By.xpath("(//h4/a)[1]"));
        add.click();

        // Sepete ekle butonuna tıkla
        WebElement addToCart = driver.findElement(By.id("button-cart"));
        addToCart.click();
        Thread.sleep(1000);

        // Sepete tıkla
        WebElement card = driver.findElement(By.id("cart"));
        card.click();
        Thread.sleep(2000);

        // Checkout butonuna tıklar
        WebElement checkout = driver.findElement(By.linkText("View Cart"));
        checkout.click();
        Thread.sleep(3000);

        //Guest girisi tıkla
        WebElement guest = driver.findElement(By.linkText("Checkout"));
        guest.click();

        // Guest Radio button'i secer
        Thread.sleep(3000);
        WebElement guestRadio = driver.findElement(By.xpath("//input[@value='guest']"));
        guestRadio.click();

        // Contiune butonuna girisi'ne  tıklar
        WebElement contiune = driver.findElement(By.id("button-account"));
        contiune.click();
        Thread.sleep(3000);

        // Your Personal Details kismini doldurur.
        Faker faker = new Faker();
        Actions actions = new Actions(driver);


        //“firstName” giris kutusuna bir soyisim yazin
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

        //“lastName” giris kutusuna bir soyisim yazin
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        //“Email” giris kutusuna bir mail yazin
        WebElement email = driver.findElement(By.id("input-payment-email"));
        email.sendKeys(faker.internet().emailAddress());
        Thread.sleep(3000);

        // “Telephone” giris kutusuna bir tlf-no yazin
        WebElement telefon = driver.findElement(By.xpath("//input[@name='telephone']"));
        telefon.sendKeys(faker.phoneNumber().phoneNumber());
        Thread.sleep(3000);

        // Your Address Details kismini doldurur.
        WebElement address = driver.findElement(By.id("input-payment-address-1"));
        address.sendKeys(faker.address().fullAddress());

        // Your City
        WebElement city = driver.findElement(By.id("input-payment-city"));
        city.sendKeys(faker.address().city());

        // Your postCode
        WebElement postCode = driver.findElement(By.id("input-payment-postcode"));
        postCode.sendKeys(faker.address().zipCode());

        // Your Country
        WebElement country = driver.findElement(By.name("country_id"));
        Select select = new Select(country);
        select.selectByVisibleText("United Kingdom");

        // Your Region
        WebElement zone = driver.findElement(By.name("zone_id"));
        Select selec = new Select(zone);
        selec.selectByVisibleText("Aberdeen");
        Thread.sleep(3000);

        // Contiunue butonuna tiklar.
        WebElement contiunue = driver.findElement(By.xpath("(//input)[20]"));
        contiunue.click();

        //“Sepetim” sayfasına yönlendirilir ve “Ödeme Yap” düğmesine tıklar.
        // ödeme sayfasına yönlendirilir ve farklı ödeme seçenekleri arasından seçim yapar.
        //  Eğer hata yaparsa, kullanıcıya ne yapması gerektiği açıklanmalı ve "Warning: No Payment options are available. Please contact us for assistance!" hatasi dogrulanmalidir.
        // Hata yoksa Contiunue butonuna tiklar.
        // ödeme işlemini tamamlandigini dogrulayin.

        //TODO Alisveris sayfasina "Guest" olarak ve tek urun secerek ilerleyince Payment kisminda herhangi bir odeme methodu ile karsilasilmadi
        // BUG Ticked hazirlandi
        WebElement actualResult = driver.findElement(By.xpath("(//div)[65]"));

        String expectedText = "Warning: No Payment options are available. Please";
        Assert.assertFalse( actualResult.getText().equals(expectedText));
        System.out.println("expectedText = " + expectedText);


    }
}
