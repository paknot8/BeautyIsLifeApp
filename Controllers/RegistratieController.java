public class RegistratieController {
    // User details
    private int id;
    private String gebruikersnaam;
    private String wachtwoord;
    private String naam;
    private String achternaam;
    private String telefoonnummer;
    private String email;

    // Singleton
    private static RegistratieController singleton;
    private final Gebruiker registeredUser;
    private final Medewerker registeredMedewerker;

    private RegistratieController(){
        registeredUser = null;
        registeredMedewerker = null;
    }

    public static RegistratieController getInstance(){
        if (singleton == null) {
            singleton = new RegistratieController();
        }
        return singleton;
    }

    private boolean userIsAuthenticated() { return registeredUser != null & registeredMedewerker != null; }

    public void isAuthenticated(){
        if (!userIsAuthenticated()){
            Registration();
        }
    }

    private void Registration() {
        System.out.println("Maak een keuze: 1) Gebruiker, 2) Medewerker");
        TempField.userInput = TempField.scanner.nextLine();
        switch (TempField.userInput) {
            case "1" -> {
                TempField.isMedewerker = false;
                GebruikersDataLoop();
            }
            case "2" -> {
                TempField.isMedewerker = true;
                MedewerkersDataLoop();
            }
        }
        KeuzeMenu.LoginScherm();
    }

    private void Details() {
        System.out.println("--- Voer uw gegevens in ---");
        System.out.println("gebruikersnaam: ");     gebruikersnaam = TempField.scanner.nextLine();
        System.out.println("wachtwoord: ");         wachtwoord = TempField.scanner.nextLine();
        System.out.println("naam: ");               naam = TempField.scanner.nextLine();
        System.out.println("achternaam: ");         achternaam = TempField.scanner.nextLine();
        System.out.println("telefoonnummer: ");     telefoonnummer = TempField.scanner.nextLine();
        System.out.println("email: ");              email = TempField.scanner.nextLine();
    }

    private void succesControl(){
        if(!TempField.succesControl){
            System.out.println("Niet succesvol, probeer nogmaals...");
        } else {
            if(TempField.isMedewerker){
                Medewerker newMedewerker = new Medewerker(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);
                Medewerker.addNewMedewerker(newMedewerker);
            } else {
                Gebruiker newUser = new Gebruiker(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);
                Medewerker.addNewGebruiker(newUser);
            }
            System.out.println(gebruikersnaam + " is nu geregistreerd!");
        }
    }

    private void GebruikersDataLoop(){
        Details();
        id = GebruikersData.GebruikersLijst.size() + 1;
        for (int i = 0; i < GebruikersData.GebruikersLijst.size(); i++) {
            TempField.tempUser = GebruikersData.GebruikersLijst.get(i).getGebruikersnaam();
            if(userCheckExist()) break;
        }
        succesControl();
    }

    private void MedewerkersDataLoop(){
        id = MedewerkersData.MedewerkersLijst.size() + 1;
        for (int i = 0; i < MedewerkersData.MedewerkersLijst.size(); i++) {
            TempField.tempUser = MedewerkersData.MedewerkersLijst.get(i).getGebruikersnaam();
            if(userCheckExist()) break;
        }
        succesControl();
    }

    private boolean userCheckExist(){
        if (TempField.tempUser.equals(gebruikersnaam)) {
            TempField.succesControl = false;
            return true;
        } else {
            TempField.succesControl = true;
            return false;
        }
    }
}