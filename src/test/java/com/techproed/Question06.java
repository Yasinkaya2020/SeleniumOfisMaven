package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Question06 {

    //Amazon'a gidelim,
    //    Başlığın Amazon içermediğini, Car ve Online içerdiğini kontrol edelim.
    //    Soft assert kullanalım
    //    http://a.testaddressbook.com/sign_in adresine gidelim
    //    mail olarak testtechproed@gmail.com girelim
    //    Başlığın "Deneme" 'ye eşit olup olmadığını kontrol edelim
    //    Şifre bölümüne Test1234! i gönderelim
    //    Title'ın Address Book e eşit olup olmadığını assert edelim
    //    Sign in olalaım
    //    Ve doğru bir şekilde giriş yapıp yapamadığımızı kontrol edelim

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
        SoftAssert softAssert = new SoftAssert();

        driver.get("https://www.amazon.com");
        String amazonTitle= driver.getTitle();
        softAssert.assertTrue(amazonTitle.contains("Amazon"));
        softAssert.assertFalse(amazonTitle.contains("Car"));
        softAssert.assertTrue(amazonTitle.contains("Online"));


        softAssert.assertAll();



    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://a.testaddressbook.com/sign_in");
        String baslik= driver.getTitle();
        System.out.println(baslik);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(baslik.contains("Deneme"));
        softAssert.assertTrue(baslik.contains("Address Book"));


        WebElement userName=driver.findElement(By.xpath("//input[@name='session[email]']"));
        userName.sendKeys("testtechproed@gmail.com");
        WebElement pass=driver.findElement(By.id("session_password"));
        pass.sendKeys("Test1234!"+Keys.ENTER);
        Thread.sleep(5000);
        WebElement girisBasarili = driver.findElement(By.linkText("Sign out"));

        softAssert.assertTrue(girisBasarili.isDisplayed());

        softAssert.assertAll();


    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }



}
