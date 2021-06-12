public class KeuzeMenu
{
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
        System.out.println("\n--- Welkom op de BeautyIsLife App ---");
        if (LoginController.getInstance().isAuthenticated()) {
            if(TempField.isMedewerker){
                MenuKeuze_Medewerker();
            } else {
                MenuKeuze();
            }
        } else {
            LoginScherm();
        }
    }

    private static void MenuText(){
        System.out.println("\n--- Menu ---");
        System.out.println(" 1) Zie catalogus");
        System.out.println(" 2) Zoek item");
        System.out.println(" 3) Bestellingen inzien");
        System.out.println(" 4) Profiel inzien");
        System.out.println(" 5) Mijn Berichten");
        System.out.println(" 6) Neem Contact");
        System.out.println(" 0) Uitloggen");
        System.out.println("Uw keuze:");
    }

    public static void MenuKeuze(){
        MenuText();
        TempField.userInput = TempField.scanner.nextLine();
        switch (TempField.userInput) {
            case "1" -> {
                System.out.println("Catalogus Laden...");
                productControl.getProducten();
                Bestelling.VraagBestellingPlaatsen();
                MenuKeuze();
            }
            case "2" -> {
                System.out.println("--- Zoeken ---");
                productControl.zoekProduct();
                MenuKeuze();
            }
            case "3" -> {
                System.out.println("Mijn bestellingen inzien");
                gebruikerKeuze.getBestellingen();
                MenuKeuze();
            }
            case "4" -> {
                gebruikerKeuze.mijnProfiel();
                MenuKeuze();
            }
            case "5" -> {
                System.out.println("Mijn berichten");
                gebruikerKeuze.getBerichten();
                MenuKeuze();
            }
            case "6" -> {
                System.out.println("Neem Contact");
                gebruikerKeuze.Contact();
                MenuKeuze();
            }
            case "0" -> {
                System.out.println("Uitloggen...");
                LoginScherm();
            }
            default -> {
                System.out.println("Maak opnieuw een keuze...");
                MenuKeuze();
            }
        }
    }

    private static void MenuText_Medewerker(){
        System.out.println("\n--- Admin Menu ---");
        System.out.println(" 1) Klantenlijst overzicht");
        System.out.println(" 2) Klanten berichten");
        System.out.println(" 3) Zoek Producten");
        System.out.println(" 4) Producten overzicht");
        System.out.println(" 5) Klanten Bestellings overzicht");
        System.out.println(" 0) Uitloggen");
        System.out.println("Uw keuze:");
    }

    public static void MenuKeuze_Medewerker() {
        MenuText_Medewerker();
        TempField.userInput = TempField.scanner.nextLine();
        switch (TempField.userInput) {
            case "1" -> {
                System.out.println("Klantenlijst wordt opgehaald");
                medewerkerKeuze.getGebruikers();
                System.out.println("\n");
                MenuKeuze_Medewerker();
            }
            case "2" -> {
                System.out.println("Alle klantenberichten inzien");
                medewerkerKeuze.getBerichten();
                MenuKeuze_Medewerker();
            } case "3" -> {
                System.out.println("Zoek item");
                productControl.zoekProduct();
                MenuKeuze_Medewerker();
            }
            case "4" -> {
                System.out.println("Productenlijst overzicht");
                medewerkerKeuze.getProducten();
                MenuKeuze_Medewerker();
            }
            case "5" -> {
                System.out.println("Alle bestellingen inzien");
                medewerkerKeuze.getBestellingen();
                MenuKeuze_Medewerker();
            }
            case "0" -> {
                System.out.println("Uitloggen...");
                System.out.println("U bent met succes uigelogd!");
                LoginScherm();
            }
            default -> {
                System.out.println("Maak opnieuw een keuze...");
                MenuKeuze_Medewerker();
            }
        }
    }

    public static void main(String[] args) {
        LoginScherm();
    }
}