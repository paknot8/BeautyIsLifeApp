import org.junit.Assert;
import org.junit.Test;

public class BestellingTest
{
   @Test
    public void kortingOpTotaalAantalProductenTest(){
       // 15% korting
        Bestelling bestelling1 = new Bestelling(4,6, 4);
        double expected1 = 23.1;
        Assert.assertEquals(expected1,bestelling1.kortingOpTotaalAantalProducten(), 0.01);

       // 20% korting
        Bestelling bestelling2 = new Bestelling(4,15, 4);
        double expected2 = 57;
        Assert.assertEquals(expected2,bestelling2.kortingOpTotaalAantalProducten(), 0.01);

       // 25% korting
       Bestelling bestelling3 = new Bestelling(4,160, 4);
       double expected3 = 600;
       Assert.assertEquals(expected3,bestelling3.kortingOpTotaalAantalProducten(), 0.01);

       // zonder korting
       Bestelling bestelling4 = new Bestelling(4,1, 4);
       double expected4 = 4;
       Assert.assertEquals(expected4,bestelling4.kortingOpTotaalAantalProducten(), 0.01);
    }
}