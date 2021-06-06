import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.in;

// Interface Segregation
// Seperatie gedaan tussen Medewerker methods en General Methods
// Zo klein mogelijk de interface implementeren, zodat je weinig veranderingen hoeft te doen.
// voor uitbreidingen voor de toekomst.
public class ProductController implements IProductMedewerkerControls, IProduct {
    private static final Scanner scanner = new Scanner(in);
    private static String userInput;
    public static String productNaam;
    public static double productPrijs;
    public static int productAantal;
    public static String tempProductNaam;
    public static double tempProductPrijs;
    public static int tempProductAantal;

    // Get all data from list
    @Override // Interface
    public void getProducten() {
        for (Product product : ProductData.ProductenLijst)
        {
            System.out.println("Productnr: " + product.getProductId() + " | Product: " + product.getProductNaam() +
                    " | Prijs: " + product.getProductPrijs() + " | Op voorraad: " + product.getProductVoorraad());
        }
    }

    @Override // Interface
    public void chooseAddNewProduct(){
        System.out.println("Kies 1) Nieuwe Product toevoegen of 0) om terug te gaan.");
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
    private static void DetailsInput() {
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

    // Alleen een Medewerker kan nieuwe producten toevoegen.
    private static void addNewProduct(){
        int id;
        DetailsInput();
        userInput = scanner.nextLine();
        // Inserts id by taking the arraylist size and adding +1
        id = ProductData.ProductenLijst.size() + 1; //increment number
        Product newProduct = new Product(id, productNaam.toLowerCase(), productPrijs, productAantal);
        productLoop(newProduct);
    }

    /// TODO: MOET NOG GEDAAN (Wijzgigen van Producten)
    // Alleen een Medewerker kan producten wijzigen.
    public void wijzigProduct(){
        int id;
        DetailsInput();
        userInput = scanner.nextLine();
        // Inserts id by taking the arraylist size and adding +1
        id = ProductData.ProductenLijst.size() + 1; //increment number
        Product newProduct = new Product(id, productNaam.toLowerCase(), productPrijs, productAantal);
        productLoop(newProduct);
    }
}