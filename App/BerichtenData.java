import java.util.ArrayList;

public class BerichtenData {
    public static Bericht berichtenLijst;
    public static ArrayList<Bericht> BerichtenLijst = new ArrayList<>() {
        {
            add(berichtenLijst = new Bericht(1,"verkeerde aankoop","Ik heb een verkeerde aankoop gedaan, graag annuleren!"));
            add(berichtenLijst = new Bericht(2,"klacht","Ontevreden met service!"));
        }
    };
}