import org.junit.Assert;
import org.junit.Test;

public class BestellingTest
{
   @Test
    public void kortingOpTotaalAantalProductenTest(){
       // 15% korting
        Bestelling bestelling1 = new Bestelling(4,1);
        double expected1 = 3.4;
        Assert.assertEquals(expected1,bestelling1.kortingOpTotaalAantalProducten(), 0.01);

       // 20% korting
        Bestelling bestelling2 = new Bestelling(11,1);
        double expected2 = 8.8;
        Assert.assertEquals(expected2,bestelling2.kortingOpTotaalAantalProducten(), 0.01);

       // 25% korting
       Bestelling bestelling3 = new Bestelling(120,1);
       double expected3 = 90.0;
       Assert.assertEquals(expected3,bestelling3.kortingOpTotaalAantalProducten(), 0.01);

       // zonder korting
       Bestelling bestelling4 = new Bestelling(1,5);
       double expected4 = 5.0;
       Assert.assertEquals(expected4,bestelling4.kortingOpTotaalAantalProducten(), 0.01);
    }
}