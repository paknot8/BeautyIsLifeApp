import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest
{
// Mock data
    Product product = new Product(1,"facial",1,10);

    @Test
    public void getProductId() {
        int expected = 1;
        Assert.assertEquals(expected,product.getProductId());
    }

    @Test
    public void setProductId() {
        int expected = 78;
        product.setProductId(78);
        Assert.assertEquals(expected,product.getProductId());
    }

    @Test
    public void getProductNaam() {
        String expected = "facial";
        Assert.assertEquals(expected,product.getProductNaam());
    }

    @Test
    public void setProductNaam() {
        String expected = "cosmetica";
        product.setProductNaam("cosmetica");
        Assert.assertEquals(expected,product.getProductNaam());
    }

    @Test
    public void getProductPrijs() {
        double expected = 1.0;
        Assert.assertEquals(expected,product.getProductPrijs(),0.01);
    }

    @Test
    public void setProductPrijs() {
        double expected = 3.13;
        product.setProductPrijs(3.13);
        Assert.assertEquals(expected,product.getProductPrijs(),0.01);
    }

    @Test
    public void getProductVoorraad() {
        int expected = 10;
        Assert.assertEquals(expected,product.getProductVoorraad());
    }

    @Test
    public void setProductVoorraad() {
        int expected = 50;
        product.setProductVoorraad(50);
        Assert.assertEquals(expected,product.getProductVoorraad());
    }
}