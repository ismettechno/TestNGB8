package Gun01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _08_Assertions {

    @Test
    public void equalsOrnek(){
        String s1="Merhaba";
        String s2="Merhaba";

        // AEM
        Assert.assertEquals(s1,s2,  "Oluşan la beklenen aynı değil");
    }

    @Test
    public void NotEqualsOrnek(){
        String s1="Merhaba";
        String s2="Merhaba";

        Assert.assertNotEquals(s1,s2,  "Oluşan la beklenen aynı");
    }

    @Test
    public void TrueOrnek(){
        String s1="Merhaba";
        String s2="Merhaba";

        Assert.assertEquals(s1.equals(s2),  "Oluşan la beklenen aynı değil");
    }

    @Test
    public void TrueOrnek2(){
        int s1=5;
        int s2=5;

        Assert.assertTrue(s1==s2,"Oluşan la beklenen aynı değil");
    }

    @Test
    public void NullOrnek(){
        String s=null;

        Assert.assertNull(s,"Beklenen değer Null değil");
    }

    @Test
    public void FalseOrnek(){
        int s1=5;
        int s2=5;

        Assert.assertFalse(s1==s2,"Sonuç false değil");
    }

    @Test
    public void DirectFail(){
        int a=56;

        if (a>56)
            Assert.fail(); // Direct fail
    }

}
