package Gun03;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _08_ContactUs_ParameterPD extends BaseDriverParameter {

 //    @Parameters({"mesaj","mesaj2"})// xml deki parametre adı aynı olmak zorunda
//    void contactUs(String gelenMesaj,String m2){

    @Test
    @Parameters("mesaj")
    public void contactUs(String gelenMesaj){
        WebElement contactUsBtn=driver.findElement(By.linkText("Contact Us"));
        contactUsBtn.click();

        WebElement enquiryArea=driver.findElement(By.id("input-enquiry"));
        enquiryArea.sendKeys(gelenMesaj);

        WebElement submitBtn=driver.findElement(By.cssSelector("[type='submit']"));
        submitBtn.click();

        bekle.until(ExpectedConditions.urlContains("success"));
        Assert.assertTrue(driver.getCurrentUrl().contains("success"));
    }

}
