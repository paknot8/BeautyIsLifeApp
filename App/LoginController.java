import java.util.Scanner;
import static java.lang.System.in;

public class LoginController {
    private static final Scanner scanner = new Scanner(in);
    public static int currentUserID;
    public static String targetUserName;
    public static String targetPassword;
    public static String userChoice;
    public static Boolean correct;
    public static Boolean userPassCheck = false;
    public static Boolean isMedewerker = false;

    // Get gegevens van current user (saves for use)
    public static String username;
    private static String password;
    public static String naam;
    public static String achternaam;
    public static String telefoonnummer;
    public static String email;

    // Singleton
    private static LoginController singleton;
    private final Gebruiker loggedInUser;

    private LoginController(){
        loggedInUser = null;
    }

    public static LoginController getInstance(){
        if (singleton == null) {
            singleton = new LoginController ();
        }
        return singleton;
    }

    private boolean userIsAuthenticated() {
        return loggedInUser != null;
    }

    public boolean isAuthenticated(){
        if (userIsAuthenticated()) {
            return true;
        } else {
            chooseLogin();
        }
        return true;
    }

    private static void chooseLogin() {
        System.out.println("Wilt u: 1) inloggen of 2) registreren");
        userChoice = scanner.nextLine();
        switch (userChoice)
        {
            case "1" -> LoginControle();
            case "2" -> RegistratieController.Registration();
            default -> {
                System.out.println(">>> " + userChoice + " bestaat niet, probeer opnieuw...");
                LoginControle();
            }
        }
        if (!userPassCheck){
            System.out.println("---> login mislukt!");
            System.out.println("Probeer het opnieuw... \n");
            chooseLogin();
        }
    }

    private static void LoginControle(){
        System.out.println("Bent u 1) Gebruiker of 2) Medewerker? --> 0) om terug te gaan.");
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1" -> {
                System.out.println("Gebruiker gekozen...");
                if (inputInfo()) {
                    GebruikersDataLoop();
                }
            }
            case "2" -> {
                System.out.println("Medewerker gekozen...");
                if (inputInfo()) {
                    MedewerkersDataLoop();
                }
            }
            case "0" -> {
                System.out.println("Terug naar beginscherm...\n");
                chooseLogin();
            }
            default -> {
                System.out.println(userInput + " bestaat niet, probeer opnieuw...");
                chooseLogin();
            }
        }
    }

    private static void GebruikersDataLoop(){
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
                correct = true;
                return;
            }
        }
    }

    private static void MedewerkersDataLoop(){
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
                correct = true;
                return;
            }
        }
    }

    private static boolean inputInfo() {
        System.out.println("Gebruikersnaam:");
        targetUserName = scanner.nextLine();
        System.out.println("Wachtwoord:");
        targetPassword = scanner.nextLine();
        return true;
    }

    private static boolean userAndPassCheck() {
        if (targetUserName.equals(username) && targetPassword.equals(password)) {
            System.out.println(">>> login geslaagd!");
            System.out.println("\nHallo, " + naam + " " + achternaam);
            userPassCheck = true;
        } else if (!targetUserName.equals(username) && !targetPassword.equals(password)){
            userPassCheck = false;
            correct = false;
        } else {
            System.out.println("Fout probeer opnieuw...\n");
            userPassCheck = false;
            correct = false;
        }
        return userPassCheck;
    }
}