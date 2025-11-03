package Gun03;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Base64;
import java.util.List;

/*
      Senaryo ;
      1- Siteyi açınız.
      2- mac(xml den gönderilecek) kelimeini göndererek aratınız.
      3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
      4- aynı işlemi samsung(xml den gönderilecek için de yapınız
    */
public class _07_SearchFunctionality extends BaseDriver {

    @Test
    @Parameters("searchText")
    public void SearchFunction(String aranacakText)
    {
        WebElement searchInput=driver.findElement(By.name("search"));
        searchInput.sendKeys(aranacakText+ Keys.ENTER);

        List<WebElement> captions=driver.findElements(By.xpath("//*[@class='caption']/h4/a"));

        for (WebElement e: captions)
            Assert.assertTrue(e.getText().toLowerCase().contains(aranacakText));
    }

}
