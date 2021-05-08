import java.util.ArrayList;

public class GebruikersData {
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
