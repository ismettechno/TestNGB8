package Gun02;

import Utility.BaseDriver;
import Utility.WebTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_SubscribeNewsLetter extends BaseDriver {
     /*
    Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe işlemini abone olunuz(YES)  , işlemin başarılı olduğunu kontrol ediniz.
  3- Ayrı bir test ile Newsletter  Subscribe işlemini abonelikten çıkınız(NO)
  4- Ayrı bir test ile Newsletter  Subscribe durumunu kontrol ediniz YES ise NO, NO ise YES yapınız.
     */

    @Test
    public void SubscribeFunctionYes() {
        WebElement newsLetterLink=driver.findElement(By.linkText("Newsletter"));
        newsLetterLink.click();

        WebElement subscribeYes=driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
        subscribeYes.click();

        WebElement continueButton=driver.findElement(By.xpath("//*[@value='Continue']"));
        continueButton.click();

        WebTool.SuccessMessageValidation();
    }

    @Test
    public void SubscribeFunctionNo() {
        WebElement newsLetterLink=driver.findElement(By.linkText("Newsletter"));
        newsLetterLink.click();

        WebElement subscribeNo=driver.findElement(By.xpath("//input[@type='radio' and @value='0']"));
        subscribeNo.click();

        WebElement continueButton=driver.findElement(By.xpath("//*[@value='Continue']"));
        continueButton.click();

        WebTool.SuccessMessageValidation();
    }

    @Test
    public void SubscribeFunctionForBoth() {
        WebElement newsLetterLink=driver.findElement(By.linkText("Newsletter"));
        newsLetterLink.click();

        WebElement subscribeYes=driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
        WebElement subscribeNo=driver.findElement(By.xpath("//input[@type='radio' and @value='0']"));

        if (subscribeYes.isSelected())
            subscribeNo.click();
        else
            subscribeYes.click();

        WebElement continueButton=driver.findElement(By.xpath("//*[@value='Continue']"));
        continueButton.click();

        WebTool.SuccessMessageValidation();
    }


}
