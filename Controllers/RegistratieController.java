import java.util.Scanner;
import static java.lang.System.in;

public class RegistratieController {
    private static final Scanner scanner = new Scanner(in);
    private static String tempUser;

    // User details
    private static int id;
    private static String gebruikersnaam;
    private static String wachtwoord;
    private static String naam;
    private static String achternaam;
    private static String telefoonnummer;
    private static String email;

    // Singleton
    private static RegistratieController singleton;
    private final Gebruiker registeredUser;
    private final Medewerker registeredMedewerker;

    private RegistratieController(){
        registeredUser = null;
        registeredMedewerker = null;
    }

    public static RegistratieController getInstance(){
        if (singleton == null) {
            singleton = new RegistratieController();
        }
        return singleton;
    }

    private boolean userIsAuthenticated() { return registeredUser != null & registeredMedewerker != null; }

    public void isAuthenticated(){
        if (!userIsAuthenticated()){
            Registration();
        }
    }

    private static void Registration() {
        System.out.println("Maak een keuze...");
        System.out.println("1) Gebruiker, 2) Medewerker");
        String userInput = scanner.nextLine();
        if (userInput.equals("1")) {
            Details();
            GebruikersDataLoop();
        } else if (userInput.equals("2")) {
            Details();
            MedewerkersDataLoop();
        }
    }

    private static void GebruikersDataLoop(){
        id = GebruikersData.GebruikersLijst.size() + 1; //increment number
        Gebruiker newGebruiker = new Gebruiker(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);
        Medewerker.addNewGebruiker(newGebruiker);
        for (int i = 0; i < GebruikersData.GebruikersLijst.size(); i++) {
            tempUser = GebruikersData.GebruikersLijst.get(i).getGebruikersnaam();
            LoginController.currentUserID = GebruikersData.GebruikersLijst.get(i).getId();
            userCheckExist();
        }
    }

    private static void MedewerkersDataLoop(){
        id = MedewerkersData.MedewerkersLijst.size() + 1;
        Medewerker newMedewerker = new Medewerker(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);
        Medewerker.addNewMedewerker(newMedewerker);
        for (int i = 0; i < MedewerkersData.MedewerkersLijst.size(); i++) {
            tempUser = MedewerkersData.MedewerkersLijst.get(i).getGebruikersnaam();
            LoginController.currentUserID = MedewerkersData.MedewerkersLijst.get(i).getId();
            userCheckExist();
        }
    }

    private static void userCheckExist(){
        if (!gebruikersnaam.equals(tempUser)) {
            System.out.println("U bent nu geregistreerd!");
            LoginController.userPassCheck = true;
            KeuzeMenu.LoginScherm();
        } else {
            System.out.println("Gebruikersnaam: " + gebruikersnaam + " bestaat al!, probeer opnieuw...");
            Registration();
        }
    }

    private static void Details() {
        System.out.println("Voer uw gegevens in...");
        System.out.println("gebruikersnaam: ");     gebruikersnaam = scanner.nextLine();
        System.out.println("wachtwoord: ");         wachtwoord = scanner.nextLine();
        System.out.println("naam: ");               naam = scanner.nextLine();
        System.out.println("achternaam: ");         achternaam = scanner.nextLine();
        System.out.println("telefoonnummer: ");     telefoonnummer = scanner.nextLine();
        System.out.println("email: ");              email = scanner.nextLine();
    }
}