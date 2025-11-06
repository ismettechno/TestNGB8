package Gun06;

import Gun05._02_PlaceOrder_Elementleri;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _02_WishList_POM extends BaseDriver {

    @Test
    public void addToWishList() {
        _02_PlaceOrder_Elementleri poe=new _02_PlaceOrder_Elementleri();
        _03_WishList_Elements wle=new _03_WishList_Elements();

        poe.searchBox.sendKeys("ipod"+ Keys.ENTER);
        int rndSayi= MyFunc.RandomSayiVer(wle.productNameList.size());
        String secilenUrunAdi=wle.productNameList.get(rndSayi).getText();
        wle.wishButtons.get(rndSayi).click();
        wle.wishListLink.click();

        boolean bulundu=false;
        for(WebElement urun: wle.wishNameList)
            if (urun.getText().equals(secilenUrunAdi)) {
                bulundu = true;
                break;
            }

        if (!bulundu)
            Assert.fail();
    }

}
