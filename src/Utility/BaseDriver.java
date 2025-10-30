package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait bekle;

    @BeforeClass
    public void Setup()
    {
        driver = new ChromeDriver();

        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // 5 sn mühlet: elementi bulma mühleti

        bekle =new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginIn();
    }

    @AfterClass
    public static void TearDown()
    {
        MyFunc.Bekle(5);
        driver.quit();  // açılmış bütün tabları kapatır, tarayıcıyı kapatır
    }

    public void LoginIn()
    {
        System.out.println("Login Testi başladı");
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement email=driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("testng1@gmail.com");

        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("123qweasd");

        WebElement loginBtn=driver.findElement(By.xpath("//*[@value='Login']"));
        loginBtn.click();

        Assert.assertTrue(driver.getTitle().equals("My Account"), "Login olunamadı");
        System.out.println("Login Testi Bitti");
    }
}
