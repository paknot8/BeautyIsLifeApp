import java.util.ArrayList;

public class ProductData {
    public static Product productenLijst;
    public static ArrayList<Product> ProductenLijst = new ArrayList<>() {
        {
            add(productenLijst = new Product(1,"cosmetica",5));
            add(productenLijst = new Product(2,"facial",20));
            add(productenLijst = new Product(3,"detox",0));
        }
    };
}
