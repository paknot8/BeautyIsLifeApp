import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.System.out;

public class KeuzeMenu{
    private static final Scanner scanner = new Scanner(in);
    private static String input;

    // Objecten initiliseren accessable in KeuzeMenu
    static Medewerker medewerkerKeuze = new Medewerker();
    static Gebruiker gebruikerKeuze = new Gebruiker();
    static ProductController productControl = new ProductController();

    public static void LoginScherm() {
        out.println("\n--- Welkom op de BeautyIsLife App ---");
        if (LoginController.getInstance().isAuthenticated()) {
            if(LoginController.isMedewerker){
                MenuKeuze_Medewerker();
            } else {
                MenuKeuze();
            }
        } else {
            LoginScherm();
        }
    }
    // gebruiker
    // erick123     password: 123

    // medewerker
    // bella123     password: 321

    public static void MenuText(){
        out.println("--- Menu ---");
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
                gebruikerKeuze.zoekProduct();
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

    public static void MenuText_Medewerker(){
        out.println("--- Admin Menu ---");
        out.println(" 1) Klantenlijst overzicht");
        out.println(" 2) Klanten berichten");
        out.println(" 3) Zoek Producten");
        out.println(" 4) Producten overzicht");
        out.println(" 4) Klanten Bestellings overzicht");
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
                medewerkerKeuze.zoekProduct();
                MenuKeuze();
            }
            case "4" -> {
                out.println("Productenlijst overzicht");
                productControl.getProducten();
                productControl.chooseAddNewProduct();
                MenuKeuze_Medewerker();
            }
            case "5" -> {
                out.println("Alle bestellingen inzien");
                medewerkerKeuze.getBestellingen();
                MenuKeuze();
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
        //LoginScherm();
    }
}