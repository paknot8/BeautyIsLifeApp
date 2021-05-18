import java.util.Scanner;
import static java.lang.System.in;

public class Bestelling{
    private static final Scanner s = new Scanner(in);
    private static int userInputAantalBesteld;
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

    public static void replaceVoorraad(){
        System.out.println("Vul product naam in:");
        String userInput = s.nextLine();
        System.out.println("Vul aantal bestellingen:");
        userInputAantalBesteld = s.nextInt();

        for (int i = 0; i < ProductData.ProductenLijst.size(); i++) {
            String tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam();
            tempProductVoorraad = ProductData.ProductenLijst.get(i).getProductVoorraad();
            int tempProductID = ProductData.ProductenLijst.get(i).getProductId();

            if(tempProductNaam.equals(userInput)){
                newVoorraadBerekenen();
                Product product = new Product(tempProductID, tempProductNaam,newVoorraad);
                ProductData.ProductenLijst.set(tempProductID -1,product); // Omdat id begint met 1, -1 voor de juiste stappen van de index
                System.out.println(ProductData.productenLijst.getProductId() + " " + ProductData.productenLijst.getProductNaam() + " " + ProductData.productenLijst.getProductVoorraad());
                return;
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