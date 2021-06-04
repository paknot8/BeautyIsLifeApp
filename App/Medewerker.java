import java.util.Scanner;
import static java.lang.System.in;

public class Medewerker extends Persoon {
    private static final Scanner scanner = new Scanner(in);
    private static String userInput;

    public Medewerker(int id, String naam, String achternaam, String telefoonnummer, String email, String gebruikersnaam, String wachtwoord) {
        super(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);
    }

    public static void addNewMedewerker(Medewerker newMedewerker){ MedewerkersData.MedewerkersLijst.add(newMedewerker); }

    public static void addNewBericht(Bericht newBericht){ BerichtenData.BerichtenLijst.add(newBericht); }

    public static void getAllBerichten() {
        for (Bericht bericht : BerichtenData.BerichtenLijst) {
            System.out.println(bericht.getId() + " " + bericht.getOnderwerp() + " " + bericht.getOnderwerp());
        }
    }
}