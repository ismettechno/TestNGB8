package Gun04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_DataProvider_CokBoyutlu {

    @Test(dataProvider="datalarim")
    public void LoginTest(String username, String password, int age){
        System.out.println(username+" - "+password+" "+age);
    }

    @DataProvider
    Object[][] datalarim(){
        Object[][] datalar={
                {"ismet","1234",24},
                {"ayşe", "5678",26},
                {"ibrahim","445454",20},
                {"Rıfat","34343",45}
        };

        return datalar;
    }




}
