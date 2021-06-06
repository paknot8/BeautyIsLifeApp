// Single Responsbility Principe
// Deze class berekent de korting van het aantal gekochte producten
// return een het totaal prijs met de korting erop.
public class korting
{
    public static double kortingOpTotaalAantalProducten(int userInputAantalBesteld,double tempProductPrijs){
        if(userInputAantalBesteld > 3 && userInputAantalBesteld < 10){
            System.out.println("U krijgt 15% korting!");
            return ((userInputAantalBesteld * tempProductPrijs) * 0.85);
        } else if(userInputAantalBesteld > 10 && userInputAantalBesteld < 100) {
            System.out.println("U krijgt 20% korting!");
            return ((userInputAantalBesteld * tempProductPrijs) * 0.80);
        } else if(userInputAantalBesteld > 100) {
            System.out.println("U krijgt 25% korting!");
            return ((userInputAantalBesteld * tempProductPrijs) * 0.75);
        } else {
            return (userInputAantalBesteld * tempProductPrijs);
        }
    }
}