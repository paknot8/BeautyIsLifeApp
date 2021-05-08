import java.util.ArrayList;

public class MedewerkersData {
    public static Medewerker medewerkersLijst;
    public static ArrayList<Medewerker> MedewerkersLijst = new ArrayList<>() {
        {
            add(medewerkersLijst = new Medewerker(1,"tim","van beek", "tim@email.nl",
                    "tim123","123"));
            add(medewerkersLijst = new Medewerker(2,"bella","kerkhof", "bella@email.nl",
                    "bella123","321"));
        }
    };
}
