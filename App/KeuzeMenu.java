import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.System.out;

public class KeuzeMenu{
    private static final Scanner scanner = new Scanner(in);
    private static String input;

    public static void LoginScherm() {
        if (LoginController.chooseLogin())
        {
            if(LoginController.isMedewerker){
                MenuKeuze_Medewerker();
            } else {
                MenuKeuze();
            }
        }
        else {
            LoginScherm();
        }
    }

    // gebruiker
    // erick123     password: 123

    // medewerker
    // bella123     password: 321

    public static void MenuText(){
        out.println("--- Welkom op de BeautyIsLife App ---");
        out.println("Menu");
        out.println(" 1) Zie catalogus");
        out.println(" 2) Zoek item");
        out.println(" 3) Bestelstatus inzien");
        out.println(" 4) Profiel inzien");
        out.println(" 5) Contact");
        out.println(" 0) Exit");
        out.println("Uw keuze:");
    }

    public static void MenuKeuze(){
        MenuText();
        input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                out.println("Zie catalogus");
                ProductController.getAllProducten();
                Bestelling.VraagBestellingPlaatsen();
            }
            case "2" -> {
                out.println("Zoek item");
            }
            case "3" -> {
                out.println("Bestelstatus inzien");
                Bestelling.getMijnBestellingen();
            }
            case "4" -> {
                out.println("Profiel inzien");
                out.println("ID nummer: " + LoginController.currentUserID);
                out.println("Gebruikersnaam: " + LoginController.tempUser);
                out.println("Naam: " + LoginController.naam);
                out.println("achternaam: " + LoginController.achternaam);
                out.println("telefoonnummer: " + LoginController.telefoonnummer);
                out.println("email: " + LoginController.email);
                out.println("gebruikersnaam: " + LoginController.gebruikersnaam);
                MenuKeuze();
            }
            case "5" -> {
                out.println("Contact");
                Gebruiker.Contact();
                Medewerker.getAllBerichten(); // Deze is alleen voor test purpose moet naar Medewerker
            }
            case "0" -> {
                out.println("Uitloggen...");
                exit(0);
            }
            default -> {
                out.println("Maak opnieuw een keuze...");
                MenuKeuze();
            }
        }
    }

    public static void MenuText_Medewerker(){
        out.println("--- Welkom op de BeautyIsLife App ---");
        out.println("Menu");
        out.println(" 1) Klantenlijst overzicht");
        out.println(" 2) Klanten berichten");
        out.println(" 3) Producten overzicht");
        out.println(" 0) Exit");
        out.println("Uw keuze:");
    }

    public static void MenuKeuze_Medewerker() {
        MenuText_Medewerker();
        input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                out.println("Klantenlijst wordt opgehaald");
                Gebruiker.getAllGebruikers();
                out.println("\n");
                MenuKeuze_Medewerker();
            }
            case "2" -> {
                out.println("Klantenberichten");
            }
            case "3" -> {
                out.println("Producten lijst overzicht");
                ProductController.getAllProducten();
                ProductController.chooseAddNewProduct();
                MenuKeuze_Medewerker();
            }
            case "0" -> {
                out.println("Uitloggen...");
                out.println("U bent met succes uigelogd!");
                exit(0);
            }
            default -> {
                out.println("Maak opnieuw een keuze...");
                MenuKeuze_Medewerker();
            }
        }
    }

    public static void main(String[] args) {
        //LoginScherm();
        MenuKeuze_Medewerker();

        //ProductController.DetailsInput();
    }
}
