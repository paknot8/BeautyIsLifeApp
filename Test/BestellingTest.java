import org.junit.Assert;
import org.junit.Test;

public class BestellingTest
{
    //Mock Data
    Bestelling bestelling = new Bestelling(13,7,"facial",2,5);

   @Test
    public void kortingOpTotaalAantalProductenTest(){
       // 15% korting
        Bestelling bestelling1 = new Bestelling(1,1, "Facial",5,5);
        double expected1 = 21.25;
        Assert.assertEquals(expected1,Korting.kortingOpTotaalAantalProducten(
                bestelling1.getAantalGekocht(),
                bestelling1.getPrijsBetaald()),
                0.01);

       // 20% korting
       Bestelling bestelling2 = new Bestelling(2,2, "Detox",14,2.50);
       double expected2 = 28.0;
       Assert.assertEquals(expected2,Korting.kortingOpTotaalAantalProducten(
               bestelling2.getAantalGekocht(),
               bestelling2.getPrijsBetaald()),
               0.01);

       // 25% korting
       Bestelling bestelling3 = new Bestelling(3,3, "Cosmetica",120,1);
       double expected3 = 90.0;
       Assert.assertEquals(expected3,Korting.kortingOpTotaalAantalProducten(
               bestelling3.getAantalGekocht(),
               bestelling3.getPrijsBetaald()),
               0.01);

       // zonder korting (Zonder korting krijgt geen bericht)
       Bestelling bestelling4 = new Bestelling(4,4, "Lotion",2,10);
       double expected4 = 20.0;
       Assert.assertEquals(expected4,Korting.kortingOpTotaalAantalProducten(
               bestelling4.getAantalGekocht(),
               bestelling4.getPrijsBetaald()),
               0.01);
    }

    @Test
    public void testGetBestelNummer() {
       int expected = 13;
       Assert.assertEquals(expected,bestelling.getBestelNummer());
    }

    @Test
    public void testGetUserID() {
        int expected = 7;
        Assert.assertEquals(expected,bestelling.getUserID());
    }

    @Test
    public void testGetProductNaam() {
        String expected = "facial";
        Assert.assertEquals(expected,bestelling.getProductNaam());
    }

    @Test
    public void testGetAantalGekocht() {
        int expected = 2;
        Assert.assertEquals(expected,bestelling.getAantalGekocht());
    }
}