package com.gunesSahin.TestCase12;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestCase2 {
    WebDriver driver;

    @BeforeMethod

    public void setUp() throws InterruptedException {
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
    public void testPaymentFlat() throws InterruptedException {
        Faker faker = new Faker();
        Actions actions = new Actions(driver);
        String psvrd = faker.number().digit();


        // Uygulamanın ana sayfasına git
        WebElement product = driver.findElement(By.xpath("//*[@id='logo']/h1/a"));

        // Birinci ürün seç
        WebElement add1 = driver.findElement(By.xpath("//h4")); //div[@class='product-thumb transition']
        add1.click();

        // Sepete ekle butonuna tıkla
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]"));
        addToCart.click();
        Thread.sleep(1000);

        // ikinci ürün seç
        WebElement add2 = driver.findElement(By.xpath("//div[@class='product-thumb transition']"));
        add2.click();

        WebElement add2ToCart = driver.findElement(By.xpath(" //*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]"));
        add2ToCart.click();
        Thread.sleep(1000);

        // Sepete tıkla
        WebElement card = driver.findElement(By.id("cart"));
        card.click();
        Thread.sleep(4000);


        // Checkout butonuna tıklar
        WebElement checkout = driver.findElement(By.linkText("View Cart"));
        checkout.click();
        Thread.sleep(3000);

        //Register girisi tıkla
        WebElement register = driver.findElement(By.linkText("Checkout"));
        register.click();

        // Register Radio button'i secer
        Thread.sleep(3000);
        WebElement registerRadio = driver.findElement(By.xpath("//input[@value='register']"));
        registerRadio.click();


        // Contiune butonuna girisi'ne  tıklar
        WebElement contiune = driver.findElement(By.id("button-account"));
        contiune.click();
        Thread.sleep(3000);

        // Your Personal Details kismini doldurur.

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

        // Your Password kismini doldurur.
        WebElement password = driver.findElement(By.id("input-payment-password"));
        password.sendKeys(psvrd);

        WebElement passwordCnfrm = driver.findElement(By.id("input-payment-confirm"));
        passwordCnfrm.sendKeys(psvrd);

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
        Thread.sleep(2000);

        // Policie Radio butonuna tiklar.
        WebElement policie = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        policie.click();

        // Contiunue butonuna tiklar.

        WebElement contiunue = driver.findElement(By.xpath("(//input)[20]"));
        contiunue.click();
        Thread.sleep(2000);

        // Checkout Contiunue butonuna tiklayin
        WebElement chkcContiunue = driver.findElement(By.xpath("((//input[@type='button'])[@value='Continue'])[2]"));
        chkcContiunue.click();

        // Flat Shipping Kabul edip Contiunue butonuna tiklayin
        WebElement flatShipping = driver.findElement(By.xpath("(//input[@type='button'])[3]"));
        flatShipping.click();

        // Siparişte ödeme yöntemini seçin


        WebElement termsConditions = driver.findElement(By.xpath("//input[@value='1']"));
        actions.click(termsConditions);

        // termsConditions.click();
        WebElement deliveryConditions = driver.findElement(By.xpath("//input[@type='checkbox']"));
        deliveryConditions.click();


        // Siparişte ödeme yöntemini seçtikten sonra devam edin

        // Confirm Order
        Thread.sleep(3000);
        WebElement confirmOrder = driver.findElement(By.id("collapse-checkout-confirm"));
        actions.click(confirmOrder);
        Thread.sleep(3000);

        // Your order has been placed! Textini dogrulayin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(5000);
        WebElement confirmOrderPlaced = driver.findElement(By.id("content"));
        String actualText = confirmOrderPlaced.getText();
        String expectedText = "Checkout";
        Assert.assertTrue(actualText.contains(expectedText));


    }

}
