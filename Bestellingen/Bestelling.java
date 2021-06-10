import java.util.InputMismatchException;

public class Bestelling
{
    private static int i;
    public static int newVoorraad;
    public static int userInputAantalBesteld;
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

    // Vragen voor het bestellen
    public static void VraagBestellingPlaatsen(){
        System.out.println("Wilt u een bestelling plaatsen? (1) ja / (0) nee");
        TempField.userInput = TempField.scanner.nextLine();
        switch (TempField.userInput) {
            case "1" -> bestellingPlaatsen();
            case "0" -> {
                System.out.println("Terug naar Keuze Menu...\n");
                KeuzeMenu.MenuKeuze();
            }
            default -> {
                System.out.println("Foutieve invoer, probeer het nogmaals...");
                VraagBestellingPlaatsen();
            }
        }
    }

    // na zoek resultaat bestelling kunnen plaatsen
    public static void gezochteProductBestellingPlaatsen(String productNaam){
        System.out.println("Wilt u " + productNaam + " bestellen? 1) ja 0) nee");
        TempField.userInput = TempField.scanner.nextLine();
        switch (TempField.userInput) {
            case "1" -> {
                System.out.println("Hoeveel wilt u van " + productNaam + " bestellen?");
                TempField.userInput = productNaam;
                userInputAantalBesteld = TempField.scanner.nextInt();
                loopProductenLijst();
            }
            case "0" -> {
                System.out.println("Terug gaan naar Menu...");
                KeuzeMenu.MenuKeuze();
            }
            default -> {
                System.out.println("Foutieve invoer, probeer opnieuw...");
                gezochteProductBestellingPlaatsen(productNaam);
            }
        }
    }

    // Bestelling geplaatst, voorraad wordt gewijzigd.
    private static void bestellingPlaatsen(){
        boolean isNumeric = false;
        while(!isNumeric){ // Controle of het cijfers zijn.
            try {
                System.out.println("Vul productnaam in:");
                TempField.userInput = TempField.scanner.nextLine();
                System.out.println("Vul aantal bestellingen:");
                userInputAantalBesteld = TempField.scanner.nextInt();
                isNumeric = true;
            } catch(InputMismatchException ime) {
                System.out.println("Invoer voor het aantal mag alleen cijfers bevatten, begin opnieuw.");
                TempField.scanner.nextLine();
            }
        }
        loopProductenLijst();
    }

    // Door de lijst van producten gaan
    private static void loopProductenLijst(){
        for (i = 0; i < ProductData.ProductenLijst.size(); i++) {
            int tempProductID = ProductData.ProductenLijst.get(i).getProductId();
            productTemporary();
            if(TempField.tempProductNaam.equals(TempField.userInput)){
                VoorraadBerekenen.newVoorraadBerekenen(); // bereken de nieuwe voorraad (oud voorraad - aantal besteld = new vooraad)
                Product product = new Product(tempProductID, TempField.tempProductNaam,TempField.tempProductPrijs,newVoorraad);
                ProductData.ProductenLijst.set(i,product); // i is de index, waar het product wordt gewijzigd
                addToMijnBestelLijst(); // Voegt in mijn bestellijst
            }
        }
    }

    private static void productTemporary(){
        TempField.tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam();
        TempField.tempProductPrijs = ProductData.ProductenLijst.get(i).getProductPrijs();
        TempField.tempProductVoorraad = ProductData.ProductenLijst.get(i).getProductVoorraad();
    }

    // Voegt in bestellijst toe.
    private static void addToMijnBestelLijst(){
        int incrementedID = BestellingsData.BestellingsLijst.size() + 1;
        Bestelling bestelling = new Bestelling(incrementedID,LoginController.getInstance().id,TempField.tempProductNaam,
                userInputAantalBesteld, Korting.kortingOpTotaalAantalProducten(userInputAantalBesteld,TempField.tempProductPrijs));
        PaymentProcessor.betaalMethode();
        BestellingsData.BestellingsLijst.add(bestelling);
    }
}