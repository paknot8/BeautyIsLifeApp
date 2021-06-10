public class Voorraad
{
    // aantal bestelde producten min voorraad
    public static void newVoorraadBerekenen(){
        if(TempField.tempProductVoorraad > 0){
            Bestelling.newVoorraad = TempField.tempProductVoorraad - Bestelling.userInputAantalBesteld;
            if(Bestelling.newVoorraad < 0){
                System.out.println(">>> Het aantal dat u wilt bestellen hebben wij niet op voorraad, voer een ander aantal in.");
                System.out.println("Vul aantal bestellingen:");
                Bestelling.userInputAantalBesteld = TempField.scanner.nextInt();
                newVoorraadBerekenen();
            }
        } else {
            System.out.println("Product niet op voorraad.");
        }
    }
}
