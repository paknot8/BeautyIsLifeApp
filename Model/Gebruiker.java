public class Gebruiker extends Persoon{
    private String onderwerp;
    private String beschrijving;
    private String email;

    public PrivatePrivateMessage newBericht;
    public Email newEmail;

    public Gebruiker(int id, String naam, String achternaam, UserAccount userAccount) {
        super(id, naam, achternaam, userAccount);
    }

    public Gebruiker(){}

    public void mijnProfiel(){
        System.out.println("--- Mijn Profiel ---");
        System.out.println("ID nummer       | " + LoginController.getInstance().id);
        System.out.println("Gebruikersnaam  | " + LoginController.getInstance().username);
        System.out.println("Password        | " + LoginController.getInstance().password);
        System.out.println("Voornaam        | " + LoginController.getInstance().naam);
        System.out.println("Achternaam      | " + LoginController.getInstance().achternaam);
        System.out.println("Telefoonnummer  | " + LoginController.getInstance().telefoonnummer);
        System.out.println("Emailadres      | " + LoginController.getInstance().email);
    }

    private void ContactInvoer(){
        System.out.println("Wat is het onderwerp:");
        onderwerp = TempField.scanner.nextLine();
        System.out.println("Beschrijf het probleem:");
        beschrijving = TempField.scanner.nextLine();
    }

    private void ContactDetails(String keuze){
        switch (keuze) {
            case "1" -> ContactInvoer();
            case "2" -> {
                ContactInvoer();
                email = TempField.scanner.nextLine();
            }
            default -> ContactDetails(keuze);
        }
    }

    public void Contact(){
        System.out.println("--- Contact nemen met de klantenservice ---");
        System.out.println("Wilt u een 1) Bericht of een 2) Email sturen?");
        String userInput = TempField.scanner.nextLine();
        ContactDetails(userInput);
        // Berichten
        int id;
        switch (userInput) {
            case "1" -> {
                id = BerichtenData.PrivatemessageLijst.size() + 1; //increment number
                newBericht = new PrivatePrivateMessage(id, LoginController.getInstance().id, onderwerp, beschrijving);
                newBericht.addBericht(newBericht);
            }
            case "2" -> {
                id = BerichtenData.EmailLijst.size() + 1; //increment number
                newEmail = new Email(id, LoginController.getInstance().id, onderwerp, beschrijving, email);
                newEmail.addEmail(newEmail);
            }
            default -> {
                System.out.println("Bestaat niet, terug naar Menu");
                KeuzeMenu.MenuKeuze();
            }
        }
    }

    @Override
    public void getBestellingen(){
        for(Bestelling bestelling : BestellingsData.BestellingsLijst) {
            if(bestelling.getUserID() == LoginController.getInstance().id){
                System.out.println("Bestelnr: " + bestelling.getBestelNummer() + " | Gebruikerid: " + bestelling.getUserID() +
                        " | Product: " + bestelling.getProductNaam() + " | Aantal: " + bestelling.getAantalGekocht() +
                        " | Prijs: €" + bestelling.getPrijsBetaald());
            }
        }
    }

    @Override
    public void getBerichten() {
        for(Bericht bericht : BerichtenData.PrivatemessageLijst) {
            if(bericht.getUserID() == LoginController.getInstance().id){
                System.out.println("Berichtnr: " + bericht.getId() + " | Gebruikerid: " + bericht.getUserID() +
                        " | Onderwerp: " + bericht.getOnderwerp() + " | Beschrijving: " + bericht.getBeschrijving());
            }
        }
        getEmails();
    }

    @Override
    public void getEmails(){
        for(Email email : BerichtenData.EmailLijst) {
            if(email.getUserID() == LoginController.getInstance().id){
                System.out.println("Emailnr: " + email.getId() + " | Gebruikerid: " + email.getUserID() +
                        " | Onderwerp: " + email.getOnderwerp() + " | Beschrijving: " + email.getBeschrijving());
            }
        }
    }
}