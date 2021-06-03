import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.in;

public class ProductController {
    private static final Scanner s = new Scanner(in);
    private static String userInput;

    public static String productNaam;
    public static double productPrijs;
    public static int productAantal;

    public static String tempProductNaam;
    public static double tempProductPrijs;
    public static int tempProductAantal;

    // Get all data from list
    public static void getAllProducten() {
        for (Product product : ProductData.ProductenLijst)
        {
            System.out.println(product.getProductId() + " " + product.getProductNaam() +
                    " " + product.getProductPrijs() + " " + product.getProductVoorraad());
        }
    }

    public static void chooseAddNewProduct(){
        System.out.println("Kies 1) Nieuwe Product toevoegen of 2) om terug te gaan.");
        userInput = s.nextLine();
        if(userInput.equals("1")){
            addNewProduct();
        } else if(userInput.equals("2")){
            System.out.println("Terug gaan naar Hoofdmenu...\n");
            KeuzeMenu.MenuKeuze_Medewerker();
        } else {
            System.out.println("Probeer opnieuw...\n");
            chooseAddNewProduct();
        }
    }

    public static void DetailsInput() {
        boolean isNumeric = false;
        System.out.println("Voer product gegevens in:");
        System.out.println("Productnaam: ");
        productNaam = s.nextLine();
        while(!isNumeric) // Controle of het cijfers zijn.
            try {
                System.out.println("Productprijs: ");   productPrijs    = s.nextDouble();   s.nextLine();
                System.out.println("Aantal: ");         productAantal   = s.nextInt();      s.nextLine();
                isNumeric = true;//numeric value entered, so break the while loop
            } catch(InputMismatchException ime) {
                //Display Error message
                System.out.println("Invoer mag alleen cijfers bevatten, begin opnieuw.");
            }
    }

    // Only medewerker can add a new product
    public static void addNewProduct(){
        int id;
        DetailsInput();
        userInput = s.nextLine();
        // Inserts id by taking the arraylist size and adding +1
        id = ProductData.ProductenLijst.size() + 1; //increment number
        Product newProduct = new Product(id, productNaam, productPrijs, productAantal);
        for (int i = 0; i < GebruikersData.GebruikersLijst.size(); i++) {
            tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam();
            tempProductPrijs = ProductData.ProductenLijst.get(i).getProductPrijs();
            tempProductAantal = ProductData.ProductenLijst.get(i).getProductVoorraad();

            if (productNaam.equals(tempProductNaam)) {
                System.out.println("Product bestaat al, vul een nieuw product in! \n");
                addNewProduct();
            } else {
                ProductData.ProductenLijst.add(newProduct);
                System.out.println("Nieuwe product is succesvol toegevoegd in de maggazijn.\n");
                break;
            }
        }
    }
}
