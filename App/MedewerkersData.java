import java.util.ArrayList;

public class MedewerkersData {
    public static Medewerker medewerkersLijst;
    public static ArrayList<Medewerker> MedewerkersLijst = new ArrayList<>() {
        {
            add(medewerkersLijst = new Medewerker(1,"tim","van beek", "06123678","tim@email.nl",
                    "tim123","123"));
            add(medewerkersLijst = new Medewerker(2,"bella","kerkhof", "06123678","bella@email.nl",
                    "bella123","321"));
        }
    };
}