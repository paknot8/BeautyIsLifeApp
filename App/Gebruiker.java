import java.util.Scanner;
import static java.lang.System.in;

public class Gebruiker extends Persoon{
    private static final Scanner s = new Scanner(in);
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

    public static void ContactDetails() {
        System.out.println("--- Contact nemen met de klantenservice ---");
        System.out.println("Wat is het onderwerp:");
        onderwerp = s.nextLine();
        System.out.println("Beschrijf het probleem:");
        beschrijving = s.nextLine();
    }

    public static void Contact(){
        ContactDetails();
        int id = MedewerkersData.BerichtenLijst.size() + 1; //increment number
        Bericht newBericht = new Bericht(id,onderwerp,beschrijving);
        Medewerker.addNewBericht(newBericht);
    }
}