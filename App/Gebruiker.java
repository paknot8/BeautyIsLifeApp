import java.util.Scanner;
import static java.lang.System.in;

public class Gebruiker extends Persoon{
    private static final Scanner scanner = new Scanner(in);

    public Gebruiker(int id, String naam, String achternaam, String telefoonnummer, String email, String gebruikersnaam, String wachtwoord) {
        super(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);
    }

    public static void addNewGebruiker(Gebruiker newGebruiker){
        GebruikersData.GebruikersLijst.add(newGebruiker);
    }
}