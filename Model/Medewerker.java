import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Medewerker extends Persoon {
    private static final Scanner scanner = new Scanner(in);
    private static String userInput;

    public static ArrayList<String> tempSearchedList = new ArrayList<>() {};

    public static int tempProductid;
    public static String tempProductNaam;
    public static double tempProductPrijs;
    public static int tempProductVoorraad;

    public Medewerker(int id, String naam, String achternaam, String telefoonnummer, String email, String gebruikersnaam, String wachtwoord) {
        super(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);
    }

    public Medewerker(){}

    public void getGebruikers() {
        for (Gebruiker gebruiker : GebruikersData.GebruikersLijst) {
            System.out.println(gebruiker.getId() + ", " + gebruiker.getGebruikersnaam() +
                    ", " + gebruiker.getNaam() + ", " + gebruiker.getAchternaam() + ", " +
                    gebruiker.getTelefoonnummer() + ", " + gebruiker.getEmail());
        }
    }

    @Override
    public void getBestellingen(){
        for(Bestelling bestelling : BestellingsData.BestellingsLijst) {
                System.out.println("Bestelnr: " + bestelling.getBestelNummer() + " | Gebruikerid: " + bestelling.getUserID() +
                        " | Besteld door: " + LoginController.naam + " " + LoginController.achternaam +
                        " | Product: " + bestelling.getProductNaam() + " | Aantal: " + bestelling.getAantalGekocht() +
                        " | Prijs: €" + bestelling.getPrijsBetaald());
        }
    }

    @Override
    public void getBerichten() {
        for (Bericht bericht : BerichtenData.PrivatemessageLijst) {
            System.out.println("Berichtnr: " + bericht.getId() + " | Gebruikerid: " + bericht.getUserID() +
                    " | Onderwerp: " + bericht.getOnderwerp() + " | Beschrijving: " + bericht.getBeschrijving());
        }
        for (Email email : BerichtenData.EmailLijst) {
            System.out.println("Emailnr: " + email.getId() + " | Gebruikerid: " + email.getUserID() +
                    " | Onderwerp: " + email.getOnderwerp() + " | Beschrijving: " + email.getBeschrijving());
        }
    }

    @Override
    public void controleProductExist(){
        if (tempProductNaam.equals(userInput)) {
            out.println("Het gezochte product: ( " + userInput + " ) is gevonden!");
            out.println("Productnr: " + tempProductid + " | Product: " + tempProductNaam +
                    " | Prijs " + tempProductPrijs + " | Aantal op voorraad: " + tempProductVoorraad);
        }
    }

    @Override
    public void zoekProduct(){
        System.out.println("Vul product in:");
        userInput = scanner.nextLine();
        for (int i = 0; i < ProductData.ProductenLijst.size(); i++) {
            tempProductid = ProductData.ProductenLijst.get(i).getProductId();
            tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam();
            tempProductPrijs = ProductData.ProductenLijst.get(i).getProductPrijs();
            tempProductVoorraad = ProductData.ProductenLijst.get(i).getProductVoorraad();
            tempSearchedList.add(tempProductNaam = ProductData.ProductenLijst.get(i).getProductNaam());
            controleProductExist();
        }
        if(!tempSearchedList.contains(userInput)) {
            out.println("Het gezochte product: ( " + userInput + " ) is niet gevonden, probeer het nogmaals...\n");
            zoekProduct();
        }
    }

    public static void addNewGebruiker(Gebruiker newGebruiker){ GebruikersData.GebruikersLijst.add(newGebruiker); }
    public static void addNewMedewerker(Medewerker newMedewerker){ MedewerkersData.MedewerkersLijst.add(newMedewerker); }
}