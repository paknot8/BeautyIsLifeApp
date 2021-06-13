import org.junit.Assert;
import org.junit.Test;

public class VoorraadBerekenenTest
{
    Product product = new Product(1,"facial",1,5);
    Bestelling bestelling = new Bestelling(1,1,"facial",3,1);

    @Test
    public void newVoorraadBerekenenTest() {
        int expected = 2;
        int newVoorraad = product.getProductVoorraad() - bestelling.getAantalGekocht();
        Assert.assertEquals(expected, newVoorraad);
    }
}