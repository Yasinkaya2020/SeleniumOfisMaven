package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Question03 {


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
        // 1. Amazon.com'a gidelim.
        driver.get("https://www.amazon.com");

        // 2. DropDown üzerinde Books seçelim.
        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Books");

        // kategorilerin hepsini konsola yazdıralım

        List<WebElement> listler = select.getOptions();
        for(WebElement w: listler){
            System.out.println(w.getText());
        }

        // 3. Arama kutusuna Les Miserables yazalım ve arama yapalım.
        WebElement searcBox=driver.findElement(By.id("twotabsearchtextbox"));
        searcBox.sendKeys("Les Miserables"+ Keys.ENTER);

        // 4. Sonuç sayısını ekrana yazdıralım.
        WebElement sonucSayisi= driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println("Sonuc Sayisi: "+sonucSayisi.getText());

        // Sonuçların Les Miserables i içerdiğini assert edelim
        WebElement actualIcerik=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        Assert.assertTrue(actualIcerik.getText().contains("Les Miserables"));

    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
