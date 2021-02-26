package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Question01 {
     /*
        @BeforeClass ın içerisinde driver ı kuralım
        maximize edip tüm we elementler yüklenene kadar 10 sn bekletelim
        Google 'a gidelim ve sayfa başlığının Google içerdiğini doğrulayalım
        Amazon'a gidelim ve url in www.amazon.com içerip içermediğini doğrulayalım
        @AfterClass ta driver ı kapatalım
         -- From stratch

    */
   static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @Test
    public void test(){
        //Google 'a gidelim ve sayfa başlığının Google içerdiğini doğrulayalım
        driver.get("https://www.google.com");

        String expetedTitle="Google";
        Assert.assertTrue(driver.getTitle().contains(expetedTitle));
    }
    @Test
    public void test2(){
        // Amazon'a gidelim ve url in www.amazon.com içerip içermediğini doğrulayalım
        driver.get("https://www.amazon.com");

        String expetedURL="www.amazon.com";
        Assert.assertTrue(driver.getCurrentUrl().contains(expetedURL));
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();

    }

}
