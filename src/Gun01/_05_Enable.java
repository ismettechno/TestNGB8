package Gun01;

import Utility.MyFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class _05_Enable {

    @Test
    public void Test1()
    {
        System.out.println("Test1");
        driver.get("https://www.facebook.com/");
    }

    @Test(enabled = false)
    public void Test2()
    {
        System.out.println("Test2");
    }

    @Test
    public void Test3()
    {
        System.out.println("Test3");
        driver.get("https://www.google.com/");
    }

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
    }

    @AfterClass
    public static void TearDown()
    {
        MyFunc.Bekle(5);
        driver.quit();  // açılmış bütün tabları kapatır, tarayıcıyı kapatır
    }

}
