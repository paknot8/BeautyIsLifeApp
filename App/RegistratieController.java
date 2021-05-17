import java.util.Scanner;
import static java.lang.System.in;

public class RegistratieController {
    private static final Scanner s = new Scanner(in);
    public static String userInput;

    private static String naam;
    private static String achternaam;
    private static String telefoonnummer;
    private static String email;
    private static String gebruikersnaam;
    private static String wachtwoord;

    public static String tempUser;
    public static String tempPass;

    public static boolean registered;

    public static void Details() {
        System.out.println("Voer in uw gegevens in...");
        System.out.println("naam: ");               naam = s.nextLine();
        System.out.println("achternaam: ");         achternaam = s.nextLine();
        System.out.println("wachtwoord: ");         telefoonnummer = s.nextLine();
        System.out.println("email: ");              email = s.nextLine();
        System.out.println("gebruikersnaam: ");     gebruikersnaam = s.nextLine();
        System.out.println("wachtwoord: ");         wachtwoord = s.nextLine();
    }

    public static void Registration() {
        System.out.println("Maak een keuze...");
        System.out.println("1) Gebruiker");
        System.out.println("2) Medewerker");
        userInput = s.nextLine();

        // Checks if user chose 1 or 2
        int id;
        if (userInput.equals("1")) {
            // Asks user for name, surname and password
            Details();
            // Inserts id by taking the arraylist size and adding +1
            id = GebruikersData.GebruikersLijst.size() + 1; //increment number
            Gebruiker newGebruiker = new Gebruiker(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);

            Gebruiker.addNewGebruiker(newGebruiker);
            //GebruikersData.GebruikersLijst.add(newGebruiker);

            // Used a for-loop to check if the user now exists in the arraylist
            for (int i = 0; i < GebruikersData.GebruikersLijst.size(); i++) {
                tempUser = GebruikersData.GebruikersLijst.get(i).getGebruikersnaam();
                tempPass = GebruikersData.GebruikersLijst.get(i).getWachtwoord();
                LoginController.currentUser = GebruikersData.GebruikersLijst.get(i).getId();
                if (gebruikersnaam.equals(tempUser) && wachtwoord.equals(tempPass)) {
                    System.out.println("Gebruiker is nu Geregistreerd!");
                    registered = true;
                    //KeuzeMenu.HoofdMenuText();
                } else {
                    registered = false;
                }
            }
        } else if (userInput.equals("2")) {
            Details();
            id = MedewerkersData.MedewerkersLijst.size() + 1;
            Medewerker newMedewerker = new Medewerker(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);
            MedewerkersData.MedewerkersLijst.add(newMedewerker);

            for (int i = 0; i < MedewerkersData.MedewerkersLijst.size(); i++) {
                tempUser = MedewerkersData.MedewerkersLijst.get(i).getGebruikersnaam();
                tempPass = MedewerkersData.MedewerkersLijst.get(i).getWachtwoord();
                LoginController.currentUser = MedewerkersData.MedewerkersLijst.get(i).getId();
                if (gebruikersnaam.equals(tempUser) && wachtwoord.equals(tempPass)) {
                    System.out.println("Examinator geregistreerd");
                    registered = true;
                    // KeuzeMenu.HoofdMenuText();
                } else {
                    registered = false;
                }
            }
        }
    }
}
