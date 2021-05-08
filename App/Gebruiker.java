import java.util.ArrayList;

public class Gebruiker extends Persoon{
    public Gebruiker(int id, String naam, String achternaam, String email, String gebruikersnaam, String wachtwoord) {
        super(id, naam, achternaam, email, gebruikersnaam, wachtwoord);
    }

    public static Gebruiker gebruikersLijst;
    public static ArrayList<Gebruiker> GebruikersLijst = new ArrayList<>() {
        {
            add(gebruikersLijst = new Gebruiker(1,"erick","ibanez", "erick@email.nl",
                    "erick123","123"));
            add(gebruikersLijst = new Gebruiker(2,"bob","smit", "bob@email.nl",
                    "bob321","321"));
        }
    };
}