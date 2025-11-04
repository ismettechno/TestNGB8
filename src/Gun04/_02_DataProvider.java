package Gun04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider {

    @Test(dataProvider = "datalarim" )
    public void Search(String gelenKelime)
    {
        System.out.println("gelenKelime = " + gelenKelime);
    }

    @DataProvider
    Object[] datalarim(){
        Object[] aranacaklar={"mac","iphone","laptop","mouse"};
        return aranacaklar;
    }


}
