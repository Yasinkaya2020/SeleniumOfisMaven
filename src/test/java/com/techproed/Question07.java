package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Question07 {
    //1.  "https://www.twitter.com" hesabına gidin
    //2. Register butonuna tıklayın
    //3. Kendi bilgilerinizi girerek hesap oluşturun.



    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void kayit() throws InterruptedException {
        driver.get("https://www.twitter.com");
        driver.findElement(By.xpath("(//div[@dir='auto'])[3]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[.='Use email instead']")).click();
        WebElement isim=driver.findElement(By.xpath("(//input[@dir='auto'])[1]"));
        isim.sendKeys("ali");
        WebElement mail=driver.findElement(By.xpath("(//input[@dir='auto'])[2]"));
        mail.sendKeys("testtechproed@gmail.com");

        WebElement aydrob=driver.findElement(By.id("Month"));
        Select aydrobdown=new Select(aydrob);
        aydrobdown.selectByVisibleText("January");

        WebElement gundrob=driver.findElement(By.id("Day"));
        Select gundrobdown= new Select(gundrob);
        gundrobdown.selectByVisibleText("2");

        WebElement yildrob=driver.findElement(By.id("Year"));
        Select yildrobdown=new Select(yildrob);
        yildrobdown.selectByVisibleText("1958");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Next']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Next']")).click();

        driver.findElement(By.xpath("(//div[@dir='auto'])[13]")).click();



    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }





}
