import org.junit.Assert;
import org.junit.Test;

public class BestellingTest
{
   @Test
    public void kortingOpTotaalAantalProductenTest(){
       // 15% korting
        Bestelling bestelling1 = new Bestelling(4,"Cosmetica", 4,1,5,1);
        double expected1 = 4.25;
        Assert.assertEquals(expected1,bestelling1.kortingOpTotaalAantalProducten(), 0.01);

       // 20% korting
        Bestelling bestelling2 = new Bestelling(4,"Cosmetica", 4,1,13,1);
        double expected2 = 10.4;
        Assert.assertEquals(expected2,bestelling2.kortingOpTotaalAantalProducten(), 0.01);

       // 25% korting
       Bestelling bestelling3 = new Bestelling(4,"Cosmetica", 4,1,168,1);
       double expected3 = 126.0;
       Assert.assertEquals(expected3,bestelling3.kortingOpTotaalAantalProducten(), 0.01);

       // zonder korting
       Bestelling bestelling4 = new Bestelling(4,"Cosmetica", 4,1,1,1);
       double expected4 = 1;
       Assert.assertEquals(expected4,bestelling4.kortingOpTotaalAantalProducten(), 0.01);
    }
}