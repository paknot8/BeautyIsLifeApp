import java.util.ArrayList;

public class MedewerkersData {
    public static Medewerker medewerkersLijst;
    public static ArrayList<Medewerker> MedewerkersLijst = new ArrayList<>() {
        {
            add(medewerkersLijst = new Medewerker(1,"superuser voornaam","superuser achternaam", "06123678","superuser@email.nl",
                    "admin","admin"));
            add(medewerkersLijst = new Medewerker(2,"tim","van beek", "06123678","tim@email.nl",
                    "tim123","123"));
            add(medewerkersLijst = new Medewerker(3,"bella","kerkhof", "06123678","bella@email.nl",
                    "bella123","123"));
        }
    };
}