public class Product {
    private int productId;
    private String productNaam;
    private double productPrijs;
    private int productVoorraad;

    public Product(int productId, String productNaam, double productPrijs, int productVoorraad) {
        this.productId = productId;
        this.productNaam = productNaam;
        this.productPrijs = productPrijs;
        this.productVoorraad = productVoorraad;
    }

    public int getProductId() { return productId; }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductNaam() {
        return productNaam;
    }
    public void setProductNaam(String productNaam) {
        this.productNaam = productNaam;
    }
    public double getProductPrijs() { return productPrijs; }
    public void setProductPrijs(double productPrijs) { this.productPrijs = productPrijs; }
    public int getProductVoorraad() {
        return productVoorraad;
    }
    public void setProductVoorraad(int productVoorraad) {
        this.productVoorraad = productVoorraad;
    }
}
