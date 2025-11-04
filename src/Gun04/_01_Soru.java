package Gun04;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*

   Senaryo
   1- Siteye gidiniz
   2- Specials tiklayiniz
   3- Cikan urun lerde (bütün ürünlerde indirim var mı, eski fiyat yeni fiyat var mı)
   4- Yukarıdaki işlemden sonra her ürünün önceki fiyatının şu andaki fiyattan
      yüksek olduğunu doğrulayınız.
*/
public class _01_Soru extends BaseDriver {

    @Test
    public void SpecialsTest()
    {
        WebElement specials=driver.findElement(By.linkText("Specials"));
        specials.click();

        List<WebElement> newPrices=driver.findElements(By.cssSelector("span[class='price-new']"));
        List<WebElement> oldPrices=driver.findElements(By.cssSelector("span[class='price-old']"));

        //her üründe indirim var mı, her üründe eski fiyat yeni fiyat var mı?
        Assert.assertTrue(newPrices.size() == oldPrices.size(),"Bütün ürünlerde indirim bulunamadı");

        //4 madde: bütün indirimler doğrumu, hatalı fiyat var mı
        for (int i = 0; i < newPrices.size(); i++) {
            double newPrice=Double.parseDouble(newPrices.get(i).getText().replaceAll("[^0-9,.]","") );
            double oldPrice=Double.parseDouble(oldPrices.get(i).getText().replaceAll("[^0-9,.]","") );

            //doğrulama
            Assert.assertTrue(oldPrice>newPrice,"Yeni fiyat eskisinden küçük değil");
        }

    }
}
