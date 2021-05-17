import java.util.Scanner;
import static java.lang.System.exit;
import static java.lang.System.in;

public class KeuzeMenu {
    private static final Scanner s = new Scanner(in);

    public static void LoginScherm() {
        if (LoginController.chooseLogin())
        {
            KeuzeMenu.MenuSelectie();
            System.out.println("Ga naar keuzemenu");
        }
        else {
            LoginScherm();
        }
    }

    public static void MenuSelectie(){ }
    public static void ProductFilteren(){ }
    public static void ProductZoeken(){ }
    public static void ProductInzien(){ }
    public static void BestelstatusOpvragen(){ }
    public static void MijnProfiel(){ }
    public static void KlachtSturen(){ }
    public static void KlantLijst(){ }

    public static void main(String[] args) {

        //LoginScherm();
        Bestelling.replaceVoorraad();

    }
}
