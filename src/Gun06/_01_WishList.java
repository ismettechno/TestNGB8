package Gun06;


import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*
    Senaryo ;
    1- Siteye gidiniz..
    2- "ipod" ürününü aratınız.
    3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
    4- Daha sonra WishList e tıklatınız
    5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
    (POM olmadan çözünüz)
 */
public class _01_WishList extends BaseDriver {

    @Test
    public void addToWishList() {
        WebElement searchBox=driver.findElement(By.name("search"));
        searchBox.sendKeys("ipod"+ Keys.ENTER);

        List<WebElement> productNameList=driver.findElements(By.xpath("//div[@class='caption'] / h4"));

        int rndSayi= MyFunc.RandomSayiVer(productNameList.size());

        String secilenUrunAdi=productNameList.get(rndSayi).getText(); //ürün adı bir sonraki adım kontrolü için alındı

        List<WebElement> wishButtons=driver.findElements(By.xpath("//*[@data-original-title='Add to Wish List']"));
        wishButtons.get(rndSayi).click(); //Seçilen ürünün Add wish list butonuna tıklattım

        WebElement wishListLink=driver.findElement(By.xpath("//a[@id='wishlist-total']"));
        wishListLink.click();

        // Wish List ekranda , ekrandaki ürünlerin listesini alalım
        List<WebElement> wishNameList=driver.findElements(By.cssSelector("[class='text-left'] a"));

        boolean bulundu=false;
        for(WebElement urun: wishNameList)
            if (urun.getText().equals(secilenUrunAdi)) {
                bulundu = true;
                break;
            }

        if (!bulundu) // urun wish liste atılamamış ise fail ver
            Assert.fail();
    }

}
