import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class Gebruiker extends Persoon{
    private static final Scanner scanner = new Scanner(in);
    public static String onderwerp;
    public static String beschrijving;

    public Gebruiker(int id, String naam, String achternaam, String telefoonnummer,
                     String email, String gebruikersnaam, String wachtwoord) {
        super(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);
    }

    public static void getAllGebruikers() {
        for (Gebruiker gebruiker : GebruikersData.GebruikersLijst)
        {
            System.out.println(gebruiker.getId() + ", " + gebruiker.getGebruikersnaam() +
                    ", " + gebruiker.getNaam() + ", " + gebruiker.getAchternaam() + ", " +
                    gebruiker.getTelefoonnummer() + ", " + gebruiker.getEmail());
        }
    }

    public static void addNewGebruiker(Gebruiker newGebruiker){
        GebruikersData.GebruikersLijst.add(newGebruiker);
    }

    public static void mijnProfiel(){
        out.println("Profiel inzien");
        out.println("ID nummer: " + LoginController.currentUserID);
        out.println("Gebruikersnaam: " + LoginController.tempUser);
        out.println("Naam: " + LoginController.naam);
        out.println("achternaam: " + LoginController.achternaam);
        out.println("telefoonnummer: " + LoginController.telefoonnummer);
        out.println("email: " + LoginController.email);
        out.println("gebruikersnaam: " + LoginController.gebruikersnaam);
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
        int id = MedewerkersData.BerichtenLijst.size() + 1; //increment number
        Bericht newBericht = new Bericht(id,onderwerp,beschrijving);
        Medewerker.addNewBericht(newBericht);
    }
}