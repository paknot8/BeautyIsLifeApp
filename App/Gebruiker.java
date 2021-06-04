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
}