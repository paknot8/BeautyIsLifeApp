import java.util.Scanner;
import static java.lang.System.in;

public class LoginController {
    private static final Scanner s = new Scanner(in);

    public static int currentUser;
    public static String userInput;
    public static String targetUser;
    public static String targetPassword;
    public static String tempUser;
    public static String tempPass;

    public static String userChoice;
    public static boolean choseLogin;
    public static boolean correct;
    public static boolean userPassCheck;

    public static boolean chooseLogin() {
        System.out.println("Wilt u: 1) inloggen of 2) registreren");
        userChoice = s.nextLine();

        switch (userChoice)
        {
            case "1" -> choseLogin = LoginControle();
            case "2" -> {
                choseLogin = false;
                RegistratieController.Registration();
            }
        }
        if (!userPassCheck){
            System.out.println("login mislukt!");
            System.out.println("Probeer het opnieuw...");
        }
        return choseLogin;
    }

    public static boolean LoginControle(){
        //Checks if user is gebruiker or medewerker
        System.out.println("Bent u 1) Gebruiker of 2) Medewerker?");
        userInput = s.nextLine();
        if (userInput.equals("1")) {
            System.out.println("Gebruiker gekozen...");
            if (inputInfo()) {
                for (int i = 0; i < GebruikersData.GebruikersLijst.size(); i++) {
                    tempUser = GebruikersData.GebruikersLijst.get(i).getGebruikersnaam();
                    tempPass = GebruikersData.GebruikersLijst.get(i).getWachtwoord();
                    currentUser = GebruikersData.GebruikersLijst.get(i).getId();

                    if (userAndPassCheck()) {
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
                    currentUser = MedewerkersData.MedewerkersLijst.get(i).getId();

                    if (userAndPassCheck()) {
                        return correct = true;
                    }
                }
            }
        }
        return correct;
    }

    public static boolean inputInfo() {
        System.out.println("Gebruikersnaam:");
        targetUser = s.nextLine();
        System.out.println("Wachtwoord:");
        targetPassword = s.nextLine();
        return true;
    }

    public static boolean userAndPassCheck() {
        if (targetUser.equals(tempUser) && targetPassword.equals(tempPass)) {
            System.out.println("login geslaagd!");
            userPassCheck = true;
        } else if (!targetUser.equals(tempUser) && !targetPassword.equals(tempPass)){
            userPassCheck = false;
        }
        return userPassCheck;
    }
}
