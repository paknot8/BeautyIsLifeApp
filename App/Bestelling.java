import java.util.Scanner;
import static java.lang.System.in;

public class Bestelling{
    private static final Scanner s = new Scanner(in);
    private static String userInput;
    private static int userInputAantalBesteld;

    private static int tempProductID;
    private static String tempProductNaam;
    private static double tempProductPrijs;
    private static int tempProductVoorraad;

    private static int newVoorraad;

    private final int bestelNummer;
    private final int aantalProducten;
    private final int prijs;

    public Bestelling(int bestelNummer, int aantalProducten, int prijs) {
        this.bestelNummer = bestelNummer;
        this.aantalProducten = aantalProducten;
        this.prijs = prijs;
    }

    public static void VraagBestellingPlaatsen(){
        System.out.println("Wilt u een bestelling plaatsen? (1) ja / (0) nee");
        userInput = s.nextLine();
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
        userInput = s.nextLine();
        System.out.println("Vul aantal bestellingen:");
        userInputAantalBesteld = s.nextInt();

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
        if(aantalProducten > 3 && aantalProducten < 10){
            return (aantalProducten * (prijs - 0.15));
        } else if(aantalProducten > 10 && aantalProducten < 100) {
            return (aantalProducten * (prijs - 0.20));
        } else if(aantalProducten > 100) {
            return (aantalProducten * (prijs - 0.25));
        } else {
            return (aantalProducten * prijs);
        }
    }
}