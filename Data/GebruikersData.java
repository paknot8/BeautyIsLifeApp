import java.util.ArrayList;

public class GebruikersData {
    public static Gebruiker gebruikersLijst;
    public static ArrayList<Gebruiker> GebruikersLijst = new ArrayList<>() {
        {
            add(gebruikersLijst = new Gebruiker(1,"timon","smith", "06123678","timon@email.nl",
                    "timon123","123"));
            add(gebruikersLijst = new Gebruiker(2,"erick","ibanez", "06123678","erick@email.nl",
                    "erick123","123"));
            add(gebruikersLijst = new Gebruiker(3,"bob","smit", "0612345678","bob@email.nl",
                    "bob123","321"));
        }
    };
}