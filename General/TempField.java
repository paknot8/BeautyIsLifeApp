import java.util.Scanner;
import static java.lang.System.in;

// Fields that are used in General
// also for performance and avoid code smells for duplications and temporary fields
public class TempField {
    // --- General user input ---
    public static final Scanner scanner = new Scanner(in);
    public static String userInput;

    // --- Temporary use of Variable Bestelling / Producten ---
    public static int tempProductID;
    public static String tempProductNaam;
    public static double tempProductPrijs;
    public static int tempProductVoorraad;
    public static int tempProductAantal;

    // --- Login and Register Controls ---
    public static boolean isMedewerker = false;

    // Login
    public static int currentUserID;
    public static String targetUserName;
    public static String targetPassword;

    // Registratie
    public static String tempUser;
    public static boolean succesControl;
}