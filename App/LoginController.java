import java.util.Scanner;
import static java.lang.System.in;

public class LoginController {
    private static final Scanner scanner = new Scanner(in);
    public static int currentUserID;
    public static String userInput;
    public static String targetUser;
    public static String targetPassword;
    public static String tempUser;
    public static String tempPass;
    public static String userChoice;
    public static Boolean choseLogin;
    public static Boolean correct;
    public static Boolean userPassCheck;
    public static Boolean isMedewerker;

    // Get gegevens van current user (saves for use)
    public static String naam;
    public static String achternaam;
    public static String telefoonnummer;
    public static String email;
    public static String gebruikersnaam;
    //private static String wachtwoord;

    public static boolean chooseLogin() {
        System.out.println("Wilt u: 1) inloggen of 2) registreren");
        userChoice = scanner.nextLine();

        switch (userChoice)
        {
            case "1" -> choseLogin = LoginControle();
            case "2" -> {
                choseLogin = false;
                RegistratieController.Registration();
            }
            default -> {
                System.out.println(">>> " + userChoice + " bestaat niet, probeer opnieuw...");
                chooseLogin();
            }
        }
        if (!userPassCheck){
            System.out.println("---> login mislukt!");
            System.out.println("Probeer het opnieuw... \n");
        }
        return choseLogin;
    }

    public static boolean LoginControle(){
        //Checks if user is gebruiker or medewerker
        System.out.println("Bent u 1) Gebruiker of 2) Medewerker? --> 0) om terug te gaan.");
        userInput = scanner.nextLine();
        if (userInput.equals("1")) {
            System.out.println("Gebruiker gekozen...");
            if (inputInfo()) {
                for (int i = 0; i < GebruikersData.GebruikersLijst.size(); i++) {
                    tempUser = GebruikersData.GebruikersLijst.get(i).getGebruikersnaam();
                    tempPass = GebruikersData.GebruikersLijst.get(i).getWachtwoord();
                    currentUserID = GebruikersData.GebruikersLijst.get(i).getId();
                    naam = GebruikersData.GebruikersLijst.get(i).getNaam();
                    achternaam = GebruikersData.GebruikersLijst.get(i).getAchternaam();
                    telefoonnummer = GebruikersData.GebruikersLijst.get(i).getTelefoonnummer();
                    email = GebruikersData.GebruikersLijst.get(i).getEmail();
                    gebruikersnaam = GebruikersData.GebruikersLijst.get(i).getGebruikersnaam();

                    if (userAndPassCheck()) {
                        isMedewerker = false;
                        return correct = true;
                    }
                }
            }
        } else if (userInput.equals("2")) {
            System.out.println("Medewerker gekozen...");
            if(inputInfo()) {
                for (int i = 0; i < MedewerkersData.MedewerkersLijst.size(); i++) {
                    tempUser = MedewerkersData.MedewerkersLijst.get(i).getGebruikersnaam();
                    tempPass = MedewerkersData.MedewerkersLijst.get(i).getWachtwoord();
                    currentUserID = MedewerkersData.MedewerkersLijst.get(i).getId();
                    naam = MedewerkersData.MedewerkersLijst.get(i).getNaam();
                    achternaam = MedewerkersData.MedewerkersLijst.get(i).getAchternaam();
                    telefoonnummer = MedewerkersData.MedewerkersLijst.get(i).getTelefoonnummer();
                    email = MedewerkersData.MedewerkersLijst.get(i).getEmail();
                    gebruikersnaam = MedewerkersData.MedewerkersLijst.get(i).getGebruikersnaam();

                    if (userAndPassCheck()) {
                        isMedewerker = true;
                        return correct = true;
                    }
                }
            }
        } else if (userInput.equals("0")) {
            System.out.println("Terug naar beginscherm...\n");
            chooseLogin();
        } else {
            System.out.println(userInput + " bestaat niet, probeer opnieuw...");
            LoginControle();
        }
        return correct;
    }

    public static boolean inputInfo() {
        System.out.println("Gebruikersnaam:");
        targetUser = scanner.nextLine();
        System.out.println("Wachtwoord:");
        targetPassword = scanner.nextLine();
        return true;
    }

    public static boolean userAndPassCheck() {
        if (targetUser.equals(tempUser) && targetPassword.equals(tempPass)) {
            System.out.println("login geslaagd!");
            userPassCheck = true;
        } else if (!targetUser.equals(tempUser) && !targetPassword.equals(tempPass)){
            userPassCheck = false;
            correct = false;
        }
        return userPassCheck;
    }
}