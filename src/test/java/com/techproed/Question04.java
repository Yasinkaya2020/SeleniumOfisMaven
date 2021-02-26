package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Question04 {
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
        //www.bestbuy.com'a gidin
        driver.get("http://www.bestbuy.com");
        // Sayfa başlığının “Best” içerdiğini(contains) doğrulayın
        String actualTitle=driver.getTitle();
        String extedTitle="Best";
        Assert.assertTrue(actualTitle.contains(extedTitle));
        // logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
        WebElement logo=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
        System.out.println("Logo PASS");
        //  mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
        WebElement mexicoLogo=driver.findElement(By.xpath("(//img[@alt='Mexico'])[1]"));
        Assert.assertTrue(mexicoLogo.isDisplayed());
        System.out.println("Mexico PASS");


    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
