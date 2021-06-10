import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;

public class LoginController {
    private final Scanner scanner = new Scanner(in);

    // user inputs
    public String userChoice;
    public int currentUserID;
    public String targetUserName;
    public String targetPassword;

    // Controle checks
    public boolean userPassCheck = false;
    public boolean isMedewerker = false;

    // Get gegevens van current user (saves for use)
    public String username;
    private String password;
    public String naam;
    public String achternaam;
    public String telefoonnummer;
    public String email;

    // Singleton
    private static LoginController singleton;
    private final Gebruiker loggedInUser;
    private final Medewerker loggedInMedewerker;

    private LoginController(){
        loggedInUser = null;
        loggedInMedewerker = null;
    }

    public static LoginController getInstance(){
        if (singleton == null) {
            singleton = new LoginController();
        }
        return singleton;
    }

    private boolean userIsAuthenticated() {
        return loggedInUser != null & loggedInMedewerker != null;
    }

    public boolean isAuthenticated(){
        if (userIsAuthenticated()) {
            return true;
        } else {
            Login();
        }
        return true;
    }

    private void Login() {
        System.out.println("Wilt u: 1) inloggen of 2) registreren | 0) Exit Application");
        userChoice = scanner.nextLine();
        switch (userChoice)
        {
            case "0" -> exit(0);
            case "1" -> LoginControle();
            case "2" -> RegistratieController.getInstance().isAuthenticated();
            default -> {
                System.out.println(">>> " + userChoice + " bestaat niet, probeer opnieuw...");
                LoginControle();
            }
        }
        if (!userPassCheck){
            System.out.println("---> login mislukt!");
            System.out.println("Probeer het opnieuw... \n");
            Login();
        }
    }

    private void LoginControle(){
        System.out.println("Bent u 1) Gebruiker of 2) Medewerker? --> 0) om terug te gaan.");
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1" -> {
                System.out.println("Gebruiker gekozen...");
                if (inputInfo()) {
                    GebruikersDataLoop();
                }
            } case "2" -> {
                System.out.println("Medewerker gekozen...");
                if (inputInfo()) {
                    MedewerkersDataLoop();
                }
            } case "0" -> {
                System.out.println("Terug naar beginscherm...\n");
                Login();
            } default -> {
                System.out.println(userInput + " bestaat niet, probeer opnieuw...");
                Login();
            }
        }
    }

    private void GebruikersDataLoop(){
        for (int i = 0; i < GebruikersData.GebruikersLijst.size(); i++) {
            username = GebruikersData.GebruikersLijst.get(i).getGebruikersnaam();
            password = GebruikersData.GebruikersLijst.get(i).getWachtwoord();
            currentUserID = GebruikersData.GebruikersLijst.get(i).getId();
            naam = GebruikersData.GebruikersLijst.get(i).getNaam();
            achternaam = GebruikersData.GebruikersLijst.get(i).getAchternaam();
            telefoonnummer = GebruikersData.GebruikersLijst.get(i).getTelefoonnummer();
            email = GebruikersData.GebruikersLijst.get(i).getEmail();
            if (userAndPassCheck()) {
                isMedewerker = false;
                return;
            }
        }
    }

    private void MedewerkersDataLoop(){
        for (int i = 0; i < MedewerkersData.MedewerkersLijst.size(); i++) {
            username = MedewerkersData.MedewerkersLijst.get(i).getGebruikersnaam();
            password = MedewerkersData.MedewerkersLijst.get(i).getWachtwoord();
            currentUserID = MedewerkersData.MedewerkersLijst.get(i).getId();
            naam = MedewerkersData.MedewerkersLijst.get(i).getNaam();
            achternaam = MedewerkersData.MedewerkersLijst.get(i).getAchternaam();
            telefoonnummer = MedewerkersData.MedewerkersLijst.get(i).getTelefoonnummer();
            email = MedewerkersData.MedewerkersLijst.get(i).getEmail();
            if (userAndPassCheck()) {
                isMedewerker = true;
                return;
            }
        }
    }

    private boolean inputInfo() {
        System.out.println("Gebruikersnaam:");
        targetUserName = scanner.nextLine();
        System.out.println("Wachtwoord:");
        targetPassword = scanner.nextLine();
        return true;
    }

    private boolean userAndPassCheck() {
        if (targetUserName.equals(username) && targetPassword.equals(password)) {
            System.out.println(">>> login geslaagd!");
            System.out.println("\nHallo, " + naam + " " + achternaam);
            userPassCheck = true;
        } else if (!targetUserName.equals(username) && !targetPassword.equals(password)){
            userPassCheck = false;
        } else {
            System.out.println("Fout probeer opnieuw...\n");
            userPassCheck = false;
        }
        return userPassCheck;
    }
}