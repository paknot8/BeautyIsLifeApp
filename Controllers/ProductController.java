import java.util.ArrayList;
import java.util.InputMismatchException;
import static java.lang.System.out;

// Interface Segregation
// Seperatie gedaan tussen Medewerker methods en General Methods
// Zo klein mogelijk de interface implementeren, zodat je weinig veranderingen hoeft te doen.
// voor uitbreidingen voor de toekomst.
public class ProductController implements IProductMedewerkerControls, IProductZoekFunctie
{
    private int i;
    private String productNaam;
    private double productPrijs;
    private int productAantal;
    private final ArrayList<String> tempSearchedList = new ArrayList<>(){};

    @Override // Get all data from producten ( General Use)
    public void getProducten() {
        for (Product product : ProductData.ProductenLijst) {
            System.out.println("Productnr: " + product.getProductId() + " | Product: " + product.getProductNaam() +
                    " | Prijs: " + product.getProductPrijs() + " | Op voorraad: " + product.getProductVoorraad());
        }
    }

    @Override
    public void controleProductExist(){
        if (TempField.tempProductNaam.equals(TempField.userInput)) {
            out.println("Het gezochte product: ( " + TempField.userInput + " ) is gevonden!");
            out.println("Productnr: " + TempField.tempProductID + " | Product: " + TempField.tempProductNaam +
                    " | Prijs " + TempField.tempProductPrijs + " | Aantal op voorraad: " + TempField.tempProductAantal);
            if(!TempField.isMedewerker) {
                Bestelling.gezochteProductBestellingPlaatsen(TempField.userInput); // Vraagt of gebruiker wilt bestellen ja of nee
            }
        }
    }

    private void productTemporary(){
        TempField.tempProductID = ProductData.ProductenLijst.get(i).getProductId();
        TempField.tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam();
        TempField.tempProductPrijs = ProductData.ProductenLijst.get(i).getProductPrijs();
        TempField.tempProductAantal = ProductData.ProductenLijst.get(i).getProductVoorraad();
    }

    @Override
    public void zoekProduct(){
        System.out.println("Productnaam :");
        TempField.userInput = TempField.scanner.nextLine();
        for (i = 0; i < ProductData.ProductenLijst.size(); i++) {
            productTemporary();
            tempSearchedList.add(TempField.tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam());
            controleProductExist();
        }
        if(!tempSearchedList.contains(TempField.userInput)) {
            out.println("Het gezochte product: ( " + TempField.userInput + " ) is niet gevonden, probeer het nogmaals...\n");
            zoekProduct();
        }
    }

    @Override
    public void wijzigProduct(){
        System.out.println("--- Product wijzigen: ---");
        DetailsInputControle();
        for (i = 0; i < ProductData.ProductenLijst.size(); i++) {
            productTemporary();
            if (TempField.tempProductNaam.equals(productNaam)) {
                Product wijzigProduct = new Product(i+1, productNaam.toLowerCase(), productPrijs, productAantal);
                ProductData.ProductenLijst.set(i,wijzigProduct); // i is de index, waar het product wordt gewijzigd
                System.out.println("Product succesvol gewijzigd in de maggazijn.");
                TempField.succesControl = true;
                break;
            } else {
                TempField.succesControl = false;
            }
        }
        if(!TempField.succesControl){
            System.out.println("Niet succesvol, probeer nogmaals...\n");
        }
    }

    @Override
    public void verwijderProduct(){
        System.out.println("Voer productnaam in om te verwijderen:");
        productNaam = TempField.scanner.nextLine();
        for (i = 0; i < ProductData.ProductenLijst.size(); i++) {
            productTemporary();
            if (TempField.tempProductNaam.equals(productNaam)){
                ProductData.ProductenLijst.remove(i);
                System.out.println("Product succesvol verwijderd van de maggazijn.");
                TempField.succesControl = true;
                break;
            } else {
                TempField.succesControl = false;
            }
        }
        if(!TempField.succesControl){
            System.out.println("Niet succesvol, product bestaat niet, probeer nogmaals...");
            verwijderProduct();
        }
    }

    @Override
    public void addProduct(){
        System.out.println("Kies 1) Nieuwe Product toevoegen of 0) om terug te gaan.");
        TempField.userInput = TempField.scanner.nextLine();
        switch (TempField.userInput) {
            case "1" -> insertProduct();
            case "0" -> {
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
    private void DetailsInputControle() {
        boolean isNumeric = false;
        while(!isNumeric){ // Controle of het cijfers zijn.
            try {
                DetailsInput();
                isNumeric = true;
            } catch(InputMismatchException ime) {
                System.out.println("Invoer mag alleen cijfers bevatten, begin opnieuw.");
                TempField.scanner.nextLine();
            }
        }
    }

    public void DetailsInput(){
        System.out.println("Productnaam: ");
        productNaam = TempField.scanner.nextLine();
        System.out.println("Prijs: ");
        productPrijs = TempField.scanner.nextDouble();
        System.out.println("Aantal: ");
        productAantal = TempField.scanner.nextInt();
        TempField.scanner.nextLine();
    }

    // extract method gebruik voor duplicate code and long methods
    // Toevoegen van new producten
    private void productLoop(Product newProduct) {
        for (int i = 0; i < ProductData.ProductenLijst.size(); i++) {
            TempField.tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam();
            TempField.tempProductPrijs = ProductData.ProductenLijst.get(i).getProductPrijs();
            TempField.tempProductAantal = ProductData.ProductenLijst.get(i).getProductVoorraad();
            if (productNaam.equals(TempField.tempProductNaam)) {
                System.out.println("Product bestaat al, vul een nieuw product in! \n");
                insertProduct();
            } else {
                Medewerker.addNewProduct(newProduct);
                System.out.println("Nieuwe product is succesvol toegevoegd in de maggazijn.\n");
                break;
            }
        }
    }

    // Product toevoegen
    private void insertProduct(){
        DetailsInputControle();
        TempField.userInput = TempField.scanner.nextLine();
        int id = ProductData.ProductenLijst.size() + 1; //increment number
        Product newProduct = new Product(id, productNaam.toLowerCase(), productPrijs, productAantal);
        productLoop(newProduct);
    }
}