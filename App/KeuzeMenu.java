import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.System.out;

public class KeuzeMenu{
    private static final Scanner s = new Scanner(in);
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
    // bella123     password: bella123

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
        input = s.nextLine();
        switch (input) {
            case "1" -> {
                out.println("Klantenlijst overzicht");
            }
            case "2" -> {
                out.println("Klantenberichten");
            }
            case "3" -> {
                out.println("Producten lijst overzicht");
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

    public static void MenuKeuze(){
        MenuText();
        input = s.nextLine();
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
            }
            case "4" -> {
                out.println("Profiel inzien");
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

    public static void main(String[] args) {
        MenuKeuze();
    }
}
