import java.util.ArrayList;

public class BerichtenData {
    public static Bericht berichtenLijst;
    public static ArrayList<Bericht> BerichtenLijst = new ArrayList<>() {
        {
            add(berichtenLijst = new Bericht(1,"klacht","ik heb een klacht over cosmetica"));
            add(berichtenLijst = new Bericht(2,"feedback","graag nieuw opties tovoegen"));
        }
    };
}