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

    public static Bericht berichtenLijst;
    public static ArrayList<Bericht> BerichtenLijst = new ArrayList<>() {
        {
            add(berichtenLijst = new Bericht(1,"verkeerde aankoop","Ik heb een verkeerde aankoop gedaan, graag annuleren!"));
            add(berichtenLijst = new Bericht(2,"klacht","Ontevreden met service!"));
        }
    };
}