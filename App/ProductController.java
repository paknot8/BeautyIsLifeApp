import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.in;

public class ProductController {
    private static final Scanner scanner = new Scanner(in);
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
            System.out.println("Productnr: " + product.getProductId() + " | Product: " + product.getProductNaam() +
                    " | Prijs: " + product.getProductPrijs() + " | Op voorraad: " + product.getProductVoorraad());
        }
    }

    public static void chooseAddNewProduct(){
        System.out.println("Kies 1) Nieuwe Product toevoegen of 2) om terug te gaan.");
        userInput = scanner.nextLine();
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

    // Input voor de producten
    public static void DetailsInput() {
        boolean isNumeric = false;
        System.out.println("Voer product gegevens in:");
        System.out.println("Productnaam: ");
        productNaam = scanner.nextLine();
        while(!isNumeric) // Controle of het cijfers zijn.
            try {
                System.out.println("Druk nogmaals op ENTER om door te gaan."); // Tussen breaker, zodat endless-loop eindigd.
                scanner.nextLine();
                System.out.println("Productprijs: ");
                productPrijs = scanner.nextDouble();
                System.out.println("Aantal: ");
                productAantal = scanner.nextInt();
                isNumeric = true; //numeric value entered, so break the while loop
            } catch(InputMismatchException ime) {
                System.out.println("Invoer mag alleen cijfers bevatten, begin opnieuw.");
            }
    }

    // Alleen een Medewerker kan nieuwe producten toevoegen.
    public static void addNewProduct(){
        int id;
        DetailsInput();
        userInput = scanner.nextLine();
        // Inserts id by taking the arraylist size and adding +1
        id = ProductData.ProductenLijst.size() + 1; //increment number
        Product newProduct = new Product(id, productNaam.toLowerCase(), productPrijs, productAantal);
        productLoop(newProduct);
    }

    // extract method gebruik voor duplicate code and long methods
    private static void productLoop(Product newProduct) {
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

    /// TODO: MOET NOG GEDAAN (Wijzgigen van Producten)
    // Alleen een Medewerker kan producten wijzigen.
    public static void wijzigProduct(){
        int id;
        DetailsInput();
        userInput = scanner.nextLine();
        // Inserts id by taking the arraylist size and adding +1
        id = ProductData.ProductenLijst.size() + 1; //increment number
        Product newProduct = new Product(id, productNaam.toLowerCase(), productPrijs, productAantal);
        productLoop(newProduct);
    }
}