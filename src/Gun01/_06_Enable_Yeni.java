package Gun01;

import Utility.BaseDriver;
import org.testng.annotations.Test;

public class _06_Enable_Yeni extends BaseDriver {
    @Test
    public void Test1()
    {
        System.out.println("Test1");
        driver.get("https://www.facebook.com/");
    }

    @Test(enabled = false)
    public void Test2()
    {
        System.out.println("Test2");
    }

    @Test
    public void Test3()
    {
        System.out.println("Test3");
        driver.get("https://www.google.com/");
    }
}
