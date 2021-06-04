import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class Gebruiker extends Persoon{
    private static final Scanner scanner = new Scanner(in);
    private static String userInput;

    // Berichten
    public static String onderwerp;
    public static String beschrijving;

    // Zoeken naar product
    public static ArrayList<String> tempSearchedList = new ArrayList<>() {};

    public static int tempProductid;
    public static String tempProductNaam;
    public static double tempProductPrijs;
    public static int tempProductVoorraad;

    public Gebruiker(int id, String naam, String achternaam, String telefoonnummer,
                     String email, String gebruikersnaam, String wachtwoord) {
        super(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);
    }

    public static void addNewBericht(Bericht newBericht){ BerichtenData.BerichtenLijst.add(newBericht); }
    public static void addNewGebruiker(Gebruiker newGebruiker){
        GebruikersData.GebruikersLijst.add(newGebruiker);
    }

    public static void mijnProfiel(){
        out.println("--- Mijn Profiel ---");
        out.println("Mijn id nummer: | " + LoginController.currentUserID);
        out.println("Gebruikersnaam: | " + LoginController.tempUser);
        out.println("Voornaam: | " + LoginController.naam);
        out.println("Achternaam: | " + LoginController.achternaam);
        out.println("Telefoonnummer: | " + LoginController.telefoonnummer);
        out.println("Emailadres: | " + LoginController.email);
    }

    public static void ContactDetails() {
        System.out.println("--- Contact nemen met de klantenservice ---");
        System.out.println("Wat is het onderwerp:");
        onderwerp = scanner.nextLine();
        System.out.println("Beschrijf het probleem:");
        beschrijving = scanner.nextLine();
    }

    public static void Contact(){
        ContactDetails();
        int id = BerichtenData.BerichtenLijst.size() + 1; //increment number
        Bericht newBericht = new Bericht(id,LoginController.currentUserID,onderwerp,beschrijving);
        Gebruiker.addNewBericht(newBericht);
    }

    public static void getMijnBerichten(){
        for(Bericht bericht : BerichtenData.BerichtenLijst) {
            if(bericht.getUserID() == LoginController.currentUserID){
                System.out.println("Berichtnr: " + bericht.getId() + " | Gebruikerid: " + bericht.getUserID() +
                        " | Onderwerp: " + bericht.getOnderwerp() + " | Beschrijving: " + bericht.getBeschrijving());
            }
        }
    }
/*

    public static void zoekProduct(){
        System.out.println("Vul product in:");
        userInput = scanner.nextLine();
        for (Product product : ProductData.ProductenLijst){
            out.println(product.getProductNaam());
            tempSearchedList.add(product.getProductNaam());
        }
        if(tempSearchedList.contains(userInput)){
            out.println("Het gezochte product: ( \" + userInput + \" ) is gevonden!\n");
            tempSearchedList.clear();
        } else {
            out.println("Het gezochte product: ( " + userInput + " ) is niet gevonden, probeer het nogmaals...\n");
            tempSearchedList.clear();
            zoekProduct();
        }
    }
*/


    public static void zoekProduct(){
        System.out.println("Vul product in:");
        userInput = scanner.nextLine();
        for (int i = 0; i < ProductData.ProductenLijst.size(); i++) {
            tempProductid = ProductData.ProductenLijst.get(i).getProductId();
            tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam();
            tempProductPrijs = ProductData.ProductenLijst.get(i).getProductPrijs();
            tempProductVoorraad = ProductData.ProductenLijst.get(i).getProductVoorraad();
            if (userInput.equals(tempProductNaam)) {
                out.println("Het gezochte product: ( " + userInput + " ) is gevonden!\n");
                tempSearchedList.clear();
            } else {
                out.println("Het gezochte product: ( " + userInput + " ) is niet gevonden, probeer het nogmaals...\n");
                tempSearchedList.clear();
                zoekProduct();
            }
        }
    }
}