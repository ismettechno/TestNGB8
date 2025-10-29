package Gun01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _03_Annotations {

    @Test
    public void Test1(){
        System.out.println("test 1 çalıştı");
    }

    @Test
    public void Test2(){
        System.out.println("test 2 çalıştı");
    }

    @BeforeClass
    public void onceCalistirilacaklar(){
        System.out.println("Test başlatılmadan yapılacaklar: driver vs işlemler");
    }

    @AfterClass
    public void sonraCalistirilacaklar(){
        System.out.println("Test bitince yapılacaklar: driver kapat vs işlemler");
    }

}
