import java.util.ArrayList;

public class ProductData {
    public static Product productenLijst;
    public static ArrayList<Product> ProductenLijst = new ArrayList<>() {
        {
            add(productenLijst = new Product(1,"cosmetica",1.50,120));
            add(productenLijst = new Product(2,"facial",4.99,30));
            add(productenLijst = new Product(3,"detox",6.0,5));
        }
    };
}
