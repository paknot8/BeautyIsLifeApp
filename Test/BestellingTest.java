import org.junit.Assert;
import org.junit.Test;

public class BestellingTest
{
    @Test
    public void Zonder_kortingOpTotaalAantalProductenTest(){
        Bestelling bestelling = new Bestelling(99,1);
        double expected = 99.0;
        Assert.assertEquals(expected,bestelling.kortingOpTotaalAantalProducten(), 0.01);
    }

   @Test
    public void kortingOpTotaalAantalProductenTest(){
        Bestelling bestelling = new Bestelling(105,1);
        double expected = 89.25;
        Assert.assertEquals(expected,bestelling.kortingOpTotaalAantalProducten(), 0.01);
    }

}