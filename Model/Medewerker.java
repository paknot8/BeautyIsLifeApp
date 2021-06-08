import java.util.Scanner;

import static java.lang.System.out;

public class Medewerker extends Persoon implements IProduct
{
    private static final Scanner scanner = new Scanner(System.in);
    private static final ProductController productControl = new ProductController();

    public Medewerker(int id, String naam, String achternaam, String telefoonnummer, String email, String gebruikersnaam, String wachtwoord) {
        super(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);
    }

    public Medewerker(){}

    public void getGebruikers() {
        for (Gebruiker gebruiker : GebruikersData.GebruikersLijst) {
            System.out.println(gebruiker.getId() + ", " + gebruiker.getGebruikersnaam() +
                    ", " + gebruiker.getNaam() + ", " + gebruiker.getAchternaam() + ", " +
                    gebruiker.getTelefoonnummer() + ", " + gebruiker.getEmail());
        }
    }

    public static void addNewGebruiker(Gebruiker newGebruiker){ GebruikersData.GebruikersLijst.add(newGebruiker); }
    public static void addNewMedewerker(Medewerker newMedewerker){ MedewerkersData.MedewerkersLijst.add(newMedewerker); }
    public static void addNewProduct(Product newProduct){ ProductData.ProductenLijst.add(newProduct); }

    @Override // Get all data from producten
    public void getProducten() {
        for (Product product : ProductData.ProductenLijst) {
            System.out.println("Productnr: " + product.getProductId() + " | Product: " + product.getProductNaam() +
                    " | Prijs: " + product.getProductPrijs() + " | Op voorraad: " + product.getProductVoorraad());
        }
        out.println("0) terug | 1) Product Toevoegen | 2) Product Wijzigen | 3) Product Verwijderen");
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "0" -> KeuzeMenu.MenuKeuze_Medewerker();
            case "1" -> productControl.addProduct();
            case "2" -> productControl.wijzigProduct();
            case "3" -> productControl.verwijderProduct();
            default -> {
                out.println("Onbekende invoer, probeer nogmaals");
                KeuzeMenu.MenuKeuze_Medewerker();
            }
        }
    }

    @Override
    public void getBestellingen(){
        for(Bestelling bestelling : BestellingsData.BestellingsLijst) {
                System.out.println("Bestelnr: " + bestelling.getBestelNummer() + " | Gebruikerid: " + bestelling.getUserID() +
                        " | Besteld door: " + LoginController.getInstance().naam + " " + LoginController.getInstance().achternaam +
                        " | Product: " + bestelling.getProductNaam() + " | Aantal: " + bestelling.getAantalGekocht() +
                        " | Prijs: €" + bestelling.getPrijsBetaald());
        }
    }

    @Override
    public void getBerichten() {
        for (Bericht bericht : BerichtenData.PrivatemessageLijst) {
            System.out.println("Berichtnr: " + bericht.getId() + " | Gebruikerid: " + bericht.getUserID() +
                    " | Onderwerp: " + bericht.getOnderwerp() + " | Beschrijving: " + bericht.getBeschrijving());
        }
        out.println("--- Emails ---");
        for (Email email : BerichtenData.EmailLijst) {
            System.out.println("Emailnr: " + email.getId() + " | Gebruikerid: " + email.getUserID() +
                    " | Onderwerp: " + email.getOnderwerp() + " | Beschrijving: " + email.getBeschrijving());
        }
    }
}