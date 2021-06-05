import java.util.Scanner;
import static java.lang.System.in;

public class RegistratieController {
    private static final Scanner scanner = new Scanner(in);
    private static int id;
    private static String naam;
    private static String achternaam;
    private static String telefoonnummer;
    private static String email;
    private static String gebruikersnaam;
    private static String wachtwoord;
    private static String tempUser;

    private static void Details() {
        System.out.println("Voer uw gegevens in...");
        System.out.println("naam: ");               naam = scanner.nextLine();
        System.out.println("achternaam: ");         achternaam = scanner.nextLine();
        System.out.println("wachtwoord: ");         telefoonnummer = scanner.nextLine();
        System.out.println("email: ");              email = scanner.nextLine();
        System.out.println("gebruikersnaam: ");     gebruikersnaam = scanner.nextLine();
        System.out.println("wachtwoord: ");         wachtwoord = scanner.nextLine();
    }

    public static void Registration() {
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
        Gebruiker.addNewGebruiker(newGebruiker);
        for (int i = 0; i < GebruikersData.GebruikersLijst.size(); i++) {
            tempUser = GebruikersData.GebruikersLijst.get(i).getGebruikersnaam();
            LoginController.currentUserID = GebruikersData.GebruikersLijst.get(i).getId();
            userCheckExist();
        }
    }

    private static void MedewerkersDataLoop(){
        id = MedewerkersData.MedewerkersLijst.size() + 1;
        Medewerker newMedewerker = new Medewerker(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);
        MedewerkersData.MedewerkersLijst.add(newMedewerker);
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
}