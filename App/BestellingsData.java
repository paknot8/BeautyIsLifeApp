import java.util.ArrayList;

public class BestellingsData {
    public static Bestelling bestellingsLijst;
    public static ArrayList<Bestelling> BestellingsLijst = new ArrayList<>() {
        {
            add(bestellingsLijst = new Bestelling(1,1,"facial",1,10));
            add(bestellingsLijst = new Bestelling(2,2,"cosmetica",1,30));
            add(bestellingsLijst = new Bestelling(3,1,"detox",1,5));
        }
    };
}