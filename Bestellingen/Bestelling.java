import java.util.Scanner;
import static java.lang.System.in;

public class Bestelling{
    private static final Scanner scanner = new Scanner(in);
    private static String userInput;
    private static int userInputAantalBesteld;
    private static String tempProductNaam;
    private static double tempProductPrijs;
    private static int tempProductVoorraad;
    private static int newVoorraad;

    // Constructor Data
    private final int bestelNummer;
    private final int userID;
    private final String productNaam;
    private final int aantalGekocht;
    private final double prijsBetaald;

    public Bestelling(int bestelNummer, int userID, String productNaam, int aantalGekocht, double prijsBetaald) {
        this.bestelNummer = bestelNummer;
        this.userID = userID;
        this.productNaam = productNaam;
        this.aantalGekocht = aantalGekocht;
        this.prijsBetaald = prijsBetaald;
    }

    public int getBestelNummer() { return bestelNummer; }
    public int getUserID() { return userID; }
    public String getProductNaam() { return productNaam; }
    public int getAantalGekocht() { return aantalGekocht; }
    public double getPrijsBetaald() { return prijsBetaald; }

    public static void VraagBestellingPlaatsen(){
        System.out.println("Wilt u een bestelling plaatsen? (1) ja / (0) nee");
        userInput = scanner.nextLine();
        if(userInput.equals("1")){
            bestellingPlaatsen();
        } else if(userInput.equals("0")) {
            System.out.println("Terug naar Keuze Menu...\n");
            KeuzeMenu.MenuKeuze();
        } else {
            System.out.println("Foutieve invoer, probeer het nogmaals...");
            VraagBestellingPlaatsen();
        }
    }

    public static void gezochteProductBestellingPlaatsen(){
        System.out.println("Wilt u " + Gebruiker.tempProductNaam + " bestellen? 1) ja 0) nee");
        userInput = scanner.nextLine();
        if(userInput.equals("1")){
            System.out.println("Hoeveel wilt u van " + Gebruiker.tempProductNaam + " bestellen?");
            userInput = Gebruiker.tempProductNaam;
            userInputAantalBesteld = scanner.nextInt();
            loopProductenLijst();
        } else if(userInput.equals("0")) {
            System.out.println("Terug gaan naar Menu...");
            KeuzeMenu.MenuKeuze();
        } else {
            System.out.println("Foutieve invoer, probeer opnieuw...");
            gezochteProductBestellingPlaatsen();
        }
    }

    // Bestelling geplaats, voorraad wordt gewijzigd.
    public static void bestellingPlaatsen(){
        System.out.println("Vul productnaam in:");
        userInput = scanner.nextLine();
        System.out.println("Vul aantal bestellingen:");
        userInputAantalBesteld = scanner.nextInt();
        loopProductenLijst();
    }

    // Door de lijst van producten gaan
    public static void loopProductenLijst(){
        for (int i = 0; i < ProductData.ProductenLijst.size(); i++) {
            int tempProductID = ProductData.ProductenLijst.get(i).getProductId();
            tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam();
            tempProductPrijs = ProductData.ProductenLijst.get(i).getProductPrijs();
            tempProductVoorraad = ProductData.ProductenLijst.get(i).getProductVoorraad();

            if(tempProductNaam.equals(userInput)){
                newVoorraadBerekenen(); // bereken de nieuwe voorraad (oud voorraad - aantal besteld = new vooraad)
                Product product = new Product(tempProductID, tempProductNaam,tempProductPrijs,newVoorraad);
                ProductData.ProductenLijst.set(i,product); // i is de index, waar het product wordt gewijzigd
                addToMijnBestelLijst(); // Voegt in mijn bestellijst
            }
        }
    }

    public static void addToMijnBestelLijst(){
        int incrementedID = BestellingsData.BestellingsLijst.size() + 1;
        Bestelling bestelling = new Bestelling(incrementedID,LoginController.currentUserID,tempProductNaam,
                userInputAantalBesteld, Korting.kortingOpTotaalAantalProducten(userInputAantalBesteld,tempProductPrijs));
        PaymentProcessor.betaalMethod();
        BestellingsData.BestellingsLijst.add(bestelling);
    }

    // aantal bestelde producten min voorraad
    public static void newVoorraadBerekenen(){
        if(tempProductVoorraad > 0){
            newVoorraad = tempProductVoorraad - userInputAantalBesteld;
            if(newVoorraad < 0){
                System.out.println(">>> Het aantal dat u wilt bestellen hebben wij niet op voorraad, voer een ander aantal in.");
                System.out.println("Vul aantal bestellingen:");
                userInputAantalBesteld = scanner.nextInt();
                newVoorraadBerekenen();
            }
        } else {
            System.out.println("Product niet op voorraad.");
        }
    }
}