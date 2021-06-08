import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Medewerker extends Persoon
{
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