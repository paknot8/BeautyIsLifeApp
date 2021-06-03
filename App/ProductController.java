public class ProductController {
    // Get all data from list
    public static void getAllProducten() {
        for (Product product : ProductData.ProductenLijst)
        {
            System.out.println(product.getProductId() + " " + product.getProductNaam() +
                    " " + product.getProductPrijs() + " " + product.getProductVoorraad());
        }
    }
}
