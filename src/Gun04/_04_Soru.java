package Gun04;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Daha önceki derslerde yaptğımız Search fonksiyonunu
 * mac,ipod ve samsung için Dataprovider ile yapınız.
 */
public class _04_Soru extends BaseDriver {

    @Test(dataProvider = "datalarim")
    public void SearchFunction(String aranacakText)
    {
        WebElement searchInput=driver.findElement(By.name("search"));
        searchInput.clear();
        searchInput.sendKeys(aranacakText+ Keys.ENTER);

        List<WebElement> captions=driver.findElements(By.xpath("//*[@class='caption']/h4/a"));

        for (WebElement e: captions)
            Assert.assertTrue(e.getText().toLowerCase().contains(aranacakText));
    }

    @DataProvider
    Object[] datalarim(){
        Object[] aranacaklar={"mac","iphone","samsung"};
        return aranacaklar;
    }

}
