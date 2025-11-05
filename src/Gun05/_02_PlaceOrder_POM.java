package Gun05;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_PlaceOrder_POM extends BaseDriver {
    @Test
    public void ProceedToCheckout(){
        _02_PlaceOrder_Elementleri elements=new _02_PlaceOrder_Elementleri();

        elements.searchBox.sendKeys("ipod"+ Keys.ENTER);
        elements.addToChart.click();
        elements.shoppingChart.click();
        elements.checkOut.click();
        bekle.until(ExpectedConditions.elementToBeClickable(elements.continue1)).click();
        bekle.until(ExpectedConditions.elementToBeClickable(elements.continue2)).click();
        bekle.until(ExpectedConditions.elementToBeClickable(elements.continue3)).click();
        elements.agree.click();

        bekle.until(ExpectedConditions.elementToBeClickable(elements.continue4)).click();
        elements.confirm.click();

        bekle.until(ExpectedConditions.urlContains("success"));
        Assert.assertEquals(elements.ekranYazi.getText(), "Your order has been placed!", "Oluşan Mesajlar Eşleşmiyor");
    }
}
