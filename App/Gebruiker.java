import java.util.Scanner;

import static java.lang.System.in;

public class Gebruiker extends Persoon{
    private static final Scanner s = new Scanner(in);

    public Gebruiker(int id, String naam, String achternaam, String telefoonnummer, String email, String gebruikersnaam, String wachtwoord) {
        super(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);
    }

    public static void loginControleGebruiker(){
        for(Gebruiker gebruiker : GebruikersData.GebruikersLijst){
            String tempGebruiker = gebruiker.getGebruikersnaam();
            String tempWachtwoord = gebruiker.getWachtwoord();

            System.out.println("Gebruikersnaam:");
            String inputGeb = s.nextLine();
            System.out.println("Wachtwoord:");
            String inputPass = s.nextLine();

            if(inputGeb.equals(tempGebruiker) & inputPass.equals(tempWachtwoord)){
                System.out.println("Goed " + tempGebruiker);
                System.out.println("Goed " + tempWachtwoord);
            } else {
                System.out.println("Fout " + tempGebruiker);
                System.out.println("Fout " + tempWachtwoord);
            }
            return;
        }
    }
}