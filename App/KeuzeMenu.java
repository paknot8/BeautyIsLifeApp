import java.util.Scanner;
import static java.lang.System.exit;
import static java.lang.System.in;

public class KeuzeMenu {
    public static void main(String[] args) {
        Scanner s = new Scanner(in);
        System.out.println("Login als Gebruiker [1], Medewerker [2]");

        String input = s.nextLine();

        if(input.equals("1")){
            Gebruiker.loginControleGebruiker();
        } else if(input.equals("2")){
            Medewerker.loginControleMedewerker();
        } else {
            exit(0);
        }
    }
}
