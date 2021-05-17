import java.util.Scanner;

import static java.lang.System.in;

public class Bestelling{
    private static final Scanner s = new Scanner(in);

    private Product product;

    private static boolean productVoorraadCheck;
    private static boolean correct;
    public static String userInput;
    public static int userInputAantalBesteld;

    private static int tempProductID;
    private static String tempProductNaam;
    private static int tempProductVoorraad;

    private static int targetProductID;
    private static String targetProductNaam;
    private static int targetProductVoorraad;
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
        userInput = s.nextLine();
        System.out.println("Vul aantal bestellingen:");
        userInputAantalBesteld = s.nextInt();

        for (int i = 0; i < ProductData.ProductenLijst.size(); i++) {
            tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam();
            tempProductVoorraad = ProductData.ProductenLijst.get(i).getProductVoorraad();
            tempProductID = ProductData.ProductenLijst.get(i).getProductId();

            // If gelijk aan de input, verander die voorraad van die rij
            if(tempProductNaam.equals(userInput)){
                System.out.println(tempProductID + " " + tempProductNaam + " " + tempProductVoorraad);

                return;
            } else {
                System.out.println("bestaat niet");
            }
        }

        //ProductData.ProductenLijst.set(1,5);
    }

    public static void newVoorraad(){
        newVoorraad = tempProductVoorraad - userInputAantalBesteld;
    }

   /* public static boolean ProductVoorraadCheck() {
        if (targetProductNaam.equals(tempProductNaam) && targetProductVoorraad == tempProductVoorraad) {
            System.out.println("Product Bestaat");
            productVoorraadCheck = true;
        } else if (!targetProductNaam.equals(tempProductNaam) && targetProductVoorraad != tempProductVoorraad) {
            System.out.println("Product Bestaat niet");
            productVoorraadCheck = false;
        }
        return productVoorraadCheck;
    }*/

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