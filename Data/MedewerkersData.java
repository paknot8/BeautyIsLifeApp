import java.util.ArrayList;

public class MedewerkersData {
    public static Medewerker medewerkersLijst;
    public static ArrayList<Medewerker> MedewerkersLijst = new ArrayList<>() {
        {
            UserAccount admin = new UserAccount("admin","admin","06123678","superuser@email.nl");
            UserAccount tim = new UserAccount("tim123","123", "06123678","tim@email.nl");
            UserAccount bella = new UserAccount("bella123","123", "06123678","bella@email.nl");

            add(medewerkersLijst = new Medewerker(1,"admin","admin",admin));
            add(medewerkersLijst = new Medewerker(2,"tim","van beek",tim));
            add(medewerkersLijst = new Medewerker(3,"bella","kerkhof",bella));
        }
    };
}