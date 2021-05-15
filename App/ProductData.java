import java.util.ArrayList;

public class ProductData {
    public static Product productenLijst;
    public static ArrayList<Product> ProductenLijst = new ArrayList<>() {
        {
            add(productenLijst = new Product(1,"Cosmetica",5));
            add(productenLijst = new Product(2,"anti pimple",2));
        }
    };
}
