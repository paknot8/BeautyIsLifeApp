import java.util.Scanner;
import static java.lang.System.in;

public class Bestelling{
    private static final Scanner scanner = new Scanner(in);
    private static String userInput;
    private static int userInputAantalBesteld;
    private static int tempProductID;
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

    public static void getMijnBestellingen(){
        for(Bestelling bestelling : BestellingsData.BestellingsLijst) {
            if(bestelling.getUserID() == LoginController.currentUserID){
                System.out.println("Bestelnr: " + bestelling.getBestelNummer() + " | Gebruikerid: " + bestelling.getUserID() +
                        " | Product: " + bestelling.getProductNaam() + " | Aantal: " + bestelling.getAantalGekocht() +
                        " | Prijs: €" + bestelling.getPrijsBetaald());
            }
        }
    }

    public static void VraagBestellingPlaatsen(){
        System.out.println("Wilt u een bestelling plaatsen? (1) ja / (0) nee");
        userInput = scanner.nextLine();
        if(userInput.equals("1")){
            bestellingPlaatsen();
        } else if(userInput.equals("0")) {
            System.out.println("Terug naar Keuze Menu...\n");
            KeuzeMenu.MenuKeuze();
        } else {
            System.out.println("Keuze bestaat niet, probeer opnieuw...\n");
            VraagBestellingPlaatsen();
        }
    }

    // Bestelling geplaats, voorraad wordt gewijzigd.
    public static void bestellingPlaatsen(){
        System.out.println("Vul product naam in:");
        userInput = scanner.nextLine();
        System.out.println("Vul aantal bestellingen:");
        userInputAantalBesteld = scanner.nextInt();

        for (int i = 0; i < ProductData.ProductenLijst.size(); i++) {
            tempProductID = ProductData.ProductenLijst.get(i).getProductId();
            tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam();
            tempProductPrijs = ProductData.ProductenLijst.get(i).getProductPrijs();
            tempProductVoorraad = ProductData.ProductenLijst.get(i).getProductVoorraad();

            if(tempProductNaam.equals(userInput)){
                newVoorraadBerekenen();
                Product product = new Product(tempProductID, tempProductNaam,tempProductPrijs,newVoorraad);
                ProductData.ProductenLijst.set(i,product); // i is de index
                ProductController.getAllProducten();
                KeuzeMenu.MenuKeuze();
            }
        }
    }

    // aantal bestelde producten min voorraad
    public static void newVoorraadBerekenen(){
        if(tempProductVoorraad > 0) {
            newVoorraad = tempProductVoorraad - userInputAantalBesteld;
        } else {
            System.out.println("Product niet op voorraad.");
        }
    }

    public double kortingOpTotaalAantalProducten(){
        if(userInputAantalBesteld > 3 && userInputAantalBesteld < 10){
            return (userInputAantalBesteld * (tempProductPrijs - 0.15));
        } else if(userInputAantalBesteld > 10 && userInputAantalBesteld < 100) {
            return (userInputAantalBesteld * (tempProductPrijs - 0.20));
        } else if(userInputAantalBesteld > 100) {
            return (userInputAantalBesteld * (tempProductPrijs - 0.25));
        } else {
            return (userInputAantalBesteld * tempProductPrijs);
        }
    }
}