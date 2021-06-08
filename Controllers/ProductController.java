import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

// Interface Segregation
// Seperatie gedaan tussen Medewerker methods en General Methods
// Zo klein mogelijk de interface implementeren, zodat je weinig veranderingen hoeft te doen.
// voor uitbreidingen voor de toekomst.
public class ProductController implements IProductMedewerkerControls, IProduct {
    private static final Scanner scanner = new Scanner(in);
    private static String userInput;
    private static boolean succesControl = false;

    public static String productNaam;
    public static double productPrijs;
    public static int productAantal;

    public static int tempProductID;
    public static String tempProductNaam;
    public static double tempProductPrijs;
    public static int tempProductAantal;

    public static ArrayList<String> tempSearchedList = new ArrayList<>() {};

    @Override
    public void controleProductExist(){
        if (tempProductNaam.equals(userInput)) {
            out.println("Het gezochte product: ( " + userInput + " ) is gevonden!");
            out.println("Productnr: " + tempProductID + " | Product: " + tempProductNaam +
                    " | Prijs " + tempProductPrijs + " | Aantal op voorraad: " + tempProductAantal);
            if(!LoginController.getInstance().isMedewerker) {
                Bestelling.gezochteProductBestellingPlaatsen(userInput); // Vraagt of gebruiker wilt bestellen ja of nee
            }
        }
    }

    @Override
    public void zoekProduct(){
        System.out.println("Productnaam :");
        userInput = scanner.nextLine();
        for (int i = 0; i < ProductData.ProductenLijst.size(); i++) {
            tempProductID = ProductData.ProductenLijst.get(i).getProductId();
            tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam();
            tempProductPrijs = ProductData.ProductenLijst.get(i).getProductPrijs();
            tempProductAantal = ProductData.ProductenLijst.get(i).getProductVoorraad();
            tempSearchedList.add(tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam());
            controleProductExist();
        }
        if(!tempSearchedList.contains(userInput)) {
            out.println("Het gezochte product: ( " + userInput + " ) is niet gevonden, probeer het nogmaals...\n");
            zoekProduct();
        }
    }

    @Override // Get all data from list
    public void getProducten() {
        for (Product product : ProductData.ProductenLijst) {
            System.out.println("Productnr: " + product.getProductId() + " | Product: " + product.getProductNaam() +
                    " | Prijs: " + product.getProductPrijs() + " | Op voorraad: " + product.getProductVoorraad());
        }
    }

    @Override
    public void wijzigProduct(){
        System.out.println("--- Product wijzigen: ---");
        DetailsInput();
        for (int i = 0; i < ProductData.ProductenLijst.size(); i++) {
            tempProductID = ProductData.ProductenLijst.get(i).getProductId();
            tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam();
            tempProductPrijs = ProductData.ProductenLijst.get(i).getProductPrijs();
            tempProductAantal = ProductData.ProductenLijst.get(i).getProductVoorraad();
            if (tempProductNaam.equals(productNaam)) {
                Product wijzigProduct = new Product(i+1, productNaam.toLowerCase(), productPrijs, productAantal);
                ProductData.ProductenLijst.set(i,wijzigProduct); // i is de index, waar het product wordt gewijzigd
                System.out.println("Product succesvol gewijzigd in de maggazijn.");
                succesControl = true;
                break;
            } else {
                succesControl = false;
            }
        }
        if(!succesControl){
            System.out.println("Niet succesvol, probeer nogmaals...\n");
        }
    }

    @Override
    public void verwijderProduct(){
        System.out.println("Voer productnaam in om te verwijderen:");
        productNaam = scanner.nextLine();
        for (int i = 0; i < ProductData.ProductenLijst.size(); i++) {
            tempProductID = ProductData.ProductenLijst.get(i).getProductId();
            tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam();
            tempProductPrijs = ProductData.ProductenLijst.get(i).getProductPrijs();
            tempProductAantal = ProductData.ProductenLijst.get(i).getProductVoorraad();

            if (tempProductNaam.equals(productNaam)){
                ProductData.ProductenLijst.remove(i);
                System.out.println("Product succesvol verwijderd van de maggazijn.");
                System.out.println("ID: " + tempProductID + " | Productnaam: " + tempProductNaam + " | Prijs: " +
                        tempProductPrijs + " | Aantal: " + tempProductAantal);
                succesControl = true;
                break;
            } else {
                succesControl = false;
            }
        }
        if(!succesControl){
            System.out.println("Niet succesvol, product bestaat niet, probeer nogmaals...");
            verwijderProduct();
        }
    }

    @Override
    public void addProduct(){
        System.out.println("Kies 1) Nieuwe Product toevoegen of 0) om terug te gaan.");
        userInput = scanner.nextLine();
        switch (userInput) {
            case "0" -> insertProduct();
            case "1" -> {
                System.out.println("Terug gaan naar Hoofdmenu...\n");
                KeuzeMenu.MenuKeuze_Medewerker();
            }
            default -> {
                System.out.println("Probeer opnieuw...\n");
                addProduct();
            }
        }
    }

    // Input voor de producten
    private static void DetailsInput() {
        boolean isNumeric = false;
        while(!isNumeric){ // Controle of het cijfers zijn.
            try {
                System.out.println("Productnaam: ");
                productNaam = scanner.nextLine();
                System.out.println("Prijs: ");
                productPrijs = scanner.nextDouble();
                System.out.println("Aantal: ");
                productAantal = scanner.nextInt();
                scanner.nextLine();
                isNumeric = true;
            } catch(InputMismatchException ime) {
                System.out.println("Invoer mag alleen cijfers bevatten, begin opnieuw.");
                scanner.nextLine();
            }
        }
    }

    // extract method gebruik voor duplicate code and long methods
    // Toevoegen van new producten
    private static void productLoop(Product newProduct) {
        for (int i = 0; i < ProductData.ProductenLijst.size(); i++) {
            tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam();
            tempProductPrijs = ProductData.ProductenLijst.get(i).getProductPrijs();
            tempProductAantal = ProductData.ProductenLijst.get(i).getProductVoorraad();

            if (productNaam.equals(tempProductNaam)) {
                System.out.println("Product bestaat al, vul een nieuw product in! \n");
                insertProduct();
            } else {
                ProductData.ProductenLijst.add(newProduct);
                System.out.println("Nieuwe product is succesvol toegevoegd in de maggazijn.\n");
                break;
            }
        }
    }

    // Product toevoegen
    private static void insertProduct(){
        DetailsInput();
        userInput = scanner.nextLine();
        int id = ProductData.ProductenLijst.size() + 1; //increment number
        Product newProduct = new Product(id, productNaam.toLowerCase(), productPrijs, productAantal);
        productLoop(newProduct);
    }
}