import static java.lang.System.exit;

public class LoginController {
    // Controle checks
    public boolean userPassCheck = false;

    // Get gegevens van current user (saves for use)
    public int id;
    public String username;
    public String password;
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
        TempField.userInput = TempField.scanner.nextLine();
        switch (TempField.userInput)
        {
            case "0" -> exit(0);
            case "1" -> LoginControle();
            case "2" -> RegistratieController.getInstance().isAuthenticated();
            default -> {
                System.out.println(">>> " + TempField.userInput + " bestaat niet, probeer opnieuw...");
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
        TempField.userInput = TempField.scanner.nextLine();
        switch (TempField.userInput) {
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
                System.out.println(TempField.userInput + " bestaat niet, probeer opnieuw...");
                Login();
            }
        }
    }

    private void GebruikersDataLoop(){
        for (int i = 0; i < GebruikersData.GebruikersLijst.size(); i++) {
            TempField.currentUserID = GebruikersData.GebruikersLijst.get(i).getId();
            id = GebruikersData.GebruikersLijst.get(i).getId();
            username = GebruikersData.GebruikersLijst.get(i).userAccount.getGebruikersnaam();
            password = GebruikersData.GebruikersLijst.get(i).userAccount.getWachtwoord();
            naam = GebruikersData.GebruikersLijst.get(i).getNaam();
            achternaam = GebruikersData.GebruikersLijst.get(i).getAchternaam();
            telefoonnummer = GebruikersData.GebruikersLijst.get(i).userAccount.getTelefoonnummer();
            email = GebruikersData.GebruikersLijst.get(i).userAccount.getEmail();
            if (userAndPassCheck()) {
                TempField.isMedewerker = false;
                return;
            }
        }
    }

    private void MedewerkersDataLoop(){
        for (int i = 0; i < MedewerkersData.MedewerkersLijst.size(); i++) {
            TempField.currentUserID = MedewerkersData.MedewerkersLijst.get(i).getId();
            id = MedewerkersData.MedewerkersLijst.get(i).getId();
            username = MedewerkersData.MedewerkersLijst.get(i).userAccount.getGebruikersnaam();
            password = MedewerkersData.MedewerkersLijst.get(i).userAccount.getWachtwoord();
            naam = MedewerkersData.MedewerkersLijst.get(i).getNaam();
            achternaam = MedewerkersData.MedewerkersLijst.get(i).getAchternaam();
            telefoonnummer = MedewerkersData.MedewerkersLijst.get(i).userAccount.getTelefoonnummer();
            email = MedewerkersData.MedewerkersLijst.get(i).userAccount.getEmail();
            if (userAndPassCheck()) {
                TempField.isMedewerker = true;
                return;
            }
        }
    }

    private boolean inputInfo() {
        System.out.println("Gebruikersnaam:");
        TempField.targetUserName = TempField.scanner.nextLine();
        System.out.println("Wachtwoord:");
        TempField.targetPassword = TempField.scanner.nextLine();
        return true;
    }

    private boolean userAndPassCheck() {
        if (TempField.targetUserName.equals(username) && TempField.targetPassword.equals(password)) {
            System.out.println(">>> login geslaagd!");
            System.out.println("\nHallo, " + naam + " " + achternaam);
            userPassCheck = true;
        } else if (!TempField.targetUserName.equals(username) && !TempField.targetPassword.equals(password)){
            userPassCheck = false;
        } else {
            System.out.println("Fout probeer opnieuw...\n");
            userPassCheck = false;
        }
        return userPassCheck;
    }
}