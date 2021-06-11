public class Medewerker extends Persoon implements IProduct
{
    private static final ProductController productControl = new ProductController();

    public Medewerker(int id, String naam, String achternaam, UserAccount userAccount) {
        super(id, naam, achternaam, userAccount);
    }

    public Medewerker(){}

    public void getGebruikers() {
        for (Gebruiker gebruiker : GebruikersData.GebruikersLijst) {
            System.out.println(gebruiker.getId() + ", " + gebruiker.userAccount.getGebruikersnaam() +
                    ", " + gebruiker.getNaam() + ", " + gebruiker.getAchternaam() + ", " +
                    gebruiker.userAccount.getTelefoonnummer() + ", " + gebruiker.userAccount.getEmail());
        }
    }

    // Toevoegen van Data
    public static void addNewGebruiker(Gebruiker newGebruiker){ GebruikersData.GebruikersLijst.add(newGebruiker); }
    public static void addNewMedewerker(Medewerker newMedewerker){ MedewerkersData.MedewerkersLijst.add(newMedewerker); }
    public static void addNewProduct(Product newProduct){ ProductData.ProductenLijst.add(newProduct); }

    @Override // Get all data from producten
    public void getProducten() {
        for (Product product : ProductData.ProductenLijst) {
            System.out.println("Productnr: " + product.getProductId() + " | Product: " + product.getProductNaam() +
                    " | Prijs: " + product.getProductPrijs() + " | Op voorraad: " + product.getProductVoorraad());
        }
        productOpties();
    }

    private void productOpties(){
        System.out.println("0) terug | 1) Product Toevoegen | 2) Product Wijzigen | 3) Product Verwijderen");
        TempField.userInput = TempField.scanner.nextLine();
        switch (TempField.userInput) {
            case "0" -> KeuzeMenu.MenuKeuze_Medewerker();
            case "1" -> productControl.addProduct();
            case "2" -> productControl.wijzigProduct();
            case "3" -> productControl.verwijderProduct();
            default -> {
                System.out.println("Onbekende invoer, probeer nogmaals");
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
        getEmails();
    }

    @Override
    public void getEmails(){
        for (Email email : BerichtenData.EmailLijst) {
            System.out.println("Emailnr: " + email.getId() + " | Gebruikerid: " + email.getUserID() +
                    " | Onderwerp: " + email.getOnderwerp() + " | Beschrijving: " + email.getBeschrijving());
        }
    }
}