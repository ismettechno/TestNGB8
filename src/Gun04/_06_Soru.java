package Gun04;

/*
  Senaryo;
  1- Brands menusune gidiniz.
  2- Burada her bir markanın üstünde yer alan harf ile başladığını doğrulayınız
 */


import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _06_Soru extends BaseDriver {

    @Test
    public void BrandsTest() {
        WebElement brandsLink = driver.findElement(By.linkText("Brands"));
        brandsLink.click();

        //harfler
        List<WebElement> harfler=driver.findElements(By.cssSelector("[id='content'] > h2"));
        //her harfin altındaki markaların olduğu tüm webelement alındı
        List<WebElement> markalar=driver.findElements(By.cssSelector("[id='content'] > div"));

        for (int i = 0; i < harfler.size(); i++) {
            System.out.println("harf = " + harfler.get(i).getText()); // A

            //marka bloklarındaki div leri alarak markalara tek tek ulaşabildim, list olarak
            List<WebElement> harfinMarkalari= markalar.get(i).findElements(By.tagName("div"));
            for(WebElement marka: harfinMarkalari) {
                System.out.println(marka.getText()); //Apple

                Assert.assertEquals(harfler.get(i).getText().charAt(0),
                                    marka.getText().charAt(0)
                                    ,"Marka ilgili harfe başlamıyor");
            }

        }


    }

}
