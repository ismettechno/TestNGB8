package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseDriverParameter {
    public WebDriver driver;
    public WebDriverWait bekle;

    @BeforeClass
    @Parameters("browserTipi")
    public void Setup(String browserTipi)
    {
        System.out.println("browserTipi = " + browserTipi);
        switch (browserTipi) {
            case "firefox": driver=new FirefoxDriver(); break;
            case "edge": driver=new EdgeDriver(); break;
            default : driver = new ChromeDriver();
        }

        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // 5 sn mühlet: elementi bulma mühleti

        bekle =new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginIn();
    }

    @AfterClass
    public void TearDown()
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

        bekle.until(ExpectedConditions.titleContains("My Account"));
        Assert.assertTrue(driver.getTitle().equals("My Account"), "Login olunamadı");
        System.out.println("Login Testi Bitti");
    }
}
