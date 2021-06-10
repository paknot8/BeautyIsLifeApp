import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.System.out;

public class KeuzeMenu{
    private static final Scanner scanner = new Scanner(in);
    private static String input;

    // Objecten initiliseren accessable in KeuzeMenu
    private static final Medewerker medewerkerKeuze = new Medewerker();
    private static final Gebruiker gebruikerKeuze = new Gebruiker();
    private static final ProductController productControl = new ProductController();

    /* --- Inlog Data voor Testing: ---
        > Gebruiker       password:
        erick123        123

        > Medewerker
        bella123        123
     */

    public static void LoginScherm() {
        out.println("\n--- Welkom op de BeautyIsLife App ---");
        if (LoginController.getInstance().isAuthenticated()) {
            if(LoginController.getInstance().isMedewerker){
                MenuKeuze_Medewerker();
            } else {
                MenuKeuze();
            }
        } else {
            LoginScherm();
        }
    }

    private static void MenuText(){
        out.println("\n--- Menu ---");
        out.println(" 1) Zie catalogus");
        out.println(" 2) Zoek item");
        out.println(" 3) Bestellingen inzien");
        out.println(" 4) Profiel inzien");
        out.println(" 5) Mijn Berichten");
        out.println(" 6) Neem Contact");
        out.println(" 0) Uitloggen");
        out.println("Uw keuze:");
    }

    public static void MenuKeuze(){
        MenuText();
        input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                out.println("Zie catalogus");
                productControl.getProducten();
                Bestelling.VraagBestellingPlaatsen();
                MenuKeuze();
            }
            case "2" -> {
                out.println("Zoek item");
                productControl.zoekProduct();
                MenuKeuze();
            }
            case "3" -> {
                out.println("Mijn bestellingen inzien");
                gebruikerKeuze.getBestellingen();
                MenuKeuze();
            }
            case "4" -> {
                gebruikerKeuze.mijnProfiel();
                MenuKeuze();
            }
            case "5" -> {
                out.println("Mijn berichten");
                gebruikerKeuze.getBerichten();
                MenuKeuze();
            }
            case "6" -> {
                out.println("Neem Contact");
                gebruikerKeuze.Contact();
                MenuKeuze();
            }
            case "0" -> {
                out.println("Uitloggen...");
                LoginScherm();
            }
            default -> {
                out.println("Maak opnieuw een keuze...");
                MenuKeuze();
            }
        }
    }

    private static void MenuText_Medewerker(){
        out.println("\n--- Admin Menu ---");
        out.println(" 1) Klantenlijst overzicht");
        out.println(" 2) Klanten berichten");
        out.println(" 3) Zoek Producten");
        out.println(" 4) Producten overzicht");
        out.println(" 5) Klanten Bestellings overzicht");
        out.println(" 0) Uitloggen");
        out.println("Uw keuze:");
    }

    public static void MenuKeuze_Medewerker() {
        MenuText_Medewerker();
        input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                out.println("Klantenlijst wordt opgehaald");
                medewerkerKeuze.getGebruikers();
                out.println("\n");
                MenuKeuze_Medewerker();
            }
            case "2" -> {
                out.println("Alle klantenberichten inzien");
                medewerkerKeuze.getBerichten();
                MenuKeuze_Medewerker();
            } case "3" -> {
                out.println("Zoek item");
                productControl.zoekProduct();
                MenuKeuze_Medewerker();
            }
            case "4" -> {
                out.println("Productenlijst overzicht");
                productControl.getProducten();
                MenuKeuze_Medewerker();
            }
            case "5" -> {
                out.println("Alle bestellingen inzien");
                medewerkerKeuze.getBestellingen();
                MenuKeuze_Medewerker();
            }
            case "0" -> {
                out.println("Uitloggen...");
                out.println("U bent met succes uigelogd!");
                LoginScherm();
            }
            default -> {
                out.println("Maak opnieuw een keuze...");
                MenuKeuze_Medewerker();
            }
        }
    }

    public static void main(String[] args) {
        LoginScherm();
    }
}