import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class Gebruiker extends Persoon{
    private static final Scanner scanner = new Scanner(in);

    // Berichten
    public static String onderwerp;
    public static String beschrijving;
    public static String email;

    public static PrivatePrivateMessage newBericht;
    public static Email newEmail;

    public Gebruiker(int id, String naam, String achternaam, String telefoonnummer, String email, String gebruikersnaam, String wachtwoord) {
        super(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);
    }

    public Gebruiker(){}

    /// TODO: Gebruiker moet dit nog kunnen wijzigen
    public void mijnProfiel(){
        out.println("--- Mijn Profiel ---");
        out.println("ID nummer       | " + LoginController.getInstance().currentUserID);
        out.println("Gebruikersnaam  | " + LoginController.getInstance().targetUserName);
        out.println("Voornaam        | " + LoginController.getInstance().naam);
        out.println("Achternaam      | " + LoginController.getInstance().achternaam);
        out.println("Telefoonnummer  | " + LoginController.getInstance().telefoonnummer);
        out.println("Emailadres      | " + LoginController.getInstance().email);
    }

    public void ContactInvoer(){
        System.out.println("Wat is het onderwerp:");
        onderwerp = scanner.nextLine();
        System.out.println("Beschrijf het probleem:");
        beschrijving = scanner.nextLine();
    }

    private void ContactDetails(String keuze){
        switch (keuze) {
            case "1" -> ContactInvoer();
            case "2" -> {
                ContactInvoer();
                email = scanner.nextLine();
            }
            default -> ContactDetails(keuze);
        }
    }

    public void Contact(){
        int id;
        System.out.println("--- Contact nemen met de klantenservice ---");
        System.out.println("Wilt u een 1) Bericht of een 2) Email sturen?");
        String userInput = scanner.nextLine();
        ContactDetails(userInput);
        switch (userInput) {
            case "1" -> {
                id = BerichtenData.PrivatemessageLijst.size() + 1; //increment number
                newBericht = new PrivatePrivateMessage(id, LoginController.getInstance().currentUserID, onderwerp, beschrijving);
                newBericht.addBericht(newBericht);
            }
            case "2" -> {
                id = BerichtenData.EmailLijst.size() + 1; //increment number
                newEmail = new Email(id, LoginController.getInstance().currentUserID, onderwerp, beschrijving, email);
                newEmail.addEmail(newEmail);
            }
            default -> {
                out.println("Bestaat niet, terug naar Menu");
                KeuzeMenu.MenuKeuze();
            }
        }
    }

    @Override
    public void getBestellingen(){
        for(Bestelling bestelling : BestellingsData.BestellingsLijst) {
            if(bestelling.getUserID() == LoginController.getInstance().currentUserID){
                System.out.println("Bestelnr: " + bestelling.getBestelNummer() + " | Gebruikerid: " + bestelling.getUserID() +
                        " | Product: " + bestelling.getProductNaam() + " | Aantal: " + bestelling.getAantalGekocht() +
                        " | Prijs: €" + bestelling.getPrijsBetaald());
            }
        }
    }

    @Override
    public void getBerichten() {
        out.println("--- Mijn Berichten ---");
        for(Bericht bericht : BerichtenData.PrivatemessageLijst) {
            if(bericht.getUserID() == LoginController.getInstance().currentUserID){
                System.out.println("Berichtnr: " + bericht.getId() + " | Gebruikerid: " + bericht.getUserID() +
                        " | Onderwerp: " + bericht.getOnderwerp() + " | Beschrijving: " + bericht.getBeschrijving());
            }
        }
        getEmails();
    }

    public void getEmails(){
        out.println("--- Mijn Emails ---");
        for(Email email : BerichtenData.EmailLijst) {
            if(email.getUserID() == LoginController.getInstance().currentUserID){
                System.out.println("Emailnr: " + email.getId() + " | Gebruikerid: " + email.getUserID() +
                        " | Onderwerp: " + email.getOnderwerp() + " | Beschrijving: " + email.getBeschrijving());
            }
        }
    }
}