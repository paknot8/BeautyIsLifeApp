public class RegistratieController {
    // User details
    private int id;
    private String gebruikersnaam;
    private String wachtwoord;
    private String naam;
    private String achternaam;
    private String telefoonnummer;
    private String email;
    private static RegistratieController singleton;

    private RegistratieController(){
        singleton = null;
    }

    public static RegistratieController getInstance(){
        if (singleton == null) {
            singleton = new RegistratieController();
        }
        return singleton;
    }

    private boolean userIsAuthenticated() {
        return singleton != null;
    }

    public void isAuthenticated(){
        if (userIsAuthenticated()) {
            Registration();
        } else {
            KeuzeMenu.LoginScherm();
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
            System.out.println(TempField.userInput + " " + gebruikersnaam);
            System.out.println("Gebruiksnaam bestaat al, probeer nogmaals...");
        } else {
            if(TempField.isMedewerker){
                UserAccount userAccountMedewerker = new UserAccount(gebruikersnaam, wachtwoord, telefoonnummer, email);
                Medewerker newMedewerker = new Medewerker(id, naam, achternaam, userAccountMedewerker);
                Medewerker.addNewMedewerker(newMedewerker);
            } else {
                UserAccount userAccount = new UserAccount(gebruikersnaam, wachtwoord, telefoonnummer, email);
                Gebruiker newUser = new Gebruiker(id, naam, achternaam, userAccount);
                Medewerker.addNewGebruiker(newUser);
            }
            System.out.println(TempField.userInput + " " + gebruikersnaam);
            System.out.println(gebruikersnaam + " is nu geregistreerd!");
        }
    }

    private void GebruikersDataLoop(){
        Details();
        id = GebruikersData.GebruikersLijst.size() + 1;
        for (int i = 0; i < GebruikersData.GebruikersLijst.size(); i++) {
            TempField.tempUser = GebruikersData.GebruikersLijst.get(i).userAccount.getGebruikersnaam();
            if(userCheckExist()){
                break;
            }
        }
        succesControl();
    }

    private void MedewerkersDataLoop(){
        Details();
        id = MedewerkersData.MedewerkersLijst.size() + 1;
        for (int i = 0; i < MedewerkersData.MedewerkersLijst.size(); i++) {
            TempField.tempUser = MedewerkersData.MedewerkersLijst.get(i).userAccount.getGebruikersnaam();
            if(userCheckExist()){
                break;
            }
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