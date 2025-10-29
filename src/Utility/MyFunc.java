package Utility;

public class MyFunc {
    public static void Bekle(int sn)
    {
        try {
            Thread.sleep(sn*1000);
        } catch (InterruptedException e) {
            System.out.println("Hata oluştu:"+e.getMessage());
        }
    }

    public static int RandomSayiVer(int min, int max)
    {
        return  (int)(Math.random()* (max-min) )+ min;
    }

    public static int RandomSayiVer(int max)
    {
        return  (int)(Math.random()* max);
    }

}
