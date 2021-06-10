import java.util.ArrayList;

public class GebruikersData
{
    public static Gebruiker gebruikersLijst;
    public static ArrayList<Gebruiker> GebruikersLijst = new ArrayList<>() {
        {
            UserAccount timon = new UserAccount("timon123","123", "06123678","timon@email.nl");
            UserAccount erick = new UserAccount("erick123","123", "06123678","erick@email.nl");
            UserAccount bob = new UserAccount("bob123","123", "0612345678","bob@email.nl");

            add(gebruikersLijst = new Gebruiker(1,"timon","smith",timon));
            add(gebruikersLijst = new Gebruiker(2,"erick","ibanez",erick));
            add(gebruikersLijst = new Gebruiker(3,"bob","smit",bob));
        }
    };
}