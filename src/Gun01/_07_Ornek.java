package Gun01;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _07_Ornek extends BaseDriver {

    @Test
    public void LoginTesti()
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
