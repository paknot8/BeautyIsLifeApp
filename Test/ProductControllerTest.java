import org.junit.Assert;
import org.junit.Test;
import static java.lang.System.out;

public class ProductControllerTest
{
    // mock data
    Product product = new Product(1,"detox",1,10);
    boolean controle = false;

    @Test
    public void getProducten() {
        boolean control = false;
        String expected = "detox";
        for(int i = 0; i < ProductData.ProductenLijst.size(); i++){
            String productNaam = ProductData.ProductenLijst.get(i).getProductNaam();
            if(expected.equals(productNaam)){
                control = true;
                break;
            }
        }
        Assert.assertTrue(product.getProductNaam(),control);
    }

    @Test
    public void controleProductExist() {
        TempField.userInput = "detox";
        TempField.tempProductNaam = product.getProductNaam();
        String expected = TempField.userInput;
        if (TempField.tempProductNaam.equals(TempField.userInput)) {
            out.println("Het gezochte product: ( " + TempField.userInput + " ) is gevonden!");
            out.println("Productnr: " + TempField.tempProductID + " | Product: " + TempField.tempProductNaam +
                    " | Prijs " + TempField.tempProductPrijs + " | Aantal op voorraad: " + TempField.tempProductAantal);
            controle = true;
        }
        Assert.assertTrue(expected,controle);
    }

    @Test
    public void zoekProduct() {
        TempField.userInput = "detox";
        TempField.tempProductNaam = product.getProductNaam();
        String expected = TempField.userInput;
        if (TempField.tempProductNaam.equals(TempField.userInput)) {
            out.println("Het gezochte product: ( " + TempField.userInput + " ) is gevonden!");
            out.println("Productnr: " + TempField.tempProductID + " | Product: " + TempField.tempProductNaam +
                    " | Prijs " + TempField.tempProductPrijs + " | Aantal op voorraad: " + TempField.tempProductAantal);
            controle = true;
        }
        Assert.assertTrue(expected,controle);
    }

    @Test
    public void wijzigProduct() {
        String expected = "lipstick";
        product.setProductNaam("lipstick");
        Assert.assertEquals(expected,product.getProductNaam());
    }

    @Test
    public void verwijderProduct() {
        TempField.userInput = "facial";
        String expected = TempField.userInput;
        for(int i = 0; i < ProductData.ProductenLijst.size(); i++){
            String productNaam = ProductData.ProductenLijst.get(i).getProductNaam();
            if (productNaam.equals(expected)) {
                ProductData.ProductenLijst.remove(expected);
                controle = true;
                break;
            }
        }
        Assert.assertTrue(expected,controle);

    }

    @Test
    public void addProduct() {
        Product newProd = new Product(5,"lotion",1,1);
        ProductData.ProductenLijst.add(newProd);
        String expected = newProd.getProductNaam();
        for(int i = 0; i < ProductData.ProductenLijst.size(); i++){
            String productNaam = ProductData.ProductenLijst.get(i).getProductNaam();
            if (productNaam.equals(expected)) {
                controle = true;
                break;
            }
        }
        Assert.assertTrue(expected,controle);
    }
}