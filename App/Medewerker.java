import java.util.Scanner;
import static java.lang.System.in;

public class Medewerker extends Persoon {
    private static final Scanner scanner = new Scanner(in);
    private static String userInput;

    public Medewerker(int id, String naam, String achternaam, String telefoonnummer, String email, String gebruikersnaam, String wachtwoord) {
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

    public static void getAllBerichten() {
        for (Bericht bericht : BerichtenData.BerichtenLijst)
        {
            System.out.println("Berichtnr: " + bericht.getId() + " | Gebruikerid: " + bericht.getUserID() +
                    " | Onderwerp: " + bericht.getOnderwerp() + " | Beschrijving: " + bericht.getBeschrijving());
        }
    }

    public static void addNewMedewerker(Medewerker newMedewerker){ MedewerkersData.MedewerkersLijst.add(newMedewerker); }
}