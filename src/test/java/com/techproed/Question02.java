package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Question02 {
            /*
        BeforeClass ile driver ı oluşturun.
        Maximize edin, 10 sn bekletin
        AfterClass ile kapatın
        Google'a gidin
        1. olarak zoom 'u aratıp çıkan sonuç sayısını ekrana yazdırın
        2. olarak Selenium 'u aratıp çıkan sonu sayısını ekrana yazdırın.
        3. olarak Techproeducation'u aratıp çıkan sonuç sayısını ekrana yazdırın.
         */
    static WebDriver driver;

    @BeforeClass
    
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @Before
    public void genel(){
        driver.get("https://www.google.com");

    }
    @Test
    public void test(){

        WebElement sourcBOx=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        sourcBOx.sendKeys("zoom"+ Keys.ENTER);

    }
    @Test
    public void test2(){

        WebElement sourcBOx=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        sourcBOx.sendKeys("Selenium"+ Keys.ENTER);

    }
    @Test
    public void test3(){

        WebElement sourcBOx=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        sourcBOx.sendKeys("Techproeducation"+ Keys.ENTER);

    }
    @After
    public void sonuclar(){
        WebElement sonucSayi=driver.findElement(By.id("result-stats"));
        System.out.println(sonucSayi.getText());

    }
    @AfterClass
    public static void tearDown(){
        driver.quit();

    }
}
