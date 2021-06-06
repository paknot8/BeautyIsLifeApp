import java.util.Scanner;

// Dependency-Inversion
// Bestelling plaatsen is afhankelijk (depends op) van de PaymentProcessor
// deze zorgt voor het afhandelen van de betalingen
public class PaymentProcessor
{
    public static void betaalMethod(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Met welke betaalmethode wilt u betalen?");
        System.out.println("0) Terug - 1) Ideal - 2) contant - 3) bankoverschrijven");
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "0" -> KeuzeMenu.MenuKeuze();
            case "1" -> System.out.println("U heeft Ideal betaald €" + Korting.newPrijs); // External API van de betaalmethode Ideal
            case "2" -> System.out.println("U heeft Contant betaald €" + Korting.newPrijs); // External API van de betaalmethode Contant Betalen
            case "3" -> System.out.println("U heeft succesvol €" + Korting.newPrijs + " overgeschreven."); // External API van de betaalmethode bank overschrijven
            default -> betaalMethod();
        }
    }
}