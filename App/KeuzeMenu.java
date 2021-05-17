import java.util.Scanner;
import static java.lang.System.exit;
import static java.lang.System.in;

public class KeuzeMenu {
    private static final Scanner s = new Scanner(in);

    public static void LoginScherm() {
        if (LoginController.chooseLogin())
        {
            MenuSelectie();
        }
        else {
            LoginScherm();
        }
    }

    public static void MenuSelectie(){
        System.out.println("U bent ingelogd en in Menu Selectie...");
    }

    public static void main(String[] args) {
        //LoginScherm();
        Bestelling.replaceVoorraad();

        System.out.println(ProductData.productenLijst.getProductId() + " "
                + ProductData.productenLijst.getProductNaam() + " " + ProductData.productenLijst.getProductVoorraad());
    }
}
